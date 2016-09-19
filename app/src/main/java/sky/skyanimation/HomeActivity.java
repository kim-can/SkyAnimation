package sky.skyanimation;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jc.sky.SKYHelper;
import jc.sky.core.Impl;
import jc.sky.modules.log.L;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

/**
 * @创建人 sky
 * @创建时间 16/9/18 下午2:33
 * @类描述 首页
 */
public class HomeActivity extends SKYActivity<IHomeBiz> implements IHomeActivity {

	@BindView(R.id.btn_test) Button		btnTest;

	@BindView(R.id.tv_content) TextView	tvContent;

	@Override protected SKYBuilder build(SKYBuilder skyBuilder) {
		skyBuilder.layoutId(R.layout.activity_main);
		return skyBuilder;
	}

	@Override protected void initData(Bundle bundle) {
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		float density = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）

		SKYHelper.toast().show("密度:" + density);
	}

	/**
	 * 测试
	 */
	AnimatorSet animSet = new AnimatorSet();

	@OnClick(R.id.btn_test) public void onTest() {
		if(animSet.isRunning()){
			return;
		}
		float tx = tvContent.getTranslationX();

		ObjectAnimator moveIn = ObjectAnimator.ofFloat(tvContent, "translationX", tx, -500f, tx);
		ObjectAnimator rotate = ObjectAnimator.ofFloat(tvContent, "rotation", 0f, 360f);
		ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tvContent, "alpha", 1f, 0f, 1f);

		fadeInOut.setRepeatCount(2);

		animSet.play(rotate).with(fadeInOut).after(moveIn);
		animSet.setDuration(5000);
		animSet.addListener(new AnimatorListenerAdapter(){});
		animSet.start();
	}

}

@Impl(HomeActivity.class)
interface IHomeActivity {

	String	ANIMATOR_TYPE_ALPHA			= "alpha";			// 透明

	String	ANIMATOR_TYPE_ROTATION		= "rotation";		// 旋转

	String	ANIMATOR_TYPE_TRANSLATION_X	= "translationX";	// 位置

	String	ANIMATOR_TYPE_SCANLE_y		= "scaleY";			// 缩放
}