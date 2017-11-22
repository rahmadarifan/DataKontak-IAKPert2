package com.example.android.datakontak;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ifan on 11/18/2017.
 */

public class HomeAdapter extends BaseAdapter {


    private ArrayList<People> listPeople = new ArrayList<>();
    private Context context;
    private TextView tvNama;

    public HomeAdapter(ArrayList<People> listPeople, Context context) {
        this.listPeople = listPeople;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPeople.size();
    }

    @Override
    public Object getItem(int position) {
        return listPeople.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemPeople = View.inflate(context, R.layout.item_people, null);

        tvNama = itemPeople.findViewById(R.id.tv_nama);

        tvNama.setText(listPeople.get(position).getName());

        return itemPeople;
    }
}
