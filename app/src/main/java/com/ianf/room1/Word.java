package com.ianf.room1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "english_word")
    private String word;

    @ColumnInfo(name = "chinese_word")
    private String chineseMessage;

    public Word() {
    }

    public Word(String word, String chineseMessage) {
        this.word = word;
        this.chineseMessage = chineseMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChineseMessage() {
        return chineseMessage;
    }

    public void setChineseMessage(String chineseMessage) {
        this.chineseMessage = chineseMessage;
    }
}
