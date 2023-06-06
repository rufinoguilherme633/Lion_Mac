package br.senai.sp.jandira.lion

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.lion.ui.theme.LionTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion.model.CoursesList
import br.senai.sp.jandira.lion.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import br.senai.sp.jandira.lion.model.Courses
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

    var cursos by remember {
        mutableStateOf(listOf<Courses>())
    }

    // Inside your MainActivity or another suitable location
   // fun fetchCourses() {

    //}
    // Inside your MainActivity or another suitable location




    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
        // .background(color = Color(0xFF000000)) // Preto
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .background(

                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF333333),
                            Color(0xFF3347B0),
                            Color(0xFF3347B0)
                        )


                    )

                ) // Gradiente vertical com duas cores
                .padding(16.dp) // Adiciona um espaçamento interno
        )  {
            Box(
                modifier = Modifier
                    .size(120.dp) // Defina o tamanho desejado da imagem aqui
                    .align(Alignment.CenterHorizontally) // Centraliza horizontalmente
                    .background(color = Color.White) // Verde correspondente ao gradiente
                    .clip(RoundedCornerShape(16.dp)) // Adiciona cantos arredondados à imagem
                    .border(2.dp, Color.White, RoundedCornerShape(16.dp)) // Adiciona uma borda branca à imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize() // Preenche o tamanho da Box
                        .padding(16.dp) // Adiciona um espaçamento interno na imagem
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaçamento vertical
            Text(
                text = stringResource(R.string.Lion_school),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Centraliza horizontalmente
            )
        }
        Spacer(modifier = Modifier.height(30.dp)) // Adiciona um espaçamento vertical
        Text(
            text = stringResource(R.string.Course_choice),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally) // Centraliza horizontalmente
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .clickable {
                        openActivity(context)
                    }

            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3347B0))
                        .height(120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp)


                    ) {
                        Text(
                            text = "Desenvolvimento de sistemas ",

                            color = Color.White,
                            fontSize = 20.sp,

                            )
                        Image(
                            painter = painterResource(R.drawable.redes),
                            contentDescription = "Descrição da imagem",
                            modifier = Modifier
                                .size(64.dp)
                        )
                    }
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .clickable {
                        openActivity(context)
                    }

            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3347B0))
                        .height(120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)


                    ) {
                        Text(
                            text = "Redes",
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(16.dp)) // Adicione um espaçador horizontal para separar o texto da imagem
                        Image(
                            painter = painterResource(R.drawable.ds),
                            contentDescription = "Descrição da imagem",
                            modifier = Modifier
                                .size(64.dp)
                        )
                    }
                }
            }

          //  LazyColumn()

        }

        val call = RetrofitFactory().getCourseService().getCourses()

        call.enqueue(object : Callback<CoursesList> {
            override fun onResponse(call: Call<CoursesList>, response: Response<CoursesList>) {

                val cursos = response.body()!!.cursos


            }

            override fun onFailure(call: Call<CoursesList>, t: Throwable) {
                // Handle failure
            }
        })


        Log.i("ds2m", "${cursos}: ")
       LazyColumn {
      items(cursos) {

          Card(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(top = 8.dp)
                  .clip(RoundedCornerShape(90.dp))
                  .clickable {
                      openActivity(context)
                  }

          ) {
              Box(
                  modifier = Modifier
                      .background(Color(0xFF3347B0))
                      .height(120.dp),
                  contentAlignment = Alignment.Center
              ) {
                  Row(
                      modifier = Modifier
                          .padding(16.dp)


                  ) {
                      Text(
                          text = it.sigla,
                          color = Color.White,
                          fontSize = 20.sp
                      )
                      Spacer(modifier = Modifier.width(16.dp)) // Adicione um espaçador horizontal para separar o texto da imagem
                      AsyncImage(model = it.icone, contentDescription ="" )
                  }
              }
          }
      }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LionTheme {
        Greeting("Android")
    }
}
fun openActivity(context: Context) {
    val intent = Intent(context, students::class.java)
    context.startActivity(intent)
}
