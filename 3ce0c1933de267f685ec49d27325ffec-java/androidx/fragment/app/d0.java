package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import g0.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpecialEffectsController.java */
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f3113a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<e> f3114b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<e> f3115c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f3116d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f3117e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f3118a;

        a(d dVar) {
            this.f3118a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d0.this.f3114b.contains(this.f3118a)) {
                this.f3118a.e().a(this.f3118a.f().mView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f3120a;

        b(d dVar) {
            this.f3120a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f3114b.remove(this.f3120a);
            d0.this.f3115c.remove(this.f3120a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3122a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3123b;

        static {
            int[] iArr = new int[e.b.values().length];
            f3123b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3123b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3123b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f3122a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3122a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3122a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3122a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: h  reason: collision with root package name */
        private final t f3124h;

        d(e.c cVar, e.b bVar, t tVar, g0.c cVar2) {
            super(cVar, bVar, tVar.k(), cVar2);
            this.f3124h = tVar;
        }

        @Override // androidx.fragment.app.d0.e
        public void c() {
            super.c();
            this.f3124h.m();
        }

        @Override // androidx.fragment.app.d0.e
        void l() {
            if (g() == e.b.ADDING) {
                Fragment k10 = this.f3124h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f3124h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            } else if (g() == e.b.REMOVING) {
                Fragment k11 = this.f3124h.k();
                View requireView2 = k11.requireView();
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + k11);
                }
                requireView2.clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private c f3125a;

        /* renamed from: b  reason: collision with root package name */
        private b f3126b;

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f3127c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f3128d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<g0.c> f3129e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f3130f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3131g = false;

        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        class a implements c.a {
            a() {
            }

            @Override // g0.c.a
            public void onCancel() {
                e.this.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpecialEffectsController.java */
        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void a(View view) {
                int i10 = c.f3122a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i10 == 2) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i10 == 3) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i10 == 4) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        e(c cVar, b bVar, Fragment fragment, g0.c cVar2) {
            this.f3125a = cVar;
            this.f3126b = bVar;
            this.f3127c = fragment;
            cVar2.d(new a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f3128d.add(runnable);
        }

        final void b() {
            if (!h()) {
                this.f3130f = true;
                if (this.f3129e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f3129e).iterator();
                while (it.hasNext()) {
                    ((g0.c) it.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f3131g) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f3131g = true;
                for (Runnable runnable : this.f3128d) {
                    runnable.run();
                }
            }
        }

        public final void d(g0.c cVar) {
            if (this.f3129e.remove(cVar) && this.f3129e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f3125a;
        }

        public final Fragment f() {
            return this.f3127c;
        }

        b g() {
            return this.f3126b;
        }

        final boolean h() {
            return this.f3130f;
        }

        final boolean i() {
            return this.f3131g;
        }

        public final void j(g0.c cVar) {
            l();
            this.f3129e.add(cVar);
        }

        final void k(c cVar, b bVar) {
            int i10 = c.f3123b[bVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3127c + " mFinalState = " + this.f3125a + " -> REMOVED. mLifecycleImpact  = " + this.f3126b + " to REMOVING.");
                    }
                    this.f3125a = c.REMOVED;
                    this.f3126b = b.REMOVING;
                } else if (i10 == 3 && this.f3125a != c.REMOVED) {
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3127c + " mFinalState = " + this.f3125a + " -> " + cVar + ". ");
                    }
                    this.f3125a = cVar;
                }
            } else if (this.f3125a == c.REMOVED) {
                if (FragmentManager.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3127c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f3126b + " to ADDING.");
                }
                this.f3125a = c.VISIBLE;
                this.f3126b = b.ADDING;
            }
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f3125a + "} {mLifecycleImpact = " + this.f3126b + "} {mFragment = " + this.f3127c + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(ViewGroup viewGroup) {
        this.f3113a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, t tVar) {
        synchronized (this.f3114b) {
            g0.c cVar2 = new g0.c();
            e h10 = h(tVar.k());
            if (h10 != null) {
                h10.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, tVar, cVar2);
            this.f3114b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f3114b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f3115c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.z0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 o(ViewGroup viewGroup, e0 e0Var) {
        int i10 = v0.b.f35561b;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof d0) {
            return (d0) tag;
        }
        d0 a10 = e0Var.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    private void q() {
        Iterator<e> it = this.f3114b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.b(next.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.c cVar, t tVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + tVar.k());
        }
        a(cVar, e.b.ADDING, tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(t tVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + tVar.k());
        }
        a(e.c.GONE, e.b.NONE, tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(t tVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + tVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(t tVar) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + tVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, tVar);
    }

    abstract void f(List<e> list, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (!this.f3117e) {
            if (!androidx.core.view.d0.W(this.f3113a)) {
                j();
                this.f3116d = false;
                return;
            }
            synchronized (this.f3114b) {
                if (!this.f3114b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3115c);
                    this.f3115c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f3115c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f3114b);
                    this.f3114b.clear();
                    this.f3115c.addAll(arrayList2);
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f3116d);
                    this.f3116d = false;
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean W = androidx.core.view.d0.W(this.f3113a);
        synchronized (this.f3114b) {
            q();
            Iterator<e> it = this.f3114b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f3115c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (W) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f3113a + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(eVar);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f3114b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (FragmentManager.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (W) {
                        str = "";
                    } else {
                        str = "Container " + this.f3113a + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(eVar2);
                    Log.v("FragmentManager", sb3.toString());
                }
                eVar2.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (this.f3117e) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f3117e = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.b l(t tVar) {
        e h10 = h(tVar.k());
        e.b g10 = h10 != null ? h10.g() : null;
        e i10 = i(tVar.k());
        return (i10 == null || !(g10 == null || g10 == e.b.NONE)) ? g10 : i10.g();
    }

    public ViewGroup m() {
        return this.f3113a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f3114b) {
            q();
            this.f3117e = false;
            int size = this.f3114b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f3114b.get(size);
                e.c c10 = e.c.c(eVar.f().mView);
                e.c e10 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e10 == cVar && c10 != cVar) {
                    this.f3117e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f3116d = z10;
    }
}
