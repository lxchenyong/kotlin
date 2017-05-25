package com.jeff.kotliontest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeff.kotliontest.DividerDecoration
import com.jeff.kotliontest.adapter.java.HomeAdapter
import com.jeff.kotliontest.bean.Person
import com.jeff.kotliontest.R
import com.jeff.kotliontest.adapter.java.HomeKtAdapter

class HomeFragment : Fragment() {

    private var persons: List<Person>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        val recyclerView: RecyclerView = view!!.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity!!)
        recyclerView.addItemDecoration(DividerDecoration(activity))
        //java写的适配器
//        val adapter: HomeAdapter = HomeAdapter(activity, persons!!)
        //kotlin写的适配器
        val adapter: HomeKtAdapter = HomeKtAdapter(activity, persons!!)
        recyclerView.adapter = adapter
    }

    /**
     * mock数据
     */
    private fun getData(): List<Person> {
        persons = listOf(
                Person("android", 12),
                Person("html", 130),
                Person("kotlin", 5),
                Person("java", 12),
                Person(null, 12),
                Person("android", 12),
                Person("ios", 12),
                Person("c++", 12),
                Person("php", 12)
        )
        return persons as List<Person>
    }
}
