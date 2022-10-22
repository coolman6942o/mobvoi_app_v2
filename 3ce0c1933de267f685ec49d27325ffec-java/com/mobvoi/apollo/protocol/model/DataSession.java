package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: DataSession.kt */
/* loaded from: classes2.dex */
public final class DataSession implements JsonBean {
    private final String activityType;
    private final String dataSourceName;
    private final long endTime;
    private final String sessionId;
    private final long startTime;

    public DataSession(String sessionId, String dataSourceName, String activityType, long j10, long j11) {
        i.f(sessionId, "sessionId");
        i.f(dataSourceName, "dataSourceName");
        i.f(activityType, "activityType");
        this.sessionId = sessionId;
        this.dataSourceName = dataSourceName;
        this.activityType = activityType;
        this.startTime = j10;
        this.endTime = j11;
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final String getDataSourceName() {
        return this.dataSourceName;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getStartTime() {
        return this.startTime;
    }
}
