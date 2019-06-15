package pt.isel.poo.li21n.g11.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Circle extends Figure {

    public static final char LETTER = 'C';
    private int radius;

    public Circle(int x, int y) {
        super(x, y);
    }

    public Circle() {
        super();
    }

    protected char getLetter() {
        return this.LETTER;
    }

    public void load(Scanner in) {

    }

    public void save(PrintWriter out) {

    }

    @Override
    public void setEnd(int x, int y) {
        int x2 = (x - start.getX()) * (x - start.getX());
        int y2 = (y - start.getY()) * (y - start.getY());
        radius = (int) sqrt(x2 + y2);
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String toString() {
        return "(" + start.getX() + "," + start.getY() + ")" + "|" + radius + "|";
    }

    protected int fromString(String s, int idx) {
        String radius = "";
        idx = s.indexOf('|') + 1;
        while (idx < s.length()) {
            if (s.charAt(idx) == '|')
                break;
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                radius += s.charAt(idx);

            }
            ++idx;
        }
        this.radius = Integer.parseInt(radius);
        return idx;

    }
}
