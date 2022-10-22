package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t6 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ s6 f9681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t6(s6 s6Var, Handler handler) {
        super(null);
        this.f9681a = s6Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.f9681a.d();
        this.f9681a.f();
    }
}
