package com.mobvoi.health.common.data.throwable;
/* loaded from: classes2.dex */
public class DefectPermissionThrowable extends SensorThrowable {
    public boolean hasPermission;

    public DefectPermissionThrowable(int i10) {
        super(i10, "defect sensor permission");
        this.hasPermission = i10 != 1 ? false : true;
    }
}
