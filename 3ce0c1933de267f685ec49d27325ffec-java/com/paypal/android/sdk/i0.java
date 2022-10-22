package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private List f21346a;

    /* renamed from: b  reason: collision with root package name */
    private List f21347b;

    private i0() {
        this.f21346a = Collections.synchronizedList(new ArrayList());
        this.f21347b = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i0(byte b10) {
        this();
    }

    public static i0 a() {
        i0 i0Var;
        i0Var = j0.f21385a;
        return i0Var;
    }

    private void c() {
        if (!this.f21347b.isEmpty()) {
            synchronized (this) {
                if (!this.f21347b.isEmpty()) {
                    h0 h0Var = (h0) this.f21347b.get(0);
                    this.f21347b.remove(0);
                    this.f21346a.add(h0Var);
                    new Thread(h0Var).start();
                }
            }
        }
    }

    public final void b(h0 h0Var) {
        this.f21347b.add(h0Var);
        if (this.f21346a.size() < 3) {
            c();
        }
    }

    public final void d(h0 h0Var) {
        this.f21346a.remove(h0Var);
        c();
    }
}
