package pt.isel.poo.li21n.g11.draw;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import pt.isel.poo.li21n.g11.draw.model.Circle;
import pt.isel.poo.li21n.g11.draw.model.DrawModel;
import pt.isel.poo.li21n.g11.draw.model.Figure;
import pt.isel.poo.li21n.g11.draw.model.Line;
import pt.isel.poo.li21n.g11.draw.model.Pixel;
import pt.isel.poo.li21n.g11.draw.model.Rect;
import pt.isel.poo.li21n.g11.draw.view.DrawView;

public class DrawController extends AppCompatActivity {

    private final File FILE = new File("sketch.txt");
    private DrawModel model;
    private DrawView view;
    private Button reset, load, save;
    private RadioButton rect, line, pixel, circle;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new DrawModel();
        view = new DrawView(this);

        if (savedInstanceState != null)
            onLoad();

        reset = new Button(this);
        reset.setText(getString(R.string.reset));

        load = new Button(this);
        load.setText(getString(R.string.load));

        save = new Button(this);
        save.setText(getString(R.string.save));

        line = new RadioButton(this);
        line.setText(getString(R.string.line));

        rect = new RadioButton(this);
        rect.setText(getString(R.string.rect));

        pixel = new RadioButton(this);
        pixel.setText(getString(R.string.pixel));

        circle = new RadioButton(this);
        circle.setText(getString(R.string.circle));

        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.HORIZONTAL);
        buttons.addView(reset);
        buttons.addView(load);
        buttons.addView(save);

        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);

        radioGroup.addView(line);
        radioGroup.addView(rect);
        radioGroup.addView(pixel);
        radioGroup.addView(circle);
        radioGroup.check(line.getId());

        LinearLayout top = new LinearLayout(this);
        top.addView(buttons);
        top.setOrientation(LinearLayout.VERTICAL);
        top.addView(radioGroup);

        LinearLayout global = new LinearLayout(this);
        global.setOrientation(LinearLayout.VERTICAL);
        global.setBackgroundColor(Color.parseColor("#7FFCA4"));
        top.setBackgroundColor(Color.WHITE);
        global.addView(top);

        global.addView(view);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReset();
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoad();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSave();
            }
        });

        setContentView(global);
    }

    private void onSave() {
        try {
            OutputStream output = openFileOutput(FILE.getName(), Context.MODE_PRIVATE);
            PrintWriter p = new PrintWriter(output);
            model.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onLoad() {
        try {
            InputStream input = openFileInput(FILE.getName());
            Scanner in = new Scanner(input);
            model.load(in);
            view.reloadModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onReset() {
        model.clear();
        view.clear();
    }

    public Figure createSelectedFigure(int x, int y) {
        Figure f = null;
        if (line.isChecked()) f = new Line(x, y);
        if (rect.isChecked()) f = new Rect(x, y);
        if (circle.isChecked()) f = new Circle(x, y);
        if (pixel.isChecked()) f = new Pixel(x, y);
        model.add(f);
        return f;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSave();
        onLoad();
    }
}
