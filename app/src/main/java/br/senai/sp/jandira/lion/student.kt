package br.senai.sp.jandira.lion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.lion.ui.theme.LionTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle


class student : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //.background(color = Color(0xFF000000)), // Preto
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color(android.graphics.Color.parseColor("#3347B0")))
            // .border(2.dp, Color.Black) // Adicionando borda de 2.dp com cor preta
        ) {
            // Conteúdo da Row
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        // Coloque a ação desejada aqui
                        // Por exemplo, abrir uma nova Activity
                        toGoBackActivityStudents(context)
                    }
            )
            Spacer(modifier = Modifier.width(280.dp))
            Icon(
                painter = painterResource(id = R.drawable.baseline_menu),
                contentDescription = "",
                tint = Color.White, // Definindo a cor do ícone como branco
                modifier = Modifier.padding(8.dp) // Adicione um espaçamento interno se necessário
            )
        }


        Card(
            modifier = Modifier

                .padding(top = 15.dp)
                .border(width = 1.dp, color = Color.Black)
                .shadow(elevation = 1.dp)
                .clip(RoundedCornerShape(20.dp))

        ) {
            Box(
                modifier = Modifier

                    .height(270.dp),

                contentAlignment = Alignment.Center

            ) {
                Column(
                    modifier = Modifier.padding(16.dp)

                ) {
                    Image(
                        painter = painterResource(R.drawable.person),
                        contentDescription = "Descrição da imagem",
                        modifier = Modifier
                            .size(150.dp)
                    )
                    Text(
                        text = "Jose Almeida Silva ",
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF3347B0)) // Preto
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFE5B657)) // Preto
                    .height(70.dp)
            ) {
                Text(
                    text = "SOP",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,

                    )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF3347B0)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFE5B657))
                                .height(270.dp)
                                .width(350.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Box(
                                modifier = Modifier.fillMaxHeight()
                                    .background(Color.White)
                                    .width(300.dp) )
                            {}
                        }
                    }
                    Text(
                        text = "90",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

            }





        }
    }
}


fun toGoBackActivityStudents(context: Context) {
    val intent = Intent(context, students::class.java)
    context.startActivity(intent)
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LionTheme {
        Greeting3("Android")
    }
}