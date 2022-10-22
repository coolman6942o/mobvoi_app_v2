package d4;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f25132a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        if (r2 == (-1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
        r0.append((char) (r2 | ((r6 & 3) << 6)));
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        int i12;
        byte b12;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i13 = 0;
        loop0: while (i13 < length) {
            while (true) {
                i10 = i13 + 1;
                b10 = f25132a[bytes[i13]];
                if (i10 >= length || b10 != -1) {
                    break;
                }
                i13 = i10;
            }
            if (b10 == -1) {
                break;
            }
            while (true) {
                i11 = i10 + 1;
                b11 = f25132a[bytes[i10]];
                if (i11 >= length || b11 != -1) {
                    break;
                }
                i10 = i11;
            }
            if (b11 == -1) {
                break;
            }
            stringBuffer.append((char) ((b10 << 2) | ((b11 & 48) >>> 4)));
            while (true) {
                i12 = i11 + 1;
                byte b13 = bytes[i11];
                if (b13 == 61) {
                    break loop0;
                }
                b12 = f25132a[b13];
                if (i12 >= length || b12 != -1) {
                    break;
                }
                i11 = i12;
            }
            if (b12 == -1) {
                break;
            }
            stringBuffer.append((char) (((b11 & 15) << 4) | ((b12 & 60) >>> 2)));
            while (true) {
                int i14 = i12 + 1;
                byte b14 = bytes[i12];
                if (b14 == 61) {
                    break loop0;
                }
                byte b15 = f25132a[b14];
                if (i14 >= length || b15 != -1) {
                    break;
                }
                i12 = i14;
            }
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
