package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.a;
import com.google.zxing.common.reedsolomon.c;
import java.util.Map;
import o8.b;
/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f13461a = new c(a.f13421l);

    private void a(byte[] bArr, int i10) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        try {
            this.f13461a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private b c(a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        h e10 = aVar.e();
        ErrorCorrectionLevel d10 = aVar.d().d();
        b[] b10 = b.b(aVar.c(), e10, d10);
        int i10 = 0;
        for (b bVar : b10) {
            i10 += bVar.c();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (b bVar2 : b10) {
            byte[] a10 = bVar2.a();
            int c10 = bVar2.c();
            a(a10, c10);
            for (int i12 = 0; i12 < c10; i12++) {
                i11++;
                bArr[i11] = a10[i12];
            }
        }
        return d.a(bArr, e10, d10, map);
    }

    public b b(com.google.zxing.common.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e10;
        a aVar = new a(bVar);
        FormatException e11 = null;
        try {
            return c(aVar, map);
        } catch (ChecksumException e12) {
            e10 = e12;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                b c10 = c(aVar, map);
                c10.m(new g(true));
                return c10;
            } catch (ChecksumException | FormatException e13) {
                if (e11 != null) {
                    throw e11;
                } else if (e10 != null) {
                    throw e10;
                } else {
                    throw e13;
                }
            }
        } catch (FormatException e14) {
            e11 = e14;
            e10 = null;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            b c102 = c(aVar, map);
            c102.m(new g(true));
            return c102;
        }
    }
}
