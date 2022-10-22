package org.greenrobot.eventbus;
/* compiled from: Subscription.java */
/* loaded from: classes3.dex */
final class n {

    /* renamed from: a  reason: collision with root package name */
    final Object f32509a;

    /* renamed from: b  reason: collision with root package name */
    final l f32510b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f32511c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Object obj, l lVar) {
        this.f32509a = obj;
        this.f32510b = lVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f32509a == nVar.f32509a && this.f32510b.equals(nVar.f32510b);
    }

    public int hashCode() {
        return this.f32509a.hashCode() + this.f32510b.f32496f.hashCode();
    }
}
