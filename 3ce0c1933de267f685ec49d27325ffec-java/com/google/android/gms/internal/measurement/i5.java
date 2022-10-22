package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i5 extends h5 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f9370c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(j5 j5Var) {
        super(j5Var);
        this.f9325b.t(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v() {
        return this.f9370c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean x();

    public final void y() {
        if (!this.f9370c) {
            x();
            this.f9325b.d0();
            this.f9370c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
