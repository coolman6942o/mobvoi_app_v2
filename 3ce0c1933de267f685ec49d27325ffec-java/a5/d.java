package a5;

import android.content.Context;
import android.graphics.Bitmap;
import n5.k;
import q4.g;
import t4.c;
import u4.e;
/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class d implements g<Bitmap> {
    @Override // q4.g
    public final c<Bitmap> a(Context context, c<Bitmap> cVar, int i10, int i11) {
        if (k.s(i10, i11)) {
            e f10 = com.bumptech.glide.c.c(context).f();
            Bitmap bitmap = cVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap c10 = c(f10, bitmap, i10, i11);
            return bitmap.equals(c10) ? cVar : c.f(c10, f10);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(e eVar, Bitmap bitmap, int i10, int i11);
}
