package nl;
/* loaded from: classes2.dex */
public class c {
    public static int a(int i10, int i11, int i12) {
        if (i11 <= 0) {
            return i10;
        }
        if (i12 == 1) {
            return (i10 >> 24) & 255;
        }
        if (i12 == 515) {
            return (i10 & 255) | ((i10 >> 8) & 255);
        } else if (i12 == 2) {
            return i10 & 255;
        } else {
            if (i12 == 3) {
                return (i10 >> 27) & 31;
            }
            if (i12 == 5) {
                return (i10 >> 21) & 2047;
            }
            if (i12 == 4 || i12 == 7 || i12 != 514) {
                return i10;
            }
            return (i10 & 255) | ((i10 >> 8) & 255);
        }
    }
}
