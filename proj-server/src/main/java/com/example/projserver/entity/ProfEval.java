package com.example.projserver.entity;

public class ProfEval {
    private Integer id;

    private String profname;

    private Integer rating;

    private String comment;

    private String user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfname() {
        return profname;
    }

    public void setProfname(String profname) {
        this.profname = profname == null ? null : profname.trim();
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    @Override
    public String toString() {
        return "ProfEval{" +
                "id=" + id +
                ", profname='" + profname + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}