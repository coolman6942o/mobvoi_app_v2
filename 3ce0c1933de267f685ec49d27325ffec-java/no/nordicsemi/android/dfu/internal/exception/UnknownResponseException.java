package no.nordicsemi.android.dfu.internal.exception;

import java.util.Locale;
/* loaded from: classes3.dex */
public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final int mExpectedReturnCode;
    private final byte[] mResponse;

    public UnknownResponseException(String str, byte[] bArr, int i10, int i11) {
        super(str);
        this.mResponse = bArr == null ? new byte[0] : bArr;
        this.mExpectedReturnCode = i10;
        this.mExpectedOpCode = i11;
    }

    public static String bytesToHex(byte[] bArr, int i10, int i11) {
        if (bArr == null || bArr.length <= i10 || i11 <= 0) {
            return "";
        }
        int min = Math.min(i11, bArr.length - i10);
        char[] cArr = new char[min * 2];
        for (int i12 = 0; i12 < min; i12++) {
            int i13 = bArr[i10 + i12] & 255;
            int i14 = i12 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i14] = cArr2[i13 >>> 4];
            cArr[i14 + 1] = cArr2[i13 & 15];
        }
        return "0x" + new String(cArr);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Locale locale = Locale.US;
        byte[] bArr = this.mResponse;
        return String.format(locale, "%s (response: %s, expected: 0x%02X%02X..)", super.getMessage(), bytesToHex(bArr, 0, bArr.length), Integer.valueOf(this.mExpectedReturnCode), Integer.valueOf(this.mExpectedOpCode));
    }
}
