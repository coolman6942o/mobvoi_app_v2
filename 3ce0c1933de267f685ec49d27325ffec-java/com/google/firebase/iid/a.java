package com.google.firebase.iid;

import android.os.Bundle;
/* loaded from: classes.dex */
final class a extends b<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i10, int i11, Bundle bundle) {
        super(i10, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.b
    public final void c(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a(null);
        } else {
            b(new zzac(4, "Invalid response to one way request"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.b
    public final boolean d() {
        return true;
    }
}
