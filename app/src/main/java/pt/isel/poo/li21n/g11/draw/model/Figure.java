package pt.isel.poo.li21n.g11.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Figure {

    protected Point start;
    protected Point end;
    private static Figure f;

    protected Figure(int x, int y) {
        start = new Point(x, y);
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }

    protected Figure() {
    }

    public void save(PrintWriter out) {
    }

    public void load(Scanner in) {
    }

    protected char getLetter() {
        return f.getLetter();
    }

    public static Figure newInstance(char letter) {
        switch (letter) {
            case 'P':
                f = new Pixel();
                return f;
            case 'L':
                f = new Line();
                return f;
            case 'R':
                f = new Rect();
                return f;
            case 'C':
                f = new Circle();
                return f;
        }
        return null;
    }

    public void setEnd(int x, int y) {
        end.set(x, y);
    }

    public String toString() {
        return "(" + start.getX() + "," + start.getY() + ")";
    }

    protected int fromString(String s, int idx) {
        String x = "";
        String y = "";
        boolean writeY = false;
        while (idx < s.length()) {
            if (s.charAt(idx) == ',')
                writeY = true;
            if (s.charAt(idx) == ')')
                break;
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                if (writeY)
                    y += s.charAt(idx);
                else
                    x += s.charAt(idx);
            }
            ++idx;
        }
        start = new Point(Integer.parseInt(x), Integer.parseInt(y));
        return idx;

    }
}
