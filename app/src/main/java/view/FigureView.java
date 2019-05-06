package view;

import android.graphics.Canvas;
import android.graphics.Paint;

import model.Figure;

public abstract class FigureView {

    protected Paint paint;
    private Figure f;

    FigureView(Figure f){
        this.f=f;
    }

    FigureView(){}

    void draw(Canvas c){}

    static FigureView newInstance(Figure f){
        switch (f.getClass().getName()){
            case "Circle": return new CircleView(f);
            case "Rect": return new RectView(f);
            case "Line": return new LineView(f);
            case "Pixel": return new PixelView(f);
        }
        return null;
    }
}
