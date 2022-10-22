package f5;

import a5.i;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import n5.j;
import q4.e;
import t4.c;
/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f26353a;

    public b(Resources resources) {
        this.f26353a = (Resources) j.d(resources);
    }

    @Override // f5.e
    public c<BitmapDrawable> a(c<Bitmap> cVar, e eVar) {
        return i.f(this.f26353a, cVar);
    }
}
