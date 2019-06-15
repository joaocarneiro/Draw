package pt.isel.poo.li21n.g11.draw.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import pt.isel.poo.li21n.g11.draw.model.Circle;
import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.model.Line;
import pt.isel.poo.li21n.g11.draw.model.Pixel;
import pt.isel.poo.li21n.g11.draw.model.Rect;

public abstract class FigureView {

    protected Paint paint;
    protected Figure elem;

    FigureView(Figure f) {
        this.elem = f;
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
    }

    void draw(Canvas c) {
    }

    static FigureView newInstance(Figure f) {
        if (f instanceof Circle) return new CircleView(f);
        if (f instanceof Rect) return new RectView(f);
        if (f instanceof Line) return new LineView(f);
        if (f instanceof Pixel) return new PixelView(f);
        return null;
    }
}
