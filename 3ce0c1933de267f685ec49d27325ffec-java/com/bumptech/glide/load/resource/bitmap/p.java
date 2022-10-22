package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b;
import n5.k;
import q4.e;
import t4.c;
/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class p implements b<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f8122a;

        a(Bitmap bitmap) {
            this.f8122a = bitmap;
        }

        /* renamed from: a */
        public Bitmap get() {
            return this.f8122a;
        }

        @Override // t4.c
        public void b() {
        }

        @Override // t4.c
        public int c() {
            return k.g(this.f8122a);
        }

        @Override // t4.c
        public Class<Bitmap> d() {
            return Bitmap.class;
        }
    }

    /* renamed from: c */
    public c<Bitmap> a(Bitmap bitmap, int i10, int i11, e eVar) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean b(Bitmap bitmap, e eVar) {
        return true;
    }
}
