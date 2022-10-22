package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    private Handler f3088a;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3097j;

    /* renamed from: l  reason: collision with root package name */
    private Dialog f3099l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3100m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f3101n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3102o;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f3089b = new a();

    /* renamed from: c  reason: collision with root package name */
    private DialogInterface.OnCancelListener f3090c = new b();

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnDismissListener f3091d = new DialogInterface$OnDismissListenerC0032c();

    /* renamed from: e  reason: collision with root package name */
    private int f3092e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f3093f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3094g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3095h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f3096i = -1;

    /* renamed from: k  reason: collision with root package name */
    private x<p> f3098k = new d();

    /* renamed from: p  reason: collision with root package name */
    private boolean f3103p = false;

    /* compiled from: DialogFragment.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            c.this.f3091d.onDismiss(c.this.f3099l);
        }
    }

    /* compiled from: DialogFragment.java */
    /* loaded from: classes.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.f3099l != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.f3099l);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class DialogInterface$OnDismissListenerC0032c implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0032c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.f3099l != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.f3099l);
            }
        }
    }

    /* compiled from: DialogFragment.java */
    /* loaded from: classes.dex */
    class d implements x<p> {
        d() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public void a(p pVar) {
            if (pVar != null && c.this.f3095h) {
                View requireView = c.this.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (c.this.f3099l != null) {
                    if (FragmentManager.H0(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + c.this.f3099l);
                    }
                    c.this.f3099l.setContentView(requireView);
                }
            }
        }
    }

    /* compiled from: DialogFragment.java */
    /* loaded from: classes.dex */
    class e extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f3108a;

        e(h hVar) {
            this.f3108a = hVar;
        }

        @Override // androidx.fragment.app.h
        public View c(int i10) {
            if (this.f3108a.d()) {
                return this.f3108a.c(i10);
            }
            return c.this.i0(i10);
        }

        @Override // androidx.fragment.app.h
        public boolean d() {
            return this.f3108a.d() || c.this.j0();
        }
    }

    private void d0(boolean z10, boolean z11) {
        if (!this.f3101n) {
            this.f3101n = true;
            this.f3102o = false;
            Dialog dialog = this.f3099l;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.f3099l.dismiss();
                if (!z11) {
                    if (Looper.myLooper() == this.f3088a.getLooper()) {
                        onDismiss(this.f3099l);
                    } else {
                        this.f3088a.post(this.f3089b);
                    }
                }
            }
            this.f3100m = true;
            if (this.f3096i >= 0) {
                getParentFragmentManager().X0(this.f3096i, 1, z10);
                this.f3096i = -1;
                return;
            }
            w l10 = getParentFragmentManager().l();
            l10.y(true);
            l10.r(this);
            if (z10) {
                l10.k();
            } else {
                l10.j();
            }
        }
    }

    private void k0(Bundle bundle) {
        if (this.f3095h && !this.f3103p) {
            try {
                this.f3097j = true;
                Dialog h02 = h0(bundle);
                this.f3099l = h02;
                if (this.f3095h) {
                    o0(h02, this.f3092e);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.f3099l.setOwnerActivity((Activity) context);
                    }
                    this.f3099l.setCancelable(this.f3094g);
                    this.f3099l.setOnCancelListener(this.f3090c);
                    this.f3099l.setOnDismissListener(this.f3091d);
                    this.f3103p = true;
                } else {
                    this.f3099l = null;
                }
            } finally {
                this.f3097j = false;
            }
        }
    }

    public void b0() {
        d0(false, false);
    }

    public void c0() {
        d0(true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public h createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    public Dialog e0() {
        return this.f3099l;
    }

    public int f0() {
        return this.f3093f;
    }

    public boolean g0() {
        return this.f3094g;
    }

    public Dialog h0(Bundle bundle) {
        if (FragmentManager.H0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), f0());
    }

    View i0(int i10) {
        Dialog dialog = this.f3099l;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    boolean j0() {
        return this.f3103p;
    }

    public final Dialog l0() {
        Dialog e02 = e0();
        if (e02 != null) {
            return e02;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void m0(boolean z10) {
        this.f3095h = z10;
    }

    public void n0(int i10, int i11) {
        if (FragmentManager.H0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i10 + ", " + i11);
        }
        this.f3092e = i10;
        if (i10 == 2 || i10 == 3) {
            this.f3093f = 16973913;
        }
        if (i11 != 0) {
            this.f3093f = i11;
        }
    }

    public void o0(Dialog dialog, int i10) {
        if (!(i10 == 1 || i10 == 2)) {
            if (i10 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().j(this.f3098k);
        if (!this.f3102o) {
            this.f3101n = false;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3088a = new Handler();
        this.f3095h = this.mContainerId == 0;
        if (bundle != null) {
            this.f3092e = bundle.getInt("android:style", 0);
            this.f3093f = bundle.getInt("android:theme", 0);
            this.f3094g = bundle.getBoolean("android:cancelable", true);
            this.f3095h = bundle.getBoolean("android:showsDialog", this.f3095h);
            this.f3096i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f3099l;
        if (dialog != null) {
            this.f3100m = true;
            dialog.setOnDismissListener(null);
            this.f3099l.dismiss();
            if (!this.f3101n) {
                onDismiss(this.f3099l);
            }
            this.f3099l = null;
            this.f3103p = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.f3102o && !this.f3101n) {
            this.f3101n = true;
        }
        getViewLifecycleOwnerLiveData().n(this.f3098k);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f3100m) {
            if (FragmentManager.H0(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            d0(true, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (!this.f3095h || this.f3097j) {
            if (FragmentManager.H0(2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (!this.f3095h) {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                } else {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                }
            }
            return onGetLayoutInflater;
        }
        k0(bundle);
        if (FragmentManager.H0(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f3099l;
        return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f3099l;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i10 = this.f3092e;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f3093f;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f3094g;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f3095h;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f3096i;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f3099l;
        if (dialog != null) {
            this.f3100m = false;
            dialog.show();
            View decorView = this.f3099l.getWindow().getDecorView();
            k0.a(decorView, this);
            l0.a(decorView, this);
            androidx.savedstate.d.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f3099l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f3099l != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f3099l.onRestoreInstanceState(bundle2);
        }
    }

    public void p0(FragmentManager fragmentManager, String str) {
        this.f3101n = false;
        this.f3102o = true;
        w l10 = fragmentManager.l();
        l10.y(true);
        l10.e(this, str);
        l10.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.f3099l != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f3099l.onRestoreInstanceState(bundle2);
        }
    }
}
