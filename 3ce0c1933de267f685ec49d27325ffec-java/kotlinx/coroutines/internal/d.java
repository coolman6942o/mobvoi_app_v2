package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlinx.coroutines.l0;
/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public final class d implements l0 {

    /* renamed from: a  reason: collision with root package name */
    private final f f30205a;

    public d(f fVar) {
        this.f30205a = fVar;
    }

    @Override // kotlinx.coroutines.l0
    public f getCoroutineContext() {
        return this.f30205a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
