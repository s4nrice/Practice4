package ru.mirea.zyryanov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumberOfLessons;
    EditText editTextNumberOfDays;
    TextView textView3;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        mainThread.setName("MireaThread");
        infoTextView.append("\nНовое имя потока: " + mainThread.getName());

        editTextNumberOfLessons = findViewById(R.id.editTextNumberOfLessons);
        editTextNumberOfDays = findViewById(R.id.editTextNumberOfDays);
        textView3 = findViewById(R.id.textView3);
    }

    public void onClick(View view) {


        Runnable runnable = new Runnable() {
            public void run() {
                int numberThread = counter++;
                Log.i("ThreadProject", "Запущен поток № " + numberThread);
                synchronized (this) {
                    try {
                        int numberOfLessons = Integer.parseInt(editTextNumberOfLessons.getText().toString());
                        int numberOfDays = Integer.parseInt(editTextNumberOfDays.getText().toString());

                        double result = (double) numberOfLessons / (double) numberOfDays;
                        textView3.setText(String.valueOf(result));
                    } catch (Exception e) { }
                }
                Log.i("ThreadProject", "Выполнен поток № " + numberThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}