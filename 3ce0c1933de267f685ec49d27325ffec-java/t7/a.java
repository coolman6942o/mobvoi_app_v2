package t7;

import android.graphics.Typeface;
/* compiled from: CancelableFontCallback.java */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f35065a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0503a f35066b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35067c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: t7.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0503a {
        void a(Typeface typeface);
    }

    public a(AbstractC0503a aVar, Typeface typeface) {
        this.f35065a = typeface;
        this.f35066b = aVar;
    }

    private void d(Typeface typeface) {
        if (!this.f35067c) {
            this.f35066b.a(typeface);
        }
    }

    @Override // t7.f
    public void a(int i10) {
        d(this.f35065a);
    }

    @Override // t7.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f35067c = true;
    }
}
