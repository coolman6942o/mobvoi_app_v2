package com.paypal.android.sdk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public abstract class f1 extends d1 {

    /* renamed from: d  reason: collision with root package name */
    private static final String f21222d = "f1";

    /* renamed from: a  reason: collision with root package name */
    private final s1 f21223a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f21224b = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    /* renamed from: c  reason: collision with root package name */
    private final int f21225c;

    public f1(int i10, s1 s1Var) {
        this.f21225c = i10;
        this.f21223a = s1Var;
    }

    @Override // com.paypal.android.sdk.o1
    public final void a() {
    }

    @Override // com.paypal.android.sdk.o1
    public final boolean a(r1 r1Var) {
        this.f21224b.submit(new g1(this, r1Var));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int g();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean h(r1 r1Var);
}
