package sky.skyanimation.view.gaoji;

import jc.sky.core.Impl;
import jc.sky.core.SKYBiz;
import jc.sky.core.SKYIBiz;

/**
 * @创建人 sky
 * @创建时间 16/9/20 下午2:31
 * @类描述 一句话描述你的业务
 */
@Impl(GaoBiz.class)
public interface IGaoBiz extends SKYIBiz {

}

class GaoBiz extends SKYBiz<IGaoActivity> implements IGaoBiz {

}