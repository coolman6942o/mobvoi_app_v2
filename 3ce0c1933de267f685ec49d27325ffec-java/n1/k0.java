package n1;

import android.os.IBinder;
/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class k0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f30936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(IBinder iBinder) {
        this.f30936a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).f30936a.equals(this.f30936a);
    }

    public int hashCode() {
        return this.f30936a.hashCode();
    }
}
