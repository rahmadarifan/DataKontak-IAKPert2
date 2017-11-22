package com.example.android.datakontak;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private String namaUser;
    private ListView lvKontak;
    private ArrayList<People> people = new ArrayList<>();
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dummyData();
        initView();
        setView();
        setAdapter();
    }

    private void setAdapter() {
        homeAdapter = new HomeAdapter(people, HomeActivity.this);
        lvKontak.setAdapter(homeAdapter);

        lvKontak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + people.get(position).getPhoneNumber()));
                startActivity(callIntent);
            }
        });


        lvKontak.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(HomeActivity.this)
                        .setMessage("Apakah anda yakin kontak " + people.get(position).getName() + " ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                people.remove(position);
                                homeAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return false;
            }
        });

    }

    private void dummyData() {

        people.add(new People("Si A", "012345"));

        People siB = new People();
        siB.setName("Si B");
        siB.setPhoneNumber("123456");

        people.add(siB);

        people.add(new People("Si C", "012345"));
        people.add(new People("Si D", "012346"));
        people.add(new People("Si E", "012347"));
        people.add(new People("Si F", "012348"));
        people.add(new People("Si G", "012349"));
        people.add(new People("Si H", "012340"));
    }

    private void setView() {
        namaUser = getIntent().getExtras().getString("username");
        tvWelcome.setText("Selamat Datang " + namaUser);
    }

    private void initView() {
        tvWelcome = (TextView) findViewById(R.id.tv_welcome);
        lvKontak = (ListView) findViewById(R.id.lv_kontak);
    }
}
