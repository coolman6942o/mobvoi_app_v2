package com.google.common.collect;
/* loaded from: classes.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    BoundType(boolean z10) {
        this.inclusive = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BoundType b(boolean z10) {
        return z10 ? CLOSED : OPEN;
    }
}
