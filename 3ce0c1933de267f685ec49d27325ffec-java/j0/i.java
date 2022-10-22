package j0;

import java.io.PrintWriter;
/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f29369a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f29370b = new char[24];

    private static int a(int i10, int i11, boolean z10, int i12) {
        if (i10 > 99 || (z10 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z10 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z10 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    public static void b(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            d(j10 - j11, printWriter, 0);
        }
    }

    public static void c(long j10, PrintWriter printWriter) {
        d(j10, printWriter, 0);
    }

    public static void d(long j10, PrintWriter printWriter, int i10) {
        synchronized (f29369a) {
            printWriter.print(new String(f29370b, 0, e(j10, i10)));
        }
    }

    private static int e(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11 = j10;
        if (f29370b.length < i10) {
            f29370b = new char[i10];
        }
        char[] cArr = f29370b;
        int i16 = (j11 > 0L ? 1 : (j11 == 0L ? 0 : -1));
        if (i16 == 0) {
            int i17 = i10 - 1;
            while (i17 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i16 > 0) {
            c10 = '+';
        } else {
            c10 = '-';
            j11 = -j11;
        }
        int i18 = (int) (j11 % 1000);
        int floor = (int) Math.floor(j11 / 1000);
        if (floor > 86400) {
            i11 = floor / 86400;
            floor -= 86400 * i11;
        } else {
            i11 = 0;
        }
        if (floor > 3600) {
            i12 = floor / 3600;
            floor -= i12 * 3600;
        } else {
            i12 = 0;
        }
        if (floor > 60) {
            int i19 = floor / 60;
            i13 = floor - (i19 * 60);
            i14 = i19;
        } else {
            i13 = floor;
            i14 = 0;
        }
        if (i10 != 0) {
            int a10 = a(i11, 1, false, 0);
            int a11 = a10 + a(i12, 1, a10 > 0, 2);
            int a12 = a11 + a(i14, 1, a11 > 0, 2);
            int a13 = a12 + a(i13, 1, a12 > 0, 2);
            i15 = 0;
            for (int a14 = a13 + a(i18, 2, true, a13 > 0 ? 3 : 0) + 1; a14 < i10; a14++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i20 = i15 + 1;
        boolean z10 = i10 != 0;
        int f10 = f(cArr, i11, 'd', i20, false, 0);
        int f11 = f(cArr, i12, 'h', f10, f10 != i20, z10 ? 2 : 0);
        int f12 = f(cArr, i14, 'm', f11, f11 != i20, z10 ? 2 : 0);
        int f13 = f(cArr, i13, 's', f12, f12 != i20, z10 ? 2 : 0);
        int f14 = f(cArr, i18, 'm', f13, true, (!z10 || f13 == i20) ? 0 : 3);
        cArr[f14] = 's';
        return f14 + 1;
    }

    private static int f(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (!z10 && i10 <= 0) {
            return i11;
        }
        if ((!z10 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        int i16 = i13 + 1;
        cArr[i16] = c10;
        return i16 + 1;
    }
}
