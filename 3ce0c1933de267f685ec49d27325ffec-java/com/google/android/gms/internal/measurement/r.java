package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import androidx.collection.a;
import b6.i;
import java.util.Map;
/* loaded from: classes.dex */
public final class r extends y2 {

    /* renamed from: d  reason: collision with root package name */
    private long f9634d;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f9633c = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f9632b = new a();

    public r(d2 d2Var) {
        super(d2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str, long j10) {
        e();
        i.g(str);
        Integer num = this.f9633c.get(str);
        if (num != null) {
            w3 M = m().M();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f9633c.remove(str);
                Long l10 = this.f9632b.get(str);
                if (l10 == null) {
                    c().K().a("First ad unit exposure time was never set");
                } else {
                    this.f9632b.remove(str);
                    z(str, j10 - l10.longValue(), M);
                }
                if (this.f9633c.isEmpty()) {
                    long j11 = this.f9634d;
                    if (j11 == 0) {
                        c().K().a("First ad exposure time was never set");
                        return;
                    }
                    v(j10 - j11, M);
                    this.f9634d = 0L;
                    return;
                }
                return;
            }
            this.f9633c.put(str, Integer.valueOf(intValue));
            return;
        }
        c().K().d("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(long j10) {
        for (String str : this.f9632b.keySet()) {
            this.f9632b.put(str, Long.valueOf(j10));
        }
        if (!this.f9632b.isEmpty()) {
            this.f9634d = j10;
        }
    }

    private final void v(long j10, w3 w3Var) {
        if (w3Var == null) {
            c().R().a("Not logging ad exposure. No active activity");
        } else if (j10 < 1000) {
            c().R().d("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j10);
            x3.H(w3Var, bundle, true);
            i().G("am", "_xa", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str, long j10) {
        e();
        i.g(str);
        if (this.f9633c.isEmpty()) {
            this.f9634d = j10;
        }
        Integer num = this.f9633c.get(str);
        if (num != null) {
            this.f9633c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f9633c.size() >= 100) {
            c().N().a("Too many ads visible");
        } else {
            this.f9633c.put(str, 1);
            this.f9632b.put(str, Long.valueOf(j10));
        }
    }

    private final void z(String str, long j10, w3 w3Var) {
        if (w3Var == null) {
            c().R().a("Not logging ad unit exposure. No active activity");
        } else if (j10 < 1000) {
            c().R().d("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j10);
            x3.H(w3Var, bundle, true);
            i().G("am", "_xu", bundle);
        }
    }

    public final void C(long j10) {
        w3 M = m().M();
        for (String str : this.f9632b.keySet()) {
            z(str, j10 - this.f9632b.get(str).longValue(), M);
        }
        if (!this.f9632b.isEmpty()) {
            v(j10 - this.f9634d, M);
        }
        D(j10);
    }

    public final void t(String str) {
        if (str == null || str.length() == 0) {
            c().K().a("Ad unit id must be a non-empty string");
            return;
        }
        d().J(new s(this, str, b().c()));
    }

    public final void u(String str) {
        if (str == null || str.length() == 0) {
            c().K().a("Ad unit id must be a non-empty string");
            return;
        }
        d().J(new t(this, str, b().c()));
    }
}
