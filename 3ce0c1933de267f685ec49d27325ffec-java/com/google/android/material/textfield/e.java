package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EndIconDelegate.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f11523a;

    /* renamed from: b  reason: collision with root package name */
    Context f11524b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f11525c;

    /* renamed from: d  reason: collision with root package name */
    final int f11526d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TextInputLayout textInputLayout, int i10) {
        this.f11523a = textInputLayout;
        this.f11524b = textInputLayout.getContext();
        this.f11525c = textInputLayout.getEndIconView();
        this.f11526d = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i10) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return false;
    }
}
