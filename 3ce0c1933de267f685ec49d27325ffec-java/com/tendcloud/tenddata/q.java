package com.tendcloud.tenddata;

import java.lang.reflect.Method;
/* compiled from: td */
/* loaded from: classes2.dex */
public interface q {
    void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2);

    void beforeMethodInvoke(Object obj, Method method, Object[] objArr);
}
