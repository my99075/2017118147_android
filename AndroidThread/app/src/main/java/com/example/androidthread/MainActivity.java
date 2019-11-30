package com.example.androidthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPDATE_TEXT=1;
    private TextView text;
    private DemoThread thread1;
    int counter;
    private Handler handler = new Handler() {
    public void handleMessage(Message msg){
        switch(msg.what){
            case UPDATE_TEXT:
                counter=(Integer)msg.obj;
                text.setText("我是："+counter);
                break;
             default:
                 break;
        }
    }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        Button changeText=(Button)findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
        text.setText("我是："+counter);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.change_text:
                DemoThread thread1 = new DemoThread();
                Log.d("子线程号：", "" + thread1.getId());
                try {
                    thread1.start();
                } catch (Exception e) {
                }
        }
        }
class DemoThread extends Thread {
    @Override
    public void run() {
        while (true) {
            counter++;
            Message message = new Message();
            message.what = UPDATE_TEXT;
            message.obj = new Integer(counter);
            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
}
