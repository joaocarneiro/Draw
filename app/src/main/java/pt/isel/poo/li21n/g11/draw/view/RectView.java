package pt.isel.poo.li21n.g11.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.model.Rect;

public class RectView extends FigureView {

    RectView(Figure f) {
        super(f);
    }

    void draw(Canvas c) {
        Rect rect = (Rect) elem;

        if (rect.getEnd().getX() < rect.getStart().getX())
            c.drawRect(rect.getEnd().getX(), rect.getStart().getY(), rect.getStart().getX(), rect.getEnd().getY(), paint);

        if (rect.getEnd().getY() < rect.getStart().getY())
            c.drawRect(rect.getStart().getX(), rect.getEnd().getY(), rect.getEnd().getX(), rect.getStart().getY(), paint);

        if (rect.getEnd().getY() < rect.getStart().getY() && rect.getEnd().getX() < rect.getStart().getX())
            c.drawRect(rect.getEnd().getX(), rect.getEnd().getY(), rect.getStart().getX(), rect.getStart().getY(), paint);

        c.drawRect(rect.getStart().getX(), rect.getStart().getY(), rect.getEnd().getX(), rect.getEnd().getY(), paint);
    }
}
