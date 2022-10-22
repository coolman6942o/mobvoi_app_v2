package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.d0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final m f3175a;

    /* renamed from: b  reason: collision with root package name */
    private final v f3176b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f3177c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3178d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f3179e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f3180a;

        a(t tVar, View view) {
            this.f3180a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f3180a.removeOnAttachStateChangeListener(this);
            d0.q0(this.f3180a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3181a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f3181a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3181a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3181a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3181a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, v vVar, Fragment fragment) {
        this.f3175a = mVar;
        this.f3176b = vVar;
        this.f3177c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f3177c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f3177c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f3177c.performSaveInstanceState(bundle);
        this.f3175a.j(this.f3177c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3177c.mView != null) {
            t();
        }
        if (this.f3177c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3177c.mSavedViewState);
        }
        if (this.f3177c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f3177c.mSavedViewRegistryState);
        }
        if (!this.f3177c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3177c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3177c);
        }
        Fragment fragment = this.f3177c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        m mVar = this.f3175a;
        Fragment fragment2 = this.f3177c;
        mVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int j10 = this.f3176b.j(this.f3177c);
        Fragment fragment = this.f3177c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    void c() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3177c);
        }
        Fragment fragment = this.f3177c;
        Fragment fragment2 = fragment.mTarget;
        t tVar = null;
        if (fragment2 != null) {
            t n10 = this.f3176b.n(fragment2.mWho);
            if (n10 != null) {
                Fragment fragment3 = this.f3177c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                tVar = n10;
            } else {
                throw new IllegalStateException("Fragment " + this.f3177c + " declared target fragment " + this.f3177c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (tVar = this.f3176b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f3177c + " declared target fragment " + this.f3177c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (tVar != null) {
            tVar.m();
        }
        Fragment fragment4 = this.f3177c;
        fragment4.mHost = fragment4.mFragmentManager.u0();
        Fragment fragment5 = this.f3177c;
        fragment5.mParentFragment = fragment5.mFragmentManager.x0();
        this.f3175a.g(this.f3177c, false);
        this.f3177c.performAttach();
        this.f3175a.b(this.f3177c, false);
    }

    int d() {
        Fragment fragment = this.f3177c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i10 = this.f3179e;
        int i11 = b.f3181a[fragment.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i10 = Math.min(i10, 5);
            } else if (i11 == 3) {
                i10 = Math.min(i10, 1);
            } else if (i11 != 4) {
                i10 = Math.min(i10, -1);
            } else {
                i10 = Math.min(i10, 0);
            }
        }
        Fragment fragment2 = this.f3177c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i10 = Math.max(this.f3179e, 2);
                View view = this.f3177c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f3179e < 4 ? Math.min(i10, fragment2.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f3177c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        d0.e.b bVar = null;
        Fragment fragment3 = this.f3177c;
        ViewGroup viewGroup = fragment3.mContainer;
        if (viewGroup != null) {
            bVar = d0.n(viewGroup, fragment3.getParentFragmentManager()).l(this);
        }
        if (bVar == d0.e.b.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (bVar == d0.e.b.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f3177c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i10 = Math.min(i10, 1);
                } else {
                    i10 = Math.min(i10, -1);
                }
            }
        }
        Fragment fragment5 = this.f3177c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i10 + " for " + this.f3177c);
        }
        return i10;
    }

    void e() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3177c);
        }
        Fragment fragment = this.f3177c;
        if (!fragment.mIsCreated) {
            this.f3175a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f3177c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            m mVar = this.f3175a;
            Fragment fragment3 = this.f3177c;
            mVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f3177c.mState = 1;
    }

    void f() {
        String str;
        if (!this.f3177c.mFromLayout) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3177c);
            }
            Fragment fragment = this.f3177c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.f3177c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i10 = fragment2.mContainerId;
                if (i10 != 0) {
                    if (i10 != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.p0().c(this.f3177c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.f3177c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.f3177c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3177c.mContainerId) + " (" + str + ") for fragment " + this.f3177c);
                            }
                        } else if (!(viewGroup instanceof FragmentContainerView)) {
                            FragmentStrictMode.p(this.f3177c, viewGroup);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f3177c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment4 = this.f3177c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.f3177c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.f3177c;
                fragment5.mView.setTag(v0.b.f35560a, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.f3177c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                if (androidx.core.view.d0.W(this.f3177c.mView)) {
                    androidx.core.view.d0.q0(this.f3177c.mView);
                } else {
                    View view2 = this.f3177c.mView;
                    view2.addOnAttachStateChangeListener(new a(this, view2));
                }
                this.f3177c.performViewCreated();
                m mVar = this.f3175a;
                Fragment fragment7 = this.f3177c;
                mVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.f3177c.mView.getVisibility();
                this.f3177c.setPostOnViewCreatedAlpha(this.f3177c.mView.getAlpha());
                Fragment fragment8 = this.f3177c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.f3177c.setFocusedView(findFocus);
                        if (FragmentManager.H0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f3177c);
                        }
                    }
                    this.f3177c.mView.setAlpha(0.0f);
                }
            }
            this.f3177c.mState = 2;
        }
    }

    void g() {
        Fragment f10;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3177c);
        }
        Fragment fragment = this.f3177c;
        boolean z10 = true;
        boolean z11 = fragment.mRemoving && !fragment.isInBackStack();
        if (z11) {
            Fragment fragment2 = this.f3177c;
            if (!fragment2.mBeingSaved) {
                this.f3176b.B(fragment2.mWho, null);
            }
        }
        if (z11 || this.f3176b.p().m(this.f3177c)) {
            k<?> kVar = this.f3177c.mHost;
            if (kVar instanceof j0) {
                z10 = this.f3176b.p().j();
            } else if (kVar.f() instanceof Activity) {
                z10 = true ^ ((Activity) kVar.f()).isChangingConfigurations();
            }
            if ((z11 && !this.f3177c.mBeingSaved) || z10) {
                this.f3176b.p().b(this.f3177c);
            }
            this.f3177c.performDestroy();
            this.f3175a.d(this.f3177c, false);
            for (t tVar : this.f3176b.k()) {
                if (tVar != null) {
                    Fragment k10 = tVar.k();
                    if (this.f3177c.mWho.equals(k10.mTargetWho)) {
                        k10.mTarget = this.f3177c;
                        k10.mTargetWho = null;
                    }
                }
            }
            Fragment fragment3 = this.f3177c;
            String str = fragment3.mTargetWho;
            if (str != null) {
                fragment3.mTarget = this.f3176b.f(str);
            }
            this.f3176b.s(this);
            return;
        }
        String str2 = this.f3177c.mTargetWho;
        if (!(str2 == null || (f10 = this.f3176b.f(str2)) == null || !f10.mRetainInstance)) {
            this.f3177c.mTarget = f10;
        }
        this.f3177c.mState = 0;
    }

    void h() {
        View view;
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3177c);
        }
        Fragment fragment = this.f3177c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f3177c.performDestroyView();
        this.f3175a.n(this.f3177c, false);
        Fragment fragment2 = this.f3177c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.o(null);
        this.f3177c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3177c);
        }
        this.f3177c.performDetach();
        boolean z10 = false;
        this.f3175a.e(this.f3177c, false);
        Fragment fragment = this.f3177c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        }
        if (z10 || this.f3176b.p().m(this.f3177c)) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f3177c);
            }
            this.f3177c.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f3177c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3177c);
            }
            Fragment fragment2 = this.f3177c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f3177c.mSavedFragmentState);
            View view = this.f3177c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f3177c;
                fragment3.mView.setTag(v0.b.f35560a, fragment3);
                Fragment fragment4 = this.f3177c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f3177c.performViewCreated();
                m mVar = this.f3175a;
                Fragment fragment5 = this.f3177c;
                mVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f3177c.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment k() {
        return this.f3177c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f3178d) {
            try {
                this.f3178d = true;
                boolean z10 = false;
                while (true) {
                    int d10 = d();
                    Fragment fragment = this.f3177c;
                    int i10 = fragment.mState;
                    if (d10 != i10) {
                        if (d10 > i10) {
                            switch (i10 + 1) {
                                case 0:
                                    c();
                                    continue;
                                case 1:
                                    e();
                                    continue;
                                case 2:
                                    j();
                                    f();
                                    continue;
                                case 3:
                                    a();
                                    continue;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        d0.n(viewGroup3, fragment.getParentFragmentManager()).b(d0.e.c.b(this.f3177c.mView.getVisibility()), this);
                                    }
                                    this.f3177c.mState = 4;
                                    continue;
                                case 5:
                                    v();
                                    continue;
                                case 6:
                                    fragment.mState = 6;
                                    continue;
                                case 7:
                                    p();
                                    continue;
                                default:
                                    continue;
                            }
                        } else {
                            switch (i10 - 1) {
                                case -1:
                                    i();
                                    continue;
                                case 0:
                                    if (fragment.mBeingSaved && this.f3176b.q(fragment.mWho) == null) {
                                        s();
                                    }
                                    g();
                                    continue;
                                case 1:
                                    h();
                                    this.f3177c.mState = 1;
                                    continue;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    continue;
                                case 3:
                                    if (FragmentManager.H0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3177c);
                                    }
                                    Fragment fragment2 = this.f3177c;
                                    if (fragment2.mBeingSaved) {
                                        s();
                                    } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f3177c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        d0.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f3177c.mState = 3;
                                    continue;
                                case 4:
                                    w();
                                    continue;
                                case 5:
                                    fragment.mState = 5;
                                    continue;
                                case 6:
                                    n();
                                    continue;
                                default:
                                    continue;
                            }
                        }
                        z10 = true;
                    } else {
                        if (!z10 && i10 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f3177c.mBeingSaved) {
                            if (FragmentManager.H0(3)) {
                                Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f3177c);
                            }
                            this.f3176b.p().b(this.f3177c);
                            this.f3176b.s(this);
                            if (FragmentManager.H0(3)) {
                                Log.d("FragmentManager", "initState called for fragment: " + this.f3177c);
                            }
                            this.f3177c.initState();
                        }
                        Fragment fragment4 = this.f3177c;
                        if (fragment4.mHiddenChanged) {
                            if (!(fragment4.mView == null || (viewGroup = fragment4.mContainer) == null)) {
                                d0 n10 = d0.n(viewGroup, fragment4.getParentFragmentManager());
                                if (this.f3177c.mHidden) {
                                    n10.c(this);
                                } else {
                                    n10.e(this);
                                }
                            }
                            Fragment fragment5 = this.f3177c;
                            FragmentManager fragmentManager = fragment5.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.F0(fragment5);
                            }
                            Fragment fragment6 = this.f3177c;
                            fragment6.mHiddenChanged = false;
                            fragment6.onHiddenChanged(fragment6.mHidden);
                            this.f3177c.mChildFragmentManager.G();
                        }
                        return;
                    }
                }
            } finally {
                this.f3178d = false;
            }
        } else if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    void n() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3177c);
        }
        this.f3177c.performPause();
        this.f3175a.f(this.f3177c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f3177c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f3177c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f3177c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f3177c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f3177c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f3177c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f3177c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f3177c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    void p() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3177c);
        }
        View focusedView = this.f3177c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(this.f3177c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f3177c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f3177c.setFocusedView(null);
        this.f3177c.performResume();
        this.f3175a.i(this.f3177c, false);
        Fragment fragment = this.f3177c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q5;
        if (this.f3177c.mState <= -1 || (q5 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        FragmentState fragmentState = new FragmentState(this.f3177c);
        Fragment fragment = this.f3177c;
        if (fragment.mState <= -1 || fragmentState.f3039m != null) {
            fragmentState.f3039m = fragment.mSavedFragmentState;
        } else {
            Bundle q5 = q();
            fragmentState.f3039m = q5;
            if (this.f3177c.mTargetWho != null) {
                if (q5 == null) {
                    fragmentState.f3039m = new Bundle();
                }
                fragmentState.f3039m.putString("android:target_state", this.f3177c.mTargetWho);
                int i10 = this.f3177c.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.f3039m.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f3176b.B(this.f3177c.mWho, fragmentState);
    }

    void t() {
        if (this.f3177c.mView != null) {
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + this.f3177c + " with view " + this.f3177c.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3177c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f3177c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f3177c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f3177c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i10) {
        this.f3179e = i10;
    }

    void v() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3177c);
        }
        this.f3177c.performStart();
        this.f3175a.k(this.f3177c, false);
    }

    void w() {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3177c);
        }
        this.f3177c.performStop();
        this.f3175a.l(this.f3177c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, v vVar, ClassLoader classLoader, j jVar, FragmentState fragmentState) {
        this.f3175a = mVar;
        this.f3176b = vVar;
        Fragment a10 = fragmentState.a(jVar, classLoader);
        this.f3177c = a10;
        if (FragmentManager.H0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, v vVar, Fragment fragment, FragmentState fragmentState) {
        this.f3175a = mVar;
        this.f3176b = vVar;
        this.f3177c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f3039m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
