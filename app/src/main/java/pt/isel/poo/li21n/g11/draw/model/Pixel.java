package pt.isel.poo.li21n.g11.draw.model;

public class Pixel extends Figure {

    public static final char LETTER = 'P';
    private int x;
    private int y;

    public Pixel(int x, int y) {
        super(x, y);
    }

    public Pixel() {
        super();
    }

    protected char getLetter() {
        return this.LETTER;
    }

    public void setEnd(int x, int y) {
        start.set(x, y);
    }
}
