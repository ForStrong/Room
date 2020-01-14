package com.ianf.room1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDataBase wordDataBase;
    private WordDao wordDao;
    private LiveData<List<Word>> wordList;

    public WordRepository(@NonNull Application application) {
        wordDataBase = WordDataBase.getWordDataBse(application);
        wordDao = wordDataBase.getWordDao();
        wordList = wordDao.getAllWords();
    }

    public LiveData<List<Word>> getWordList() {
        return wordList;
    }

    public void insertWords(Word... words) {
        new InsertAsyncTask(wordDao).execute(words);
    }

    public void deleteWords(Word... words) {
        new DeleteAsyncTask(wordDao).execute(words);
    }

    public void deleteAllWords() {
        new DeleteAllAsyncTask(wordDao).execute();
    }

    public void updateWords(Word... words) {
        new UpdateAsyncTask(wordDao).execute(words);
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao wordDao;

        public DeleteAllAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }


}
