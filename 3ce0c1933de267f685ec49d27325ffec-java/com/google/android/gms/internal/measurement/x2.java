package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9789a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9790b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9791c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f9792d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ f2 f9793e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x2(f2 f2Var, String str, String str2, String str3, long j10) {
        this.f9793e = f2Var;
        this.f9789a = str;
        this.f9790b = str2;
        this.f9791c = str3;
        this.f9792d = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        String str = this.f9789a;
        if (str == null) {
            j5Var2 = this.f9793e.f9262a;
            j5Var2.e0().r0().J(this.f9790b, null);
            return;
        }
        w3 w3Var = new w3(this.f9791c, str, this.f9792d);
        j5Var = this.f9793e.f9262a;
        j5Var.e0().r0().J(this.f9790b, w3Var);
    }
}
