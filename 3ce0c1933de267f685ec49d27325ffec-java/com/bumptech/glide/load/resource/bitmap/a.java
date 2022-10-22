package com.bumptech.glide.load.resource.bitmap;

import a5.i;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b;
import java.io.IOException;
import n5.j;
import q4.e;
import t4.c;
/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: classes.dex */
public class a<DataType> implements b<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final b<DataType, Bitmap> f8070a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f8071b;

    public a(Resources resources, b<DataType, Bitmap> bVar) {
        this.f8071b = (Resources) j.d(resources);
        this.f8070a = (b) j.d(bVar);
    }

    @Override // com.bumptech.glide.load.b
    public c<BitmapDrawable> a(DataType datatype, int i10, int i11, e eVar) throws IOException {
        return i.f(this.f8071b, this.f8070a.a(datatype, i10, i11, eVar));
    }

    @Override // com.bumptech.glide.load.b
    public boolean b(DataType datatype, e eVar) throws IOException {
        return this.f8070a.b(datatype, eVar);
    }
}
