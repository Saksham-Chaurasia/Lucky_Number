package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    public static final String Extra = "com.example";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void star(View view){
        name = findViewById(R.id.name);
        String owner = name.getText().toString();
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra(Extra, owner);
        startActivity(intent);
    }

}