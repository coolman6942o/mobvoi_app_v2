package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.d0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class c extends q {

    /* renamed from: s  reason: collision with root package name */
    private static TimeInterpolator f3931s;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.b0> f3932h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.b0> f3933i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<j> f3934j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<i> f3935k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.b0>> f3936l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    ArrayList<ArrayList<j>> f3937m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    ArrayList<ArrayList<i>> f3938n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    ArrayList<RecyclerView.b0> f3939o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    ArrayList<RecyclerView.b0> f3940p = new ArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    ArrayList<RecyclerView.b0> f3941q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    ArrayList<RecyclerView.b0> f3942r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3943a;

        a(ArrayList arrayList) {
            this.f3943a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3943a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.T(jVar.f3977a, jVar.f3978b, jVar.f3979c, jVar.f3980d, jVar.f3981e);
            }
            this.f3943a.clear();
            c.this.f3937m.remove(this.f3943a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3945a;

        b(ArrayList arrayList) {
            this.f3945a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3945a.iterator();
            while (it.hasNext()) {
                c.this.S((i) it.next());
            }
            this.f3945a.clear();
            c.this.f3938n.remove(this.f3945a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0042c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3947a;

        RunnableC0042c(ArrayList arrayList) {
            this.f3947a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3947a.iterator();
            while (it.hasNext()) {
                c.this.R((RecyclerView.b0) it.next());
            }
            this.f3947a.clear();
            c.this.f3936l.remove(this.f3947a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f3949a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3950b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3951c;

        d(RecyclerView.b0 b0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3949a = b0Var;
            this.f3950b = viewPropertyAnimator;
            this.f3951c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3950b.setListener(null);
            this.f3951c.setAlpha(1.0f);
            c.this.H(this.f3949a);
            c.this.f3941q.remove(this.f3949a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.I(this.f3949a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f3953a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f3954b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3955c;

        e(RecyclerView.b0 b0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3953a = b0Var;
            this.f3954b = view;
            this.f3955c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3954b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3955c.setListener(null);
            c.this.B(this.f3953a);
            c.this.f3939o.remove(this.f3953a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.C(this.f3953a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f3957a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3958b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3959c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3960d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3961e;

        f(RecyclerView.b0 b0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3957a = b0Var;
            this.f3958b = i10;
            this.f3959c = view;
            this.f3960d = i11;
            this.f3961e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3958b != 0) {
                this.f3959c.setTranslationX(0.0f);
            }
            if (this.f3960d != 0) {
                this.f3959c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3961e.setListener(null);
            c.this.F(this.f3957a);
            c.this.f3940p.remove(this.f3957a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.G(this.f3957a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f3963a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3964b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3965c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3963a = iVar;
            this.f3964b = viewPropertyAnimator;
            this.f3965c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3964b.setListener(null);
            this.f3965c.setAlpha(1.0f);
            this.f3965c.setTranslationX(0.0f);
            this.f3965c.setTranslationY(0.0f);
            c.this.D(this.f3963a.f3971a, true);
            c.this.f3942r.remove(this.f3963a.f3971a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.E(this.f3963a.f3971a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f3967a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3968b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f3969c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3967a = iVar;
            this.f3968b = viewPropertyAnimator;
            this.f3969c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3968b.setListener(null);
            this.f3969c.setAlpha(1.0f);
            this.f3969c.setTranslationX(0.0f);
            this.f3969c.setTranslationY(0.0f);
            c.this.D(this.f3967a.f3972b, false);
            c.this.f3942r.remove(this.f3967a.f3972b);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.E(this.f3967a.f3972b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.b0 f3977a;

        /* renamed from: b  reason: collision with root package name */
        public int f3978b;

        /* renamed from: c  reason: collision with root package name */
        public int f3979c;

        /* renamed from: d  reason: collision with root package name */
        public int f3980d;

        /* renamed from: e  reason: collision with root package name */
        public int f3981e;

        j(RecyclerView.b0 b0Var, int i10, int i11, int i12, int i13) {
            this.f3977a = b0Var;
            this.f3978b = i10;
            this.f3979c = i11;
            this.f3980d = i12;
            this.f3981e = i13;
        }
    }

    private void U(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3941q.add(b0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(b0Var, animate, view)).start();
    }

    private void X(List<i> list, RecyclerView.b0 b0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Z(iVar, b0Var) && iVar.f3971a == null && iVar.f3972b == null) {
                list.remove(iVar);
            }
        }
    }

    private void Y(i iVar) {
        RecyclerView.b0 b0Var = iVar.f3971a;
        if (b0Var != null) {
            Z(iVar, b0Var);
        }
        RecyclerView.b0 b0Var2 = iVar.f3972b;
        if (b0Var2 != null) {
            Z(iVar, b0Var2);
        }
    }

    private boolean Z(i iVar, RecyclerView.b0 b0Var) {
        boolean z10 = false;
        if (iVar.f3972b == b0Var) {
            iVar.f3972b = null;
        } else if (iVar.f3971a != b0Var) {
            return false;
        } else {
            iVar.f3971a = null;
            z10 = true;
        }
        b0Var.itemView.setAlpha(1.0f);
        b0Var.itemView.setTranslationX(0.0f);
        b0Var.itemView.setTranslationY(0.0f);
        D(b0Var, z10);
        return true;
    }

    private void a0(RecyclerView.b0 b0Var) {
        if (f3931s == null) {
            f3931s = new ValueAnimator().getInterpolator();
        }
        b0Var.itemView.animate().setInterpolator(f3931s);
        j(b0Var);
    }

    @Override // androidx.recyclerview.widget.q
    public boolean A(RecyclerView.b0 b0Var) {
        a0(b0Var);
        this.f3932h.add(b0Var);
        return true;
    }

    void R(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3939o.add(b0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(b0Var, view, animate)).start();
    }

    void S(i iVar) {
        RecyclerView.b0 b0Var = iVar.f3971a;
        View view = null;
        View view2 = b0Var == null ? null : b0Var.itemView;
        RecyclerView.b0 b0Var2 = iVar.f3972b;
        if (b0Var2 != null) {
            view = b0Var2.itemView;
        }
        if (view2 != null) {
            ViewPropertyAnimator duration = view2.animate().setDuration(m());
            this.f3942r.add(iVar.f3971a);
            duration.translationX(iVar.f3975e - iVar.f3973c);
            duration.translationY(iVar.f3976f - iVar.f3974d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view2)).start();
        }
        if (view != null) {
            ViewPropertyAnimator animate = view.animate();
            this.f3942r.add(iVar.f3972b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view)).start();
        }
    }

    void T(RecyclerView.b0 b0Var, int i10, int i11, int i12, int i13) {
        View view = b0Var.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f3940p.add(b0Var);
        animate.setDuration(n()).setListener(new f(b0Var, i14, view, i15, animate)).start();
    }

    void V(List<RecyclerView.b0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void W() {
        if (!p()) {
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.b0 b0Var, List<Object> list) {
        return !list.isEmpty() || super.g(b0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.b0 b0Var) {
        View view = b0Var.itemView;
        view.animate().cancel();
        int size = this.f3934j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f3934j.get(size).f3977a == b0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(b0Var);
                this.f3934j.remove(size);
            }
        }
        X(this.f3935k, b0Var);
        if (this.f3932h.remove(b0Var)) {
            view.setAlpha(1.0f);
            H(b0Var);
        }
        if (this.f3933i.remove(b0Var)) {
            view.setAlpha(1.0f);
            B(b0Var);
        }
        for (int size2 = this.f3938n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f3938n.get(size2);
            X(arrayList, b0Var);
            if (arrayList.isEmpty()) {
                this.f3938n.remove(size2);
            }
        }
        for (int size3 = this.f3937m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f3937m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f3977a == b0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(b0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3937m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3936l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.b0> arrayList3 = this.f3936l.get(size5);
            if (arrayList3.remove(b0Var)) {
                view.setAlpha(1.0f);
                B(b0Var);
                if (arrayList3.isEmpty()) {
                    this.f3936l.remove(size5);
                }
            }
        }
        this.f3941q.remove(b0Var);
        this.f3939o.remove(b0Var);
        this.f3942r.remove(b0Var);
        this.f3940p.remove(b0Var);
        W();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f3934j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f3934j.get(size);
            View view = jVar.f3977a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(jVar.f3977a);
            this.f3934j.remove(size);
        }
        for (int size2 = this.f3932h.size() - 1; size2 >= 0; size2--) {
            H(this.f3932h.get(size2));
            this.f3932h.remove(size2);
        }
        int size3 = this.f3933i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.b0 b0Var = this.f3933i.get(size3);
            b0Var.itemView.setAlpha(1.0f);
            B(b0Var);
            this.f3933i.remove(size3);
        }
        for (int size4 = this.f3935k.size() - 1; size4 >= 0; size4--) {
            Y(this.f3935k.get(size4));
        }
        this.f3935k.clear();
        if (p()) {
            for (int size5 = this.f3937m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f3937m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f3977a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(jVar2.f3977a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3937m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3936l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.b0> arrayList2 = this.f3936l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.b0 b0Var2 = arrayList2.get(size8);
                    b0Var2.itemView.setAlpha(1.0f);
                    B(b0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3936l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3938n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f3938n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Y(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3938n.remove(arrayList3);
                    }
                }
            }
            V(this.f3941q);
            V(this.f3940p);
            V(this.f3939o);
            V(this.f3942r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return !this.f3933i.isEmpty() || !this.f3935k.isEmpty() || !this.f3934j.isEmpty() || !this.f3932h.isEmpty() || !this.f3940p.isEmpty() || !this.f3941q.isEmpty() || !this.f3939o.isEmpty() || !this.f3942r.isEmpty() || !this.f3937m.isEmpty() || !this.f3936l.isEmpty() || !this.f3938n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean z10 = !this.f3932h.isEmpty();
        boolean z11 = !this.f3934j.isEmpty();
        boolean z12 = !this.f3935k.isEmpty();
        boolean z13 = !this.f3933i.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.b0> it = this.f3932h.iterator();
            while (it.hasNext()) {
                U(it.next());
            }
            this.f3932h.clear();
            if (z11) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f3934j);
                this.f3937m.add(arrayList);
                this.f3934j.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    d0.m0(arrayList.get(0).f3977a.itemView, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f3935k);
                this.f3938n.add(arrayList2);
                this.f3935k.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    d0.m0(arrayList2.get(0).f3971a.itemView, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList<RecyclerView.b0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f3933i);
                this.f3936l.add(arrayList3);
                this.f3933i.clear();
                RunnableC0042c cVar = new RunnableC0042c(arrayList3);
                if (z10 || z11 || z12) {
                    long j10 = 0;
                    long o10 = z10 ? o() : 0L;
                    long n10 = z11 ? n() : 0L;
                    if (z12) {
                        j10 = m();
                    }
                    d0.m0(arrayList3.get(0).itemView, cVar, o10 + Math.max(n10, j10));
                    return;
                }
                cVar.run();
            }
        }
    }

    @Override // androidx.recyclerview.widget.q
    public boolean x(RecyclerView.b0 b0Var) {
        a0(b0Var);
        b0Var.itemView.setAlpha(0.0f);
        this.f3933i.add(b0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.q
    public boolean y(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i10, int i11, int i12, int i13) {
        if (b0Var == b0Var2) {
            return z(b0Var, i10, i11, i12, i13);
        }
        float translationX = b0Var.itemView.getTranslationX();
        float translationY = b0Var.itemView.getTranslationY();
        float alpha = b0Var.itemView.getAlpha();
        a0(b0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        b0Var.itemView.setTranslationX(translationX);
        b0Var.itemView.setTranslationY(translationY);
        b0Var.itemView.setAlpha(alpha);
        if (b0Var2 != null) {
            a0(b0Var2);
            b0Var2.itemView.setTranslationX(-i14);
            b0Var2.itemView.setTranslationY(-i15);
            b0Var2.itemView.setAlpha(0.0f);
        }
        this.f3935k.add(new i(b0Var, b0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.q
    public boolean z(RecyclerView.b0 b0Var, int i10, int i11, int i12, int i13) {
        View view = b0Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) b0Var.itemView.getTranslationY());
        a0(b0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            F(b0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f3934j.add(new j(b0Var, translationX, translationY, i12, i13));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.b0 f3971a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.b0 f3972b;

        /* renamed from: c  reason: collision with root package name */
        public int f3973c;

        /* renamed from: d  reason: collision with root package name */
        public int f3974d;

        /* renamed from: e  reason: collision with root package name */
        public int f3975e;

        /* renamed from: f  reason: collision with root package name */
        public int f3976f;

        private i(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
            this.f3971a = b0Var;
            this.f3972b = b0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3971a + ", newHolder=" + this.f3972b + ", fromX=" + this.f3973c + ", fromY=" + this.f3974d + ", toX=" + this.f3975e + ", toY=" + this.f3976f + '}';
        }

        i(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i10, int i11, int i12, int i13) {
            this(b0Var, b0Var2);
            this.f3973c = i10;
            this.f3974d = i11;
            this.f3975e = i12;
            this.f3976f = i13;
        }
    }
}
