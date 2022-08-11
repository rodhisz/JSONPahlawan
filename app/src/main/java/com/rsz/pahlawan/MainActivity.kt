package com.rsz.pahlawan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ParsingJSON()
        Log.i("JSON", "onCreate: $data")

//        val json = getJSONfromAsset()
//        Log.i("JSON", "parsingJSON: $json")

        findViewById<RecyclerView>(R.id.rv_pahlawan).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = PahlawanAdapter(context,ParsingJSON())
        }
    }

    private fun ParsingJSON(): ArrayList<PahlawanItem> {
        val json = getJSONfromAsset()
        Log.i("JSON", "parsingJSON: $json")

        //ambil dari json root
        val getRootJSON = JSONObject(json)

        //get array yang ada didalam json
        val getArrayPahlawanFromJson = getRootJSON.getJSONArray("daftar_pahlawan")

        //wadah penampung untuk hasil data parsing
        val arrayPahlawan = ArrayList<PahlawanItem>()

        //ngambil data dari tiap array
        for(i in 0 until getArrayPahlawanFromJson.length()) {

            val getItemPahlawan = getArrayPahlawanFromJson.getJSONObject(i)

            //penampung untumk setiap item
            val pahlawan = PahlawanItem(
                nama = getItemPahlawan.getString("nama"),
                nama2 = getItemPahlawan.getString("nama2"),
                kategori = getItemPahlawan.getString("kategori"),
                asal = getItemPahlawan.getString("asal"),
                lahir = getItemPahlawan.getString("lahir"),
            )
            pahlawan.usia = getItemPahlawan.getString("usia")
            pahlawan.gugur = getItemPahlawan.getString("gugur")
            pahlawan.lokasimakam = getItemPahlawan.getString("lokasimakam")
            pahlawan.history = getItemPahlawan.getString("history")
            pahlawan.img = getItemPahlawan.getString("img")

            //klo inisialiasasinya diluar
            arrayPahlawan.add(pahlawan)
        }
        return arrayPahlawan
    }

    private fun getJSONfromAsset() : String {
        val json : String //penampung json

        val stream = assets.open("pahlawan_nasional.json") //ambil json dari asset manager

        val size = stream.available() //ngecek apakah ada inputan
        val buffer = ByteArray(size) //menyimpan data di byte array

        stream.read(buffer) //membaca inputan
        stream.close() //biar dia berhenti

        json = String(buffer, Charsets.UTF_8) //pengisian val json
        return json
    }

}