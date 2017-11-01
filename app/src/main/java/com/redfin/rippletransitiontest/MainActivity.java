package com.redfin.rippletransitiontest;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TRANSITION_NAME = "TRANSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button primaryCta = (Button) findViewById(R.id.primary_cta);
        primaryCta.setTransitionName(TRANSITION_NAME);

        primaryCta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabSwitch = new Intent(MainActivity.this, SecondaryActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, primaryCta, TRANSITION_NAME);
                MainActivity.this.startActivity(tabSwitch, options.toBundle());
            }
        });
    }
}
