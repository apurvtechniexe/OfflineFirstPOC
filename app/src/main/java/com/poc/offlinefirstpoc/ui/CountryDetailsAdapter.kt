package com.poc.offlinefirstpoc.ui

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.poc.offlinefirstpoc.R
import com.poc.offlinefirstpoc.data.CountryDetails

class CountryDetailsAdapter(
    val context: Context, val countryDetailRows: ArrayList<CountryDetails>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is CountryDetailsListHolder) {
            val row = countryDetailRows[position]
            val uri = Uri.parse(row.imageHref ?: "")

            holder.hrfImage.setImageURI(uri, holder.hrfImage.context)
            holder.titleTV.text = row.title
            holder.descTV.text = row.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country_adapter, parent, false)
        return CountryDetailsListHolder(view)


    }

    override fun getItemCount(): Int {
        return countryDetailRows.size
    }


    internal inner class CountryDetailsListHolder(view: View) : RecyclerView.ViewHolder(view) {
        var hrfImage: SimpleDraweeView
        var titleTV: TextView
        var descTV: TextView


        init {
            hrfImage = view.findViewById(R.id.hrfImage)
            titleTV = view.findViewById(R.id.titleTV)
            descTV = view.findViewById(R.id.descTV)
        }
    }
}