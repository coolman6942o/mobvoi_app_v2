package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOffsetBehavior.java */
/* loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private d f10396a;

    /* renamed from: b  reason: collision with root package name */
    private int f10397b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f10398c = 0;

    public c() {
    }

    public int E() {
        d dVar = this.f10396a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.I(v10, i10);
    }

    public boolean G(int i10) {
        d dVar = this.f10396a;
        if (dVar != null) {
            return dVar.e(i10);
        }
        this.f10397b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        F(coordinatorLayout, v10, i10);
        if (this.f10396a == null) {
            this.f10396a = new d(v10);
        }
        this.f10396a.c();
        this.f10396a.a();
        int i11 = this.f10397b;
        if (i11 != 0) {
            this.f10396a.e(i11);
            this.f10397b = 0;
        }
        int i12 = this.f10398c;
        if (i12 == 0) {
            return true;
        }
        this.f10396a.d(i12);
        this.f10398c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
