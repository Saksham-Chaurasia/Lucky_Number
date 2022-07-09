package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView own;
    TextView instrucitons;
    EditText guessAttempt;
    public static final String Ext = "com.es";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        own = findViewById(R.id.textView3);
        instrucitons = findViewById(R.id.textView4);

        String in = "Guess the number Ranging from 0 to 100";
        instrucitons.setText(in);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.Extra);
        own.setText(orig(name));
    }

    public String orig(String name){
        if(name.equals("priyaaa")||name.equals("priyanka")||name.equals("Priyanka")||name.equals("PriyankaChaurasia")||name.equals("Priyanka Chaurasia")||name.equals("priyanka chaurasia")||name.equals("priyankachaurasia")||name.equals("Priyaaa")){
            return "Pagaliya";
        }
        else
            return name;
    }

   public void btn(View view){
        guessAttempt = findViewById(R.id.editTextNumber);
        String guess = guessAttempt.getText().toString();
        Intent intent = new Intent(this, Game.class);
        intent.putExtra(Ext,guess);
        startActivity(intent);
   }



}