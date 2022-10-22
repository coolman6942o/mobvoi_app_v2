package com.google.android.gms.internal.measurement;

import java.util.Arrays;
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    final int f9557a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f9558b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i10, byte[] bArr) {
        this.f9557a = i10;
        this.f9558b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f9557a == pVar.f9557a && Arrays.equals(this.f9558b, pVar.f9558b);
    }

    public final int hashCode() {
        return ((this.f9557a + 527) * 31) + Arrays.hashCode(this.f9558b);
    }
}
