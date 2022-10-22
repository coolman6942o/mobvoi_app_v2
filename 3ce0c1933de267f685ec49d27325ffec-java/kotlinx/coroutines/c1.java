package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
/* compiled from: CoroutineScope.kt */
/* loaded from: classes3.dex */
public final class c1 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final c1 f30125a = new c1();

    private c1() {
    }

    @Override // kotlinx.coroutines.l0
    public f getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
