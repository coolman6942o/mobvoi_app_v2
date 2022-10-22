package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: RequestBean.kt */
/* loaded from: classes2.dex */
public final class f implements JsonBean {
    private String deltaID;
    private long downEnd;
    private long downStart;
    private String downloadStatus;
    private String mid;
    private String sign;
    private long timestamp;

    public f(String mid, String deltaID, String downloadStatus, long j10, long j11, long j12, String sign) {
        i.f(mid, "mid");
        i.f(deltaID, "deltaID");
        i.f(downloadStatus, "downloadStatus");
        i.f(sign, "sign");
        this.mid = mid;
        this.deltaID = deltaID;
        this.downloadStatus = downloadStatus;
        this.downStart = j10;
        this.downEnd = j11;
        this.timestamp = j12;
        this.sign = sign;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return i.b(this.mid, fVar.mid) && i.b(this.deltaID, fVar.deltaID) && i.b(this.downloadStatus, fVar.downloadStatus) && this.downStart == fVar.downStart && this.downEnd == fVar.downEnd && this.timestamp == fVar.timestamp && i.b(this.sign, fVar.sign);
    }

    public int hashCode() {
        return (((((((((((this.mid.hashCode() * 31) + this.deltaID.hashCode()) * 31) + this.downloadStatus.hashCode()) * 31) + a.a(this.downStart)) * 31) + a.a(this.downEnd)) * 31) + a.a(this.timestamp)) * 31) + this.sign.hashCode();
    }

    public String toString() {
        return "ReportDown(mid=" + this.mid + ", deltaID=" + this.deltaID + ", downloadStatus=" + this.downloadStatus + ", downStart=" + this.downStart + ", downEnd=" + this.downEnd + ", timestamp=" + this.timestamp + ", sign=" + this.sign + ')';
    }
}
