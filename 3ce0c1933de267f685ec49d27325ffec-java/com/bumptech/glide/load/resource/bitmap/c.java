package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import n5.a;
import q4.e;
/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class c implements b<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final f f8073a;

    public c(f fVar) {
        this.f8073a = fVar;
    }

    /* renamed from: c */
    public t4.c<Bitmap> a(ByteBuffer byteBuffer, int i10, int i11, e eVar) throws IOException {
        return this.f8073a.d(a.f(byteBuffer), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(ByteBuffer byteBuffer, e eVar) {
        return this.f8073a.n(byteBuffer);
    }
}
