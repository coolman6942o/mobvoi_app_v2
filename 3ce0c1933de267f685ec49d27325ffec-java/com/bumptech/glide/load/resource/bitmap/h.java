package com.bumptech.glide.load.resource.bitmap;

import a5.i;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;
import q4.g;
import t4.c;
import u4.e;
/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class h implements g<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final g<Bitmap> f8094b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8095c;

    public h(g<Bitmap> gVar, boolean z10) {
        this.f8094b = gVar;
        this.f8095c = z10;
    }

    private c<Drawable> d(Context context, c<Bitmap> cVar) {
        return i.f(context.getResources(), cVar);
    }

    @Override // q4.g
    public c<Drawable> a(Context context, c<Drawable> cVar, int i10, int i11) {
        e f10 = com.bumptech.glide.c.c(context).f();
        Drawable drawable = cVar.get();
        c<Bitmap> a10 = g.a(f10, drawable, i10, i11);
        if (a10 != null) {
            c<Bitmap> a11 = this.f8094b.a(context, a10, i10, i11);
            if (!a11.equals(a10)) {
                return d(context, a11);
            }
            a11.b();
            return cVar;
        } else if (!this.f8095c) {
            return cVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        this.f8094b.b(messageDigest);
    }

    public g<BitmapDrawable> c() {
        return this;
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f8094b.equals(((h) obj).f8094b);
        }
        return false;
    }

    @Override // q4.b
    public int hashCode() {
        return this.f8094b.hashCode();
    }
}
