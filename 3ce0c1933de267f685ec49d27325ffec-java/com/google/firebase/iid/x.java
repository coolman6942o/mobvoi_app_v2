package com.google.firebase.iid;

import android.util.Base64;
import b6.h;
import java.security.KeyPair;
/* loaded from: classes.dex */
final class x {

    /* renamed from: a  reason: collision with root package name */
    private final KeyPair f12526a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12527b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(KeyPair keyPair, long j10) {
        this.f12526a = keyPair;
        this.f12527b = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        return Base64.encodeToString(this.f12526a.getPublic().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        return Base64.encodeToString(this.f12526a.getPrivate().getEncoded(), 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyPair a() {
        return this.f12526a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f12527b == xVar.f12527b && this.f12526a.getPublic().equals(xVar.f12526a.getPublic()) && this.f12526a.getPrivate().equals(xVar.f12526a.getPrivate());
    }

    public final int hashCode() {
        return h.b(this.f12526a.getPublic(), this.f12526a.getPrivate(), Long.valueOf(this.f12527b));
    }
}
