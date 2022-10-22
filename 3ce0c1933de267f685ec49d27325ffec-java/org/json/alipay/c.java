package org.json.alipay;

import com.mobvoi.wear.lpa.LpaConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f32515a;

    /* renamed from: b  reason: collision with root package name */
    public Reader f32516b;

    /* renamed from: c  reason: collision with root package name */
    public char f32517c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32518d;

    public c(Reader reader) {
        this.f32516b = !reader.markSupported() ? new BufferedReader(reader) : reader;
        this.f32518d = false;
        this.f32515a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i10) {
        if (i10 == 0) {
            return "";
        }
        char[] cArr = new char[i10];
        int i11 = 0;
        if (this.f32518d) {
            this.f32518d = false;
            cArr[0] = this.f32517c;
            i11 = 1;
        }
        while (i11 < i10) {
            try {
                int read = this.f32516b.read(cArr, i11, i10 - i11);
                if (read == -1) {
                    break;
                }
                i11 += read;
            } catch (IOException e10) {
                throw new JSONException(e10);
            }
        }
        this.f32515a += i11;
        if (i11 >= i10) {
            this.f32517c = cArr[i10 - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i10;
        if (this.f32518d || (i10 = this.f32515a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f32515a = i10 - 1;
        this.f32518d = true;
    }

    public final char b() {
        if (this.f32518d) {
            this.f32518d = false;
            char c10 = this.f32517c;
            if (c10 != 0) {
                this.f32515a++;
            }
            return c10;
        }
        try {
            int read = this.f32516b.read();
            if (read <= 0) {
                this.f32517c = (char) 0;
                return (char) 0;
            }
            this.f32515a++;
            char c11 = (char) read;
            this.f32517c = c11;
            return c11;
        } catch (IOException e10) {
            throw new JSONException(e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final char c() {
        char b10;
        char b11;
        while (true) {
            char b12 = b();
            if (b12 == '/') {
                char b13 = b();
                if (b13 == '*') {
                    while (true) {
                        char b14 = b();
                        if (b14 == 0) {
                            throw a("Unclosed comment");
                        } else if (b14 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else if (b13 != '/') {
                    a();
                    return '/';
                } else {
                    do {
                        b10 = b();
                        if (!(b10 == '\n' || b10 == '\r')) {
                        }
                    } while (b10 != 0);
                }
            } else if (b12 == '#') {
                do {
                    b11 = b();
                    if (!(b11 == '\n' || b11 == '\r')) {
                    }
                } while (b11 != 0);
            } else if (b12 == 0 || b12 > ' ') {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0146, code lost:
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d() {
        String str;
        char c10 = c();
        if (c10 != '\"') {
            if (c10 != '[') {
                if (c10 == '{') {
                    a();
                    return new b(this);
                } else if (c10 != '\'') {
                    if (c10 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c11 = c10;
                        while (c11 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c11) < 0) {
                            stringBuffer.append(c11);
                            c11 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        } else if (trim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        } else {
                            if (trim.equalsIgnoreCase("false")) {
                                return Boolean.FALSE;
                            }
                            if (trim.equalsIgnoreCase(LpaConstants.VALUE_NULL)) {
                                return b.f32513a;
                            }
                            if ((c10 < '0' || c10 > '9') && c10 != '.' && c10 != '-' && c10 != '+') {
                                return trim;
                            }
                            if (c10 == '0') {
                                try {
                                    return (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(trim, 8)) : new Integer(Integer.parseInt(trim.substring(2), 16));
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                try {
                                    try {
                                        return new Integer(trim);
                                    } catch (Exception unused2) {
                                        return new Double(trim);
                                    }
                                } catch (Exception unused3) {
                                    return new Long(trim);
                                }
                            } catch (Exception unused4) {
                                return trim;
                            }
                        }
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b10 = b();
            if (b10 == 0 || b10 == '\n' || b10 == '\r') {
                break;
            }
            if (b10 == '\\') {
                b10 = b();
                if (b10 == 'b') {
                    stringBuffer2.append('\b');
                } else if (b10 == 'f') {
                    b10 = '\f';
                } else if (b10 == 'n') {
                    stringBuffer2.append('\n');
                } else if (b10 != 'r') {
                    if (b10 == 'x') {
                        str = a(2);
                    } else if (b10 == 't') {
                        b10 = '\t';
                    } else if (b10 == 'u') {
                        str = a(4);
                    }
                    b10 = (char) Integer.parseInt(str, 16);
                } else {
                    stringBuffer2.append('\r');
                }
            } else if (b10 == c10) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(b10);
        }
    }

    public final String toString() {
        return " at character " + this.f32515a;
    }
}
