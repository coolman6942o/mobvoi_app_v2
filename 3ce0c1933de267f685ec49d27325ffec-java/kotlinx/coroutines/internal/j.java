package kotlinx.coroutines.internal;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class j extends l {
    @Override // kotlinx.coroutines.internal.l
    public boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.l
    public final boolean s() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
