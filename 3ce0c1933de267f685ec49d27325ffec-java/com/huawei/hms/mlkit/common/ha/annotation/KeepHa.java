package com.huawei.hms.mlkit.common.ha.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@KeepHa
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface KeepHa {
}
