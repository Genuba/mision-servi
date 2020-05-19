package com.example.misionservi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class FileCoronavirus : AppCompatActivity() {

    lateinit var mPDFView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_coronavirus)

        mPDFView = findViewById<PDFView>(R.id.pdfView)
        mPDFView.fromAsset("Coronavirus.pdf").load()
    }
}
