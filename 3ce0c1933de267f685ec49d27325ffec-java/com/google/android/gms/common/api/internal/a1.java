package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f8506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(e eVar) {
        this.f8506a = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.b.a
    public final void a(boolean z10) {
        this.f8506a.f8569m.sendMessage(this.f8506a.f8569m.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
