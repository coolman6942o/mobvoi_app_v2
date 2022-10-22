package com.google.firebase.iid;

import android.os.Bundle;
/* loaded from: classes.dex */
final class c extends b<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i10, int i11, Bundle bundle) {
        super(i10, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.b
    public final void c(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.b
    public final boolean d() {
        return false;
    }
}
