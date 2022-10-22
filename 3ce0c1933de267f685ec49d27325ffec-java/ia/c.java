package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: ResponseBean.kt */
/* loaded from: classes2.dex */
public final class c implements JsonBean {
    private final String deviceId;
    private final String deviceSecret;

    public final String a() {
        return this.deviceId;
    }

    public final String b() {
        return this.deviceSecret;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.b(this.deviceId, cVar.deviceId) && i.b(this.deviceSecret, cVar.deviceSecret);
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.deviceSecret.hashCode();
    }

    public String toString() {
        return "DeviceInfo(deviceId=" + this.deviceId + ", deviceSecret=" + this.deviceSecret + ')';
    }
}
