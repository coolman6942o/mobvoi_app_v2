package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import b6.i;
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f9500a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9501b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9502c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9503d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k1 f9504e;

    public m1(k1 k1Var, String str, boolean z10) {
        this.f9504e = k1Var;
        i.g(str);
        this.f9500a = str;
    }

    public final boolean a() {
        SharedPreferences I;
        if (!this.f9502c) {
            this.f9502c = true;
            I = this.f9504e.I();
            this.f9503d = I.getBoolean(this.f9500a, this.f9501b);
        }
        return this.f9503d;
    }

    public final void b(boolean z10) {
        SharedPreferences I;
        I = this.f9504e.I();
        SharedPreferences.Editor edit = I.edit();
        edit.putBoolean(this.f9500a, z10);
        edit.apply();
        this.f9503d = z10;
    }
}
