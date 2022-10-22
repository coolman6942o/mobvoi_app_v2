package r8;

import androidx.recyclerview.widget.g;
import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f33447b;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f33449d;

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f33446a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f33448c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f33450e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33451a;

        static {
            int[] iArr = new int[b.values().length];
            f33451a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33451a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33451a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33451a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33451a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes.dex */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f33447b = cArr;
        f33449d = cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o8.b a(byte[] bArr) throws FormatException {
        o8.a aVar = new o8.a(bArr);
        StringBuilder sb2 = new StringBuilder(100);
        StringBuilder sb3 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            b bVar2 = b.ASCII_ENCODE;
            if (bVar == bVar2) {
                bVar = c(aVar, sb2, sb3);
            } else {
                int i10 = a.f33451a[bVar.ordinal()];
                if (i10 == 1) {
                    e(aVar, sb2);
                } else if (i10 == 2) {
                    g(aVar, sb2);
                } else if (i10 == 3) {
                    b(aVar, sb2);
                } else if (i10 == 4) {
                    f(aVar, sb2);
                } else if (i10 == 5) {
                    d(aVar, sb2, arrayList);
                } else {
                    throw FormatException.getFormatInstance();
                }
                bVar = bVar2;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (aVar.a() > 0);
        if (sb3.length() > 0) {
            sb2.append((CharSequence) sb3);
        }
        String sb4 = sb2.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new o8.b(bArr, sb4, arrayList, null);
    }

    private static void b(o8.a aVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        while (aVar.a() != 8 && (d10 = aVar.d(8)) != 254) {
            h(d10, aVar.d(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 == 0) {
                    sb2.append('\r');
                } else if (i11 == 1) {
                    sb2.append('*');
                } else if (i11 == 2) {
                    sb2.append('>');
                } else if (i11 == 3) {
                    sb2.append(' ');
                } else if (i11 < 14) {
                    sb2.append((char) (i11 + 44));
                } else if (i11 < 40) {
                    sb2.append((char) (i11 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (aVar.a() <= 0) {
                return;
            }
        }
    }

    private static b c(o8.a aVar, StringBuilder sb2, StringBuilder sb3) throws FormatException {
        boolean z10 = false;
        do {
            int d10 = aVar.d(8);
            if (d10 == 0) {
                throw FormatException.getFormatInstance();
            } else if (d10 <= 128) {
                if (z10) {
                    d10 += 128;
                }
                sb2.append((char) (d10 - 1));
                return b.ASCII_ENCODE;
            } else if (d10 == 129) {
                return b.PAD_ENCODE;
            } else {
                if (d10 <= 229) {
                    int i10 = d10 - 130;
                    if (i10 < 10) {
                        sb2.append('0');
                    }
                    sb2.append(i10);
                } else if (d10 == 230) {
                    return b.C40_ENCODE;
                } else {
                    if (d10 == 231) {
                        return b.BASE256_ENCODE;
                    }
                    if (d10 == 232) {
                        sb2.append((char) 29);
                    } else if (!(d10 == 233 || d10 == 234)) {
                        if (d10 == 235) {
                            z10 = true;
                        } else if (d10 == 236) {
                            sb2.append("[)>\u001e05\u001d");
                            sb3.insert(0, "\u001e\u0004");
                        } else if (d10 == 237) {
                            sb2.append("[)>\u001e06\u001d");
                            sb3.insert(0, "\u001e\u0004");
                        } else if (d10 == 238) {
                            return b.ANSIX12_ENCODE;
                        } else {
                            if (d10 == 239) {
                                return b.TEXT_ENCODE;
                            }
                            if (d10 == 240) {
                                return b.EDIFACT_ENCODE;
                            }
                            if (!(d10 == 241 || d10 < 242 || (d10 == 254 && aVar.a() == 0))) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (aVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(o8.a aVar, StringBuilder sb2, Collection<byte[]> collection) throws FormatException {
        int c10 = aVar.c() + 1;
        int i10 = c10 + 1;
        int i11 = i(aVar.d(8), c10);
        if (i11 == 0) {
            i11 = aVar.a() / 8;
        } else if (i11 >= 250) {
            i10++;
            i11 = ((i11 - 249) * g.f.DEFAULT_SWIPE_ANIMATION_DURATION) + i(aVar.d(8), i10);
        }
        if (i11 >= 0) {
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                if (aVar.a() >= 8) {
                    i10++;
                    bArr[i12] = (byte) i(aVar.d(8), i10);
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb2.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e10) {
                throw new IllegalStateException("Platform does not support required encoding: " + e10);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void e(o8.a aVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (aVar.a() != 8 && (d10 = aVar.d(8)) != 254) {
            h(d10, aVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f33447b;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb2.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb2.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb2.append((char) 29);
                            } else if (i12 == 30) {
                                z10 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i10 = 0;
                        } else if (i10 != 3) {
                            throw FormatException.getFormatInstance();
                        } else if (z10) {
                            sb2.append((char) (i12 + 224));
                            z10 = false;
                            i10 = 0;
                        } else {
                            sb2.append((char) (i12 + 96));
                            i10 = 0;
                        }
                    } else if (z10) {
                        sb2.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb2.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = f33446a;
                    if (i12 < cArr2.length) {
                        char c11 = cArr2[i12];
                        if (z10) {
                            sb2.append((char) (c11 + 128));
                            z10 = false;
                        } else {
                            sb2.append(c11);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (aVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(o8.a aVar, StringBuilder sb2) {
        while (aVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int d10 = aVar.d(6);
                if (d10 == 31) {
                    int b10 = 8 - aVar.b();
                    if (b10 != 8) {
                        aVar.d(b10);
                        return;
                    }
                    return;
                }
                if ((d10 & 32) == 0) {
                    d10 |= 64;
                }
                sb2.append((char) d10);
            }
            if (aVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(o8.a aVar, StringBuilder sb2) throws FormatException {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (aVar.a() != 8 && (d10 = aVar.d(8)) != 254) {
            h(d10, aVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            char[] cArr = f33449d;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb2.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb2.append(c10);
                                }
                            } else if (i12 == 27) {
                                sb2.append((char) 29);
                            } else if (i12 == 30) {
                                z10 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i10 = 0;
                        } else if (i10 == 3) {
                            char[] cArr2 = f33450e;
                            if (i12 < cArr2.length) {
                                char c11 = cArr2[i12];
                                if (z10) {
                                    sb2.append((char) (c11 + 128));
                                    z10 = false;
                                    i10 = 0;
                                } else {
                                    sb2.append(c11);
                                    i10 = 0;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (z10) {
                        sb2.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb2.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = f33448c;
                    if (i12 < cArr3.length) {
                        char c12 = cArr3[i12];
                        if (z10) {
                            sb2.append((char) (c12 + 128));
                            z10 = false;
                        } else {
                            sb2.append(c12);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (aVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    private static int i(int i10, int i11) {
        int i12 = i10 - (((i11 * com.bjleisen.iface.sdk.a.f7612e) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
