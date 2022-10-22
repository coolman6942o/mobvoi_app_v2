package com.tendcloud.tenddata;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class t {
    public static List<Location> a(Context context) {
        ArrayList arrayList = new ArrayList();
        if (ab.O) {
            return arrayList;
        }
        try {
            arrayList.add(f(context));
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static String b(Context context) {
        try {
            List<Location> a10 = a(context);
            StringBuilder sb2 = new StringBuilder();
            for (Location location : a10) {
                if (location != null) {
                    sb2.append(location.getLatitude());
                    sb2.append(',');
                    sb2.append(location.getLongitude());
                    sb2.append(',');
                    Object obj = "";
                    sb2.append(location.hasAltitude() ? Double.valueOf(location.getAltitude()) : obj);
                    sb2.append(',');
                    sb2.append(location.getTime());
                    sb2.append(',');
                    sb2.append(location.hasAccuracy() ? Float.valueOf(location.getAccuracy()) : obj);
                    sb2.append(',');
                    sb2.append(location.hasBearing() ? Float.valueOf(location.getBearing()) : obj);
                    sb2.append(',');
                    if (location.hasSpeed()) {
                        obj = Float.valueOf(location.getSpeed());
                    }
                    sb2.append(obj);
                    sb2.append(',');
                    sb2.append(location.getProvider());
                    sb2.append(':');
                }
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray c(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (ab.O) {
            return jSONArray;
        }
        try {
            Location f10 = f(context);
            if (f10 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SharedWearInfoHelper.LocationInfo.KEY_LAT, f10.getLatitude());
                jSONObject.put(SharedWearInfoHelper.LocationInfo.KEY_LNG, f10.getLongitude());
                jSONObject.put("ts", f10.getTime());
                if (u.a(17)) {
                    jSONObject.put("elapsed", f10.getElapsedRealtimeNanos());
                }
                if (f10.hasAltitude()) {
                    jSONObject.put("altitude", f10.getAltitude());
                }
                if (f10.hasAccuracy()) {
                    jSONObject.put("hAccuracy", f10.getAccuracy());
                }
                if (f10.hasBearing()) {
                    jSONObject.put("bearing", f10.getBearing());
                }
                if (f10.hasSpeed()) {
                    jSONObject.put("speed", f10.getSpeed());
                }
                jSONObject.put(SharedWearInfoHelper.LocationInfo.KEY_PROVIDER, f10.getProvider());
                jSONArray.put(jSONObject);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    public static JSONArray d(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray A = m.A(context);
            if (A.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "sim");
                jSONObject.put("extra", A);
                jSONArray.put(jSONObject);
            }
            String str = ab.f22580t;
            if (str != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("accountId", str);
                jSONObject2.put("type", "account");
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    public static Long[][] e(Context context) {
        return new Long[3];
    }

    private static Location f(Context context) {
        boolean z10;
        if (!u.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) ab.f22568h.getSystemService(SharedWearInfoHelper.LocationInfo.TABLE);
            boolean z11 = false;
            if (locationManager != null) {
                z11 = locationManager.isProviderEnabled("gps");
                z10 = locationManager.isProviderEnabled("network");
            } else {
                z10 = false;
            }
            if (z11 || z10) {
                return locationManager.getLastKnownLocation("passive");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
