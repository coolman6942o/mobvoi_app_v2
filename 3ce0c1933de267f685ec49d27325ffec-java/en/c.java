package en;

import android.content.Context;
import android.content.SharedPreferences;
import cn.w;
import cn.x;
import cn.z;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.unionpay.tsmservice.data.Constant;
import gn.h;
import gn.q;
import gn.t;
import gn.u;
import gn.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a0  reason: collision with root package name */
    public static c f26134a0;

    /* renamed from: a  reason: collision with root package name */
    private Context f26135a;

    /* renamed from: p  reason: collision with root package name */
    private SharedPreferences f26150p;

    /* renamed from: q  reason: collision with root package name */
    private SharedPreferences.Editor f26151q;

    /* renamed from: r  reason: collision with root package name */
    private o f26152r;

    /* renamed from: s  reason: collision with root package name */
    private q f26153s;

    /* renamed from: t  reason: collision with root package name */
    private y f26154t;

    /* renamed from: u  reason: collision with root package name */
    private n f26155u;

    /* renamed from: v  reason: collision with root package name */
    private l f26156v;

    /* renamed from: w  reason: collision with root package name */
    private a f26157w;

    /* renamed from: x  reason: collision with root package name */
    private h f26158x;

    /* renamed from: y  reason: collision with root package name */
    private i f26159y;

    /* renamed from: z  reason: collision with root package name */
    private k f26160z;

    /* renamed from: b  reason: collision with root package name */
    private int f26136b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int[] f26137c = {0, 1, 2, 3, 4};

    /* renamed from: d  reason: collision with root package name */
    private int f26138d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f26139e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f26140f = "";

    /* renamed from: g  reason: collision with root package name */
    private int f26141g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f26142h = 25;

    /* renamed from: i  reason: collision with root package name */
    private String f26143i = "";

    /* renamed from: j  reason: collision with root package name */
    private int f26144j = 0;

    /* renamed from: k  reason: collision with root package name */
    private String f26145k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f26146l = "";

    /* renamed from: m  reason: collision with root package name */
    private int f26147m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f26148n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f26149o = 0;
    private int A = -1;
    private String B = "0";
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private ArrayList<x> S = new ArrayList<>();
    private ArrayList<cn.y> T = new ArrayList<>();
    private ArrayList<z> U = new ArrayList<>();
    private ArrayList<w> V = new ArrayList<>();
    private ArrayList<w> W = new ArrayList<>();
    private int X = 255;
    private int Y = 0;
    private int Z = 0;

    private c(Context context) {
        this.f26135a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(q.f27582a, 0);
        this.f26150p = sharedPreferences;
        this.f26151q = sharedPreferences.edit();
        this.f26152r = o.b(this.f26135a);
        this.f26153s = q.B(this.f26135a);
        this.f26154t = y.h(this.f26135a);
        this.f26156v = l.p(this.f26135a);
    }

    private int A(byte[] bArr) {
        return ((bArr[9] << 32) & (-16777216)) | (bArr[12] & 255) | ((bArr[11] << 8) & 65280) | ((bArr[10] << 16) & 16711680);
    }

    private int B(byte[] bArr) {
        return bArr[10] & 255;
    }

    private int C(byte[] bArr) {
        return ((bArr[11] << 8) & 65280) | (bArr[12] & 255);
    }

    private int D(byte[] bArr) {
        return bArr[15] & 255;
    }

    private int E(byte[] bArr) {
        return ((bArr[13] << 8) & 65280) | (bArr[14] & 255);
    }

    private int F(byte[] bArr) {
        return ((bArr[12] << 8) & 65280) | (bArr[13] & 255);
    }

    private int G(byte[] bArr) {
        return ((bArr[7] & 255) * 60) + (bArr[8] & 255);
    }

    private int H(byte[] bArr) {
        return ((bArr[5] & 255) * 60) + (bArr[6] & 255);
    }

    private int I(byte[] bArr) {
        return ((bArr[9] & 255) * 3600) + ((bArr[10] & 255) * 60) + (bArr[11] & 255);
    }

    private int J(byte[] bArr) {
        return bArr[15] & 255;
    }

    private int K(byte[] bArr) {
        return ((bArr[16] << 8) & 65280) | (bArr[17] & 255);
    }

    private boolean R(byte[] bArr) {
        return (bArr[1] & 255) == 0;
    }

    private boolean Z(byte[] bArr) {
        return (bArr[2] & 255) == 0;
    }

    private int a() {
        return Calendar.getInstance().get(11);
    }

    private boolean a0(byte[] bArr) {
        return (bArr[2] & 255) == 0;
    }

    private int b(byte[] bArr) {
        return bArr[5] & 255;
    }

    private boolean b0(byte[] bArr) {
        return (bArr[1] & 255) == 0;
    }

    private int c(byte[] bArr, int i10) {
        int i11;
        byte b10;
        int i12 = bArr[5] & 255;
        if (i10 == 0) {
            b10 = bArr[8];
        } else if (i10 == 1) {
            b10 = bArr[9];
        } else if (i10 == 2) {
            b10 = bArr[13];
        } else if (i10 != 3) {
            i11 = 0;
            return (i12 * 60) + i11;
        } else {
            b10 = bArr[14];
        }
        i11 = b10 & 255;
        return (i12 * 60) + i11;
    }

    private String d(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, i10);
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).format(calendar.getTime());
    }

    private String e(String str) {
        int length = str.length() / 2;
        String str2 = "";
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            str2 = str2 + String.valueOf((char) m(str.substring(i11, i11 + 2)));
        }
        return str2;
    }

    private void f(StringBuilder sb2, byte[] bArr) {
        if (sb2.toString().equals(this.f26146l)) {
            o();
            k kVar = this.f26160z;
            if (kVar != null) {
                kVar.a();
                u.d("CRC", "sync sleep data is OK");
            }
            u.d("CRC", "CRC 不校准");
        } else if ((bArr[2] & 255) == (this.f26148n & 255)) {
            o();
            k kVar2 = this.f26160z;
            if (kVar2 != null) {
                kVar2.a();
                u.d("CRC", "sync sleep data is OK");
            }
        } else {
            u.d("CRC", "sync sleep data is faile，try again");
            this.f26153s.y0();
        }
        this.f26148n = 0;
        this.f26146l = sb2.toString();
    }

    private void g(ArrayList<w> arrayList) {
        float f10;
        int i10;
        float f11;
        float f12;
        String str;
        String str2;
        String str3;
        String str4;
        if (arrayList.size() != 0) {
            int i11 = 0;
            while (i11 < arrayList.size()) {
                w wVar = arrayList.get(i11);
                ArrayList<x> i12 = wVar.i();
                ArrayList<cn.y> j10 = wVar.j();
                ArrayList<z> k10 = wVar.k();
                String a10 = wVar.a();
                int h10 = wVar.h();
                float b10 = wVar.b();
                float c10 = wVar.c();
                int g10 = wVar.g();
                float d10 = wVar.d();
                float e10 = wVar.e();
                int f13 = wVar.f();
                int o10 = wVar.o();
                float l10 = wVar.l();
                float m10 = wVar.m();
                int n10 = wVar.n();
                u.d("step_data", "mStepOneHourArrayInfo.size() =" + i12.size());
                int i13 = i11;
                if (i12.size() != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    f11 = d10;
                    f12 = e10;
                    for (int i14 = 0; i14 < i12.size(); i14++) {
                        int a11 = i12.get(i14).a();
                        i12 = i12;
                        int b11 = i12.get(i14).b();
                        g10 = g10;
                        StringBuilder sb2 = new StringBuilder();
                        c10 = c10;
                        sb2.append("j =");
                        sb2.append(i14);
                        sb2.append(",time =");
                        sb2.append(a11);
                        sb2.append(",step =");
                        sb2.append(a11);
                        u.d("step_data", sb2.toString());
                        if (i14 != 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("[");
                        stringBuffer.append("\"" + b11 + "\"");
                        stringBuffer.append(",");
                        stringBuffer.append("\"" + a11 + "\"");
                        stringBuffer.append("]");
                        u.d("step_data", "str =" + ((Object) stringBuffer));
                    }
                    f10 = c10;
                    i10 = g10;
                    str = "[" + stringBuffer.toString() + "]";
                } else {
                    f10 = c10;
                    i10 = g10;
                    f11 = d10;
                    f12 = e10;
                    str = "";
                }
                if (j10.size() != 0) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i15 = 0; i15 < j10.size(); i15++) {
                        int e11 = j10.get(i15).e();
                        int c11 = j10.get(i15).c();
                        int d11 = j10.get(i15).d();
                        int a12 = j10.get(i15).a();
                        j10 = j10;
                        int b12 = j10.get(i15).b();
                        if (i15 != 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("[");
                        str = str;
                        stringBuffer2.append("\"" + e11 + "\"");
                        stringBuffer2.append(",");
                        stringBuffer2.append("\"" + d11 + "\"");
                        stringBuffer2.append(",");
                        stringBuffer2.append("\"" + a12 + "\"");
                        stringBuffer2.append(",");
                        stringBuffer2.append("\"" + b12 + "\"");
                        stringBuffer2.append(",");
                        stringBuffer2.append("\"" + c11 + "\"");
                        stringBuffer2.append("]");
                    }
                    str2 = str;
                    str3 = "[" + stringBuffer2.toString() + "]";
                } else {
                    str2 = str;
                    str3 = "";
                }
                if (k10.size() != 0) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    for (int i16 = 0; i16 < k10.size(); i16++) {
                        int c12 = k10.get(i16).c();
                        int e12 = k10.get(i16).e();
                        int b13 = k10.get(i16).b();
                        int a13 = k10.get(i16).a();
                        int d12 = k10.get(i16).d();
                        if (i16 != 0) {
                            stringBuffer3.append(",");
                        }
                        stringBuffer3.append("[");
                        k10 = k10;
                        stringBuffer3.append("\"" + c12 + "\"");
                        stringBuffer3.append(",");
                        stringBuffer3.append("\"" + b13 + "\"");
                        stringBuffer3.append(",");
                        stringBuffer3.append("\"" + a13 + "\"");
                        stringBuffer3.append(",");
                        stringBuffer3.append("\"" + d12 + "\"");
                        stringBuffer3.append(",");
                        stringBuffer3.append("\"" + e12 + "\"");
                        stringBuffer3.append("]");
                    }
                    str4 = "[" + stringBuffer3.toString() + "]";
                } else {
                    str4 = "";
                }
                if (h10 > 0) {
                    this.f26152r.D(a10, h10, b10, f10, str2, i10, f11, f12, f13, str3, o10, l10, m10, n10, str4);
                }
                i11 = i13 + 1;
            }
        }
    }

    private int h() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    private int i(byte[] bArr) {
        return ((bArr[6] << 8) & 65280) | (bArr[7] & 255);
    }

    private String j(String str) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - 1);
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).format(calendar.getTime());
    }

    private int m(String str) {
        int length;
        String upperCase = str.toUpperCase();
        int i10 = 0;
        for (int length2 = upperCase.length(); length2 > 0; length2--) {
            char charAt = upperCase.charAt(length2 - 1);
            i10 = (int) (i10 + (Math.pow(16.0d, length - length2) * ((charAt < '0' || charAt > '9') ? charAt - '7' : charAt - '0')));
        }
        return i10;
    }

    private String n(byte[] bArr) {
        int i10 = bArr[4] & 255;
        int i11 = bArr[3] & 255;
        int i12 = (bArr[2] & 255) | ((bArr[1] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return String.valueOf(i12) + valueOf2 + valueOf;
    }

    private void o() {
        ArrayList<g> o10 = this.f26156v.o();
        t.a("sleep_data", "mSleepDataAfterOrder.size()=" + o10.size());
        if (o10.size() != 0) {
            String str = "";
            for (int i10 = 0; i10 < o10.size(); i10++) {
                ArrayList<m> d10 = o10.get(i10).d();
                if (d10.size() != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int i11 = 0;
                    int i12 = 0;
                    for (int i13 = 0; i13 < d10.size(); i13++) {
                        str = d10.get(i13).a();
                        int e10 = d10.get(i13).e();
                        int b10 = d10.get(i13).b();
                        int d11 = d10.get(i13).d();
                        int i14 = e10 > b10 ? (b10 + 1440) - e10 : b10 - e10;
                        if (i14 >= 0) {
                            i11 += i14;
                        }
                        if (d11 <= 13) {
                            i12 = this.f26137c[0];
                        } else if (d11 <= 62) {
                            i12 = this.f26137c[1];
                        } else if (d11 > 62) {
                            i12 = this.f26137c[2];
                        }
                        if (i13 != 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("[");
                        stringBuffer.append("\"" + e10 + "\"");
                        stringBuffer.append(",");
                        stringBuffer.append("\"" + b10 + "\"");
                        stringBuffer.append(",");
                        stringBuffer.append("\"" + i12 + "\"");
                        stringBuffer.append("]");
                        d10.size();
                    }
                    this.f26152r.A(str, i11, "[" + stringBuffer.toString() + "]");
                }
            }
        }
    }

    private int r(byte[] bArr) {
        return ((bArr[5] & 255) * 60) + (bArr[6] & 255);
    }

    private int s(byte[] bArr) {
        return bArr[3] & 255;
    }

    private int t(byte[] bArr) {
        return bArr[4] & 255;
    }

    private int u(byte[] bArr) {
        return bArr[3] & 255;
    }

    public static c y(Context context) {
        if (f26134a0 == null) {
            f26134a0 = new c(context);
        }
        return f26134a0;
    }

    public void L(byte[] bArr) {
        boolean z10;
        int i10 = bArr[8] & 255;
        int i11 = bArr[9] & 255;
        int i12 = bArr[10] & 255;
        if (i10 != this.X) {
            this.X = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 != this.Y) {
            this.Y = i11;
            z10 = true;
        }
        if (i12 != this.Z) {
            this.Z = i12;
            z10 = true;
        }
        u.d("SyncParameterUtils", "max=" + i10 + ",min=" + i11 + ",average=" + i12 + ",isChange=" + z10);
        i iVar = this.f26159y;
        if (iVar != null && i10 > 40 && i10 < 200) {
            iVar.a(i10, i11, i12, true);
        }
    }

    public void M(byte[] bArr) {
        String n10 = n(bArr);
        int i10 = bArr[5] & 255;
        if (i10 == 0) {
            i10 = 24;
            n10 = j(n10);
        }
        int i11 = i10 * 60;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            if (i12 >= 6) {
                int i13 = i11 - (((12 - i12) + 5) * 10);
                int i14 = bArr[i12] & 255;
                u.d("stringBuilder", "24小时心率，calendar = " + n10 + ",hour=" + i10 + ",time=" + i13 + ",rate=" + i14);
                if (i14 > 40 && i14 < 200) {
                    this.f26152r.o(n10, i13, i14);
                }
            }
        }
    }

    public void N(byte[] bArr) {
        int i10 = bArr[5] & 255;
        int i11 = bArr[4] & 255;
        int i12 = ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        String str = String.valueOf(i12) + valueOf2 + valueOf;
        int i13 = bArr[6] & 255;
        if (i13 == 0) {
            i13 = 24;
            str = j(str);
        }
        int i14 = (i13 * 60) + (bArr[7] & 255);
        int i15 = bArr[8] & 255;
        if (i15 > 40 && i15 < 200) {
            this.f26152r.o(str, i14, i15);
        }
    }

    public void O(byte[] bArr) {
        String n10 = n(bArr);
        int r10 = r(bArr);
        int i10 = bArr[7] & 255;
        this.f26150p.getString("last_rate_calendar_sp", "20100101");
        if (i10 > 0) {
            this.f26152r.q(n10, r10, i10);
        }
        this.f26151q.putString("last_rate_calendar_sp", n10);
        this.f26151q.commit();
    }

    public void P(byte[] bArr) {
        h hVar;
        boolean a02 = a0(bArr);
        u.d("DataProcessing", "isRate=" + a02);
        if (a02) {
            int u10 = u(bArr);
            boolean b02 = b0(bArr);
            if (u10 != 0) {
                int i10 = 0;
                if (b02) {
                    this.f26152r.q(d(0), h(), u10);
                    hVar = this.f26158x;
                    if (hVar != null) {
                        i10 = 1;
                    } else {
                        return;
                    }
                } else {
                    hVar = this.f26158x;
                    if (hVar == null) {
                        return;
                    }
                }
                hVar.a(u10, i10);
            }
        }
    }

    public void Q(byte[] bArr, String str) {
        String n10 = n(bArr);
        int H = H(bArr);
        int G = G(bArr);
        int A = A(bArr);
        this.f26152r.y(n10, H, G, A, 0.0f, this.f26154t.e(A), 0.0f);
    }

    public void S(h hVar) {
        this.f26158x = hVar;
    }

    public void T(byte[] bArr, String str) {
        String n10 = n(bArr);
        int H = H(bArr);
        int G = G(bArr);
        int I = I(bArr);
        int F = F(bArr);
        this.f26152r.z(n10, H, G, I, F, this.f26154t.f(I, F));
    }

    public void U(byte[] bArr, String str, StringBuilder sb2, boolean z10) {
        int i10;
        String str2;
        int i11;
        int i12;
        int i13;
        byte[] bArr2 = bArr;
        if (str.equals("B3FD")) {
            this.f26156v.r();
            this.f26149o++;
            u.a("CRC", "syncCount =" + this.f26149o);
            if (this.f26149o >= 3) {
                o();
                k kVar = this.f26160z;
                if (kVar != null) {
                    kVar.a();
                    return;
                }
                return;
            }
            f(sb2, bArr2);
            return;
        }
        String n10 = n(bArr);
        u.d("DataProcessing", "data.length=" + bArr2.length + ",isSupportSleepOneHourMerge =" + z10);
        String str3 = "sleep_data";
        if (!z10 || bArr2.length != 14) {
            int r10 = r(bArr);
            int i14 = (bArr[8] & 255) | ((bArr[7] << 8) & 65280);
            t.a(str3, "mCalendar =" + n10 + ",lastCalendarB3 =" + this.f26143i + ",time=" + r10 + "," + (r10 / 60) + ":" + (r10 % 60) + ",mSleepRollCountSection =" + i14);
            if (!sb2.toString().equals(this.f26146l)) {
                this.f26148n = (bArr[8] ^ bArr[7]) ^ this.f26148n;
            }
            this.f26146l = sb2.toString();
            if (n10.length() <= 2 || !n10.substring(0, 3).equals(Constant.DEFAULT_CVN2)) {
                i10 = r10;
                this.f26156v.n(n10, r10, i14, this.f26143i, this.f26141g);
            } else {
                return;
            }
        } else {
            int i15 = 4;
            if (!sb2.toString().equals(this.f26146l)) {
                this.f26148n ^= (((((((((((bArr2[1] ^ bArr2[2]) ^ bArr2[3]) ^ bArr2[4]) ^ bArr2[5]) ^ bArr2[6]) ^ bArr2[7]) ^ bArr2[8]) ^ bArr2[9]) ^ bArr2[10]) ^ bArr2[11]) ^ bArr2[12]) ^ bArr2[13];
            }
            this.f26146l = sb2.toString();
            if (n10.length() <= 2 || !n10.substring(0, 3).equals(Constant.DEFAULT_CVN2)) {
                int i16 = 0;
                int i17 = 0;
                while (i16 < i15) {
                    int i18 = i16 * 2;
                    int i19 = bArr2[i18 + 7] & 255;
                    int i20 = bArr2[i18 + 6] & 255;
                    if (i20 == 255 && i19 == 255) {
                        i11 = i15;
                        str2 = str3;
                        i13 = i17;
                        i12 = i16;
                    } else {
                        int i21 = bArr2[5] & 255;
                        i13 = (i21 * 60) + i20;
                        u.d(str3, "mCalendar =" + n10 + ",lastCalendarB3 =" + this.f26143i + ",time=" + i13 + "," + i21 + ":" + i20 + ",mSleepRollCountSection =" + i19 + ",lastTimeB3 =" + this.f26141g);
                        str2 = str3;
                        i11 = 4;
                        i12 = i16;
                        this.f26156v.n(n10, i13, i19, this.f26143i, this.f26141g);
                        this.f26141g = i13;
                        this.f26143i = n10;
                    }
                    i16 = i12 + 1;
                    i17 = i13;
                    i15 = i11;
                    str3 = str2;
                    bArr2 = bArr;
                }
                i10 = i17;
            } else {
                return;
            }
        }
        this.f26143i = n10;
        this.f26141g = i10;
    }

    public void V(byte[] bArr) {
        String n10 = n(bArr);
        int H = H(bArr);
        int G = G(bArr);
        int A = A(bArr);
        int E = E(bArr);
        int D = D(bArr);
        u.a("stringBuilder", "球类calendar =" + n10 + ",startTime =" + H + ",endTime =" + G + ",useTime =" + A + ",calories =" + E + ",sportsMode =" + D);
        this.f26152r.r(n10, H, G, A, E, D);
    }

    public void W(byte[] bArr, String str, StringBuilder sb2, boolean z10) {
        float f10;
        float f11;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        String str2;
        int i23;
        int i24;
        int i25;
        float f12;
        float f13;
        int i26;
        int i27;
        u.a("test", "正在同步计步数据isSupportRunning =" + z10);
        if (!str.equals("B2FD")) {
            String n10 = n(bArr);
            int b10 = b(bArr);
            int i28 = i(bArr);
            if (z10) {
                i14 = c(bArr, 0);
                i13 = c(bArr, 1);
                i12 = B(bArr);
                i15 = C(bArr);
                i11 = c(bArr, 2);
                i10 = c(bArr, 3);
                i16 = J(bArr);
                i17 = K(bArr);
            } else {
                i17 = 0;
                i16 = 0;
                i15 = 0;
                i14 = 0;
                i13 = 0;
                i12 = 0;
                i11 = 0;
                i10 = 0;
            }
            u.d("step_data", "mCalendar = " + n10 + ",currentHour =" + b10 + ",currentHourStep =" + i28 + ",startRunTime =" + (i14 / 60) + "：" + (i14 % 60) + ",endRunTime =" + (i13 / 60) + "：" + (i13 % 60) + ",runDurationTime =" + i12 + ",runSteps =" + i15 + ",startWalkTime =" + (i11 / 60) + "：" + (i11 % 60) + ",endWalkTime =" + (i10 / 60) + "：" + (i10 % 60) + ",walkDurationTime =" + i16 + ",walkSteps =" + i17);
            this.f26146l = sb2.toString();
            if (n10.length() <= 2 || !n10.substring(0, 3).equals(Constant.DEFAULT_CVN2)) {
                this.f26145k = n10;
                int i29 = (b10 + 1) * 60;
                x xVar = new x(i29, i28);
                int i30 = i16;
                int i31 = i15;
                int i32 = i12;
                cn.y yVar = new cn.y(i29, i14, i13, i12, i31);
                z zVar = new z(i29, i11, i10, i30, i17);
                if (n10.equals(this.f26140f)) {
                    if (this.f26142h != b10) {
                        this.f26144j += i28;
                        i23 = i31;
                        this.C += i23;
                        i24 = i32;
                        this.D += i24;
                        this.E += i17;
                        this.F += i30;
                        this.S.add(xVar);
                        this.T.add(yVar);
                        this.U.add(zVar);
                    } else {
                        i23 = i31;
                        i24 = i32;
                    }
                    str2 = n10;
                    i19 = b10;
                    i25 = i30;
                } else {
                    u.d("step_data", "不同一天 mStepOneHourArrayInfo.size() = " + this.S.size());
                    if (this.S.size() != 0) {
                        float b11 = this.f26154t.b(this.C, 1);
                        float d10 = this.f26154t.d(this.C, 1);
                        float b12 = this.f26154t.b(this.E, 0);
                        float d11 = this.f26154t.d(this.E, 0);
                        if (z10) {
                            f13 = d10 + d11;
                            f12 = b11 + b12;
                        } else {
                            f13 = this.f26154t.d(this.f26144j, 0);
                            f12 = this.f26154t.b(this.f26144j, 0);
                        }
                        i19 = b10;
                        str2 = n10;
                        i20 = i30;
                        i22 = i17;
                        i18 = i32;
                        i21 = i31;
                        this.V.add(new w(this.f26140f, this.f26144j, f12, f13, this.C, b11, d10, this.D, this.E, b12, d11, this.F, this.S, this.T, this.U));
                        u.d("step_data", "最大数组加1天的数据 lastCalendarB2=" + this.f26140f);
                        p();
                    } else {
                        i22 = i17;
                        str2 = n10;
                        i19 = b10;
                        i20 = i30;
                        i18 = i32;
                        i21 = i31;
                    }
                    u.d("step_data", "开始同步后的第一条数据或新一天的第一条数据");
                    this.S.add(xVar);
                    this.T.add(yVar);
                    this.U.add(zVar);
                    this.f26144j = i28;
                    i23 = i21;
                    this.C = i23;
                    i24 = i18;
                    this.D = i24;
                    i17 = i22;
                    this.E = i17;
                    i25 = i20;
                    this.F = i25;
                }
                String str3 = str2;
                if (str3.equals(h.c(0))) {
                    i26 = i19;
                    if (i26 >= a()) {
                        this.f26147m = this.f26144j - i28;
                        this.G = this.C - i23;
                        this.H = this.D - i24;
                        this.I = this.E - i17;
                        i27 = this.F - i25;
                    } else {
                        this.f26147m = this.f26144j;
                        this.G = this.C;
                        this.H = this.D;
                        this.I = this.E;
                        i27 = this.F;
                    }
                    this.J = i27;
                    this.f26136b = this.f26144j;
                    this.K = this.C;
                    this.L = this.D;
                    this.M = this.E;
                    this.N = this.F;
                } else {
                    i26 = i19;
                }
                u.d("step_data", "offLineOneDayWalkStepsTemp =" + this.I);
                this.f26140f = str3;
                this.f26142h = i26;
                this.f26151q.putInt("last_hour_value", i26);
            } else {
                return;
            }
        } else {
            float b13 = this.f26154t.b(this.C, 1);
            float d12 = this.f26154t.d(this.C, 1);
            float b14 = this.f26154t.b(this.E, 0);
            float d13 = this.f26154t.d(this.E, 0);
            if (z10) {
                f11 = d12 + d13;
                f10 = b13 + b14;
            } else {
                f11 = this.f26154t.d(this.f26144j, 0);
                f10 = this.f26154t.b(this.f26144j, 0);
                u.a("stringBuilder", "今天的卡路里到1 calories =" + f10);
            }
            if (this.f26140f.equals(h.c(0))) {
                this.f26151q.putInt("steps", this.f26144j);
                this.f26151q.putFloat("distance", f11);
                this.f26151q.putFloat("calories", f10);
                this.f26151q.commit();
                int i33 = this.f26144j;
                int i34 = this.C;
                float b15 = this.f26154t.b(i34, 1);
                float d14 = this.f26154t.d(this.C, 1);
                int i35 = this.D;
                int i36 = this.E;
                w wVar = new w(i33, f10, f11, i34, b15, d14, i35, i36, this.f26154t.b(i36, 0), this.f26154t.d(this.E, 0), this.F);
                n nVar = this.f26155u;
                if (nVar != null) {
                    nVar.a(wVar);
                }
            }
            w wVar2 = new w(this.f26140f, this.f26144j, f10, f11, this.C, b13, d12, this.D, this.E, b14, d13, this.F, this.S, this.T, this.U);
            this.V.add(wVar2);
            u.d("step_data", "同步完成,最大数组加一天 lastCalendarB2 =" + this.f26140f + "，mStepOneHourArrayInfo.size() =" + this.S.size());
            this.W = new ArrayList<>();
            if (this.f26140f.equals(h.c(0))) {
                this.W.add(wVar2);
            }
            p();
            g(this.V);
            q();
            this.f26144j = 0;
            this.C = 0;
            this.D = 0;
            this.E = 0;
            this.F = 0;
            this.f26140f = "";
            this.f26151q.putString("b2fd_calendar_sp", this.f26145k);
        }
        this.f26151q.commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X(byte[] bArr, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        String str;
        String str2;
        String str3;
        float f15;
        float f16;
        w wVar;
        int i18;
        n nVar;
        int i19;
        String n10 = n(bArr);
        if (n10.length() <= 2 || !n10.substring(0, 3).equals(Constant.DEFAULT_CVN2)) {
            u.d("BleData", "mStepCount =" + this.f26136b);
            int b10 = b(bArr);
            int i20 = i(bArr);
            this.f26151q.putString("ble_step_calendar", n10);
            this.f26151q.commit();
            int i21 = this.f26150p.getInt("last_hour_value", 0);
            if (!z10 || bArr.length != 18) {
                i17 = 0;
                i16 = 0;
                i15 = 0;
                i14 = 0;
                i13 = 0;
                i12 = 0;
                i11 = 0;
                i10 = 0;
            } else {
                i11 = c(bArr, 0);
                i10 = c(bArr, 1);
                i13 = B(bArr);
                i12 = C(bArr);
                i15 = c(bArr, 2);
                i14 = c(bArr, 3);
                i16 = J(bArr);
                i17 = K(bArr);
            }
            u.d("step_data", "mCalendar = " + n10 + ",lastHour =" + i21 + ",currentHour =" + b10 + ",currentHourStep =" + i20 + ",startRunTime =" + (i11 / 60) + "：" + (i11 % 60) + ",endRunTime =" + (i10 / 60) + "：" + (i10 % 60) + ",runDurationTime =" + i13 + ",runSteps =" + i12 + ",startWalkTime =" + (i15 / 60) + "：" + (i15 % 60) + ",endWalkTime =" + (i14 / 60) + "：" + (i14 % 60) + ",walkDurationTime =" + i16 + ",walkSteps =" + i17);
            int i22 = (b10 + 1) * 60;
            x xVar = new x(i22, i20);
            cn.y yVar = new cn.y(i22, i11, i10, i13, i12);
            z zVar = new z(i22, i15, i14, i16, i17);
            if (this.W == null) {
                this.W = new ArrayList<>();
            }
            if (this.W.size() > 0) {
                int size = this.W.size() - 1;
                this.S = this.W.get(size).i();
                this.T = this.W.get(size).j();
                this.U = this.W.get(size).k();
                if (this.S.size() > 0 && b10 == i21) {
                    int size2 = this.S.size() - 1;
                    this.S.set(size2, xVar);
                    this.T.set(size2, yVar);
                    this.U.set(size2, zVar);
                    if (this.f26139e.equals("")) {
                        if (n10.equals(this.f26139e) && b10 != i21) {
                            this.f26147m += this.f26138d;
                            this.G += this.O;
                            this.H += this.P;
                            this.I += this.Q;
                            i19 = this.J + this.R;
                            this.J = i19;
                        }
                        this.f26138d = i20;
                        this.O = i12;
                        this.P = i13;
                        this.Q = i17;
                        this.R = i16;
                        this.f26151q.putInt("last_hour_step", i20);
                        this.f26151q.putInt("last_hour_value", b10);
                        this.f26151q.commit();
                        u.d("step_data", "tempSteps =" + this.f26147m + ",currentHourStep =" + i20);
                        int i23 = this.f26147m + i20;
                        this.f26136b = i23;
                        int i24 = this.G + i12;
                        this.K = i24;
                        this.L = this.H + i13;
                        this.M = this.I + i17;
                        this.N = this.J + i16;
                        float f17 = 0.0f;
                        if (!z10) {
                            float d10 = this.f26154t.d(i24, 1);
                            float b11 = this.f26154t.b(this.K, 1);
                            float d11 = this.f26154t.d(this.M, 0);
                            float b12 = this.f26154t.b(this.M, 0);
                            f14 = d10 + d11;
                            f13 = b11 + b12;
                            f12 = d10;
                            f17 = b11;
                            f10 = d11;
                            f11 = b12;
                        } else {
                            f14 = this.f26154t.d(i23, 0);
                            f13 = this.f26154t.b(this.f26136b, 0);
                            f12 = 0.0f;
                            f11 = 0.0f;
                            f10 = 0.0f;
                        }
                        float f18 = f14;
                        float f19 = f13;
                        if (b10 != 0) {
                            wVar = new w(this.f26139e, this.f26136b, f19, f18, this.K, f17, f12, this.L, this.M, f11, f10, this.N, this.S, this.T, this.U);
                            f16 = f19;
                            f15 = f18;
                            str2 = "step_data";
                            str = n10;
                            str3 = "mStepCount =";
                        } else {
                            f16 = f19;
                            f15 = f18;
                            str2 = "step_data";
                            str3 = "mStepCount =";
                            str = n10;
                            wVar = new w(n10, this.f26136b, f19, f18, this.K, f17, f12, this.L, this.M, f11, f10, this.N, this.S, this.T, this.U);
                        }
                        if (this.W.size() <= 0) {
                            ArrayList<w> arrayList = this.W;
                            i18 = 1;
                            arrayList.set(arrayList.size() - 1, wVar);
                        } else {
                            i18 = 1;
                            this.W.add(wVar);
                        }
                        u.d(str2, "实时数据，来一条存一条，currentWalkSteps =" + this.M);
                        g(this.W);
                        this.f26139e = str;
                        this.f26151q.putInt("steps", this.f26136b);
                        float f20 = f15;
                        this.f26151q.putFloat("distance", f20);
                        float f21 = f16;
                        this.f26151q.putFloat("calories", f21);
                        this.f26151q.commit();
                        int i25 = this.f26136b;
                        int i26 = this.K;
                        float b13 = this.f26154t.b(i26, i18);
                        float d12 = this.f26154t.d(this.K, i18);
                        int i27 = this.L;
                        int i28 = this.M;
                        w wVar2 = new w(i25, f21, f20, i26, b13, d12, i27, i28, this.f26154t.b(i28, 0), this.f26154t.d(this.M, 0), this.N);
                        nVar = this.f26155u;
                        if (nVar != null) {
                            nVar.a(wVar2);
                        }
                        u.d("onStepHandler", str3 + this.f26136b);
                        return;
                    }
                    if (i21 != b10) {
                        this.f26147m = this.f26136b;
                        this.G = this.K;
                        this.H = this.L;
                        this.I = this.M;
                        i19 = this.N;
                        this.J = i19;
                    }
                    this.f26138d = i20;
                    this.O = i12;
                    this.P = i13;
                    this.Q = i17;
                    this.R = i16;
                    this.f26151q.putInt("last_hour_step", i20);
                    this.f26151q.putInt("last_hour_value", b10);
                    this.f26151q.commit();
                    u.d("step_data", "tempSteps =" + this.f26147m + ",currentHourStep =" + i20);
                    int i232 = this.f26147m + i20;
                    this.f26136b = i232;
                    int i242 = this.G + i12;
                    this.K = i242;
                    this.L = this.H + i13;
                    this.M = this.I + i17;
                    this.N = this.J + i16;
                    float f172 = 0.0f;
                    if (!z10) {
                    }
                    float f182 = f14;
                    float f192 = f13;
                    if (b10 != 0) {
                    }
                    if (this.W.size() <= 0) {
                    }
                    u.d(str2, "实时数据，来一条存一条，currentWalkSteps =" + this.M);
                    g(this.W);
                    this.f26139e = str;
                    this.f26151q.putInt("steps", this.f26136b);
                    float f202 = f15;
                    this.f26151q.putFloat("distance", f202);
                    float f212 = f16;
                    this.f26151q.putFloat("calories", f212);
                    this.f26151q.commit();
                    int i252 = this.f26136b;
                    int i262 = this.K;
                    float b132 = this.f26154t.b(i262, i18);
                    float d122 = this.f26154t.d(this.K, i18);
                    int i272 = this.L;
                    int i282 = this.M;
                    w wVar22 = new w(i252, f212, f202, i262, b132, d122, i272, i282, this.f26154t.b(i282, 0), this.f26154t.d(this.M, 0), this.N);
                    nVar = this.f26155u;
                    if (nVar != null) {
                    }
                    u.d("onStepHandler", str3 + this.f26136b);
                    return;
                }
            }
            this.S.add(xVar);
            this.T.add(yVar);
            this.U.add(zVar);
            if (this.f26139e.equals("")) {
            }
        }
    }

    public void Y(byte[] bArr, String str) {
        String n10 = n(bArr);
        int H = H(bArr);
        int G = G(bArr);
        int I = I(bArr);
        int F = F(bArr);
        this.f26152r.E(n10, H, G, I, F, this.f26154t.g(I, F));
    }

    public void k(byte[] bArr) {
        String n10 = n(bArr);
        this.f26152r.s(n10, r(bArr), bArr[7] & 255, bArr[8] & 255);
        this.f26151q.putString("last_blood_pressure_calendar_sp", n10);
        this.f26151q.commit();
    }

    public void l(byte[] bArr) {
        a aVar;
        int i10;
        if (Z(bArr)) {
            int s10 = s(bArr);
            int t10 = t(bArr);
            if (R(bArr)) {
                this.f26152r.s(d(0), h(), s10, t10);
                aVar = this.f26157w;
                if (aVar != null) {
                    i10 = 4;
                } else {
                    return;
                }
            } else {
                aVar = this.f26157w;
                if (aVar != null) {
                    i10 = 3;
                } else {
                    return;
                }
            }
            aVar.a(s10, t10, i10);
        }
    }

    public void p() {
        this.S = new ArrayList<>();
        this.T = new ArrayList<>();
        this.U = new ArrayList<>();
    }

    public void q() {
        this.V = new ArrayList<>();
    }

    public int v(byte[] bArr) {
        int i10 = bArr[1] & 255;
        this.A = i10;
        int min = Math.min(i10, 100);
        this.A = min;
        return min;
    }

    public boolean w(byte[] bArr) {
        boolean z10 = true;
        int i10 = bArr[1] & 255;
        int i11 = bArr[2] & 255;
        if (i10 == 16) {
            this.f26151q.putBoolean("ble_step_status", true);
            this.f26151q.putBoolean("ble_sleep_status", false);
            this.f26151q.putBoolean("step_mode", true);
        } else if (i11 == 16) {
            this.f26151q.putBoolean("ble_step_status", false);
            this.f26151q.putBoolean("ble_sleep_status", true);
            this.f26151q.putBoolean("step_mode", false);
            z10 = false;
        } else {
            this.f26151q.putBoolean("ble_step_status", false);
            this.f26151q.putBoolean("ble_sleep_status", false);
        }
        this.f26151q.commit();
        return z10;
    }

    public String x(String str) {
        String str2;
        this.B = e(str.substring(2, str.length()));
        gn.z.v(this.f26135a).v0(this.B);
        boolean z10 = false;
        q.f27596o = false;
        if (!this.B.contains("V") || this.B.length() <= 2) {
            str2 = null;
        } else {
            String str3 = this.B;
            str2 = str3.substring(0, str3.indexOf("V"));
        }
        if (str2 != null && str2.length() > 0) {
            if (str2.contains("DB") || str2.contains("DH") || str2.contains("DM")) {
                z10 = true;
            }
            q.f27596o = z10;
        }
        return this.B;
    }

    public int z(byte[] bArr) {
        if (bArr.length != 3) {
            return 0;
        }
        int i10 = bArr[2] & 255;
        this.f26151q.putInt("uv_value_sp", i10);
        this.f26151q.commit();
        return i10;
    }
}
