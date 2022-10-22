package com.amap.api.maps2d.model;

import android.graphics.Bitmap;
/* compiled from: BitmapDescriptorFactory.java */
/* loaded from: classes.dex */
public final class a {
    public static BitmapDescriptor a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap);
        } catch (Throwable th2) {
            com.amap.api.mapcore2d.a.e(th2, "BitmapDescriptorFactory", "fromBitmap");
            return null;
        }
    }
}
