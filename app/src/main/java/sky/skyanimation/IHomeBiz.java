package sky.skyanimation;

import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;

/**
 * @创建人 sky
 * @创建时间 16/9/18 下午2:34
 * @类描述 一句话描述你的业务
 */
@Impl(HomeBiz.class)
public interface IHomeBiz extends SKYIBiz {

}

class HomeBiz extends SKYBiz<IHomeActivity> implements IHomeBiz {

}