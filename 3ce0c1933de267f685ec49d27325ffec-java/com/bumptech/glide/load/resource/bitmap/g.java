package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
import t4.c;
import u4.e;
import u4.f;
/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: classes.dex */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final e f8093a = new a();

    /* compiled from: DrawableToBitmapConverter.java */
    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // u4.f, u4.e
        public void c(Bitmap bitmap) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c<Bitmap> a(e eVar, Drawable drawable, int i10, int i11) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z10 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i10, i11);
            z10 = true;
        } else {
            bitmap = null;
        }
        if (!z10) {
            eVar = f8093a;
        }
        return a5.c.f(bitmap, eVar);
    }

    private static Bitmap b(e eVar, Drawable drawable, int i10, int i11) {
        if (i10 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i11 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i10 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i11 = drawable.getIntrinsicHeight();
            }
            Lock i12 = o.i();
            i12.lock();
            Bitmap d10 = eVar.d(i10, i11, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(d10);
                drawable.setBounds(0, 0, i10, i11);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return d10;
            } finally {
                i12.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
