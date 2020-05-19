package com.example.misionservi

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.misionservi.interfaces.JsonPlaceHolderApi
import com.example.misionservi.model.Persona
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class PersonaForm : AppCompatActivity() {

    private var txtCedula: EditText? = null
    private var txtNombre: EditText? = null
    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona_form)

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

        this.txtCedula = findViewById(R.id.cedula)
        this.txtNombre = findViewById(R.id.nombre)

        this.txtCedula?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                getPersona(s.toString())
            }
        })
    }

    fun encuestaContinue(v: View?) {
        val intent = Intent(this, EncuestaPagUno::class.java)
        startActivity(intent)
    }

    fun getPersona(cedula: String) {
        val call: Call<Persona> = jsonPlaceHolderApi.getPersona(cedula)
        call?.enqueue(object : Callback<Persona> {
            override fun onFailure(call: Call<Persona>?, t: Throwable?) {
                Log.v("retrofit", "call failed persona")
            }

            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                var postResponse = response.body()
                if (postResponse != null) {
                    txtNombre?.setText(postResponse.nombre, TextView.BufferType.EDITABLE)
                };
            }

        })
    }
}
