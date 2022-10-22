package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.tasks.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f8721a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map<c<?>, Boolean> f8722b = Collections.synchronizedMap(new WeakHashMap());

    private final void d(boolean z10, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f8721a) {
            hashMap = new HashMap(this.f8721a);
        }
        synchronized (this.f8722b) {
            hashMap2 = new HashMap(this.f8722b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).o(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(BasePendingResult<? extends h> basePendingResult, boolean z10) {
        this.f8721a.put(basePendingResult, Boolean.valueOf(z10));
        basePendingResult.b(new t(this, basePendingResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <TResult> void c(c<TResult> cVar, boolean z10) {
        this.f8722b.put(cVar, Boolean.valueOf(z10));
        cVar.a().b(new u(this, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return !this.f8721a.isEmpty() || !this.f8722b.isEmpty();
    }

    public final void f() {
        d(false, e.f8553n);
    }

    public final void g() {
        d(true, w1.f8778d);
    }
}
