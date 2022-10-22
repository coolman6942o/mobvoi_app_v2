package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.a;
import java.util.ArrayList;
/* compiled from: FragmentStatePagerAdapter.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class u extends a {

    /* renamed from: c  reason: collision with root package name */
    private final FragmentManager f3182c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3183d;

    /* renamed from: e  reason: collision with root package name */
    private w f3184e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f3185f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Fragment> f3186g;

    /* renamed from: h  reason: collision with root package name */
    private Fragment f3187h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3188i;

    @Deprecated
    public u(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3184e == null) {
            this.f3184e = this.f3182c.l();
        }
        while (this.f3185f.size() <= i10) {
            this.f3185f.add(null);
        }
        this.f3185f.set(i10, fragment.isAdded() ? this.f3182c.l1(fragment) : null);
        this.f3186g.set(i10, null);
        this.f3184e.r(fragment);
        if (fragment.equals(this.f3187h)) {
            this.f3187h = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void c(ViewGroup viewGroup) {
        w wVar = this.f3184e;
        if (wVar != null) {
            if (!this.f3188i) {
                try {
                    this.f3188i = true;
                    wVar.m();
                } finally {
                    this.f3188i = false;
                }
            }
            this.f3184e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f3186g.size() > i10 && (fragment = this.f3186g.get(i10)) != null) {
            return fragment;
        }
        if (this.f3184e == null) {
            this.f3184e = this.f3182c.l();
        }
        Fragment t10 = t(i10);
        if (this.f3185f.size() > i10 && (savedState = this.f3185f.get(i10)) != null) {
            t10.setInitialSavedState(savedState);
        }
        while (this.f3186g.size() <= i10) {
            this.f3186g.add(null);
        }
        t10.setMenuVisibility(false);
        if (this.f3183d == 0) {
            t10.setUserVisibleHint(false);
        }
        this.f3186g.set(i10, t10);
        this.f3184e.b(viewGroup.getId(), t10);
        if (this.f3183d == 1) {
            this.f3184e.w(t10, Lifecycle.State.STARTED);
        }
        return t10;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void l(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f3185f.clear();
            this.f3186g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f3185f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment q02 = this.f3182c.q0(bundle, str);
                    if (q02 != null) {
                        while (this.f3186g.size() <= parseInt) {
                            this.f3186g.add(null);
                        }
                        q02.setMenuVisibility(false);
                        this.f3186g.set(parseInt, q02);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable m() {
        Bundle bundle;
        if (this.f3185f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f3185f.size()];
            this.f3185f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f3186g.size(); i10++) {
            Fragment fragment = this.f3186g.get(i10);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f3182c.d1(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void o(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3187h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3183d == 1) {
                    if (this.f3184e == null) {
                        this.f3184e = this.f3182c.l();
                    }
                    this.f3184e.w(this.f3187h, Lifecycle.State.STARTED);
                } else {
                    this.f3187h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3183d == 1) {
                if (this.f3184e == null) {
                    this.f3184e = this.f3182c.l();
                }
                this.f3184e.w(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3187h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void r(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public abstract Fragment t(int i10);

    public u(FragmentManager fragmentManager, int i10) {
        this.f3184e = null;
        this.f3185f = new ArrayList<>();
        this.f3186g = new ArrayList<>();
        this.f3187h = null;
        this.f3182c = fragmentManager;
        this.f3183d = i10;
    }
}
