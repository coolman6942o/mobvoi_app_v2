package c5;

import android.graphics.drawable.Drawable;
/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t4.c<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // t4.c
    public void b() {
    }

    @Override // t4.c
    public int c() {
        return Math.max(1, this.f5578a.getIntrinsicWidth() * this.f5578a.getIntrinsicHeight() * 4);
    }

    @Override // t4.c
    public Class<Drawable> d() {
        return this.f5578a.getClass();
    }
}
