package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.x;
/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: classes2.dex */
final class L {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14582a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final J f14583b = new J();

    /* renamed from: c  reason: collision with root package name */
    private final K f14584c = new K();

    /* JADX INFO: Access modifiers changed from: package-private */
    public x a(int i10, C0591h hVar, int i11) throws C0550a {
        int[] a10 = M.a(hVar, i11, false, f14582a);
        try {
            return this.f14584c.a(i10, hVar, a10);
        } catch (C0550a unused) {
            return this.f14583b.a(i10, hVar, a10);
        }
    }
}
