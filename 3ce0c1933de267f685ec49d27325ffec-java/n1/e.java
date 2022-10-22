package n1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.z;
import g0.c;
import java.util.ArrayList;
import java.util.List;
import n1.m;
/* compiled from: FragmentTransitionSupport.java */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends z {

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class b implements m.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f30890a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f30891b;

        b(e eVar, View view, ArrayList arrayList) {
            this.f30890a = view;
            this.f30891b = arrayList;
        }

        @Override // n1.m.f
        public void a(m mVar) {
            mVar.P(this);
            mVar.a(this);
        }

        @Override // n1.m.f
        public void b(m mVar) {
            mVar.P(this);
            this.f30890a.setVisibility(8);
            int size = this.f30891b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f30891b.get(i10)).setVisibility(0);
            }
        }

        @Override // n1.m.f
        public void c(m mVar) {
        }

        @Override // n1.m.f
        public void d(m mVar) {
        }

        @Override // n1.m.f
        public void e(m mVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class c extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f30892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f30893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f30894c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f30895d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f30896e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f30897f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f30892a = obj;
            this.f30893b = arrayList;
            this.f30894c = obj2;
            this.f30895d = arrayList2;
            this.f30896e = obj3;
            this.f30897f = arrayList3;
        }

        @Override // n1.n, n1.m.f
        public void a(m mVar) {
            Object obj = this.f30892a;
            if (obj != null) {
                e.this.w(obj, this.f30893b, null);
            }
            Object obj2 = this.f30894c;
            if (obj2 != null) {
                e.this.w(obj2, this.f30895d, null);
            }
            Object obj3 = this.f30896e;
            if (obj3 != null) {
                e.this.w(obj3, this.f30897f, null);
            }
        }

        @Override // n1.m.f
        public void b(m mVar) {
            mVar.P(this);
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f30899a;

        d(e eVar, m mVar) {
            this.f30899a = mVar;
        }

        @Override // g0.c.a
        public void onCancel() {
            this.f30899a.cancel();
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: n1.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0406e implements m.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f30900a;

        C0406e(e eVar, Runnable runnable) {
            this.f30900a = runnable;
        }

        @Override // n1.m.f
        public void a(m mVar) {
        }

        @Override // n1.m.f
        public void b(m mVar) {
            this.f30900a.run();
        }

        @Override // n1.m.f
        public void c(m mVar) {
        }

        @Override // n1.m.f
        public void d(m mVar) {
        }

        @Override // n1.m.f
        public void e(m mVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    class f extends m.e {
        f(e eVar, Rect rect) {
        }
    }

    private static boolean v(m mVar) {
        return !z.i(mVar.z()) || !z.i(mVar.A()) || !z.i(mVar.B());
    }

    @Override // androidx.fragment.app.z
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.z
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar != null) {
            int i10 = 0;
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                int h02 = qVar.h0();
                while (i10 < h02) {
                    b(qVar.g0(i10), arrayList);
                    i10++;
                }
            } else if (!v(mVar) && z.i(mVar.C())) {
                int size = arrayList.size();
                while (i10 < size) {
                    mVar.b(arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    @Override // androidx.fragment.app.z
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.z
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.z
    public Object f(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.z
    public Object j(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            mVar = new q().e0(mVar).e0(mVar2).m0(1);
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar = new q();
        if (mVar != null) {
            qVar.e0(mVar);
        }
        qVar.e0(mVar3);
        return qVar;
    }

    @Override // androidx.fragment.app.z
    public Object k(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.e0((m) obj);
        }
        if (obj2 != null) {
            qVar.e0((m) obj2);
        }
        if (obj3 != null) {
            qVar.e0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.z
    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.z
    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.z
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).V(new f(this, rect));
        }
    }

    @Override // androidx.fragment.app.z
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((m) obj).V(new a(this, rect));
        }
    }

    @Override // androidx.fragment.app.z
    public void q(Fragment fragment, Object obj, g0.c cVar, Runnable runnable) {
        m mVar = (m) obj;
        cVar.d(new d(this, mVar));
        mVar.a(new C0406e(this, runnable));
    }

    @Override // androidx.fragment.app.z
    public void s(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> C = qVar.C();
        C.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            z.d(C, arrayList.get(i10));
        }
        C.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }

    @Override // androidx.fragment.app.z
    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.C().clear();
            qVar.C().addAll(arrayList2);
            w(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.z
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.e0((m) obj);
        return qVar;
    }

    public void w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i10 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int h02 = qVar.h0();
            while (i10 < h02) {
                w(qVar.g0(i10), arrayList, arrayList2);
                i10++;
            }
        } else if (!v(mVar)) {
            List<View> C = mVar.C();
            if (C.size() == arrayList.size() && C.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i10 < size) {
                    mVar.b(arrayList2.get(i10));
                    i10++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    mVar.Q(arrayList.get(size2));
                }
            }
        }
    }
}
