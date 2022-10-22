package e5;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import n5.j;
import q4.g;
import t4.c;
/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class f implements g<c> {

    /* renamed from: b  reason: collision with root package name */
    private final g<Bitmap> f25799b;

    public f(g<Bitmap> gVar) {
        this.f25799b = (g) j.d(gVar);
    }

    @Override // q4.g
    public c<c> a(Context context, c<c> cVar, int i10, int i11) {
        c cVar2 = cVar.get();
        c<Bitmap> cVar3 = new a5.c(cVar2.e(), com.bumptech.glide.c.c(context).f());
        c<Bitmap> a10 = this.f25799b.a(context, cVar3, i10, i11);
        if (!cVar3.equals(a10)) {
            cVar3.b();
        }
        cVar2.m(this.f25799b, a10.get());
        return cVar;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        this.f25799b.b(messageDigest);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f25799b.equals(((f) obj).f25799b);
        }
        return false;
    }

    @Override // q4.b
    public int hashCode() {
        return this.f25799b.hashCode();
    }
}
