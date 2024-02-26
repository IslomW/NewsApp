package com.example.newsapp.model;

import com.google.gson.annotations.SerializedName;

public class News {
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("content")
        private String content;
        @SerializedName("author")
        private String author;
        @SerializedName("urlToImage")
        private String imageUrl;


        @Override
        public String toString() {
            return "News{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", content='" + content + '\'' +
                    ", author='" + author + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

}
