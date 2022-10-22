package com.google.android.gms.tasks;
/* loaded from: classes.dex */
public class c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final s<TResult> f10149a = new s<>();

    public b<TResult> a() {
        return this.f10149a;
    }

    public void b(Exception exc) {
        this.f10149a.p(exc);
    }

    public void c(TResult tresult) {
        this.f10149a.q(tresult);
    }

    public boolean d(Exception exc) {
        return this.f10149a.r(exc);
    }

    public boolean e(TResult tresult) {
        return this.f10149a.s(tresult);
    }
}
