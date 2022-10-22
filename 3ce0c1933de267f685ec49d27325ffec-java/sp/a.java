package sp;

import kotlin.jvm.internal.i;
import okio.c;
import rp.b;
import rp.d;
import rp.g;
/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    private static final byte[] f35034a = b.a("0123456789abcdef");

    public static final byte[] a() {
        return f35034a;
    }

    public static final boolean b(g segment, int i10, byte[] bytes, int i11, int i12) {
        i.f(segment, "segment");
        i.f(bytes, "bytes");
        int i13 = segment.f33665c;
        byte[] bArr = segment.f33663a;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.f33668f;
                i.d(segment);
                byte[] bArr2 = segment.f33663a;
                bArr = bArr2;
                i10 = segment.f33664b;
                i13 = segment.f33665c;
            }
            if (bArr[i10] != bytes[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String c(c readUtf8Line, long j10) {
        i.f(readUtf8Line, "$this$readUtf8Line");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (readUtf8Line.u(j11) == ((byte) 13)) {
                String W = readUtf8Line.W(j11);
                readUtf8Line.f(2L);
                return W;
            }
        }
        String W2 = readUtf8Line.W(j10);
        readUtf8Line.f(1L);
        return W2;
    }

    public static final int d(c selectPrefix, d options, boolean z10) {
        int i10;
        int i11;
        int i12;
        g gVar;
        int i13;
        i.f(selectPrefix, "$this$selectPrefix");
        i.f(options, "options");
        g gVar2 = selectPrefix.f32393a;
        if (gVar2 == null) {
            return z10 ? -2 : -1;
        }
        byte[] bArr = gVar2.f33663a;
        int i14 = gVar2.f33664b;
        int i15 = gVar2.f33665c;
        int[] f10 = options.f();
        g gVar3 = gVar2;
        int i16 = -1;
        int i17 = 0;
        loop0: while (true) {
            int i18 = i17 + 1;
            int i19 = f10[i17];
            int i20 = i18 + 1;
            int i21 = f10[i18];
            if (i21 != -1) {
                i16 = i21;
            }
            if (gVar3 == null) {
                break;
            }
            if (i19 < 0) {
                int i22 = i20 + (i19 * (-1));
                while (true) {
                    int i23 = i14 + 1;
                    int i24 = i20 + 1;
                    if ((bArr[i14] & 255) != f10[i20]) {
                        return i16;
                    }
                    boolean z11 = i24 == i22;
                    if (i23 == i15) {
                        i.d(gVar3);
                        g gVar4 = gVar3.f33668f;
                        i.d(gVar4);
                        i13 = gVar4.f33664b;
                        byte[] bArr2 = gVar4.f33663a;
                        i12 = gVar4.f33665c;
                        if (gVar4 != gVar2) {
                            gVar = gVar4;
                            bArr = bArr2;
                        } else if (!z11) {
                            break loop0;
                        } else {
                            bArr = bArr2;
                            gVar = null;
                        }
                    } else {
                        gVar = gVar3;
                        i12 = i15;
                        i13 = i23;
                    }
                    if (z11) {
                        i11 = f10[i24];
                        i10 = i13;
                        i15 = i12;
                        gVar3 = gVar;
                        break;
                    }
                    i14 = i13;
                    i15 = i12;
                    i20 = i24;
                    gVar3 = gVar;
                }
            } else {
                i10 = i14 + 1;
                int i25 = bArr[i14] & 255;
                int i26 = i20 + i19;
                while (i20 != i26) {
                    if (i25 == f10[i20]) {
                        i11 = f10[i20 + i19];
                        if (i10 == i15) {
                            gVar3 = gVar3.f33668f;
                            i.d(gVar3);
                            i10 = gVar3.f33664b;
                            bArr = gVar3.f33663a;
                            i15 = gVar3.f33665c;
                            if (gVar3 == gVar2) {
                                gVar3 = null;
                            }
                        }
                    } else {
                        i20++;
                    }
                }
                return i16;
            }
            if (i11 >= 0) {
                return i11;
            }
            i17 = -i11;
            i14 = i10;
        }
        if (z10) {
            return -2;
        }
        return i16;
    }

    public static /* synthetic */ int e(c cVar, d dVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d(cVar, dVar, z10);
    }
}
