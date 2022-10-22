package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: RequestBean.kt */
/* loaded from: classes2.dex */
public final class b implements JsonBean {
    private String mid;
    private String sign;
    private long timestamp;
    private String version;

    public b(String mid, String version, long j10, String sign) {
        i.f(mid, "mid");
        i.f(version, "version");
        i.f(sign, "sign");
        this.mid = mid;
        this.version = version;
        this.timestamp = j10;
        this.sign = sign;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.b(this.mid, bVar.mid) && i.b(this.version, bVar.version) && this.timestamp == bVar.timestamp && i.b(this.sign, bVar.sign);
    }

    public int hashCode() {
        return (((((this.mid.hashCode() * 31) + this.version.hashCode()) * 31) + a.a(this.timestamp)) * 31) + this.sign.hashCode();
    }

    public String toString() {
        return "CheckVersion(mid=" + this.mid + ", version=" + this.version + ", timestamp=" + this.timestamp + ", sign=" + this.sign + ')';
    }
}
