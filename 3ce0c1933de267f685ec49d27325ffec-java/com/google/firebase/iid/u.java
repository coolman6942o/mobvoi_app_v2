package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.b;
import java.io.IOException;
/* loaded from: classes.dex */
final class u implements a<Bundle, String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ s f12525a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.f12525a = sVar;
    }

    @Override // com.google.android.gms.tasks.a
    public final /* synthetic */ String a(b<Bundle> bVar) throws Exception {
        String b10;
        b10 = this.f12525a.b(bVar.l(IOException.class));
        return b10;
    }
}
