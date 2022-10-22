package v9;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: LocationPoint.java */
/* loaded from: classes2.dex */
public class c implements JsonBean {
    private static final String TAG = "LocationPoint";
    public double latitude;
    public double longitude;

    public static c a(double d10, double d11) {
        c cVar = new c();
        cVar.latitude = d10;
        cVar.longitude = d11;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.latitude == cVar.latitude && this.longitude == cVar.longitude;
    }

    public String toString() {
        return "Point[latitude=" + this.latitude + ", longitude=" + this.longitude + "]";
    }
}
