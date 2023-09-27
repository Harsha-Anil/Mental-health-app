package com.av.avmessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class aboutusc extends AppCompatActivity {

    Button bbc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutusc_act);

        bbc = findViewById(R.id.bbt);

        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aboutusc.this, information.class);
                startActivity(intent);
            }
        });
    }
}
