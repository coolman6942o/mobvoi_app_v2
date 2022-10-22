package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.i;
import x5.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s0 implements i<Status> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ n f8723a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f8724b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d f8725c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ n0 f8726d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(n0 n0Var, n nVar, boolean z10, d dVar) {
        this.f8726d = n0Var;
        this.f8723a = nVar;
        this.f8724b = z10;
        this.f8725c = dVar;
    }

    @Override // com.google.android.gms.common.api.i
    public final /* synthetic */ void a(Status status) {
        Context context;
        Status status2 = status;
        context = this.f8726d.f8658g;
        b.b(context).l();
        if (status2.K0() && this.f8726d.p()) {
            this.f8726d.s();
        }
        this.f8723a.j(status2);
        if (this.f8724b) {
            this.f8725c.h();
        }
    }
}
