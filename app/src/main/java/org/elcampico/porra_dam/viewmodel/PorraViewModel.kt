package org.elcampico.porra_dam.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.elcampico.porra_dam.data.model.FilaResultado
import org.elcampico.porra_dam.data.model.FiltroPronostico
import org.elcampico.porra_dam.data.model.JornadaInfo
import org.elcampico.porra_dam.data.model.Partido
import org.elcampico.porra_dam.data.model.Pronostico
import org.elcampico.porra_dam.data.model.TipoAcierto
import org.elcampico.porra_dam.data.model.calcularAcierto

class PorraViewModel : ViewModel() {

    val jornadas = mutableStateListOf<JornadaInfo>()
    val partidos = mutableStateListOf<Partido>()
    val pronosticos = mutableStateMapOf<String, Pronostico>() // clave = id del partido

    private var cargado = false
    fun cargar(listaJornadas: List<JornadaInfo>, listaPartidos: List<Partido>, listaPronosticos: List<Pronostico>) {
        if (cargado) return
        jornadas.addAll(listaJornadas)
        partidos.addAll(listaPartidos)
        listaPronosticos.forEach { pronosticos[it.partidoId] = it }
        cargado = true
    }

    // ---------- PANTALLA JORNADA (rellenar / editar / borrar pronósticos) ----------

    val jornadaActual: Int
        get() = jornadas.firstOrNull { j -> partidos.any { it.jornada == j.numero && !it.jugado } }?.numero
            ?: jornadas.lastOrNull()?.numero
            ?: 1

    val cierreActual: String
        get() = jornadas.firstOrNull { it.numero == jornadaActual }?.cierre ?: ""

    val partidosJornada: List<Partido>
        get() = partidos.filter { it.jornada == jornadaActual }

    var filtro by mutableStateOf(FiltroPronostico.TODOS)
        private set

    val visibles: List<Partido>
        get() = when (filtro) {
            FiltroPronostico.TODOS -> partidosJornada
            FiltroPronostico.PENDIENTES -> partidosJornada.filter { it.id !in pronosticos }
            FiltroPronostico.RELLENADOS -> partidosJornada.filter { it.id in pronosticos }
        }

    // Igual que sePuedeEnviar: solo se guarda si todos los partidos tienen pronóstico
    val sePuedeGuardar: Boolean
        get() = partidosJornada.isNotEmpty() && partidosJornada.all { it.id in pronosticos }

    var guardado by mutableStateOf(false)
        private set

    fun filtrar(nuevo: FiltroPronostico) { filtro = nuevo }

    fun cambiar(nuevo: Pronostico) {          // EDITAR
        pronosticos[nuevo.partidoId] = nuevo
        guardado = false
    }

    fun borrar(partidoId: String) {           // BORRAR uno
        pronosticos.remove(partidoId)
        guardado = false
    }

    fun limpiar() {                           // BORRAR todos los de la jornada
        partidosJornada.forEach { pronosticos.remove(it.id) }
        guardado = false
    }

    fun guardar() { guardado = true }

    // ---------- PANTALLA RESULTADOS ----------

    val jornadasJugadas: List<Int>
        get() = jornadas.map { it.numero }.filter { n -> partidos.any { it.jornada == n && it.jugado } }

    private var jornadaElegida by mutableStateOf<Int?>(null)
    val jornadaResultados: Int?
        get() = jornadaElegida ?: jornadasJugadas.lastOrNull()

    fun elegirJornada(numero: Int) { jornadaElegida = numero }

    var filtroAcierto by mutableStateOf<TipoAcierto?>(null)
        private set

    fun filtrarAcierto(tipo: TipoAcierto?) { filtroAcierto = tipo }

    val filasResultados: List<FilaResultado>
        get() {
            val n = jornadaResultados ?: return emptyList()
            return partidos
                .filter { it.jornada == n && it.jugado }
                .mapNotNull { p ->
                    pronosticos[p.id]?.let { pr -> FilaResultado(p, pr, calcularAcierto(p, pr)) }
                }
                .filter { filtroAcierto == null || it.acierto == filtroAcierto }
        }

    // ---------- PUNTOS ----------

    val puntosPorJornada: Map<Int, Int>
        get() = partidos
            .filter { it.jugado }
            .groupBy { it.jornada }
            .mapValues { (_, lista) ->
                lista.sumOf { p -> pronosticos[p.id]?.let { calcularAcierto(p, it).puntos } ?: 0 }
            }

    val puntosTotales: Int
        get() = puntosPorJornada.values.sum()
}