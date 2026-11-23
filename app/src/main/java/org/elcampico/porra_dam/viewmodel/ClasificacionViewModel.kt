package org.elcampico.porra_dam.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.elcampico.porra_dam.data.model.FilaClasificacion
import org.elcampico.porra_dam.data.model.Participante

class ClasificacionViewModel : ViewModel() {

    val participantes = mutableStateListOf<Participante>()

    private var cargado = false
    fun cargar(lista: List<Participante>) {
        if (cargado) return
        participantes.addAll(lista)
        cargado = true
    }

    // null = General, número = esa jornada
    var filtroJornada by mutableStateOf<Int?>(null)
        private set

    fun filtrar(jornada: Int?) { filtroJornada = jornada }

    private fun puntosDe(mapa: Map<Int, Int>): Int =
        filtroJornada?.let { mapa[it] ?: 0 } ?: mapa.values.sum()

    // Mezcla los participantes del JSON con tus puntos calculados
    fun tabla(alias: String, misPuntos: Map<Int, Int>): List<FilaClasificacion> {
        val otros = participantes.map {
            FilaClasificacion(it.id, it.nombre, puntosDe(it.puntosPorJornada), esYo = false)
        }
        val yo = FilaClasificacion("yo", alias.ifBlank { "Tú" }, puntosDe(misPuntos), esYo = true)
        return (otros + yo).sortedByDescending { it.puntos }
    }
}