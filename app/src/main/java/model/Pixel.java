package model;

public class Pixel extends Figure {

    public static char LETTER;
    private int x;
    private int y;

    public Pixel(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Pixel(){}

    protected char getLETTER(){
        return this.LETTER;
    }

    public void setEnd(int x, int y){
        this.x=x;
        this.y=y;
    }
}
