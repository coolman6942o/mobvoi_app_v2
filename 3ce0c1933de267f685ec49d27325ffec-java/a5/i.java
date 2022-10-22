package a5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import n5.j;
import t4.b;
import t4.c;
/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class i implements c<BitmapDrawable>, b {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f98a;

    /* renamed from: b  reason: collision with root package name */
    private final c<Bitmap> f99b;

    private i(Resources resources, c<Bitmap> cVar) {
        this.f98a = (Resources) j.d(resources);
        this.f99b = (c) j.d(cVar);
    }

    public static c<BitmapDrawable> f(Resources resources, c<Bitmap> cVar) {
        if (cVar == null) {
            return null;
        }
        return new i(resources, cVar);
    }

    @Override // t4.b
    public void a() {
        c<Bitmap> cVar = this.f99b;
        if (cVar instanceof b) {
            ((b) cVar).a();
        }
    }

    @Override // t4.c
    public void b() {
        this.f99b.b();
    }

    @Override // t4.c
    public int c() {
        return this.f99b.c();
    }

    @Override // t4.c
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    /* renamed from: e */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f98a, this.f99b.get());
    }
}
