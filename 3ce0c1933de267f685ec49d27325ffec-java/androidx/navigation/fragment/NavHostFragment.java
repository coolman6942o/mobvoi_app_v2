package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.c;
import androidx.navigation.NavController;
import androidx.navigation.fragment.b;
import androidx.navigation.o;
import androidx.navigation.s;
import androidx.navigation.t;
import androidx.navigation.w;
/* loaded from: classes.dex */
public class NavHostFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private o f3465a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3466b = null;

    /* renamed from: c  reason: collision with root package name */
    private View f3467c;

    /* renamed from: d  reason: collision with root package name */
    private int f3468d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3469e;

    public static NavController Z(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).b0();
            }
            Fragment y02 = fragment2.getParentFragmentManager().y0();
            if (y02 instanceof NavHostFragment) {
                return ((NavHostFragment) y02).b0();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return s.b(view);
        }
        Dialog e02 = fragment instanceof c ? ((c) fragment).e0() : null;
        if (!(e02 == null || e02.getWindow() == null)) {
            return s.b(e02.getWindow().getDecorView());
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int a0() {
        int id2 = getId();
        return (id2 == 0 || id2 == -1) ? c.f3476a : id2;
    }

    @Deprecated
    protected t<? extends b.a> Y() {
        return new b(requireContext(), getChildFragmentManager(), a0());
    }

    public final NavController b0() {
        o oVar = this.f3465a;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    protected void c0(NavController navController) {
        navController.m().a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.m().a(Y());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f3469e) {
            getParentFragmentManager().l().x(this).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator) this.f3465a.m().d(DialogFragmentNavigator.class)).h(fragment);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        o oVar = new o(requireContext());
        this.f3465a = oVar;
        oVar.G(this);
        this.f3465a.H(requireActivity().getOnBackPressedDispatcher());
        o oVar2 = this.f3465a;
        Boolean bool = this.f3466b;
        int i10 = 0;
        oVar2.c(bool != null && bool.booleanValue());
        Bundle bundle3 = null;
        this.f3466b = null;
        this.f3465a.I(getViewModelStore());
        c0(this.f3465a);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f3469e = true;
                getParentFragmentManager().l().x(this).j();
            }
            this.f3468d = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.f3465a.A(bundle2);
        }
        int i11 = this.f3468d;
        if (i11 != 0) {
            this.f3465a.C(i11);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i10 = arguments.getInt("android-support-nav:fragment:graphId");
            }
            if (arguments != null) {
                bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
            }
            if (i10 != 0) {
                this.f3465a.D(i10, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(a0());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f3467c;
        if (view != null && s.b(view) == this.f3465a) {
            s.e(this.f3467c, null);
        }
        this.f3467c = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f3571g);
        int resourceId = obtainStyledAttributes.getResourceId(w.f3572h, 0);
        if (resourceId != 0) {
            this.f3468d = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.f3481e);
        if (obtainStyledAttributes2.getBoolean(d.f3482f, false)) {
            this.f3469e = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean z10) {
        o oVar = this.f3465a;
        if (oVar != null) {
            oVar.c(z10);
        } else {
            this.f3466b = Boolean.valueOf(z10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle B = this.f3465a.B();
        if (B != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", B);
        }
        if (this.f3469e) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i10 = this.f3468d;
        if (i10 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            s.e(view, this.f3465a);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.f3467c = view2;
                if (view2.getId() == getId()) {
                    s.e(this.f3467c, this.f3465a);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
