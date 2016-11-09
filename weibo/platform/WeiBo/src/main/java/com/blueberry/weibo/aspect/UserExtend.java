package com.blueberry.weibo.aspect;

import com.blueberry.weibo.common.DefaultExtendable;
import com.blueberry.weibo.common.Extendable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/9.
 */
@Component("userExtend")
@Aspect
public class UserExtend {

    /**
     * 扩展了UserBo的所有实现
     */
    @DeclareParents(value = "com.blueberry.weibo.user.bo.UserBo+"
            , defaultImpl = DefaultExtendable.class)
    public static Extendable extendable;
}
