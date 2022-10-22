package cn;

import android.content.Context;
import android.util.Log;
import com.realsil.sdk.dfu.DfuException;
import dn.j;
import gn.k;
import gn.p;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: p  reason: collision with root package name */
    private static h f6250p;

    /* renamed from: h  reason: collision with root package name */
    private j f6258h;

    /* renamed from: k  reason: collision with root package name */
    private Context f6261k;

    /* renamed from: a  reason: collision with root package name */
    private String f6251a = "ECGAlgoAnalysis";

    /* renamed from: b  reason: collision with root package name */
    private int f6252b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f6253c = {0.1f, 0.3f, 0.7f, 0.3f, 0.1f};

    /* renamed from: d  reason: collision with root package name */
    private float f6254d = 1.5f;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Short> f6255e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private int f6257g = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f6259i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6260j = true;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f6262l = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: m  reason: collision with root package name */
    private final int[] f6263m = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, DfuException.ERROR_SEND_COMMAND_FAIL, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: n  reason: collision with root package name */
    private int f6264n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f6265o = 0;

    /* renamed from: f  reason: collision with root package name */
    private k f6256f = new k();

    public h(Context context) {
        this.f6261k = context;
    }

    public static h e(Context context) {
        if (f6250p == null) {
            f6250p = new h(context);
        }
        return f6250p;
    }

    public void a(short s10) {
        int o10 = this.f6256f.o(s10);
        int i10 = this.f6257g + 1;
        this.f6257g = i10;
        int i11 = this.f6252b;
        if (i10 < i11) {
            return;
        }
        if (o10 != 0) {
            if (this.f6258h != null) {
                Log.i("RTHR", "rtHR=" + o10);
                this.f6258h.a(o10);
            }
            this.f6257g = 0;
            return;
        }
        this.f6257g = i11;
    }

    public short b(byte b10, int i10) {
        int i11;
        int i12 = this.f6264n;
        int i13 = this.f6265o;
        int i14 = this.f6263m[i13];
        boolean z10 = false;
        short s10 = 0;
        byte b11 = 0;
        while (i10 > 0) {
            if (!z10) {
                i11 = b10 & 15;
                b11 = b10;
            } else {
                i11 = (b11 >> 4) & 15;
            }
            z10 = !z10;
            i13 += this.f6262l[i11];
            if (i13 < 0) {
                i13 = 0;
            }
            if (i13 > 88) {
                i13 = 88;
            }
            int i15 = i11 & 8;
            int i16 = i11 & 7;
            int i17 = i14 >> 3;
            if ((i16 & 4) != 0) {
                i17 += i14;
            }
            if ((i16 & 2) != 0) {
                i17 += i14 >> 1;
            }
            if ((i16 & 1) != 0) {
                i17 += i14 >> 2;
            }
            i12 = i15 != 0 ? i12 - i17 : i12 + i17;
            if (i12 > 32767) {
                i12 = 32767;
            } else if (i12 < -32768) {
                i12 = -32768;
            }
            i14 = this.f6263m[i13];
            s10 = (short) i12;
            i10--;
        }
        this.f6264n = i12;
        this.f6265o = i13;
        if (p.d(this.f6261k, 128)) {
            return s10;
        }
        double d10 = 0.0d;
        this.f6255e.add(Short.valueOf(s10));
        if (this.f6255e.size() >= 5) {
            if (this.f6255e.size() > 5) {
                this.f6255e.remove(0);
            }
            for (int i18 = 0; i18 < 5; i18++) {
                d10 += this.f6253c[i18] * this.f6255e.get(i18).shortValue();
            }
            d10 /= this.f6254d;
        }
        int i19 = this.f6259i;
        if (i19 >= 1000) {
            this.f6260j = false;
        }
        if (this.f6260j) {
            this.f6259i = i19 + 1;
        } else {
            a((short) d10);
        }
        return (short) d10;
    }

    public int c() {
        return this.f6256f.u();
    }

    public int d() {
        return this.f6256f.v();
    }

    public void f() {
        Log.i(this.f6251a, "心电算法 重置");
        this.f6256f.p();
        this.f6257g = 0;
        this.f6264n = 0;
        this.f6265o = 0;
        this.f6259i = 0;
        this.f6260j = true;
    }
}
