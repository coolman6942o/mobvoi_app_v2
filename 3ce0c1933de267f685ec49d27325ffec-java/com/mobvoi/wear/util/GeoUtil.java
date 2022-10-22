package com.mobvoi.wear.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes2.dex */
public class GeoUtil {
    private static final double EARTH_RADIUS = 6378.137d;
    public static final int LOCATION_SYSTEM_BAIDU = 2;
    public static final int LOCATION_SYSTEM_MARS = 1;
    public static final int LOCATION_SYSTEM_STANDARD = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final double f20962a = 6378245.0d;

    /* renamed from: ee  reason: collision with root package name */
    private static final double f20963ee = 0.006693421622965943d;
    private static double xPi = 52.35987755982988d;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LocationSystem {
    }

    private static double calculateDelta(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return Math.abs(geoPoint.getLat() - geoPoint2.getLat()) + Math.abs(geoPoint.getLng() - geoPoint2.getLng());
    }

    public static double calculateDistance(double d10, double d11, double d12, double d13) {
        double rad = rad(d11);
        double rad2 = rad(d13);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((rad - rad2) / 2.0d), 2.0d) + (Math.cos(rad) * Math.cos(rad2) * Math.pow(Math.sin((rad(d12) - rad(d10)) / 2.0d), 2.0d)))) * 2.0d * EARTH_RADIUS * 1000.0d;
    }

    public static GeoPoint convertBaiduToGCJ(GeoPoint geoPoint) {
        if (!geoPoint.isValid()) {
            return geoPoint;
        }
        double lng = geoPoint.getLng() - 0.0065d;
        double lat = geoPoint.getLat() - 0.006d;
        double sqrt = Math.sqrt((lng * lng) + (lat * lat)) - (Math.sin(xPi * lat) * 2.0E-5d);
        double atan2 = Math.atan2(lat, lng) - (Math.cos(lng * xPi) * 3.0E-6d);
        GeoPoint geoPoint2 = new GeoPoint();
        geoPoint2.setLat(Math.sin(atan2) * sqrt);
        geoPoint2.setLng(sqrt * Math.cos(atan2));
        return geoPoint2;
    }

    public static GeoPoint convertBaiduToGPSGeo(GeoPoint geoPoint) {
        return convertMarsGeoToGPS(convertBaiduToGCJ(geoPoint));
    }

    public static GeoPoint convertGCJToBaidu(GeoPoint geoPoint) {
        if (!geoPoint.isValid()) {
            return geoPoint;
        }
        double sqrt = Math.sqrt((geoPoint.getLng() * geoPoint.getLng()) + (geoPoint.getLat() * geoPoint.getLat())) + (Math.sin(geoPoint.getLat() * xPi) * 2.0E-5d);
        double atan2 = Math.atan2(geoPoint.getLat(), geoPoint.getLng()) + (Math.cos(geoPoint.getLng() * xPi) * 3.0E-6d);
        GeoPoint geoPoint2 = new GeoPoint();
        geoPoint2.setLat((Math.sin(atan2) * sqrt) + 0.006d);
        geoPoint2.setLng((sqrt * Math.cos(atan2)) + 0.0065d);
        return geoPoint2;
    }

    public static GeoPoint convertGPSToBaiduGeo(GeoPoint geoPoint) {
        return convertGCJToBaidu(convertGPSToMarsGeo(geoPoint));
    }

    public static GeoPoint convertGPSToMarsGeo(GeoPoint geoPoint) {
        if (!geoPoint.isValid()) {
            return geoPoint;
        }
        double lng = geoPoint.getLng();
        double lat = geoPoint.getLat();
        double d10 = lng - 105.0d;
        double d11 = lat - 35.0d;
        double transformLat = transformLat(d10, d11);
        double transformLon = transformLon(d10, d11);
        double d12 = (lat / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d12);
        double d13 = 1.0d - ((f20963ee * sin) * sin);
        double sqrt = Math.sqrt(d13);
        return new GeoPoint(lat + ((transformLat * 180.0d) / ((6335552.717000426d / (d13 * sqrt)) * 3.141592653589793d)), lng + ((transformLon * 180.0d) / (((f20962a / sqrt) * Math.cos(d12)) * 3.141592653589793d)));
    }

    public static GeoPoint convertMarsGeoToGPS(GeoPoint geoPoint) {
        double d10;
        double d11;
        if (!geoPoint.isValid()) {
            return geoPoint;
        }
        double lat = geoPoint.getLat() - 0.5d;
        double lat2 = geoPoint.getLat() + 0.5d;
        double lng = geoPoint.getLng() - 0.5d;
        double lng2 = geoPoint.getLng() + 0.5d;
        int i10 = 30;
        while (true) {
            GeoPoint convertGPSToMarsGeo = convertGPSToMarsGeo(new GeoPoint(lat, lng));
            GeoPoint convertGPSToMarsGeo2 = convertGPSToMarsGeo(new GeoPoint(lat, lng2));
            GeoPoint convertGPSToMarsGeo3 = convertGPSToMarsGeo(new GeoPoint(lat2, lng));
            d10 = (lat + lat2) / 2.0d;
            lat = lat;
            d11 = (lng + lng2) / 2.0d;
            GeoPoint convertGPSToMarsGeo4 = convertGPSToMarsGeo(new GeoPoint(d10, d11));
            double calculateDelta = calculateDelta(convertGPSToMarsGeo4, geoPoint);
            i10--;
            if (i10 <= 0 || calculateDelta <= 1.0E-5d) {
                break;
            } else if (isContains(geoPoint, convertGPSToMarsGeo, convertGPSToMarsGeo4)) {
                lat2 = d10;
                lng2 = d11;
            } else if (isContains(geoPoint, convertGPSToMarsGeo2, convertGPSToMarsGeo4)) {
                lat2 = d10;
                lng = d11;
            } else {
                if (isContains(geoPoint, convertGPSToMarsGeo3, convertGPSToMarsGeo4)) {
                    lng2 = d11;
                } else {
                    lng = d11;
                }
                lat = d10;
            }
        }
        return new GeoPoint(d10, d11);
    }

    public static int getClosestPointIndex(GeoPoint geoPoint, List<GeoPoint> list) {
        int i10 = -1;
        double d10 = Double.MAX_VALUE;
        for (int i11 = 0; i11 < list.size(); i11++) {
            double calculateDistance = calculateDistance(geoPoint, list.get(i11));
            if (calculateDistance < d10) {
                i10 = i11;
                d10 = calculateDistance;
            }
        }
        return i10;
    }

    private static boolean isContains(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        return geoPoint.getLat() >= Math.min(geoPoint2.getLat(), geoPoint3.getLat()) && geoPoint.getLat() <= Math.max(geoPoint2.getLat(), geoPoint3.getLat()) && geoPoint.getLng() >= Math.min(geoPoint2.getLng(), geoPoint3.getLng()) && geoPoint.getLng() <= Math.max(geoPoint2.getLng(), geoPoint3.getLng());
    }

    public static boolean isInMap(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        return geoPoint2.getLat() > geoPoint3.getLat() && geoPoint2.getLng() > geoPoint3.getLng() && geoPoint.getLat() < geoPoint3.getLat() && geoPoint.getLng() < geoPoint3.getLng();
    }

    private static double rad(double d10) {
        return (d10 * 3.141592653589793d) / 180.0d;
    }

    private static double transformLat(double d10, double d11) {
        double d12 = d10 * 2.0d;
        double d13 = d11 * 3.141592653589793d;
        return (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((6.0d * d10) * 3.141592653589793d) * 20.0d) + (Math.sin(d12 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d13) * 20.0d) + (Math.sin((d11 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d13 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double transformLon(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * 3.141592653589793d) * 20.0d) + (Math.sin((d10 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d10 * 3.141592653589793d) * 20.0d) + (Math.sin((d10 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d10 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static double calculateDistance(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return calculateDistance(geoPoint.getLng(), geoPoint.getLat(), geoPoint2.getLng(), geoPoint2.getLat());
    }
}
