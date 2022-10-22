package com.google.android.gms.common.api.internal;

import android.app.Dialog;
/* loaded from: classes.dex */
final class l2 extends j1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Dialog f8649a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ k2 f8650b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2(k2 k2Var, Dialog dialog) {
        this.f8650b = k2Var;
        this.f8649a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void a() {
        this.f8650b.f8647b.p();
        if (this.f8649a.isShowing()) {
            this.f8649a.dismiss();
        }
    }
}
