package pt.isel.poo.li21n.g11.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;

import pt.isel.poo.li21n.g11.draw.model.DrawModel;
import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.DrawController;

public class DrawView extends View {

    private FigureView curr;
    private Figure figure;
    private DrawController ctrl;
    private Paint paint;
    private LinkedList<FigureView> views = new LinkedList<>();

    public DrawView(DrawController ctrl) {
        super(ctrl);
        this.ctrl = ctrl;
        paint = new Paint();
        paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(2.0f);
    }

    public void reloadModel(DrawModel model) {
        views.clear();
        LinkedList<Figure> newViews = model.getList();
        for (int i = 0; i < newViews.size(); i++) {
            curr = FigureView.newInstance(newViews.get(i));
            views.add(curr);
        }
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRect(5.0f, 5.0f, (float) (getWidth() - 5), (float) (getHeight() - 5), this.paint);
        for (FigureView i : views)
            i.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                figure = ctrl.createSelectedFigure((int) event.getX(), (int) event.getY());
                curr = FigureView.newInstance(figure);
                views.add(curr);
                break;
            case MotionEvent.ACTION_MOVE:
                figure.setEnd((int) event.getX(), (int) event.getY());
                break;
        }

        invalidate();
        return true;
    }

    public void clear() {
        views.clear();
        invalidate();
    }
}
