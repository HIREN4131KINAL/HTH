package com.example.hirenamaliyar.attendenceemployee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_add_person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_add_person = (Button) findViewById(R.id.bt_add_person);
        bt_add_person.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_add_person) {
            Intent i = new Intent(MainActivity.this, Person_details.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        } else if (view.getId() == R.id.bt_show_data) {
            Toast.makeText(MainActivity.this, "Coming soon...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Coming soon...", Toast.LENGTH_SHORT).show();
        }


    }
}
