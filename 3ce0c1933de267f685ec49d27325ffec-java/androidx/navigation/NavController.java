package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.e;
import androidx.core.app.r;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i0;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.navigation.k;
import androidx.navigation.q;
import androidx.navigation.t;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class NavController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3414a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3415b;

    /* renamed from: c  reason: collision with root package name */
    private p f3416c;

    /* renamed from: d  reason: collision with root package name */
    m f3417d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f3418e;

    /* renamed from: f  reason: collision with root package name */
    private Parcelable[] f3419f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3420g;

    /* renamed from: i  reason: collision with root package name */
    private p f3422i;

    /* renamed from: j  reason: collision with root package name */
    private g f3423j;

    /* renamed from: h  reason: collision with root package name */
    final Deque<f> f3421h = new ArrayDeque();

    /* renamed from: k  reason: collision with root package name */
    private u f3424k = new u();

    /* renamed from: l  reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f3425l = new CopyOnWriteArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private final o f3426m = new n() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.n
        public void c(p pVar, Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.f3417d != null) {
                for (f fVar : navController.f3421h) {
                    fVar.e(event);
                }
            }
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final e f3427n = new a(false);

    /* renamed from: o  reason: collision with root package name */
    private boolean f3428o = true;

    /* loaded from: classes.dex */
    class a extends e {
        a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.e
        public void b() {
            NavController.this.w();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NavController navController, k kVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.f3414a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f3415b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        u uVar = this.f3424k;
        uVar.a(new n(uVar));
        this.f3424k.a(new androidx.navigation.b(this.f3414a));
    }

    private void J() {
        e eVar = this.f3427n;
        boolean z10 = true;
        if (!this.f3428o || j() <= 1) {
            z10 = false;
        }
        eVar.f(z10);
    }

    private boolean b() {
        while (!this.f3421h.isEmpty() && (this.f3421h.peekLast().b() instanceof m) && y(this.f3421h.peekLast().b().i(), true)) {
        }
        if (this.f3421h.isEmpty()) {
            return false;
        }
        k b10 = this.f3421h.peekLast().b();
        k kVar = null;
        if (b10 instanceof c) {
            Iterator<f> descendingIterator = this.f3421h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                k b11 = descendingIterator.next().b();
                if (!((b11 instanceof m) || (b11 instanceof c))) {
                    kVar = b11;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<f> descendingIterator2 = this.f3421h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            f next = descendingIterator2.next();
            Lifecycle.State c10 = next.c();
            k b12 = next.b();
            if (b10 != null && b12.i() == b10.i()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (c10 != state) {
                    hashMap.put(next, state);
                }
                b10 = b10.l();
            } else if (kVar == null || b12.i() != kVar.i()) {
                next.h(Lifecycle.State.CREATED);
            } else {
                if (c10 == Lifecycle.State.RESUMED) {
                    next.h(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (c10 != state2) {
                        hashMap.put(next, state2);
                    }
                }
                kVar = kVar.l();
            }
        }
        for (f fVar : this.f3421h) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(fVar);
            if (state3 != null) {
                fVar.h(state3);
            } else {
                fVar.i();
            }
        }
        f peekLast = this.f3421h.peekLast();
        Iterator<b> it = this.f3425l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.b(), peekLast.a());
        }
        return true;
    }

    private String e(int[] iArr) {
        m mVar;
        m mVar2 = this.f3417d;
        int i10 = 0;
        while (true) {
            k kVar = null;
            if (i10 >= iArr.length) {
                return null;
            }
            int i11 = iArr[i10];
            if (i10 != 0) {
                kVar = mVar2.u(i11);
            } else if (this.f3417d.i() == i11) {
                kVar = this.f3417d;
            }
            if (kVar == null) {
                return k.h(this.f3414a, i11);
            }
            if (i10 != iArr.length - 1) {
                while (true) {
                    mVar = (m) kVar;
                    if (!(mVar.u(mVar.z()) instanceof m)) {
                        break;
                    }
                    kVar = mVar.u(mVar.z());
                }
                mVar2 = mVar;
            }
            i10++;
        }
    }

    private int j() {
        int i10 = 0;
        for (f fVar : this.f3421h) {
            if (!(fVar.b() instanceof m)) {
                i10++;
            }
        }
        return i10;
    }

    private void s(k kVar, Bundle bundle, q qVar, t.a aVar) {
        boolean z10;
        boolean z11 = false;
        if (qVar == null || qVar.e() == -1) {
            z10 = false;
        } else {
            z10 = y(qVar.e(), qVar.f());
        }
        t e10 = this.f3424k.e(kVar.k());
        Bundle c10 = kVar.c(bundle);
        k b10 = e10.b(kVar, c10, qVar, aVar);
        if (b10 != null) {
            if (!(b10 instanceof c)) {
                while (!this.f3421h.isEmpty() && (this.f3421h.peekLast().b() instanceof c) && y(this.f3421h.peekLast().b().i(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (kVar instanceof m) {
                m mVar = b10;
                while (true) {
                    m l10 = mVar.l();
                    if (l10 != null) {
                        arrayDeque.addFirst(new f(this.f3414a, l10, c10, this.f3422i, this.f3423j));
                        if (!this.f3421h.isEmpty() && this.f3421h.getLast().b() == l10) {
                            y(l10.i(), true);
                        }
                    }
                    if (l10 == null || l10 == kVar) {
                        break;
                    }
                    mVar = l10;
                }
            }
            m b11 = arrayDeque.isEmpty() ? b10 : ((f) arrayDeque.getFirst()).b();
            while (b11 != null && d(b11.i()) == null) {
                b11 = b11.l();
                if (b11 != null) {
                    arrayDeque.addFirst(new f(this.f3414a, b11, c10, this.f3422i, this.f3423j));
                }
            }
            k b12 = arrayDeque.isEmpty() ? b10 : ((f) arrayDeque.getLast()).b();
            while (!this.f3421h.isEmpty() && (this.f3421h.getLast().b() instanceof m) && ((m) this.f3421h.getLast().b()).w(b12.i(), false) == null && y(this.f3421h.getLast().b().i(), true)) {
            }
            this.f3421h.addAll(arrayDeque);
            if (this.f3421h.isEmpty() || this.f3421h.getFirst().b() != this.f3417d) {
                this.f3421h.addFirst(new f(this.f3414a, this.f3417d, c10, this.f3422i, this.f3423j));
            }
            this.f3421h.add(new f(this.f3414a, b10, b10.c(c10), this.f3422i, this.f3423j));
        } else if (qVar != null && qVar.g()) {
            f peekLast = this.f3421h.peekLast();
            if (peekLast != null) {
                peekLast.f(c10);
            }
            z11 = true;
        }
        J();
        if (z10 || b10 != null || z11) {
            b();
        }
    }

    private void v(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f3418e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                t e10 = this.f3424k.e(next);
                Bundle bundle3 = this.f3418e.getBundle(next);
                if (bundle3 != null) {
                    e10.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f3419f;
        boolean z10 = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                k d10 = d(navBackStackEntryState.b());
                if (d10 != null) {
                    Bundle a10 = navBackStackEntryState.a();
                    if (a10 != null) {
                        a10.setClassLoader(this.f3414a.getClassLoader());
                    }
                    this.f3421h.add(new f(this.f3414a, d10, a10, this.f3422i, this.f3423j, navBackStackEntryState.d(), navBackStackEntryState.c()));
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + k.h(this.f3414a, navBackStackEntryState.b()) + " cannot be found from the current destination " + i());
                }
            }
            J();
            this.f3419f = null;
        }
        if (this.f3417d == null || !this.f3421h.isEmpty()) {
            b();
            return;
        }
        if (!this.f3420g && (activity = this.f3415b) != null && n(activity.getIntent())) {
            z10 = true;
        }
        if (!z10) {
            s(this.f3417d, bundle, null, null);
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.f3414a.getClassLoader());
            this.f3418e = bundle.getBundle("android-support-nav:controller:navigatorState");
            this.f3419f = bundle.getParcelableArray("android-support-nav:controller:backStack");
            this.f3420g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
    }

    public Bundle B() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, t<? extends k>> entry : this.f3424k.f().entrySet()) {
            String key = entry.getKey();
            Bundle d10 = entry.getValue().d();
            if (d10 != null) {
                arrayList.add(key);
                bundle2.putBundle(key, d10);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.f3421h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f3421h.size()];
            int i10 = 0;
            for (f fVar : this.f3421h) {
                i10++;
                parcelableArr[i10] = new NavBackStackEntryState(fVar);
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.f3420g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f3420g);
        }
        return bundle;
    }

    public void C(int i10) {
        D(i10, null);
    }

    public void D(int i10, Bundle bundle) {
        F(l().c(i10), bundle);
    }

    public void E(m mVar) {
        F(mVar, null);
    }

    public void F(m mVar, Bundle bundle) {
        m mVar2 = this.f3417d;
        if (mVar2 != null) {
            y(mVar2.i(), true);
        }
        this.f3417d = mVar;
        v(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(p pVar) {
        if (pVar != this.f3422i) {
            this.f3422i = pVar;
            pVar.getLifecycle().a(this.f3426m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.f3422i != null) {
            this.f3427n.d();
            onBackPressedDispatcher.a(this.f3422i, this.f3427n);
            this.f3422i.getLifecycle().c(this.f3426m);
            this.f3422i.getLifecycle().a(this.f3426m);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(i0 i0Var) {
        if (this.f3423j != g.b(i0Var)) {
            if (this.f3421h.isEmpty()) {
                this.f3423j = g.b(i0Var);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
    }

    public void a(b bVar) {
        if (!this.f3421h.isEmpty()) {
            f peekLast = this.f3421h.peekLast();
            bVar.a(this, peekLast.b(), peekLast.a());
        }
        this.f3425l.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z10) {
        this.f3428o = z10;
        J();
    }

    k d(int i10) {
        k kVar;
        m mVar;
        m mVar2 = this.f3417d;
        if (mVar2 == null) {
            return null;
        }
        if (mVar2.i() == i10) {
            return this.f3417d;
        }
        if (this.f3421h.isEmpty()) {
            kVar = this.f3417d;
        } else {
            kVar = this.f3421h.getLast().b();
        }
        if (kVar instanceof m) {
            mVar = kVar;
        } else {
            mVar = kVar.l();
        }
        return mVar.u(i10);
    }

    public f f(int i10) {
        f fVar;
        Iterator<f> descendingIterator = this.f3421h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                fVar = null;
                break;
            }
            fVar = descendingIterator.next();
            if (fVar.b().i() == i10) {
                break;
            }
        }
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("No destination with ID " + i10 + " is on the NavController's back stack. The current destination is " + i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context g() {
        return this.f3414a;
    }

    public f h() {
        if (this.f3421h.isEmpty()) {
            return null;
        }
        return this.f3421h.getLast();
    }

    public k i() {
        f h10 = h();
        if (h10 != null) {
            return h10.b();
        }
        return null;
    }

    public m k() {
        m mVar = this.f3417d;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public p l() {
        if (this.f3416c == null) {
            this.f3416c = new p(this.f3414a, this.f3424k);
        }
        return this.f3416c;
    }

    public u m() {
        return this.f3424k;
    }

    public boolean n(Intent intent) {
        m mVar;
        k.a m10;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (!((intArray != null && intArray.length != 0) || intent.getData() == null || (m10 = this.f3417d.m(new j(intent))) == null)) {
            k b10 = m10.b();
            int[] d10 = b10.d();
            bundle.putAll(b10.c(m10.c()));
            intArray = d10;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String e10 = e(intArray);
        if (e10 != null) {
            Log.i("NavController", "Could not find destination " + e10 + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i10 = 268435456 & flags;
        if (i10 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            r.e(this.f3414a).b(intent).h();
            Activity activity = this.f3415b;
            if (activity != null) {
                activity.finish();
                this.f3415b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i10 != 0) {
            if (!this.f3421h.isEmpty()) {
                y(this.f3417d.i(), true);
            }
            int i11 = 0;
            while (i11 < intArray.length) {
                i11++;
                int i12 = intArray[i11];
                k d11 = d(i12);
                if (d11 != null) {
                    s(d11, bundle, new q.a().b(0).c(0).a(), null);
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.h(this.f3414a, i12) + " cannot be found from the current destination " + i());
                }
            }
            return true;
        } else {
            m mVar2 = this.f3417d;
            int i13 = 0;
            while (i13 < intArray.length) {
                int i14 = intArray[i13];
                k u10 = i13 == 0 ? this.f3417d : mVar2.u(i14);
                if (u10 != null) {
                    if (i13 != intArray.length - 1) {
                        while (true) {
                            mVar = (m) u10;
                            if (!(mVar.u(mVar.z()) instanceof m)) {
                                break;
                            }
                            u10 = mVar.u(mVar.z());
                        }
                        mVar2 = mVar;
                    } else {
                        s(u10, u10.c(bundle), new q.a().g(this.f3417d.i(), true).b(0).c(0).a(), null);
                    }
                    i13++;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.h(this.f3414a, i14) + " cannot be found in graph " + mVar2);
                }
            }
            this.f3420g = true;
            return true;
        }
    }

    public void o(int i10) {
        p(i10, null);
    }

    public void p(int i10, Bundle bundle) {
        q(i10, bundle, null);
    }

    public void q(int i10, Bundle bundle, q qVar) {
        r(i10, bundle, qVar, null);
    }

    public void r(int i10, Bundle bundle, q qVar, t.a aVar) {
        k kVar;
        int i11;
        if (this.f3421h.isEmpty()) {
            kVar = this.f3417d;
        } else {
            kVar = this.f3421h.getLast().b();
        }
        if (kVar != null) {
            d e10 = kVar.e(i10);
            Bundle bundle2 = null;
            if (e10 != null) {
                if (qVar == null) {
                    qVar = e10.c();
                }
                i11 = e10.b();
                Bundle a10 = e10.a();
                if (a10 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(a10);
                }
            } else {
                i11 = i10;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i11 == 0 && qVar != null && qVar.e() != -1) {
                x(qVar.e(), qVar.f());
            } else if (i11 != 0) {
                k d10 = d(i11);
                if (d10 == null) {
                    String h10 = k.h(this.f3414a, i11);
                    if (e10 != null) {
                        throw new IllegalArgumentException("Navigation destination " + h10 + " referenced from action " + k.h(this.f3414a, i10) + " cannot be found from the current destination " + kVar);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + h10 + " cannot be found from the current destination " + kVar);
                }
                s(d10, bundle2, qVar, aVar);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public void t(l lVar) {
        p(lVar.b(), lVar.a());
    }

    public boolean u() {
        if (j() != 1) {
            return w();
        }
        k i10 = i();
        int i11 = i10.i();
        for (m l10 = i10.l(); l10 != null; l10 = l10.l()) {
            if (l10.z() != i11) {
                Bundle bundle = new Bundle();
                Activity activity = this.f3415b;
                if (!(activity == null || activity.getIntent() == null || this.f3415b.getIntent().getData() == null)) {
                    bundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.f3415b.getIntent());
                    k.a m10 = this.f3417d.m(new j(this.f3415b.getIntent()));
                    if (m10 != null) {
                        bundle.putAll(m10.b().c(m10.c()));
                    }
                }
                new i(this).d(l10.i()).c(bundle).a().h();
                Activity activity2 = this.f3415b;
                if (activity2 != null) {
                    activity2.finish();
                }
                return true;
            }
            i11 = l10.i();
        }
        return false;
    }

    public boolean w() {
        if (this.f3421h.isEmpty()) {
            return false;
        }
        return x(i().i(), true);
    }

    public boolean x(int i10, boolean z10) {
        return y(i10, z10) && b();
    }

    boolean y(int i10, boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f3421h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<f> descendingIterator = this.f3421h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z11 = false;
                break;
            }
            k b10 = descendingIterator.next().b();
            t e10 = this.f3424k.e(b10.k());
            if (z10 || b10.i() != i10) {
                arrayList.add(e10);
            }
            if (b10.i() == i10) {
                z11 = true;
                break;
            }
        }
        if (!z11) {
            Log.i("NavController", "Ignoring popBackStack to destination " + k.h(this.f3414a, i10) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((t) it.next()).e()) {
            f removeLast = this.f3421h.removeLast();
            if (removeLast.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                removeLast.h(Lifecycle.State.DESTROYED);
            }
            g gVar = this.f3423j;
            if (gVar != null) {
                gVar.a(removeLast.f3453f);
            }
            z12 = true;
        }
        J();
        return z12;
    }

    public void z(b bVar) {
        this.f3425l.remove(bVar);
    }
}
