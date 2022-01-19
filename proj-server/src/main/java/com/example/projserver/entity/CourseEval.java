package com.example.projserver.entity;

public class CourseEval {
    private Integer id;

    private String coursenumber;

    private String profname;

    private String semester;

    private Integer rating;

    private String comment;

    private String user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(String coursenumber) {
        this.coursenumber = coursenumber == null ? null : coursenumber.trim();
    }

    public String getProfname() {
        return profname;
    }

    public void setProfname(String profname) {
        this.profname = profname == null ? null : profname.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
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
        return "CourseEval{" +
                "id=" + id +
                ", coursenumber='" + coursenumber + '\'' +
                ", profname='" + profname + '\'' +
                ", semester='" + semester + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}