package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.util.Pair;
import b6.i;
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f9541a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9542b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9543c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9544d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k1 f9545e;

    private o1(k1 k1Var, String str, long j10) {
        this.f9545e = k1Var;
        i.g(str);
        i.a(j10 > 0);
        this.f9541a = String.valueOf(str).concat(":start");
        this.f9542b = String.valueOf(str).concat(":count");
        this.f9543c = String.valueOf(str).concat(":value");
        this.f9544d = j10;
    }

    private final void b() {
        SharedPreferences I;
        this.f9545e.e();
        long b10 = this.f9545e.b().b();
        I = this.f9545e.I();
        SharedPreferences.Editor edit = I.edit();
        edit.remove(this.f9542b);
        edit.remove(this.f9543c);
        edit.putLong(this.f9541a, b10);
        edit.apply();
    }

    private final long d() {
        SharedPreferences I;
        I = this.f9545e.I();
        return I.getLong(this.f9541a, 0L);
    }

    public final void a(String str, long j10) {
        SharedPreferences I;
        SharedPreferences I2;
        SharedPreferences I3;
        this.f9545e.e();
        if (d() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        I = this.f9545e.I();
        long j11 = I.getLong(this.f9542b, 0L);
        if (j11 <= 0) {
            I3 = this.f9545e.I();
            SharedPreferences.Editor edit = I3.edit();
            edit.putString(this.f9543c, str);
            edit.putLong(this.f9542b, 1L);
            edit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (this.f9545e.p().y0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12;
        I2 = this.f9545e.I();
        SharedPreferences.Editor edit2 = I2.edit();
        if (z10) {
            edit2.putString(this.f9543c, str);
        }
        edit2.putLong(this.f9542b, j12);
        edit2.apply();
    }

    public final Pair<String, Long> c() {
        long j10;
        SharedPreferences I;
        SharedPreferences I2;
        this.f9545e.e();
        this.f9545e.e();
        long d10 = d();
        if (d10 == 0) {
            b();
            j10 = 0;
        } else {
            j10 = Math.abs(d10 - this.f9545e.b().b());
        }
        long j11 = this.f9544d;
        if (j10 < j11) {
            return null;
        }
        if (j10 > (j11 << 1)) {
            b();
            return null;
        }
        I = this.f9545e.I();
        String string = I.getString(this.f9543c, null);
        I2 = this.f9545e.I();
        long j12 = I2.getLong(this.f9542b, 0L);
        b();
        return (string == null || j12 <= 0) ? k1.f9429y : new Pair<>(string, Long.valueOf(j12));
    }
}
