package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
final class f implements c<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f30181a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.coroutines.f f30182b = EmptyCoroutineContext.INSTANCE;

    private f() {
    }

    @Override // kotlin.coroutines.c
    public kotlin.coroutines.f getContext() {
        return f30182b;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
    }
}
