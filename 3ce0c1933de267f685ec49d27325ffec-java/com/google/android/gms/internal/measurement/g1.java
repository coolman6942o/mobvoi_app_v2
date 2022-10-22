package com.google.android.gms.internal.measurement;

import b6.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f1 f9292a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9293b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f9294c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f9295d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9296e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, List<String>> f9297f;

    private g1(String str, f1 f1Var, int i10, Throwable th2, byte[] bArr, Map<String, List<String>> map) {
        i.k(f1Var);
        this.f9292a = f1Var;
        this.f9293b = i10;
        this.f9294c = th2;
        this.f9295d = bArr;
        this.f9296e = str;
        this.f9297f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9292a.a(this.f9296e, this.f9293b, this.f9294c, this.f9295d, this.f9297f);
    }
}
