package n1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.d0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static m f30974a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<m>>>> f30975b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f30976c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        m f30977a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f30978b;

        /* compiled from: TransitionManager.java */
        /* renamed from: n1.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0407a extends n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f30979a;

            C0407a(androidx.collection.a aVar) {
                this.f30979a = aVar;
            }

            @Override // n1.m.f
            public void b(m mVar) {
                ((ArrayList) this.f30979a.get(a.this.f30978b)).remove(mVar);
                mVar.P(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f30977a = mVar;
            this.f30978b = viewGroup;
        }

        private void a() {
            this.f30978b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f30978b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f30976c.remove(this.f30978b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<m>> b10 = o.b();
            ArrayList<m> arrayList = b10.get(this.f30978b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b10.put(this.f30978b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f30977a);
            this.f30977a.a(new C0407a(b10));
            this.f30977a.k(this.f30978b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).R(this.f30978b);
                }
            }
            this.f30977a.O(this.f30978b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f30976c.remove(this.f30978b);
            ArrayList<m> arrayList = o.b().get(this.f30978b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().R(this.f30978b);
                }
            }
            this.f30977a.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (!f30976c.contains(viewGroup) && d0.X(viewGroup)) {
            f30976c.add(viewGroup);
            if (mVar == null) {
                mVar = f30974a;
            }
            m m10 = mVar.clone();
            d(viewGroup, m10);
            l.c(viewGroup, null);
            c(viewGroup, m10);
        }
    }

    static androidx.collection.a<ViewGroup, ArrayList<m>> b() {
        androidx.collection.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<androidx.collection.a<ViewGroup, ArrayList<m>>> weakReference = f30975b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<m>> aVar2 = new androidx.collection.a<>();
        f30975b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar != null && viewGroup != null) {
            a aVar = new a(mVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l b10 = l.b(viewGroup);
        if (b10 != null) {
            b10.a();
        }
    }
}
