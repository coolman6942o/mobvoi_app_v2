package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.d0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f10399a;

    /* renamed from: b  reason: collision with root package name */
    private int f10400b;

    /* renamed from: c  reason: collision with root package name */
    private int f10401c;

    /* renamed from: d  reason: collision with root package name */
    private int f10402d;

    /* renamed from: e  reason: collision with root package name */
    private int f10403e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10404f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10405g = true;

    public d(View view) {
        this.f10399a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f10399a;
        d0.e0(view, this.f10402d - (view.getTop() - this.f10400b));
        View view2 = this.f10399a;
        d0.d0(view2, this.f10403e - (view2.getLeft() - this.f10401c));
    }

    public int b() {
        return this.f10402d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f10400b = this.f10399a.getTop();
        this.f10401c = this.f10399a.getLeft();
    }

    public boolean d(int i10) {
        if (!this.f10405g || this.f10403e == i10) {
            return false;
        }
        this.f10403e = i10;
        a();
        return true;
    }

    public boolean e(int i10) {
        if (!this.f10404f || this.f10402d == i10) {
            return false;
        }
        this.f10402d = i10;
        a();
        return true;
    }
}
