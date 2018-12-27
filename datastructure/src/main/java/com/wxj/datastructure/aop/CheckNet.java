package com.wxj.datastructure.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wuxiaojun on 2018/12/22.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // RUNTIME:运行时 CLASS:代表编译期 SOURCE:检测资源是否正确
public @interface CheckNet {



}
