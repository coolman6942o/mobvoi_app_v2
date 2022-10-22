package gn;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: b  reason: collision with root package name */
    private static v f27600b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27601a;

    public v(Context context) {
        this.f27601a = context;
    }

    public static void a(String str) {
        u.d("sendTextKey", str);
    }

    public static v w(Context context) {
        if (f27600b == null) {
            f27600b = new v(context);
        }
        return f27600b;
    }

    public int A(byte[] bArr) {
        return ((bArr[1] << 8) & 65280) | (bArr[2] & 255);
    }

    public String B(byte[] bArr) {
        int i10 = bArr[9] & 255;
        int i11 = bArr[8] & 255;
        int i12 = (bArr[7] & 255) | ((bArr[6] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        String valueOf3 = String.valueOf(i12);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return valueOf3 + valueOf2 + valueOf;
    }

    public String C(byte[] bArr) {
        int i10 = bArr[12] & 255;
        int i11 = bArr[11] & 255;
        int i12 = bArr[10] & 255;
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
        return B(bArr) + valueOf3 + valueOf2 + valueOf;
    }

    public int D(byte[] bArr) {
        return (bArr[9] & 255) | ((bArr[8] << 8) & 65280);
    }

    public int E(byte[] bArr, String str) {
        if (!p.d(this.f27601a, 262144)) {
            return h.g(C(bArr), s(bArr, str));
        }
        if (str.length() == 40) {
            return Integer.parseInt(str.substring(34, 40), 16);
        }
        return 0;
    }

    public int b(byte[] bArr) {
        return ((bArr[15] & 255) * 60) + (bArr[16] & 255);
    }

    public int c(byte[] bArr) {
        return ((bArr[5] & 255) * 60) + (bArr[6] & 255);
    }

    public int d(byte[] bArr) {
        return bArr[12] & 255;
    }

    public int e(byte[] bArr) {
        return bArr[13] & 255;
    }

    public int f(byte[] bArr) {
        return bArr[14] & 255;
    }

    public int g(byte[] bArr) {
        return bArr[2] & 255;
    }

    public int h(byte[] bArr) {
        return (bArr[9] & 255) | ((bArr[8] << 8) & 65280);
    }

    public int i(byte[] bArr) {
        return (bArr[4] & 255) | ((bArr[3] << 8) & 65280);
    }

    public int j(byte[] bArr) {
        return (bArr[7] & 255) | ((bArr[6] << 8) & 65280);
    }

    public int k(byte[] bArr) {
        return (bArr[11] & 255) | ((bArr[10] << 8) & 65280);
    }

    public float l(byte[] bArr) {
        return (bArr[10] & 255) + ((bArr[11] & 255) / 100.0f);
    }

    public float m(byte[] bArr) {
        return (bArr[12] & 255) + ((bArr[13] & 255) / 100.0f);
    }

    public int n(byte[] bArr) {
        return (bArr[5] & 255) | ((bArr[3] << 8) & 16711680) | ((bArr[4] << 8) & 65280);
    }

    public int o(byte[] bArr) {
        return (bArr[9] & 255) | ((bArr[7] << 8) & 16711680) | ((bArr[8] << 8) & 65280);
    }

    public int p(byte[] bArr) {
        return bArr[17] & 255;
    }

    public int q(byte[] bArr) {
        return bArr[3];
    }

    public int r(byte[] bArr) {
        return bArr[1];
    }

    public String s(byte[] bArr, String str) {
        if (p.d(this.f27601a, 262144)) {
            return str.length() == 40 ? h.i(Integer.parseInt(str.substring(26, 34), 16)) : "";
        }
        int i10 = bArr[19] & 255;
        int i11 = bArr[18] & 255;
        int i12 = bArr[17] & 255;
        int i13 = bArr[16] & 255;
        int i14 = bArr[15] & 255;
        int i15 = (bArr[14] & 255) | ((bArr[13] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        String valueOf3 = String.valueOf(i12);
        String valueOf4 = String.valueOf(i13);
        String valueOf5 = String.valueOf(i14);
        String valueOf6 = String.valueOf(i15);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        if (i12 < 10) {
            valueOf3 = "0" + i12;
        }
        if (i13 < 10) {
            valueOf4 = "0" + i13;
        }
        if (i14 < 10) {
            valueOf5 = "0" + i14;
        }
        return valueOf6 + valueOf5 + valueOf4 + valueOf3 + valueOf2 + valueOf;
    }

    public List<Integer> t(byte[] bArr, boolean z10) {
        int length = bArr.length;
        ArrayList arrayList = new ArrayList();
        for (int i10 = !z10 ? 3 : 5; i10 < length; i10++) {
            arrayList.add(Integer.valueOf(bArr[i10] & 255));
        }
        return arrayList;
    }

    public int u(byte[] bArr) {
        return bArr[4] & 255;
    }

    public int v(byte[] bArr) {
        return bArr[3] & 255;
    }

    public int x(byte[] bArr) {
        return (bArr[6] & 255) | ((bArr[5] << 8) & 65280);
    }

    public String y(String[] strArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (!TextUtils.isEmpty(strArr[i10])) {
                sb2.append(strArr[i10]);
            }
        }
        return sb2.toString();
    }

    public int z(byte[] bArr) {
        return ((bArr[4] << 8) & 65280) | (bArr[5] & 255);
    }
}
