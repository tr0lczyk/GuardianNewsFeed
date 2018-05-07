package com.example.android.guardiannewsfeed;

public class News {

    private String newsTitle;

    private String newsAuthor;

    private String newsCategory;

    private String newsDate;

    private String newsLink;

    public News(String newsTitle, String newsAuthor, String newsCategory, String newsDate, String newsLink){
        this.newsTitle = newsTitle;
        this.newsAuthor = newsAuthor;
        this.newsCategory = newsCategory;
        this.newsDate = newsDate;
        this.newsLink = newsLink;
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

    public String getNewsLink() {
        return newsLink;
    }
}
