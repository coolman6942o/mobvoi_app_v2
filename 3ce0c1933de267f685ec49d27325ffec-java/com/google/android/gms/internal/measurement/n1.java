package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import b6.i;
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f9522a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9523b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9524c;

    /* renamed from: d  reason: collision with root package name */
    private long f9525d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k1 f9526e;

    public n1(k1 k1Var, String str, long j10) {
        this.f9526e = k1Var;
        i.g(str);
        this.f9522a = str;
        this.f9523b = j10;
    }

    public final long a() {
        SharedPreferences I;
        if (!this.f9524c) {
            this.f9524c = true;
            I = this.f9526e.I();
            this.f9525d = I.getLong(this.f9522a, this.f9523b);
        }
        return this.f9525d;
    }

    public final void b(long j10) {
        SharedPreferences I;
        I = this.f9526e.I();
        SharedPreferences.Editor edit = I.edit();
        edit.putLong(this.f9522a, j10);
        edit.apply();
        this.f9525d = j10;
    }
}
