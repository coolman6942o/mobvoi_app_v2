package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: WatchVersion.kt */
/* loaded from: classes2.dex */
public final class WatchVersion implements JsonBean {
    private final String fotaVersion;
    private final String version;

    public WatchVersion(String version, String fotaVersion) {
        i.f(version, "version");
        i.f(fotaVersion, "fotaVersion");
        this.version = version;
        this.fotaVersion = fotaVersion;
    }

    public static /* synthetic */ WatchVersion copy$default(WatchVersion watchVersion, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = watchVersion.version;
        }
        if ((i10 & 2) != 0) {
            str2 = watchVersion.fotaVersion;
        }
        return watchVersion.copy(str, str2);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.fotaVersion;
    }

    public final WatchVersion copy(String version, String fotaVersion) {
        i.f(version, "version");
        i.f(fotaVersion, "fotaVersion");
        return new WatchVersion(version, fotaVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchVersion)) {
            return false;
        }
        WatchVersion watchVersion = (WatchVersion) obj;
        return i.b(this.version, watchVersion.version) && i.b(this.fotaVersion, watchVersion.fotaVersion);
    }

    public final String getFotaVersion() {
        return this.fotaVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.fotaVersion.hashCode();
    }

    public String toString() {
        return "WatchVersion(version=" + this.version + ", fotaVersion=" + this.fotaVersion + ')';
    }
}
