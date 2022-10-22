package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
import com.google.zxing.h;
import com.google.zxing.i;
import com.huawei.agconnect.exception.AGCServerException;
import com.realsil.sdk.dfu.DfuException;
import java.util.Arrays;
import java.util.Map;
/* compiled from: Code39Reader.java */
/* loaded from: classes.dex */
public final class c extends k {

    /* renamed from: e  reason: collision with root package name */
    static final int[] f35639e;

    /* renamed from: f  reason: collision with root package name */
    static final int f35640f;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f35641a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f35642b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f35643c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f35644d;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, DfuException.ERROR_CANNOT_FIND_DEVICE, 73, 328, 25, DfuException.ERROR_ENTER_OTA_MODE_FAILED, 88, 13, DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES, 76, 28, DfuException.ERROR_LOCK_WAIT_INTERRUPTED, 67, 322, 19, DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, 82, 7, DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 70, 22, 385, 193, 448, 145, AGCServerException.AUTHENTICATION_INVALID, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f35639e = iArr;
        f35640f = iArr[39];
    }

    public c() {
        this(false);
    }

    private static String g(CharSequence charSequence) throws FormatException {
        char c10;
        int i10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i11++;
                char charAt2 = charSequence.charAt(i11);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt != '/') {
                                c10 = 0;
                            } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i10 = charAt2 - ' ';
                            } else if (charAt2 == 'Z') {
                                c10 = ':';
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            sb2.append(c10);
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i10 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i10 = charAt2 - '&';
                    } else if (charAt2 < 'F' || charAt2 > 'W') {
                        throw FormatException.getFormatInstance();
                    } else {
                        i10 = charAt2 - 11;
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    i10 = charAt2 - '@';
                }
                c10 = (char) i10;
                sb2.append(c10);
            } else {
                sb2.append(charAt);
            }
            i11++;
        }
        return sb2.toString();
    }

    private static int[] h(a aVar, int[] iArr) throws NotFoundException {
        int g10 = aVar.g();
        int e10 = aVar.e(0);
        int length = iArr.length;
        boolean z10 = false;
        int i10 = 0;
        int i11 = e10;
        while (e10 < g10) {
            if (aVar.c(e10) ^ z10) {
                iArr[i10] = iArr[i10] + 1;
            } else {
                int i12 = length - 1;
                if (i10 != i12) {
                    i10++;
                } else if (j(iArr) == f35640f && aVar.i(Math.max(0, i11 - ((e10 - i11) / 2)), i11, false)) {
                    return new int[]{i11, e10};
                } else {
                    i11 += iArr[0] + iArr[1];
                    int i13 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i12] = 0;
                    i10--;
                }
                iArr[i10] = 1;
                z10 = !z10;
            }
            e10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char i(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f35639e;
            if (i11 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            } else if (iArr[i11] == i10) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".charAt(i11);
            } else {
                i11++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r1 >= r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r4 <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        r2 = r10[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r2 <= r3) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        r4 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        if ((r2 << 1) < r6) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int j(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = Integer.MAX_VALUE;
            for (int i13 : iArr) {
                if (i13 < i12 && i13 > i11) {
                    i12 = i13;
                }
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                int i18 = iArr[i17];
                if (i18 > i12) {
                    i15 |= 1 << ((length - 1) - i17);
                    i14++;
                    i16 += i18;
                }
            }
            if (i14 == 3) {
                break;
            } else if (i14 <= 3) {
                return -1;
            } else {
                i11 = i12;
            }
        }
    }

    @Override // v8.k
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] h10;
        String str;
        int[] iArr = this.f35644d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f35643c;
        sb2.setLength(0);
        int e10 = aVar.e(h(aVar, iArr)[1]);
        int g10 = aVar.g();
        while (true) {
            k.e(aVar, e10, iArr);
            int j10 = j(iArr);
            if (j10 >= 0) {
                char i11 = i(j10);
                sb2.append(i11);
                int i12 = e10;
                for (int i13 : iArr) {
                    i12 += i13;
                }
                int e11 = aVar.e(i12);
                if (i11 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i14 = 0;
                    for (int i15 : iArr) {
                        i14 += i15;
                    }
                    int i16 = (e11 - e10) - i14;
                    if (e11 == g10 || (i16 << 1) >= i14) {
                        if (this.f35641a) {
                            int length = sb2.length() - 1;
                            int i17 = 0;
                            for (int i18 = 0; i18 < length; i18++) {
                                i17 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f35643c.charAt(i18));
                            }
                            if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i17 % 43)) {
                                sb2.setLength(length);
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        }
                        if (sb2.length() != 0) {
                            if (this.f35642b) {
                                str = g(sb2);
                            } else {
                                str = sb2.toString();
                            }
                            float f10 = i10;
                            return new h(str, null, new i[]{new i((h10[1] + h10[0]) / 2.0f, f10), new i(e10 + (i14 / 2.0f), f10)}, BarcodeFormat.CODE_39);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                e10 = e11;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public c(boolean z10) {
        this(z10, false);
    }

    public c(boolean z10, boolean z11) {
        this.f35641a = z10;
        this.f35642b = z11;
        this.f35643c = new StringBuilder(20);
        this.f35644d = new int[9];
    }
}
