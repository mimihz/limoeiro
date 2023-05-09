package com.example.limoeiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limoeiro.ui.theme.LimoeiroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           LimoeiroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Limoeiro()
                }
            }
        }
    }
}

@Preview
@Composable
fun Limoeiro() {
  var espremer by remember { mutableStateOf(1) }

    var tela by remember { mutableStateOf( 1) }

    when(tela) {
        1 -> Comofazerlimonada(
            R.string.limoeiro,
            R.drawable.limoeiro,
        onImagemClick = {
            tela = 2
            espremer = (2..4).random()

            }
        )
        2 -> Comofazerlimonada(
            R.string.limao,
            R.drawable.limonada,
            onImagemClick = {
                if (espremer>1)
                       espremer--
                else
                tela = 3

            }
        )
        3 -> Comofazerlimonada(
            R.string.copo_de_limonada,
            R.drawable.copo_limonada,
            onImagemClick = {
                tela = 4

            }
        )
        4 -> Comofazerlimonada(
            R.string.copo_vazio,
            R.drawable.reiniciar,
            onImagemClick = {
                tela = 1

            }
        )

    }
}
@Composable
fun Comofazerlimonada(recursoTextoId: Int, recursoImageId: Int, onImagemClick:()->Unit){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(recursoTextoId),
            fontSize = 19.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Image(
            painter = painterResource(id = recursoImageId),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .border(
                    BorderStroke(2.dp, Color.Cyan),
                    RoundedCornerShape(15.dp)
                )
                .clickable(onClick = onImagemClick)

        )
    }

}




