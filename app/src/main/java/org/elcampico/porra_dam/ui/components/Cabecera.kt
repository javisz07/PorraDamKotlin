package org.elcampico.porra_dam.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.theme.Grotesk

@Composable
fun CabeceraPorra(puntos: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_menu),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )
        Text(
            "Porra DAM",
            fontSize = 30.sp,
            fontFamily = Grotesk,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier
                .height(28.dp)
                .widthIn(min = 60.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFc7ead6))
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
            ) {
                Text("$puntos ", fontWeight = FontWeight.Bold, color = Color.White)
                Text("pts", fontWeight = FontWeight.Bold, color = Color(0xFF3A9D08))
            }
        }
    }
}