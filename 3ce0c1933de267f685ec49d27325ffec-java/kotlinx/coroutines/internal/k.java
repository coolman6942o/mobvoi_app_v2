package kotlinx.coroutines.internal;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f30219a = new w("CONDITION_FALSE");

    static {
        new w("LIST_EMPTY");
    }

    public static final Object a() {
        return f30219a;
    }

    public static final l b(Object obj) {
        t tVar = obj instanceof t ? (t) obj : null;
        return tVar == null ? (l) obj : tVar.f30241a;
    }
}
