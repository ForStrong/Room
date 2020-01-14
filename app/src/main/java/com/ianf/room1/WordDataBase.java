package com.ianf.room1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Word.class, version = 1, exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {

    private static WordDataBase INSTANCE;

    public synchronized static WordDataBase getWordDataBse(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, WordDataBase.class, "word_database")
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract WordDao getWordDao();
}
