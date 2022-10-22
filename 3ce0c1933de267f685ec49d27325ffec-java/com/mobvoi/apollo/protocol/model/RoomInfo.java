package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: RoomInfo.kt */
/* loaded from: classes2.dex */
public final class RoomInfo implements JsonBean {
    private final int fileSize;
    private final String md5;
    private final String version;

    public RoomInfo(String version, int i10, String md5) {
        i.f(version, "version");
        i.f(md5, "md5");
        this.version = version;
        this.fileSize = i10;
        this.md5 = md5;
    }

    public static /* synthetic */ RoomInfo copy$default(RoomInfo roomInfo, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = roomInfo.version;
        }
        if ((i11 & 2) != 0) {
            i10 = roomInfo.fileSize;
        }
        if ((i11 & 4) != 0) {
            str2 = roomInfo.md5;
        }
        return roomInfo.copy(str, i10, str2);
    }

    public final String component1() {
        return this.version;
    }

    public final int component2() {
        return this.fileSize;
    }

    public final String component3() {
        return this.md5;
    }

    public final RoomInfo copy(String version, int i10, String md5) {
        i.f(version, "version");
        i.f(md5, "md5");
        return new RoomInfo(version, i10, md5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoomInfo)) {
            return false;
        }
        RoomInfo roomInfo = (RoomInfo) obj;
        return i.b(this.version, roomInfo.version) && this.fileSize == roomInfo.fileSize && i.b(this.md5, roomInfo.md5);
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.version.hashCode() * 31) + this.fileSize) * 31) + this.md5.hashCode();
    }

    public String toString() {
        return "RoomInfo(version=" + this.version + ", fileSize=" + this.fileSize + ", md5=" + this.md5 + ')';
    }
}
