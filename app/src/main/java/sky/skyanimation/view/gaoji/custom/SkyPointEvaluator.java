package sky.skyanimation.view.gaoji.custom;


import com.nineoldandroids.animation.TypeEvaluator;

import sky.skyanimation.view.gaoji.model.SkyPoint;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午3:12
 * @类描述
 */
public class SkyPointEvaluator implements TypeEvaluator<SkyPoint> {

	@Override public SkyPoint evaluate(float fraction, SkyPoint startPoint, SkyPoint endPoint) {
        float x = startPoint.x + fraction * (endPoint.x - startPoint.x);
        float y = startPoint.y + fraction * (endPoint.y - startPoint.y);
        SkyPoint point = new SkyPoint();
        point.x = x;
        point.y = y;
        return point;
	}
}
