package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;
/* loaded from: classes.dex */
final class u1 implements a<Boolean, Void> {
    @Override // com.google.android.gms.tasks.a
    public final /* synthetic */ Void a(b<Boolean> bVar) throws Exception {
        if (bVar.k().booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
