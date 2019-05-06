package model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DrawModel {

    private ArrayList<Figure> figures;

    public void save(PrintWriter out){
        int i=0;
        while(iterator()!=null){
            out.write(figures.get(i).getLetter());
            out.write(figures.get(i).getStart().x);
            out.write(figures.get(i).getStart().y);
        }
    }

    public void load(Scanner in){

    }

    public void add(Figure f){
        figures.add(f);
    }

    public Iterator<Figure> iterator(){
        Iterator<Figure> iterator = figures.iterator();
        while(iterator.hasNext()){
            return iterator;
        }
        return null;
    }
}
