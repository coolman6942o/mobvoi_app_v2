package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public final class b implements c<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30066a = new b();

    private b() {
    }

    @Override // kotlin.coroutines.c
    public f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
