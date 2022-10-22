package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c5.d;
import com.bumptech.glide.load.b;
import t4.c;
import u4.e;
/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class m implements b<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f8110a;

    /* renamed from: b  reason: collision with root package name */
    private final e f8111b;

    public m(d dVar, e eVar) {
        this.f8110a = dVar;
        this.f8111b = eVar;
    }

    /* renamed from: c */
    public c<Bitmap> a(Uri uri, int i10, int i11, q4.e eVar) {
        c<Drawable> c10 = this.f8110a.a(uri, i10, i11, eVar);
        if (c10 == null) {
            return null;
        }
        return g.a(this.f8111b, c10.get(), i10, i11);
    }

    /* renamed from: d */
    public boolean b(Uri uri, q4.e eVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
