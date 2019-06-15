package pt.isel.poo.li21n.g11.draw.model;

public class Rect extends Line {

    public static final char LETTER = 'R';

    public Rect(int x, int y) {
        super(x, y);
        end = new Point(x, y);
    }

    public Rect() {
        super();
    }

    protected char getLetter() {
        return this.LETTER;
    }
}
