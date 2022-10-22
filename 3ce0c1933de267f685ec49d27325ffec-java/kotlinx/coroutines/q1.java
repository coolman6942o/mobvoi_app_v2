package kotlinx.coroutines;

import kotlinx.coroutines.internal.w;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final w f30276a = new w("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final w f30277b = new w("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final w f30278c = new w("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final w f30279d = new w("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final w f30280e = new w("SEALED");

    /* renamed from: f  reason: collision with root package name */
    private static final v0 f30281f = new v0(false);

    /* renamed from: g  reason: collision with root package name */
    private static final v0 f30282g = new v0(true);

    public static final Object g(Object obj) {
        return obj instanceof e1 ? new f1((e1) obj) : obj;
    }

    public static final Object h(Object obj) {
        f1 f1Var = obj instanceof f1 ? (f1) obj : null;
        return f1Var == null ? obj : f1Var.f30172a;
    }
}
