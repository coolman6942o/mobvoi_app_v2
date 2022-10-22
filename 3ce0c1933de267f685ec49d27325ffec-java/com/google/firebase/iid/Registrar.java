package com.google.firebase.iid;

import androidx.annotation.Keep;
import b8.e;
import b8.f;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public final class Registrar implements e {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements d8.a {
        public a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    @Override // b8.e
    @Keep
    public final List<b8.a<?>> getComponents() {
        return Arrays.asList(b8.a.a(FirebaseInstanceId.class).a(f.a(com.google.firebase.a.class)).d(d.f12473a).b().c(), b8.a.a(d8.a.class).a(f.a(FirebaseInstanceId.class)).d(e.f12475a).c());
    }
}
