package model;

import android.graphics.Point;

import java.io.PrintWriter;
import java.util.Scanner;

import view.FigureView;

public abstract class Figure {

    private Point start;
    public FigureView elem;

    protected Figure(int x, int y){}

    protected Figure(){}

    public void save(PrintWriter out){}

    public void load(Scanner in){}

//    protected char getLetter(){}

//    public static Figure newInstance(char letter){}

//    public Point getStart(){}

    public void setEnd(int x, int y){}
}
