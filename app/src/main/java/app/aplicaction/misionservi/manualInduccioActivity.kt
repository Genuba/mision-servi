package app.aplicaction.misionservi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class manualInduccioActivity : AppCompatActivity() {

    lateinit var mPDFView: PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_induccio)
        // poner el icono en el action Bar

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.mipmap.ic_launcher)

        mPDFView = findViewById<PDFView>(R.id.pdfView)
        mPDFView.fromAsset("ManualInduccion.pdf").load()
    }
}
