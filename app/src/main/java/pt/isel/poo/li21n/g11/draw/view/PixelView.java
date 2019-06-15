package pt.isel.poo.li21n.g11.draw.view;

import android.graphics.Canvas;

import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.model.Pixel;

public class PixelView extends FigureView {

    PixelView(Figure f) {
        super(f);
    }

    void draw(Canvas c) {
        Pixel pixel = (Pixel) elem;
        c.drawPoint(pixel.getStart().getX(), pixel.getStart().getY(), paint);
    }
}
