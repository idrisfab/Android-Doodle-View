package com.fabiyi.myapplicationdoodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Attr;

/**
 * Created by idris_000 on 28/06/2015.
 */
public class DoodleView extends View
{
    private Paint paintDoodle = new Paint();

    Path path = new Path();

    public DoodleView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs, 0);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        //canvas.drawLine(0,0, getWidth(), getHeight(), paintDoodle);
        canvas.drawPath(path, paintDoodle);
        Toast.makeText(getContext(), "Drawning is happening", Toast.LENGTH_SHORT).show();
    }

    public DoodleView(Context context)
    {
        super(context);
        init(null, 0);
    }

    public void init(AttributeSet attrs, int defStyle)
    {
        paintDoodle.setColor(Color.RED);
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float touchX = event.getX();
        float touchy = event.getY();
        // there are 3 different types of motion events, so we can use a switch statement to choose.
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchy);
                break;
            case MotionEvent.ACTION_MOVE :
                path.lineTo(touchX, touchy);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();
        return true;
        //return super.onTouchEvent(event);

    }
}
