package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b6.b;
import q6.d;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f8860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap, boolean z10) {
        b.c(bitmap);
        c(new BitmapDrawable(context.getResources(), bitmap), z10, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Context context, d dVar, boolean z10) {
        int i10 = this.f8860a;
        c(i10 != 0 ? context.getResources().getDrawable(i10) : null, z10, false, false);
    }

    protected abstract void c(Drawable drawable, boolean z10, boolean z11, boolean z12);
}
