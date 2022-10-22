package c0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.view.f;
/* compiled from: RoundedBitmapDrawableFactory.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: RoundedBitmapDrawableFactory.java */
    /* loaded from: classes.dex */
    private static class a extends b {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // c0.b
        void c(int i10, int i11, int i12, Rect rect, Rect rect2) {
            f.a(i10, i11, i12, rect, rect2, 0);
        }
    }

    public static b a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c0.a(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
