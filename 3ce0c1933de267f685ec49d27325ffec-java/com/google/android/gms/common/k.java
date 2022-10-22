package com.google.android.gms.common;

import java.util.Arrays;
/* loaded from: classes.dex */
final class k extends j {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f8973b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f8973b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.j
    public final byte[] U1() {
        return this.f8973b;
    }
}
