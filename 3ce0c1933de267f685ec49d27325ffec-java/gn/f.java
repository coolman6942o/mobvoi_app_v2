package gn;

import android.content.Context;
import android.util.Log;
import cn.b;
import cn.c;
import en.o;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f27544a;

    /* renamed from: b  reason: collision with root package name */
    public static int f27545b;

    private f() {
        i();
    }

    public static void c(String str) {
        Log.d("BodyUtil", str);
    }

    public static void d(String str) {
        Log.i("BodyUtilI", str);
    }

    private int e(byte[] bArr) {
        int i10 = bArr[7] & 255;
        d("bodyAge =" + i10);
        return i10;
    }

    private int f(byte[] bArr, byte[] bArr2) {
        int i10 = ((bArr[19] << 8) & 65280) | (bArr2[3] & 255);
        d("bodyBMRKg =" + i10);
        return i10;
    }

    private float g(byte[] bArr) {
        float a10 = d.b().a((bArr[16] & 255) | ((bArr[15] << 8) & 65280), 100.0f);
        d("bodyBoneSaltKg =" + a10);
        return a10;
    }

    private String h(byte[] bArr) {
        int i10 = bArr[6] & 255;
        int i11 = bArr[5] & 255;
        int i12 = (bArr[4] & 255) | ((bArr[3] << 8) & 65280);
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

    private String j(byte[] bArr) {
        String h10 = h(bArr);
        int q5 = q(bArr);
        int i10 = q5 / 60;
        int i11 = q5 % 60;
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

    private float k(byte[] bArr) {
        return (bArr[18] & 255) | ((bArr[17] << 8) & 65280);
    }

    private boolean l(byte[] bArr) {
        int i10 = bArr[8] & 255;
        boolean z10 = i10 != 0;
        d("genderInt =" + i10 + "，bodyGender =" + z10);
        return z10;
    }

    private int m(byte[] bArr) {
        int i10 = bArr[4] & 255;
        d("bodyHeightCm =" + i10);
        return i10;
    }

    public static f n() {
        if (f27544a == null) {
            f27544a = new f();
        }
        return f27544a;
    }

    private float o(byte[] bArr) {
        float a10 = d.b().a((bArr[12] & 255) | ((bArr[11] << 8) & 65280), 100.0f);
        d("bodyMuscleKg =" + a10);
        return a10;
    }

    private float p(byte[] bArr) {
        return (bArr[14] & 255) | ((bArr[13] << 8) & 65280);
    }

    private int q(byte[] bArr) {
        return ((bArr[7] & 255) * 60) + (bArr[8] & 255);
    }

    private float r(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[9] << 8) & 65280);
    }

    private float s(byte[] bArr) {
        float f10 = ((bArr[6] & 255) | ((bArr[5] << 8) & 65280)) / 100.0f;
        d("bodyWeightKg =" + f10);
        return f10;
    }

    private String t(byte[] bArr) {
        int i10 = bArr[5] & 255;
        int i11 = (bArr[4] & 255) | ((bArr[3] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        return String.valueOf(i11) + valueOf;
    }

    public void a(Context context, List<c> list) {
        int i10;
        String str;
        f fVar = this;
        List<c> list2 = list;
        int i11 = 0;
        while (i11 < list.size()) {
            byte[] a10 = list2.get(i11).a();
            byte[] b10 = list2.get(i11).b();
            if ((a10[1] & 255) != 250) {
                i10 = i11;
            } else {
                String h10 = fVar.h(a10);
                String t10 = fVar.t(a10);
                int q5 = fVar.q(a10);
                String j10 = fVar.j(a10);
                float r10 = fVar.r(a10);
                float p10 = fVar.p(a10);
                float g10 = fVar.g(a10);
                float k10 = fVar.k(a10);
                int f10 = fVar.f(a10, b10);
                float o10 = fVar.o(a10);
                int m10 = fVar.m(b10);
                float s10 = fVar.s(b10);
                int e10 = fVar.e(b10);
                boolean l10 = fVar.l(b10);
                StringBuilder sb2 = new StringBuilder();
                i10 = i11;
                sb2.append("AnalysisBleBodyTestData ,calendar =");
                sb2.append(h10);
                sb2.append(",calendarTime =");
                sb2.append(j10);
                sb2.append(",startTime =");
                sb2.append(q5);
                sb2.append(",bodyFat =");
                sb2.append(k10);
                sb2.append(",bodyWater =");
                sb2.append(r10);
                sb2.append(",bodyProtein =");
                sb2.append(p10);
                sb2.append(",bodyBMR =");
                sb2.append(f10);
                sb2.append(",bodyBoneSalt =");
                sb2.append(g10);
                sb2.append(",bodyMuscle =");
                sb2.append(o10);
                sb2.append(",bodyGender =");
                sb2.append(l10);
                sb2.append(",bodyAge =");
                sb2.append(e10);
                sb2.append(",bodyHeight =");
                sb2.append(m10);
                sb2.append(",bodyWeight =");
                sb2.append(s10);
                c(sb2.toString());
                if (s10 != 0.0f) {
                    d b11 = d.b();
                    float a11 = b11.a(k10, s10);
                    float a12 = b11.a(r10, s10);
                    float a13 = b11.a(p10, s10);
                    c("AnalysisBleBodyHistoryData ,除以体重calendar =" + h10 + ",calendarTime =" + j10 + ",startTime =" + q5 + ",bodyFat =" + a11 + ",bodyWater =" + a12 + ",bodyProtein =" + a13 + ",bodyBMR =" + f10 + ",bodyBoneSalt =" + g10 + ",bodyMuscle =" + o10 + ",bodyGender =" + l10 + ",bodyAge =" + e10 + ",bodyHeight =" + m10 + ",bodyWeight =" + s10);
                    if (a12 == 0.0f && a13 == 0.0f && g10 == 0.0f && a11 == 0.0f && f10 == 0 && o10 == 0.0f) {
                        str = "AnalysisBleBodyHistoryData ,五项全部为0，不保存数据";
                    } else if (a11 >= 100.0f || a12 >= 100.0f || a13 >= 100.0f || g10 >= s10 || o10 >= s10) {
                        str = "AnalysisBleBodyHistoryData ,脂肪水分蛋白质任何一个，百分比大于等于1，不保存数据;骨盐量，肌肉量大于等于体重，不保存数据";
                    } else {
                        o.b(context).t(h10, j10, t10, q5, a11, a12, a13, f10, g10, o10, l10, e10, m10, s10);
                    }
                    c(str);
                }
            }
            i11 = i10 + 1;
            fVar = this;
            list2 = list;
        }
    }

    public b b(Context context, byte[] bArr, byte[] bArr2) {
        boolean z10;
        String str;
        String str2;
        if ((bArr[1] & 255) != 0) {
            str = "";
        } else {
            String h10 = h(bArr);
            String t10 = t(bArr);
            int q5 = q(bArr);
            String j10 = j(bArr);
            float r10 = r(bArr);
            float p10 = p(bArr);
            float g10 = g(bArr);
            float k10 = k(bArr);
            int f10 = f(bArr, bArr2);
            float o10 = o(bArr);
            int m10 = m(bArr2);
            float s10 = s(bArr2);
            int e10 = e(bArr2);
            boolean l10 = l(bArr2);
            c("AnalysisBleBodyTestData ,calendar =" + h10 + ",calendarTime =" + j10 + ",startTime =" + q5 + ",bodyFat =" + k10 + ",bodyWater =" + r10 + ",bodyProtein =" + p10 + ",bodyBMR =" + f10 + ",bodyBoneSalt =" + g10 + ",bodyMuscle =" + o10 + ",bodyGender =" + l10 + ",bodyAge =" + e10 + ",bodyHeight =" + m10 + ",bodyWeight =" + s10);
            if (s10 != 0.0f) {
                d b10 = d.b();
                float a10 = b10.a(k10, s10);
                float a11 = b10.a(r10, s10);
                float a12 = b10.a(p10, s10);
                c("AnalysisBleBodyTestData ,除以体重calendar =" + h10 + ",calendarTime =" + j10 + ",startTime =" + q5 + ",bodyFat =" + a10 + ",bodyWater =" + a11 + ",bodyProtein =" + a12 + ",bodyBMR =" + f10 + ",bodyBoneSalt =" + g10 + ",bodyMuscle =" + o10 + ",bodyGender =" + l10 + ",bodyAge =" + e10 + ",bodyHeight =" + m10 + ",bodyWeight =" + s10);
                if (a11 == 0.0f && a12 == 0.0f && g10 == 0.0f && a10 == 0.0f && f10 == 0 && o10 == 0.0f) {
                    str2 = "AnalysisBleBodyTestData ,五项全部为0，不保存数据";
                } else if (a10 >= 100.0f || a11 >= 100.0f || a12 >= 100.0f || g10 >= s10 || o10 >= s10) {
                    str2 = "AnalysisBleBodyTestData ,脂肪水分蛋白质任何一个，百分比大于等于1，不保存数据;骨盐量，肌肉量大于等于体重，不保存数据";
                } else {
                    o.b(context).t(h10, j10, t10, q5, a10, a11, a12, f10, g10, o10, l10, e10, m10, s10);
                    str = j10;
                    z10 = true;
                    b bVar = new b();
                    bVar.e(z10);
                    bVar.f(str);
                    return bVar;
                }
                c(str2);
                str = j10;
                z10 = true;
                b bVar2 = new b();
                bVar2.e(z10);
                bVar2.f(str);
                return bVar2;
            }
            str = j10;
        }
        z10 = false;
        b bVar22 = new b();
        bVar22.e(z10);
        bVar22.f(str);
        return bVar22;
    }

    public int i() {
        String locale = Locale.getDefault().toString();
        f27545b = (locale.contains("zh_CN") || locale.contains("zh_TW") || locale.contains("zh_MO") || locale.contains("zh_HK")) ? 0 : 1;
        c("countryStatus COUNTRY =" + f27545b);
        return f27545b;
    }
}
