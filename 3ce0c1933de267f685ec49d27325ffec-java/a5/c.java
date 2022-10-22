package a5;

import android.graphics.Bitmap;
import n5.j;
import n5.k;
import t4.b;
import u4.e;
/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class c implements t4.c<Bitmap>, b {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f92a;

    /* renamed from: b  reason: collision with root package name */
    private final e f93b;

    public c(Bitmap bitmap, e eVar) {
        this.f92a = (Bitmap) j.e(bitmap, "Bitmap must not be null");
        this.f93b = (e) j.e(eVar, "BitmapPool must not be null");
    }

    public static c f(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, eVar);
    }

    @Override // t4.b
    public void a() {
        this.f92a.prepareToDraw();
    }

    @Override // t4.c
    public void b() {
        this.f93b.c(this.f92a);
    }

    @Override // t4.c
    public int c() {
        return k.g(this.f92a);
    }

    @Override // t4.c
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    /* renamed from: e */
    public Bitmap get() {
        return this.f92a;
    }
}
