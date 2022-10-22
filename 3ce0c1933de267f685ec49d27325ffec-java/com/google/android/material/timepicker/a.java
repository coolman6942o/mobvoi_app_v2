package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import k0.c;
/* compiled from: ClickActionDelegate.java */
/* loaded from: classes.dex */
class a extends androidx.core.view.a {

    /* renamed from: d  reason: collision with root package name */
    private final c.a f11611d;

    public a(Context context, int i10) {
        this.f11611d = new c.a(16, context.getString(i10));
    }

    @Override // androidx.core.view.a
    public void g(View view, c cVar) {
        super.g(view, cVar);
        cVar.b(this.f11611d);
    }
}
