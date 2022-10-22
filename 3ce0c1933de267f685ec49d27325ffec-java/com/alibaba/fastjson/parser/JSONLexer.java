package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.mobvoi.wear.lpa.LpaConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;

    /* renamed from: bp  reason: collision with root package name */
    protected int f6709bp;
    public Calendar calendar;

    /* renamed from: ch  reason: collision with root package name */
    protected char f6710ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;

    /* renamed from: np  reason: collision with root package name */
    protected int f6711np;
    protected int pos;
    protected char[] sbuf;

    /* renamed from: sp  reason: collision with root package name */
    protected int f6712sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int i10;
        try {
            i10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i10 = -1;
        }
        char c10 = 0;
        V6 = i10 >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i11 = 48; i11 <= 57; i11++) {
            digits[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            digits[i12] = (i12 - 97) + 10;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            digits[i13] = (i13 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            IA[CA[i14]] = i14;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c11 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c10 < zArr2.length) {
                if (c10 >= 'A' && c10 <= 'Z') {
                    zArr2[c10] = true;
                } else if (c10 >= 'a' && c10 <= 'z') {
                    zArr2[c10] = true;
                } else if (c10 == '_') {
                    zArr2[c10] = true;
                } else if (c10 >= '0' && c10 <= '9') {
                    zArr2[c10] = true;
                }
                c10 = (char) (c10 + 1);
            } else {
                return;
            }
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean checkDate(char c10, char c11, char c12, char c13, char c14, char c15, int i10, int i11) {
        if ((c10 == '1' || c10 == '2') && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9') {
            if (c14 == '0') {
                if (c15 < '1' || c15 > '9') {
                    return false;
                }
            } else if (!(c14 == '1' && (c15 == '0' || c15 == '1' || c15 == '2'))) {
                return false;
            }
            if (i10 == 48) {
                return i11 >= 49 && i11 <= 57;
            }
            if (i10 != 49 && i10 != 50) {
                return i10 == 51 && (i11 == 48 || i11 == 49);
            }
            if (i11 >= 48 && i11 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
        if (r5 <= '4') goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean checkTime(char c10, char c11, char c12, char c13, char c14, char c15) {
        if (c10 == '0') {
            if (c11 < '0' || c11 > '9') {
                return false;
            }
        } else if (c10 != '1') {
            if (c10 == '2') {
                if (c11 >= '0') {
                }
            }
            return false;
        } else if (c11 < '0' || c11 > '9') {
            return false;
        }
        if (c12 < '0' || c12 > '5') {
            if (!(c12 == '6' && c13 == '0')) {
                return false;
            }
        } else if (c13 < '0' || c13 > '9') {
            return false;
        }
        return (c14 < '0' || c14 > '5') ? c14 == '6' && c15 == '0' : c15 >= '0' && c15 <= '9';
    }

    public static final byte[] decodeFast(String str, int i10, int i11) {
        int i12;
        int i13;
        int i14 = 0;
        if (i11 == 0) {
            return new byte[0];
        }
        int i15 = (i10 + i11) - 1;
        while (i10 < i15 && IA[str.charAt(i10)] < 0) {
            i10++;
        }
        while (i15 > 0 && IA[str.charAt(i15)] < 0) {
            i15--;
        }
        if (str.charAt(i15) == '=') {
            i12 = str.charAt(i15 + (-1)) == '=' ? 2 : 1;
        } else {
            i12 = 0;
        }
        int i16 = (i15 - i10) + 1;
        if (i11 > 76) {
            i13 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i13 = 0;
        }
        int i17 = (((i16 - i13) * 6) >> 3) - i12;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i10 + 1;
            int i22 = i21 + 1;
            int i23 = (iArr[str.charAt(i10)] << 18) | (iArr[str.charAt(i21)] << 12);
            int i24 = i22 + 1;
            int i25 = i23 | (iArr[str.charAt(i22)] << 6);
            int i26 = i24 + 1;
            int i27 = i25 | iArr[str.charAt(i24)];
            int i28 = i19 + 1;
            bArr[i19] = (byte) (i27 >> 16);
            int i29 = i28 + 1;
            bArr[i28] = (byte) (i27 >> 8);
            i19 = i29 + 1;
            bArr[i29] = (byte) i27;
            if (i13 > 0 && (i20 = i20 + 1) == 19) {
                i26 += 2;
                i20 = 0;
            }
            i10 = i26;
        }
        if (i19 < i17) {
            int i30 = 0;
            while (i10 <= i15 - i12) {
                i10++;
                i14 |= IA[str.charAt(i10)] << (18 - (i30 * 6));
                i30++;
            }
            int i31 = 16;
            while (i19 < i17) {
                i19++;
                bArr[i19] = (byte) (i14 >> i31);
                i31 -= 8;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j10) {
        char c10 = this.f6710ch;
        int i10 = this.f6709bp + 1;
        int i11 = 1;
        while (c10 != '\"' && c10 != '\'') {
            if (c10 > ' ' || !(c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b')) {
                this.matchStat = -2;
                return 0;
            }
            i11++;
            int i12 = this.f6709bp + i11;
            c10 = i12 >= this.len ? EOI : this.text.charAt(i12);
        }
        long j11 = -2128831035;
        int i13 = i10;
        while (true) {
            if (i13 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i13);
            if (charAt == c10) {
                i11 += i13 - i10;
                break;
            }
            j11 = 16777619 * (charAt ^ j11);
            i13++;
        }
        if (j11 != j10) {
            this.matchStat = -2;
            return 0;
        }
        int i14 = i11 + 1;
        int i15 = this.f6709bp + i14;
        char charAt2 = i15 >= this.len ? EOI : this.text.charAt(i15);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            i14++;
            int i16 = this.f6709bp + i14;
            charAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
        }
        return i14 + 1;
    }

    private static String readString(char[] cArr, int i10) {
        int i11;
        char[] cArr2 = new char[i10];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            char c10 = cArr[i12];
            if (c10 != '\\') {
                i13++;
                cArr2[i13] = c10;
            } else {
                i12++;
                char c11 = cArr[i12];
                if (c11 == '\"') {
                    i11 = i13 + 1;
                    cArr2[i13] = '\"';
                } else if (c11 != '\'') {
                    if (c11 != 'F') {
                        if (c11 == '\\') {
                            i11 = i13 + 1;
                            cArr2[i13] = '\\';
                        } else if (c11 == 'b') {
                            i11 = i13 + 1;
                            cArr2[i13] = '\b';
                        } else if (c11 != 'f') {
                            if (c11 == 'n') {
                                i11 = i13 + 1;
                                cArr2[i13] = '\n';
                            } else if (c11 == 'r') {
                                i11 = i13 + 1;
                                cArr2[i13] = '\r';
                            } else if (c11 != 'x') {
                                switch (c11) {
                                    case '/':
                                        i11 = i13 + 1;
                                        cArr2[i13] = '/';
                                        break;
                                    case '0':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 0;
                                        break;
                                    case '1':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 1;
                                        break;
                                    case '2':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 2;
                                        break;
                                    case '3':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 3;
                                        break;
                                    case '4':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 4;
                                        break;
                                    case '5':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 5;
                                        break;
                                    case '6':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 6;
                                        break;
                                    case '7':
                                        i11 = i13 + 1;
                                        cArr2[i13] = 7;
                                        break;
                                    default:
                                        switch (c11) {
                                            case 't':
                                                i11 = i13 + 1;
                                                cArr2[i13] = '\t';
                                                break;
                                            case 'u':
                                                i11 = i13 + 1;
                                                int i14 = i12 + 1;
                                                int i15 = i14 + 1;
                                                int i16 = i15 + 1;
                                                i12 = i16 + 1;
                                                cArr2[i13] = (char) Integer.parseInt(new String(new char[]{cArr[i14], cArr[i15], cArr[i16], cArr[i12]}), 16);
                                                break;
                                            case 'v':
                                                i11 = i13 + 1;
                                                cArr2[i13] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i11 = i13 + 1;
                                int[] iArr = digits;
                                int i17 = i12 + 1;
                                i12 = i17 + 1;
                                cArr2[i13] = (char) ((iArr[cArr[i17]] * 16) + iArr[cArr[i12]]);
                            }
                        }
                    }
                    i11 = i13 + 1;
                    cArr2[i13] = '\f';
                } else {
                    i11 = i13 + 1;
                    cArr2[i13] = '\'';
                }
                i13 = i11;
            }
            i12++;
        }
        return new String(cArr2, 0, i13);
    }

    private void scanIdent() {
        this.f6711np = this.f6709bp - 1;
        this.hasSpecial = false;
        do {
            this.f6712sp++;
            next();
        } while (Character.isLetterOrDigit(this.f6710ch));
        String stringVal = stringVal();
        if (stringVal.equals(LpaConstants.VALUE_NULL)) {
            this.token = 8;
        } else if (stringVal.equals("true")) {
            this.token = 6;
        } else if (stringVal.equals("false")) {
            this.token = 7;
        } else if (stringVal.equals("new")) {
            this.token = 9;
        } else if (stringVal.equals("undefined")) {
            this.token = 23;
        } else if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0'));
        this.calendar.set(2, (((c14 - '0') * 10) + (c15 - '0')) - 1);
        this.calendar.set(5, ((c16 - '0') * 10) + (c17 - '0'));
    }

    private final String subString(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.sbuf, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.f6711np + 1, this.f6712sp);
    }

    protected char charAt(int i10) {
        return i10 >= this.len ? EOI : this.text.charAt(i10);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z10) {
        if (z10) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z10 ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z10) {
        char[] cArr;
        boolean z11;
        int i10 = (this.f6711np + this.f6712sp) - 1;
        char charAt = i10 >= this.len ? EOI : this.text.charAt(i10);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z10) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.f6711np + this.f6712sp) - 1);
            int i11 = this.f6712sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i11--;
            }
            int i12 = this.f6711np;
            char[] cArr2 = this.sbuf;
            int i13 = 0;
            if (i11 < cArr2.length) {
                this.text.getChars(i12, i12 + i11, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i11];
                this.text.getChars(i12, i12 + i11, cArr3, 0);
                cArr = cArr3;
            }
            if (i11 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i11)));
            }
            char c10 = cArr[0];
            int i14 = 2;
            if (c10 == '-') {
                c10 = cArr[1];
                z11 = true;
            } else {
                if (c10 == '+') {
                    c10 = cArr[1];
                } else {
                    i14 = 1;
                }
                z11 = false;
            }
            int i15 = c10 - '0';
            while (i14 < i11) {
                char c11 = cArr[i14];
                if (c11 == '.') {
                    i13 = 1;
                } else {
                    i15 = (i15 * 10) + (c11 - '0');
                    if (i13 != 0) {
                        i13 *= 10;
                    }
                }
                i14++;
            }
            double d10 = i15 / i13;
            if (z11) {
                d10 = -d10;
            }
            return Double.valueOf(d10);
        } catch (NumberFormatException e10) {
            throw new JSONException(e10.getMessage() + ", " + info());
        }
    }

    public String info() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.f6709bp);
        sb2.append(", json : ");
        sb2.append(this.len < 65536 ? this.text : this.text.substring(0, WXMediaMessage.THUMB_LENGTH_LIMIT));
        return sb2.toString();
    }

    public final int intValue() {
        boolean z10;
        int i10;
        int i11 = this.f6711np;
        int i12 = this.f6712sp + i11;
        int i13 = 0;
        if ((i11 >= this.len ? (char) 26 : this.text.charAt(i11)) == '-') {
            i10 = Integer.MIN_VALUE;
            i11++;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i11 < i12) {
            i11++;
            i13 = -((i11 >= this.len ? (char) 26 : this.text.charAt(i11)) - '0');
        }
        while (i11 < i12) {
            int i14 = i11 + 1;
            char charAt = i11 >= this.len ? (char) 26 : this.text.charAt(i11);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i11 = i14;
                break;
            }
            int i15 = charAt - '0';
            if (i13 >= -214748364) {
                int i16 = i13 * 10;
                if (i16 >= i10 + i15) {
                    i13 = i16 - i15;
                    i11 = i14;
                } else {
                    throw new NumberFormatException(numberString());
                }
            } else {
                throw new NumberFormatException(numberString());
            }
        }
        if (!z10) {
            return -i13;
        }
        if (i11 > this.f6711np + 1) {
            return i13;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c10;
        boolean z10;
        long j10;
        long j11;
        int i10 = this.f6711np;
        int i11 = this.f6712sp + i10;
        int i12 = i11 - 1;
        char charAt = i12 >= this.len ? EOI : this.text.charAt(i12);
        if (charAt == 'B') {
            i11--;
            c10 = 'B';
        } else if (charAt == 'L') {
            i11--;
            c10 = 'L';
        } else if (charAt != 'S') {
            c10 = ' ';
        } else {
            i11--;
            c10 = 'S';
        }
        int i13 = this.f6711np;
        if ((i13 >= this.len ? EOI : this.text.charAt(i13)) == '-') {
            j10 = Long.MIN_VALUE;
            i10++;
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
            z10 = false;
        }
        if (i10 < i11) {
            i10++;
            j11 = -((i10 >= this.len ? EOI : this.text.charAt(i10)) - '0');
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            i10++;
            int charAt2 = (i10 >= this.len ? EOI : this.text.charAt(i10)) - '0';
            if (j11 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j12 = j11 * 10;
            long j13 = charAt2;
            if (j12 < j10 + j13) {
                return new BigInteger(numberString());
            }
            j11 = j12 - j13;
        }
        if (!z10) {
            long j14 = -j11;
            if (j14 > 2147483647L || c10 == 'L') {
                return Long.valueOf(j14);
            }
            if (c10 == 'S') {
                return Short.valueOf((short) j14);
            }
            if (c10 == 'B') {
                return Byte.valueOf((byte) j14);
            }
            return Integer.valueOf((int) j14);
        } else if (i10 <= this.f6711np + 1) {
            throw new NumberFormatException(numberString());
        } else if (j11 < -2147483648L || c10 == 'L') {
            return Long.valueOf(j11);
        } else {
            if (c10 == 'S') {
                return Short.valueOf((short) j11);
            }
            if (c10 == 'B') {
                return Byte.valueOf((byte) j11);
            }
            return Integer.valueOf((int) j11);
        }
    }

    public final boolean isBlankInput() {
        int i10 = 0;
        while (true) {
            char charAt = charAt(i10);
            boolean z10 = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || !(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
            i10++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:8:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long longValue() throws NumberFormatException {
        long j10;
        boolean z10;
        long j11;
        int i10 = this.f6711np;
        int i11 = this.f6712sp + i10;
        if (charAt(i10) == '-') {
            j10 = Long.MIN_VALUE;
            i10++;
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
            z10 = false;
        }
        if (i10 < i11) {
            int i12 = i10 + 1;
            j11 = -(charAt(i10) - '0');
            i10 = i12;
            if (i10 < i11) {
                i12 = i10 + 1;
                char charAt = i10 >= this.len ? EOI : this.text.charAt(i10);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i10 = i12;
                } else {
                    int i13 = charAt - '0';
                    if (j11 >= -922337203685477580L) {
                        long j12 = j11 * 10;
                        long j13 = i13;
                        if (j12 >= j10 + j13) {
                            j11 = j12 - j13;
                            i10 = i12;
                            if (i10 < i11) {
                            }
                        } else {
                            throw new NumberFormatException(numberString());
                        }
                    } else {
                        throw new NumberFormatException(numberString());
                    }
                }
            }
            if (z10) {
                return -j11;
            }
            if (i10 > this.f6711np + 1) {
                return j11;
            }
            throw new NumberFormatException(numberString());
        }
        j11 = 0;
        if (i10 < i11) {
        }
        if (z10) {
        }
    }

    public boolean matchField(long j10) {
        char c10 = this.f6710ch;
        int i10 = this.f6709bp + 1;
        int i11 = 1;
        while (c10 != '\"' && c10 != '\'') {
            if (c10 > ' ' || !(c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b')) {
                this.matchStat = -2;
                return false;
            }
            i11++;
            int i12 = this.f6709bp + i11;
            c10 = i12 >= this.len ? EOI : this.text.charAt(i12);
        }
        long j11 = -2128831035;
        int i13 = i10;
        while (true) {
            if (i13 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i13);
            if (charAt == c10) {
                i11 += (i13 - i10) + 1;
                break;
            }
            j11 = (charAt ^ j11) * 16777619;
            i13++;
        }
        if (j11 != j10) {
            this.matchStat = -2;
            return false;
        }
        int i14 = i11 + 1;
        int i15 = this.f6709bp + i11;
        char charAt2 = i15 >= this.len ? EOI : this.text.charAt(i15);
        while (charAt2 != ':') {
            if (charAt2 > ' ' || !(charAt2 == ' ' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == '\f' || charAt2 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            i14++;
            int i16 = this.f6709bp + i14;
            charAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
        }
        int i17 = this.f6709bp + i14;
        char charAt3 = i17 >= this.len ? EOI : this.text.charAt(i17);
        if (charAt3 == '{') {
            int i18 = i17 + 1;
            this.f6709bp = i18;
            this.f6710ch = i18 >= this.len ? EOI : this.text.charAt(i18);
            this.token = 12;
        } else if (charAt3 == '[') {
            int i19 = i17 + 1;
            this.f6709bp = i19;
            this.f6710ch = i19 >= this.len ? EOI : this.text.charAt(i19);
            this.token = 14;
        } else {
            this.f6709bp = i17;
            this.f6710ch = i17 >= this.len ? EOI : this.text.charAt(i17);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i10 = this.f6709bp + 1;
        this.f6709bp = i10;
        char charAt = i10 >= this.len ? EOI : this.text.charAt(i10);
        this.f6710ch = charAt;
        return charAt;
    }

    public final void nextIdent() {
        char c10;
        while (true) {
            c10 = this.f6710ch;
            if (!(c10 <= ' ' && (c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b'))) {
                break;
            }
            next();
        }
        if (c10 == '_' || Character.isLetter(c10)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0103, code lost:
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0106, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void nextToken() {
        int i10;
        this.f6712sp = 0;
        while (true) {
            int i11 = this.f6709bp;
            this.pos = i11;
            char c10 = this.f6710ch;
            if (c10 == '/') {
                skipComment();
            } else if (c10 == '\"') {
                scanString();
                return;
            } else if ((c10 < '0' || c10 > '9') && c10 != '-') {
                if (c10 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (!(c10 == '\f' || c10 == '\r' || c10 == ' ')) {
                    if (c10 != ':') {
                        char c11 = EOI;
                        if (c10 == '[') {
                            int i12 = i11 + 1;
                            this.f6709bp = i12;
                            if (i12 < this.len) {
                                c11 = this.text.charAt(i12);
                            }
                            this.f6710ch = c11;
                            this.token = 14;
                            return;
                        } else if (c10 == ']') {
                            next();
                            this.token = 15;
                            return;
                        } else if (c10 == 'f') {
                            if (this.text.startsWith("false", i11)) {
                                int i13 = this.f6709bp + 5;
                                this.f6709bp = i13;
                                char charAt = charAt(i13);
                                this.f6710ch = charAt;
                                if (charAt == ' ' || charAt == ',' || charAt == '}' || charAt == ']' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == 26 || charAt == '\f' || charAt == '\b' || charAt == ':') {
                                    this.token = 7;
                                    return;
                                }
                            }
                            throw new JSONException("scan false error");
                        } else if (c10 == 'n') {
                            if (this.text.startsWith(LpaConstants.VALUE_NULL, i11)) {
                                this.f6709bp += 4;
                                i10 = 8;
                            } else if (this.text.startsWith("new", this.f6709bp)) {
                                this.f6709bp += 3;
                                i10 = 9;
                            } else {
                                i10 = 0;
                            }
                            if (i10 != 0) {
                                char charAt2 = charAt(this.f6709bp);
                                this.f6710ch = charAt2;
                                if (charAt2 == ' ' || charAt2 == ',' || charAt2 == '}' || charAt2 == ']' || charAt2 == '\n' || charAt2 == '\r' || charAt2 == '\t' || charAt2 == 26 || charAt2 == '\f' || charAt2 == '\b') {
                                    this.token = i10;
                                    return;
                                }
                            }
                            throw new JSONException("scan null/new error");
                        } else if (c10 == '{') {
                            int i14 = i11 + 1;
                            this.f6709bp = i14;
                            if (i14 < this.len) {
                                c11 = this.text.charAt(i14);
                            }
                            this.f6710ch = c11;
                            this.token = 12;
                            return;
                        } else if (c10 == '}') {
                            int i15 = i11 + 1;
                            this.f6709bp = i15;
                            if (i15 < this.len) {
                                c11 = this.text.charAt(i15);
                            }
                            this.f6710ch = c11;
                            this.token = 13;
                            return;
                        } else if (!(c10 == 'S' || c10 == 'T')) {
                            if (c10 == 't') {
                                if (this.text.startsWith("true", i11)) {
                                    int i16 = this.f6709bp + 4;
                                    this.f6709bp = i16;
                                    char charAt3 = charAt(i16);
                                    this.f6710ch = charAt3;
                                    if (charAt3 == ' ' || charAt3 == ',' || charAt3 == '}' || charAt3 == ']' || charAt3 == '\n' || charAt3 == '\r' || charAt3 == '\t' || charAt3 == 26 || charAt3 == '\f' || charAt3 == '\b' || charAt3 == ':') {
                                        this.token = 6;
                                        return;
                                    }
                                }
                                throw new JSONException("scan true error");
                            } else if (c10 != 'u') {
                                switch (c10) {
                                    case '\b':
                                    case '\t':
                                    case '\n':
                                        break;
                                    default:
                                        switch (c10) {
                                            case '\'':
                                                scanString();
                                                return;
                                            case '(':
                                                next();
                                                this.token = 10;
                                                return;
                                            case ')':
                                                next();
                                                this.token = 11;
                                                return;
                                            default:
                                                int i17 = this.len;
                                                if (i11 == i17 || (c10 == 26 && i11 + 1 == i17)) {
                                                    if (this.token != 20) {
                                                        this.token = 20;
                                                        int i18 = this.eofPos;
                                                        this.f6709bp = i18;
                                                        this.pos = i18;
                                                        return;
                                                    }
                                                    throw new JSONException("EOF error");
                                                } else if (c10 <= 31 || c10 == 127) {
                                                    next();
                                                    break;
                                                } else {
                                                    this.token = 1;
                                                    next();
                                                    return;
                                                }
                                                break;
                                        }
                                }
                            }
                        }
                    } else {
                        next();
                        this.token = 17;
                        return;
                    }
                }
                next();
            }
        }
    }

    public final void nextTokenWithChar(char c10) {
        this.f6712sp = 0;
        while (true) {
            char c11 = this.f6710ch;
            if (c11 == c10) {
                int i10 = this.f6709bp + 1;
                this.f6709bp = i10;
                this.f6710ch = i10 >= this.len ? EOI : this.text.charAt(i10);
                nextToken();
                return;
            } else if (c11 == ' ' || c11 == '\n' || c11 == '\r' || c11 == '\t' || c11 == '\f' || c11 == '\b') {
                next();
            } else {
                throw new JSONException("not match " + c10 + " - " + this.f6710ch);
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.f6711np + this.f6712sp) - 1);
        int i10 = this.f6712sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        return subString(this.f6711np, i10);
    }

    public boolean scanBoolean() {
        boolean z10 = false;
        int i10 = 1;
        if (this.text.startsWith("false", this.f6709bp)) {
            i10 = 5;
        } else if (this.text.startsWith("true", this.f6709bp)) {
            i10 = 4;
            z10 = true;
        } else {
            char c10 = this.f6710ch;
            if (c10 == '1') {
                z10 = true;
            } else if (c10 != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i11 = this.f6709bp + i10;
        this.f6709bp = i11;
        this.f6710ch = charAt(i11);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanFieldBoolean(long j10) {
        boolean z10;
        int i10;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return false;
        }
        if (this.text.startsWith("false", this.f6709bp + matchFieldHash)) {
            i10 = matchFieldHash + 5;
        } else {
            if (this.text.startsWith("true", this.f6709bp + matchFieldHash)) {
                i10 = matchFieldHash + 4;
            } else if (this.text.startsWith("\"false\"", this.f6709bp + matchFieldHash)) {
                i10 = matchFieldHash + 7;
            } else if (this.text.startsWith("\"true\"", this.f6709bp + matchFieldHash)) {
                i10 = matchFieldHash + 6;
            } else {
                this.matchStat = -1;
                return false;
            }
            z10 = true;
            int i11 = i10 + 1;
            int i12 = this.f6709bp + i10;
            int i13 = this.len;
            char c10 = EOI;
            charAt = i12 < i13 ? (char) 26 : this.text.charAt(i12);
            if (charAt != ',') {
                int i14 = this.f6709bp + (i11 - 1);
                this.f6709bp = i14;
                int i15 = i14 + 1;
                this.f6709bp = i15;
                if (i15 < this.len) {
                    c10 = this.text.charAt(i15);
                }
                this.f6710ch = c10;
                this.matchStat = 3;
                this.token = 16;
                return z10;
            } else if (charAt == '}') {
                int i16 = i11 + 1;
                char charAt2 = charAt(this.f6709bp + i11);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i17 = this.f6709bp + (i16 - 1);
                    this.f6709bp = i17;
                    int i18 = i17 + 1;
                    this.f6709bp = i18;
                    if (i18 < this.len) {
                        c10 = this.text.charAt(i18);
                    }
                    this.f6710ch = c10;
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i19 = this.f6709bp + (i16 - 1);
                    this.f6709bp = i19;
                    int i20 = i19 + 1;
                    this.f6709bp = i20;
                    if (i20 < this.len) {
                        c10 = this.text.charAt(i20);
                    }
                    this.f6710ch = c10;
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i21 = this.f6709bp + (i16 - 1);
                    this.f6709bp = i21;
                    int i22 = i21 + 1;
                    this.f6709bp = i22;
                    if (i22 < this.len) {
                        c10 = this.text.charAt(i22);
                    }
                    this.f6710ch = c10;
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.f6709bp += i16 - 1;
                    this.f6710ch = EOI;
                } else {
                    this.matchStat = -1;
                    return false;
                }
                this.matchStat = 4;
                return z10;
            } else {
                this.matchStat = -1;
                return false;
            }
        }
        z10 = false;
        int i112 = i10 + 1;
        int i122 = this.f6709bp + i10;
        int i132 = this.len;
        char c102 = EOI;
        if (i122 < i132) {
        }
        if (charAt != ',') {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00bb A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00b8 -> B:51:0x00b9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double scanFieldDouble(long j10) {
        int i10;
        char charAt;
        int i11;
        double d10;
        int i12;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0d;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.f6709bp + matchFieldHash);
        int i14 = this.f6709bp;
        int i15 = (i14 + i13) - 1;
        boolean z10 = charAt3 == '-';
        if (z10) {
            i13++;
            charAt3 = charAt(i14 + i13);
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i16 = charAt3 - '0';
        while (true) {
            i10 = i13 + 1;
            charAt = charAt(this.f6709bp + i13);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i16 = (i16 * 10) + (charAt - '0');
            i13 = i10;
        }
        if (charAt == '.') {
            int i17 = i10 + 1;
            char charAt4 = charAt(this.f6709bp + i10);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            i16 = (i16 * 10) + (charAt4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                charAt2 = charAt(this.f6709bp + i17);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            i10 = i12;
            i11 = i18;
            charAt = charAt2;
        } else {
            i11 = 1;
        }
        boolean z11 = charAt == 'e' || charAt == 'E';
        if (z11) {
            int i19 = i10 + 1;
            charAt = charAt(this.f6709bp + i10);
            if (charAt == '+' || charAt == '-') {
                int i20 = i19 + 1;
                charAt = charAt(this.f6709bp + i19);
                i10 = i20;
                if (charAt >= '0' && charAt <= '9') {
                    i20 = i10 + 1;
                    charAt = charAt(this.f6709bp + i10);
                    i10 = i20;
                    if (charAt >= '0') {
                        i20 = i10 + 1;
                        charAt = charAt(this.f6709bp + i10);
                        i10 = i20;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i10 = i19;
                if (charAt >= '0') {
                }
            }
        }
        int i21 = ((this.f6709bp + i10) - i15) - 1;
        if (z11 || i21 >= 10) {
            d10 = Double.parseDouble(subString(i15, i21));
        } else {
            d10 = i16 / i11;
            if (z10) {
                d10 = -d10;
            }
        }
        if (charAt == ',') {
            this.f6709bp += i10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return d10;
        } else if (charAt == '}') {
            int i22 = i10 + 1;
            char charAt5 = charAt(this.f6709bp + i10);
            if (charAt5 == ',') {
                this.token = 16;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == 26) {
                this.f6709bp += i22 - 1;
                this.token = 20;
                this.f6710ch = EOI;
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 4;
            return d10;
        } else {
            this.matchStat = -1;
            return 0.0d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x021a, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x021c, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0116 -> B:83:0x0119). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double[] scanFieldDoubleArray(long j10) {
        int i10;
        char charAt;
        int i11;
        double d10;
        char charAt2;
        boolean z10 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        double[] dArr = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i12 = matchFieldHash + 1;
        int i13 = this.f6709bp + matchFieldHash;
        if ((i13 >= this.len ? EOI : this.text.charAt(i13)) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i14 = i12 + 1;
        int i15 = this.f6709bp + i12;
        char charAt3 = i15 >= this.len ? EOI : this.text.charAt(i15);
        double[] dArr2 = new double[16];
        int i16 = 0;
        while (true) {
            int i17 = this.f6709bp;
            int i18 = (i17 + i14) - 1;
            boolean z11 = charAt3 == '-' ? true : z10;
            if (z11) {
                i14++;
                int i19 = i17 + i14;
                charAt3 = i19 >= this.len ? EOI : this.text.charAt(i19);
            }
            if (charAt3 < '0' || charAt3 > '9') {
                break;
            }
            int i20 = charAt3 - '0';
            while (true) {
                i10 = i14 + 1;
                int i21 = this.f6709bp + i14;
                charAt = i21 >= this.len ? EOI : this.text.charAt(i21);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i20 = (i20 * 10) + (charAt - '0');
                i14 = i10;
            }
            if (charAt == '.' ? true : z10) {
                int i22 = i10 + 1;
                int i23 = this.f6709bp + i10;
                char charAt4 = i23 >= this.len ? EOI : this.text.charAt(i23);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    i20 = (i20 * 10) + (charAt4 - '0');
                    i11 = 10;
                    while (true) {
                        i10 = i22 + 1;
                        int i24 = this.f6709bp + i22;
                        charAt = i24 >= this.len ? EOI : this.text.charAt(i24);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i20 = (i20 * 10) + (charAt - '0');
                        i11 *= 10;
                        i22 = i10;
                    }
                } else {
                    break;
                }
            } else {
                i11 = 1;
            }
            boolean z12 = charAt == 'e' || charAt == 'E';
            if (z12) {
                int i25 = i10 + 1;
                int i26 = this.f6709bp + i10;
                char charAt5 = i26 >= this.len ? EOI : this.text.charAt(i26);
                if (charAt5 == '+' || charAt5 == '-') {
                    int i27 = i25 + 1;
                    int i28 = this.f6709bp + i25;
                    if (i28 < this.len) {
                        charAt2 = this.text.charAt(i28);
                        i10 = i27;
                        charAt = charAt2;
                        if (charAt >= '0' && charAt <= '9') {
                            i27 = i10 + 1;
                            int i29 = this.f6709bp + i10;
                            if (i29 < this.len) {
                                charAt2 = this.text.charAt(i29);
                                i10 = i27;
                                charAt = charAt2;
                                if (charAt >= '0') {
                                    i27 = i10 + 1;
                                    int i292 = this.f6709bp + i10;
                                    if (i292 < this.len) {
                                    }
                                }
                            }
                        }
                    }
                    charAt2 = EOI;
                    i10 = i27;
                    charAt = charAt2;
                    if (charAt >= '0') {
                    }
                } else {
                    charAt = charAt5;
                    i10 = i25;
                    if (charAt >= '0') {
                    }
                }
            }
            int i30 = ((this.f6709bp + i10) - i18) - 1;
            if (z12 || i30 >= 10) {
                d10 = Double.parseDouble(subString(i18, i30));
            } else {
                d10 = i20 / i11;
                if (z11) {
                    d10 = -d10;
                }
            }
            if (i16 >= dArr2.length) {
                double[] dArr3 = new double[(dArr2.length * 3) / 2];
                System.arraycopy(dArr2, 0, dArr3, 0, i16);
                dArr2 = dArr3;
            }
            int i31 = i16 + 1;
            dArr2[i16] = d10;
            if (charAt == ',') {
                i10++;
                int i32 = this.f6709bp + i10;
                charAt = i32 >= this.len ? EOI : this.text.charAt(i32);
            } else if (charAt == ']') {
                int i33 = i10 + 1;
                int i34 = this.f6709bp + i10;
                char charAt6 = i34 >= this.len ? EOI : this.text.charAt(i34);
                if (i31 != dArr2.length) {
                    double[] dArr4 = new double[i31];
                    System.arraycopy(dArr2, 0, dArr4, 0, i31);
                    dArr2 = dArr4;
                }
                if (charAt6 == ',') {
                    this.f6709bp += i33 - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return dArr2;
                } else if (charAt6 == '}') {
                    int i35 = i33 + 1;
                    int i36 = this.f6709bp + i33;
                    char charAt7 = i36 >= this.len ? EOI : this.text.charAt(i36);
                    if (charAt7 == ',') {
                        this.token = 16;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == ']') {
                        this.token = 15;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == '}') {
                        this.token = 13;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == 26) {
                        this.f6709bp += i35 - 1;
                        this.token = 20;
                        this.f6710ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return dArr2;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            dArr = null;
            z10 = false;
            charAt3 = charAt;
            i16 = i31;
            i14 = i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x028c, code lost:
        r4 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0290, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e6, code lost:
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e8, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0129 -> B:85:0x012c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double[][] scanFieldDoubleArray2(long j10) {
        int i10;
        char charAt;
        int i11;
        double d10;
        int i12;
        char c10;
        double[][] dArr;
        int i13;
        int i14;
        int i15;
        double[][] dArr2;
        char charAt2;
        int i16 = 0;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        double[][] dArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i17 = matchFieldHash + 1;
        int i18 = this.f6709bp + matchFieldHash;
        char charAt3 = i18 >= this.len ? EOI : this.text.charAt(i18);
        char c11 = '[';
        if (charAt3 != '[') {
            this.matchStat = -2;
            return null;
        }
        int i19 = i17 + 1;
        int i20 = this.f6709bp + i17;
        char charAt4 = i20 >= this.len ? EOI : this.text.charAt(i20);
        int i21 = 16;
        double[][] dArr4 = new double[16];
        int i22 = 0;
        loop0: while (true) {
            if (charAt4 == c11) {
                int i23 = i19 + 1;
                int i24 = this.f6709bp + i19;
                char charAt5 = i24 >= this.len ? EOI : this.text.charAt(i24);
                double[] dArr5 = new double[i21];
                int i25 = i16;
                while (true) {
                    int i26 = this.f6709bp;
                    int i27 = (i26 + i23) - 1;
                    int i28 = charAt5 == '-' ? 1 : i16;
                    if (i28 != 0) {
                        i23++;
                        int i29 = i26 + i23;
                        charAt5 = i29 >= this.len ? EOI : this.text.charAt(i29);
                    }
                    if (charAt5 < '0' || charAt5 > '9') {
                        break loop0;
                    }
                    int i30 = charAt5 - '0';
                    while (true) {
                        i10 = i23 + 1;
                        int i31 = this.f6709bp + i23;
                        charAt = i31 >= this.len ? EOI : this.text.charAt(i31);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i30 = (i30 * 10) + (charAt - '0');
                        i23 = i10;
                    }
                    if (charAt == '.') {
                        int i32 = i10 + 1;
                        int i33 = this.f6709bp + i10;
                        char charAt6 = i33 >= this.len ? EOI : this.text.charAt(i33);
                        if (charAt6 >= '0' && charAt6 <= '9') {
                            i30 = (i30 * 10) + (charAt6 - '0');
                            i11 = 10;
                            while (true) {
                                i10 = i32 + 1;
                                int i34 = this.f6709bp + i32;
                                charAt = i34 >= this.len ? EOI : this.text.charAt(i34);
                                if (charAt < '0' || charAt > '9') {
                                    break;
                                }
                                i30 = (i30 * 10) + (charAt - '0');
                                i11 *= 10;
                                i32 = i10;
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        i11 = 1;
                    }
                    boolean z10 = charAt == 'e' || charAt == 'E';
                    if (z10) {
                        int i35 = i10 + 1;
                        int i36 = this.f6709bp + i10;
                        char charAt7 = i36 >= this.len ? EOI : this.text.charAt(i36);
                        if (charAt7 == '+' || charAt7 == '-') {
                            int i37 = i35 + 1;
                            int i38 = this.f6709bp + i35;
                            if (i38 < this.len) {
                                charAt2 = this.text.charAt(i38);
                                i10 = i37;
                                charAt = charAt2;
                                if (charAt >= '0' && charAt <= '9') {
                                    i37 = i10 + 1;
                                    int i39 = this.f6709bp + i10;
                                    if (i39 < this.len) {
                                        charAt2 = this.text.charAt(i39);
                                        i10 = i37;
                                        charAt = charAt2;
                                        if (charAt >= '0') {
                                            i37 = i10 + 1;
                                            int i392 = this.f6709bp + i10;
                                            if (i392 < this.len) {
                                            }
                                        }
                                    }
                                }
                            }
                            charAt2 = EOI;
                            i10 = i37;
                            charAt = charAt2;
                            if (charAt >= '0') {
                            }
                        } else {
                            charAt = charAt7;
                            i10 = i35;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    int i40 = ((this.f6709bp + i10) - i27) - 1;
                    if (z10 || i40 >= 10) {
                        d10 = Double.parseDouble(subString(i27, i40));
                    } else {
                        d10 = i30 / i11;
                        if (i28 != 0) {
                            d10 = -d10;
                        }
                    }
                    if (i25 >= dArr5.length) {
                        double[] dArr6 = new double[(dArr5.length * 3) / 2];
                        System.arraycopy(dArr5, 0, dArr6, 0, i25);
                        dArr5 = dArr6;
                    }
                    int i41 = i25 + 1;
                    dArr5[i25] = d10;
                    if (charAt == ',') {
                        i23 = i10 + 1;
                        int i42 = this.f6709bp + i10;
                        charAt5 = i42 >= this.len ? EOI : this.text.charAt(i42);
                        dArr = null;
                        c10 = 16;
                        i12 = 0;
                    } else if (charAt == ']') {
                        int i43 = i10 + 1;
                        int i44 = this.f6709bp + i10;
                        char charAt8 = i44 >= this.len ? EOI : this.text.charAt(i44);
                        if (i41 != dArr5.length) {
                            double[] dArr7 = new double[i41];
                            i13 = 0;
                            System.arraycopy(dArr5, 0, dArr7, 0, i41);
                            dArr5 = dArr7;
                        } else {
                            i13 = 0;
                        }
                        if (i22 >= dArr4.length) {
                            dArr4 = new double[(dArr4.length * 3) / 2];
                            System.arraycopy(dArr5, i13, dArr4, i13, i41);
                        }
                        int i45 = i22 + 1;
                        dArr4[i22] = dArr5;
                        if (charAt8 == ',') {
                            i19 = i43 + 1;
                            int i46 = this.f6709bp + i43;
                            charAt4 = i46 >= this.len ? EOI : this.text.charAt(i46);
                            dArr2 = null;
                            i15 = 16;
                            i14 = 0;
                        } else if (charAt8 == ']') {
                            int i47 = i43 + 1;
                            int i48 = this.f6709bp + i43;
                            char charAt9 = i48 >= this.len ? EOI : this.text.charAt(i48);
                            if (i45 != dArr4.length) {
                                double[][] dArr8 = new double[i45];
                                System.arraycopy(dArr4, 0, dArr8, 0, i45);
                                dArr4 = dArr8;
                            }
                            if (charAt9 == ',') {
                                this.f6709bp += i47 - 1;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return dArr4;
                            } else if (charAt9 == '}') {
                                int i49 = i47 + 1;
                                char charAt10 = charAt(this.f6709bp + i47);
                                if (charAt10 == ',') {
                                    this.token = 16;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == ']') {
                                    this.token = 15;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == '}') {
                                    this.token = 13;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == 26) {
                                    this.f6709bp += i49 - 1;
                                    this.token = 20;
                                    this.f6710ch = EOI;
                                } else {
                                    this.matchStat = -1;
                                    return null;
                                }
                                this.matchStat = 4;
                                return dArr4;
                            } else {
                                this.matchStat = -1;
                                return null;
                            }
                        } else {
                            dArr2 = null;
                            i15 = 16;
                            i14 = 0;
                            charAt4 = charAt8;
                            i19 = i43;
                        }
                        i22 = i45;
                        dArr3 = dArr2;
                        i21 = i15;
                        i16 = i14;
                    } else {
                        dArr = null;
                        c10 = 16;
                        i12 = 0;
                        charAt5 = charAt;
                        i23 = i10;
                    }
                    dArr3 = dArr;
                    i16 = i12;
                    i25 = i41;
                }
            } else {
                dArr3 = dArr3;
            }
            c11 = '[';
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00b0 -> B:50:0x00b1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFieldFloat(long j10) {
        int i10;
        char charAt;
        int i11;
        float f10;
        int i12;
        char charAt2;
        boolean z10 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0.0f;
        }
        int i13 = matchFieldHash + 1;
        char charAt3 = charAt(this.f6709bp + matchFieldHash);
        int i14 = this.f6709bp;
        int i15 = (i14 + i13) - 1;
        boolean z11 = charAt3 == '-';
        if (z11) {
            i13++;
            charAt3 = charAt(i14 + i13);
        }
        if (charAt3 < '0' || charAt3 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i16 = charAt3 - '0';
        while (true) {
            i10 = i13 + 1;
            charAt = charAt(this.f6709bp + i13);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i16 = (i16 * 10) + (charAt - '0');
            i13 = i10;
        }
        if (charAt == '.') {
            int i17 = i10 + 1;
            char charAt4 = charAt(this.f6709bp + i10);
            if (charAt4 < '0' || charAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i16 = (i16 * 10) + (charAt4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                charAt2 = charAt(this.f6709bp + i17);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (charAt2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            i10 = i12;
            i11 = i18;
            charAt = charAt2;
        } else {
            i11 = 1;
        }
        if (charAt == 'e' || charAt == 'E') {
            z10 = true;
        }
        if (z10) {
            int i19 = i10 + 1;
            charAt = charAt(this.f6709bp + i10);
            if (charAt == '+' || charAt == '-') {
                int i20 = i19 + 1;
                charAt = charAt(this.f6709bp + i19);
                i10 = i20;
                if (charAt >= '0' && charAt <= '9') {
                    i20 = i10 + 1;
                    charAt = charAt(this.f6709bp + i10);
                    i10 = i20;
                    if (charAt >= '0') {
                        i20 = i10 + 1;
                        charAt = charAt(this.f6709bp + i10);
                        i10 = i20;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i10 = i19;
                if (charAt >= '0') {
                }
            }
        }
        int i21 = ((this.f6709bp + i10) - i15) - 1;
        if (z10 || i21 >= 10) {
            f10 = Float.parseFloat(subString(i15, i21));
        } else {
            f10 = i16 / i11;
            if (z11) {
                f10 = -f10;
            }
        }
        if (charAt == ',') {
            this.f6709bp += i10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f10;
        } else if (charAt == '}') {
            int i22 = i10 + 1;
            char charAt5 = charAt(this.f6709bp + i10);
            if (charAt5 == ',') {
                this.token = 16;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == ']') {
                this.token = 15;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == '}') {
                this.token = 13;
                this.f6709bp += i22 - 1;
                next();
            } else if (charAt5 == 26) {
                this.f6709bp += i22 - 1;
                this.token = 20;
                this.f6710ch = EOI;
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 4;
            return f10;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x021a, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x021c, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0116 -> B:83:0x0119). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] scanFieldFloatArray(long j10) {
        int i10;
        char charAt;
        int i11;
        float f10;
        char charAt2;
        boolean z10 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        float[] fArr = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i12 = matchFieldHash + 1;
        int i13 = this.f6709bp + matchFieldHash;
        if ((i13 >= this.len ? EOI : this.text.charAt(i13)) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i14 = i12 + 1;
        int i15 = this.f6709bp + i12;
        char charAt3 = i15 >= this.len ? EOI : this.text.charAt(i15);
        float[] fArr2 = new float[16];
        int i16 = 0;
        while (true) {
            int i17 = this.f6709bp;
            int i18 = (i17 + i14) - 1;
            boolean z11 = charAt3 == '-' ? true : z10;
            if (z11) {
                i14++;
                int i19 = i17 + i14;
                charAt3 = i19 >= this.len ? EOI : this.text.charAt(i19);
            }
            if (charAt3 < '0' || charAt3 > '9') {
                break;
            }
            int i20 = charAt3 - '0';
            while (true) {
                i10 = i14 + 1;
                int i21 = this.f6709bp + i14;
                charAt = i21 >= this.len ? EOI : this.text.charAt(i21);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i20 = (i20 * 10) + (charAt - '0');
                i14 = i10;
            }
            if (charAt == '.' ? true : z10) {
                int i22 = i10 + 1;
                int i23 = this.f6709bp + i10;
                char charAt4 = i23 >= this.len ? EOI : this.text.charAt(i23);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    i20 = (i20 * 10) + (charAt4 - '0');
                    i11 = 10;
                    while (true) {
                        i10 = i22 + 1;
                        int i24 = this.f6709bp + i22;
                        charAt = i24 >= this.len ? EOI : this.text.charAt(i24);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i20 = (i20 * 10) + (charAt - '0');
                        i11 *= 10;
                        i22 = i10;
                    }
                } else {
                    break;
                }
            } else {
                i11 = 1;
            }
            boolean z12 = charAt == 'e' || charAt == 'E';
            if (z12) {
                int i25 = i10 + 1;
                int i26 = this.f6709bp + i10;
                char charAt5 = i26 >= this.len ? EOI : this.text.charAt(i26);
                if (charAt5 == '+' || charAt5 == '-') {
                    int i27 = i25 + 1;
                    int i28 = this.f6709bp + i25;
                    if (i28 < this.len) {
                        charAt2 = this.text.charAt(i28);
                        i10 = i27;
                        charAt = charAt2;
                        if (charAt >= '0' && charAt <= '9') {
                            i27 = i10 + 1;
                            int i29 = this.f6709bp + i10;
                            if (i29 < this.len) {
                                charAt2 = this.text.charAt(i29);
                                i10 = i27;
                                charAt = charAt2;
                                if (charAt >= '0') {
                                    i27 = i10 + 1;
                                    int i292 = this.f6709bp + i10;
                                    if (i292 < this.len) {
                                    }
                                }
                            }
                        }
                    }
                    charAt2 = EOI;
                    i10 = i27;
                    charAt = charAt2;
                    if (charAt >= '0') {
                    }
                } else {
                    charAt = charAt5;
                    i10 = i25;
                    if (charAt >= '0') {
                    }
                }
            }
            int i30 = ((this.f6709bp + i10) - i18) - 1;
            if (z12 || i30 >= 10) {
                f10 = Float.parseFloat(subString(i18, i30));
            } else {
                f10 = i20 / i11;
                if (z11) {
                    f10 = -f10;
                }
            }
            if (i16 >= fArr2.length) {
                float[] fArr3 = new float[(fArr2.length * 3) / 2];
                System.arraycopy(fArr2, 0, fArr3, 0, i16);
                fArr2 = fArr3;
            }
            int i31 = i16 + 1;
            fArr2[i16] = f10;
            if (charAt == ',') {
                i10++;
                int i32 = this.f6709bp + i10;
                charAt = i32 >= this.len ? EOI : this.text.charAt(i32);
            } else if (charAt == ']') {
                int i33 = i10 + 1;
                int i34 = this.f6709bp + i10;
                char charAt6 = i34 >= this.len ? EOI : this.text.charAt(i34);
                if (i31 != fArr2.length) {
                    float[] fArr4 = new float[i31];
                    System.arraycopy(fArr2, 0, fArr4, 0, i31);
                    fArr2 = fArr4;
                }
                if (charAt6 == ',') {
                    this.f6709bp += i33 - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return fArr2;
                } else if (charAt6 == '}') {
                    int i35 = i33 + 1;
                    int i36 = this.f6709bp + i33;
                    char charAt7 = i36 >= this.len ? EOI : this.text.charAt(i36);
                    if (charAt7 == ',') {
                        this.token = 16;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == ']') {
                        this.token = 15;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == '}') {
                        this.token = 13;
                        this.f6709bp += i35 - 1;
                        next();
                    } else if (charAt7 == 26) {
                        this.f6709bp += i35 - 1;
                        this.token = 20;
                        this.f6710ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return fArr2;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            fArr = null;
            z10 = false;
            charAt3 = charAt;
            i16 = i31;
            i14 = i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x028b, code lost:
        r11 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x028e, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e6, code lost:
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e8, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0129 -> B:85:0x012c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] scanFieldFloatArray2(long j10) {
        int i10;
        char charAt;
        int i11;
        float f10;
        float[][] fArr;
        int i12;
        char c10;
        int i13;
        float[][] fArr2;
        int i14;
        int i15;
        char charAt2;
        int i16 = 0;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        float[][] fArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i17 = matchFieldHash + 1;
        int i18 = this.f6709bp + matchFieldHash;
        char charAt3 = i18 >= this.len ? EOI : this.text.charAt(i18);
        char c11 = '[';
        if (charAt3 != '[') {
            this.matchStat = -2;
            return null;
        }
        int i19 = i17 + 1;
        int i20 = this.f6709bp + i17;
        char charAt4 = i20 >= this.len ? EOI : this.text.charAt(i20);
        int i21 = 16;
        float[][] fArr4 = new float[16];
        int i22 = 0;
        loop0: while (true) {
            if (charAt4 == c11) {
                int i23 = i19 + 1;
                int i24 = this.f6709bp + i19;
                char charAt5 = i24 >= this.len ? EOI : this.text.charAt(i24);
                float[] fArr5 = new float[i21];
                int i25 = i16;
                while (true) {
                    int i26 = this.f6709bp;
                    int i27 = (i26 + i23) - 1;
                    int i28 = charAt5 == '-' ? 1 : i16;
                    if (i28 != 0) {
                        i23++;
                        int i29 = i26 + i23;
                        charAt5 = i29 >= this.len ? EOI : this.text.charAt(i29);
                    }
                    if (charAt5 < '0' || charAt5 > '9') {
                        break loop0;
                    }
                    int i30 = charAt5 - '0';
                    while (true) {
                        i10 = i23 + 1;
                        int i31 = this.f6709bp + i23;
                        charAt = i31 >= this.len ? EOI : this.text.charAt(i31);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i30 = (i30 * 10) + (charAt - '0');
                        i23 = i10;
                    }
                    if (charAt == '.') {
                        int i32 = i10 + 1;
                        int i33 = this.f6709bp + i10;
                        char charAt6 = i33 >= this.len ? EOI : this.text.charAt(i33);
                        if (charAt6 >= '0' && charAt6 <= '9') {
                            i30 = (i30 * 10) + (charAt6 - '0');
                            i11 = 10;
                            while (true) {
                                i10 = i32 + 1;
                                int i34 = this.f6709bp + i32;
                                charAt = i34 >= this.len ? EOI : this.text.charAt(i34);
                                if (charAt < '0' || charAt > '9') {
                                    break;
                                }
                                i30 = (i30 * 10) + (charAt - '0');
                                i11 *= 10;
                                i32 = i10;
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        i11 = 1;
                    }
                    boolean z10 = charAt == 'e' || charAt == 'E';
                    if (z10) {
                        int i35 = i10 + 1;
                        int i36 = this.f6709bp + i10;
                        char charAt7 = i36 >= this.len ? EOI : this.text.charAt(i36);
                        if (charAt7 == '+' || charAt7 == '-') {
                            int i37 = i35 + 1;
                            int i38 = this.f6709bp + i35;
                            if (i38 < this.len) {
                                charAt2 = this.text.charAt(i38);
                                i10 = i37;
                                charAt = charAt2;
                                if (charAt >= '0' && charAt <= '9') {
                                    i37 = i10 + 1;
                                    int i39 = this.f6709bp + i10;
                                    if (i39 < this.len) {
                                        charAt2 = this.text.charAt(i39);
                                        i10 = i37;
                                        charAt = charAt2;
                                        if (charAt >= '0') {
                                            i37 = i10 + 1;
                                            int i392 = this.f6709bp + i10;
                                            if (i392 < this.len) {
                                            }
                                        }
                                    }
                                }
                            }
                            charAt2 = EOI;
                            i10 = i37;
                            charAt = charAt2;
                            if (charAt >= '0') {
                            }
                        } else {
                            charAt = charAt7;
                            i10 = i35;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    int i40 = ((this.f6709bp + i10) - i27) - 1;
                    if (z10 || i40 >= 10) {
                        f10 = Float.parseFloat(subString(i27, i40));
                    } else {
                        f10 = i30 / i11;
                        if (i28 != 0) {
                            f10 = -f10;
                        }
                    }
                    if (i25 >= fArr5.length) {
                        float[] fArr6 = new float[(fArr5.length * 3) / 2];
                        System.arraycopy(fArr5, 0, fArr6, 0, i25);
                        fArr5 = fArr6;
                    }
                    int i41 = i25 + 1;
                    fArr5[i25] = f10;
                    if (charAt == ',') {
                        i10++;
                        int i42 = this.f6709bp + i10;
                        charAt5 = i42 >= this.len ? EOI : this.text.charAt(i42);
                        c10 = 16;
                        i12 = 0;
                        fArr = null;
                    } else if (charAt == ']') {
                        int i43 = i10 + 1;
                        int i44 = this.f6709bp + i10;
                        char charAt8 = i44 >= this.len ? EOI : this.text.charAt(i44);
                        if (i41 != fArr5.length) {
                            float[] fArr7 = new float[i41];
                            i13 = 0;
                            System.arraycopy(fArr5, 0, fArr7, 0, i41);
                            fArr5 = fArr7;
                        } else {
                            i13 = 0;
                        }
                        if (i22 >= fArr4.length) {
                            fArr4 = new float[(fArr4.length * 3) / 2];
                            System.arraycopy(fArr5, i13, fArr4, i13, i41);
                        }
                        int i45 = i22 + 1;
                        fArr4[i22] = fArr5;
                        if (charAt8 == ',') {
                            i19 = i43 + 1;
                            int i46 = this.f6709bp + i43;
                            charAt4 = i46 >= this.len ? EOI : this.text.charAt(i46);
                            i15 = 16;
                            i14 = 0;
                            fArr2 = null;
                        } else if (charAt8 == ']') {
                            int i47 = i43 + 1;
                            int i48 = this.f6709bp + i43;
                            char charAt9 = i48 >= this.len ? EOI : this.text.charAt(i48);
                            if (i45 != fArr4.length) {
                                float[][] fArr8 = new float[i45];
                                System.arraycopy(fArr4, 0, fArr8, 0, i45);
                                fArr4 = fArr8;
                            }
                            if (charAt9 == ',') {
                                this.f6709bp += i47 - 1;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return fArr4;
                            } else if (charAt9 == '}') {
                                int i49 = i47 + 1;
                                char charAt10 = charAt(this.f6709bp + i47);
                                if (charAt10 == ',') {
                                    this.token = 16;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == ']') {
                                    this.token = 15;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == '}') {
                                    this.token = 13;
                                    this.f6709bp += i49 - 1;
                                    next();
                                } else if (charAt10 == 26) {
                                    this.f6709bp += i49 - 1;
                                    this.token = 20;
                                    this.f6710ch = EOI;
                                } else {
                                    this.matchStat = -1;
                                    return null;
                                }
                                this.matchStat = 4;
                                return fArr4;
                            } else {
                                this.matchStat = -1;
                                return null;
                            }
                        } else {
                            i15 = 16;
                            i14 = 0;
                            fArr2 = null;
                            charAt4 = charAt8;
                            i19 = i43;
                        }
                        i22 = i45;
                        i21 = i15;
                        i16 = i14;
                        fArr3 = fArr2;
                        c11 = '[';
                    } else {
                        c10 = 16;
                        i12 = 0;
                        fArr = null;
                        charAt5 = charAt;
                    }
                    fArr3 = fArr;
                    i25 = i41;
                    i16 = i12;
                    i23 = i10;
                }
            }
        }
    }

    public int scanFieldInt(long j10) {
        boolean z10;
        int i10;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.f6709bp + matchFieldHash;
        int i13 = this.len;
        char c10 = EOI;
        char charAt2 = i12 >= i13 ? (char) 26 : this.text.charAt(i12);
        if (charAt2 == '\"') {
            i11++;
            int i14 = this.f6709bp + i11;
            charAt2 = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            z10 = true;
        } else {
            z10 = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i15 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i16 = this.f6709bp + i11;
            charAt = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i15 = (i15 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0;
            }
            i10++;
            int i17 = this.f6709bp + i10;
            charAt = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
        }
        if (i15 < 0) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i18 = this.f6709bp + (i10 - 1);
            this.f6709bp = i18;
            int i19 = i18 + 1;
            this.f6709bp = i19;
            if (i19 < this.len) {
                c10 = this.text.charAt(i19);
            }
            this.f6710ch = c10;
            this.matchStat = 3;
            this.token = 16;
            return i15;
        } else if (charAt == '}') {
            int i20 = i10 + 1;
            char charAt3 = charAt(this.f6709bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i21 = this.f6709bp + (i20 - 1);
                this.f6709bp = i21;
                int i22 = i21 + 1;
                this.f6709bp = i22;
                if (i22 < this.len) {
                    c10 = this.text.charAt(i22);
                }
                this.f6710ch = c10;
            } else if (charAt3 == ']') {
                this.token = 15;
                int i23 = this.f6709bp + (i20 - 1);
                this.f6709bp = i23;
                int i24 = i23 + 1;
                this.f6709bp = i24;
                if (i24 < this.len) {
                    c10 = this.text.charAt(i24);
                }
                this.f6710ch = c10;
            } else if (charAt3 == '}') {
                this.token = 13;
                int i25 = this.f6709bp + (i20 - 1);
                this.f6709bp = i25;
                int i26 = i25 + 1;
                this.f6709bp = i26;
                if (i26 < this.len) {
                    c10 = this.text.charAt(i26);
                }
                this.f6710ch = c10;
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f6709bp += i20 - 1;
                this.f6710ch = EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return i15;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(long j10) {
        int i10;
        int i11;
        char c10;
        boolean z10;
        int[] iArr;
        int i12;
        int i13;
        char charAt;
        int[] iArr2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        int[] iArr3 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i14 = matchFieldHash + 1;
        int i15 = this.f6709bp + matchFieldHash;
        if ((i15 >= this.len ? (char) 26 : this.text.charAt(i15)) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i16 = i14 + 1;
        int i17 = this.f6709bp + i14;
        char charAt2 = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
        int[] iArr4 = new int[16];
        if (charAt2 == ']') {
            i10 = i16 + 1;
            int i18 = this.f6709bp + i16;
            c10 = i18 >= this.len ? (char) 26 : this.text.charAt(i18);
            i11 = 0;
        } else {
            int i19 = 0;
            while (true) {
                if (charAt2 == '-') {
                    i16++;
                    int i20 = this.f6709bp + i16;
                    charAt2 = i20 >= this.len ? (char) 26 : this.text.charAt(i20);
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (charAt2 >= '0') {
                    if (charAt2 > '9') {
                        i12 = -1;
                        iArr = null;
                        break;
                    }
                    int i21 = charAt2 - '0';
                    while (true) {
                        i13 = i16 + 1;
                        int i22 = this.f6709bp + i16;
                        charAt = i22 >= this.len ? (char) 26 : this.text.charAt(i22);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i21 = (i21 * 10) + (charAt - '0');
                        i16 = i13;
                    }
                    if (i19 >= iArr4.length) {
                        int[] iArr5 = new int[(iArr4.length * 3) / 2];
                        System.arraycopy(iArr4, 0, iArr5, 0, i19);
                        iArr4 = iArr5;
                    }
                    i11 = i19 + 1;
                    if (z10) {
                        i21 = -i21;
                    }
                    iArr4[i19] = i21;
                    if (charAt == ',') {
                        i13++;
                        int i23 = this.f6709bp + i13;
                        iArr2 = null;
                        charAt = i23 >= this.len ? (char) 26 : this.text.charAt(i23);
                    } else if (charAt == ']') {
                        i10 = i13 + 1;
                        int i24 = this.f6709bp + i13;
                        c10 = i24 >= this.len ? (char) 26 : this.text.charAt(i24);
                    } else {
                        iArr2 = null;
                    }
                    i19 = i11;
                    charAt2 = charAt;
                    iArr3 = iArr2;
                    i16 = i13;
                } else {
                    iArr = iArr3;
                    i12 = -1;
                    break;
                }
            }
            this.matchStat = i12;
            return iArr;
        }
        if (i11 != iArr4.length) {
            int[] iArr6 = new int[i11];
            System.arraycopy(iArr4, 0, iArr6, 0, i11);
            iArr4 = iArr6;
        }
        if (c10 == ',') {
            this.f6709bp += i10 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr4;
        } else if (c10 == '}') {
            int i25 = i10 + 1;
            char charAt3 = charAt(this.f6709bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                this.f6709bp += i25 - 1;
                next();
            } else if (charAt3 == ']') {
                this.token = 15;
                this.f6709bp += i25 - 1;
                next();
            } else if (charAt3 == '}') {
                this.token = 13;
                this.f6709bp += i25 - 1;
                next();
            } else if (charAt3 == 26) {
                this.f6709bp += i25 - 1;
                this.token = 20;
                this.f6710ch = EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr4;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(long j10) {
        int i10;
        char charAt;
        boolean z10 = false;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i11 = matchFieldHash + 1;
        int i12 = this.f6709bp + matchFieldHash;
        char charAt2 = i12 >= this.len ? EOI : this.text.charAt(i12);
        if (charAt2 == '\"') {
            i11++;
            int i13 = this.f6709bp + i11;
            charAt2 = i13 >= this.len ? EOI : this.text.charAt(i13);
            z10 = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = charAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i14 = this.f6709bp + i11;
            charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j11 = (j11 * 10) + (charAt - '0');
            i11 = i10;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == '\"') {
            if (!z10) {
                this.matchStat = -1;
                return 0L;
            }
            i10++;
            int i15 = this.f6709bp + i10;
            charAt = i15 >= this.len ? EOI : this.text.charAt(i15);
        }
        if (j11 < 0) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i16 = this.f6709bp + (i10 - 1);
            this.f6709bp = i16;
            int i17 = i16 + 1;
            this.f6709bp = i17;
            this.f6710ch = i17 >= this.len ? EOI : this.text.charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return j11;
        } else if (charAt == '}') {
            int i18 = i10 + 1;
            char charAt3 = charAt(this.f6709bp + i10);
            if (charAt3 == ',') {
                this.token = 16;
                int i19 = this.f6709bp + (i18 - 1);
                this.f6709bp = i19;
                int i20 = i19 + 1;
                this.f6709bp = i20;
                this.f6710ch = i20 >= this.len ? EOI : this.text.charAt(i20);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i21 = this.f6709bp + (i18 - 1);
                this.f6709bp = i21;
                int i22 = i21 + 1;
                this.f6709bp = i22;
                this.f6710ch = i22 >= this.len ? EOI : this.text.charAt(i22);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i23 = this.f6709bp + (i18 - 1);
                this.f6709bp = i23;
                int i24 = i23 + 1;
                this.f6709bp = i24;
                this.f6710ch = i24 >= this.len ? EOI : this.text.charAt(i24);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f6709bp += i18 - 1;
                this.f6710ch = EOI;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return j11;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public String scanFieldString(long j10) {
        String str;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return null;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.f6709bp + matchFieldHash;
        if (i11 >= this.len) {
            throw new JSONException("unclosed str, " + info());
        } else if (this.text.charAt(i11) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        } else {
            int i12 = this.f6709bp + i10;
            int indexOf = this.text.indexOf(34, i12);
            if (indexOf != -1) {
                if (V6) {
                    str = this.text.substring(i12, indexOf);
                } else {
                    int i13 = indexOf - i12;
                    str = new String(sub_chars(this.f6709bp + i10, i13), 0, i13);
                }
                if (str.indexOf(92) != -1) {
                    boolean z10 = false;
                    while (true) {
                        int i14 = indexOf - 1;
                        int i15 = 0;
                        while (i14 >= 0 && this.text.charAt(i14) == '\\') {
                            i15++;
                            i14--;
                            z10 = true;
                        }
                        if (i15 % 2 == 0) {
                            break;
                        }
                        indexOf = this.text.indexOf(34, indexOf + 1);
                    }
                    int i16 = indexOf - i12;
                    char[] sub_chars = sub_chars(this.f6709bp + i10, i16);
                    if (z10) {
                        str = readString(sub_chars, i16);
                    } else {
                        str = new String(sub_chars, 0, i16);
                        if (str.indexOf(92) != -1) {
                            str = readString(sub_chars, i16);
                        }
                    }
                }
                int i17 = indexOf + 1;
                int i18 = this.len;
                char c10 = EOI;
                char charAt = i17 >= i18 ? (char) 26 : this.text.charAt(i17);
                if (charAt == ',') {
                    this.f6709bp = i17;
                    int i19 = i17 + 1;
                    this.f6709bp = i19;
                    if (i19 < this.len) {
                        c10 = this.text.charAt(i19);
                    }
                    this.f6710ch = c10;
                    this.matchStat = 3;
                    this.token = 16;
                    return str;
                } else if (charAt == '}') {
                    int i20 = i17 + 1;
                    char charAt2 = i20 >= this.len ? (char) 26 : this.text.charAt(i20);
                    if (charAt2 == ',') {
                        this.token = 16;
                        this.f6709bp = i20;
                        next();
                    } else if (charAt2 == ']') {
                        this.token = 15;
                        this.f6709bp = i20;
                        next();
                    } else if (charAt2 == '}') {
                        this.token = 13;
                        this.f6709bp = i20;
                        next();
                    } else if (charAt2 == 26) {
                        this.token = 20;
                        this.f6709bp = i20;
                        this.f6710ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return this.stringDefaultValue;
                    }
                    this.matchStat = 4;
                    return str;
                } else {
                    this.matchStat = -1;
                    return this.stringDefaultValue;
                }
            } else {
                throw new JSONException("unclosed str, " + info());
            }
        }
    }

    public long scanFieldSymbol(long j10) {
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j10);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i10 = matchFieldHash + 1;
        int i11 = this.f6709bp + matchFieldHash;
        int i12 = this.len;
        char c10 = EOI;
        if ((i11 >= i12 ? (char) 26 : this.text.charAt(i11)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j11 = -2128831035;
        while (true) {
            int i13 = i10 + 1;
            int i14 = this.f6709bp + i10;
            char charAt = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            if (charAt == '\"') {
                int i15 = i13 + 1;
                int i16 = this.f6709bp + i13;
                char charAt2 = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
                if (charAt2 == ',') {
                    int i17 = this.f6709bp + (i15 - 1);
                    this.f6709bp = i17;
                    int i18 = i17 + 1;
                    this.f6709bp = i18;
                    if (i18 < this.len) {
                        c10 = this.text.charAt(i18);
                    }
                    this.f6710ch = c10;
                    this.matchStat = 3;
                    return j11;
                } else if (charAt2 == '}') {
                    int i19 = i15 + 1;
                    int i20 = this.f6709bp + i15;
                    char charAt3 = i20 >= this.len ? (char) 26 : this.text.charAt(i20);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.f6709bp += i19 - 1;
                        next();
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.f6709bp += i19 - 1;
                        next();
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.f6709bp += i19 - 1;
                        next();
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.f6709bp += i19 - 1;
                        this.f6710ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j11;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            } else {
                j11 = (j11 ^ charAt) * 16777619;
                if (charAt == '\\') {
                    this.matchStat = -1;
                    return 0L;
                }
                i10 = i13;
            }
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        char charAt;
        int i14;
        int i15;
        char charAt2;
        int i16;
        char charAt3;
        char charAt4;
        int i17 = this.len;
        int i18 = this.f6709bp;
        int i19 = i17 - i18;
        if (!z10 && i19 > 13 && this.text.startsWith("/Date(", i18) && charAt((this.f6709bp + i19) - 1) == '/' && charAt((this.f6709bp + i19) - 2) == ')') {
            int i20 = -1;
            for (int i21 = 6; i21 < i19; i21++) {
                char charAt5 = charAt(this.f6709bp + i21);
                if (charAt5 != '+') {
                    if (charAt5 < '0' || charAt5 > '9') {
                        break;
                    }
                } else {
                    i20 = i21;
                }
            }
            if (i20 == -1) {
                return false;
            }
            int i22 = this.f6709bp + 6;
            long parseLong = Long.parseLong(subString(i22, i20 - i22), 10);
            Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
            this.calendar = calendar;
            calendar.setTimeInMillis(parseLong);
            this.token = 5;
            return true;
        } else if (i19 == 8 || i19 == 14 || i19 == 17) {
            int i23 = 0;
            if (z10) {
                return false;
            }
            char charAt6 = charAt(this.f6709bp);
            char charAt7 = charAt(this.f6709bp + 1);
            char charAt8 = charAt(this.f6709bp + 2);
            char charAt9 = charAt(this.f6709bp + 3);
            char charAt10 = charAt(this.f6709bp + 4);
            char charAt11 = charAt(this.f6709bp + 5);
            char charAt12 = charAt(this.f6709bp + 6);
            char charAt13 = charAt(this.f6709bp + 7);
            if (!checkDate(charAt6, charAt7, charAt8, charAt9, charAt10, charAt11, charAt12, charAt13)) {
                return false;
            }
            setCalendar(charAt6, charAt7, charAt8, charAt9, charAt10, charAt11, charAt12, charAt13);
            if (i19 != 8) {
                char charAt14 = charAt(this.f6709bp + 8);
                char charAt15 = charAt(this.f6709bp + 9);
                char charAt16 = charAt(this.f6709bp + 10);
                char charAt17 = charAt(this.f6709bp + 11);
                char charAt18 = charAt(this.f6709bp + 12);
                char charAt19 = charAt(this.f6709bp + 13);
                if (!checkTime(charAt14, charAt15, charAt16, charAt17, charAt18, charAt19)) {
                    return false;
                }
                if (i19 == 17) {
                    char charAt20 = charAt(this.f6709bp + 14);
                    char charAt21 = charAt(this.f6709bp + 15);
                    char charAt22 = charAt(this.f6709bp + 16);
                    c10 = '0';
                    if (charAt20 < '0' || charAt20 > '9' || charAt21 < '0' || charAt21 > '9' || charAt22 < '0' || charAt22 > '9') {
                        return false;
                    }
                    i13 = ((charAt20 - '0') * 100) + ((charAt21 - '0') * 10) + (charAt22 - '0');
                } else {
                    c10 = '0';
                    i13 = 0;
                }
                i10 = ((charAt14 - c10) * 10) + (charAt15 - c10);
                i23 = ((charAt16 - c10) * 10) + (charAt17 - c10);
                i11 = ((charAt18 - '0') * 10) + (charAt19 - '0');
                i12 = i13;
            } else {
                i12 = 0;
                i11 = 0;
                i10 = 0;
            }
            this.calendar.set(11, i10);
            this.calendar.set(12, i23);
            this.calendar.set(13, i11);
            this.calendar.set(14, i12);
            this.token = 5;
            return true;
        } else if (i19 < 10 || charAt(this.f6709bp + 4) != '-' || charAt(this.f6709bp + 7) != '-') {
            return false;
        } else {
            char charAt23 = charAt(this.f6709bp);
            char charAt24 = charAt(this.f6709bp + 1);
            char charAt25 = charAt(this.f6709bp + 2);
            char charAt26 = charAt(this.f6709bp + 3);
            char charAt27 = charAt(this.f6709bp + 5);
            char charAt28 = charAt(this.f6709bp + 6);
            char charAt29 = charAt(this.f6709bp + 8);
            char charAt30 = charAt(this.f6709bp + 9);
            if (!checkDate(charAt23, charAt24, charAt25, charAt26, charAt27, charAt28, charAt29, charAt30)) {
                return false;
            }
            setCalendar(charAt23, charAt24, charAt25, charAt26, charAt27, charAt28, charAt29, charAt30);
            char charAt31 = charAt(this.f6709bp + 10);
            if (charAt31 == 'T' || (charAt31 == ' ' && !z10)) {
                if (!(i19 >= 19 && charAt(this.f6709bp + 13) == ':' && charAt(this.f6709bp + 16) == ':')) {
                    return false;
                }
                char charAt32 = charAt(this.f6709bp + 11);
                char charAt33 = charAt(this.f6709bp + 12);
                char charAt34 = charAt(this.f6709bp + 14);
                char charAt35 = charAt(this.f6709bp + 15);
                char charAt36 = charAt(this.f6709bp + 17);
                char charAt37 = charAt(this.f6709bp + 18);
                if (!checkTime(charAt32, charAt33, charAt34, charAt35, charAt36, charAt37)) {
                    return false;
                }
                this.calendar.set(11, ((charAt32 - '0') * 10) + (charAt33 - '0'));
                this.calendar.set(12, ((charAt34 - '0') * 10) + (charAt35 - '0'));
                this.calendar.set(13, ((charAt36 - '0') * 10) + (charAt37 - '0'));
                char charAt38 = charAt(this.f6709bp + 19);
                if (charAt38 == '.') {
                    if (i19 >= 21 && (charAt = charAt(this.f6709bp + 20)) >= '0' && charAt <= '9') {
                        int[] iArr = digits;
                        int i24 = iArr[charAt];
                        if (i19 <= 21 || (charAt4 = charAt(this.f6709bp + 21)) < '0' || charAt4 > '9') {
                            i14 = 1;
                        } else {
                            i24 = (i24 * 10) + iArr[charAt4];
                            i14 = 2;
                        }
                        if (i14 == 2 && (charAt3 = charAt(this.f6709bp + 22)) >= '0' && charAt3 <= '9') {
                            i24 = (i24 * 10) + iArr[charAt3];
                            i14 = 3;
                        }
                        this.calendar.set(14, i24);
                        char charAt39 = charAt(this.f6709bp + 20 + i14);
                        if (charAt39 == '+' || charAt39 == '-') {
                            char charAt40 = charAt(this.f6709bp + 20 + i14 + 1);
                            if (charAt40 >= '0' && charAt40 <= '1' && (charAt2 = charAt(this.f6709bp + 20 + i14 + 2)) >= '0' && charAt2 <= '9') {
                                char charAt41 = charAt(this.f6709bp + 20 + i14 + 3);
                                if (charAt41 == ':') {
                                    if (!(charAt(this.f6709bp + 20 + i14 + 4) == '0' && charAt(this.f6709bp + 20 + i14 + 5) == '0')) {
                                        return false;
                                    }
                                    i16 = 6;
                                } else if (charAt41 != '0') {
                                    i16 = 3;
                                } else if (charAt(this.f6709bp + 20 + i14 + 4) != '0') {
                                    return false;
                                } else {
                                    i16 = 5;
                                }
                                int i25 = ((iArr[charAt40] * 10) + iArr[charAt2]) * 3600 * 1000;
                                if (charAt39 == '-') {
                                    i25 = -i25;
                                }
                                if (this.calendar.getTimeZone().getRawOffset() != i25) {
                                    String[] availableIDs = TimeZone.getAvailableIDs(i25);
                                    if (availableIDs.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                i15 = i16;
                            }
                        } else if (charAt39 == 'Z') {
                            if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                if (availableIDs2.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                }
                            }
                            i15 = 1;
                        } else {
                            i15 = 0;
                        }
                        int i26 = i14 + 20 + i15;
                        char charAt42 = charAt(this.f6709bp + i26);
                        if (!(charAt42 == 26 || charAt42 == '\"')) {
                            return false;
                        }
                        int i27 = this.f6709bp + i26;
                        this.f6709bp = i27;
                        this.f6710ch = charAt(i27);
                        this.token = 5;
                        return true;
                    }
                    return false;
                }
                this.calendar.set(14, 0);
                int i28 = this.f6709bp + 19;
                this.f6709bp = i28;
                this.f6710ch = charAt(i28);
                this.token = 5;
                if (charAt38 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs3 = TimeZone.getAvailableIDs(0);
                    if (availableIDs3.length > 0) {
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs3[0]));
                    }
                }
                return true;
            } else if (charAt31 != '\"' && charAt31 != 26) {
                return false;
            } else {
                this.calendar.set(11, 0);
                this.calendar.set(12, 0);
                this.calendar.set(13, 0);
                this.calendar.set(14, 0);
                int i29 = this.f6709bp + 10;
                this.f6709bp = i29;
                this.f6710ch = charAt(i29);
                this.token = 5;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
        if (r0 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c5, code lost:
        return -r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long scanLongValue() {
        long j10;
        boolean z10 = false;
        this.f6711np = 0;
        if (this.f6710ch == '-') {
            j10 = Long.MIN_VALUE;
            this.f6711np = 0 + 1;
            int i10 = this.f6709bp + 1;
            this.f6709bp = i10;
            if (i10 < this.len) {
                this.f6710ch = this.text.charAt(i10);
                z10 = true;
            } else {
                throw new JSONException("syntax error, " + info());
            }
        } else {
            j10 = -9223372036854775807L;
        }
        long j11 = 0;
        while (true) {
            char c10 = this.f6710ch;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            int i11 = c10 - '0';
            if (j11 >= -922337203685477580L) {
                long j12 = j11 * 10;
                long j13 = i11;
                if (j12 >= j10 + j13) {
                    j11 = j12 - j13;
                    this.f6711np++;
                    int i12 = this.f6709bp + 1;
                    this.f6709bp = i12;
                    this.f6710ch = i12 >= this.len ? EOI : this.text.charAt(i12);
                } else {
                    throw new JSONException("error long value, " + j12 + ", " + info());
                }
            } else {
                throw new JSONException("error long value, " + j11 + ", " + info());
            }
        }
    }

    public final void scanNumber() {
        char c10;
        char c11;
        int i10 = this.f6709bp;
        this.f6711np = i10;
        this.exp = false;
        if (this.f6710ch == '-') {
            this.f6712sp++;
            int i11 = i10 + 1;
            this.f6709bp = i11;
            this.f6710ch = i11 >= this.len ? (char) 26 : this.text.charAt(i11);
        }
        while (true) {
            c10 = this.f6710ch;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            this.f6712sp++;
            int i12 = this.f6709bp + 1;
            this.f6709bp = i12;
            this.f6710ch = i12 >= this.len ? (char) 26 : this.text.charAt(i12);
        }
        this.isDouble = false;
        if (c10 == '.') {
            this.f6712sp++;
            int i13 = this.f6709bp + 1;
            this.f6709bp = i13;
            this.f6710ch = i13 >= this.len ? (char) 26 : this.text.charAt(i13);
            this.isDouble = true;
            while (true) {
                char c12 = this.f6710ch;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                this.f6712sp++;
                int i14 = this.f6709bp + 1;
                this.f6709bp = i14;
                this.f6710ch = i14 >= this.len ? (char) 26 : this.text.charAt(i14);
            }
        }
        char c13 = this.f6710ch;
        if (c13 == 'L') {
            this.f6712sp++;
            next();
        } else if (c13 == 'S') {
            this.f6712sp++;
            next();
        } else if (c13 == 'B') {
            this.f6712sp++;
            next();
        } else if (c13 == 'F') {
            this.f6712sp++;
            next();
            this.isDouble = true;
        } else if (c13 == 'D') {
            this.f6712sp++;
            next();
            this.isDouble = true;
        } else if (c13 == 'e' || c13 == 'E') {
            this.f6712sp++;
            int i15 = this.f6709bp + 1;
            this.f6709bp = i15;
            char charAt = i15 >= this.len ? (char) 26 : this.text.charAt(i15);
            this.f6710ch = charAt;
            if (charAt == '+' || charAt == '-') {
                this.f6712sp++;
                int i16 = this.f6709bp + 1;
                this.f6709bp = i16;
                this.f6710ch = i16 >= this.len ? (char) 26 : this.text.charAt(i16);
            }
            while (true) {
                c11 = this.f6710ch;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                this.f6712sp++;
                int i17 = this.f6709bp + 1;
                this.f6709bp = i17;
                this.f6710ch = i17 >= this.len ? (char) 26 : this.text.charAt(i17);
            }
            if (c11 == 'D' || c11 == 'F') {
                this.f6712sp++;
                next();
            }
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020c A[Catch: NumberFormatException -> 0x0254, TryCatch #0 {NumberFormatException -> 0x0254, blocks: (B:116:0x01fc, B:121:0x0205, B:122:0x0208, B:124:0x020c, B:127:0x0214, B:129:0x021b, B:130:0x021d, B:133:0x0224, B:136:0x022a, B:138:0x022f, B:141:0x0235, B:143:0x023a, B:145:0x0244, B:147:0x024a), top: B:152:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0224 A[Catch: NumberFormatException -> 0x0254, TryCatch #0 {NumberFormatException -> 0x0254, blocks: (B:116:0x01fc, B:121:0x0205, B:122:0x0208, B:124:0x020c, B:127:0x0214, B:129:0x021b, B:130:0x021d, B:133:0x0224, B:136:0x022a, B:138:0x022f, B:141:0x0235, B:143:0x023a, B:145:0x0244, B:147:0x024a), top: B:152:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x022f A[Catch: NumberFormatException -> 0x0254, TryCatch #0 {NumberFormatException -> 0x0254, blocks: (B:116:0x01fc, B:121:0x0205, B:122:0x0208, B:124:0x020c, B:127:0x0214, B:129:0x021b, B:130:0x021d, B:133:0x0224, B:136:0x022a, B:138:0x022f, B:141:0x0235, B:143:0x023a, B:145:0x0244, B:147:0x024a), top: B:152:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0244 A[Catch: NumberFormatException -> 0x0254, TryCatch #0 {NumberFormatException -> 0x0254, blocks: (B:116:0x01fc, B:121:0x0205, B:122:0x0208, B:124:0x020c, B:127:0x0214, B:129:0x021b, B:130:0x021d, B:133:0x0224, B:136:0x022a, B:138:0x022f, B:141:0x0235, B:143:0x023a, B:145:0x0244, B:147:0x024a), top: B:152:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024a A[Catch: NumberFormatException -> 0x0254, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0254, blocks: (B:116:0x01fc, B:121:0x0205, B:122:0x0208, B:124:0x020c, B:127:0x0214, B:129:0x021b, B:130:0x021d, B:133:0x0224, B:136:0x022a, B:138:0x022f, B:141:0x0235, B:143:0x023a, B:145:0x0244, B:147:0x024a), top: B:152:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Number scanNumberValue() {
        long j10;
        boolean z10;
        char c10;
        boolean z11;
        Number number;
        boolean z12;
        char c11;
        boolean z13;
        char c12;
        int i10;
        char[] cArr;
        int i11;
        char[] cArr2;
        Number valueOf;
        int i12;
        char charAt;
        Number valueOf2;
        int i13 = this.f6709bp;
        this.f6711np = 0;
        if (this.f6710ch == '-') {
            j10 = Long.MIN_VALUE;
            this.f6711np = 0 + 1;
            int i14 = i13 + 1;
            this.f6709bp = i14;
            this.f6710ch = i14 >= this.len ? EOI : this.text.charAt(i14);
            z10 = true;
        } else {
            j10 = -9223372036854775807L;
            z10 = false;
        }
        long j11 = 0;
        boolean z14 = false;
        while (true) {
            c10 = this.f6710ch;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            int i15 = c10 - '0';
            if (j11 < -922337203685477580L) {
                z14 = true;
            }
            long j12 = j11 * 10;
            long j13 = i15;
            if (j12 < j10 + j13) {
                z14 = true;
            }
            j11 = j12 - j13;
            this.f6711np++;
            int i16 = this.f6709bp + 1;
            this.f6709bp = i16;
            this.f6710ch = i16 >= this.len ? EOI : this.text.charAt(i16);
        }
        if (!z10) {
            j11 = -j11;
        }
        try {
            if (c10 == 'L') {
                this.f6711np++;
                next();
                valueOf2 = Long.valueOf(j11);
            } else if (c10 == 'S') {
                this.f6711np++;
                next();
                valueOf2 = Short.valueOf((short) j11);
            } else if (c10 == 'B') {
                this.f6711np++;
                next();
                valueOf2 = Byte.valueOf((byte) j11);
            } else if (c10 == 'F') {
                this.f6711np++;
                next();
                valueOf2 = Float.valueOf((float) j11);
            } else {
                if (c10 == 'D') {
                    this.f6711np++;
                    next();
                    z11 = z10;
                    number = Double.valueOf(j11);
                } else {
                    z11 = z10;
                    number = null;
                }
                if (this.f6710ch != '.') {
                    this.f6711np++;
                    int i17 = this.f6709bp + 1;
                    this.f6709bp = i17;
                    this.f6710ch = i17 >= this.len ? EOI : this.text.charAt(i17);
                    while (true) {
                        char c13 = this.f6710ch;
                        if (c13 < '0' || c13 > '9') {
                            break;
                        }
                        this.f6711np++;
                        int i18 = this.f6709bp + 1;
                        this.f6709bp = i18;
                        this.f6710ch = i18 >= this.len ? EOI : this.text.charAt(i18);
                    }
                    z12 = true;
                } else {
                    z12 = false;
                }
                c11 = this.f6710ch;
                if (c11 != 'e' || c11 == 'E') {
                    this.f6711np++;
                    int i19 = this.f6709bp + 1;
                    this.f6709bp = i19;
                    charAt = i19 < this.len ? EOI : this.text.charAt(i19);
                    this.f6710ch = charAt;
                    if (charAt != '+' || charAt == '-') {
                        this.f6711np++;
                        int i20 = this.f6709bp + 1;
                        this.f6709bp = i20;
                        this.f6710ch = i20 < this.len ? EOI : this.text.charAt(i20);
                    }
                    while (true) {
                        c12 = this.f6710ch;
                        if (c12 < '0' || c12 > '9') {
                            break;
                        }
                        this.f6711np++;
                        int i21 = this.f6709bp + 1;
                        this.f6709bp = i21;
                        this.f6710ch = i21 >= this.len ? EOI : this.text.charAt(i21);
                    }
                    if (c12 != 'D' || c12 == 'F') {
                        this.f6711np++;
                        next();
                    } else {
                        c12 = 0;
                    }
                    z13 = true;
                } else {
                    c12 = 0;
                    z13 = false;
                }
                if (!z12 || z13) {
                    i10 = this.f6709bp - i13;
                    if (c12 != 0) {
                        i10--;
                    }
                    cArr = this.sbuf;
                    if (i10 >= cArr.length) {
                        i11 = 0;
                        this.text.getChars(i13, i13 + i10, cArr, 0);
                        cArr2 = this.sbuf;
                    } else {
                        i11 = 0;
                        char[] cArr3 = new char[i10];
                        this.text.getChars(i13, i13 + i10, cArr3, 0);
                        cArr2 = cArr3;
                    }
                    if (z13 && (this.features & Feature.UseBigDecimal.mask) != 0) {
                        return new BigDecimal(cArr2, i11, i10);
                    }
                    if (i10 <= 9 || z13) {
                        String str = new String(cArr2, 0, i10);
                        if (c12 != 'F') {
                            valueOf = Float.valueOf(str);
                        } else {
                            valueOf = Double.valueOf(Double.parseDouble(str));
                        }
                        return valueOf;
                    }
                    char c14 = cArr2[i11];
                    if (!(c14 == '-' || c14 == '+')) {
                        i12 = 1;
                        int i22 = c14 - '0';
                        int i23 = 0;
                        while (i12 < i10) {
                            char c15 = cArr2[i12];
                            if (c15 == '.') {
                                i23 = 1;
                            } else {
                                i22 = (i22 * 10) + (c15 - '0');
                                if (i23 != 0) {
                                    i23 *= 10;
                                }
                            }
                            i12++;
                        }
                        if (c12 != 'F') {
                            float f10 = i22 / i23;
                            if (z11) {
                                f10 = -f10;
                            }
                            return Float.valueOf(f10);
                        }
                        double d10 = i22 / i23;
                        if (z11) {
                            d10 = -d10;
                        }
                        return Double.valueOf(d10);
                    }
                    i12 = 2;
                    c14 = cArr2[1];
                    int i222 = c14 - '0';
                    int i232 = 0;
                    while (i12 < i10) {
                    }
                    if (c12 != 'F') {
                    }
                } else {
                    if (z14) {
                        int i24 = this.f6709bp;
                        char[] cArr4 = new char[i24 - i13];
                        this.text.getChars(i13, i24, cArr4, 0);
                        number = new BigInteger(new String(cArr4));
                    }
                    if (number != null) {
                        return number;
                    }
                    if (j11 <= -2147483648L || j11 >= 2147483647L) {
                        return Long.valueOf(j11);
                    }
                    return Integer.valueOf((int) j11);
                }
            }
            if (i10 <= 9) {
            }
            String str2 = new String(cArr2, 0, i10);
            if (c12 != 'F') {
            }
            return valueOf;
        } catch (NumberFormatException e10) {
            throw new JSONException(e10.getMessage() + ", " + info(), e10);
        }
        z11 = z10;
        number = valueOf2;
        if (this.f6710ch != '.') {
        }
        c11 = this.f6710ch;
        if (c11 != 'e') {
        }
        this.f6711np++;
        int i192 = this.f6709bp + 1;
        this.f6709bp = i192;
        if (i192 < this.len) {
        }
        this.f6710ch = charAt;
        if (charAt != '+') {
        }
        this.f6711np++;
        int i202 = this.f6709bp + 1;
        this.f6709bp = i202;
        this.f6710ch = i202 < this.len ? EOI : this.text.charAt(i202);
        while (true) {
            c12 = this.f6710ch;
            if (c12 < '0') {
                break;
            }
            break;
            this.f6710ch = i21 >= this.len ? EOI : this.text.charAt(i21);
        }
        if (c12 != 'D') {
        }
        this.f6711np++;
        next();
        z13 = true;
        if (!z12) {
        }
        i10 = this.f6709bp - i13;
        if (c12 != 0) {
        }
        cArr = this.sbuf;
        if (i10 >= cArr.length) {
        }
        if (z13) {
        }
    }

    public final void scanString() {
        char c10 = this.f6710ch;
        int i10 = this.f6709bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.f6709bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = 1;
                for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c10, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (!z10) {
                for (int i15 = 0; i15 < i11; i15++) {
                    if (sub_chars[i15] == '\\') {
                        z10 = true;
                    }
                }
            }
            this.sbuf = sub_chars;
            this.f6712sp = i11;
            this.f6711np = this.f6709bp;
            this.hasSpecial = z10;
            int i16 = indexOf + 1;
            this.f6709bp = i16;
            this.f6710ch = i16 >= this.len ? EOI : this.text.charAt(i16);
            this.token = 4;
            return;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public String scanStringValue(char c10) {
        String str;
        int i10 = this.f6709bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            if (V6) {
                str = this.text.substring(i10, indexOf);
            } else {
                int i11 = indexOf - i10;
                str = new String(sub_chars(this.f6709bp + 1, i11), 0, i11);
            }
            if (str.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = indexOf - 1; i13 >= 0 && this.text.charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(c10, indexOf + 1);
                }
                int i14 = indexOf - i10;
                str = readString(sub_chars(this.f6709bp + 1, i14), i14);
            }
            int i15 = indexOf + 1;
            this.f6709bp = i15;
            this.f6710ch = i15 >= this.len ? EOI : this.text.charAt(i15);
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c10;
        while (true) {
            c10 = this.f6710ch;
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                break;
            }
            next();
        }
        if (c10 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c10 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c10 == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c10 == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c10 != 26) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            this.token = 20;
            return null;
        }
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i10 = this.f6710ch;
        boolean[] zArr = firstIdentifierFlags;
        if (i10 >= zArr.length || zArr[i10]) {
            this.f6711np = this.f6709bp;
            this.f6712sp = 1;
            while (true) {
                char next = next();
                boolean[] zArr2 = identifierFlags;
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i10 = (i10 * 31) + next;
                this.f6712sp++;
            }
            this.f6710ch = charAt(this.f6709bp);
            this.token = 18;
            if (this.f6712sp != 4 || !this.text.startsWith(LpaConstants.VALUE_NULL, this.f6711np)) {
                return symbolTable.addSymbol(this.text, this.f6711np, this.f6712sp, i10);
            }
            return null;
        }
        throw new JSONException("illegal identifier : " + this.f6710ch + ", " + info());
    }

    protected void skipComment() {
        next();
        char c10 = this.f6710ch;
        if (c10 == '/') {
            do {
                next();
            } while (this.f6710ch != '\n');
            next();
        } else if (c10 == '*') {
            next();
            while (true) {
                char c11 = this.f6710ch;
                if (c11 == 26) {
                    return;
                }
                if (c11 == '*') {
                    next();
                    if (this.f6710ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void skipWhitespace() {
        while (true) {
            char c10 = this.f6710ch;
            if (c10 > '/') {
                return;
            }
            if (c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t' || c10 == '\f' || c10 == '\b') {
                next();
            } else if (c10 == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return readString(this.sbuf, this.f6712sp);
        }
        return subString(this.f6711np + 1, this.f6712sp);
    }

    final char[] sub_chars(int i10, int i11) {
        char[] cArr = this.sbuf;
        if (i11 < cArr.length) {
            this.text.getChars(i10, i11 + i10, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i11];
        this.sbuf = cArr2;
        this.text.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i10) {
        this(cArr, i10, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i10, int i11) {
        this(new String(cArr, 0, i10), i11);
    }

    public JSONLexer(String str, int i10) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean z10 = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String str2 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i10;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.f6709bp = -1;
        int i11 = (-1) + 1;
        this.f6709bp = i11;
        char charAt = i11 >= length ? EOI : str.charAt(i11);
        this.f6710ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i10) != 0 ? "" : str2;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i10) != 0 ? true : z10;
    }

    public String scanSymbol(SymbolTable symbolTable, char c10) {
        String str;
        int i10 = this.f6709bp + 1;
        int indexOf = this.text.indexOf(c10, i10);
        if (indexOf != -1) {
            int i11 = indexOf - i10;
            char[] sub_chars = sub_chars(this.f6709bp + 1, i11);
            boolean z10 = false;
            while (i11 > 0 && sub_chars[i11 - 1] == '\\') {
                int i12 = 1;
                for (int i13 = i11 - 2; i13 >= 0 && sub_chars[i13] == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                int indexOf2 = this.text.indexOf(c10, indexOf + 1);
                int i14 = (indexOf2 - indexOf) + i11;
                if (i14 >= sub_chars.length) {
                    int length = (sub_chars.length * 3) / 2;
                    if (length < i14) {
                        length = i14;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                    sub_chars = cArr;
                }
                this.text.getChars(indexOf, indexOf2, sub_chars, i11);
                indexOf = indexOf2;
                i11 = i14;
                z10 = true;
            }
            if (!z10) {
                int i15 = 0;
                for (int i16 = 0; i16 < i11; i16++) {
                    char c11 = sub_chars[i16];
                    i15 = (i15 * 31) + c11;
                    if (c11 == '\\') {
                        z10 = true;
                    }
                }
                if (z10) {
                    str = readString(sub_chars, i11);
                } else {
                    str = i11 < 20 ? symbolTable.addSymbol(sub_chars, 0, i11, i15) : new String(sub_chars, 0, i11);
                }
            } else {
                str = readString(sub_chars, i11);
            }
            int i17 = indexOf + 1;
            this.f6709bp = i17;
            this.f6710ch = i17 >= this.len ? EOI : this.text.charAt(i17);
            return str;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.f6711np + this.f6712sp) - 1);
        int i10 = this.f6712sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i10--;
        }
        int i11 = this.f6711np;
        char[] cArr = this.sbuf;
        if (i10 < cArr.length) {
            this.text.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i11, i10 + i11, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public final void nextToken(int i10) {
        this.f6712sp = 0;
        while (true) {
            if (i10 != 2) {
                char c10 = EOI;
                if (i10 == 4) {
                    char c11 = this.f6710ch;
                    if (c11 == '\"') {
                        this.pos = this.f6709bp;
                        scanString();
                        return;
                    } else if (c11 >= '0' && c11 <= '9') {
                        this.pos = this.f6709bp;
                        scanNumber();
                        return;
                    } else if (c11 == '{') {
                        this.token = 12;
                        int i11 = this.f6709bp + 1;
                        this.f6709bp = i11;
                        if (i11 < this.len) {
                            c10 = this.text.charAt(i11);
                        }
                        this.f6710ch = c10;
                        return;
                    }
                } else if (i10 == 12) {
                    char c12 = this.f6710ch;
                    if (c12 == '{') {
                        this.token = 12;
                        int i12 = this.f6709bp + 1;
                        this.f6709bp = i12;
                        if (i12 < this.len) {
                            c10 = this.text.charAt(i12);
                        }
                        this.f6710ch = c10;
                        return;
                    } else if (c12 == '[') {
                        this.token = 14;
                        int i13 = this.f6709bp + 1;
                        this.f6709bp = i13;
                        if (i13 < this.len) {
                            c10 = this.text.charAt(i13);
                        }
                        this.f6710ch = c10;
                        return;
                    }
                } else if (i10 != 18) {
                    if (i10 != 20) {
                        switch (i10) {
                            case 14:
                                char c13 = this.f6710ch;
                                if (c13 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c13 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.f6710ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c14 = this.f6710ch;
                                if (c14 == ',') {
                                    this.token = 16;
                                    int i14 = this.f6709bp + 1;
                                    this.f6709bp = i14;
                                    if (i14 < this.len) {
                                        c10 = this.text.charAt(i14);
                                    }
                                    this.f6710ch = c10;
                                    return;
                                } else if (c14 == '}') {
                                    this.token = 13;
                                    int i15 = this.f6709bp + 1;
                                    this.f6709bp = i15;
                                    if (i15 < this.len) {
                                        c10 = this.text.charAt(i15);
                                    }
                                    this.f6710ch = c10;
                                    return;
                                } else if (c14 == ']') {
                                    this.token = 15;
                                    int i16 = this.f6709bp + 1;
                                    this.f6709bp = i16;
                                    if (i16 < this.len) {
                                        c10 = this.text.charAt(i16);
                                    }
                                    this.f6710ch = c10;
                                    return;
                                } else if (c14 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.f6710ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c15 = this.f6710ch;
                if (c15 >= '0' && c15 <= '9') {
                    this.pos = this.f6709bp;
                    scanNumber();
                    return;
                } else if (c15 == '\"') {
                    this.pos = this.f6709bp;
                    scanString();
                    return;
                } else if (c15 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c15 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c16 = this.f6710ch;
            if (c16 == ' ' || c16 == '\n' || c16 == '\r' || c16 == '\t' || c16 == '\f' || c16 == '\b') {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }
}
