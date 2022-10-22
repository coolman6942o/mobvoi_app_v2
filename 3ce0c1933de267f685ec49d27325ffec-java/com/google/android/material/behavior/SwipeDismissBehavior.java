package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import k0.c;
import k0.f;
import o0.d;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    o0.d f10450a;

    /* renamed from: b  reason: collision with root package name */
    c f10451b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10452c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10454e;

    /* renamed from: d  reason: collision with root package name */
    private float f10453d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    int f10455f = 2;

    /* renamed from: g  reason: collision with root package name */
    float f10456g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    float f10457h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f10458i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final d.c f10459j = new a();

    /* loaded from: classes.dex */
    class a extends d.c {

        /* renamed from: a  reason: collision with root package name */
        private int f10460a;

        /* renamed from: b  reason: collision with root package name */
        private int f10461b = -1;

        a() {
        }

        private boolean n(View view, float f10) {
            int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
            if (i10 != 0) {
                boolean z10 = d0.E(view) == 1;
                int i11 = SwipeDismissBehavior.this.f10455f;
                if (i11 == 2) {
                    return true;
                }
                if (i11 == 0) {
                    if (z10) {
                        if (f10 >= 0.0f) {
                            return false;
                        }
                    } else if (i10 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i11 != 1) {
                    return false;
                } else {
                    if (z10) {
                        if (i10 <= 0) {
                            return false;
                        }
                    } else if (f10 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                return Math.abs(view.getLeft() - this.f10460a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f10456g);
            }
        }

        @Override // o0.d.c
        public int a(View view, int i10, int i11) {
            int i12;
            int i13;
            int width;
            boolean z10 = d0.E(view) == 1;
            int i14 = SwipeDismissBehavior.this.f10455f;
            if (i14 == 0) {
                if (z10) {
                    i12 = this.f10460a - view.getWidth();
                    i13 = this.f10460a;
                } else {
                    i12 = this.f10460a;
                    width = view.getWidth();
                    i13 = width + i12;
                }
            } else if (i14 != 1) {
                i12 = this.f10460a - view.getWidth();
                i13 = view.getWidth() + this.f10460a;
            } else if (z10) {
                i12 = this.f10460a;
                width = view.getWidth();
                i13 = width + i12;
            } else {
                i12 = this.f10460a - view.getWidth();
                i13 = this.f10460a;
            }
            return SwipeDismissBehavior.G(i12, i10, i13);
        }

        @Override // o0.d.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // o0.d.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // o0.d.c
        public void i(View view, int i10) {
            this.f10461b = i10;
            this.f10460a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // o0.d.c
        public void j(int i10) {
            c cVar = SwipeDismissBehavior.this.f10451b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // o0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            float width = this.f10460a + (view.getWidth() * SwipeDismissBehavior.this.f10457h);
            float width2 = this.f10460a + (view.getWidth() * SwipeDismissBehavior.this.f10458i);
            float f10 = i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f10), 1.0f));
            }
        }

        @Override // o0.d.c
        public void l(View view, float f10, float f11) {
            boolean z10;
            int i10;
            c cVar;
            this.f10461b = -1;
            int width = view.getWidth();
            if (n(view, f10)) {
                int left = view.getLeft();
                int i11 = this.f10460a;
                i10 = left < i11 ? i11 - width : i11 + width;
                z10 = true;
            } else {
                i10 = this.f10460a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f10450a.O(i10, view.getTop())) {
                d0.l0(view, new d(view, z10));
            } else if (z10 && (cVar = SwipeDismissBehavior.this.f10451b) != null) {
                cVar.a(view);
            }
        }

        @Override // o0.d.c
        public boolean m(View view, int i10) {
            int i11 = this.f10461b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.E(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements f {
        b() {
        }

        @Override // k0.f
        public boolean a(View view, f.a aVar) {
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z11 = d0.E(view) == 1;
            int i10 = SwipeDismissBehavior.this.f10455f;
            if ((i10 == 0 && z11) || (i10 == 1 && !z11)) {
                z10 = true;
            }
            int width = view.getWidth();
            if (z10) {
                width = -width;
            }
            d0.d0(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f10451b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view);

        void b(int i10);
    }

    /* loaded from: classes.dex */
    private class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f10464a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10465b;

        d(View view, boolean z10) {
            this.f10464a = view;
            this.f10465b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            o0.d dVar = SwipeDismissBehavior.this.f10450a;
            if (dVar != null && dVar.m(true)) {
                d0.l0(this.f10464a, this);
            } else if (this.f10465b && (cVar = SwipeDismissBehavior.this.f10451b) != null) {
                cVar.a(this.f10464a);
            }
        }
    }

    static float F(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    static int G(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void H(ViewGroup viewGroup) {
        o0.d dVar;
        if (this.f10450a == null) {
            if (this.f10454e) {
                dVar = o0.d.n(viewGroup, this.f10453d, this.f10459j);
            } else {
                dVar = o0.d.o(viewGroup, this.f10459j);
            }
            this.f10450a = dVar;
        }
    }

    static float I(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    private void N(View view) {
        d0.n0(view, 1048576);
        if (E(view)) {
            d0.p0(view, c.a.f29702l, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        o0.d dVar = this.f10450a;
        if (dVar == null) {
            return false;
        }
        dVar.F(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f10) {
        this.f10458i = F(0.0f, f10, 1.0f);
    }

    public void K(c cVar) {
        this.f10451b = cVar;
    }

    public void L(float f10) {
        this.f10457h = F(0.0f, f10, 1.0f);
    }

    public void M(int i10) {
        this.f10455f = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10 = this.f10452c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.B(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f10452c = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f10452c = false;
        }
        if (!z10) {
            return false;
        }
        H(coordinatorLayout);
        return this.f10450a.P(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean l10 = super.l(coordinatorLayout, v10, i10);
        if (d0.C(v10) == 0) {
            d0.E0(v10, 1);
            N(v10);
        }
        return l10;
    }
}
