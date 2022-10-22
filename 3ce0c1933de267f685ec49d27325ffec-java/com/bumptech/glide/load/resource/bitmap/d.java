package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import q4.e;
import t4.c;
/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class d implements b<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8074a = new b();

    /* renamed from: c */
    public c<Bitmap> a(ByteBuffer byteBuffer, int i10, int i11, e eVar) throws IOException {
        return this.f8074a.a(ImageDecoder.createSource(byteBuffer), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(ByteBuffer byteBuffer, e eVar) throws IOException {
        return true;
    }
}
