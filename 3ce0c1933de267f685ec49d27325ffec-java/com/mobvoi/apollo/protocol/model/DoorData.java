package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: DoorData.kt */
/* loaded from: classes2.dex */
public final class DoorData implements JsonBean {
    private final String data;
    private final String uid;

    public DoorData(String uid, String data) {
        i.f(uid, "uid");
        i.f(data, "data");
        this.uid = uid;
        this.data = data;
    }

    public static /* synthetic */ DoorData copy$default(DoorData doorData, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = doorData.uid;
        }
        if ((i10 & 2) != 0) {
            str2 = doorData.data;
        }
        return doorData.copy(str, str2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.data;
    }

    public final DoorData copy(String uid, String data) {
        i.f(uid, "uid");
        i.f(data, "data");
        return new DoorData(uid, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoorData)) {
            return false;
        }
        DoorData doorData = (DoorData) obj;
        return i.b(this.uid, doorData.uid) && i.b(this.data, doorData.data);
    }

    public final String getData() {
        return this.data;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (this.uid.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "DoorData(uid=" + this.uid + ", data=" + this.data + ')';
    }
}
