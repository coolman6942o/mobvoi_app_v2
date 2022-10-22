package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import o8.a;
import o8.b;
import o8.e;
/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f13460a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea A[LOOP:0: B:63:0x001d->B:60:0x00ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(byte[] bArr, h hVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        Mode mode2;
        a aVar = new a(bArr);
        StringBuilder sb2 = new StringBuilder(50);
        int i10 = 1;
        ArrayList arrayList = new ArrayList(1);
        boolean z10 = false;
        int i11 = -1;
        int i12 = -1;
        CharacterSetECI characterSetECI = null;
        while (true) {
            try {
                if (aVar.a() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(aVar.d(4));
                }
                Mode mode3 = forBits;
                Mode mode4 = Mode.TERMINATOR;
                if (mode3 != mode4) {
                    if (!(mode3 == Mode.FNC1_FIRST_POSITION || mode3 == Mode.FNC1_SECOND_POSITION)) {
                        if (mode3 == Mode.STRUCTURED_APPEND) {
                            if (aVar.a() >= 16) {
                                int d10 = aVar.d(8);
                                i12 = aVar.d(8);
                                i11 = d10;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else if (mode3 == Mode.ECI) {
                            characterSetECI = CharacterSetECI.getCharacterSetECIByValue(g(aVar));
                            if (characterSetECI == null) {
                                throw FormatException.getFormatInstance();
                            }
                        } else if (mode3 == Mode.HANZI) {
                            int d11 = aVar.d(4);
                            int d12 = aVar.d(mode3.getCharacterCountBits(hVar));
                            if (d11 == i10) {
                                d(aVar, sb2, d12);
                            }
                        } else {
                            int d13 = aVar.d(mode3.getCharacterCountBits(hVar));
                            if (mode3 == Mode.NUMERIC) {
                                f(aVar, sb2, d13);
                            } else if (mode3 == Mode.ALPHANUMERIC) {
                                b(aVar, sb2, d13, z10);
                            } else {
                                if (mode3 == Mode.BYTE) {
                                    mode2 = mode4;
                                    mode = mode3;
                                    c(aVar, sb2, d13, characterSetECI, arrayList, map);
                                } else {
                                    mode2 = mode4;
                                    mode = mode3;
                                    if (mode == Mode.KANJI) {
                                        e(aVar, sb2, d13);
                                    } else {
                                        throw FormatException.getFormatInstance();
                                    }
                                }
                                if (mode == mode2) {
                                    return new b(bArr, sb2.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i11, i12);
                                }
                                i10 = 1;
                            }
                        }
                    }
                    mode2 = mode4;
                    mode = mode3;
                    z10 = true;
                    if (mode == mode2) {
                    }
                }
                mode2 = mode4;
                mode = mode3;
                if (mode == mode2) {
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void b(a aVar, StringBuilder sb2, int i10, boolean z10) throws FormatException {
        while (i10 > 1) {
            if (aVar.a() >= 11) {
                int d10 = aVar.d(11);
                sb2.append(h(d10 / 45));
                sb2.append(h(d10 % 45));
                i10 -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i10 == 1) {
            if (aVar.a() >= 6) {
                sb2.append(h(aVar.d(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(a aVar, StringBuilder sb2, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if ((i10 << 3) <= aVar.a()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) aVar.d(8);
            }
            if (characterSetECI == null) {
                str = e.a(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb2.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void d(a aVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 <= aVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int d10 = aVar.d(13);
                int i12 = (d10 % 96) | ((d10 / 96) << 8);
                int i13 = i12 + (i12 < 959 ? 41377 : 42657);
                bArr[i11] = (byte) (i13 >> 8);
                bArr[i11 + 1] = (byte) i13;
                i11 += 2;
                i10--;
            }
            try {
                sb2.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void e(a aVar, StringBuilder sb2, int i10) throws FormatException {
        if (i10 * 13 <= aVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int d10 = aVar.d(13);
                int i12 = (d10 % 192) | ((d10 / 192) << 8);
                int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
                bArr[i11] = (byte) (i13 >> 8);
                bArr[i11 + 1] = (byte) i13;
                i11 += 2;
                i10--;
            }
            try {
                sb2.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void f(a aVar, StringBuilder sb2, int i10) throws FormatException {
        while (i10 >= 3) {
            if (aVar.a() >= 10) {
                int d10 = aVar.d(10);
                if (d10 < 1000) {
                    sb2.append(h(d10 / 100));
                    sb2.append(h((d10 / 10) % 10));
                    sb2.append(h(d10 % 10));
                    i10 -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i10 == 2) {
            if (aVar.a() >= 7) {
                int d11 = aVar.d(7);
                if (d11 < 100) {
                    sb2.append(h(d11 / 10));
                    sb2.append(h(d11 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i10 != 1) {
        } else {
            if (aVar.a() >= 4) {
                int d12 = aVar.d(4);
                if (d12 < 10) {
                    sb2.append(h(d12));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int g(a aVar) throws FormatException {
        int d10 = aVar.d(8);
        if ((d10 & 128) == 0) {
            return d10 & 127;
        }
        if ((d10 & 192) == 128) {
            return aVar.d(8) | ((d10 & 63) << 8);
        }
        if ((d10 & 224) == 192) {
            return aVar.d(16) | ((d10 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i10) throws FormatException {
        char[] cArr = f13460a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.getFormatInstance();
    }
}
