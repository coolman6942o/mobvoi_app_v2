package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* compiled from: HighLevelEncoder.java */
/* loaded from: classes2.dex */
public final class Eb {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f14508a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: b  reason: collision with root package name */
    static final int[][] f14509b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f14510c;

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f14511d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f14512e;

    /* compiled from: HighLevelEncoder.java */
    /* loaded from: classes2.dex */
    static class a<State> implements Comparator<Gb> {
        a() {
        }

        /* renamed from: a */
        public int compare(Gb gb2, Gb gb3) {
            return gb2.b() - gb3.b();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, 5, 256);
        f14510c = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f14510c[0][i10] = (i10 - 65) + 2;
        }
        f14510c[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f14510c[1][i11] = (i11 - 97) + 2;
        }
        f14510c[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f14510c[2][i12] = (i12 - 48) + 2;
        }
        int[][] iArr2 = f14510c;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i13 = 0; i13 < 28; i13++) {
            f14510c[3][iArr3[i13]] = i13;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i14 = 0; i14 < 31; i14++) {
            if (iArr4[i14] > 0) {
                f14510c[4][iArr4[i14]] = i14;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(int.class, 6, 6);
        f14511d = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        try {
            int[][] iArr7 = f14511d;
            if (b.a(iArr7, 0) && b.a(iArr7[0], 4)) {
                iArr7[0][4] = 0;
            }
            if (b.a(iArr7, 1) && b.a(iArr7[1], 4)) {
                iArr7[1][4] = 0;
            }
            if (b.a(iArr7, 1) && b.a(iArr7[1], 0)) {
                iArr7[1][0] = 28;
            }
            if (b.a(iArr7, 3) && b.a(iArr7[3], 4)) {
                iArr7[3][4] = 0;
            }
            if (b.a(iArr7, 2) && b.a(iArr7[2], 4)) {
                iArr7[2][4] = 0;
            }
            if (b.a(iArr7, 2) && b.a(iArr7[2], 0)) {
                iArr7[2][0] = 15;
            }
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    public Eb(byte[] bArr) {
        this.f14512e = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0591h a() {
        int i10;
        Collection<Gb> singletonList = Collections.singletonList(Gb.f14533a);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f14512e;
            if (i11 >= bArr.length) {
                return ((Gb) Collections.min(singletonList, new a())).a(this.f14512e);
            }
            int i12 = i11 + 1;
            byte b10 = i12 < bArr.length ? bArr[i12] : (byte) 0;
            byte b11 = bArr[i11];
            if (b11 == 13) {
                if (b10 == 10) {
                    i10 = 2;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else if (b11 == 44) {
                if (b10 == 32) {
                    i10 = 4;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else if (b11 != 46) {
                if (b11 == 58 && b10 == 32) {
                    i10 = 5;
                    if (i10 <= 0) {
                        singletonList = a(singletonList, i11, i10);
                        i11 = i12;
                    } else {
                        singletonList = a(singletonList, i11);
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else {
                if (b10 == 32) {
                    i10 = 3;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            }
        }
    }

    private Collection<Gb> a(Iterable<Gb> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        for (Gb gb2 : iterable) {
            a(gb2, i10, linkedList);
        }
        return a(linkedList);
    }

    private void a(Gb gb2, int i10, Collection<Gb> collection) {
        if (b.a(this.f14512e, i10)) {
            char c10 = (char) (this.f14512e[i10] & 255);
            int[][] iArr = f14510c;
            boolean z10 = b.a(iArr, gb2.c()) && b.a(iArr[gb2.c()], (int) c10) && iArr[gb2.c()][c10] > 0;
            Gb gb3 = null;
            for (int i11 = 0; i11 <= 4; i11++) {
                int[][] iArr2 = f14510c;
                int i12 = (!b.a(iArr2, i11) || !b.a(iArr2[i11], (int) c10)) ? 0 : iArr2[i11][c10];
                if (i12 > 0) {
                    if (gb3 == null) {
                        gb3 = gb2.b(i10);
                    }
                    if (!z10 || i11 == gb2.c() || i11 == 2) {
                        collection.add(gb3.a(i11, i12));
                    }
                    if (!z10 && f14511d[gb2.c()][i11] >= 0) {
                        collection.add(gb3.b(i11, i12));
                    }
                }
            }
            int[][] iArr3 = f14510c;
            if (b.a(iArr3, gb2.c()) && b.a(iArr3[gb2.c()], (int) c10)) {
                if (gb2.a() > 0 || iArr3[gb2.c()][c10] == 0) {
                    collection.add(gb2.a(i10));
                }
            }
        }
    }

    private static Collection<Gb> a(Iterable<Gb> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        for (Gb gb2 : iterable) {
            a(gb2, i10, i11, linkedList);
        }
        return a(linkedList);
    }

    private static void a(Gb gb2, int i10, int i11, Collection<Gb> collection) {
        Gb b10 = gb2.b(i10);
        collection.add(b10.a(4, i11));
        if (gb2.c() != 4) {
            collection.add(b10.b(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(b10.a(2, 16 - i11).a(2, 1));
        }
        if (gb2.a() > 0) {
            collection.add(gb2.a(i10).a(i10 + 1));
        }
    }

    private static Collection<Gb> a(Iterable<Gb> iterable) {
        LinkedList linkedList = new LinkedList();
        for (Gb gb2 : iterable) {
            boolean z10 = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Gb gb3 = (Gb) it.next();
                if (gb3.a(gb2)) {
                    z10 = false;
                    break;
                } else if (gb2.a(gb3)) {
                    it.remove();
                }
            }
            if (z10) {
                linkedList.add(gb2);
            }
        }
        return linkedList;
    }
}
