package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f9151a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9152b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f9153c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Object f9154d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f9155e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ z0 f9156f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(z0 z0Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f9156f = z0Var;
        this.f9151a = i10;
        this.f9152b = str;
        this.f9153c = obj;
        this.f9154d = obj2;
        this.f9155e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c10;
        long j10;
        char c11;
        long j11;
        char c12;
        z0 z0Var;
        k1 L = this.f9156f.f9815a.L();
        if (!L.t()) {
            this.f9156f.F(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c10 = this.f9156f.f9826c;
        if (c10 == 0) {
            if (this.f9156f.s().I()) {
                z0Var = this.f9156f;
                c12 = 'C';
            } else {
                z0Var = this.f9156f;
                c12 = 'c';
            }
            z0Var.f9826c = c12;
        }
        j10 = this.f9156f.f9827d;
        if (j10 < 0) {
            this.f9156f.f9827d = 12451L;
        }
        char charAt = "01VDIWEA?".charAt(this.f9151a);
        c11 = this.f9156f.f9826c;
        j11 = this.f9156f.f9827d;
        String E = z0.E(true, this.f9152b, this.f9153c, this.f9154d, this.f9155e);
        StringBuilder sb2 = new StringBuilder(String.valueOf(E).length() + 24);
        sb2.append("2");
        sb2.append(charAt);
        sb2.append(c11);
        sb2.append(j11);
        sb2.append(":");
        sb2.append(E);
        String sb3 = sb2.toString();
        if (sb3.length() > 1024) {
            sb3 = this.f9152b.substring(0, 1024);
        }
        L.f9431d.a(sb3, 1L);
    }
}
