package com.jeff.kotliontest.adapter.java;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jeff.kotliontest.R;
import com.jeff.kotliontest.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeAdapter
 * Created by chen_yong on 2017/5/24.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Person> persons;
    private LayoutInflater inflater;

    public HomeAdapter(Context mContext,List<Person> persons) {
        this.persons = persons;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.tv_name.setText(person.getName());
        holder.tv_age.setText(String.valueOf(person.getAge()));

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_age;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.name);
            tv_age = (TextView) itemView.findViewById(R.id.age);
        }
    }
}
