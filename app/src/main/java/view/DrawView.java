package view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import pt.isel.poo.li21n.g11.draw.DrawController;

public class DrawView extends View {

//    private FigureView[] views;
//    private FigureView curr;

    public DrawView(DrawController ctrl){
        super(ctrl);
    }

//    public reloadModel(DrawModel draw){
//
//    }

//    protected void onDraw(Canvas canvas){
//
//    }

    public boolean onTouchEvent(MotionEvent event){
        return false;
    }
}
