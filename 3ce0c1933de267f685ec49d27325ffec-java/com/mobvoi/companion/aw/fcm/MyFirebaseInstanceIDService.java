package com.mobvoi.companion.aw.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mobvoi.android.common.utils.k;
import ii.a;
import nc.d;
/* loaded from: classes2.dex */
public class MyFirebaseInstanceIDService extends a {

    /* renamed from: i  reason: collision with root package name */
    public d f16261i;

    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    public void f() {
        super.f();
        String c10 = FirebaseInstanceId.b().c();
        a.f(c10);
        k.c("MyFirebaseService", "token = %s", c10);
        this.f16261i.f();
    }
}
