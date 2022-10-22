package f5;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import u4.e;
/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f26354a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f26355b;

    /* renamed from: c  reason: collision with root package name */
    private final e<e5.c, byte[]> f26356c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<e5.c, byte[]> eVar3) {
        this.f26354a = eVar;
        this.f26355b = eVar2;
        this.f26356c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static t4.c<e5.c> b(t4.c<Drawable> cVar) {
        return cVar;
    }

    @Override // f5.e
    public t4.c<byte[]> a(t4.c<Drawable> cVar, q4.e eVar) {
        Drawable drawable = cVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f26355b.a(a5.c.f(((BitmapDrawable) drawable).getBitmap(), this.f26354a), eVar);
        }
        if (drawable instanceof e5.c) {
            return this.f26356c.a(b(cVar), eVar);
        }
        return null;
    }
}
