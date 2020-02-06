package com.introtoandroid.button_counter_sitar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private Button buttonInc;
    private Button buttonDec;
    private Button buttonRes;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.displayCount);
        buttonDec = findViewById(R.id.decrementButton);
        buttonInc = findViewById(R.id.incrementButton);
        buttonRes = findViewById(R.id.resetButton);

        buttonDec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counter--;
                String result = Integer.toString(counter);
                txt.setText(result);
            }
        });

        buttonInc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counter++;
                String result = Integer.toString(counter);
                txt.setText(result);
            }
        });

        buttonRes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counter = 0;
                String result = Integer.toString(counter);
                txt.setText(result);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String value = txt.getText().toString();
        outState.putString("key", value);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("key");
        txt.setText(value);
    }
}
