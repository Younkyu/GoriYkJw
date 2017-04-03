package goriproject.ykjw.com.myapplication.Custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by JINWOO on 2017-03-28.
 */

public class RadiusImageView extends ImageView {

    public static float radius = 2000.0f;

    public RadiusImageView(Context context) {
        super(context);
    }

    public RadiusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadiusImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
