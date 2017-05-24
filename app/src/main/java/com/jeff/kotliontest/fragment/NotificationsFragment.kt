package com.jeff.kotliontest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * NotificationsFragment
 * Created by chen_yong on 2017/5/24.
 */
class NotificationsFragment : android.support.v4.app.Fragment(){

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        return inflater!!.inflate(com.jeff.kotliontest.R.layout.fragment_notfication,container,false)
    }

    override fun onViewCreated(view: android.view.View?, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}