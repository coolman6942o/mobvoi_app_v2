package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuHostHelper.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f2575a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<n> f2576b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<n, a> f2577c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MenuHostHelper.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f2578a;

        /* renamed from: b  reason: collision with root package name */
        private n f2579b;

        a(Lifecycle lifecycle, n nVar) {
            this.f2578a = lifecycle;
            this.f2579b = nVar;
            lifecycle.a(nVar);
        }

        void a() {
            this.f2578a.c(this.f2579b);
            this.f2579b = null;
        }
    }

    public l(Runnable runnable) {
        this.f2575a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(n nVar, p pVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            j(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, n nVar, p pVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(nVar);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            j(nVar);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.f2576b.remove(nVar);
            this.f2575a.run();
        }
    }

    public void c(n nVar) {
        this.f2576b.add(nVar);
        this.f2575a.run();
    }

    public void d(final n nVar, p pVar) {
        c(nVar);
        Lifecycle lifecycle = pVar.getLifecycle();
        a remove = this.f2577c.remove(nVar);
        if (remove != null) {
            remove.a();
        }
        this.f2577c.put(nVar, new a(lifecycle, new n() { // from class: androidx.core.view.j
            @Override // androidx.lifecycle.n
            public final void c(p pVar2, Lifecycle.Event event) {
                l.this.f(nVar, pVar2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(final n nVar, p pVar, final Lifecycle.State state) {
        Lifecycle lifecycle = pVar.getLifecycle();
        a remove = this.f2577c.remove(nVar);
        if (remove != null) {
            remove.a();
        }
        this.f2577c.put(nVar, new a(lifecycle, new n() { // from class: androidx.core.view.k
            @Override // androidx.lifecycle.n
            public final void c(p pVar2, Lifecycle.Event event) {
                l.this.g(state, nVar, pVar2, event);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<n> it = this.f2576b.iterator();
        while (it.hasNext()) {
            it.next().b(menu, menuInflater);
        }
    }

    public boolean i(MenuItem menuItem) {
        Iterator<n> it = this.f2576b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void j(n nVar) {
        this.f2576b.remove(nVar);
        a remove = this.f2577c.remove(nVar);
        if (remove != null) {
            remove.a();
        }
        this.f2575a.run();
    }
}
