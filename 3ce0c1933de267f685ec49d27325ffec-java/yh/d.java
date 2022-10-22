package yh;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.TelephonyUtil;
import h8.c;
import v9.a;
import v9.e;
/* compiled from: WeatherCardData.java */
/* loaded from: classes2.dex */
public class d implements JsonBean {
    public static final String TYPE = "weather";
    public a[] dayWeathers;
    @c("detailUrl")
    public String detailUrl;
    public a[] hourlyData;
    @c("aqi")
    public String mAqi;
    @c("aqiType")
    public String mAqiType;
    @c("currentTemp")
    public String mCurrentTemp;
    @c(ContactConstant.CallsRecordKeys.DATE)
    public String mDate;
    @c(SharedWearInfoHelper.LocationInfo.TABLE)
    public String mLocation;
    @c("maxTemp")
    public String mMaxTemp;
    @c("minTemp")
    public String mMinTemp;
    @c("weatherBg")
    public String mWeatherCondition;
    @c(TYPE)
    public String mWeatherDesc;
    @c("weekDay")
    public String mWeekDay;
    @c("windDir")
    public String mWindDirection;
    @c("wind")
    public String mWindLevel;
    @c(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE)
    public String source;

    public static d a(e eVar) {
        e.d dVar;
        e.a aVar;
        e.b bVar;
        if (eVar == null || (dVar = eVar.result) == null || (aVar = dVar.clientData) == null || (bVar = aVar.data) == null) {
            return null;
        }
        v9.d dVar2 = bVar.params.mQueriesDay;
        d dVar3 = new d();
        dVar3.mLocation = dVar2.n();
        dVar3.mCurrentTemp = dVar2.c();
        dVar3.mWeatherDesc = dVar2.j();
        dVar3.mMinTemp = dVar2.g();
        dVar3.mMaxTemp = dVar2.f();
        dVar3.mAqi = String.valueOf(dVar2.a());
        dVar3.mAqiType = dVar2.b();
        dVar3.mWeatherCondition = dVar2.i();
        dVar3.mWindDirection = dVar2.l();
        dVar3.mWindLevel = dVar2.m();
        dVar3.mDate = dVar2.d();
        dVar3.mWeekDay = dVar2.k();
        e.c cVar = bVar.params;
        dVar3.dayWeathers = cVar.pageData;
        dVar3.hourlyData = cVar.hourlyData;
        e.b bVar2 = eVar.result.clientData.data;
        dVar3.source = bVar2.source;
        dVar3.detailUrl = bVar2.detailUrl;
        return dVar3;
    }
}
