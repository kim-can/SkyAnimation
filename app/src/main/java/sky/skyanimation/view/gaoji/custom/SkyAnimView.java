package sky.skyanimation.view.gaoji.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import jc.sky.modules.log.L;
import sky.skyanimation.R;
import sky.skyanimation.view.gaoji.model.SkyPoint;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午4:02
 * @类描述
 */
public class SkyAnimView extends View {

    public static final float SIZE = 50;

	// 坐标
	SkyPoint	skyPoint;

	// 画笔
	Paint		paint;

    Bitmap bitmap;


    String color;

    public void setSkycolor(String value){
        color = value;
        paint.setColor(Color.parseColor(value));
        invalidate();
    }

    public String getSkycolor(){
        return color;
    }

	public SkyAnimView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(ContextCompat.getColor(context,R.color.colorPrimary));
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
        if (skyPoint == null) {
            skyPoint = new SkyPoint(0, 0);
            canvas.drawBitmap(bitmap,skyPoint.x, skyPoint.y, paint);
            canvas.drawCircle(skyPoint.x, skyPoint.y,SIZE, paint);
            startAnimation();
        } else {
            canvas.drawBitmap(bitmap,skyPoint.x, skyPoint.y, paint);
            canvas.drawCircle(skyPoint.x, skyPoint.y,SIZE, paint);
        }

    }

    private void startAnimation() {
        SkyPoint startPoint = new SkyPoint(0, 0);
        SkyPoint endPoint = new SkyPoint(0, getHeight()-bitmap.getHeight());
        ValueAnimator anim = ValueAnimator.ofObject(new SkyPointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                skyPoint = (SkyPoint) animation.getAnimatedValue();
                L.i("值x" + skyPoint.x +", 值y" + skyPoint.y);
                invalidate();
            }
        });

        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "skycolor", new SkyColorEvaluator(),"#0000FF", "#FF0000");
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(anim2);
        animSet.setDuration(5000);
        animSet.setInterpolator(new SkyAccelerateInterpolator());
        animSet.start();
    }
}
