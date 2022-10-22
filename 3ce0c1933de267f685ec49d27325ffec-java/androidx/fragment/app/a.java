package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class a extends w implements FragmentManager.i, FragmentManager.m {

    /* renamed from: r  reason: collision with root package name */
    final FragmentManager f3041r;

    /* renamed from: s  reason: collision with root package name */
    boolean f3042s;

    /* renamed from: t  reason: collision with root package name */
    int f3043t;

    /* renamed from: u  reason: collision with root package name */
    boolean f3044u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FragmentManager fragmentManager) {
        super(fragmentManager.s0(), fragmentManager.u0() != null ? fragmentManager.u0().f().getClassLoader() : null);
        this.f3043t = -1;
        this.f3044u = false;
        this.f3041r = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10) {
        w.a aVar;
        if (this.f3199g) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f3193a.size();
            for (int i11 = 0; i11 < size; i11++) {
                Fragment fragment = this.f3193a.get(i11).f3211b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i10;
                    if (FragmentManager.H0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3211b + " to " + aVar.f3211b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int B(boolean z10) {
        if (!this.f3042s) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new c0("FragmentManager"));
                C("  ", printWriter);
                printWriter.close();
            }
            this.f3042s = true;
            if (this.f3199g) {
                this.f3043t = this.f3041r.i();
            } else {
                this.f3043t = -1;
            }
            this.f3041r.W(this, z10);
            return this.f3043t;
        }
        throw new IllegalStateException("commit already called");
    }

    public void C(String str, PrintWriter printWriter) {
        D(str, printWriter, true);
    }

    public void D(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3201i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3043t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3042s);
            if (this.f3198f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3198f));
            }
            if (!(this.f3194b == 0 && this.f3195c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3194b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3195c));
            }
            if (!(this.f3196d == 0 && this.f3197e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3196d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3197e));
            }
            if (!(this.f3202j == 0 && this.f3203k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3202j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3203k);
            }
            if (!(this.f3204l == 0 && this.f3205m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3204l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3205m);
            }
        }
        if (!this.f3193a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f3193a.size();
            for (int i10 = 0; i10 < size; i10++) {
                w.a aVar = this.f3193a.get(i10);
                switch (aVar.f3210a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f3210a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f3211b);
                if (z10) {
                    if (!(aVar.f3213d == 0 && aVar.f3214e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3213d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3214e));
                    }
                    if (aVar.f3215f != 0 || aVar.f3216g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3215f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3216g));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        int size = this.f3193a.size();
        for (int i10 = 0; i10 < size; i10++) {
            w.a aVar = this.f3193a.get(i10);
            Fragment fragment = aVar.f3211b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f3044u;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f3198f);
                fragment.setSharedElementNames(this.f3206n, this.f3207o);
            }
            switch (aVar.f3210a) {
                case 1:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, false);
                    this.f3041r.f(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3210a);
                case 3:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.e1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.E0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, false);
                    this.f3041r.r1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.u(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, false);
                    this.f3041r.k(fragment);
                    break;
                case 8:
                    this.f3041r.p1(fragment);
                    break;
                case 9:
                    this.f3041r.p1(null);
                    break;
                case 10:
                    this.f3041r.o1(fragment, aVar.f3218i);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        for (int size = this.f3193a.size() - 1; size >= 0; size--) {
            w.a aVar = this.f3193a.get(size);
            Fragment fragment = aVar.f3211b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f3044u;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.j1(this.f3198f));
                fragment.setSharedElementNames(this.f3207o, this.f3206n);
            }
            switch (aVar.f3210a) {
                case 1:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, true);
                    this.f3041r.e1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3210a);
                case 3:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.f(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.r1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, true);
                    this.f3041r.E0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.k(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3213d, aVar.f3214e, aVar.f3215f, aVar.f3216g);
                    this.f3041r.n1(fragment, true);
                    this.f3041r.u(fragment);
                    break;
                case 8:
                    this.f3041r.p1(null);
                    break;
                case 9:
                    this.f3041r.p1(fragment);
                    break;
                case 10:
                    this.f3041r.o1(fragment, aVar.f3217h);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment G(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f3193a.size()) {
            w.a aVar = this.f3193a.get(i10);
            int i11 = aVar.f3210a;
            if (i11 != 1) {
                if (i11 == 2) {
                    Fragment fragment3 = aVar.f3211b;
                    int i12 = fragment3.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId == i12) {
                            if (fragment4 == fragment3) {
                                z10 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f3193a.add(i10, new w.a(9, fragment4, true));
                                    i10++;
                                    fragment2 = null;
                                }
                                w.a aVar2 = new w.a(3, fragment4, true);
                                aVar2.f3213d = aVar.f3213d;
                                aVar2.f3215f = aVar.f3215f;
                                aVar2.f3214e = aVar.f3214e;
                                aVar2.f3216g = aVar.f3216g;
                                this.f3193a.add(i10, aVar2);
                                arrayList.remove(fragment4);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f3193a.remove(i10);
                        i10--;
                    } else {
                        aVar.f3210a = 1;
                        aVar.f3212c = true;
                        arrayList.add(fragment3);
                    }
                } else if (i11 == 3 || i11 == 6) {
                    arrayList.remove(aVar.f3211b);
                    Fragment fragment5 = aVar.f3211b;
                    if (fragment5 == fragment2) {
                        this.f3193a.add(i10, new w.a(9, fragment5));
                        i10++;
                        fragment2 = null;
                    }
                } else if (i11 != 7) {
                    if (i11 == 8) {
                        this.f3193a.add(i10, new w.a(9, fragment2, true));
                        aVar.f3212c = true;
                        i10++;
                        fragment2 = aVar.f3211b;
                    }
                }
                i10++;
            }
            arrayList.add(aVar.f3211b);
            i10++;
        }
        return fragment2;
    }

    public void H() {
        if (this.f3209q != null) {
            for (int i10 = 0; i10 < this.f3209q.size(); i10++) {
                this.f3209q.get(i10).run();
            }
            this.f3209q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment I(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3193a.size() - 1; size >= 0; size--) {
            w.a aVar = this.f3193a.get(size);
            int i10 = aVar.f3210a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f3211b;
                            break;
                        case 10:
                            aVar.f3218i = aVar.f3217h;
                            break;
                    }
                }
                arrayList.add(aVar.f3211b);
            }
            arrayList.remove(aVar.f3211b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.m
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3199g) {
            return true;
        }
        this.f3041r.e(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.i
    public String getName() {
        return this.f3201i;
    }

    @Override // androidx.fragment.app.w
    public int j() {
        return B(false);
    }

    @Override // androidx.fragment.app.w
    public int k() {
        return B(true);
    }

    @Override // androidx.fragment.app.w
    public void l() {
        o();
        this.f3041r.Z(this, false);
    }

    @Override // androidx.fragment.app.w
    public void m() {
        o();
        this.f3041r.Z(this, true);
    }

    @Override // androidx.fragment.app.w
    public w n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f3041r) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    void p(int i10, Fragment fragment, String str, int i11) {
        super.p(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f3041r;
    }

    @Override // androidx.fragment.app.w
    public w q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f3041r) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    public w r(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f3041r) {
            return super.r(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3043t >= 0) {
            sb2.append(" #");
            sb2.append(this.f3043t);
        }
        if (this.f3201i != null) {
            sb2.append(" ");
            sb2.append(this.f3201i);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.w
    public w w(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f3041r) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3041r);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.w(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    @Override // androidx.fragment.app.w
    public w x(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.f3041r) {
            return super.x(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.w
    public w z(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f3041r) {
            return super.z(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }
}
