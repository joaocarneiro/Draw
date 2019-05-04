package model;

public class Rect extends Line {

    public static char LETTER;
    private int x;
    private int y;

    public Rect(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Rect(){

    }

    protected char getLETTER(){
        return this.LETTER;
    }
}
