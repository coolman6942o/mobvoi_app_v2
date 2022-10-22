package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 implements b.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e.a f8593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(e.a aVar) {
        this.f8593a = aVar;
    }

    @Override // com.google.android.gms.common.internal.b.e
    public final void a() {
        e.this.f8569m.post(new f1(this));
    }
}
