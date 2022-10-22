package com.huawei.hms.scankit.p;

import androidx.recyclerview.widget.g;
import com.huawei.hms.scankit.aiscan.common.B;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.q  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0620q {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14902b;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f14904d;

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14901a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f14903c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f14905e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* renamed from: com.huawei.hms.scankit.p.q$a */
    /* loaded from: classes2.dex */
    public enum a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f14902b = cArr;
        f14904d = cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0554e a(byte[] bArr, Map<EnumC0553d, ?> map) throws C0550a {
        C0599j jVar = new C0599j(bArr);
        StringBuilder sb2 = new StringBuilder(100);
        StringBuilder sb3 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        a aVar = a.ASCII_ENCODE;
        do {
            a aVar2 = a.ASCII_ENCODE;
            if (aVar == aVar2) {
                aVar = a(jVar, sb2, sb3);
            } else {
                int i10 = C0617p.f14889a[aVar.ordinal()];
                if (i10 == 1) {
                    b(jVar, sb2);
                } else if (i10 == 2) {
                    d(jVar, sb2);
                } else if (i10 == 3) {
                    a(jVar, sb2);
                } else if (i10 == 4) {
                    c(jVar, sb2);
                } else if (i10 == 5) {
                    a(jVar, sb2, arrayList);
                } else {
                    throw C0550a.a("AIScanException");
                }
                aVar = aVar2;
            }
            if (aVar == a.PAD_ENCODE) {
                break;
            }
        } while (jVar.a() > 0);
        if (sb3.length() > 0) {
            sb2.append((CharSequence) sb3);
        }
        int length = sb2.length();
        byte[] bArr2 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr2[i11] = (byte) sb2.charAt(i11);
        }
        try {
            String str = new String(bArr2, B.a(bArr2, map));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new C0554e(bArr, str, arrayList, null);
        } catch (UnsupportedEncodingException unused) {
            throw C0550a.a();
        }
    }

    private static void b(C0599j jVar, StringBuilder sb2) throws C0550a {
        int a10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (jVar.a() != 8 && (a10 = jVar.a(8)) != 254) {
            a(a10, jVar.a(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int[] b10 = b(sb2, i10, iArr[i11], z10);
                i10 = b10[0];
                z10 = b10[1] == 1;
            }
            if (jVar.a() <= 0) {
                return;
            }
        }
    }

    private static void c(C0599j jVar, StringBuilder sb2) {
        while (jVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int a10 = jVar.a(6);
                if (a10 == 31) {
                    int b10 = 8 - jVar.b();
                    if (b10 != 8) {
                        jVar.a(b10);
                        return;
                    }
                    return;
                }
                if ((a10 & 32) == 0) {
                    a10 |= 64;
                }
                sb2.append((char) a10);
            }
            if (jVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(C0599j jVar, StringBuilder sb2) throws C0550a {
        int a10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (jVar.a() != 8 && (a10 = jVar.a(8)) != 254) {
            a(a10, jVar.a(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int[] a11 = a(sb2, i10, iArr[i11], z10);
                i10 = a11[0];
                z10 = a11[1] == 1;
            }
            if (jVar.a() <= 0) {
                return;
            }
        }
    }

    private static int[] b(StringBuilder sb2, int i10, int i11, boolean z10) throws C0550a {
        if (i10 != 0) {
            if (i10 == 1) {
                if (z10) {
                    i11 += 128;
                }
                sb2.append((char) i11);
            } else if (i10 == 2) {
                char[] cArr = f14902b;
                if (i11 < cArr.length) {
                    char c10 = cArr[i11];
                    if (z10) {
                        c10 = (char) (c10 + 128);
                    }
                    sb2.append(c10);
                    z10 = false;
                } else if (i11 == 27) {
                    sb2.append((char) 29);
                } else if (i11 == 30) {
                    z10 = true;
                } else {
                    throw C0550a.a("AIScanException");
                }
                i10 = 0;
            } else if (i10 == 3) {
                sb2.append((char) (z10 ? i11 + 224 : i11 + 96));
            } else {
                throw C0550a.a("AIScanException");
            }
            i10 = 0;
            z10 = false;
        } else if (i11 < 3) {
            i10 = i11 + 1;
        } else {
            char[] cArr2 = f14901a;
            if (i11 < cArr2.length) {
                char c11 = cArr2[i11];
                if (z10) {
                    c11 = (char) (c11 + 128);
                }
                sb2.append(c11);
                z10 = false;
            } else {
                throw C0550a.a("AIScanException");
            }
        }
        int i12 = z10 ? 1 : 0;
        char c12 = z10 ? 1 : 0;
        char c13 = z10 ? 1 : 0;
        char c14 = z10 ? 1 : 0;
        char c15 = z10 ? 1 : 0;
        char c16 = z10 ? 1 : 0;
        return new int[]{i10, i12};
    }

    private static a a(C0599j jVar, StringBuilder sb2, StringBuilder sb3) throws C0550a {
        boolean z10 = false;
        do {
            int a10 = jVar.a(8);
            if (a10 == 0) {
                throw C0550a.a("AIScanException");
            } else if (a10 <= 128) {
                if (z10) {
                    a10 += 128;
                }
                sb2.append((char) (a10 - 1));
                return a.ASCII_ENCODE;
            } else if (a10 == 129) {
                return a.PAD_ENCODE;
            } else {
                if (a10 <= 229) {
                    int i10 = a10 - 130;
                    if (i10 < 10) {
                        sb2.append('0');
                    }
                    sb2.append(i10);
                } else {
                    a a11 = a(a10, sb2, sb3, jVar);
                    if (a11 != null) {
                        if (a11 != a.UPPER_ENCODE) {
                            return a11;
                        }
                        z10 = true;
                    }
                }
            }
        } while (jVar.a() > 0);
        return a.ASCII_ENCODE;
    }

    private static a a(int i10, StringBuilder sb2, StringBuilder sb3, C0599j jVar) throws C0550a {
        switch (i10) {
            case 230:
                return a.C40_ENCODE;
            case 231:
                return a.BASE256_ENCODE;
            case 232:
                sb2.append((char) 29);
                return null;
            case 233:
            case 234:
            case 241:
                return null;
            case 235:
                return a.UPPER_ENCODE;
            case 236:
                sb2.append("[)>\u001e05\u001d");
                sb3.insert(0, "\u001e\u0004");
                return null;
            case 237:
                sb2.append("[)>\u001e06\u001d");
                sb3.insert(0, "\u001e\u0004");
                return null;
            case 238:
                return a.ANSIX12_ENCODE;
            case 239:
                return a.TEXT_ENCODE;
            case 240:
                return a.EDIFACT_ENCODE;
            default:
                if (i10 == 254 && jVar.a() == 0) {
                    return null;
                }
                throw C0550a.a("AIScanException");
        }
    }

    private static int[] a(StringBuilder sb2, int i10, int i11, boolean z10) throws C0550a {
        if (i10 != 0) {
            if (i10 == 1) {
                if (z10) {
                    i11 = (char) (i11 + 128);
                }
                sb2.append(i11);
            } else if (i10 == 2) {
                char[] cArr = f14904d;
                if (i11 < cArr.length) {
                    char c10 = cArr[i11];
                    if (z10) {
                        c10 = (char) (c10 + 128);
                    }
                    sb2.append(c10);
                    z10 = false;
                } else if (i11 == 27) {
                    sb2.append((char) 29);
                } else if (i11 == 30) {
                    z10 = true;
                } else {
                    throw C0550a.a("AIScanException");
                }
                i10 = 0;
            } else if (i10 == 3) {
                char[] cArr2 = f14905e;
                if (i11 < cArr2.length) {
                    char c11 = cArr2[i11];
                    if (z10) {
                        c11 = (char) (c11 + 128);
                    }
                    sb2.append(c11);
                } else {
                    throw C0550a.a("AIScanException");
                }
            } else {
                throw C0550a.a("AIScanException");
            }
            i10 = 0;
            z10 = false;
        } else if (i11 < 3) {
            i10 = i11 + 1;
        } else {
            char[] cArr3 = f14903c;
            if (i11 < cArr3.length) {
                char c12 = cArr3[i11];
                if (z10) {
                    c12 = (char) (c12 + 128);
                }
                sb2.append(c12);
                z10 = false;
            } else {
                throw C0550a.a("AIScanException");
            }
        }
        int i12 = z10 ? 1 : 0;
        char c13 = z10 ? 1 : 0;
        char c14 = z10 ? 1 : 0;
        char c15 = z10 ? 1 : 0;
        char c16 = z10 ? 1 : 0;
        char c17 = z10 ? 1 : 0;
        return new int[]{i10, i12};
    }

    private static void a(C0599j jVar, StringBuilder sb2) throws C0550a {
        int a10;
        int[] iArr = new int[3];
        while (jVar.a() != 8 && (a10 = jVar.a(8)) != 254) {
            a(a10, jVar.a(8), iArr);
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
                    throw C0550a.a("AIScanException");
                }
            }
            if (jVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    private static void a(C0599j jVar, StringBuilder sb2, Collection<byte[]> collection) throws C0550a {
        int c10 = jVar.c() + 1;
        int i10 = c10 + 1;
        int a10 = a(jVar.a(8), c10);
        if (a10 == 0) {
            a10 = jVar.a() / 8;
        } else if (a10 >= 250) {
            i10++;
            a10 = ((a10 - 249) * g.f.DEFAULT_SWIPE_ANIMATION_DURATION) + a(jVar.a(8), i10);
        }
        if (a10 >= 0) {
            byte[] bArr = new byte[a10];
            for (int i11 = 0; i11 < a10; i11++) {
                if (jVar.a() >= 8) {
                    i10++;
                    bArr[i11] = (byte) a(jVar.a(8), i10);
                } else {
                    throw C0550a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb2.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e10) {
                throw new IllegalStateException("Platform does not support required encoding: " + e10);
            }
        } else {
            throw C0550a.a("AIScanException");
        }
    }

    private static int a(int i10, int i11) {
        int i12 = i10 - (((i11 * com.bjleisen.iface.sdk.a.f7612e) % 255) + 1);
        return i12 >= 0 ? i12 : i12 + 256;
    }
}
