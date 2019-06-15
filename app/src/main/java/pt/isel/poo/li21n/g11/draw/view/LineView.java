package pt.isel.poo.li21n.g11.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.model.Line;

public class LineView extends FigureView {

    LineView(Figure f) {
        super(f);
    }

    void draw(Canvas c) {
        Line line = (Line) elem;
        c.drawLine(line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY(), paint);
    }

}
