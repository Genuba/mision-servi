package app.aplicaction.misionservi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import app.aplicaction.misionservi.model.Encuesta
import app.aplicaction.misionservi.model.EncuestaBody
import app.aplicaction.misionservi.model.RespuestaPost
import app.aplicaction.misionservi.utils.ApiUtils
import app.aplicaction.misionservi.utils.LoadingDailog
import kotlinx.android.synthetic.main.activity_encuesta_pag_uno.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EncuestaPagUno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta_pag_uno)
        // poner el icono en el action Bar

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.mipmap.ic_launcher)
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
            var loadingDailog = LoadingDailog(this)
            loadingDailog.startLoadingDialog()

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

            val call: Call<RespuestaPost> = ApiUtils.getAPIService(intent.getStringExtra("token")).postEncuesta(parameters)

            call?.enqueue(object : Callback<RespuestaPost> {
                override fun onFailure(call: Call<RespuestaPost>, t: Throwable) {
                    Log.v("retrofit", "call failed encuesta")
                }

                override fun onResponse(call: Call<RespuestaPost>, response: Response<RespuestaPost>) {
                    loadingDailog.dismissDialog()
                    Toast.makeText(this@EncuestaPagUno, response.body()?.mensaje, LENGTH_LONG).show();
                    val intent = Intent(this@EncuestaPagUno, MainActivity::class.java)
                    startActivity(intent)
                }
            })
        }else{
            Toast.makeText(this, "Debe responder todas las preguntas", Toast.LENGTH_LONG).show()
        }
    }
}
