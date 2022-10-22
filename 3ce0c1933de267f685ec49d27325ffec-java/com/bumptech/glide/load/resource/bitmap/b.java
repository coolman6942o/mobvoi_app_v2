package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;
import t4.c;
import u4.e;
import u4.f;
import z4.a;
/* compiled from: BitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class b extends a<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final e f8072b = new f();

    @Override // z4.a
    protected c<Bitmap> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new a5.c(decodeBitmap, this.f8072b);
    }
}
