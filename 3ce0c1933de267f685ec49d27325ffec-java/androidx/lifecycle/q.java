package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import l.b;
/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class q extends Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private l.a<o, a> f3324a;

    /* renamed from: b  reason: collision with root package name */
    private Lifecycle.State f3325b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<p> f3326c;

    /* renamed from: d  reason: collision with root package name */
    private int f3327d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3328e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3329f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f3330g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3331h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Lifecycle.State f3332a;

        /* renamed from: b  reason: collision with root package name */
        n f3333b;

        a(o oVar, Lifecycle.State state) {
            this.f3333b = t.f(oVar);
            this.f3332a = state;
        }

        void a(p pVar, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.f3332a = q.k(this.f3332a, targetState);
            this.f3333b.c(pVar, event);
            this.f3332a = targetState;
        }
    }

    public q(p pVar) {
        this(pVar, true);
    }

    private void d(p pVar) {
        Iterator<Map.Entry<o, a>> descendingIterator = this.f3324a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f3329f) {
            Map.Entry<o, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.f3332a.compareTo(this.f3325b) > 0 && !this.f3329f && this.f3324a.contains(next.getKey())) {
                Lifecycle.Event downFrom = Lifecycle.Event.downFrom(value.f3332a);
                if (downFrom != null) {
                    n(downFrom.getTargetState());
                    value.a(pVar, downFrom);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + value.f3332a);
                }
            }
        }
    }

    private Lifecycle.State e(o oVar) {
        Map.Entry<o, a> h10 = this.f3324a.h(oVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = h10 != null ? h10.getValue().f3332a : null;
        if (!this.f3330g.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f3330g;
            state = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f3325b, state2), state);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (this.f3331h && !k.a.f().c()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void g(p pVar) {
        b<o, a>.d c10 = this.f3324a.c();
        while (c10.hasNext() && !this.f3329f) {
            Map.Entry next = c10.next();
            a aVar = (a) next.getValue();
            while (aVar.f3332a.compareTo(this.f3325b) < 0 && !this.f3329f && this.f3324a.contains((o) next.getKey())) {
                n(aVar.f3332a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(aVar.f3332a);
                if (upFrom != null) {
                    aVar.a(pVar, upFrom);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3332a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f3324a.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f3324a.a().getValue().f3332a;
        Lifecycle.State state2 = this.f3324a.d().getValue().f3332a;
        return state == state2 && this.f3325b == state2;
    }

    static Lifecycle.State k(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void l(Lifecycle.State state) {
        if (this.f3325b != state) {
            this.f3325b = state;
            if (this.f3328e || this.f3327d != 0) {
                this.f3329f = true;
                return;
            }
            this.f3328e = true;
            p();
            this.f3328e = false;
        }
    }

    private void m() {
        ArrayList<Lifecycle.State> arrayList = this.f3330g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(Lifecycle.State state) {
        this.f3330g.add(state);
    }

    private void p() {
        p pVar = this.f3326c.get();
        if (pVar != null) {
            while (!i()) {
                this.f3329f = false;
                if (this.f3325b.compareTo(this.f3324a.a().getValue().f3332a) < 0) {
                    d(pVar);
                }
                Map.Entry<o, a> d10 = this.f3324a.d();
                if (!this.f3329f && d10 != null && this.f3325b.compareTo(d10.getValue().f3332a) > 0) {
                    g(pVar);
                }
            }
            this.f3329f = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(o oVar) {
        p pVar;
        f("addObserver");
        Lifecycle.State state = this.f3325b;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        a aVar = new a(oVar, state2);
        if (this.f3324a.f(oVar, aVar) == null && (pVar = this.f3326c.get()) != null) {
            boolean z10 = this.f3327d != 0 || this.f3328e;
            Lifecycle.State e10 = e(oVar);
            this.f3327d++;
            while (aVar.f3332a.compareTo(e10) < 0 && this.f3324a.contains(oVar)) {
                n(aVar.f3332a);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(aVar.f3332a);
                if (upFrom != null) {
                    aVar.a(pVar, upFrom);
                    m();
                    e10 = e(oVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3332a);
                }
            }
            if (!z10) {
                p();
            }
            this.f3327d--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f3325b;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void c(o oVar) {
        f("removeObserver");
        this.f3324a.g(oVar);
    }

    public void h(Lifecycle.Event event) {
        f("handleLifecycleEvent");
        l(event.getTargetState());
    }

    @Deprecated
    public void j(Lifecycle.State state) {
        f("markState");
        o(state);
    }

    public void o(Lifecycle.State state) {
        f("setCurrentState");
        l(state);
    }

    private q(p pVar, boolean z10) {
        this.f3324a = new l.a<>();
        this.f3327d = 0;
        this.f3328e = false;
        this.f3329f = false;
        this.f3330g = new ArrayList<>();
        this.f3326c = new WeakReference<>(pVar);
        this.f3325b = Lifecycle.State.INITIALIZED;
        this.f3331h = z10;
    }
}
