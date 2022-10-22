package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.u;
import java.util.Map;
/* compiled from: Decoder.java */
/* renamed from: com.huawei.hms.scankit.p.xa  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0641xa {

    /* renamed from: a  reason: collision with root package name */
    private final u f15001a = new u(h.f14224e);

    public C0554e a(C0595i iVar, Map<EnumC0553d, ?> map) throws C0550a {
        C0603ka kaVar = new C0603ka(iVar);
        try {
            return a(kaVar, map);
        } catch (C0550a e10) {
            try {
                kaVar.e();
                kaVar.a(true);
                kaVar.d();
                kaVar.c();
                kaVar.a();
                C0554e a10 = a(kaVar, map);
                a10.a(new Ga(true));
                return a10;
            } catch (C0550a unused) {
                throw e10;
            }
        }
    }

    private C0554e a(C0603ka kaVar, Map<EnumC0553d, ?> map) throws C0550a {
        Ia d10 = kaVar.d();
        EnumC0647za b10 = kaVar.c().b();
        C0606la[] a10 = C0606la.a(kaVar.b(), d10, b10);
        int i10 = 0;
        for (C0606la laVar : a10) {
            i10 += laVar.b();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (C0606la laVar2 : a10) {
            byte[] a11 = laVar2.a();
            int b11 = laVar2.b();
            a(a11, b11);
            for (int i12 = 0; i12 < b11; i12++) {
                i11++;
                bArr[i11] = a11[i12];
            }
        }
        return C0638wa.a(bArr, d10, b10, map);
    }

    private void a(byte[] bArr, int i10) throws C0550a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f15001a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (C0550a unused) {
            throw C0550a.a();
        }
    }
}
