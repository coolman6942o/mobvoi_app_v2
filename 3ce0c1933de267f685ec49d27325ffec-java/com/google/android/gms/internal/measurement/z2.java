package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class z2 extends y2 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f9848b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2(d2 d2Var) {
        super(d2Var);
        this.f9815a.k0(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        return this.f9848b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean v();

    protected void w() {
    }

    public final void x() {
        if (!this.f9848b) {
            w();
            this.f9815a.B0();
            this.f9848b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void y() {
        if (this.f9848b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!v()) {
            this.f9815a.B0();
            this.f9848b = true;
        }
    }
}
