package gn;

import android.content.Context;
import android.util.Log;
import cn.h;
import cn.i;
import com.google.gson.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: d  reason: collision with root package name */
    private static l f27574d = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f27575e = 1000;

    /* renamed from: a  reason: collision with root package name */
    private h f27576a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Double> f27577b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f27578c;

    private l(Context context) {
        this.f27578c = context;
        this.f27576a = h.e(context);
    }

    public static void c(String str) {
        Log.d("EcgUtil", str);
    }

    public static void d(String str) {
        Log.i("EcgUtil", str);
    }

    private int e(byte[] bArr) {
        return bArr[10] & 255;
    }

    private int g(byte[] bArr) {
        return bArr[3] & 255;
    }

    private String h(byte[] bArr) {
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
        return String.valueOf(i12) + valueOf2 + valueOf;
    }

    private String i(byte[] bArr) {
        String h10 = h(bArr);
        int t10 = t(bArr);
        int i10 = t10 / 60;
        int i11 = t10 % 60;
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + valueOf;
        }
        if (i11 < 10) {
            valueOf2 = "0" + valueOf2;
        }
        return h10 + valueOf + valueOf2;
    }

    private int k(byte[] bArr) {
        return bArr[13] & 255;
    }

    private int l(byte[] bArr) {
        return bArr[6] & 255;
    }

    private int m(byte[] bArr) {
        return bArr[11] & 255;
    }

    public static l n(Context context) {
        if (f27574d == null) {
            f27574d = new l(context);
        }
        return f27574d;
    }

    private int o(byte[] bArr) {
        return bArr[4] & 255;
    }

    private int p(byte[] bArr) {
        return bArr[14] & 255;
    }

    private int q(byte[] bArr) {
        return bArr[7] & 255;
    }

    private int r(byte[] bArr) {
        return bArr[12] & 255;
    }

    private int s(byte[] bArr) {
        return bArr[5] & 255;
    }

    private int t(byte[] bArr) {
        return ((bArr[6] & 255) * 60) + (bArr[7] & 255);
    }

    private int u(byte[] bArr) {
        return (bArr[9] & 255) | (((bArr[8] << 8) & 65280) * 9);
    }

    private String v(byte[] bArr) {
        int i10 = bArr[4] & 255;
        int i11 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        return String.valueOf(i11) + valueOf;
    }

    public i a(byte[] bArr) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String h10 = h(bArr);
        v(bArr);
        int t10 = t(bArr);
        String i14 = i(bArr);
        int u10 = u(bArr);
        int i15 = 0;
        if (p.d(this.f27578c, 128)) {
            i13 = e(bArr);
            i12 = m(bArr);
            i11 = r(bArr);
            i10 = k(bArr);
            i15 = p(bArr);
        } else {
            i13 = this.f27576a.c();
            i12 = this.f27576a.d();
            i11 = 0;
            i10 = 0;
        }
        int size = this.f27577b.size();
        int i16 = f27575e;
        if (size > i16) {
            arrayList.addAll(this.f27577b.subList(i16, size));
        }
        this.f27576a.f();
        d("心电离线结果  ecgDataArray.zize= " + this.f27577b.size() + ",ecgDataArray2.size=" + arrayList.size());
        c("AnalysisBleEcgHistoryData3 ,calendar =" + h10 + ",calendarTime =" + i14 + ",startTime =" + t10 + ",totalCount =" + u10 + ",ecgAverageRate =" + i13 + ",ecgHRV =" + i12 + ",ecgRiskLevel =" + i11 + ",ecgFatigueIndex =" + i10 + ",ecgStrength =" + i15);
        i iVar = new i(h10, i14, t10, i13, i12, i15, i11, i10, u10, new e().s(arrayList));
        this.f27577b = new ArrayList<>();
        return iVar;
    }

    public i b(byte[] bArr) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String c10 = h.c(0);
        h.h(0);
        int f10 = h.f();
        String d10 = h.d();
        ArrayList arrayList = new ArrayList();
        if (p.d(this.f27578c, 128)) {
            i14 = g(bArr);
            i13 = o(bArr);
            i11 = s(bArr);
            i10 = l(bArr);
            i12 = q(bArr);
        } else {
            i14 = this.f27576a.c();
            i13 = this.f27576a.d();
            i12 = 0;
            i11 = 0;
            i10 = 0;
        }
        int size = this.f27577b.size();
        int i15 = f27575e;
        if (size > i15) {
            arrayList.addAll(this.f27577b.subList(i15, size));
        }
        this.f27576a.f();
        d("心电实时结果  ecgDataArray.zize= " + this.f27577b.size() + ",ecgDataArray2.size=" + arrayList.size());
        c("AnalysisBleEcgRealTimeData ,calendar =" + c10 + ",calendarTime =" + d10 + ",startTime =" + f10 + ",totalCount =0,ecgAverageRate =" + i14 + ",ecgHRV =" + i13 + ",ecgRiskLevel =" + i11 + ",ecgFatigueIndex =" + i10 + ",ecgStrength =" + i12);
        i iVar = new i(c10, d10, f10, i14, i13, i12, i11, i10, 0, new e().s(arrayList));
        this.f27577b = new ArrayList<>();
        return iVar;
    }

    public boolean f(byte[] bArr, List<i> list) {
        if (list == null) {
            return false;
        }
        String i10 = i(bArr);
        for (int i11 = 0; i11 < list.size(); i11++) {
            String c10 = list.get(i11).c();
            c("alreadySyncThisEcgData ,calendarTime =" + i10 + ",lastDate=" + c10);
            if (c10.equals(i10)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Double> j(String str) {
        ArrayList<Double> arrayList = new ArrayList<>();
        int length = str.length() / 2;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 * 2;
            i10++;
            arrayList.add(Double.valueOf(this.f27576a.b(Byte.parseByte(str.substring(i11, i10 * 2), 16), 1)));
        }
        this.f27577b.addAll(arrayList);
        return arrayList;
    }
}
