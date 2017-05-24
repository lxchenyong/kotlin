package com.jeff.kotliontest.adapter.java

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.jeff.kotliontest.R
import com.jeff.kotliontest.bean.Person


/**
 * HomeAdapter
 * Created by chen_yong on 2017/5/24.
 */

 class HomeKtAdapter(mContext: Context, private val persons: List<Person>) : RecyclerView.Adapter<HomeKtAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.home_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = persons[position]
        holder.tv_name.text = person.name
        holder.tv_age.text = person.age.toString()

    }

    override fun getItemCount(): Int {
        return persons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_name: TextView = itemView.findViewById(R.id.name) as TextView
        var tv_age: TextView = itemView.findViewById(R.id.age) as TextView

    }
}
