package app.aplicaction.misionservi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import app.aplicaction.misionservi.interfaces.JsonPlaceHolderApi
import app.aplicaction.misionservi.utils.Session


class MainActivity : AppCompatActivity() {

    private var rbAutorizo: CheckBox? = null
    private var token: String = ""
    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi
    private lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // poner el icono en el action Bar

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.mipmap.ic_launcher)
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
