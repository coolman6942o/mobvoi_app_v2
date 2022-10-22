package com.google.android.gms.internal.measurement;

import b6.i;
import com.mobvoi.wear.util.LogCleaner;
import h6.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e5 {

    /* renamed from: a  reason: collision with root package name */
    private final e f9254a;

    /* renamed from: b  reason: collision with root package name */
    private long f9255b;

    public e5(e eVar) {
        i.k(eVar);
        this.f9254a = eVar;
    }

    public final void a() {
        this.f9255b = 0L;
    }

    public final void b() {
        this.f9255b = this.f9254a.c();
    }

    public final boolean c(long j10) {
        return this.f9255b == 0 || this.f9254a.c() - this.f9255b >= LogCleaner.ONE_HOUR;
    }
}
