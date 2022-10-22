package n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] G = {2, 1, 3, 4};
    private static final g H = new a();
    private static ThreadLocal<androidx.collection.a<Animator, d>> I = new ThreadLocal<>();
    p C;
    private e D;
    private androidx.collection.a<String, String> E;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<s> f30959t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<s> f30960u;

    /* renamed from: a  reason: collision with root package name */
    private String f30940a = getClass().getName();

    /* renamed from: b  reason: collision with root package name */
    private long f30941b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f30942c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f30943d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Integer> f30944e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<View> f30945f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f30946g = null;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Class<?>> f30947h = null;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Integer> f30948i = null;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<View> f30949j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Class<?>> f30950k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<String> f30951l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<Integer> f30952m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<View> f30953n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<Class<?>> f30954o = null;

    /* renamed from: p  reason: collision with root package name */
    private t f30955p = new t();

    /* renamed from: q  reason: collision with root package name */
    private t f30956q = new t();

    /* renamed from: r  reason: collision with root package name */
    q f30957r = null;

    /* renamed from: s  reason: collision with root package name */
    private int[] f30958s = G;

    /* renamed from: v  reason: collision with root package name */
    boolean f30961v = false;

    /* renamed from: w  reason: collision with root package name */
    ArrayList<Animator> f30962w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private int f30963x = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f30964y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f30965z = false;
    private ArrayList<f> A = null;
    private ArrayList<Animator> B = new ArrayList<>();
    private g F = H;

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // n1.g
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f30966a;

        b(androidx.collection.a aVar) {
            this.f30966a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f30966a.remove(animator);
            m.this.f30962w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.f30962w.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f30969a;

        /* renamed from: b  reason: collision with root package name */
        String f30970b;

        /* renamed from: c  reason: collision with root package name */
        s f30971c;

        /* renamed from: d  reason: collision with root package name */
        m0 f30972d;

        /* renamed from: e  reason: collision with root package name */
        m f30973e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.f30969a = view;
            this.f30970b = str;
            this.f30971c = sVar;
            this.f30972d = m0Var;
            this.f30973e = mVar;
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.f30986a.get(str);
        Object obj2 = sVar2.f30986a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void I(androidx.collection.a<View, s> aVar, androidx.collection.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && G(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && G(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.f30959t.add(sVar);
                    this.f30960u.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void J(androidx.collection.a<View, s> aVar, androidx.collection.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View j10 = aVar.j(size);
            if (j10 != null && G(j10) && (remove = aVar2.remove(j10)) != null && G(remove.f30987b)) {
                this.f30959t.add(aVar.l(size));
                this.f30960u.add(remove);
            }
        }
    }

    private void K(androidx.collection.a<View, s> aVar, androidx.collection.a<View, s> aVar2, androidx.collection.d<View> dVar, androidx.collection.d<View> dVar2) {
        View f10;
        int n10 = dVar.n();
        for (int i10 = 0; i10 < n10; i10++) {
            View o10 = dVar.o(i10);
            if (o10 != null && G(o10) && (f10 = dVar2.f(dVar.j(i10))) != null && G(f10)) {
                s sVar = aVar.get(o10);
                s sVar2 = aVar2.get(f10);
                if (!(sVar == null || sVar2 == null)) {
                    this.f30959t.add(sVar);
                    this.f30960u.add(sVar2);
                    aVar.remove(o10);
                    aVar2.remove(f10);
                }
            }
        }
    }

    private void L(androidx.collection.a<View, s> aVar, androidx.collection.a<View, s> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View n10 = aVar3.n(i10);
            if (n10 != null && G(n10) && (view = aVar4.get(aVar3.j(i10))) != null && G(view)) {
                s sVar = aVar.get(n10);
                s sVar2 = aVar2.get(view);
                if (!(sVar == null || sVar2 == null)) {
                    this.f30959t.add(sVar);
                    this.f30960u.add(sVar2);
                    aVar.remove(n10);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void M(t tVar, t tVar2) {
        androidx.collection.a<View, s> aVar = new androidx.collection.a<>(tVar.f30989a);
        androidx.collection.a<View, s> aVar2 = new androidx.collection.a<>(tVar2.f30989a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f30958s;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    J(aVar, aVar2);
                } else if (i11 == 2) {
                    L(aVar, aVar2, tVar.f30992d, tVar2.f30992d);
                } else if (i11 == 3) {
                    I(aVar, aVar2, tVar.f30990b, tVar2.f30990b);
                } else if (i11 == 4) {
                    K(aVar, aVar2, tVar.f30991c, tVar2.f30991c);
                }
                i10++;
            } else {
                c(aVar, aVar2);
                return;
            }
        }
    }

    private void S(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(androidx.collection.a<View, s> aVar, androidx.collection.a<View, s> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            s n10 = aVar.n(i10);
            if (G(n10.f30987b)) {
                this.f30959t.add(n10);
                this.f30960u.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            s n11 = aVar2.n(i11);
            if (G(n11.f30987b)) {
                this.f30960u.add(n11);
                this.f30959t.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f30989a.put(view, sVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (tVar.f30990b.indexOfKey(id2) >= 0) {
                tVar.f30990b.put(id2, null);
            } else {
                tVar.f30990b.put(id2, view);
            }
        }
        String N = d0.N(view);
        if (N != null) {
            if (tVar.f30992d.containsKey(N)) {
                tVar.f30992d.put(N, null);
            } else {
                tVar.f30992d.put(N, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f30991c.i(itemIdAtPosition) >= 0) {
                    View f10 = tVar.f30991c.f(itemIdAtPosition);
                    if (f10 != null) {
                        d0.D0(f10, false);
                        tVar.f30991c.k(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                d0.D0(view, true);
                tVar.f30991c.k(itemIdAtPosition, view);
            }
        }
    }

    private void g(View view, boolean z10) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.f30948i;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.f30949j;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.f30950k;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            if (this.f30950k.get(i10).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        s sVar = new s(view);
                        if (z10) {
                            j(sVar);
                        } else {
                            f(sVar);
                        }
                        sVar.f30988c.add(this);
                        i(sVar);
                        if (z10) {
                            d(this.f30955p, view, sVar);
                        } else {
                            d(this.f30956q, view, sVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f30952m;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.f30953n;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.f30954o;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    for (int i11 = 0; i11 < size2; i11++) {
                                        if (this.f30954o.get(i11).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                    g(viewGroup.getChildAt(i12), z10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static androidx.collection.a<Animator, d> x() {
        androidx.collection.a<Animator, d> aVar = I.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        I.set(aVar2);
        return aVar2;
    }

    public List<String> A() {
        return this.f30946g;
    }

    public List<Class<?>> B() {
        return this.f30947h;
    }

    public List<View> C() {
        return this.f30945f;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z10) {
        q qVar = this.f30957r;
        if (qVar != null) {
            return qVar.E(view, z10);
        }
        return (z10 ? this.f30955p : this.f30956q).f30989a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] D = D();
        if (D != null) {
            for (String str : D) {
                if (!H(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : sVar.f30986a.keySet()) {
            if (H(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f30948i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f30949j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f30950k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f30950k.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.f30951l == null || d0.N(view) == null || !this.f30951l.contains(d0.N(view)))) {
            return false;
        }
        if ((this.f30944e.size() == 0 && this.f30945f.size() == 0 && (((arrayList = this.f30947h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f30946g) == null || arrayList2.isEmpty()))) || this.f30944e.contains(Integer.valueOf(id2)) || this.f30945f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f30946g;
        if (arrayList6 != null && arrayList6.contains(d0.N(view))) {
            return true;
        }
        if (this.f30947h != null) {
            for (int i11 = 0; i11 < this.f30947h.size(); i11++) {
                if (this.f30947h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N(View view) {
        if (!this.f30965z) {
            androidx.collection.a<Animator, d> x10 = x();
            int size = x10.size();
            m0 d10 = c0.d(view);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d n10 = x10.n(i10);
                if (n10.f30969a != null && d10.equals(n10.f30972d)) {
                    n1.a.b(x10.j(i10));
                }
            }
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size2 = arrayList2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((f) arrayList2.get(i11)).c(this);
                }
            }
            this.f30964y = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(ViewGroup viewGroup) {
        d dVar;
        this.f30959t = new ArrayList<>();
        this.f30960u = new ArrayList<>();
        M(this.f30955p, this.f30956q);
        androidx.collection.a<Animator, d> x10 = x();
        int size = x10.size();
        m0 d10 = c0.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator j10 = x10.j(i10);
            if (!(j10 == null || (dVar = x10.get(j10)) == null || dVar.f30969a == null || !d10.equals(dVar.f30972d))) {
                s sVar = dVar.f30971c;
                View view = dVar.f30969a;
                s E = E(view, true);
                s t10 = t(view, true);
                if (E == null && t10 == null) {
                    t10 = this.f30956q.f30989a.get(view);
                }
                if (!(E == null && t10 == null) && dVar.f30973e.F(sVar, t10)) {
                    if (j10.isRunning() || j10.isStarted()) {
                        j10.cancel();
                    } else {
                        x10.remove(j10);
                    }
                }
            }
        }
        o(viewGroup, this.f30955p, this.f30956q, this.f30959t, this.f30960u);
        T();
    }

    public m P(f fVar) {
        ArrayList<f> arrayList = this.A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.A.size() == 0) {
            this.A = null;
        }
        return this;
    }

    public m Q(View view) {
        this.f30945f.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.f30964y) {
            if (!this.f30965z) {
                androidx.collection.a<Animator, d> x10 = x();
                int size = x10.size();
                m0 d10 = c0.d(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    d n10 = x10.n(i10);
                    if (n10.f30969a != null && d10.equals(n10.f30972d)) {
                        n1.a.c(x10.j(i10));
                    }
                }
                ArrayList<f> arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((f) arrayList2.get(i11)).e(this);
                    }
                }
            }
            this.f30964y = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        a0();
        androidx.collection.a<Animator, d> x10 = x();
        Iterator<Animator> it = this.B.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (x10.containsKey(next)) {
                a0();
                S(next, x10);
            }
        }
        this.B.clear();
        p();
    }

    public m U(long j10) {
        this.f30942c = j10;
        return this;
    }

    public void V(e eVar) {
        this.D = eVar;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.f30943d = timeInterpolator;
        return this;
    }

    public void X(g gVar) {
        if (gVar == null) {
            this.F = H;
        } else {
            this.F = gVar;
        }
    }

    public void Y(p pVar) {
    }

    public m Z(long j10) {
        this.f30941b = j10;
        return this;
    }

    public m a(f fVar) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        if (this.f30963x == 0) {
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).a(this);
                }
            }
            this.f30965z = false;
        }
        this.f30963x++;
    }

    public m b(View view) {
        this.f30945f.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f30942c != -1) {
            str2 = str2 + "dur(" + this.f30942c + ") ";
        }
        if (this.f30941b != -1) {
            str2 = str2 + "dly(" + this.f30941b + ") ";
        }
        if (this.f30943d != null) {
            str2 = str2 + "interp(" + this.f30943d + ") ";
        }
        if (this.f30944e.size() <= 0 && this.f30945f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f30944e.size() > 0) {
            for (int i10 = 0; i10 < this.f30944e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f30944e.get(i10);
            }
        }
        if (this.f30945f.size() > 0) {
            for (int i11 = 0; i11 < this.f30945f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f30945f.get(i11);
            }
        }
        return str3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.f30962w.size() - 1; size >= 0; size--) {
            this.f30962w.get(size).cancel();
        }
        ArrayList<f> arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((f) arrayList2.get(i10)).d(this);
            }
        }
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void f(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(s sVar) {
    }

    public abstract void j(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ViewGroup viewGroup, boolean z10) {
        androidx.collection.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        l(z10);
        if ((this.f30944e.size() > 0 || this.f30945f.size() > 0) && (((arrayList = this.f30946g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f30947h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f30944e.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.f30944e.get(i10).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z10) {
                        j(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f30988c.add(this);
                    i(sVar);
                    if (z10) {
                        d(this.f30955p, findViewById, sVar);
                    } else {
                        d(this.f30956q, findViewById, sVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f30945f.size(); i11++) {
                View view = this.f30945f.get(i11);
                s sVar2 = new s(view);
                if (z10) {
                    j(sVar2);
                } else {
                    f(sVar2);
                }
                sVar2.f30988c.add(this);
                i(sVar2);
                if (z10) {
                    d(this.f30955p, view, sVar2);
                } else {
                    d(this.f30956q, view, sVar2);
                }
            }
        } else {
            g(viewGroup, z10);
        }
        if (!(z10 || (aVar = this.E) == null)) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.f30955p.f30992d.remove(this.E.j(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.f30955p.f30992d.put(this.E.n(i13), view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z10) {
        if (z10) {
            this.f30955p.f30989a.clear();
            this.f30955p.f30990b.clear();
            this.f30955p.f30991c.b();
            return;
        }
        this.f30956q.f30989a.clear();
        this.f30956q.f30990b.clear();
        this.f30956q.f30991c.b();
    }

    /* renamed from: m */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.B = new ArrayList<>();
            mVar.f30955p = new t();
            mVar.f30956q = new t();
            mVar.f30959t = null;
            mVar.f30960u = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i10;
        Animator animator;
        s sVar;
        View view;
        s sVar2;
        Animator animator2;
        androidx.collection.a<Animator, d> x10 = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            s sVar3 = arrayList.get(i11);
            s sVar4 = arrayList2.get(i11);
            if (sVar3 != null && !sVar3.f30988c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f30988c.contains(this)) {
                sVar4 = null;
            }
            if (!(sVar3 == null && sVar4 == null)) {
                if (sVar3 == null || sVar4 == null || F(sVar3, sVar4)) {
                    Animator n10 = n(viewGroup, sVar3, sVar4);
                    if (n10 != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f30987b;
                            String[] D = D();
                            if (D != null && D.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.f30989a.get(view2);
                                if (sVar5 != null) {
                                    for (int i12 = 0; i12 < D.length; i12++) {
                                        Map<String, Object> map = sVar2.f30986a;
                                        n10 = n10;
                                        String str = D[i12];
                                        size = size;
                                        Map<String, Object> map2 = sVar5.f30986a;
                                        sVar5 = sVar5;
                                        map.put(str, map2.get(D[i12]));
                                    }
                                }
                                animator2 = n10;
                                i10 = size;
                                int size2 = x10.size();
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= size2) {
                                        break;
                                    }
                                    d dVar = x10.get(x10.j(i13));
                                    if (dVar.f30971c != null && dVar.f30969a == view2 && dVar.f30970b.equals(u()) && dVar.f30971c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i13++;
                                }
                            } else {
                                i10 = size;
                                animator2 = n10;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            i10 = size;
                            view = sVar3.f30987b;
                            animator = n10;
                            sVar = null;
                        }
                        if (animator != null) {
                            x10.put(animator, new d(view, u(), this, c0.d(viewGroup), sVar));
                            this.B.add(animator);
                        }
                        i11++;
                        size = i10;
                    }
                    i10 = size;
                    i11++;
                    size = i10;
                }
            }
            i10 = size;
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                Animator animator3 = this.B.get(sparseIntArray.keyAt(i14));
                animator3.setStartDelay((sparseIntArray.valueAt(i14) - Long.MAX_VALUE) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        int i10 = this.f30963x - 1;
        this.f30963x = i10;
        if (i10 == 0) {
            ArrayList<f> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).b(this);
                }
            }
            for (int i12 = 0; i12 < this.f30955p.f30991c.n(); i12++) {
                View o10 = this.f30955p.f30991c.o(i12);
                if (o10 != null) {
                    d0.D0(o10, false);
                }
            }
            for (int i13 = 0; i13 < this.f30956q.f30991c.n(); i13++) {
                View o11 = this.f30956q.f30991c.o(i13);
                if (o11 != null) {
                    d0.D0(o11, false);
                }
            }
            this.f30965z = true;
        }
    }

    public long q() {
        return this.f30942c;
    }

    public e r() {
        return this.D;
    }

    public TimeInterpolator s() {
        return this.f30943d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s t(View view, boolean z10) {
        q qVar = this.f30957r;
        if (qVar != null) {
            return qVar.t(view, z10);
        }
        ArrayList<s> arrayList = z10 ? this.f30959t : this.f30960u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            s sVar = arrayList.get(i11);
            if (sVar == null) {
                return null;
            }
            if (sVar.f30987b == view) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 < 0) {
            return null;
        }
        return (z10 ? this.f30960u : this.f30959t).get(i10);
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f30940a;
    }

    public g v() {
        return this.F;
    }

    public p w() {
        return this.C;
    }

    public long y() {
        return this.f30941b;
    }

    public List<Integer> z() {
        return this.f30944e;
    }
}
