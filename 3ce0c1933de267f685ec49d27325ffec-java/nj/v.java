package nj;

import cn.n;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.WeatherInfo;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import v9.a;
import v9.b;
import v9.c;
import yh.d;
/* compiled from: UTEManager.kt */
/* loaded from: classes2.dex */
public final class v {
    public static final String a(u uVar, String weather) {
        i.f(uVar, "<this>");
        i.f(weather, "weather");
        return uVar.M().get(weather);
    }

    public static final void b(u uVar, n weather) {
        i.f(uVar, "<this>");
        i.f(weather, "weather");
        f.M(uVar, weather);
    }

    public static final void c(d weather, b location) {
        i.f(weather, "weather");
        i.f(location, "location");
        if (q.g().l() == 5) {
            d(weather, location);
        } else {
            f(weather, location);
        }
    }

    private static final void d(d dVar, b bVar) {
        List<a> C;
        int p10;
        a[] aVarArr = dVar.dayWeathers;
        i.e(aVarArr, "weather.dayWeathers");
        C = kotlin.collections.i.C(aVarArr, 4);
        p10 = kotlin.collections.n.p(C, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (a aVar : C) {
            String j10 = aVar.j();
            i.e(j10, "it.weatherDesc");
            String i10 = aVar.i();
            i.e(i10, "it.weatherCondition");
            long e10 = aVar.e();
            String str = dVar.mCurrentTemp;
            i.e(str, "weather.mCurrentTemp");
            int parseInt = Integer.parseInt(str);
            String g10 = aVar.g();
            i.e(g10, "it.minTemperature");
            int parseInt2 = Integer.parseInt(g10);
            String f10 = aVar.f();
            i.e(f10, "it.maxTemperature");
            int parseInt3 = Integer.parseInt(f10);
            String h10 = aVar.h();
            i.e(h10, "it.temperatureUnit");
            String k10 = aVar.k();
            i.e(k10, "it.weekDay");
            arrayList.add(new WeatherInfo(j10, i10, e10, parseInt, parseInt2, parseInt3, h10, k10, dVar.mLocation));
        }
        q qVar = q.f15504a;
        qVar.W(arrayList);
        c cVar = bVar.point;
        qVar.U(cVar.longitude, cVar.latitude);
    }

    public static final String[] e(a aVar) {
        i.f(aVar, "<this>");
        String[] strArr = new String[3];
        u uVar = u.f19202a;
        String weatherCondition = aVar.i();
        i.e(weatherCondition, "weatherCondition");
        strArr[0] = a(uVar, weatherCondition);
        String f10 = aVar.f();
        String str = "0";
        if (f10 == null) {
            f10 = str;
        }
        strArr[1] = f10;
        String g10 = aVar.g();
        if (g10 != null) {
            str = g10;
        }
        strArr[2] = str;
        return strArr;
    }

    private static final void f(d dVar, b bVar) {
        a[] aVarArr = dVar.dayWeathers;
        if ((aVarArr != null && aVarArr.length >= 7 ? dVar : null) != null) {
            i.e(aVarArr, "weather.dayWeathers");
            n nVar = new n();
            nVar.z(bVar.city);
            u uVar = u.f19202a;
            String str = dVar.mWeatherCondition;
            i.e(str, "weather.mWeatherCondition");
            nVar.W(a(uVar, str));
            String str2 = dVar.mCurrentTemp;
            i.e(str2, "weather.mCurrentTemp");
            nVar.T(Integer.parseInt(str2));
            String str3 = dVar.mMaxTemp;
            i.e(str3, "weather.mMaxTemp");
            nVar.U(Integer.parseInt(str3));
            String str4 = dVar.mMinTemp;
            i.e(str4, "weather.mMinTemp");
            nVar.V(Integer.parseInt(str4));
            String str5 = dVar.mAqi;
            i.e(str5, "weather.mAqi");
            nVar.S(Integer.parseInt(str5));
            String[] e10 = e(aVarArr[1]);
            nVar.I(e10[0]);
            nVar.G(Integer.parseInt(e10[1]));
            nVar.H(Integer.parseInt(e10[2]));
            String[] e11 = e(aVarArr[2]);
            nVar.R(e11[0]);
            nVar.P(Integer.parseInt(e11[1]));
            nVar.Q(Integer.parseInt(e11[2]));
            String[] e12 = e(aVarArr[3]);
            nVar.F(e12[0]);
            nVar.D(Integer.parseInt(e12[1]));
            nVar.E(Integer.parseInt(e12[2]));
            String[] e13 = e(aVarArr[4]);
            nVar.C(e13[0]);
            nVar.A(Integer.parseInt(e13[1]));
            nVar.B(Integer.parseInt(e13[2]));
            String[] e14 = e(aVarArr[5]);
            nVar.O(e14[0]);
            nVar.M(Integer.parseInt(e14[1]));
            nVar.N(Integer.parseInt(e14[2]));
            String[] e15 = e(aVarArr[6]);
            nVar.L(e15[0]);
            nVar.J(Integer.parseInt(e15[1]));
            nVar.K(Integer.parseInt(e15[2]));
            b(uVar, nVar);
        }
    }
}
