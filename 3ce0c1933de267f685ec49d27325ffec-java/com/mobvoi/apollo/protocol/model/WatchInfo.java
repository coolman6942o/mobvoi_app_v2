package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: WatchInfo.kt */
/* loaded from: classes2.dex */
public final class WatchInfo implements JsonBean {
    private final String fotaVersion;
    private final String model;
    private final String platform;
    private final String version;

    public WatchInfo(String model, String platform, String version, String fotaVersion) {
        i.f(model, "model");
        i.f(platform, "platform");
        i.f(version, "version");
        i.f(fotaVersion, "fotaVersion");
        this.model = model;
        this.platform = platform;
        this.version = version;
        this.fotaVersion = fotaVersion;
    }

    public static /* synthetic */ WatchInfo copy$default(WatchInfo watchInfo, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = watchInfo.model;
        }
        if ((i10 & 2) != 0) {
            str2 = watchInfo.platform;
        }
        if ((i10 & 4) != 0) {
            str3 = watchInfo.version;
        }
        if ((i10 & 8) != 0) {
            str4 = watchInfo.fotaVersion;
        }
        return watchInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.model;
    }

    public final String component2() {
        return this.platform;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.fotaVersion;
    }

    public final WatchInfo copy(String model, String platform, String version, String fotaVersion) {
        i.f(model, "model");
        i.f(platform, "platform");
        i.f(version, "version");
        i.f(fotaVersion, "fotaVersion");
        return new WatchInfo(model, platform, version, fotaVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchInfo)) {
            return false;
        }
        WatchInfo watchInfo = (WatchInfo) obj;
        return i.b(this.model, watchInfo.model) && i.b(this.platform, watchInfo.platform) && i.b(this.version, watchInfo.version) && i.b(this.fotaVersion, watchInfo.fotaVersion);
    }

    public final String getFotaVersion() {
        return this.fotaVersion;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.model.hashCode() * 31) + this.platform.hashCode()) * 31) + this.version.hashCode()) * 31) + this.fotaVersion.hashCode();
    }

    public String toString() {
        return "WatchInfo(model=" + this.model + ", platform=" + this.platform + ", version=" + this.version + ", fotaVersion=" + this.fotaVersion + ')';
    }
}
