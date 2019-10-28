package com.zyt;

public class Post {
    private long postId;

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", title='" + title + '\'' + ", content='" + content + '\'' + ", anthor='" + anthor + '\'' + '}';
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    private String title;

    private String content;
    private String anthor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

}
