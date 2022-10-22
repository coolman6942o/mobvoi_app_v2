package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import java.util.Arrays;
import kotlin.jvm.internal.i;
/* compiled from: DoorCardData.kt */
/* loaded from: classes2.dex */
public final class DoorCardData implements JsonBean {
    private final byte[] aid;
    private final String name;
    private final int type;

    public DoorCardData(String name, byte[] aid, int i10) {
        i.f(name, "name");
        i.f(aid, "aid");
        this.name = name;
        this.aid = aid;
        this.type = i10;
    }

    public static /* synthetic */ DoorCardData copy$default(DoorCardData doorCardData, String str, byte[] bArr, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = doorCardData.name;
        }
        if ((i11 & 2) != 0) {
            bArr = doorCardData.aid;
        }
        if ((i11 & 4) != 0) {
            i10 = doorCardData.type;
        }
        return doorCardData.copy(str, bArr, i10);
    }

    public final String component1() {
        return this.name;
    }

    public final byte[] component2() {
        return this.aid;
    }

    public final int component3() {
        return this.type;
    }

    public final DoorCardData copy(String name, byte[] aid, int i10) {
        i.f(name, "name");
        i.f(aid, "aid");
        return new DoorCardData(name, aid, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoorCardData)) {
            return false;
        }
        DoorCardData doorCardData = (DoorCardData) obj;
        return i.b(this.name, doorCardData.name) && i.b(this.aid, doorCardData.aid) && this.type == doorCardData.type;
    }

    public final byte[] getAid() {
        return this.aid;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Arrays.hashCode(this.aid)) * 31) + this.type;
    }

    public String toString() {
        return "DoorCardData(name=" + this.name + ", aid=" + Arrays.toString(this.aid) + ", type=" + this.type + ')';
    }
}
