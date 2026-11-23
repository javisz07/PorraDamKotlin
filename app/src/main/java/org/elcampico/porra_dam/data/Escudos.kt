package org.elcampico.porra_dam.data

import org.elcampico.porra_dam.R

// En el JSON solo guardamos el nombre ("real_madrid"); aquí se traduce al drawable.
object Escudos {
    private val mapa = mapOf(
        "real_madrid" to R.drawable.real_madrid,
        "atletico_madrid" to R.drawable.atletico_madrid
    )

    fun id(nombre: String): Int = mapa[nombre] ?: R.drawable.real_madrid
}