package ru.mirea.zyryanov.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.concurrent.ThreadLocalRandom;

public class MyLoader extends AsyncTaskLoader<String> {
    private String word;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            word = args.getString(ARG_WORD);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    StringBuffer randomWord;
    StringBuffer wordBuffer;

    int wordLenght;
    int index;

    @Nullable
    @Override
    public String loadInBackground() {
        wordBuffer = new StringBuffer(word);
        randomWord = new StringBuffer();
        wordLenght = wordBuffer.length();

        for (int i = 0; i < wordLenght; i++) {
            index = ThreadLocalRandom.current().nextInt(wordBuffer.length());
            randomWord.append((wordBuffer.charAt(index))) ;
            wordBuffer.deleteCharAt(index);
        }

        return String.valueOf(randomWord);
    }
}
