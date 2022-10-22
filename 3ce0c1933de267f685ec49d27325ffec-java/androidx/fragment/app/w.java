package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: b  reason: collision with root package name */
    int f3194b;

    /* renamed from: c  reason: collision with root package name */
    int f3195c;

    /* renamed from: d  reason: collision with root package name */
    int f3196d;

    /* renamed from: e  reason: collision with root package name */
    int f3197e;

    /* renamed from: f  reason: collision with root package name */
    int f3198f;

    /* renamed from: g  reason: collision with root package name */
    boolean f3199g;

    /* renamed from: i  reason: collision with root package name */
    String f3201i;

    /* renamed from: j  reason: collision with root package name */
    int f3202j;

    /* renamed from: k  reason: collision with root package name */
    CharSequence f3203k;

    /* renamed from: l  reason: collision with root package name */
    int f3204l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f3205m;

    /* renamed from: n  reason: collision with root package name */
    ArrayList<String> f3206n;

    /* renamed from: o  reason: collision with root package name */
    ArrayList<String> f3207o;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<Runnable> f3209q;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<a> f3193a = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    boolean f3200h = true;

    /* renamed from: p  reason: collision with root package name */
    boolean f3208p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransaction.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f3210a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f3211b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3212c;

        /* renamed from: d  reason: collision with root package name */
        int f3213d;

        /* renamed from: e  reason: collision with root package name */
        int f3214e;

        /* renamed from: f  reason: collision with root package name */
        int f3215f;

        /* renamed from: g  reason: collision with root package name */
        int f3216g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f3217h;

        /* renamed from: i  reason: collision with root package name */
        Lifecycle.State f3218i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Fragment fragment) {
            this.f3210a = i10;
            this.f3211b = fragment;
            this.f3212c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f3217h = state;
            this.f3218i = state;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Fragment fragment, boolean z10) {
            this.f3210a = i10;
            this.f3211b = fragment;
            this.f3212c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f3217h = state;
            this.f3218i = state;
        }

        a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f3210a = i10;
            this.f3211b = fragment;
            this.f3212c = false;
            this.f3217h = fragment.mMaxState;
            this.f3218i = state;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(j jVar, ClassLoader classLoader) {
    }

    public w b(int i10, Fragment fragment) {
        p(i10, fragment, null, 1);
        return this;
    }

    public w c(int i10, Fragment fragment, String str) {
        p(i10, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public w e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f3193a.add(aVar);
        aVar.f3213d = this.f3194b;
        aVar.f3214e = this.f3195c;
        aVar.f3215f = this.f3196d;
        aVar.f3216g = this.f3197e;
    }

    public w g(View view, String str) {
        if (x.e()) {
            String N = d0.N(view);
            if (N != null) {
                if (this.f3206n == null) {
                    this.f3206n = new ArrayList<>();
                    this.f3207o = new ArrayList<>();
                } else if (this.f3207o.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.f3206n.contains(N)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + N + "' has already been added to the transaction.");
                }
                this.f3206n.add(N);
                this.f3207o.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    public w h(String str) {
        if (this.f3200h) {
            this.f3199g = true;
            this.f3201i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public w i(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int j();

    public abstract int k();

    public abstract void l();

    public abstract void m();

    public w n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public w o() {
        if (!this.f3199g) {
            this.f3200h = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 == null || str.equals(str3)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = fragment.mFragmentId;
                if (i12 == 0 || i12 == i10) {
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new a(i11, fragment));
    }

    public w q(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public w r(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public w s(int i10, Fragment fragment) {
        return t(i10, fragment, null);
    }

    public w t(int i10, Fragment fragment, String str) {
        if (i10 != 0) {
            p(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public w u(int i10, int i11) {
        return v(i10, i11, 0, 0);
    }

    public w v(int i10, int i11, int i12, int i13) {
        this.f3194b = i10;
        this.f3195c = i11;
        this.f3196d = i12;
        this.f3197e = i13;
        return this;
    }

    public w w(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public w x(Fragment fragment) {
        f(new a(8, fragment));
        return this;
    }

    public w y(boolean z10) {
        this.f3208p = z10;
        return this;
    }

    public w z(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
