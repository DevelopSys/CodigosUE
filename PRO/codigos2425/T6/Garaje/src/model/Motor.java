package model;

public class Motor {
    private int cv;
    private int cc;

    public Motor() {
    }

    public Motor(int cv, int cc) {
        this.cv = cv;
        this.cc = cc;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
