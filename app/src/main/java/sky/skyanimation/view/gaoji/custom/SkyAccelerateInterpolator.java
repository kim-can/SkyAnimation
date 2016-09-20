package sky.skyanimation.view.gaoji.custom;


import android.view.animation.Interpolator;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午9:48
 * @类描述
 */
public class SkyAccelerateInterpolator implements Interpolator {

	@Override public float getInterpolation(float v) {
		float result;
		if (v <= 0.5) {
			result = (float) (Math.sin(Math.PI * v)) / 2;
		} else {
			result = (float) (2 - Math.sin(Math.PI * v)) / 2;
		}
		return result;
	}
}
