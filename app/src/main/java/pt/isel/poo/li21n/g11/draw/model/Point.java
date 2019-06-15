package pt.isel.poo.li21n.g11.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point {

    private int x;
    private int y;

    Point() {
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void save(PrintWriter out) {

    }

    public void load(Scanner in) {

    }

    @Override
    public String toString() {
        return "";
    }

    protected int fromString(String s, int idx) {
        return 0;
    }

}
