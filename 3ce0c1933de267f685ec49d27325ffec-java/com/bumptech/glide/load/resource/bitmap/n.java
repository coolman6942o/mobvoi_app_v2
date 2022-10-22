package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.resource.bitmap.f;
import java.io.IOException;
import java.io.InputStream;
import n5.d;
import n5.h;
import t4.c;
import u4.e;
/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class n implements b<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final f f8112a;

    /* renamed from: b  reason: collision with root package name */
    private final u4.b f8113b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static class a implements f.b {

        /* renamed from: a  reason: collision with root package name */
        private final l f8114a;

        /* renamed from: b  reason: collision with root package name */
        private final d f8115b;

        a(l lVar, d dVar) {
            this.f8114a = lVar;
            this.f8115b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f.b
        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException c10 = this.f8115b.c();
            if (c10 != null) {
                if (bitmap != null) {
                    eVar.c(bitmap);
                }
                throw c10;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f.b
        public void b() {
            this.f8114a.d();
        }
    }

    public n(f fVar, u4.b bVar) {
        this.f8112a = fVar;
        this.f8113b = bVar;
    }

    /* renamed from: c */
    public c<Bitmap> a(InputStream inputStream, int i10, int i11, q4.e eVar) throws IOException {
        l lVar;
        boolean z10;
        if (inputStream instanceof l) {
            lVar = (l) inputStream;
            z10 = false;
        } else {
            z10 = true;
            lVar = new l(inputStream, this.f8113b);
        }
        d d10 = d.d(lVar);
        try {
            return this.f8112a.e(new h(d10), i10, i11, eVar, new a(lVar, d10));
        } finally {
            d10.h();
            if (z10) {
                lVar.h();
            }
        }
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, q4.e eVar) {
        return this.f8112a.m(inputStream);
    }
}
