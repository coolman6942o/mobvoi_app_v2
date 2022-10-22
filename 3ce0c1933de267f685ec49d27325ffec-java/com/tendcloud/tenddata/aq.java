package com.tendcloud.tenddata;

import android.text.TextUtils;
import com.tendcloud.tenddata.l;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22635a = "Archimedes_p";

    /* renamed from: b  reason: collision with root package name */
    private static final int f22636b = 1000000000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        try {
            l.b bVar = l.b.AES_DATA_LOCK;
            l.getFileLock(bVar.toString());
            int a10 = am.a(b());
            if (a10 == 0) {
                a10 = u.b().nextInt(f22636b);
                a(a10);
            }
            l.releaseFileLock(bVar.toString());
            return a10;
        } catch (Throwable unused) {
            l.releaseFileLock(l.b.AES_DATA_LOCK.toString());
            return 0;
        }
    }

    private static int[][] b() {
        int i10;
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            for (int i12 = 1; i12 < 4; i12++) {
                String a10 = ap.a(f22635a + i12);
                if (!TextUtils.isEmpty(a10)) {
                    arrayList.add(a10);
                    i11++;
                }
            }
            int i13 = 4;
            while (true) {
                if (i13 >= 6) {
                    break;
                }
                String b10 = ap.b(f22635a + i13);
                if (!TextUtils.isEmpty(b10)) {
                    arrayList.add(b10);
                    i11++;
                }
                i13++;
            }
            if (i11 < 4) {
                for (i10 = 6; i10 < 8; i10++) {
                    String c10 = ap.c(ab.f22568h.getPackageName() + i10);
                    if (!TextUtils.isEmpty(c10)) {
                        arrayList.add(c10);
                    }
                }
            }
            if (arrayList.size() < 4) {
                return null;
            }
            for (int i14 = 0; i14 < 4; i14++) {
                sb2.append((String) arrayList.get(i14));
            }
            return a(sb2.toString(), 4, 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(int i10) {
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList(16);
        int i14 = 0;
        do {
            int[] iArr = new int[3];
            int[] iArr2 = new int[7];
            int[] iArr3 = new int[7];
            SecureRandom b10 = u.b();
            for (int i15 = 0; i15 < 3; i15++) {
                iArr[i15] = b10.nextInt(1000);
            }
            for (int i16 = 0; i16 < 7; i16++) {
                iArr2[i16] = b10.nextInt(100);
            }
            int i17 = 0;
            while (true) {
                i11 = 1;
                if (i17 >= 7) {
                    break;
                }
                iArr3[i17] = (iArr[0] * iArr2[i17] * iArr2[i17] * iArr2[i17]) + (iArr[1] * iArr2[i17] * iArr2[i17]) + (iArr[2] * iArr2[i17]) + i10;
                arrayList.add(iArr2[i17] + "," + iArr3[i17] + ",");
                i17++;
            }
            if (a(arrayList, i10)) {
                break;
            }
            arrayList.clear();
            i14++;
        } while (i14 < 7);
        while (true) {
            i12 = 4;
            if (i11 < 4) {
                ap.a(f22635a + i11, (String) arrayList.get(i11 - 1));
                i11++;
            }
        }
        while (true) {
            if (i12 < 6) {
                ap.b(f22635a + i12, (String) arrayList.get(i12 - 1));
                i12++;
            }
        }
        for (i13 = 6; i13 < 8; i13++) {
            ap.c(ab.f22568h.getPackageName() + i13, (String) arrayList.get(i13 - 1));
        }
    }

    private static boolean a(ArrayList<String> arrayList, int i10) {
        String str = "";
        for (int i11 = 0; i11 < 4; i11++) {
            try {
                str = str.concat(arrayList.get(i11));
            } catch (Throwable unused) {
                return false;
            }
        }
        return i10 == am.a(a(str, 4, 2));
    }

    private static int[][] a(String str, int i10, int i11) {
        int[][] iArr = (int[][]) Array.newInstance(int.class, i10, i11);
        String[] split = str.split(",");
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            for (int i14 = 0; i14 < i11; i14++) {
                iArr[i13][i14] = Integer.parseInt(split[i12]);
                i12++;
            }
        }
        return iArr;
    }
}
