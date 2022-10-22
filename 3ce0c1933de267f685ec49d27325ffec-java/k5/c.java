package k5;

import android.graphics.drawable.Drawable;
import j5.a;
import n5.k;
/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class c<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f29755a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29756b;

    /* renamed from: c  reason: collision with root package name */
    private a f29757c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // k5.i
    public final void b(h hVar) {
    }

    @Override // k5.i
    public void c(Drawable drawable) {
    }

    @Override // k5.i
    public final void d(a aVar) {
        this.f29757c = aVar;
    }

    @Override // k5.i
    public void e(Drawable drawable) {
    }

    @Override // k5.i
    public final a f() {
        return this.f29757c;
    }

    @Override // k5.i
    public final void h(h hVar) {
        hVar.g(this.f29755a, this.f29756b);
    }

    @Override // g5.i
    public void onDestroy() {
    }

    @Override // g5.i
    public void onStart() {
    }

    @Override // g5.i
    public void onStop() {
    }

    public c(int i10, int i11) {
        if (k.s(i10, i11)) {
            this.f29755a = i10;
            this.f29756b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }
}
