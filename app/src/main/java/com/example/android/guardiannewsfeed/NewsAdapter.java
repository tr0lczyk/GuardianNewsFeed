package com.example.android.guardiannewsfeed;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> newses){
        super(context,0,newses);
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        News currentNews = getItem(position);

        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentNews.getNewsTitle());

        TextView author = listItemView.findViewById(R.id.author);
        author.setText(currentNews.getNewsAuthor());

        TextView category = listItemView.findViewById(R.id.category);
        category.setText(currentNews.getNewsAuthor());

        TextView date = listItemView.findViewById(R.id.date);
        date.setText(currentNews.getNewsAuthor());

        return listItemView;
    }
}
