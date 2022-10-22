package v9;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
import yh.d;
/* compiled from: DayWeather.java */
/* loaded from: classes2.dex */
public class a {
    @c(ContactConstant.CallsRecordKeys.DATE)

    /* renamed from: a  reason: collision with root package name */
    private String f35681a;
    @c("dateTime")

    /* renamed from: b  reason: collision with root package name */
    private long f35682b;
    @c("weekDay")

    /* renamed from: c  reason: collision with root package name */
    private String f35683c;
    @c("currentTemp")

    /* renamed from: d  reason: collision with root package name */
    private String f35684d;
    @c("unit")

    /* renamed from: e  reason: collision with root package name */
    private String f35685e;
    @c("minTemp")

    /* renamed from: f  reason: collision with root package name */
    private String f35686f;
    @c("maxTemp")

    /* renamed from: g  reason: collision with root package name */
    private String f35687g;
    @c("weatherBg")

    /* renamed from: h  reason: collision with root package name */
    private String f35688h;
    @c(d.TYPE)

    /* renamed from: i  reason: collision with root package name */
    private String f35689i;
    @c("windDir")

    /* renamed from: j  reason: collision with root package name */
    private String f35690j;
    @c("wind")

    /* renamed from: k  reason: collision with root package name */
    private String f35691k;
    @c("windSpeed")

    /* renamed from: l  reason: collision with root package name */
    private String f35692l;
    @c("weatherNight")

    /* renamed from: m  reason: collision with root package name */
    private String f35693m;
    @c("aqi")

    /* renamed from: n  reason: collision with root package name */
    private String f35694n;
    @c(PermissionConstant.Columns.STATUS)

    /* renamed from: o  reason: collision with root package name */
    private String f35695o;
    @c("humidity")

    /* renamed from: p  reason: collision with root package name */
    private String f35696p;
    @c("aqiType")

    /* renamed from: q  reason: collision with root package name */
    private String f35697q;
    @c("hourlyTime")

    /* renamed from: r  reason: collision with root package name */
    private String f35698r;
    @c("imgUrl")

    /* renamed from: s  reason: collision with root package name */
    private String f35699s;

    public int a() {
        if (TextUtils.isEmpty(this.f35694n)) {
            return 0;
        }
        try {
            return Integer.parseInt(this.f35694n);
        } catch (Exception unused) {
            k.s("WeatherData", "bad AQI data [%s]", this.f35694n);
            return 0;
        }
    }

    public String b() {
        return this.f35697q;
    }

    public String c() {
        return this.f35684d;
    }

    public String d() {
        return this.f35681a;
    }

    public long e() {
        return this.f35682b;
    }

    public String f() {
        return this.f35687g;
    }

    public String g() {
        return this.f35686f;
    }

    public String h() {
        return this.f35685e;
    }

    public String i() {
        return this.f35688h;
    }

    public String j() {
        return this.f35689i;
    }

    public String k() {
        return this.f35683c;
    }

    public String l() {
        return this.f35690j;
    }

    public String m() {
        return this.f35691k;
    }
}
