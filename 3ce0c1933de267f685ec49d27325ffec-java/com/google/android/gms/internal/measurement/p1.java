package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import b6.i;
/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f9585a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9586b;

    /* renamed from: c  reason: collision with root package name */
    private String f9587c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ k1 f9588d;

    public p1(k1 k1Var, String str, String str2) {
        this.f9588d = k1Var;
        i.g(str);
        this.f9585a = str;
    }

    public final void a(String str) {
        SharedPreferences I;
        if (!r5.C0(str, this.f9587c)) {
            I = this.f9588d.I();
            SharedPreferences.Editor edit = I.edit();
            edit.putString(this.f9585a, str);
            edit.apply();
            this.f9587c = str;
        }
    }

    public final String b() {
        SharedPreferences I;
        if (!this.f9586b) {
            this.f9586b = true;
            I = this.f9588d.I();
            this.f9587c = I.getString(this.f9585a, null);
        }
        return this.f9587c;
    }
}
