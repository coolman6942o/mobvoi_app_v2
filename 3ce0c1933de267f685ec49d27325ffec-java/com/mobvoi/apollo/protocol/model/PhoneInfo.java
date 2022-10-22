package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import ia.a;
import kotlin.jvm.internal.i;
/* compiled from: PhoneInfo.kt */
/* loaded from: classes2.dex */
public final class PhoneInfo implements JsonBean {
    private final int accountId;
    private final long timestamp;
    private final String token;
    private final String wwid;

    public PhoneInfo(String wwid, String token, int i10, long j10) {
        i.f(wwid, "wwid");
        i.f(token, "token");
        this.wwid = wwid;
        this.token = token;
        this.accountId = i10;
        this.timestamp = j10;
    }

    public static /* synthetic */ PhoneInfo copy$default(PhoneInfo phoneInfo, String str, String str2, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = phoneInfo.wwid;
        }
        if ((i11 & 2) != 0) {
            str2 = phoneInfo.token;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            i10 = phoneInfo.accountId;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            j10 = phoneInfo.timestamp;
        }
        return phoneInfo.copy(str, str3, i12, j10);
    }

    public final String component1() {
        return this.wwid;
    }

    public final String component2() {
        return this.token;
    }

    public final int component3() {
        return this.accountId;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final PhoneInfo copy(String wwid, String token, int i10, long j10) {
        i.f(wwid, "wwid");
        i.f(token, "token");
        return new PhoneInfo(wwid, token, i10, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneInfo)) {
            return false;
        }
        PhoneInfo phoneInfo = (PhoneInfo) obj;
        return i.b(this.wwid, phoneInfo.wwid) && i.b(this.token, phoneInfo.token) && this.accountId == phoneInfo.accountId && this.timestamp == phoneInfo.timestamp;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getWwid() {
        return this.wwid;
    }

    public int hashCode() {
        return (((((this.wwid.hashCode() * 31) + this.token.hashCode()) * 31) + this.accountId) * 31) + a.a(this.timestamp);
    }

    public String toString() {
        return "PhoneInfo(wwid=" + this.wwid + ", token=" + this.token + ", accountId=" + this.accountId + ", timestamp=" + this.timestamp + ')';
    }
}
