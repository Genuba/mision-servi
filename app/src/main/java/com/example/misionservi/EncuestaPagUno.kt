package com.example.misionservi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.misionservi.interfaces.JsonPlaceHolderApi
import com.example.misionservi.model.Encuesta
import com.example.misionservi.model.EncuestaBody
import com.example.misionservi.model.RespuestaPost
import com.example.misionservi.model.Token
import kotlinx.android.synthetic.main.activity_encuesta_pag_uno.*
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EncuestaPagUno : AppCompatActivity() {

    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta_pag_uno)

        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + intent.getStringExtra("token"))
                .build()
            chain.proceed(newRequest)
        }.build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://servicioapp.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
    }

    fun encuestaContinue(view: View){
        var pUno: Int = rbPreguntaUno.checkedRadioButtonId
        var pDos: Int = rbPreguntaDos.checkedRadioButtonId
        var pTres: Int = rbPreguntaTres.checkedRadioButtonId
        var pCuatro: Int = rbPreguntaCuatro.checkedRadioButtonId
        var pCinco: Int = rbPreguntaCinco.checkedRadioButtonId
        var pSeis: Int = rbPreguntaSeis.checkedRadioButtonId
        var pSiete: Int = rbPreguntaSiete.checkedRadioButtonId
        var pOcho: Int = rbPreguntaOcho.checkedRadioButtonId
        var pNueve: Int = rbPreguntaNueve.checkedRadioButtonId
        var pDiez: Int = rbPreguntaDiez.checkedRadioButtonId

        if(pUno != -1 && pDos != -1 && pTres != -1 && pCuatro != -1 && pCinco != -1 && pSeis != -1 && pSiete != -1 && pOcho != -1 && pNueve != -1 && pDiez != -1){
            val parameters = Encuesta()
            var encuesta= mutableListOf<EncuestaBody>()
            parameters.numeroDocumento = intent.getStringExtra("numeroDocumento")
            parameters.nombre = intent.getStringExtra("nombre")

            var encuestaBody = EncuestaBody()
            var radio: RadioButton = findViewById(pUno)
            encuestaBody.idPregunta = 4
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pDos)
            encuestaBody.idPregunta = 5
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pTres)
            encuestaBody.idPregunta = 6
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pCuatro)
            encuestaBody.idPregunta = 7
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pCinco)
            encuestaBody.idPregunta = 8
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pSeis)
            encuestaBody.idPregunta = 9
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pSiete)
            encuestaBody.idPregunta = 10
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pOcho)
            encuestaBody.idPregunta = 11
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pNueve)
            encuestaBody.idPregunta = 12
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            encuestaBody = EncuestaBody()
            radio = findViewById(pDiez)
            encuestaBody.idPregunta = 13
            encuestaBody.pregunta = ""
            encuestaBody.isIdEStado = if (radio.text == "Si") true else false
            encuesta.add(encuestaBody)

            parameters.encuesta = encuesta

            val call: Call<RespuestaPost> = jsonPlaceHolderApi.postEncuesta(parameters)

            call?.enqueue(object : Callback<RespuestaPost> {
                override fun onFailure(call: Call<RespuestaPost>, t: Throwable) {
                    Log.v("retrofit", "call failed encuesta")
                }

                override fun onResponse(call: Call<RespuestaPost>, response: Response<RespuestaPost>) {
                    Log.v("retrofit", "call failed encuesta")
                }
            })
            Toast.makeText(this, "Encuesta Enviada", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Debe responder todas las preguntas", Toast.LENGTH_LONG).show()
        }
    }
}
