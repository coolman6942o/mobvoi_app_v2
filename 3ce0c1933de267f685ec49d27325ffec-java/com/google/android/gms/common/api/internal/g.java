package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.f;
import b6.i;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8607a;

    public g(Activity activity) {
        i.l(activity, "Activity must not be null");
        this.f8607a = activity;
    }

    public Activity a() {
        return (Activity) this.f8607a;
    }

    public f b() {
        return (f) this.f8607a;
    }

    public boolean c() {
        return this.f8607a instanceof f;
    }

    public final boolean d() {
        return this.f8607a instanceof Activity;
    }
}
