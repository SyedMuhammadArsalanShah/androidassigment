package com.example.signup;

public class Courses {
    String cname;
    String Duration;
    int img;

    public Courses() {
    }

    public Courses(String cname, String duration, int img) {
        this.cname = cname;
        Duration = duration;
        this.img = img;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
