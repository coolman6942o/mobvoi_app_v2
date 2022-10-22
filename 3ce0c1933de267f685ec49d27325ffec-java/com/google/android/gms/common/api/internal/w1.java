package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: d  reason: collision with root package name */
    public static final Status f8778d = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: e  reason: collision with root package name */
    private static final BasePendingResult<?>[] f8779e = new BasePendingResult[0];

    /* renamed from: a  reason: collision with root package name */
    final Set<BasePendingResult<?>> f8780a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b  reason: collision with root package name */
    private final z1 f8781b = new x1(this);

    /* renamed from: c  reason: collision with root package name */
    private final Map<a.c<?>, a.f> f8782c;

    public w1(Map<a.c<?>, a.f> map) {
        this.f8782c = map;
    }

    public final void a() {
        BasePendingResult[] basePendingResultArr;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f8780a.toArray(f8779e)) {
            basePendingResult.m(null);
            if (basePendingResult.f() != null) {
                basePendingResult.e(null);
                IBinder u10 = this.f8782c.get(((c) basePendingResult).t()).u();
                if (basePendingResult.i()) {
                    basePendingResult.m(new y1(basePendingResult, null, u10, null));
                } else if (u10 == null || !u10.isBinderAlive()) {
                    basePendingResult.m(null);
                    basePendingResult.c();
                    basePendingResult.f().intValue();
                    throw null;
                } else {
                    y1 y1Var = new y1(basePendingResult, null, u10, null);
                    basePendingResult.m(y1Var);
                    try {
                        u10.linkToDeath(y1Var, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.c();
                        basePendingResult.f().intValue();
                        throw null;
                    }
                }
                this.f8780a.remove(basePendingResult);
            } else if (basePendingResult.p()) {
                this.f8780a.remove(basePendingResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(BasePendingResult<? extends h> basePendingResult) {
        this.f8780a.add(basePendingResult);
        basePendingResult.m(this.f8781b);
    }

    public final void c() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f8780a.toArray(f8779e)) {
            basePendingResult.o(f8778d);
        }
    }
}
