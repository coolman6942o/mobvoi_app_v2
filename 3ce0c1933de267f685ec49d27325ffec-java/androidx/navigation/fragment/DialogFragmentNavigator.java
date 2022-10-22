package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.navigation.k;
import androidx.navigation.q;
import androidx.navigation.t;
import java.util.HashSet;
@t.b("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends t<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3459a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f3460b;

    /* renamed from: c  reason: collision with root package name */
    private int f3461c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<String> f3462d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private n f3463e = new n(this) { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.n
        public void c(p pVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP) {
                c cVar = (c) pVar;
                if (!cVar.l0().isShowing()) {
                    NavHostFragment.Z(cVar).w();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class a extends k implements androidx.navigation.c {

        /* renamed from: i  reason: collision with root package name */
        private String f3464i;

        public a(t<? extends a> tVar) {
            super(tVar);
        }

        @Override // androidx.navigation.k
        public void n(Context context, AttributeSet attributeSet) {
            super.n(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.f3477a);
            String string = obtainAttributes.getString(d.f3478b);
            if (string != null) {
                u(string);
            }
            obtainAttributes.recycle();
        }

        public final String t() {
            String str = this.f3464i;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        public final a u(String str) {
            this.f3464i = str;
            return this;
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.f3459a = context;
        this.f3460b = fragmentManager;
    }

    @Override // androidx.navigation.t
    public void c(Bundle bundle) {
        if (bundle != null) {
            this.f3461c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i10 = 0; i10 < this.f3461c; i10++) {
                FragmentManager fragmentManager = this.f3460b;
                c cVar = (c) fragmentManager.g0("androidx-nav-fragment:navigator:dialog:" + i10);
                if (cVar != null) {
                    cVar.getLifecycle().a(this.f3463e);
                } else {
                    HashSet<String> hashSet = this.f3462d;
                    hashSet.add("androidx-nav-fragment:navigator:dialog:" + i10);
                }
            }
        }
    }

    @Override // androidx.navigation.t
    public Bundle d() {
        if (this.f3461c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f3461c);
        return bundle;
    }

    @Override // androidx.navigation.t
    public boolean e() {
        if (this.f3461c == 0) {
            return false;
        }
        if (this.f3460b.N0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        FragmentManager fragmentManager = this.f3460b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("androidx-nav-fragment:navigator:dialog:");
        int i10 = this.f3461c - 1;
        this.f3461c = i10;
        sb2.append(i10);
        Fragment g02 = fragmentManager.g0(sb2.toString());
        if (g02 != null) {
            g02.getLifecycle().c(this.f3463e);
            ((c) g02).b0();
        }
        return true;
    }

    /* renamed from: f */
    public a a() {
        return new a(this);
    }

    /* renamed from: g */
    public k b(a aVar, Bundle bundle, q qVar, t.a aVar2) {
        if (this.f3460b.N0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String t10 = aVar.t();
        if (t10.charAt(0) == '.') {
            t10 = this.f3459a.getPackageName() + t10;
        }
        Fragment a10 = this.f3460b.s0().a(this.f3459a.getClassLoader(), t10);
        if (c.class.isAssignableFrom(a10.getClass())) {
            c cVar = (c) a10;
            cVar.setArguments(bundle);
            cVar.getLifecycle().a(this.f3463e);
            FragmentManager fragmentManager = this.f3460b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("androidx-nav-fragment:navigator:dialog:");
            int i10 = this.f3461c;
            this.f3461c = i10 + 1;
            sb2.append(i10);
            cVar.p0(fragmentManager, sb2.toString());
            return aVar;
        }
        throw new IllegalArgumentException("Dialog destination " + aVar.t() + " is not an instance of DialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (this.f3462d.remove(fragment.getTag())) {
            fragment.getLifecycle().a(this.f3463e);
        }
    }
}
