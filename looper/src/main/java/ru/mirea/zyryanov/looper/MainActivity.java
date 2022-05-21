package ru.mirea.zyryanov.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyLooper myLooper;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);

        myLooper = new MyLooper();
        myLooper.start();
    }

    public void onClick(View view) {
        Message message = new Message();
        Bundle bundle = new Bundle();

        String studyingPlace = editText.getText().toString();
        int age = 19;

        bundle.putString("STUDY", studyingPlace);
        bundle.putInt("AGE", age);

        message.setData(bundle);

        if (myLooper != null) {
            myLooper.handler.sendMessage(message);
        }
    }
}