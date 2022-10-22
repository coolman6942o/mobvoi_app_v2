package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.b;
import java.io.IOException;
import java.io.InputStream;
import n5.a;
import q4.e;
import t4.c;
/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class k implements b<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8103a = new b();

    /* renamed from: c */
    public c<Bitmap> a(InputStream inputStream, int i10, int i11, e eVar) throws IOException {
        return this.f8103a.a(ImageDecoder.createSource(a.b(inputStream)), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, e eVar) throws IOException {
        return true;
    }
}
