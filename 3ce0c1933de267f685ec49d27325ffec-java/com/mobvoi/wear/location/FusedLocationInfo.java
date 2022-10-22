package com.mobvoi.wear.location;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class FusedLocationInfo {
    private static final String ACCURACY_KEY = "accuracy";
    private static final String ADDRESS_KEY = "address";
    private static final String ALTITUDE_KEY = "altitude";
    private static final String BEARING_KEY = "bearing";
    private static final String CITY_KEY = "city";
    private static final String CONFIDENCE_KEY = "confidence";
    private static final String COUNTRY_KEY = "country";
    private static final String COUNTY_KEY = "county";
    private static final String CREATE_TIME_KEY = "create_time";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_MESSAGE_KEY = "error_message";
    private static final String LATITUDE_KEY = "latitude";
    private static final String LONGITUDE_KEY = "longitude";
    private static final String PROVINCE_KEY = "province";
    private static final String SPEED_KEY = "speed";
    private static final String TYPE_KEY = "type";
    private int errorCode = -1;
    private String errorMsg = FusedLocationConstants.NO_ERROR;
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private double altitude = 0.0d;
    private float accuracy = 0.0f;
    private String address = "";
    private float bearing = 0.0f;
    private String country = "";
    private String city = "";
    private String county = "";
    private byte confidence = 0;
    private long createTime = 0;
    private float speed = 0.0f;
    private String province = "";
    private byte type = 0;

    public FusedLocationInfo fromBundle(Bundle bundle) {
        this.errorCode = bundle.getInt(ERROR_CODE_KEY, -1);
        this.errorMsg = bundle.getString(ERROR_MESSAGE_KEY, FusedLocationConstants.NO_ERROR);
        this.latitude = bundle.getDouble(LATITUDE_KEY, 0.0d);
        this.longitude = bundle.getDouble(LONGITUDE_KEY, 0.0d);
        this.altitude = bundle.getDouble(ALTITUDE_KEY, 0.0d);
        this.accuracy = bundle.getFloat("accuracy", 0.0f);
        this.speed = bundle.getFloat(SPEED_KEY, 0.0f);
        this.bearing = bundle.getFloat(BEARING_KEY, 0.0f);
        this.city = bundle.getString(CITY_KEY, "");
        this.province = bundle.getString(PROVINCE_KEY, "");
        this.country = bundle.getString("country", "");
        this.county = bundle.getString(COUNTY_KEY, "");
        this.address = bundle.getString(ADDRESS_KEY, "");
        this.confidence = bundle.getByte(CONFIDENCE_KEY, (byte) 0).byteValue();
        this.createTime = bundle.getLong("create_time", 0L);
        this.type = bundle.getByte("type", (byte) 0).byteValue();
        return this;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getBearing() {
        return this.bearing;
    }

    public String getCity() {
        return this.city;
    }

    public byte getConfidence() {
        return this.confidence;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCounty() {
        return this.county;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvince() {
        return this.province;
    }

    public float getSpeed() {
        return this.speed;
    }

    public byte getType() {
        return this.type;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAltitude(double d10) {
        this.altitude = d10;
    }

    public void setBearing(float f10) {
        this.bearing = f10;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setConfidence(byte b10) {
        this.confidence = b10;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCounty(String str) {
        this.county = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setSpeed(float f10) {
        this.speed = f10;
    }

    public void setType(byte b10) {
        this.type = b10;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putDouble(LATITUDE_KEY, this.latitude);
        bundle.putDouble(LONGITUDE_KEY, this.longitude);
        bundle.putDouble(ALTITUDE_KEY, this.altitude);
        bundle.putFloat("accuracy", this.accuracy);
        bundle.putFloat(SPEED_KEY, this.speed);
        bundle.putFloat(BEARING_KEY, this.bearing);
        bundle.putString(CITY_KEY, this.city);
        bundle.putString(PROVINCE_KEY, this.province);
        bundle.putString("country", this.country);
        bundle.putString(COUNTY_KEY, this.county);
        bundle.putString(ADDRESS_KEY, this.address);
        bundle.putByte(CONFIDENCE_KEY, this.confidence);
        bundle.putLong("create_time", this.createTime);
        bundle.putByte("type", this.type);
        bundle.putInt(ERROR_CODE_KEY, this.errorCode);
        bundle.putString(ERROR_MESSAGE_KEY, this.errorMsg);
        return bundle;
    }
}
