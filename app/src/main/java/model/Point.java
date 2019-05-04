package model;

import java.io.PrintWriter;
import java.util.Scanner;

public class Point {

    private int x;
    private int y;
    private Line end;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    Point(){}

    void set(int x, int y){

    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public void save(PrintWriter out){

    }

    public void load(Scanner in){

    }
}
