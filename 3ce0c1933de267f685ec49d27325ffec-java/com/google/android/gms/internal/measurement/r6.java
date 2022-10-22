package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r6 extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r6(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = q6.f9622e;
        atomicBoolean.set(true);
    }
}
