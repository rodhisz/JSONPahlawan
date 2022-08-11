package com.rsz.pahlawan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PahlawanAdapter (val context : Context, val dataPahlawan : ArrayList<PahlawanItem>) : RecyclerView.Adapter<PahlawanAdapter.MyViewHoler>() {
    class MyViewHoler(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.item_nama)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pahlawan_item, parent, false)
        return MyViewHoler(view)
    }

    override fun onBindViewHolder(holder: MyViewHoler, position: Int) {
        val data = dataPahlawan[position]
        holder.nama.text = dataPahlawan[position].nama

        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra(DetailActivity.DATA, data)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return dataPahlawan.size
    }
}