package com.google.gson.stream;

import com.google.gson.internal.f;
import com.mobvoi.wear.lpa.LpaConstants;
import i8.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    private static final char[] f12657p = ")]}'\n".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private final Reader f12658a;

    /* renamed from: i  reason: collision with root package name */
    private long f12666i;

    /* renamed from: j  reason: collision with root package name */
    private int f12667j;

    /* renamed from: k  reason: collision with root package name */
    private String f12668k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f12669l;

    /* renamed from: m  reason: collision with root package name */
    private int f12670m;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12659b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f12660c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f12661d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f12662e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f12663f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f12664g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f12665h = 0;

    /* renamed from: n  reason: collision with root package name */
    private String[] f12671n = new String[32];

    /* renamed from: o  reason: collision with root package name */
    private int[] f12672o = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.stream.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0166a extends f {
        C0166a() {
        }

        @Override // com.google.gson.internal.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof e) {
                ((e) aVar).M0();
                return;
            }
            int i10 = aVar.f12665h;
            if (i10 == 0) {
                i10 = aVar.n();
            }
            if (i10 == 13) {
                aVar.f12665h = 9;
            } else if (i10 == 12) {
                aVar.f12665h = 8;
            } else if (i10 == 14) {
                aVar.f12665h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.k0() + aVar.E());
            }
        }
    }

    static {
        f.f12641a = new C0166a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f12669l = iArr;
        this.f12670m = 0;
        this.f12670m = 0 + 1;
        iArr[0] = 6;
        Objects.requireNonNull(reader, "in == null");
        this.f12658a = reader;
    }

    private void A0() throws IOException {
        char c10;
        do {
            if (this.f12661d < this.f12662e || u(1)) {
                char[] cArr = this.f12660c;
                int i10 = this.f12661d;
                int i11 = i10 + 1;
                this.f12661d = i11;
                c10 = cArr[i10];
                if (c10 == '\n') {
                    this.f12663f++;
                    this.f12664g = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G0() throws IOException {
        do {
            int i10 = 0;
            while (true) {
                int i11 = this.f12661d;
                if (i11 + i10 < this.f12662e) {
                    char c10 = this.f12660c[i11 + i10];
                    if (!(c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ')) {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (!(c10 == '/' || c10 == '=')) {
                                    if (!(c10 == '{' || c10 == '}' || c10 == ':')) {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i10++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f12661d = i11 + i10;
                }
            }
            this.f12661d += i10;
            return;
        } while (u(1));
    }

    private IOException I0(String str) throws IOException {
        throw new MalformedJsonException(str + E());
    }

    private int W(boolean z10) throws IOException {
        char[] cArr = this.f12660c;
        int i10 = this.f12661d;
        int i11 = this.f12662e;
        while (true) {
            if (i10 == i11) {
                this.f12661d = i10;
                if (u(1)) {
                    i10 = this.f12661d;
                    i11 = this.f12662e;
                } else if (!z10) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + E());
                }
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f12663f++;
                this.f12664g = i12;
            } else if (!(c10 == ' ' || c10 == '\r' || c10 == '\t')) {
                if (c10 == '/') {
                    this.f12661d = i12;
                    if (i12 == i11) {
                        this.f12661d = i12 - 1;
                        boolean u10 = u(2);
                        this.f12661d++;
                        if (!u10) {
                            return c10;
                        }
                    }
                    h();
                    int i13 = this.f12661d;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f12661d = i13 + 1;
                        if (z0("*/")) {
                            i10 = this.f12661d + 2;
                            i11 = this.f12662e;
                        } else {
                            throw I0("Unterminated comment");
                        }
                    } else if (c11 != '/') {
                        return c10;
                    } else {
                        this.f12661d = i13 + 1;
                        A0();
                        i10 = this.f12661d;
                        i11 = this.f12662e;
                    }
                } else if (c10 == '#') {
                    this.f12661d = i12;
                    h();
                    A0();
                    i10 = this.f12661d;
                    i11 = this.f12662e;
                } else {
                    this.f12661d = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    private void h() throws IOException {
        if (!this.f12659b) {
            throw I0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f12661d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String h0(char c10) throws IOException {
        char[] cArr = this.f12660c;
        StringBuilder sb2 = null;
        do {
            int i10 = this.f12661d;
            int i11 = this.f12662e;
            while (true) {
                int i12 = i11;
                int i13 = i10;
                while (i10 < i12) {
                    int i14 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 == c10) {
                        this.f12661d = i14;
                        int i15 = (i14 - i13) - 1;
                        if (sb2 == null) {
                            return new String(cArr, i13, i15);
                        }
                        sb2.append(cArr, i13, i15);
                        return sb2.toString();
                    } else if (c11 == '\\') {
                        this.f12661d = i14;
                        int i16 = (i14 - i13) - 1;
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max((i16 + 1) * 2, 16));
                        }
                        sb2.append(cArr, i13, i16);
                        sb2.append(t0());
                        i10 = this.f12661d;
                        i11 = this.f12662e;
                    } else {
                        if (c11 == '\n') {
                            this.f12663f++;
                            this.f12664g = i14;
                        }
                        i10 = i14;
                    }
                }
                break;
            }
        } while (u(1));
        throw I0("Unterminated string");
    }

    private void i() throws IOException {
        W(true);
        int i10 = this.f12661d - 1;
        this.f12661d = i10;
        char[] cArr = f12657p;
        if (i10 + cArr.length <= this.f12662e || u(cArr.length)) {
            int i11 = 0;
            while (true) {
                char[] cArr2 = f12657p;
                if (i11 >= cArr2.length) {
                    this.f12661d += cArr2.length;
                    return;
                } else if (this.f12660c[this.f12661d + i11] == cArr2[i11]) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        h();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String j0() throws IOException {
        String str;
        int i10 = 0;
        StringBuilder sb2 = null;
        do {
            int i11 = 0;
            while (true) {
                int i12 = this.f12661d;
                if (i12 + i11 < this.f12662e) {
                    char c10 = this.f12660c[i12 + i11];
                    if (!(c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ')) {
                        if (c10 != '#') {
                            if (c10 != ',') {
                                if (!(c10 == '/' || c10 == '=')) {
                                    if (!(c10 == '{' || c10 == '}' || c10 == ':')) {
                                        if (c10 != ';') {
                                            switch (c10) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i11++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i11 >= this.f12660c.length) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i11, 16));
                    }
                    sb2.append(this.f12660c, this.f12661d, i11);
                    this.f12661d += i11;
                } else if (u(i11 + 1)) {
                }
            }
            i10 = i11;
            if (sb2 != null) {
                str = new String(this.f12660c, this.f12661d, i10);
            } else {
                sb2.append(this.f12660c, this.f12661d, i10);
                str = sb2.toString();
            }
            this.f12661d += i10;
            return str;
        } while (u(1));
        if (sb2 != null) {
        }
        this.f12661d += i10;
        return str;
    }

    private int m0() throws IOException {
        String str;
        String str2;
        int i10;
        char c10 = this.f12660c[this.f12661d];
        if (c10 == 't' || c10 == 'T') {
            i10 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c10 == 'f' || c10 == 'F') {
            i10 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c10 != 'n' && c10 != 'N') {
            return 0;
        } else {
            i10 = 7;
            str2 = LpaConstants.VALUE_NULL;
            str = "NULL";
        }
        int length = str2.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f12661d + i11 >= this.f12662e && !u(i11 + 1)) {
                return 0;
            }
            char c11 = this.f12660c[this.f12661d + i11];
            if (!(c11 == str2.charAt(i11) || c11 == str.charAt(i11))) {
                return 0;
            }
        }
        if ((this.f12661d + length < this.f12662e || u(length + 1)) && x(this.f12660c[this.f12661d + length])) {
            return 0;
        }
        this.f12661d += length;
        this.f12665h = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
        if (x(r14) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
        if (r9 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009b, code lost:
        if (r11 != Long.MIN_VALUE) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009d, code lost:
        if (r13 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        if (r11 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
        if (r13 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a7, code lost:
        if (r13 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ab, code lost:
        r18.f12666i = r11;
        r18.f12661d += r8;
        r18.f12665h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:
        if (r9 == 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ba, code lost:
        if (r9 == 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bd, code lost:
        if (r9 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
        r18.f12667j = r8;
        r18.f12665h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c9, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int o0() throws IOException {
        char[] cArr = this.f12660c;
        int i10 = this.f12661d;
        int i11 = this.f12662e;
        int i12 = 0;
        boolean z10 = true;
        int i13 = 0;
        char c10 = 0;
        boolean z11 = false;
        long j10 = 0;
        while (true) {
            if (i10 + i13 == i11) {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!u(i13 + 1)) {
                    break;
                }
                i10 = this.f12661d;
                i11 = this.f12662e;
            }
            char c11 = cArr[i10 + i13];
            char c12 = 3;
            if (c11 != '+') {
                if (c11 == 'E' || c11 == 'e') {
                    i12 = 0;
                    if (c10 != 2 && c10 != 4) {
                        return 0;
                    }
                    c10 = 5;
                } else if (c11 == '-') {
                    c12 = 6;
                    i12 = 0;
                    if (c10 == 0) {
                        c10 = 1;
                        z11 = true;
                    } else if (c10 != 5) {
                        return 0;
                    }
                } else if (c11 == '.') {
                    i12 = 0;
                    if (c10 != 2) {
                        return 0;
                    }
                } else if (c11 < '0' || c11 > '9') {
                    break;
                } else {
                    if (c10 == 1 || c10 == 0) {
                        j10 = -(c11 - '0');
                        c10 = 2;
                    } else if (c10 == 2) {
                        if (j10 == 0) {
                            return 0;
                        }
                        long j11 = (10 * j10) - (c11 - '0');
                        int i14 = (j10 > (-922337203685477580L) ? 1 : (j10 == (-922337203685477580L) ? 0 : -1));
                        z10 &= i14 > 0 || (i14 == 0 && j11 < j10);
                        j10 = j11;
                    } else if (c10 == 3) {
                        i12 = 0;
                        c10 = 4;
                    } else if (c10 == 5 || c10 == 6) {
                        i12 = 0;
                        c10 = 7;
                    }
                    i12 = 0;
                }
                i13++;
            } else {
                c12 = 6;
                i12 = 0;
                if (c10 != 5) {
                    return 0;
                }
            }
            c10 = c12;
            i13++;
        }
    }

    private void r0(int i10) {
        int i11 = this.f12670m;
        int[] iArr = this.f12669l;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[i11 * 2];
            int[] iArr3 = new int[i11 * 2];
            String[] strArr = new String[i11 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.f12672o, 0, iArr3, 0, this.f12670m);
            System.arraycopy(this.f12671n, 0, strArr, 0, this.f12670m);
            this.f12669l = iArr2;
            this.f12672o = iArr3;
            this.f12671n = strArr;
        }
        int[] iArr4 = this.f12669l;
        int i12 = this.f12670m;
        this.f12670m = i12 + 1;
        iArr4[i12] = i10;
    }

    private char t0() throws IOException {
        int i10;
        int i11;
        if (this.f12661d != this.f12662e || u(1)) {
            char[] cArr = this.f12660c;
            int i12 = this.f12661d;
            int i13 = i12 + 1;
            this.f12661d = i13;
            char c10 = cArr[i12];
            if (c10 == '\n') {
                this.f12663f++;
                this.f12664g = i13;
            } else if (!(c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\')) {
                if (c10 == 'b') {
                    return '\b';
                }
                if (c10 == 'f') {
                    return '\f';
                }
                if (c10 == 'n') {
                    return '\n';
                }
                if (c10 == 'r') {
                    return '\r';
                }
                if (c10 == 't') {
                    return '\t';
                }
                if (c10 != 'u') {
                    throw I0("Invalid escape sequence");
                } else if (i13 + 4 <= this.f12662e || u(4)) {
                    char c11 = 0;
                    int i14 = this.f12661d;
                    int i15 = i14 + 4;
                    while (i14 < i15) {
                        char c12 = this.f12660c[i14];
                        char c13 = (char) (c11 << 4);
                        if (c12 < '0' || c12 > '9') {
                            if (c12 >= 'a' && c12 <= 'f') {
                                i10 = c12 - 'a';
                            } else if (c12 < 'A' || c12 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f12660c, this.f12661d, 4));
                            } else {
                                i10 = c12 - 'A';
                            }
                            i11 = i10 + 10;
                        } else {
                            i11 = c12 - '0';
                        }
                        c11 = (char) (c13 + i11);
                        i14++;
                    }
                    this.f12661d += 4;
                    return c11;
                } else {
                    throw I0("Unterminated escape sequence");
                }
            }
            return c10;
        }
        throw I0("Unterminated escape sequence");
    }

    private boolean u(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f12660c;
        int i13 = this.f12664g;
        int i14 = this.f12661d;
        this.f12664g = i13 - i14;
        int i15 = this.f12662e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f12662e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f12662e = 0;
        }
        this.f12661d = 0;
        do {
            Reader reader = this.f12658a;
            int i17 = this.f12662e;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.f12662e + read;
            this.f12662e = i11;
            if (this.f12663f == 0 && (i12 = this.f12664g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f12661d++;
                this.f12664g = i12 + 1;
                i10++;
                continue;
            }
        } while (i11 < i10);
        return true;
    }

    private void w0(char c10) throws IOException {
        char[] cArr = this.f12660c;
        do {
            int i10 = this.f12661d;
            int i11 = this.f12662e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f12661d = i12;
                    return;
                } else if (c11 == '\\') {
                    this.f12661d = i12;
                    t0();
                    i10 = this.f12661d;
                    i11 = this.f12662e;
                } else {
                    if (c11 == '\n') {
                        this.f12663f++;
                        this.f12664g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f12661d = i10;
        } while (u(1));
        throw I0("Unterminated string");
    }

    private boolean x(char c10) throws IOException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\f' || c10 == '\r' || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (!(c10 == '/' || c10 == '=')) {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        h();
        return false;
    }

    private boolean z0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f12661d + length > this.f12662e && !u(length)) {
                return false;
            }
            char[] cArr = this.f12660c;
            int i10 = this.f12661d;
            if (cArr[i10] == '\n') {
                this.f12663f++;
                this.f12664g = i10 + 1;
            } else {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f12660c[this.f12661d + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f12661d++;
        }
    }

    String E() {
        return " at line " + (this.f12663f + 1) + " column " + ((this.f12661d - this.f12664g) + 1) + " path " + a();
    }

    public void H0() throws IOException {
        int i10 = 0;
        do {
            int i11 = this.f12665h;
            if (i11 == 0) {
                i11 = n();
            }
            if (i11 == 3) {
                r0(1);
            } else if (i11 == 1) {
                r0(3);
            } else {
                if (i11 == 4) {
                    this.f12670m--;
                } else if (i11 == 2) {
                    this.f12670m--;
                } else {
                    if (i11 == 14 || i11 == 10) {
                        G0();
                    } else if (i11 == 8 || i11 == 12) {
                        w0('\'');
                    } else if (i11 == 9 || i11 == 13) {
                        w0('\"');
                    } else if (i11 == 16) {
                        this.f12661d += this.f12667j;
                    }
                    this.f12665h = 0;
                }
                i10--;
                this.f12665h = 0;
            }
            i10++;
            this.f12665h = 0;
        } while (i10 != 0);
        int[] iArr = this.f12672o;
        int i12 = this.f12670m;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.f12671n[i12 - 1] = LpaConstants.VALUE_NULL;
    }

    public boolean I() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 5) {
            this.f12665h = 0;
            int[] iArr = this.f12672o;
            int i11 = this.f12670m - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f12665h = 0;
            int[] iArr2 = this.f12672o;
            int i12 = this.f12670m - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + k0() + E());
        }
    }

    public double O() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 15) {
            this.f12665h = 0;
            int[] iArr = this.f12672o;
            int i11 = this.f12670m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f12666i;
        }
        if (i10 == 16) {
            this.f12668k = new String(this.f12660c, this.f12661d, this.f12667j);
            this.f12661d += this.f12667j;
        } else if (i10 == 8 || i10 == 9) {
            this.f12668k = h0(i10 == 8 ? '\'' : '\"');
        } else if (i10 == 10) {
            this.f12668k = j0();
        } else if (i10 != 11) {
            throw new IllegalStateException("Expected a double but was " + k0() + E());
        }
        this.f12665h = 11;
        double parseDouble = Double.parseDouble(this.f12668k);
        if (this.f12659b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f12668k = null;
            this.f12665h = 0;
            int[] iArr2 = this.f12672o;
            int i12 = this.f12670m - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + E());
    }

    public int Q() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 15) {
            long j10 = this.f12666i;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f12665h = 0;
                int[] iArr = this.f12672o;
                int i12 = this.f12670m - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.f12666i + E());
        }
        if (i10 == 16) {
            this.f12668k = new String(this.f12660c, this.f12661d, this.f12667j);
            this.f12661d += this.f12667j;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f12668k = j0();
            } else {
                this.f12668k = h0(i10 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f12668k);
                this.f12665h = 0;
                int[] iArr2 = this.f12672o;
                int i13 = this.f12670m - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + k0() + E());
        }
        this.f12665h = 11;
        double parseDouble = Double.parseDouble(this.f12668k);
        int i14 = (int) parseDouble;
        if (i14 == parseDouble) {
            this.f12668k = null;
            this.f12665h = 0;
            int[] iArr3 = this.f12672o;
            int i15 = this.f12670m - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.f12668k + E());
    }

    public long T() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 15) {
            this.f12665h = 0;
            int[] iArr = this.f12672o;
            int i11 = this.f12670m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f12666i;
        }
        if (i10 == 16) {
            this.f12668k = new String(this.f12660c, this.f12661d, this.f12667j);
            this.f12661d += this.f12667j;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f12668k = j0();
            } else {
                this.f12668k = h0(i10 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f12668k);
                this.f12665h = 0;
                int[] iArr2 = this.f12672o;
                int i12 = this.f12670m - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + k0() + E());
        }
        this.f12665h = 11;
        double parseDouble = Double.parseDouble(this.f12668k);
        long j10 = (long) parseDouble;
        if (j10 == parseDouble) {
            this.f12668k = null;
            this.f12665h = 0;
            int[] iArr3 = this.f12672o;
            int i13 = this.f12670m - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.f12668k + E());
    }

    public String V() throws IOException {
        String str;
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 14) {
            str = j0();
        } else if (i10 == 12) {
            str = h0('\'');
        } else if (i10 == 13) {
            str = h0('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + k0() + E());
        }
        this.f12665h = 0;
        this.f12671n[this.f12670m - 1] = str;
        return str;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = this.f12670m;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f12669l[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(this.f12672o[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String[] strArr = this.f12671n;
                if (strArr[i11] != null) {
                    sb2.append(strArr[i11]);
                }
            }
        }
        return sb2.toString();
    }

    public void c() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 3) {
            r0(1);
            this.f12672o[this.f12670m - 1] = 0;
            this.f12665h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + k0() + E());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12665h = 0;
        this.f12669l[0] = 8;
        this.f12670m = 1;
        this.f12658a.close();
    }

    public void d() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 1) {
            r0(3);
            this.f12665h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + k0() + E());
    }

    public void g0() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 7) {
            this.f12665h = 0;
            int[] iArr = this.f12672o;
            int i11 = this.f12670m - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + k0() + E());
    }

    public String i0() throws IOException {
        String str;
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 10) {
            str = j0();
        } else if (i10 == 8) {
            str = h0('\'');
        } else if (i10 == 9) {
            str = h0('\"');
        } else if (i10 == 11) {
            str = this.f12668k;
            this.f12668k = null;
        } else if (i10 == 15) {
            str = Long.toString(this.f12666i);
        } else if (i10 == 16) {
            str = new String(this.f12660c, this.f12661d, this.f12667j);
            this.f12661d += this.f12667j;
        } else {
            throw new IllegalStateException("Expected a string but was " + k0() + E());
        }
        this.f12665h = 0;
        int[] iArr = this.f12672o;
        int i11 = this.f12670m - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public JsonToken k0() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        switch (i10) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    int n() throws IOException {
        int W;
        int[] iArr = this.f12669l;
        int i10 = this.f12670m;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int W2 = W(true);
            if (W2 != 44) {
                if (W2 == 59) {
                    h();
                } else if (W2 == 93) {
                    this.f12665h = 4;
                    return 4;
                } else {
                    throw I0("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5 && (W = W(true)) != 44) {
                if (W == 59) {
                    h();
                } else if (W == 125) {
                    this.f12665h = 2;
                    return 2;
                } else {
                    throw I0("Unterminated object");
                }
            }
            int W3 = W(true);
            if (W3 == 34) {
                this.f12665h = 13;
                return 13;
            } else if (W3 == 39) {
                h();
                this.f12665h = 12;
                return 12;
            } else if (W3 != 125) {
                h();
                this.f12661d--;
                if (x((char) W3)) {
                    this.f12665h = 14;
                    return 14;
                }
                throw I0("Expected name");
            } else if (i11 != 5) {
                this.f12665h = 2;
                return 2;
            } else {
                throw I0("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int W4 = W(true);
            if (W4 != 58) {
                if (W4 == 61) {
                    h();
                    if (this.f12661d < this.f12662e || u(1)) {
                        char[] cArr = this.f12660c;
                        int i12 = this.f12661d;
                        if (cArr[i12] == '>') {
                            this.f12661d = i12 + 1;
                        }
                    }
                } else {
                    throw I0("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            if (this.f12659b) {
                i();
            }
            this.f12669l[this.f12670m - 1] = 7;
        } else if (i11 == 7) {
            if (W(false) == -1) {
                this.f12665h = 17;
                return 17;
            }
            h();
            this.f12661d--;
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int W5 = W(true);
        if (W5 == 34) {
            this.f12665h = 9;
            return 9;
        } else if (W5 != 39) {
            if (!(W5 == 44 || W5 == 59)) {
                if (W5 == 91) {
                    this.f12665h = 3;
                    return 3;
                } else if (W5 != 93) {
                    if (W5 != 123) {
                        this.f12661d--;
                        int m02 = m0();
                        if (m02 != 0) {
                            return m02;
                        }
                        int o02 = o0();
                        if (o02 != 0) {
                            return o02;
                        }
                        if (x(this.f12660c[this.f12661d])) {
                            h();
                            this.f12665h = 10;
                            return 10;
                        }
                        throw I0("Expected value");
                    }
                    this.f12665h = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f12665h = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                h();
                this.f12661d--;
                this.f12665h = 7;
                return 7;
            }
            throw I0("Unexpected value");
        } else {
            h();
            this.f12665h = 8;
            return 8;
        }
    }

    public void o() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 4) {
            int i11 = this.f12670m - 1;
            this.f12670m = i11;
            int[] iArr = this.f12672o;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f12665h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + k0() + E());
    }

    public void q() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        if (i10 == 2) {
            int i11 = this.f12670m - 1;
            this.f12670m = i11;
            this.f12671n[i11] = null;
            int[] iArr = this.f12672o;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f12665h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + k0() + E());
    }

    public String toString() {
        return getClass().getSimpleName() + E();
    }

    public final void u0(boolean z10) {
        this.f12659b = z10;
    }

    public boolean v() throws IOException {
        int i10 = this.f12665h;
        if (i10 == 0) {
            i10 = n();
        }
        return (i10 == 2 || i10 == 4) ? false : true;
    }

    public final boolean w() {
        return this.f12659b;
    }
}
