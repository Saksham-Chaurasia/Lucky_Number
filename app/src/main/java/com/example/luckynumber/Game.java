package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class Game extends AppCompatActivity {
    EditText guessNumber;
    TextView guide, orign;
    Button check;
    TextView f1, f2;
    int g = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        guide = findViewById(R.id.guide);
        orign = findViewById(R.id.textView8);
        f1 = findViewById(R.id.textView9);
        f2 = findViewById(R.id.textView10);

        guessNumber = findViewById(R.id.editTextNumber2);
        check = findViewById(R.id.button3);

        Intent intent = getIntent();
        String num = intent.getStringExtra(Profile.Ext);
        g = Integer.parseInt(num);
        if(g>10){
            g = 10;
        }
        if(g<=0){
            g = 5;
        }
        Random random = new Random();
        int origin = random.nextInt(30);
        String s1 = "Total " + g+ " Attempts";
        f1.setText(s1);
        check.setOnClickListener(view -> crop(origin));


    }


    public boolean getNumber() {
        String s1 = guessNumber.getText().toString();
        int num = Integer.parseInt(s1);
        if (s1.length() == 0) {
            String s2 = "Please Enter the number";
            guide.setText(s2);
            return false;
        } else if (s1.length() > 3 && num > 100) {
            String s3 = "Please enter low value, Try again";
            guide.setText(s3);
            return false;
        } else if (num < 100 && num > 0)
            return true;
        else if (num < 0) {
            String s4 ="Please enter high value, Try again";
            guide.setText(s4);
            return false;
        }
        return true;
    }

    public void crop(int orig) {
        if (getNumber()) {


            String r = guessNumber.getText().toString();
            int guesn = Integer.parseInt(r);

            if (guesn > orig && guesn - orig >= 20) {
                String s5 = "Too High";
                guide.setText(s5);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn > orig && guesn - orig < 20 && guesn - orig > 3) {
                String s6 ="Close but High";
                guide.setText(s6);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn > orig && guesn - orig <= 3) {
                String s7 = "Very close but High";
                guide.setText(s7);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn < orig && orig - guesn >= 20) {
                String s8 = "Too Low";
                guide.setText(s8);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn < orig && orig - guesn < 20 && orig - guesn > 3) {
                String s9 = "Close but Low";
                guide.setText(s9);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn < orig && orig - guesn <= 3) {
                String s10 = "Very close but Low";
                guide.setText(s10);
                Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
            }
            else if (guesn == orig) {
                String s11 = "Congratulations! YOU WIN";
                String s12 = "Thank You";
                guide.setText(s11);
                orign.setText(s12);
                g =1;

            }

            if (g == 0 ) {
                String s13 = "GAME OVER";
                String s14 ="The Original Number is " + orig;
                String s15 =  "BACK"     ;
                guide.setText(s13);
                orign.setText(s14);
                check.setText(s15);
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
            }
            if (g >= 0) {
                String s16 = (--g) + "Attempts remaining";
                f2.setText(s16);
            }
            if(g<0){
                f2.setText("");
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
            }
            if(g==0) {
                String s17 = "BACK";
                check.setText(s17);

            }


        }
    }


}










