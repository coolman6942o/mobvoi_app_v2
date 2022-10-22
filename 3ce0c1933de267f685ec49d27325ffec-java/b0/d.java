package b0;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f4964a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4965b;

        a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c10, float[] fArr) {
        arrayList.add(new b(c10, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (!(bVarArr[i10].f4966a == bVarArr2[i10].f4966a && bVarArr[i10].f4967b.length == bVarArr2[i10].f4967b.length)) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i10, int i11) {
        if (i10 <= i11) {
            int length = fArr.length;
            if (i10 < 0 || i10 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = i11 - i10;
            int min = Math.min(i12, length - i10);
            float[] fArr2 = new float[i12];
            System.arraycopy(fArr, i10, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int i12 = i(str, i10);
            String trim = str.substring(i11, i12).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i10 = i12 + 1;
            i11 = i12;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            a(arrayList, str.charAt(i11), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d10 = d(str);
        if (d10 == null) {
            return null;
        }
        try {
            b.e(d10, path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing " + str, e10);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            bVarArr2[i10] = new b(bVarArr[i10]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[LOOP:0: B:3:0x0007->B:22:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(String str, int i10, a aVar) {
        aVar.f4965b = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = i10; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i11 != i10 && !z10) {
                                aVar.f4965b = true;
                                break;
                            }
                            z10 = false;
                            break;
                        case '.':
                            if (!z11) {
                                z10 = false;
                                z11 = true;
                                break;
                            } else {
                                aVar.f4965b = true;
                                break;
                            }
                        default:
                            z10 = false;
                            break;
                    }
                } else {
                    z10 = true;
                }
                if (!z12) {
                    aVar.f4964a = i11;
                }
            }
            z10 = false;
            z12 = true;
            if (!z12) {
            }
        }
        aVar.f4964a = i11;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                g(str, i10, aVar);
                int i12 = aVar.f4964a;
                if (i10 < i12) {
                    i11++;
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                }
                i10 = aVar.f4965b ? i12 : i12 + 1;
            }
            return c(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e10);
        }
    }

    private static int i(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i10 = 0; i10 < bVarArr2.length; i10++) {
            bVarArr[i10].f4966a = bVarArr2[i10].f4966a;
            for (int i11 = 0; i11 < bVarArr2[i10].f4967b.length; i11++) {
                bVarArr[i10].f4967b[i11] = bVarArr2[i10].f4967b[i11];
            }
        }
    }

    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f4966a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f4967b;

        b(char c10, float[] fArr) {
            this.f4966a = c10;
            this.f4967b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            int i12;
            char c12 = c11;
            char c13 = 0;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i12 = 7;
                    i10 = i12;
                    break;
                case 'C':
                case 'c':
                    i12 = 6;
                    i10 = i12;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i10 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    i10 = 2;
                    break;
            }
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i13 = 0;
            char c14 = c10;
            while (i13 < fArr2.length) {
                if (c12 != 'A') {
                    if (c12 == 'C') {
                        i11 = i13;
                        int i14 = i11 + 2;
                        int i15 = i11 + 3;
                        int i16 = i11 + 4;
                        int i17 = i11 + 5;
                        path.cubicTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                        f24 = fArr2[i16];
                        float f28 = fArr2[i17];
                        float f29 = fArr2[i14];
                        float f30 = fArr2[i15];
                        f25 = f28;
                        f21 = f30;
                        f20 = f29;
                    } else if (c12 == 'H') {
                        i11 = i13;
                        int i18 = i11 + 0;
                        path.lineTo(fArr2[i18], f25);
                        f24 = fArr2[i18];
                    } else if (c12 == 'Q') {
                        i11 = i13;
                        int i19 = i11 + 0;
                        int i20 = i11 + 1;
                        int i21 = i11 + 2;
                        int i22 = i11 + 3;
                        path.quadTo(fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                        float f31 = fArr2[i19];
                        float f32 = fArr2[i20];
                        f24 = fArr2[i21];
                        f25 = fArr2[i22];
                        f20 = f31;
                        f21 = f32;
                    } else if (c12 == 'V') {
                        i11 = i13;
                        int i23 = i11 + 0;
                        path.lineTo(f24, fArr2[i23]);
                        f25 = fArr2[i23];
                    } else if (c12 != 'a') {
                        if (c12 != 'c') {
                            if (c12 == 'h') {
                                int i24 = i13 + 0;
                                path.rLineTo(fArr2[i24], 0.0f);
                                f24 += fArr2[i24];
                            } else if (c12 != 'q') {
                                if (c12 == 'v') {
                                    int i25 = i13 + 0;
                                    path.rLineTo(0.0f, fArr2[i25]);
                                    f13 = fArr2[i25];
                                } else if (c12 == 'L') {
                                    int i26 = i13 + 0;
                                    int i27 = i13 + 1;
                                    path.lineTo(fArr2[i26], fArr2[i27]);
                                    f24 = fArr2[i26];
                                    f25 = fArr2[i27];
                                } else if (c12 == 'M') {
                                    int i28 = i13 + 0;
                                    f24 = fArr2[i28];
                                    int i29 = i13 + 1;
                                    f25 = fArr2[i29];
                                    if (i13 > 0) {
                                        path.lineTo(fArr2[i28], fArr2[i29]);
                                    } else {
                                        path.moveTo(fArr2[i28], fArr2[i29]);
                                        i11 = i13;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 'S') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    float f33 = f25;
                                    int i30 = i13 + 0;
                                    int i31 = i13 + 1;
                                    int i32 = i13 + 2;
                                    int i33 = i13 + 3;
                                    path.cubicTo(f24, f33, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                    f11 = fArr2[i30];
                                    f10 = fArr2[i31];
                                    f24 = fArr2[i32];
                                    f25 = fArr2[i33];
                                    f20 = f11;
                                    f21 = f10;
                                } else if (c12 == 'T') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    int i34 = i13 + 0;
                                    int i35 = i13 + 1;
                                    path.quadTo(f24, f25, fArr2[i34], fArr2[i35]);
                                    float f34 = fArr2[i34];
                                    float f35 = fArr2[i35];
                                    i11 = i13;
                                    f21 = f25;
                                    f20 = f24;
                                    f24 = f34;
                                    f25 = f35;
                                } else if (c12 == 'l') {
                                    int i36 = i13 + 0;
                                    int i37 = i13 + 1;
                                    path.rLineTo(fArr2[i36], fArr2[i37]);
                                    f24 += fArr2[i36];
                                    f13 = fArr2[i37];
                                } else if (c12 == 'm') {
                                    int i38 = i13 + 0;
                                    f24 += fArr2[i38];
                                    int i39 = i13 + 1;
                                    f25 += fArr2[i39];
                                    if (i13 > 0) {
                                        path.rLineTo(fArr2[i38], fArr2[i39]);
                                    } else {
                                        path.rMoveTo(fArr2[i38], fArr2[i39]);
                                        i11 = i13;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 's') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        f15 = f24 - f20;
                                        f14 = f25 - f21;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i40 = i13 + 0;
                                    int i41 = i13 + 1;
                                    int i42 = i13 + 2;
                                    int i43 = i13 + 3;
                                    path.rCubicTo(f15, f14, fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                                    f11 = fArr2[i40] + f24;
                                    f10 = fArr2[i41] + f25;
                                    f24 += fArr2[i42];
                                    f12 = fArr2[i43];
                                } else if (c12 == 't') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f16 = f24 - f20;
                                        f17 = f25 - f21;
                                    } else {
                                        f17 = 0.0f;
                                        f16 = 0.0f;
                                    }
                                    int i44 = i13 + 0;
                                    int i45 = i13 + 1;
                                    path.rQuadTo(f16, f17, fArr2[i44], fArr2[i45]);
                                    f20 = f16 + f24;
                                    f21 = f17 + f25;
                                    f24 += fArr2[i44];
                                    f25 += fArr2[i45];
                                }
                                f25 += f13;
                            } else {
                                int i46 = i13 + 0;
                                int i47 = i13 + 1;
                                int i48 = i13 + 2;
                                int i49 = i13 + 3;
                                path.rQuadTo(fArr2[i46], fArr2[i47], fArr2[i48], fArr2[i49]);
                                f11 = fArr2[i46] + f24;
                                f10 = fArr2[i47] + f25;
                                f24 += fArr2[i48];
                                f12 = fArr2[i49];
                            }
                            i11 = i13;
                        } else {
                            int i50 = i13 + 2;
                            int i51 = i13 + 3;
                            int i52 = i13 + 4;
                            int i53 = i13 + 5;
                            path.rCubicTo(fArr2[i13 + 0], fArr2[i13 + 1], fArr2[i50], fArr2[i51], fArr2[i52], fArr2[i53]);
                            f11 = fArr2[i50] + f24;
                            f10 = fArr2[i51] + f25;
                            f24 += fArr2[i52];
                            f12 = fArr2[i53];
                        }
                        f25 += f12;
                        f20 = f11;
                        f21 = f10;
                        i11 = i13;
                    } else {
                        int i54 = i13 + 5;
                        int i55 = i13 + 6;
                        i11 = i13;
                        c(path, f24, f25, fArr2[i54] + f24, fArr2[i55] + f25, fArr2[i13 + 0], fArr2[i13 + 1], fArr2[i13 + 2], fArr2[i13 + 3] != 0.0f, fArr2[i13 + 4] != 0.0f);
                        f24 += fArr2[i54];
                        f25 += fArr2[i55];
                    }
                    i13 = i11 + i10;
                    c14 = c11;
                    c12 = c14;
                    c13 = 0;
                } else {
                    i11 = i13;
                    int i56 = i11 + 5;
                    int i57 = i11 + 6;
                    c(path, f24, f25, fArr2[i56], fArr2[i57], fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                    f24 = fArr2[i56];
                    f25 = fArr2[i57];
                }
                f21 = f25;
                f20 = f24;
                i13 = i11 + i10;
                c14 = c11;
                c12 = c14;
                c13 = 0;
            }
            fArr[c13] = f24;
            fArr[1] = f25;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        private static void b(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int ceil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d16);
            double sin = Math.sin(d16);
            double cos2 = Math.cos(d17);
            double sin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * cos;
            double d22 = d13 * sin;
            double d23 = (d21 * sin2) - (d22 * cos2);
            double d24 = d20 * sin;
            double d25 = d13 * cos;
            double d26 = (sin2 * d24) + (cos2 * d25);
            double d27 = d18 / ceil;
            int i10 = 0;
            double d28 = d14;
            double d29 = d15;
            double d30 = d17;
            while (i10 < ceil) {
                double d31 = d30 + d27;
                double sin3 = Math.sin(d31);
                double cos3 = Math.cos(d31);
                ceil = ceil;
                double d32 = (d10 + ((d19 * cos) * cos3)) - (d22 * sin3);
                double d33 = d11 + (d19 * sin * cos3) + (d25 * sin3);
                double d34 = (d21 * sin3) - (d22 * cos3);
                double d35 = (sin3 * d24) + (cos3 * d25);
                double d36 = d31 - d30;
                double tan = Math.tan(d36 / 2.0d);
                double sin4 = (Math.sin(d36) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                cos = cos;
                sin = sin;
                d27 = d27;
                d24 = d24;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d28 + (d23 * sin4)), (float) (d29 + (d26 * sin4)), (float) (d32 - (sin4 * d34)), (float) (d33 - (sin4 * d35)), (float) d32, (float) d33);
                i10++;
                d28 = d32;
                d30 = d31;
                d26 = d35;
                d23 = d34;
                d29 = d33;
                d19 = d12;
            }
        }

        private static void c(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            double radians = Math.toRadians(f16);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d12 = f10;
            double d13 = d12 * cos;
            double d14 = f11;
            double d15 = f14;
            double d16 = (d13 + (d14 * sin)) / d15;
            double d17 = f15;
            double d18 = (((-f10) * sin) + (d14 * cos)) / d17;
            double d19 = f13;
            double d20 = ((f12 * cos) + (d19 * sin)) / d15;
            double d21 = (((-f12) * sin) + (d19 * cos)) / d17;
            double d22 = d16 - d20;
            double d23 = d18 - d21;
            double d24 = (d16 + d20) / 2.0d;
            double d25 = (d18 + d21) / 2.0d;
            double d26 = (d22 * d22) + (d23 * d23);
            if (d26 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d27 = (1.0d / d26) - 0.25d;
            if (d27 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d26);
                float sqrt = (float) (Math.sqrt(d26) / 1.99999d);
                c(path, f10, f11, f12, f13, f14 * sqrt, f15 * sqrt, f16, z10, z11);
                return;
            }
            double sqrt2 = Math.sqrt(d27);
            double d28 = d22 * sqrt2;
            double d29 = sqrt2 * d23;
            if (z10 == z11) {
                d11 = d24 - d29;
                d10 = d25 + d28;
            } else {
                d11 = d24 + d29;
                d10 = d25 - d28;
            }
            double atan2 = Math.atan2(d18 - d10, d16 - d11);
            double atan22 = Math.atan2(d21 - d10, d20 - d11) - atan2;
            int i10 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z11 != (i10 >= 0)) {
                atan22 = i10 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d30 = d11 * d15;
            double d31 = d10 * d17;
            b(path, (d30 * cos) - (d31 * sin), (d30 * sin) + (d31 * cos), d15, d17, d12, d14, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c10 = 'm';
            for (int i10 = 0; i10 < bVarArr.length; i10++) {
                a(path, fArr, c10, bVarArr[i10].f4966a, bVarArr[i10].f4967b);
                c10 = bVarArr[i10].f4966a;
            }
        }

        public void d(b bVar, b bVar2, float f10) {
            this.f4966a = bVar.f4966a;
            int i10 = 0;
            while (true) {
                float[] fArr = bVar.f4967b;
                if (i10 < fArr.length) {
                    this.f4967b[i10] = (fArr[i10] * (1.0f - f10)) + (bVar2.f4967b[i10] * f10);
                    i10++;
                } else {
                    return;
                }
            }
        }

        b(b bVar) {
            this.f4966a = bVar.f4966a;
            float[] fArr = bVar.f4967b;
            this.f4967b = d.c(fArr, 0, fArr.length);
        }
    }
}
