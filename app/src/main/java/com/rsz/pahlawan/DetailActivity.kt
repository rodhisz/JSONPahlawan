package com.rsz.pahlawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<PahlawanItem>(DATA)

        findViewById<TextView>(R.id.nama).text = data?.nama
    }
}