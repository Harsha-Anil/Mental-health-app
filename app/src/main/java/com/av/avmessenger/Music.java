package com.av.avmessenger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Music extends AppCompatActivity {
    ImageView M1,U1,P1,S1;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        M1 = findViewById(R.id.imageView1);
        U1 = findViewById(R.id.imageView2);
        P1 = findViewById(R.id.imageView4);
        S1 = findViewById(R.id.imageView3);

        nav = findViewById(R.id.nav);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                switch (item.getItemId()){

                    case R.id.home:
                        intent = new Intent(Music.this, grideview.class);
                        startActivity(intent);
                        return true;

                    case R.id.chat:
                        intent = new Intent(Music.this, MainActivity.class);
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
                        intent = new Intent(Music.this, Music.class);
                        startActivity(intent);
                        return true;

                    case R.id.ainfo:
                        intent = new Intent(Music.this, information.class);
                        startActivity(intent);
                        return true;

                    default:


                }
                return true;
            }
        });

        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/3eQke2KWWrhOGeCDB0vE7h?si=b_Z3qrcoTRyYgAtpOoHllQ");
            }
        });

        U1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/1axFFl31Kd6ZG4C27OtPlU?si=sXboDWPDRZuJsTWYrn3SwQ&utm_source=copy-link");
            }
        });

        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DWWY64wDtewQt?si=D7lyh0qARiSwrJCwWeP98w&utm_source=copy-link");
            }
        });

        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/3XDx4ZH82386rU1QKqWV2Q?si=bq2BN85KQTmvI3TyYLFe5A&utm_source=copy-link");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}
