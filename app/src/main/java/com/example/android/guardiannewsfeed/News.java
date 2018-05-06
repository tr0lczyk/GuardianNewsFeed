package com.example.android.guardiannewsfeed;

public class News {

    private String newsTitle;

    private String newsAuthor;

    private String newsCategory;

    private String newsDate;

    public News(String newsTitle, String newsAuthor, String newsCategory, String newsDate){
        this.newsTitle = newsTitle;
        this.newsAuthor = newsAuthor;
        this.newsCategory = newsCategory;
        this.newsDate = newsDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public String getNewsDate() {
        return newsDate;
    }
}
