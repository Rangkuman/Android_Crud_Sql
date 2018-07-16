package com.example.cokro.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton menu1, menu2, menu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menu1 = (FloatingActionButton)findViewById(R.id.subFloatingMenu1);
        menu2 = (FloatingActionButton)findViewById(R.id.subFloatingMenu2);
        menu3 = (FloatingActionButton)findViewById(R.id.subFloatingMenu3);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(HomeActivity.this, TampilSemuaPgw.class);
                startActivity(a);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent b = new Intent(HomeActivity.this, TampilAllKantor.class);
                startActivity(b);

            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent b = new Intent(HomeActivity.this, TampilAllBarang.class);
                startActivity(b);

            }
        });
    }
}
