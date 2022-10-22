package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes.dex */
public interface h {
    void g(String str, LifecycleCallback lifecycleCallback);

    void startActivityForResult(Intent intent, int i10);

    <T extends LifecycleCallback> T t(String str, Class<T> cls);

    Activity u();
}
