package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: OnBackPressedCallback.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f321a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f322b = new CopyOnWriteArrayList<>();

    public e(boolean z10) {
        this.f321a = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f322b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f321a;
    }

    public final void d() {
        Iterator<a> it = this.f322b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f322b.remove(aVar);
    }

    public final void f(boolean z10) {
        this.f321a = z10;
    }
}
