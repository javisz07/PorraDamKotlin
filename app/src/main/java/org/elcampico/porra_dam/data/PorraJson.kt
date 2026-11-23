package org.elcampico.porra_dam.data

import android.content.Context
import org.elcampico.porra_dam.data.model.JornadaInfo
import org.elcampico.porra_dam.data.model.Participante
import org.elcampico.porra_dam.data.model.Partido
import org.elcampico.porra_dam.data.model.Pronostico
import org.json.JSONArray
import org.json.JSONObject

private fun Context.leerAsset(nombre: String): String =
    assets.open(nombre).bufferedReader().use { it.readText() }

private fun JSONObject.intOrNull(clave: String): Int? =
    if (has(clave) && !isNull(clave)) getInt(clave) else null

fun leerJornadas(contexto: Context): List<JornadaInfo> {
    val array = JSONArray(contexto.leerAsset("jornadas.json"))
    return List(array.length()) { i ->
        val o = array.getJSONObject(i)
        JornadaInfo(numero = o.getInt("numero"), cierre = o.getString("cierre"))
    }
}

fun leerPartidos(contexto: Context): List<Partido> {
    val array = JSONArray(contexto.leerAsset("partidos.json"))
    return List(array.length()) { i ->
        val o = array.getJSONObject(i)
        Partido(
            id = o.getString("id"),
            jornada = o.getInt("jornada"),
            local = o.getString("local"),
            visitante = o.getString("visitante"),
            escudoLocal = o.getString("escudoLocal"),
            escudoVisitante = o.getString("escudoVisitante"),
            golesLocal = o.intOrNull("golesLocal"),
            golesVisitante = o.intOrNull("golesVisitante")
        )
    }
}

fun leerPronosticos(contexto: Context): List<Pronostico> {
    val array = JSONArray(contexto.leerAsset("pronosticos.json"))
    return List(array.length()) { i ->
        val o = array.getJSONObject(i)
        Pronostico(
            partidoId = o.getString("partidoId"),
            golesLocal = o.getInt("golesLocal"),
            golesVisitante = o.getInt("golesVisitante")
        )
    }
}

fun leerParticipantes(contexto: Context): List<Participante> {
    val array = JSONArray(contexto.leerAsset("participantes.json"))
    return List(array.length()) { i ->
        val o = array.getJSONObject(i)
        val puntosJson = o.getJSONObject("puntos")
        val puntos = mutableMapOf<Int, Int>()
        puntosJson.keys().forEach { clave -> puntos[clave.toInt()] = puntosJson.getInt(clave) }
        Participante(
            id = o.getString("id"),
            nombre = o.getString("nombre"),
            puntosPorJornada = puntos
        )
    }
}