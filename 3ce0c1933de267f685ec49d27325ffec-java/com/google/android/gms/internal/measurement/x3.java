package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import androidx.collection.a;
import b6.i;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.Map;
/* loaded from: classes.dex */
public final class x3 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    protected w3 f9794c;

    /* renamed from: d  reason: collision with root package name */
    private volatile w3 f9795d;

    /* renamed from: e  reason: collision with root package name */
    private w3 f9796e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Activity, w3> f9797f = new a();

    /* renamed from: g  reason: collision with root package name */
    private String f9798g;

    public x3(d2 d2Var) {
        super(d2Var);
    }

    private final void F(Activity activity, w3 w3Var, boolean z10) {
        w3 w3Var2 = this.f9795d == null ? this.f9796e : this.f9795d;
        if (w3Var.f9773b == null) {
            w3Var = new w3(w3Var.f9772a, K(activity.getClass().getCanonicalName()), w3Var.f9774c);
        }
        this.f9796e = this.f9795d;
        b().c();
        this.f9795d = w3Var;
        d().J(new y3(this, z10, w3Var2, w3Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(w3 w3Var) {
        h().C(b().c());
        if (q().H(w3Var.f9775d)) {
            w3Var.f9775d = false;
        }
    }

    public static void H(w3 w3Var, Bundle bundle, boolean z10) {
        if (bundle != null && w3Var != null && (!bundle.containsKey("_sc") || z10)) {
            String str = w3Var.f9772a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", w3Var.f9773b);
            bundle.putLong("_si", w3Var.f9774c);
        } else if (bundle != null && w3Var == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    private static String K(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final w3 L(Activity activity) {
        i.k(activity);
        w3 w3Var = this.f9797f.get(activity);
        if (w3Var != null) {
            return w3Var;
        }
        w3 w3Var2 = new w3(null, K(activity.getClass().getCanonicalName()), p().x0());
        this.f9797f.put(activity, w3Var2);
        return w3Var2;
    }

    public final void A(Activity activity) {
        this.f9797f.remove(activity);
    }

    public final void B(Activity activity) {
        w3 L = L(activity);
        this.f9796e = this.f9795d;
        b().c();
        this.f9795d = null;
        d().J(new z3(this, L));
    }

    public final void C(Activity activity) {
        F(activity, L(activity), false);
        r h10 = h();
        h10.d().J(new u(h10, h10.b().c()));
    }

    public final void D(Activity activity, Bundle bundle) {
        w3 w3Var;
        if (bundle != null && (w3Var = this.f9797f.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", w3Var.f9774c);
            bundle2.putString(ContactConstant.CallsRecordKeys.NAME, w3Var.f9772a);
            bundle2.putString("referrer_name", w3Var.f9773b);
            bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        }
    }

    public final void E(Activity activity, String str, String str2) {
        d();
        if (!z1.z()) {
            c().N().a("setCurrentScreen must be called from the main thread");
        } else if (this.f9795d == null) {
            c().N().a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f9797f.get(activity) == null) {
            c().N().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = K(activity.getClass().getCanonicalName());
            }
            boolean equals = this.f9795d.f9773b.equals(str2);
            boolean C0 = r5.C0(this.f9795d.f9772a, str);
            if (equals && C0) {
                c().O().a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                c().N().d("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                c().R().c("Setting current screen to name, class", str == null ? LpaConstants.VALUE_NULL : str, str2);
                w3 w3Var = new w3(str, str2, p().x0());
                this.f9797f.put(activity, w3Var);
                F(activity, w3Var, true);
            } else {
                c().N().d("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void J(String str, w3 w3Var) {
        e();
        synchronized (this) {
            String str2 = this.f9798g;
            if (str2 == null || str2.equals(str) || w3Var != null) {
                this.f9798g = str;
            }
        }
    }

    public final w3 M() {
        u();
        e();
        return this.f9794c;
    }

    public final w3 N() {
        return this.f9795d;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }

    public final void z(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) != null) {
            this.f9797f.put(activity, new w3(bundle2.getString(ContactConstant.CallsRecordKeys.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }
}
