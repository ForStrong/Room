package com.ianf.room1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private  List<Word> allWords = new ArrayList<>();


    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.word_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Word word = allWords.get(position);
        holder.numberTv.setText(String.valueOf(word.getId()));
        holder.chineseTv.setText(word.getChineseMessage());
        holder.englishTv.setText(word.getWord());
    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView chineseTv,englishTv,numberTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTv = itemView.findViewById(R.id.number_Tv);
            chineseTv = itemView.findViewById(R.id.chineseTv);
            englishTv = itemView.findViewById(R.id.englishTv);
        }
    }
}
