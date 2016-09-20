package sky.skyanimation.view.gaoji.custom;

import com.nineoldandroids.animation.TypeEvaluator;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午7:35
 * @类描述
 */
public class SkyColorEvaluator implements TypeEvaluator<String> {

	@Override public String evaluate(float v, String s, String t1) {

		if (v < 0.1f) {
			return s;
		} else if (v < 0.2f) {
			return "#99FFFF";
		} else if (v < 0.4f) {
			return "#99FFFF";
		} else if (v < 0.6f) {
			return "#9933FF";
		} else if (v < 0.8f) {
			return "#FF66FF";
		} else if (v < 0.9f) {
			return "#3366CC";
		}

		return t1;
	}
}
