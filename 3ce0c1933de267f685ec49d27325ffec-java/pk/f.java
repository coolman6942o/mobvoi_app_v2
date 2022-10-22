package pk;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import h8.c;
/* compiled from: BleDevice.java */
/* loaded from: classes2.dex */
public class f implements JsonBean {
    @c("address")
    private String address;
    @c(ContactConstant.CallsRecordKeys.NAME)
    private String name;
    @c("rssi")
    private int rssi;

    public f() {
    }

    public String a() {
        return this.address;
    }

    public String b() {
        return this.name;
    }

    public void c(String str) {
        this.address = str;
    }

    public void d(String str) {
        this.name = str;
    }

    public void e(int i10) {
        this.rssi = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.address;
        if (str == null) {
            if (fVar.address != null) {
                return false;
            }
        } else if (!str.equals(fVar.address)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.address;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BleDevice{name='" + this.name + "', address='" + this.address + "', rssi=" + this.rssi + '}';
    }

    public f(String str, String str2, int i10) {
        d(str);
        c(str2);
        e(i10);
    }
}
