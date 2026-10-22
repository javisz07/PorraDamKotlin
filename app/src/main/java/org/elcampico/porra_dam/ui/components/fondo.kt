package org.elcampico.porra_dam.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import org.elcampico.porra_dam.R


@Composable
fun FondoPantalla(modifier: Modifier,
                  content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = null, // decorativa
            contentScale = ContentScale.Crop, // llena y recorta
            alignment = Alignment.BottomCenter,
            modifier = Modifier.matchParentSize() // tamaño del Box
        )
        val scrim = Brush.verticalGradient(
            listOf(Color.Transparent, Color.Black.copy(alpha = 1f))
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(scrim)
        )

        content()
    }

}