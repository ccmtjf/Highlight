package zhy.com.highlight.shape;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import zhy.com.highlight.HighLight;

/**
 * Created by caizepeng on 16/8/20.
 * Edited by isanwenyu@163.com 16/10/26.
 */
public class RectLightShape extends BaseLightShape {
    public RectLightShape() {
        super();
    }

    public RectLightShape(float dx, float dy, float blurRadius) {
        super(dx, dy, blurRadius);
    }

    public RectLightShape(float dx, float dy) {
        super(dx, dy);
    }

    @Override
    protected void drawShape(Bitmap bitmap, HighLight.ViewPosInfo viewPosInfo) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setAntiAlias(true);
        if (blurRadius > 0) {
            paint.setMaskFilter(new BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.SOLID));
        }
        canvas.drawRoundRect(viewPosInfo.rectF,6,6,paint);
    }

    @Override
    protected void resetRectF4Shape(RectF viewPosInfoRectF, float dx, float dy) {
        viewPosInfoRectF.inset(dx,dy);
    }
}
