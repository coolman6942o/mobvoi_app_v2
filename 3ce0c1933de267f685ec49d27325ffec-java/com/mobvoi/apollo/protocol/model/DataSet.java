package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: DataSet.kt */
/* loaded from: classes2.dex */
public final class DataSet implements JsonBean {
    private final String dataSourceName;
    private final long maxEndTime;
    private final long minStartTime;
    private final int pointSize;
    private final List<Point> points;

    /* compiled from: DataSet.kt */
    /* loaded from: classes2.dex */
    public static final class Point implements JsonBean {
        private final String dataType;
        private final int deleted;
        private final long endTime;
        private final long startTime;
        private final String value;

        public Point(long j10, long j11, String dataType, String value, int i10) {
            i.f(dataType, "dataType");
            i.f(value, "value");
            this.startTime = j10;
            this.endTime = j11;
            this.dataType = dataType;
            this.value = value;
            this.deleted = i10;
        }

        public final String getDataType() {
            return this.dataType;
        }

        public final int getDeleted() {
            return this.deleted;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public DataSet(String dataSourceName, long j10, long j11, int i10, l<? super Integer, Point> initPoint) {
        i.f(dataSourceName, "dataSourceName");
        i.f(initPoint, "initPoint");
        this.dataSourceName = dataSourceName;
        this.minStartTime = j10;
        this.maxEndTime = j11;
        this.pointSize = i10;
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(initPoint.invoke(Integer.valueOf(i11)));
        }
        this.points = arrayList;
    }

    public final String getDataSourceName() {
        return this.dataSourceName;
    }

    public final long getMaxEndTime() {
        return this.maxEndTime;
    }

    public final long getMinStartTime() {
        return this.minStartTime;
    }

    public final int getPointSize() {
        return this.pointSize;
    }

    public final List<Point> getPoints() {
        return this.points;
    }
}
