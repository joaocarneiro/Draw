package pt.isel.poo.li21n.g11.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.li21n.g11.draw.model.Circle;
import pt.isel.poo.li21n.g11.draw.model.Figure;

public class CircleView extends FigureView {

    CircleView(Figure f) {
        super(f);
    }

    void draw(Canvas c) {
        Circle circle = (Circle) elem;
        c.drawCircle(circle.getStart().getX(), elem.getStart().getY(), circle.getRadius(), paint);
    }
}
