package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.u;
import java.util.Map;
/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: b  reason: collision with root package name */
    private C0631u f14917b = null;

    /* renamed from: a  reason: collision with root package name */
    private final u f14916a = new u(h.f14225f);

    public C0554e a(C0595i iVar, Map<EnumC0553d, ?> map) throws C0550a {
        C0608m mVar = new C0608m(iVar);
        C0631u a10 = mVar.a();
        this.f14917b = a10;
        C0611n[] a11 = C0611n.a(mVar.b(), a10);
        int i10 = 0;
        for (C0611n nVar : a11) {
            i10 += nVar.b();
        }
        byte[] bArr = new byte[i10];
        int length = a11.length;
        for (int i11 = 0; i11 < length; i11++) {
            C0611n nVar2 = a11[i11];
            byte[] a12 = nVar2.a();
            int b10 = nVar2.b();
            a(a12, b10);
            for (int i12 = 0; i12 < b10; i12++) {
                bArr[(i12 * length) + i11] = a12[i12];
            }
        }
        return C0620q.a(bArr, map);
    }

    private void a(byte[] bArr, int i10) throws C0550a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f14916a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (C0550a unused) {
            throw C0550a.a();
        }
    }

    public C0631u a() {
        return this.f14917b;
    }
}
