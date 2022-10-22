package kotlin;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Standard.kt */
/* loaded from: classes3.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String message) {
        super(message);
        i.f(message, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i10, f fVar) {
        this((i10 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
