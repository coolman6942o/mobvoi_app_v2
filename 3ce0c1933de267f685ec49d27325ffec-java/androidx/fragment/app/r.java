package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.a;
/* compiled from: FragmentPagerAdapter.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class r extends a {

    /* renamed from: c  reason: collision with root package name */
    private final FragmentManager f3164c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3165d;

    /* renamed from: e  reason: collision with root package name */
    private w f3166e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f3167f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3168g;

    @Deprecated
    public r(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String v(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3166e == null) {
            this.f3166e = this.f3164c.l();
        }
        this.f3166e.n(fragment);
        if (fragment.equals(this.f3167f)) {
            this.f3167f = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void c(ViewGroup viewGroup) {
        w wVar = this.f3166e;
        if (wVar != null) {
            if (!this.f3168g) {
                try {
                    this.f3168g = true;
                    wVar.m();
                } finally {
                    this.f3168g = false;
                }
            }
            this.f3166e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i10) {
        if (this.f3166e == null) {
            this.f3166e = this.f3164c.l();
        }
        long u10 = u(i10);
        Fragment g02 = this.f3164c.g0(v(viewGroup.getId(), u10));
        if (g02 != null) {
            this.f3166e.i(g02);
        } else {
            g02 = t(i10);
            this.f3166e.c(viewGroup.getId(), g02, v(viewGroup.getId(), u10));
        }
        if (g02 != this.f3167f) {
            g02.setMenuVisibility(false);
            if (this.f3165d == 1) {
                this.f3166e.w(g02, Lifecycle.State.STARTED);
            } else {
                g02.setUserVisibleHint(false);
            }
        }
        return g02;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable m() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void o(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3167f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3165d == 1) {
                    if (this.f3166e == null) {
                        this.f3166e = this.f3164c.l();
                    }
                    this.f3166e.w(this.f3167f, Lifecycle.State.STARTED);
                } else {
                    this.f3167f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3165d == 1) {
                if (this.f3166e == null) {
                    this.f3166e = this.f3164c.l();
                }
                this.f3166e.w(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3167f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void r(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public abstract Fragment t(int i10);

    public long u(int i10) {
        return i10;
    }

    public r(FragmentManager fragmentManager, int i10) {
        this.f3166e = null;
        this.f3167f = null;
        this.f3164c = fragmentManager;
        this.f3165d = i10;
    }
}
