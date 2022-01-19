package com.example.projserver.entity;

public class Course {
    private Integer id;

    private Integer number;

    private String name;

    private Integer units;

    private String prof;

    private String intro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof == null ? null : prof.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", units=" + units +
                ", prof='" + prof + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}