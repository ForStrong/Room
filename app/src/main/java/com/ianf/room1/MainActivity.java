package com.ianf.room1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDataBase wordDataBase;
    WordDao wordDao;
    Button btnInsert, btnDelete, btnClear, btnUpdate;
    TextView textView;
    LiveData<List<Word>> wordsLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.buttonInsert);
        btnClear = findViewById(R.id.buttonClear);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        textView = findViewById(R.id.textView);
        final WordViewModel wordViewModel = new WordViewModel(getApplication());
        wordDataBase = WordDataBase.getWordDataBse(this);
        wordDao = wordDataBase.getWordDao();
        wordsLive = wordDao.getAllWords();
        wordViewModel.getWordList().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append(" = ").append(word.getChineseMessage()).append("\n");
                }
                textView.setText(text.toString());
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hello", "你好");
                Word word1 = new Word("World", "世界");
                wordViewModel.insertWords(word,word1);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordViewModel.deleteAllWords();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word();
                word.setId(70);
                wordViewModel.deleteWords(word);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "嗨");
                word.setId(69);
                wordViewModel.updateWords(word);
            }
        });
    }




}
