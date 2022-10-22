package androidx.navigation;

import android.os.Bundle;
/* compiled from: NavAction.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f3437a;

    /* renamed from: b  reason: collision with root package name */
    private q f3438b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3439c;

    public d(int i10) {
        this(i10, null);
    }

    public Bundle a() {
        return this.f3439c;
    }

    public int b() {
        return this.f3437a;
    }

    public q c() {
        return this.f3438b;
    }

    public void d(Bundle bundle) {
        this.f3439c = bundle;
    }

    public void e(q qVar) {
        this.f3438b = qVar;
    }

    public d(int i10, q qVar) {
        this(i10, qVar, null);
    }

    public d(int i10, q qVar, Bundle bundle) {
        this.f3437a = i10;
        this.f3438b = qVar;
        this.f3439c = bundle;
    }
}
