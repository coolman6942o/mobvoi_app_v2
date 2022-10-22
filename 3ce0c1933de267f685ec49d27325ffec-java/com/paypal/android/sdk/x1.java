package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class x1 implements p1 {

    /* renamed from: a  reason: collision with root package name */
    final dc f22054a;

    public x1(dc dcVar) {
        this.f22054a = dcVar;
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        for (dc dcVar : dc.values()) {
            arrayList.add(new x1(dcVar));
        }
        return arrayList;
    }

    @Override // com.paypal.android.sdk.p1
    public String a() {
        return this.f22054a.name();
    }

    @Override // com.paypal.android.sdk.p1
    public ca b() {
        return this.f22054a.a();
    }

    @Override // com.paypal.android.sdk.p1
    public String c() {
        return this.f22054a.b();
    }
}
