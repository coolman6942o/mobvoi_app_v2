package com.cardiex.arty.lite.models.coach;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: SeenStatus.kt */
/* loaded from: classes.dex */
public final class SeenStatus {

    /* renamed from: id  reason: collision with root package name */
    private String f8201id;
    private boolean isSeen;

    public SeenStatus() {
        this(null, false, 3, null);
    }

    public SeenStatus(String str, boolean z10) {
        this.f8201id = str;
        this.isSeen = z10;
    }

    public static /* synthetic */ SeenStatus copy$default(SeenStatus seenStatus, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = seenStatus.f8201id;
        }
        if ((i10 & 2) != 0) {
            z10 = seenStatus.isSeen;
        }
        return seenStatus.copy(str, z10);
    }

    public final String component1() {
        return this.f8201id;
    }

    public final boolean component2() {
        return this.isSeen;
    }

    public final SeenStatus copy(String str, boolean z10) {
        return new SeenStatus(str, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeenStatus)) {
            return false;
        }
        SeenStatus seenStatus = (SeenStatus) obj;
        return i.b(this.f8201id, seenStatus.f8201id) && this.isSeen == seenStatus.isSeen;
    }

    public final String getId() {
        return this.f8201id;
    }

    public int hashCode() {
        String str = this.f8201id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.isSeen;
        if (z10) {
            z10 = true;
        }
        int i10 = z10 ? 1 : 0;
        int i11 = z10 ? 1 : 0;
        return hashCode + i10;
    }

    public final boolean isSeen() {
        return this.isSeen;
    }

    public final void setId(String str) {
        this.f8201id = str;
    }

    public final void setSeen(boolean z10) {
        this.isSeen = z10;
    }

    public String toString() {
        return "SeenStatus(id=" + ((Object) this.f8201id) + ", isSeen=" + this.isSeen + ')';
    }

    public /* synthetic */ SeenStatus(String str, boolean z10, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? true : z10);
    }
}
