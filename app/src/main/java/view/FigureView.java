package view;

import android.graphics.Canvas;
import android.graphics.Paint;

import model.Figure;

public abstract class FigureView {

    protected Paint paint;

    FigureView(Figure f){}

    FigureView(){}

    void draw(Canvas c){}

//    static FigureView newInstance(Figure f){
//
//    }
}
