package com.av.avmessenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.content.Context;


import java.nio.charset.StandardCharsets;

public class chatbot extends AppCompatActivity {
    TextView t1;
    EditText ed;
    Button bt1;

    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chatbot);


        nav = findViewById(R.id.Bnav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                switch (item.getItemId()){

                    case R.id.home:
                        intent = new Intent(chatbot.this, grideview.class);
                        startActivity(intent);
                        return true;

                    case R.id.chat:
                        intent = new Intent(chatbot.this, MainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.qaa:
                        intent = getPackageManager().getLaunchIntentForPackage("com.teammh.sona");
                        if (intent != null) {
                            // We found the activity now start the activity
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            // Bring user to the market or let them choose an app?
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setData(Uri.parse("market://details?id=" + "com.teammh.sona"));
                            startActivity(intent);
                        }
                        return true;

                    case R.id.music:
                        intent = new Intent(chatbot.this, Music.class);
                        startActivity(intent);
                        return true;

                    case R.id.ainfo:
                        intent = new Intent(chatbot.this, information.class);
                        startActivity(intent);
                        return true;

                    default:


                }





                return true;
            }
        });


            bt1= (Button) findViewById(R.id.btn);
            ed= (EditText) findViewById(R.id.inp);

            t1=(TextView) findViewById(R.id.txt);


            if (!Python.isStarted()) {

                Python.start(new AndroidPlatform(this));
            }
            Python py = Python.getInstance();

            PyObject proj = py.getModule("script");

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    PyObject onj = proj.callAttr("main", ed.getText().toString());

                    t1.setText(onj.toString());

                }
            });



            // Initialize the button and text view

        }
    }
