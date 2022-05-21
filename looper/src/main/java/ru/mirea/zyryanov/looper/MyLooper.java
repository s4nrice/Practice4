package ru.mirea.zyryanov.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread{
    Handler handler;
    int milliseconds;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("MyLooper", "run");

        Looper.prepare();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                milliseconds = msg.getData().getInt("AGE") * 1000;

                try {
                    Thread.sleep(milliseconds);
                } catch (InterruptedException e) {
                }

                Log.d("MyLooper", "Возраст: "+ msg.getData().getInt("AGE"));
                Log.d("MyLooper", "Учусь в: "+ msg.getData().getString("STUDY"));
            }
        };
        Looper.loop();
    }
}
