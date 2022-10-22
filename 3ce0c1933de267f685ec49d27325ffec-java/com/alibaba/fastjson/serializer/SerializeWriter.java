package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            specicalFlags_doubleQuotes[i10] = 4;
            specicalFlags_singleQuotes[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            specicalFlags_doubleQuotes[i11] = 4;
            specicalFlags_singleQuotes[i11] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void getChars(long j10, int i10, char[] cArr) {
        char c10;
        if (j10 < 0) {
            c10 = '-';
            j10 = -j10;
        } else {
            c10 = 0;
        }
        while (j10 > 2147483647L) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            int i12 = i10 - 1;
            cArr[i12] = DigitOnes[i11];
            i10 = i12 - 1;
            cArr[i10] = DigitTens[i11];
            j10 = j11;
        }
        int i13 = (int) j10;
        while (i13 >= 65536) {
            int i14 = i13 / 100;
            int i15 = i13 - (((i14 << 6) + (i14 << 5)) + (i14 << 2));
            int i16 = i10 - 1;
            cArr[i16] = DigitOnes[i15];
            i10 = i16 - 1;
            cArr[i10] = DigitTens[i15];
            i13 = i14;
        }
        while (true) {
            int i17 = (52429 * i13) >>> 19;
            i10--;
            cArr[i10] = digits[i13 - ((i17 << 3) + (i17 << 1))];
            if (i17 == 0) {
                break;
            }
            i13 = i17;
        }
        if (c10 != 0) {
            cArr[i10 - 1] = c10;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i10);
            } else if (length == 0) {
                write(34);
                write(34);
                write(58);
                return;
            } else {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i11++;
                }
                if (z10) {
                    write(34);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(34);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = '\"';
            int i16 = i15 + 1;
            this.count = i16;
            cArr[i15] = '\"';
            this.count = i16 + 1;
            cArr[i16] = ':';
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i19];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 3, (i18 - i19) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i19);
                    char[] cArr5 = this.buf;
                    cArr5[i17] = '\"';
                    cArr5[i20] = '\\';
                    int i21 = i20 + 1;
                    cArr5[i21] = replaceChars[c10];
                    i18 += 2;
                    cArr5[this.count - 2] = '\"';
                    i19 = i21;
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i22 = i19 + 1;
                    System.arraycopy(cArr6, i22, cArr6, i19 + 2, i18 - i19);
                    char[] cArr7 = this.buf;
                    cArr7[i19] = '\\';
                    cArr7[i22] = replaceChars[c10];
                    i18++;
                    i19 = i22;
                }
            }
            i19++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.count + length + 1;
        if (i10 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i10);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i11++;
                }
                if (z10) {
                    write(39);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char charAt2 = str.charAt(i12);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i13 = this.count;
            if (i13 + 3 > this.buf.length) {
                expandCapacity(i13 + 3);
            }
            char[] cArr = this.buf;
            int i14 = this.count;
            int i15 = i14 + 1;
            this.count = i15;
            cArr[i14] = '\'';
            int i16 = i15 + 1;
            this.count = i16;
            cArr[i15] = '\'';
            this.count = i16 + 1;
            cArr[i16] = ':';
            return;
        }
        int i17 = this.count;
        int i18 = i17 + length;
        str.getChars(0, length, this.buf, i17);
        this.count = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.buf;
            char c10 = cArr2[i19];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (!z11) {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr3 = this.buf;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 3, (i18 - i19) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i19);
                    char[] cArr5 = this.buf;
                    cArr5[i17] = '\'';
                    cArr5[i20] = '\\';
                    int i21 = i20 + 1;
                    cArr5[i21] = replaceChars[c10];
                    i18 += 2;
                    cArr5[this.count - 2] = '\'';
                    i19 = i21;
                    z11 = true;
                } else {
                    i10++;
                    if (i10 > cArr2.length) {
                        expandCapacity(i10);
                    }
                    this.count = i10;
                    char[] cArr6 = this.buf;
                    int i22 = i19 + 1;
                    System.arraycopy(cArr6, i22, cArr6, i19 + 2, i18 - i19);
                    char[] cArr7 = this.buf;
                    cArr7[i19] = '\\';
                    cArr7[i22] = replaceChars[c10];
                    i18++;
                    i19 = i22;
                }
            }
            i19++;
        }
        this.buf[i10 - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            this.features = serializerFeature.mask | this.features;
            return;
        }
        this.features = (~serializerFeature.mask) & this.features;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void expandCapacity(int i10) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr2 = new char[i10];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer != null) {
            try {
                writer.write(this.buf, 0, this.count);
                this.writer.flush();
                this.count = 0;
            } catch (IOException e10) {
                throw new JSONException(e10.getMessage(), e10);
            }
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            if (str == null) {
                str = "UTF-8";
            }
            try {
                return new String(this.buf, 0, this.count).getBytes(str);
            } catch (UnsupportedEncodingException e10) {
                throw new JSONException("toBytes error", e10);
            }
        } else {
            throw new UnsupportedOperationException("writer not null");
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i10) {
        int i11 = 1;
        int i12 = this.count + 1;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                flush();
                this.buf[this.count] = (char) i10;
                this.count = i11;
            }
        }
        i11 = i12;
        this.buf[this.count] = (char) i10;
        this.count = i11;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        int i10 = 0;
        boolean z10 = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c10 = z10 ? '\'' : '\"';
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = this.count;
        int i14 = (((i12 / 3) + 1) << 2) + i13 + 2;
        if (i14 > this.buf.length) {
            if (this.writer != null) {
                write(c10);
                int i15 = 0;
                while (i15 < i11) {
                    int i16 = i15 + 1;
                    int i17 = i16 + 1;
                    int i18 = ((bArr[i15] & 255) << 16) | ((bArr[i16] & 255) << 8);
                    i15 = i17 + 1;
                    int i19 = i18 | (bArr[i17] & 255);
                    write(cArr[(i19 >>> 18) & 63]);
                    write(cArr[(i19 >>> 12) & 63]);
                    write(cArr[(i19 >>> 6) & 63]);
                    write(cArr[i19 & 63]);
                }
                int i20 = length - i11;
                if (i20 > 0) {
                    int i21 = (bArr[i11] & 255) << 10;
                    if (i20 == 2) {
                        i10 = (bArr[i12] & 255) << 2;
                    }
                    int i22 = i21 | i10;
                    write(cArr[i22 >> 12]);
                    write(cArr[(i22 >>> 6) & 63]);
                    write(i20 == 2 ? cArr[i22 & 63] : '=');
                    write(61);
                }
                write(c10);
                return;
            }
            expandCapacity(i14);
        }
        this.count = i14;
        int i23 = i13 + 1;
        this.buf[i13] = c10;
        int i24 = 0;
        while (i24 < i11) {
            int i25 = i24 + 1;
            int i26 = i25 + 1;
            int i27 = ((bArr[i24] & 255) << 16) | ((bArr[i25] & 255) << 8);
            i24 = i26 + 1;
            int i28 = i27 | (bArr[i26] & 255);
            char[] cArr2 = this.buf;
            int i29 = i23 + 1;
            cArr2[i23] = cArr[(i28 >>> 18) & 63];
            int i30 = i29 + 1;
            cArr2[i29] = cArr[(i28 >>> 12) & 63];
            int i31 = i30 + 1;
            cArr2[i30] = cArr[(i28 >>> 6) & 63];
            i23 = i31 + 1;
            cArr2[i31] = cArr[i28 & 63];
        }
        int i32 = length - i11;
        if (i32 > 0) {
            int i33 = (bArr[i11] & 255) << 10;
            if (i32 == 2) {
                i10 = (bArr[i12] & 255) << 2;
            }
            int i34 = i33 | i10;
            char[] cArr3 = this.buf;
            cArr3[i14 - 5] = cArr[i34 >> 12];
            cArr3[i14 - 4] = cArr[(i34 >>> 6) & 63];
            cArr3[i14 - 3] = i32 == 2 ? cArr[i34 & 63] : '=';
            cArr3[i14 - 2] = '=';
        }
        this.buf[i14 - 1] = c10;
    }

    public void writeFieldName(String str, boolean z10) {
        int i10 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i10) != 0) {
            if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if ((i10 & SerializerFeature.QuoteFieldNames.mask) != 0) {
            writeStringWithDoubleQuote(str, ':', z10);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    public void writeInt(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i11 = 0;
        while ((i10 < 0 ? -i10 : i10) > sizeTable[i11]) {
            i11++;
        }
        int i12 = i11 + 1;
        if (i10 < 0) {
            i12++;
        }
        int i13 = this.count + i12;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                char[] cArr = new char[i12];
                getChars(i10, i12, cArr);
                write(cArr, 0, i12);
                return;
            }
        }
        getChars(i10, i13, this.buf);
        this.count = i13;
    }

    public void writeLong(long j10) {
        int i10;
        if (j10 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int i11 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        long j11 = i11 < 0 ? -j10 : j10;
        int i12 = 1;
        long j12 = 10;
        while (true) {
            i10 = 19;
            if (i12 >= 19) {
                i12 = 0;
                break;
            } else if (j11 < j12) {
                break;
            } else {
                j12 *= 10;
                i12++;
            }
        }
        if (i12 != 0) {
            i10 = i12;
        }
        if (i11 < 0) {
            i10++;
        }
        int i13 = this.count + i10;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                char[] cArr = new char[i10];
                getChars(j10, i10, cArr);
                write(cArr, 0, i10);
                return;
            }
        }
        getChars(j10, i13, this.buf);
        this.count = i13;
    }

    public void writeNull() {
        write(LpaConstants.VALUE_NULL);
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0239, code lost:
        if (r8 == (-1)) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023b, code lost:
        r8 = r3;
        r15 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x028a, code lost:
        if (r8 == (-1)) goto L109;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(String str, char c10, boolean z10) {
        int i10;
        if (str == null) {
            writeNull();
            if (c10 != 0) {
                write(c10);
                return;
            }
            return;
        }
        int length = str.length();
        int i11 = this.count + length + 2;
        if (c10 != 0) {
            i11++;
        }
        char c11 = '\r';
        char c12 = ' ';
        char c13 = '/';
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                int i12 = 0;
                while (i12 < str.length()) {
                    char charAt = str.charAt(i12);
                    int i13 = this.features;
                    if ((SerializerFeature.BrowserCompatible.mask & i13) != 0) {
                        if (charAt == '\b' || charAt == '\f' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\"' || charAt == '/' || charAt == '\\') {
                            write(92);
                            write(replaceChars[charAt]);
                        } else if (charAt < c12) {
                            write(92);
                            write(117);
                            write(48);
                            write(48);
                            char[] cArr = ascii_chars;
                            int i14 = charAt * 2;
                            write(cArr[i14]);
                            write(cArr[i14 + 1]);
                        } else {
                            if (charAt >= 127) {
                                write(92);
                                write(117);
                                char[] cArr2 = DIGITS;
                                write(cArr2[(charAt >>> '\f') & 15]);
                                write(cArr2[(charAt >>> '\b') & 15]);
                                write(cArr2[(charAt >>> 4) & 15]);
                                write(cArr2[charAt & 15]);
                            }
                            write(charAt);
                        }
                        i12++;
                        c12 = ' ';
                    } else {
                        byte[] bArr = specicalFlags_doubleQuotes;
                        if ((charAt < bArr.length && bArr[charAt] != 0) || (charAt == '/' && (i13 & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                            write(92);
                            write(replaceChars[charAt]);
                            i12++;
                            c12 = ' ';
                        }
                        write(charAt);
                        i12++;
                        c12 = ' ';
                    }
                }
                write(34);
                if (c10 != 0) {
                    write(c10);
                    return;
                }
                return;
            }
            expandCapacity(i11);
        }
        int i15 = this.count;
        int i16 = i15 + 1;
        int i17 = i16 + length;
        char[] cArr3 = this.buf;
        cArr3[i15] = '\"';
        str.getChars(0, length, cArr3, i16);
        this.count = i11;
        int i18 = -1;
        if ((this.features & SerializerFeature.BrowserCompatible.mask) != 0) {
            for (int i19 = i16; i19 < i17; i19++) {
                char c14 = this.buf[i19];
                if (c14 == '\"' || c14 == '/' || c14 == '\\' || c14 == '\b' || c14 == '\f' || c14 == '\n' || c14 == '\r' || c14 == '\t') {
                    i11++;
                } else if (c14 < ' ' || c14 >= 127) {
                    i11 += 5;
                }
                i18 = i19;
            }
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            this.count = i11;
            while (i18 >= i16) {
                char[] cArr4 = this.buf;
                char c15 = cArr4[i18];
                if (c15 == '\b' || c15 == '\f' || c15 == '\n' || c15 == c11 || c15 == '\t') {
                    int i20 = i18 + 1;
                    System.arraycopy(cArr4, i20, cArr4, i18 + 2, (i17 - i18) - 1);
                    char[] cArr5 = this.buf;
                    cArr5[i18] = '\\';
                    cArr5[i20] = replaceChars[c15];
                } else if (c15 == '\"' || c15 == '/' || c15 == '\\') {
                    int i21 = i18 + 1;
                    System.arraycopy(cArr4, i21, cArr4, i18 + 2, (i17 - i18) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i18] = '\\';
                    cArr6[i21] = c15;
                } else {
                    if (c15 < ' ') {
                        int i22 = i18 + 1;
                        System.arraycopy(cArr4, i22, cArr4, i18 + 6, (i17 - i18) - 1);
                        char[] cArr7 = this.buf;
                        cArr7[i18] = '\\';
                        cArr7[i22] = 'u';
                        cArr7[i18 + 2] = '0';
                        cArr7[i18 + 3] = '0';
                        char[] cArr8 = ascii_chars;
                        int i23 = c15 * 2;
                        cArr7[i18 + 4] = cArr8[i23];
                        cArr7[i18 + 5] = cArr8[i23 + 1];
                    } else if (c15 >= 127) {
                        int i24 = i18 + 1;
                        System.arraycopy(cArr4, i24, cArr4, i18 + 6, (i17 - i18) - 1);
                        char[] cArr9 = this.buf;
                        cArr9[i18] = '\\';
                        cArr9[i24] = 'u';
                        char[] cArr10 = DIGITS;
                        cArr9[i18 + 2] = cArr10[(c15 >>> '\f') & 15];
                        cArr9[i18 + 3] = cArr10[(c15 >>> '\b') & 15];
                        cArr9[i18 + 4] = cArr10[(c15 >>> 4) & 15];
                        cArr9[i18 + 5] = cArr10[c15 & 15];
                    } else {
                        i18--;
                        c11 = '\r';
                    }
                    i17 += 5;
                    i18--;
                    c11 = '\r';
                }
                i17++;
                i18--;
                c11 = '\r';
            }
            if (c10 != 0) {
                char[] cArr11 = this.buf;
                int i25 = this.count;
                cArr11[i25 - 2] = '\"';
                cArr11[i25 - 1] = c10;
                return;
            }
            this.buf[this.count - 1] = '\"';
            return;
        }
        if (z10) {
            int i26 = 0;
            char c16 = 0;
            int i27 = -1;
            int i28 = -1;
            int i29 = i16;
            while (i29 < i17) {
                char c17 = this.buf[i29];
                if (c17 == 8232) {
                    i26++;
                    i11 += 4;
                } else if (c17 >= ']') {
                    if (c17 >= 127 && c17 < 160) {
                        if (i27 == -1) {
                            i27 = i29;
                        }
                        i26++;
                        i11 += 4;
                        i28 = i29;
                    }
                    i29++;
                    c13 = '/';
                } else if (c17 != ' ' && ((c17 == c13 && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) || ((c17 <= '#' || c17 == '\\') && (c17 <= 31 || c17 == '\\' || c17 == '\"')))) {
                    i26++;
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (c17 < bArr2.length && bArr2[c17] == 4) {
                        i11 += 4;
                    }
                } else {
                    i29++;
                    c13 = '/';
                }
                c16 = c17;
                i29++;
                c13 = '/';
            }
            if (i26 > 0) {
                int i30 = i11 + i26;
                if (i30 > this.buf.length) {
                    expandCapacity(i30);
                }
                this.count = i30;
                if (i26 == 1) {
                    if (c16 == 8232) {
                        int i31 = i28 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i31, cArr12, i28 + 6, (i17 - i28) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i28] = '\\';
                        cArr13[i31] = 'u';
                        int i32 = i31 + 1;
                        cArr13[i32] = '2';
                        int i33 = i32 + 1;
                        cArr13[i33] = '0';
                        int i34 = i33 + 1;
                        cArr13[i34] = '2';
                        cArr13[i34 + 1] = '8';
                    } else {
                        byte[] bArr3 = specicalFlags_doubleQuotes;
                        if (c16 >= bArr3.length || bArr3[c16] != 4) {
                            int i35 = i28 + 1;
                            char[] cArr14 = this.buf;
                            System.arraycopy(cArr14, i35, cArr14, i28 + 2, (i17 - i28) - 1);
                            char[] cArr15 = this.buf;
                            cArr15[i28] = '\\';
                            cArr15[i35] = replaceChars[c16];
                        } else {
                            int i36 = i28 + 1;
                            char[] cArr16 = this.buf;
                            System.arraycopy(cArr16, i36, cArr16, i28 + 6, (i17 - i28) - 1);
                            char[] cArr17 = this.buf;
                            cArr17[i28] = '\\';
                            int i37 = i36 + 1;
                            cArr17[i36] = 'u';
                            int i38 = i37 + 1;
                            char[] cArr18 = DIGITS;
                            cArr17[i37] = cArr18[(c16 >>> '\f') & 15];
                            int i39 = i38 + 1;
                            cArr17[i38] = cArr18[(c16 >>> '\b') & 15];
                            cArr17[i39] = cArr18[(c16 >>> 4) & 15];
                            cArr17[i39 + 1] = cArr18[c16 & 15];
                        }
                    }
                } else if (i26 > 1) {
                    for (int i40 = i27 - i16; i40 < str.length(); i40++) {
                        char charAt2 = str.charAt(i40);
                        byte[] bArr4 = specicalFlags_doubleQuotes;
                        if ((charAt2 >= bArr4.length || bArr4[charAt2] == 0) && (charAt2 != '/' || (this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0)) {
                            if (charAt2 == 8232) {
                                char[] cArr19 = this.buf;
                                int i41 = i27 + 1;
                                cArr19[i27] = '\\';
                                int i42 = i41 + 1;
                                cArr19[i41] = 'u';
                                int i43 = i42 + 1;
                                char[] cArr20 = DIGITS;
                                cArr19[i42] = cArr20[(charAt2 >>> '\f') & 15];
                                int i44 = i43 + 1;
                                cArr19[i43] = cArr20[(charAt2 >>> '\b') & 15];
                                int i45 = i44 + 1;
                                cArr19[i44] = cArr20[(charAt2 >>> 4) & 15];
                                i27 = i45 + 1;
                                cArr19[i45] = cArr20[charAt2 & 15];
                            } else {
                                i27++;
                                this.buf[i27] = charAt2;
                            }
                        }
                        char[] cArr21 = this.buf;
                        int i46 = i27 + 1;
                        cArr21[i27] = '\\';
                        if (bArr4[charAt2] == 4) {
                            int i47 = i46 + 1;
                            cArr21[i46] = 'u';
                            int i48 = i47 + 1;
                            char[] cArr22 = DIGITS;
                            cArr21[i47] = cArr22[(charAt2 >>> '\f') & 15];
                            int i49 = i48 + 1;
                            cArr21[i48] = cArr22[(charAt2 >>> '\b') & 15];
                            int i50 = i49 + 1;
                            cArr21[i49] = cArr22[(charAt2 >>> 4) & 15];
                            i10 = i50 + 1;
                            cArr21[i50] = cArr22[charAt2 & 15];
                        } else {
                            i10 = i46 + 1;
                            cArr21[i46] = replaceChars[charAt2];
                        }
                        i27 = i10;
                    }
                }
            }
        }
        if (c10 != 0) {
            char[] cArr23 = this.buf;
            int i51 = this.count;
            cArr23[i51 - 2] = '\"';
            cArr23[i51 - 1] = c10;
            return;
        }
        this.buf[this.count - 1] = '\"';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i10 = 0;
        if (str == null) {
            int i11 = this.count + 4;
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            LpaConstants.VALUE_NULL.getChars(0, 4, this.buf, this.count);
            this.count = i11;
            return;
        }
        int length = str.length();
        int i12 = this.count + length + 2;
        if (i12 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write(replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            expandCapacity(i12);
        }
        int i13 = this.count;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.buf;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.count = i12;
        int i16 = -1;
        char c10 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.buf[i17];
            if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.buf.length) {
            expandCapacity(i18);
        }
        this.count = i18;
        if (i10 == 1) {
            char[] cArr2 = this.buf;
            int i19 = i16 + 1;
            System.arraycopy(cArr2, i19, cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.buf;
            cArr3[i16] = '\\';
            cArr3[i19] = replaceChars[c10];
        } else if (i10 > 1) {
            char[] cArr4 = this.buf;
            int i20 = i16 + 1;
            System.arraycopy(cArr4, i20, cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.buf;
            cArr5[i16] = '\\';
            cArr5[i20] = replaceChars[c10];
            int i21 = i15 + 1;
            for (int i22 = i20 - 2; i22 >= i14; i22--) {
                char[] cArr6 = this.buf;
                char c12 = cArr6[i22];
                if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i23 = i22 + 1;
                    System.arraycopy(cArr6, i23, cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i22] = '\\';
                    cArr7[i23] = replaceChars[c12];
                    i21++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer == null) {
            writer.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? LpaConstants.VALUE_NULL : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i11 != 0) {
            int i13 = this.count + i11;
            if (i13 > this.buf.length) {
                if (this.writer == null) {
                    expandCapacity(i13);
                } else {
                    do {
                        char[] cArr2 = this.buf;
                        int length = cArr2.length;
                        int i14 = this.count;
                        int i15 = length - i14;
                        System.arraycopy(cArr, i10, cArr2, i14, i15);
                        this.count = this.buf.length;
                        flush();
                        i11 -= i15;
                        i10 += i15;
                    } while (i11 > this.buf.length);
                    i13 = i11;
                }
            }
            System.arraycopy(cArr, i10, this.buf, this.count, i11);
            this.count = i13;
        }
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = LpaConstants.VALUE_NULL;
        }
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter(Writer writer, int i10, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.mask;
        }
        this.features = i10;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c10) {
        write(c10);
        return this;
    }

    public SerializeWriter(int i10) {
        this(null, i10);
    }

    public SerializeWriter(Writer writer, int i10) {
        this.writer = writer;
        if (i10 > 0) {
            this.buf = new char[i10];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i10);
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) {
        int i12;
        int i13 = this.count + i11;
        if (i13 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i13);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i14 = this.count;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.count = this.buf.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.buf.length) {
                        break;
                    }
                    i10 = i12;
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.buf, this.count);
        this.count = i13;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z10) {
        write(z10 ? "true" : "false");
    }
}
