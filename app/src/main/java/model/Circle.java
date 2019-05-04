package model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Circle extends Figure{

    public static char LETTER;
    private int radius;
    private int x;
    private int y;

    public Circle(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Circle(){}

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

    public int getRadius(){
        return this.radius;
    }
}
