package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.l;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y1 implements IBinder.DeathRecipient, z1 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<BasePendingResult<?>> f8794a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<l> f8795b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<IBinder> f8796c;

    private y1(BasePendingResult<?> basePendingResult, l lVar, IBinder iBinder) {
        this.f8795b = new WeakReference<>(lVar);
        this.f8794a = new WeakReference<>(basePendingResult);
        this.f8796c = new WeakReference<>(iBinder);
    }

    private final void b() {
        BasePendingResult<?> basePendingResult = this.f8794a.get();
        l lVar = this.f8795b.get();
        if (!(lVar == null || basePendingResult == null)) {
            lVar.a(basePendingResult.f().intValue());
        }
        IBinder iBinder = this.f8796c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.z1
    public final void a(BasePendingResult<?> basePendingResult) {
        b();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y1(BasePendingResult basePendingResult, l lVar, IBinder iBinder, x1 x1Var) {
        this(basePendingResult, null, iBinder);
    }
}
