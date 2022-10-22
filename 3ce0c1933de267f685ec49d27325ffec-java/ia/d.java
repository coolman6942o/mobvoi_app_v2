package ia;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: RequestBean.kt */
/* loaded from: classes2.dex */
public final class d implements JsonBean {
    private String appversion;
    private String deviceType;
    private String mid;
    private String models;
    private String networkType;
    private String oem;
    private String platform;
    private String sdkversion;
    private String sign;
    private long timestamp;
    private String version;

    public d(String mid, String oem, String models, String platform, String deviceType, long j10, String sign, String sdkversion, String appversion, String version, String networkType) {
        i.f(mid, "mid");
        i.f(oem, "oem");
        i.f(models, "models");
        i.f(platform, "platform");
        i.f(deviceType, "deviceType");
        i.f(sign, "sign");
        i.f(sdkversion, "sdkversion");
        i.f(appversion, "appversion");
        i.f(version, "version");
        i.f(networkType, "networkType");
        this.mid = mid;
        this.oem = oem;
        this.models = models;
        this.platform = platform;
        this.deviceType = deviceType;
        this.timestamp = j10;
        this.sign = sign;
        this.sdkversion = sdkversion;
        this.appversion = appversion;
        this.version = version;
        this.networkType = networkType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return i.b(this.mid, dVar.mid) && i.b(this.oem, dVar.oem) && i.b(this.models, dVar.models) && i.b(this.platform, dVar.platform) && i.b(this.deviceType, dVar.deviceType) && this.timestamp == dVar.timestamp && i.b(this.sign, dVar.sign) && i.b(this.sdkversion, dVar.sdkversion) && i.b(this.appversion, dVar.appversion) && i.b(this.version, dVar.version) && i.b(this.networkType, dVar.networkType);
    }

    public int hashCode() {
        return (((((((((((((((((((this.mid.hashCode() * 31) + this.oem.hashCode()) * 31) + this.models.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + a.a(this.timestamp)) * 31) + this.sign.hashCode()) * 31) + this.sdkversion.hashCode()) * 31) + this.appversion.hashCode()) * 31) + this.version.hashCode()) * 31) + this.networkType.hashCode();
    }

    public String toString() {
        return "Register(mid=" + this.mid + ", oem=" + this.oem + ", models=" + this.models + ", platform=" + this.platform + ", deviceType=" + this.deviceType + ", timestamp=" + this.timestamp + ", sign=" + this.sign + ", sdkversion=" + this.sdkversion + ", appversion=" + this.appversion + ", version=" + this.version + ", networkType=" + this.networkType + ')';
    }
}
