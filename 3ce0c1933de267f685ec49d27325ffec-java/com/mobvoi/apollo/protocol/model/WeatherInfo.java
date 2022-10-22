package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import ia.a;
import kotlin.jvm.internal.i;
/* compiled from: WeatherInfo.kt */
/* loaded from: classes2.dex */
public final class WeatherInfo implements JsonBean {
    private final int currentTemp;
    private final long dateTime;
    private final String location;
    private final int maxTemp;
    private final int minTemp;
    private final String unit;
    private final String weather;
    private final String weatherCode;
    private final String weekDay;

    public WeatherInfo(String weather, String weatherCode, long j10, int i10, int i11, int i12, String unit, String weekDay, String str) {
        i.f(weather, "weather");
        i.f(weatherCode, "weatherCode");
        i.f(unit, "unit");
        i.f(weekDay, "weekDay");
        this.weather = weather;
        this.weatherCode = weatherCode;
        this.dateTime = j10;
        this.currentTemp = i10;
        this.minTemp = i11;
        this.maxTemp = i12;
        this.unit = unit;
        this.weekDay = weekDay;
        this.location = str;
    }

    public final String component1() {
        return this.weather;
    }

    public final String component2() {
        return this.weatherCode;
    }

    public final long component3() {
        return this.dateTime;
    }

    public final int component4() {
        return this.currentTemp;
    }

    public final int component5() {
        return this.minTemp;
    }

    public final int component6() {
        return this.maxTemp;
    }

    public final String component7() {
        return this.unit;
    }

    public final String component8() {
        return this.weekDay;
    }

    public final String component9() {
        return this.location;
    }

    public final WeatherInfo copy(String weather, String weatherCode, long j10, int i10, int i11, int i12, String unit, String weekDay, String str) {
        i.f(weather, "weather");
        i.f(weatherCode, "weatherCode");
        i.f(unit, "unit");
        i.f(weekDay, "weekDay");
        return new WeatherInfo(weather, weatherCode, j10, i10, i11, i12, unit, weekDay, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherInfo)) {
            return false;
        }
        WeatherInfo weatherInfo = (WeatherInfo) obj;
        return i.b(this.weather, weatherInfo.weather) && i.b(this.weatherCode, weatherInfo.weatherCode) && this.dateTime == weatherInfo.dateTime && this.currentTemp == weatherInfo.currentTemp && this.minTemp == weatherInfo.minTemp && this.maxTemp == weatherInfo.maxTemp && i.b(this.unit, weatherInfo.unit) && i.b(this.weekDay, weatherInfo.weekDay) && i.b(this.location, weatherInfo.location);
    }

    public final int getCurrentTemp() {
        return this.currentTemp;
    }

    public final long getDateTime() {
        return this.dateTime;
    }

    public final String getLocation() {
        return this.location;
    }

    public final int getMaxTemp() {
        return this.maxTemp;
    }

    public final int getMinTemp() {
        return this.minTemp;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getWeather() {
        return this.weather;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final String getWeekDay() {
        return this.weekDay;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.weather.hashCode() * 31) + this.weatherCode.hashCode()) * 31) + a.a(this.dateTime)) * 31) + this.currentTemp) * 31) + this.minTemp) * 31) + this.maxTemp) * 31) + this.unit.hashCode()) * 31) + this.weekDay.hashCode()) * 31;
        String str = this.location;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WeatherInfo(weather=" + this.weather + ", weatherCode=" + this.weatherCode + ", dateTime=" + this.dateTime + ", currentTemp=" + this.currentTemp + ", minTemp=" + this.minTemp + ", maxTemp=" + this.maxTemp + ", unit=" + this.unit + ", weekDay=" + this.weekDay + ", location=" + ((Object) this.location) + ')';
    }
}
