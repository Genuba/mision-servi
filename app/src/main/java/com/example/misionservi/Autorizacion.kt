package com.example.misionservi

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.misionservi.interfaces.JsonPlaceHolderApi
import com.example.misionservi.model.LoginPost
import com.example.misionservi.model.Token
import com.example.misionservi.utils.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Autorizacion : AppCompatActivity() {

    private var rbAutorizo: CheckBox? = null
    private var token: String = ""
    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi
    private lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autorizacion)

        this.rbAutorizo = findViewById<CheckBox>(R.id.rbAutorizo);

        session = Session(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://servicioapp.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val cm = this@Autorizacion.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if (!isConnected) {
            Toast.makeText(this, "Para poder continuar debe connectarse a internet", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            getTokenLogin();
        }
    }

    fun encuestaCheckbox(v: View?) {
        val s = if (rbAutorizo?.isChecked()!!) "Marcado" else "Debe Autorizar"

        if(s.equals("Marcado")){
            val intent = Intent(this, PersonaForm::class.java)
            intent.putExtra("token",session.gettoken())
            startActivity(intent)
        }else {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show()
        }

    }

    fun getTokenLogin() {
        var token: String = ""
        val parameters = LoginPost()
        parameters.email = "OMSClaro"
        parameters.password = "pxQHf50Lht4u9Lzus.Q8x"
        val call: Call<Token> = jsonPlaceHolderApi.postLogin(parameters)

        call?.enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                Log.v("retrofit", "call failed get token")
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                var postResponse = response.body()
                if (postResponse != null) {

                    session.settoken(response.body()?.token)
                }
            }
        })
    }
}
