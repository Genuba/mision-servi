package com.example.misionservi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.misionservi.interfaces.JsonPlaceHolderApi
import com.example.misionservi.utils.Session


class MainActivity : AppCompatActivity() {

    private var rbAutorizo: CheckBox? = null
    private var token: String = ""
    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi
    private lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun autorizacionCheckbox(view: View) {
        val intent = Intent(this, Autorizacion::class.java)
        startActivity(intent)
    }

    fun archivosInstructivos(view: View) {
        val intent = Intent(this, DescargarAchivos::class.java)
        startActivity(intent)
    }

}
