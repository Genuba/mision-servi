package com.example.misionservi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var rbAutorizo: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rbAutorizo = findViewById<CheckBox>(R.id.rbAutorizo);

    }

    fun encuestaCheckbox(v: View?) {
        val s = if (rbAutorizo?.isChecked()!!) "Marcado" else "Debe Autorizar"

        if(s.equals("Marcado")){
            val intent = Intent(this, PersonaForm::class.java)
            startActivity(intent)
        }else {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show()
        }

    }

}