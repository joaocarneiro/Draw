package pt.isel.poo.li21n.g11.draw;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import view.DrawView;

public class DrawController extends AppCompatActivity {

    private int value = 0;
    private final String FILE = "src/main/res/draw.txt";
    private Button save;
    private Button load;
    private Button reset;
    private RadioButton pixel;
    private RadioButton circle;
    private RadioButton rect;
    private RadioButton line;
    private RadioGroup radioGroup;
    String mycontent;
//    private DrawModel model;
    private DrawView view;

    private void onReset(){
        reset = new Button(this);
        reset.setText("RESET");
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){}
        });
    }

    private void onLoad(){
        load = new Button(this);
        load.setText("LOAD");
        load.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){}
        });
    }

    private void onSave(){
        save = new Button(this);
        save.setText("SAVE");
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BufferedWriter bw;
                try {
                    File targetFile = new File(FILE);
                    FileWriter fw = new FileWriter(targetFile);
                    bw = new BufferedWriter(fw);
                    bw.write(mycontent);
                    System.out.println(mycontent);
                }
                catch(IOException e){
                    System.err.println(e);
                }

            }
        });
    }

//    public Figure createSelectedFigure(int x, int y){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        onReset();
        onLoad();
        onSave();

        final LinearLayout btnLayout = new LinearLayout(this);
        btnLayout.setOrientation(LinearLayout.HORIZONTAL);
        btnLayout.addView(reset);
        btnLayout.addView(save);
        btnLayout.addView(load);

        line = new RadioButton(this);
        line.setText("Line");
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){}
        });
        rect = new RadioButton(this);
        rect.setText("Rect");
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){}
        });
        pixel = new RadioButton(this);
        pixel.setText("Pixel");
        pixel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){}
        });
        circle = new RadioButton(this);
        circle.setText("Circle");
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){}
        });

        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.addView(line);
        radioGroup.addView(rect);
        radioGroup.addView(pixel);
        radioGroup.addView(circle);

        final LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        final LinearLayout drawingBoard = new LinearLayout(this);
        drawingBoard.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    mycontent="("+event.getX()+"),("+event.getY()+")";
                    Toast.makeText(DrawController.this, mycontent, Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
        drawingBoard.setLayoutParams(layoutParams);
        drawingBoard.setBackgroundColor(Color.parseColor("#7FFCA4"));

        final TableLayout tableLayout = new TableLayout(this);
        tableLayout.setOrientation(LinearLayout.HORIZONTAL);
        tableLayout.setLayoutParams(layoutParams);
        tableLayout.addView(btnLayout);
        tableLayout.addView(radioGroup);
        tableLayout.addView(drawingBoard);

        final LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(layoutParams);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(tableLayout);

        setContentView(layout);


    }
}