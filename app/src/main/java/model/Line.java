package model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Line extends Figure {

    public static char LETTER;
    private int x;
    private int y;

    public Line(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Line(){}

    protected char getLETTER(){
        return this.LETTER;
    }

    public void load(Scanner in){

    }

    public void save(PrintWriter out){

    }

    public void setEnd(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Point getEnd(){
        return new Point(this.x,this.y);
    }
}
