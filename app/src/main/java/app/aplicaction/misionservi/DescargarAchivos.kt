package app.aplicaction.misionservi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DescargarAchivos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descargar_achivos)
        // poner el icono en el action Bar

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.mipmap.ic_launcher)
    }

    fun clickBtnProtocoloSeguridad(view: View) {
        val intent = Intent(this, FileProtocoloSeguridad::class.java)
        startActivity(intent)
    }

    fun clickBtnCoronavirus(view: View) {
        val intent = Intent(this, FileCoronavirus::class.java)
        startActivity(intent)
    }
    fun clickBtnManualInduccion(view: View) {
        val intent = Intent(this, manualInduccioActivity::class.java)
        startActivity(intent)
    }
}
