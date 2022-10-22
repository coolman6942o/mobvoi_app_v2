package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NoEndIconDelegate.java */
/* loaded from: classes.dex */
public class h extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f11523a.setEndIconOnClickListener(null);
        this.f11523a.setEndIconDrawable((Drawable) null);
        this.f11523a.setEndIconContentDescription((CharSequence) null);
    }
}
