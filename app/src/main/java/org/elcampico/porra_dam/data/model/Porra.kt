package org.elcampico.porra_dam.data.model

import kotlin.math.sign

data class JornadaInfo(
    val numero: Int,
    val cierre: String
)

data class Partido(
    val id: String = "",
    val jornada: Int = 1,
    val local: String = "",
    val visitante: String = "",
    val escudoLocal: String = "",
    val escudoVisitante: String = "",
    val golesLocal: Int? = null,
    val golesVisitante: Int? = null
) {
    val jugado: Boolean get() = golesLocal != null && golesVisitante != null
}

data class Pronostico(
    val partidoId: String = "",
    val golesLocal: Int = 0,
    val golesVisitante: Int = 0
)

data class Participante(
    val id: String = "",
    val nombre: String = "",
    val puntosPorJornada: Map<Int, Int> = emptyMap()
)

enum class TipoAcierto(val etiqueta: String, val puntos: Int) {
    EXACTO("Exactos", 8),
    SIGNO("Signo", 4),
    FALLO("Fallos", 0)
}

enum class FiltroPronostico(val etiqueta: String) {
    TODOS("Todos"),
    PENDIENTES("Pendientes"),
    RELLENADOS("Rellenados")
}

// Modelos "calculados" para pintar las listas
data class FilaResultado(
    val partido: Partido,
    val pronostico: Pronostico,
    val acierto: TipoAcierto
)

data class FilaClasificacion(
    val id: String,
    val nombre: String,
    val puntos: Int,
    val esYo: Boolean
)

fun calcularAcierto(partido: Partido, pronostico: Pronostico): TipoAcierto {
    val realL = partido.golesLocal ?: 0
    val realV = partido.golesVisitante ?: 0
    return when {
        realL == pronostico.golesLocal && realV == pronostico.golesVisitante -> TipoAcierto.EXACTO
        (realL - realV).sign == (pronostico.golesLocal - pronostico.golesVisitante).sign -> TipoAcierto.SIGNO
        else -> TipoAcierto.FALLO
    }
}