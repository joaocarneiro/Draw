package pt.isel.poo.li21n.g11.draw.model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static final char LETTER = 'L';
    protected Point end;

    public Line(int x, int y) {
        super(x, y);
        end = new Point(x, y);
    }

    public Line() {
        super();
    }

    protected char getLetter() {
        return this.LETTER;
    }

    public void load(Scanner in) {

    }

    public void save(PrintWriter out) {

    }

    public void setEnd(int x, int y) {
        end.set(x, y);
    }

    public Point getEnd() {
        return end;
    }

    public String toString() {
        return "(" + start.getX() + "," + start.getY() + ")" + " " + "(" + end.getX() + "," + end.getY() + ")";
    }

    protected int fromString(String s, int idx) {
        idx = super.fromString(s, idx) + 1;
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
        end = new Point(Integer.parseInt(x), Integer.parseInt(y));
        return idx;
    }
}
