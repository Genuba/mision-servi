package com.example.misionservi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class FileProtocoloSeguridad : AppCompatActivity() {

    lateinit var mPDFView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_protocolo_seguridad)

        mPDFView = findViewById<PDFView>(R.id.pdfView)
        mPDFView.fromAsset("protocoloSeguridad.pdf").load()
    }
}
