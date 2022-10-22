package com.google.firebase.crash;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseCrash f12442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FirebaseCrash firebaseCrash) {
        this.f12442a = firebaseCrash;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12442a.e();
    }
}
