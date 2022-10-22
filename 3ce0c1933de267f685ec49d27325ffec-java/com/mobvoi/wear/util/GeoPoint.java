package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public class GeoPoint {
    private double lat = 0.0d;
    private double lng = 0.0d;

    public GeoPoint() {
    }

    public static GeoPoint parseFromDouble(double d10, double d11) {
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.lat = d10;
        geoPoint.lng = d11;
        return geoPoint;
    }

    public static GeoPoint parseFromInt(int i10, int i11) {
        return parseFromDouble(i10 / 1000000.0d, i11 / 1000000.0d);
    }

    public static GeoPoint parseFromString(String str, String str2) {
        try {
            return parseFromDouble(Double.valueOf(str).doubleValue(), Double.valueOf(str2).doubleValue());
        } catch (Exception unused) {
            return parseFromDouble(0.0d, 0.0d);
        }
    }

    public static GeoPoint parseFromStringComma(String str) {
        try {
            String[] split = str.split(",");
            if (split.length == 2) {
                return parseFromString(split[0], split[1]);
            }
        } catch (Exception unused) {
        }
        return parseFromDouble(0.0d, 0.0d);
    }

    public static GeoPoint parseFromStringInt(String str, String str2) {
        try {
            return parseFromInt(Integer.valueOf(str).intValue(), Integer.valueOf(str2).intValue());
        } catch (Exception unused) {
            return parseFromDouble(0.0d, 0.0d);
        }
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public boolean isValid() {
        return (this.lat == 0.0d || this.lng == 0.0d) ? false : true;
    }

    public void setLat(double d10) {
        this.lat = d10;
    }

    public void setLng(double d10) {
        this.lng = d10;
    }

    public String toStringWithComma() {
        return this.lat + "," + this.lng;
    }

    public GeoPoint(double d10, double d11) {
        setLat(d10);
        setLng(d11);
    }
}
