package v9;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: LocationInfo.java */
/* loaded from: classes2.dex */
public class b implements JsonBean {
    public String city;
    public String country;
    public String district;
    public c point;
    public String province;
    public String street;
    public String streetNumber;
    public long time;

    public String a() {
        return this.country + "," + this.province + "," + this.city + "," + this.district + "," + this.street + "," + this.streetNumber + "," + this.point.latitude + "," + this.point.longitude;
    }

    public String toString() {
        return "LocationInfo[point=" + this.point + ", country=" + this.country + ", province=" + this.province + ", city=" + this.city + ", district=" + this.district + ", street=" + this.street + ", streetNumber=" + this.streetNumber + "]";
    }
}
