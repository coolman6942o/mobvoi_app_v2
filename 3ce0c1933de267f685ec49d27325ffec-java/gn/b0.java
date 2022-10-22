package gn;

import java.util.Locale;
/* loaded from: classes2.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static b0 f27520a;

    private b0() {
    }

    public static void a(String str) {
        u.d("TemperatureUtil", str);
    }

    public static b0 h() {
        if (f27520a == null) {
            f27520a = new b0();
        }
        return f27520a;
    }

    public float b(byte[] bArr) {
        return m(2, ((bArr[12] & 255) | ((bArr[11] << 8) & 65280)) / 100.0f);
    }

    public float c(byte[] bArr) {
        return m(2, ((bArr[10] & 255) | ((bArr[9] << 8) & 65280)) / 100.0f);
    }

    public float d(boolean z10, byte[] bArr) {
        byte b10;
        int i10;
        if (z10) {
            i10 = (bArr[11] << 8) & 65280;
            b10 = bArr[12];
        } else {
            i10 = (bArr[9] << 8) & 65280;
            b10 = bArr[10];
        }
        return m(2, (i10 | (b10 & 255)) / 100.0f);
    }

    public String e(byte[] bArr) {
        int i10 = bArr[5] & 255;
        int i11 = bArr[4] & 255;
        int i12 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return i12 + valueOf2 + valueOf;
    }

    public String f(String str, int i10) {
        int i11 = i10 / 60;
        int i12 = i10 % 60;
        String valueOf = String.valueOf(i11);
        String valueOf2 = String.valueOf(i12);
        if (i11 < 10) {
            valueOf = "0" + valueOf;
        }
        if (i12 < 10) {
            valueOf2 = "0" + valueOf2;
        }
        return str + valueOf + valueOf2;
    }

    public int g(byte[] bArr) {
        return bArr[6] & 255;
    }

    public float i(byte[] bArr) {
        int i10 = (bArr[4] & 255) | ((bArr[3] << 8) & 65280);
        a("temperature1 =" + i10);
        return m(2, i10 / 100.0f);
    }

    public float j(byte[] bArr) {
        int i10 = (bArr[6] & 255) | ((bArr[5] << 8) & 65280);
        a("temperature2 =" + i10);
        return m(2, i10 / 100.0f);
    }

    public int k(byte[] bArr) {
        return ((bArr[6] & 255) * 3600) + ((bArr[7] & 255) * 60) + (bArr[8] & 255);
    }

    public String l(byte[] bArr) {
        int i10 = bArr[6] & 255;
        int i11 = bArr[7] & 255;
        int i12 = bArr[8] & 255;
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        String valueOf3 = String.valueOf(i12);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        if (i12 < 10) {
            valueOf3 = "0" + i12;
        }
        return e(bArr) + valueOf + valueOf2 + valueOf3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float m(int i10, double d10) {
        String str = "%.0f";
        float f10 = 5.0E-6f;
        f10 = 0.0f;
        switch (i10) {
            case 1:
                str = "%.1f";
                break;
            case 2:
                str = "%.2f";
                break;
            case 3:
                str = "%.3f";
                break;
            case 4:
                str = "%.4f";
                break;
            case 5:
                str = "%.5f";
                break;
            case 6:
                str = "%.6f";
                break;
            case 7:
                str = "%.7f";
                break;
            case 8:
                str = "%.8f";
                break;
            case 9:
                str = "%.9f";
                break;
            case 10:
                str = "%.10f";
                break;
        }
        return Float.valueOf(String.format(Locale.US, str, Double.valueOf(d10 + f10))).floatValue();
    }
}
