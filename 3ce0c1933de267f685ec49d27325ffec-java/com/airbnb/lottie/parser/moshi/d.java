package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;
import okio.c;
import okio.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
public final class d extends JsonReader {

    /* renamed from: n  reason: collision with root package name */
    private static final ByteString f6698n = ByteString.encodeUtf8("'\\");

    /* renamed from: o  reason: collision with root package name */
    private static final ByteString f6699o = ByteString.encodeUtf8("\"\\");

    /* renamed from: p  reason: collision with root package name */
    private static final ByteString f6700p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q  reason: collision with root package name */
    private static final ByteString f6701q = ByteString.encodeUtf8("\n\r");

    /* renamed from: r  reason: collision with root package name */
    private static final ByteString f6702r = ByteString.encodeUtf8("*/");

    /* renamed from: h  reason: collision with root package name */
    private final e f6703h;

    /* renamed from: i  reason: collision with root package name */
    private final c f6704i;

    /* renamed from: j  reason: collision with root package name */
    private int f6705j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f6706k;

    /* renamed from: l  reason: collision with root package name */
    private int f6707l;

    /* renamed from: m  reason: collision with root package name */
    private String f6708m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        this.f6703h = eVar;
        this.f6704i = eVar.b();
        O(6);
    }

    private boolean A0() throws IOException {
        e eVar = this.f6703h;
        ByteString byteString = f6702r;
        long A = eVar.A(byteString);
        boolean z10 = A != -1;
        c cVar = this.f6704i;
        cVar.f(z10 ? A + byteString.size() : cVar.i0());
        return z10;
    }

    private void G0() throws IOException {
        long F = this.f6703h.F(f6701q);
        c cVar = this.f6704i;
        cVar.f(F != -1 ? F + 1 : cVar.i0());
    }

    private void H0() throws IOException {
        long F = this.f6703h.F(f6700p);
        c cVar = this.f6704i;
        if (F == -1) {
            F = cVar.i0();
        }
        cVar.f(F);
    }

    private void h0() throws IOException {
        if (!this.f6694e) {
            throw g0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int i0() throws IOException {
        int[] iArr = this.f6691b;
        int i10 = this.f6690a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int m02 = m0(true);
            this.f6704i.readByte();
            if (m02 != 44) {
                if (m02 == 59) {
                    h0();
                } else if (m02 == 93) {
                    this.f6705j = 4;
                    return 4;
                } else {
                    throw g0("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int m03 = m0(true);
                this.f6704i.readByte();
                if (m03 != 44) {
                    if (m03 == 59) {
                        h0();
                    } else if (m03 == 125) {
                        this.f6705j = 2;
                        return 2;
                    } else {
                        throw g0("Unterminated object");
                    }
                }
            }
            int m04 = m0(true);
            if (m04 == 34) {
                this.f6704i.readByte();
                this.f6705j = 13;
                return 13;
            } else if (m04 == 39) {
                this.f6704i.readByte();
                h0();
                this.f6705j = 12;
                return 12;
            } else if (m04 != 125) {
                h0();
                if (k0((char) m04)) {
                    this.f6705j = 14;
                    return 14;
                }
                throw g0("Expected name");
            } else if (i11 != 5) {
                this.f6704i.readByte();
                this.f6705j = 2;
                return 2;
            } else {
                throw g0("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int m05 = m0(true);
            this.f6704i.readByte();
            if (m05 != 58) {
                if (m05 == 61) {
                    h0();
                    if (this.f6703h.request(1L) && this.f6704i.u(0L) == 62) {
                        this.f6704i.readByte();
                    }
                } else {
                    throw g0("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            iArr[i10 - 1] = 7;
        } else if (i11 == 7) {
            if (m0(false) == -1) {
                this.f6705j = 18;
                return 18;
            }
            h0();
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int m06 = m0(true);
        if (m06 == 34) {
            this.f6704i.readByte();
            this.f6705j = 9;
            return 9;
        } else if (m06 != 39) {
            if (!(m06 == 44 || m06 == 59)) {
                if (m06 == 91) {
                    this.f6704i.readByte();
                    this.f6705j = 3;
                    return 3;
                } else if (m06 != 93) {
                    if (m06 != 123) {
                        int t02 = t0();
                        if (t02 != 0) {
                            return t02;
                        }
                        int u02 = u0();
                        if (u02 != 0) {
                            return u02;
                        }
                        if (k0(this.f6704i.u(0L))) {
                            h0();
                            this.f6705j = 10;
                            return 10;
                        }
                        throw g0("Expected value");
                    }
                    this.f6704i.readByte();
                    this.f6705j = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f6704i.readByte();
                    this.f6705j = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                h0();
                this.f6705j = 7;
                return 7;
            }
            throw g0("Unexpected value");
        } else {
            h0();
            this.f6704i.readByte();
            this.f6705j = 8;
            return 8;
        }
    }

    private int j0(String str, JsonReader.a aVar) {
        int length = aVar.f6696a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f6696a[i10])) {
                this.f6705j = 0;
                this.f6692c[this.f6690a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    private boolean k0(int i10) throws IOException {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (!(i10 == 47 || i10 == 61)) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        h0();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r6.f6704i.f(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r1 != 47) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r6.f6703h.request(2) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        h0();
        r3 = r6.f6704i.u(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r3 == 42) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r3 == 47) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        r6.f6704i.readByte();
        r6.f6704i.readByte();
        G0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r6.f6704i.readByte();
        r6.f6704i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (A0() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        throw g0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r1 != 35) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        h0();
        G0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m0(boolean z10) throws IOException {
        while (true) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (this.f6703h.request(i11)) {
                    byte u10 = this.f6704i.u(i10);
                    if (u10 != 10 && u10 != 32 && u10 != 13 && u10 != 9) {
                        break;
                    }
                    i10 = i11;
                } else if (!z10) {
                    return -1;
                } else {
                    throw new EOFException("End of input");
                }
            }
        }
    }

    private String o0(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long F = this.f6703h.F(byteString);
            if (F == -1) {
                throw g0("Unterminated string");
            } else if (this.f6704i.u(F) == 92) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f6704i.W(F));
                this.f6704i.readByte();
                sb2.append(w0());
            } else if (sb2 == null) {
                String W = this.f6704i.W(F);
                this.f6704i.readByte();
                return W;
            } else {
                sb2.append(this.f6704i.W(F));
                this.f6704i.readByte();
                return sb2.toString();
            }
        }
    }

    private String r0() throws IOException {
        long F = this.f6703h.F(f6700p);
        return F != -1 ? this.f6704i.W(F) : this.f6704i.V();
    }

    private int t0() throws IOException {
        String str;
        String str2;
        int i10;
        byte u10 = this.f6704i.u(0L);
        if (u10 == 116 || u10 == 84) {
            i10 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (u10 == 102 || u10 == 70) {
            i10 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (u10 != 110 && u10 != 78) {
            return 0;
        } else {
            i10 = 7;
            str2 = LpaConstants.VALUE_NULL;
            str = "NULL";
        }
        int length = str2.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f6703h.request(i12)) {
                return 0;
            }
            byte u11 = this.f6704i.u(i11);
            if (u11 != str2.charAt(i11) && u11 != str.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f6703h.request(length + 1) && k0(this.f6704i.u(length))) {
            return 0;
        }
        this.f6704i.f(length);
        this.f6705j = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
        if (k0(r11) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
        if (r6 != 2) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0086, code lost:
        if (r7 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
        if (r8 != Long.MIN_VALUE) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
        if (r10 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
        if (r8 != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0094, code lost:
        if (r10 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
        if (r10 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009a, code lost:
        r16.f6706k = r8;
        r16.f6704i.f(r5);
        r16.f6705j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a6, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a7, code lost:
        if (r6 == 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00aa, code lost:
        if (r6 == 4) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ad, code lost:
        if (r6 != 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b2, code lost:
        r16.f6707l = r5;
        r16.f6705j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b9, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int u0() throws IOException {
        char c10;
        char c11 = 1;
        int i10 = 0;
        long j10 = 0;
        boolean z10 = true;
        int i11 = 0;
        char c12 = 0;
        boolean z11 = false;
        while (true) {
            int i12 = i11 + 1;
            if (!this.f6703h.request(i12)) {
                break;
            }
            byte u10 = this.f6704i.u(i11);
            if (u10 != 43) {
                if (u10 == 69 || u10 == 101) {
                    if (c12 != 2 && c12 != 4) {
                        return i10;
                    }
                    c12 = 5;
                } else if (u10 == 45) {
                    c10 = 6;
                    if (c12 == 0) {
                        c12 = 1;
                        z11 = true;
                    } else if (c12 != 5) {
                        return i10;
                    }
                } else if (u10 == 46) {
                    c10 = 3;
                    if (c12 != 2) {
                        return i10;
                    }
                } else if (u10 < 48 || u10 > 57) {
                    break;
                } else {
                    if (c12 == c11 || c12 == 0) {
                        j10 = -(u10 - 48);
                        c12 = 2;
                    } else if (c12 == 2) {
                        if (j10 == 0) {
                            return i10;
                        }
                        long j11 = (10 * j10) - (u10 - 48);
                        int i13 = (j10 > (-922337203685477580L) ? 1 : (j10 == (-922337203685477580L) ? 0 : -1));
                        z10 &= i13 > 0 || (i13 == 0 && j11 < j10);
                        j10 = j11;
                    } else if (c12 == 3) {
                        i10 = 0;
                        c12 = 4;
                    } else if (c12 == 5 || c12 == 6) {
                        i10 = 0;
                        c12 = 7;
                    }
                    i10 = 0;
                }
                i11 = i12;
                c11 = 1;
            } else {
                c10 = 6;
                if (c12 != 5) {
                    return i10;
                }
            }
            c12 = c10;
            i11 = i12;
            c11 = 1;
        }
    }

    private char w0() throws IOException {
        int i10;
        int i11;
        if (this.f6703h.request(1L)) {
            byte readByte = this.f6704i.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return '\b';
            }
            if (readByte == 102) {
                return '\f';
            }
            if (readByte == 110) {
                return '\n';
            }
            if (readByte == 114) {
                return '\r';
            }
            if (readByte == 116) {
                return '\t';
            }
            if (readByte != 117) {
                if (this.f6694e) {
                    return (char) readByte;
                }
                throw g0("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f6703h.request(4L)) {
                char c10 = 0;
                for (int i12 = 0; i12 < 4; i12++) {
                    byte u10 = this.f6704i.u(i12);
                    char c11 = (char) (c10 << 4);
                    if (u10 < 48 || u10 > 57) {
                        if (u10 >= 97 && u10 <= 102) {
                            i10 = u10 - 97;
                        } else if (u10 < 65 || u10 > 70) {
                            throw g0("\\u" + this.f6704i.W(4L));
                        } else {
                            i10 = u10 - 65;
                        }
                        i11 = i10 + 10;
                    } else {
                        i11 = u10 - 48;
                    }
                    c10 = (char) (c11 + i11);
                }
                this.f6704i.f(4L);
                return c10;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + a());
            }
        } else {
            throw g0("Unterminated escape sequence");
        }
    }

    private void z0(ByteString byteString) throws IOException {
        while (true) {
            long F = this.f6703h.F(byteString);
            if (F == -1) {
                throw g0("Unterminated string");
            } else if (this.f6704i.u(F) == 92) {
                this.f6704i.f(F + 1);
                w0();
            } else {
                this.f6704i.f(F + 1);
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token I() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        switch (i10) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int Q(JsonReader.a aVar) throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return j0(this.f6708m, aVar);
        }
        int e02 = this.f6703h.e0(aVar.f6697b);
        if (e02 != -1) {
            this.f6705j = 0;
            this.f6692c[this.f6690a - 1] = aVar.f6696a[e02];
            return e02;
        }
        String str = this.f6692c[this.f6690a - 1];
        String w10 = w();
        int j02 = j0(w10, aVar);
        if (j02 == -1) {
            this.f6705j = 15;
            this.f6708m = w10;
            this.f6692c[this.f6690a - 1] = str;
        }
        return j02;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void T() throws IOException {
        if (!this.f6695f) {
            int i10 = this.f6705j;
            if (i10 == 0) {
                i10 = i0();
            }
            if (i10 == 14) {
                H0();
            } else if (i10 == 13) {
                z0(f6699o);
            } else if (i10 == 12) {
                z0(f6698n);
            } else if (i10 != 15) {
                throw new a("Expected a name but was " + I() + " at path " + a());
            }
            this.f6705j = 0;
            this.f6692c[this.f6690a - 1] = LpaConstants.VALUE_NULL;
            return;
        }
        throw new a("Cannot skip unexpected " + I() + " at " + a());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void V() throws IOException {
        if (!this.f6695f) {
            int i10 = 0;
            do {
                int i11 = this.f6705j;
                if (i11 == 0) {
                    i11 = i0();
                }
                if (i11 == 3) {
                    O(1);
                } else if (i11 == 1) {
                    O(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f6690a--;
                        } else {
                            throw new a("Expected a value but was " + I() + " at path " + a());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f6690a--;
                        } else {
                            throw new a("Expected a value but was " + I() + " at path " + a());
                        }
                    } else if (i11 == 14 || i11 == 10) {
                        H0();
                    } else if (i11 == 9 || i11 == 13) {
                        z0(f6699o);
                    } else if (i11 == 8 || i11 == 12) {
                        z0(f6698n);
                    } else if (i11 == 17) {
                        this.f6704i.f(this.f6707l);
                    } else if (i11 == 18) {
                        throw new a("Expected a value but was " + I() + " at path " + a());
                    }
                    this.f6705j = 0;
                }
                i10++;
                this.f6705j = 0;
            } while (i10 != 0);
            int[] iArr = this.f6693d;
            int i12 = this.f6690a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f6692c[i12 - 1] = LpaConstants.VALUE_NULL;
            return;
        }
        throw new a("Cannot skip unexpected " + I() + " at " + a());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6705j = 0;
        this.f6691b[0] = 8;
        this.f6690a = 1;
        this.f6704i.c();
        this.f6703h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 3) {
            O(1);
            this.f6693d[this.f6690a - 1] = 0;
            this.f6705j = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + I() + " at path " + a());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void h() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 1) {
            O(3);
            this.f6705j = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + I() + " at path " + a());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void i() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 4) {
            int i11 = this.f6690a - 1;
            this.f6690a = i11;
            int[] iArr = this.f6693d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f6705j = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + I() + " at path " + a());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void n() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 2) {
            int i11 = this.f6690a - 1;
            this.f6690a = i11;
            this.f6692c[i11] = null;
            int[] iArr = this.f6693d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f6705j = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + I() + " at path " + a());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean o() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        return (i10 == 2 || i10 == 4 || i10 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean q() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 5) {
            this.f6705j = 0;
            int[] iArr = this.f6693d;
            int i11 = this.f6690a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f6705j = 0;
            int[] iArr2 = this.f6693d;
            int i12 = this.f6690a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + I() + " at path " + a());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f6703h + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double u() throws IOException {
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 16) {
            this.f6705j = 0;
            int[] iArr = this.f6693d;
            int i11 = this.f6690a - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f6706k;
        }
        if (i10 == 17) {
            this.f6708m = this.f6704i.W(this.f6707l);
        } else if (i10 == 9) {
            this.f6708m = o0(f6699o);
        } else if (i10 == 8) {
            this.f6708m = o0(f6698n);
        } else if (i10 == 10) {
            this.f6708m = r0();
        } else if (i10 != 11) {
            throw new a("Expected a double but was " + I() + " at path " + a());
        }
        this.f6705j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f6708m);
            if (this.f6694e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.f6708m = null;
                this.f6705j = 0;
                int[] iArr2 = this.f6693d;
                int i12 = this.f6690a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseDouble;
            }
            throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + a());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.f6708m + " at path " + a());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int v() throws IOException {
        String str;
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 16) {
            long j10 = this.f6706k;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f6705j = 0;
                int[] iArr = this.f6693d;
                int i12 = this.f6690a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new a("Expected an int but was " + this.f6706k + " at path " + a());
        }
        if (i10 == 17) {
            this.f6708m = this.f6704i.W(this.f6707l);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                str = o0(f6699o);
            } else {
                str = o0(f6698n);
            }
            this.f6708m = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f6705j = 0;
                int[] iArr2 = this.f6693d;
                int i13 = this.f6690a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new a("Expected an int but was " + I() + " at path " + a());
        }
        this.f6705j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f6708m);
            int i14 = (int) parseDouble;
            if (i14 == parseDouble) {
                this.f6708m = null;
                this.f6705j = 0;
                int[] iArr3 = this.f6693d;
                int i15 = this.f6690a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new a("Expected an int but was " + this.f6708m + " at path " + a());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.f6708m + " at path " + a());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String w() throws IOException {
        String str;
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 14) {
            str = r0();
        } else if (i10 == 13) {
            str = o0(f6699o);
        } else if (i10 == 12) {
            str = o0(f6698n);
        } else if (i10 == 15) {
            str = this.f6708m;
        } else {
            throw new a("Expected a name but was " + I() + " at path " + a());
        }
        this.f6705j = 0;
        this.f6692c[this.f6690a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String x() throws IOException {
        String str;
        int i10 = this.f6705j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 10) {
            str = r0();
        } else if (i10 == 9) {
            str = o0(f6699o);
        } else if (i10 == 8) {
            str = o0(f6698n);
        } else if (i10 == 11) {
            str = this.f6708m;
            this.f6708m = null;
        } else if (i10 == 16) {
            str = Long.toString(this.f6706k);
        } else if (i10 == 17) {
            str = this.f6704i.W(this.f6707l);
        } else {
            throw new a("Expected a string but was " + I() + " at path " + a());
        }
        this.f6705j = 0;
        int[] iArr = this.f6693d;
        int i11 = this.f6690a - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }
}
