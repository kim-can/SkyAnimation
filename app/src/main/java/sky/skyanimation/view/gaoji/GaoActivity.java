package sky.skyanimation.view.gaoji;

import android.os.Bundle;

import com.nineoldandroids.animation.ValueAnimator;

import jc.sky.core.Impl;
import jc.sky.modules.log.L;
import jc.sky.view.SKYBuilder;
import jc.sky.view.SKYActivity;
import sky.skyanimation.R;
import sky.skyanimation.view.gaoji.custom.SkyPointEvaluator;
import sky.skyanimation.view.gaoji.model.SkyPoint;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午2:31
 * @类描述 高级
 */
public class GaoActivity extends SKYActivity<IGaoBiz> implements IGaoActivity {

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_gao);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {
		SkyPoint point1 = new SkyPoint(0, 0);
		SkyPoint point2 = new SkyPoint(300, 300);
		final ValueAnimator anim = ValueAnimator.ofObject(new SkyPointEvaluator(), point1, point2);
		anim.setDuration(5000);
		anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

			@Override public void onAnimationUpdate(ValueAnimator animation) {
				SkyPoint value = (SkyPoint) animation.getAnimatedValue();
//				L.i("值x" + value.x +", 值y" + value.y);
			}
		});
		anim.start();
	}

}

@Impl(GaoActivity.class)
interface IGaoActivity {

}