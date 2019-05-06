package model;

import android.graphics.Point;

import java.io.PrintWriter;
import java.util.Scanner;

import view.FigureView;

public abstract class Figure {

    private Point start;
    public FigureView elem;
    private int x;
    private int y;

    protected Figure(int x, int y){
        this.x=x;
        this.y=y;
    }

    protected Figure(){}

    public void save(PrintWriter out){
        start=getStart();
    }

    public void load(Scanner in){}

    protected char getLetter(){
        return ' ';
    }

    public static Figure newInstance(char letter){
        switch(letter){
            case 'P': return new Pixel();
            case 'L': return new Pixel();
            case 'R': return new Rect();
            case 'C': return new Circle();
        }
        return null;
    }

    public Point getStart(){
        return new Point(this.x,this.y);
    }

    public void setEnd(int x, int y){
        this.x=x;
        this.y=y;
    }
}
