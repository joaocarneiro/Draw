package pt.isel.poo.li21n.g11.draw.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import pt.isel.poo.li21n.g11.draw.DrawController;

public class DrawModel extends DrawController {

    LinkedList<Figure> list = new LinkedList<>();

    public Iterator<Figure> iterator() {
        return list.iterator();
    }

    public void add(Figure f) {
        list.add(f);
    }

    public void clear() {
        list.clear();
    }

    public void save(PrintWriter out) {
        out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).getLetter() + " " + list.get(i).toString();
            out.println(s);
        }
        out.flush();
        out.close();
    }

    public void load(Scanner in) {
        try {
            Figure f;
            in.next();
            while (in.hasNext()) {
                int aux = 0;
                f = Figure.newInstance(in.next().charAt(aux));
                f.fromString(in.nextLine(), aux);
                list.add(f);
                ++aux;
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    public LinkedList<Figure> getList() {
        return list;
    }
}
