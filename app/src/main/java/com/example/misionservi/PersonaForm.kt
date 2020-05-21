package com.example.misionservi

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.misionservi.model.Persona
import com.example.misionservi.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonaForm : AppCompatActivity() {

    private var txtCedula: EditText? = null
    private var txtNombre: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona_form)

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

        if (txtCedula?.getText().toString().isEmpty() || txtNombre?.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show()
        }else{
            var token = intent.getStringExtra("token")
            val intent = Intent(this, EncuestaPagUno::class.java)
            intent.putExtra("token",token)
            intent.putExtra("numeroDocumento", txtCedula?.getText().toString())
            intent.putExtra("nombre", txtNombre?.getText().toString())
            startActivity(intent)
        }

    }

    fun getPersona(cedula: String) {
        val call: Call<Persona> = ApiUtils.getAPIService(intent.getStringExtra("token")).getPersona(cedula)
        call?.enqueue(object : Callback<Persona> {
            override fun onFailure(call: Call<Persona>?, t: Throwable?) {
                Log.v("retrofit", "call failed persona")
            }

            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                var postResponse = response.body()
                if (postResponse?.mombre != null) {
                    txtNombre?.setText(postResponse.mombre, TextView.BufferType.EDITABLE)
                    txtNombre?.setEnabled(false)
                }else {
                    txtNombre?.setText("", TextView.BufferType.EDITABLE)
                    txtNombre?.setEnabled(true)
                }
            }

        })
    }
}
