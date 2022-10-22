package com.alipay.android.phone.mrpc.core;

import android.content.Context;
/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ aa f6745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f6746b;

    public i(h hVar, aa aaVar) {
        this.f6746b = hVar;
        this.f6745a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f6745a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.f6746b.f6744a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f6745a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f6745a.c();
    }
}
