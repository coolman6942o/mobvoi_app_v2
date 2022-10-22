package n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import n1.a;
import n1.m;
/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int J = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f30919a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f30920b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f30921c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f30919a = viewGroup;
            this.f30920b = view;
            this.f30921c = view2;
        }

        @Override // n1.m.f
        public void b(m mVar) {
            this.f30921c.setTag(j.f30916b, null);
            x.a(this.f30919a).d(this.f30920b);
            mVar.P(this);
        }

        @Override // n1.n, n1.m.f
        public void c(m mVar) {
            x.a(this.f30919a).d(this.f30920b);
        }

        @Override // n1.n, n1.m.f
        public void e(m mVar) {
            if (this.f30920b.getParent() == null) {
                x.a(this.f30919a).c(this.f30920b);
            } else {
                j0.this.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.AbstractC0404a {

        /* renamed from: a  reason: collision with root package name */
        private final View f30923a;

        /* renamed from: b  reason: collision with root package name */
        private final int f30924b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f30925c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f30926d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f30927e;

        /* renamed from: f  reason: collision with root package name */
        boolean f30928f = false;

        b(View view, int i10, boolean z10) {
            this.f30923a = view;
            this.f30924b = i10;
            this.f30925c = (ViewGroup) view.getParent();
            this.f30926d = z10;
            g(true);
        }

        private void f() {
            if (!this.f30928f) {
                c0.h(this.f30923a, this.f30924b);
                ViewGroup viewGroup = this.f30925c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z10) {
            ViewGroup viewGroup;
            if (this.f30926d && this.f30927e != z10 && (viewGroup = this.f30925c) != null) {
                this.f30927e = z10;
                x.c(viewGroup, z10);
            }
        }

        @Override // n1.m.f
        public void a(m mVar) {
        }

        @Override // n1.m.f
        public void b(m mVar) {
            f();
            mVar.P(this);
        }

        @Override // n1.m.f
        public void c(m mVar) {
            g(false);
        }

        @Override // n1.m.f
        public void d(m mVar) {
        }

        @Override // n1.m.f
        public void e(m mVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f30928f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, n1.a.AbstractC0404a
        public void onAnimationPause(Animator animator) {
            if (!this.f30928f) {
                c0.h(this.f30923a, this.f30924b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, n1.a.AbstractC0404a
        public void onAnimationResume(Animator animator) {
            if (!this.f30928f) {
                c0.h(this.f30923a, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f30929a;

        /* renamed from: b  reason: collision with root package name */
        boolean f30930b;

        /* renamed from: c  reason: collision with root package name */
        int f30931c;

        /* renamed from: d  reason: collision with root package name */
        int f30932d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f30933e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f30934f;

        c() {
        }
    }

    private void c0(s sVar) {
        sVar.f30986a.put("android:visibility:visibility", Integer.valueOf(sVar.f30987b.getVisibility()));
        sVar.f30986a.put("android:visibility:parent", sVar.f30987b.getParent());
        int[] iArr = new int[2];
        sVar.f30987b.getLocationOnScreen(iArr);
        sVar.f30986a.put("android:visibility:screenLocation", iArr);
    }

    private c d0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f30929a = false;
        cVar.f30930b = false;
        if (sVar == null || !sVar.f30986a.containsKey("android:visibility:visibility")) {
            cVar.f30931c = -1;
            cVar.f30933e = null;
        } else {
            cVar.f30931c = ((Integer) sVar.f30986a.get("android:visibility:visibility")).intValue();
            cVar.f30933e = (ViewGroup) sVar.f30986a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f30986a.containsKey("android:visibility:visibility")) {
            cVar.f30932d = -1;
            cVar.f30934f = null;
        } else {
            cVar.f30932d = ((Integer) sVar2.f30986a.get("android:visibility:visibility")).intValue();
            cVar.f30934f = (ViewGroup) sVar2.f30986a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i10 = cVar.f30931c;
            int i11 = cVar.f30932d;
            if (i10 == i11 && cVar.f30933e == cVar.f30934f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f30930b = false;
                    cVar.f30929a = true;
                } else if (i11 == 0) {
                    cVar.f30930b = true;
                    cVar.f30929a = true;
                }
            } else if (cVar.f30934f == null) {
                cVar.f30930b = false;
                cVar.f30929a = true;
            } else if (cVar.f30933e == null) {
                cVar.f30930b = true;
                cVar.f30929a = true;
            }
        } else if (sVar == null && cVar.f30932d == 0) {
            cVar.f30930b = true;
            cVar.f30929a = true;
        } else if (sVar2 == null && cVar.f30931c == 0) {
            cVar.f30930b = false;
            cVar.f30929a = true;
        }
        return cVar;
    }

    @Override // n1.m
    public String[] D() {
        return K;
    }

    @Override // n1.m
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f30986a.containsKey("android:visibility:visibility") != sVar.f30986a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c d02 = d0(sVar, sVar2);
        if (d02.f30929a) {
            return d02.f30931c == 0 || d02.f30932d == 0;
        }
        return false;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // n1.m
    public void f(s sVar) {
        c0(sVar);
    }

    public Animator f0(ViewGroup viewGroup, s sVar, int i10, s sVar2, int i11) {
        if ((this.J & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f30987b.getParent();
            if (d0(t(view, false), E(view, false)).f30929a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f30987b, sVar, sVar2);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
        if (r17.f30961v != false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator h0(ViewGroup viewGroup, s sVar, int i10, s sVar2, int i11) {
        boolean z10;
        View view;
        boolean z11;
        View view2;
        if ((this.J & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.f30987b;
        View view4 = sVar2 != null ? sVar2.f30987b : null;
        int i12 = j.f30916b;
        View view5 = (View) view3.getTag(i12);
        if (view5 != null) {
            view = null;
            z10 = true;
        } else if (view4 == null || view4.getParent() == null) {
            if (view4 != null) {
                view2 = null;
                z11 = false;
                if (z11) {
                    if (view3.getParent() != null) {
                        if (view3.getParent() instanceof View) {
                            View view6 = (View) view3.getParent();
                            if (!d0(E(view6, true), t(view6, true)).f30929a) {
                                view4 = r.a(viewGroup, view3, view6);
                            } else {
                                int id2 = view6.getId();
                                if (view6.getParent() == null) {
                                    if (id2 != -1) {
                                        if (viewGroup.findViewById(id2) != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    view = view2;
                    z10 = false;
                    view5 = view3;
                }
                z10 = false;
                view = view2;
                view5 = view4;
            }
            view4 = null;
            view2 = null;
            z11 = true;
            if (z11) {
            }
            z10 = false;
            view = view2;
            view5 = view4;
        } else {
            if (i11 == 4 || view3 == view4) {
                view2 = view4;
                z11 = false;
                view4 = null;
                if (z11) {
                }
                z10 = false;
                view = view2;
                view5 = view4;
            }
            view4 = null;
            view2 = null;
            z11 = true;
            if (z11) {
            }
            z10 = false;
            view = view2;
            view5 = view4;
        }
        if (view5 != null) {
            if (!z10) {
                int[] iArr = (int[]) sVar.f30986a.get("android:visibility:screenLocation");
                int i13 = iArr[0];
                int i14 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view5.offsetLeftAndRight((i13 - iArr2[0]) - view5.getLeft());
                view5.offsetTopAndBottom((i14 - iArr2[1]) - view5.getTop());
                x.a(viewGroup).c(view5);
            }
            Animator g02 = g0(viewGroup, view5, sVar, sVar2);
            if (!z10) {
                if (g02 == null) {
                    x.a(viewGroup).d(view5);
                } else {
                    view3.setTag(i12, view5);
                    a(new a(viewGroup, view5, view3));
                }
            }
            return g02;
        } else if (view == null) {
            return null;
        } else {
            int visibility = view.getVisibility();
            c0.h(view, 0);
            Animator g03 = g0(viewGroup, view, sVar, sVar2);
            if (g03 != null) {
                b bVar = new b(view, i11, true);
                g03.addListener(bVar);
                n1.a.a(g03, bVar);
                a(bVar);
            } else {
                c0.h(view, visibility);
            }
            return g03;
        }
    }

    public void i0(int i10) {
        if ((i10 & (-4)) == 0) {
            this.J = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // n1.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // n1.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c d02 = d0(sVar, sVar2);
        if (!d02.f30929a) {
            return null;
        }
        if (d02.f30933e == null && d02.f30934f == null) {
            return null;
        }
        if (d02.f30930b) {
            return f0(viewGroup, sVar, d02.f30931c, sVar2, d02.f30932d);
        }
        return h0(viewGroup, sVar, d02.f30931c, sVar2, d02.f30932d);
    }
}
