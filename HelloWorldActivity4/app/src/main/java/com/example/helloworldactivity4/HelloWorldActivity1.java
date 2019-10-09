package com.example.helloworldactivity4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class HelloWorldActivity1 extends AppCompatActivity {
    public static final String TAG="HelloWorldActivity1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HelloWorld",this.toString());
        setContentView(R.layout.activity_hello_world1);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorldActivity1.this, HelloWorldActivity1.class);
                startActivity(intent);
            }
        });
        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorldActivity1.this, HelloWorldActivity2.class);
                startActivity(intent);
            }
        });
        Button button3=(Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorldActivity1.this, HelloWorldActivity3.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
