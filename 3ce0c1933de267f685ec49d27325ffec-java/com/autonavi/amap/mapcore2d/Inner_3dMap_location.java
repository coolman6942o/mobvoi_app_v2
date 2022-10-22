package com.autonavi.amap.mapcore2d;

import android.location.Location;
/* loaded from: classes.dex */
public class Inner_3dMap_location extends Location {

    /* renamed from: a  reason: collision with root package name */
    private String f7588a;

    /* renamed from: b  reason: collision with root package name */
    private String f7589b;

    /* renamed from: c  reason: collision with root package name */
    private String f7590c;

    /* renamed from: d  reason: collision with root package name */
    private String f7591d;

    /* renamed from: e  reason: collision with root package name */
    private String f7592e;

    /* renamed from: f  reason: collision with root package name */
    private String f7593f;

    /* renamed from: g  reason: collision with root package name */
    private String f7594g;

    /* renamed from: h  reason: collision with root package name */
    private String f7595h;

    /* renamed from: i  reason: collision with root package name */
    private String f7596i;

    /* renamed from: j  reason: collision with root package name */
    private String f7597j;

    /* renamed from: k  reason: collision with root package name */
    private String f7598k;

    /* renamed from: l  reason: collision with root package name */
    private int f7599l;

    /* renamed from: m  reason: collision with root package name */
    private String f7600m;

    /* renamed from: n  reason: collision with root package name */
    private String f7601n;

    /* renamed from: o  reason: collision with root package name */
    private int f7602o;

    /* renamed from: p  reason: collision with root package name */
    private double f7603p;

    /* renamed from: q  reason: collision with root package name */
    private double f7604q;

    /* renamed from: r  reason: collision with root package name */
    private String f7605r;

    /* renamed from: s  reason: collision with root package name */
    protected String f7606s;

    /* renamed from: t  reason: collision with root package name */
    protected String f7607t;

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    @Override // android.location.Location
    public double getAltitude() {
        return super.getAltitude();
    }

    @Override // android.location.Location
    public float getBearing() {
        return super.getBearing();
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f7603p;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f7604q;
    }

    @Override // android.location.Location
    public String getProvider() {
        return super.getProvider();
    }

    @Override // android.location.Location
    public float getSpeed() {
        return super.getSpeed();
    }

    @Override // android.location.Location
    public void setLatitude(double d10) {
        this.f7603p = d10;
    }

    @Override // android.location.Location
    public void setLongitude(double d10) {
        this.f7604q = d10;
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f7603p + "#");
            stringBuffer.append("longitude=" + this.f7604q + "#");
            stringBuffer.append("province=" + this.f7588a + "#");
            stringBuffer.append("city=" + this.f7589b + "#");
            stringBuffer.append("district=" + this.f7590c + "#");
            stringBuffer.append("cityCode=" + this.f7591d + "#");
            stringBuffer.append("adCode=" + this.f7592e + "#");
            stringBuffer.append("address=" + this.f7593f + "#");
            stringBuffer.append("country=" + this.f7595h + "#");
            stringBuffer.append("road=" + this.f7596i + "#");
            stringBuffer.append("poiName=" + this.f7594g + "#");
            stringBuffer.append("street=" + this.f7597j + "#");
            stringBuffer.append("streetNum=" + this.f7598k + "#");
            stringBuffer.append("aoiName=" + this.f7605r + "#");
            stringBuffer.append("poiid=" + this.f7606s + "#");
            stringBuffer.append("floor=" + this.f7607t + "#");
            stringBuffer.append("errorCode=" + this.f7599l + "#");
            stringBuffer.append("errorInfo=" + this.f7600m + "#");
            stringBuffer.append("locationDetail=" + this.f7601n + "#");
            StringBuilder sb2 = new StringBuilder("locationType=");
            sb2.append(this.f7602o);
            stringBuffer.append(sb2.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
