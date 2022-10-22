package i;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.i0;
import androidx.core.view.j0;
import androidx.core.view.k0;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f27962c;

    /* renamed from: d  reason: collision with root package name */
    j0 f27963d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27964e;

    /* renamed from: b  reason: collision with root package name */
    private long f27961b = -1;

    /* renamed from: f  reason: collision with root package name */
    private final k0 f27965f = new a();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<i0> f27960a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* loaded from: classes.dex */
    class a extends k0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27966a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f27967b = 0;

        a() {
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            int i10 = this.f27967b + 1;
            this.f27967b = i10;
            if (i10 == h.this.f27960a.size()) {
                j0 j0Var = h.this.f27963d;
                if (j0Var != null) {
                    j0Var.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.k0, androidx.core.view.j0
        public void c(View view) {
            if (!this.f27966a) {
                this.f27966a = true;
                j0 j0Var = h.this.f27963d;
                if (j0Var != null) {
                    j0Var.c(null);
                }
            }
        }

        void d() {
            this.f27967b = 0;
            this.f27966a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f27964e) {
            Iterator<i0> it = this.f27960a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f27964e = false;
        }
    }

    void b() {
        this.f27964e = false;
    }

    public h c(i0 i0Var) {
        if (!this.f27964e) {
            this.f27960a.add(i0Var);
        }
        return this;
    }

    public h d(i0 i0Var, i0 i0Var2) {
        this.f27960a.add(i0Var);
        i0Var2.h(i0Var.c());
        this.f27960a.add(i0Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f27964e) {
            this.f27961b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f27964e) {
            this.f27962c = interpolator;
        }
        return this;
    }

    public h g(j0 j0Var) {
        if (!this.f27964e) {
            this.f27963d = j0Var;
        }
        return this;
    }

    public void h() {
        if (!this.f27964e) {
            Iterator<i0> it = this.f27960a.iterator();
            while (it.hasNext()) {
                i0 next = it.next();
                long j10 = this.f27961b;
                if (j10 >= 0) {
                    next.d(j10);
                }
                Interpolator interpolator = this.f27962c;
                if (interpolator != null) {
                    next.e(interpolator);
                }
                if (this.f27963d != null) {
                    next.f(this.f27965f);
                }
                next.j();
            }
            this.f27964e = true;
        }
    }
}
