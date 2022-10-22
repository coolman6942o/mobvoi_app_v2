package androidx.core.os;

import j0.c;
/* loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(c.d(str, "The operation has been canceled."));
    }
}
