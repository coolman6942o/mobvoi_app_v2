package com.mobvoi.wear.location;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class FusedLocationRequest {
    public static final String ID_KEY = "ID_KEY";
    public static final String INTERVAL_KEY = "INTERVAL_KEY";
    public static final String PID_KEY = "PID_KEY";
    public static final String PRIORITY_KEY = "PRIORITY_KEY";
    private String pid = "MMS";

    /* renamed from: id  reason: collision with root package name */
    private String f20938id = "APP";
    private int priority = 105;
    private int interval = FusedLocationConstants.DEFAULT_INTERVAL;

    public FusedLocationRequest fromBundle(Bundle bundle) {
        this.pid = bundle.getString(PID_KEY, "MMS");
        this.f20938id = bundle.getString(ID_KEY, "APP");
        this.priority = bundle.getInt(PRIORITY_KEY, 105);
        this.interval = bundle.getInt(INTERVAL_KEY, FusedLocationConstants.DEFAULT_INTERVAL);
        return this;
    }

    public String getId() {
        return this.f20938id;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPid() {
        return this.pid;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setId(String str) {
        this.f20938id = str;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(PID_KEY, this.pid);
        bundle.putString(ID_KEY, this.f20938id);
        bundle.putInt(PRIORITY_KEY, this.priority);
        bundle.putInt(INTERVAL_KEY, this.interval);
        return bundle;
    }
}
