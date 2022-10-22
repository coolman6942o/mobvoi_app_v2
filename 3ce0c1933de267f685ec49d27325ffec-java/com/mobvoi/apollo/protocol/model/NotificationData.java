package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import ia.a;
import kotlin.jvm.internal.i;
/* compiled from: NotificationData.kt */
/* loaded from: classes2.dex */
public final class NotificationData implements JsonBean {
    private final String appName;
    private final int appType;
    private String icon;
    private final String message;
    private final long timestamp;
    private final String title;

    public NotificationData(String title, String message, String appName, long j10, String str, int i10) {
        i.f(title, "title");
        i.f(message, "message");
        i.f(appName, "appName");
        this.title = title;
        this.message = message;
        this.appName = appName;
        this.timestamp = j10;
        this.icon = str;
        this.appType = i10;
    }

    public static /* synthetic */ NotificationData copy$default(NotificationData notificationData, String str, String str2, String str3, long j10, String str4, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = notificationData.title;
        }
        if ((i11 & 2) != 0) {
            str2 = notificationData.message;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = notificationData.appName;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            j10 = notificationData.timestamp;
        }
        long j11 = j10;
        if ((i11 & 16) != 0) {
            str4 = notificationData.icon;
        }
        String str7 = str4;
        if ((i11 & 32) != 0) {
            i10 = notificationData.appType;
        }
        return notificationData.copy(str, str5, str6, j11, str7, i10);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.appName;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.icon;
    }

    public final int component6() {
        return this.appType;
    }

    public final NotificationData copy(String title, String message, String appName, long j10, String str, int i10) {
        i.f(title, "title");
        i.f(message, "message");
        i.f(appName, "appName");
        return new NotificationData(title, message, appName, j10, str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationData)) {
            return false;
        }
        NotificationData notificationData = (NotificationData) obj;
        return i.b(this.title, notificationData.title) && i.b(this.message, notificationData.message) && i.b(this.appName, notificationData.appName) && this.timestamp == notificationData.timestamp && i.b(this.icon, notificationData.icon) && this.appType == notificationData.appType;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((((this.title.hashCode() * 31) + this.message.hashCode()) * 31) + this.appName.hashCode()) * 31) + a.a(this.timestamp)) * 31;
        String str = this.icon;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appType;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public String toString() {
        return "NotificationData(title=" + this.title + ", message=" + this.message + ", appName=" + this.appName + ", timestamp=" + this.timestamp + ", icon=" + ((Object) this.icon) + ", appType=" + this.appType + ')';
    }
}
