package com.google.android.gms.common;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
abstract class l extends j {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference<byte[]> f8974c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<byte[]> f8975b = f8974c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(byte[] bArr) {
        super(bArr);
    }

    protected abstract byte[] B2();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.j
    public final byte[] U1() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f8975b.get();
            if (bArr == null) {
                bArr = B2();
                this.f8975b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
