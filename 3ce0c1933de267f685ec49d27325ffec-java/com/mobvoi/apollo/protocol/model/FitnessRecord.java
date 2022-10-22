package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import java.util.ArrayList;
import kotlin.jvm.internal.i;
/* compiled from: FitnessRecord.kt */
/* loaded from: classes2.dex */
public final class FitnessRecord implements JsonBean {
    private int accountId;
    private int avgHeartRate;
    private long endAt;
    private int sessionMode;
    private long startAt;
    private long timestamp;
    private int totalCalorie;
    private int totalDistance;
    private long totalMotionTime;
    private int totalSteps;
    private float cumulativeDown = -1.0f;
    private float cumulativeUp = -1.0f;
    private String deviceId = "";

    /* renamed from: id  reason: collision with root package name */
    private String f15613id = "";
    private float maxElevation = -1.0f;
    private float minElevation = -1.0f;
    private float objective = -1.0f;
    private String objectiveType = "";
    private String type = "";
    private float score = -1.0f;
    private int swimDistance = -1;
    private int swimPoolLength = -1;
    private int swimStroke = -1;
    private float swimTrips = -1.0f;
    private ArrayList<TrackPoint> trackPoints = new ArrayList<>();

    /* compiled from: FitnessRecord.kt */
    /* loaded from: classes2.dex */
    public static final class TrackPoint implements JsonBean {
        private int distance;
        private int heartRate;
        private boolean resume;
        private int steps;
        private long timestamp;
        private double velocity;
        private long wallClockTimestamp;
        private float elevation = -1.0f;
        private String GPSPoint = "";
        private float GPSState = -1.0f;
        private int swimStroke = -1;
        private float swimTrips = -1.0f;
        private int swimType = -1;

        public final int getDistance() {
            return this.distance;
        }

        public final float getElevation() {
            return this.elevation;
        }

        public final String getGPSPoint() {
            return this.GPSPoint;
        }

        public final float getGPSState() {
            return this.GPSState;
        }

        public final int getHeartRate() {
            return this.heartRate;
        }

        public final boolean getResume() {
            return this.resume;
        }

        public final int getSteps() {
            return this.steps;
        }

        public final int getSwimStroke() {
            return this.swimStroke;
        }

        public final float getSwimTrips() {
            return this.swimTrips;
        }

        public final int getSwimType() {
            return this.swimType;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final double getVelocity() {
            return this.velocity;
        }

        public final long getWallClockTimestamp() {
            return this.wallClockTimestamp;
        }

        public final void setDistance(int i10) {
            this.distance = i10;
        }

        public final void setElevation(float f10) {
            this.elevation = f10;
        }

        public final void setGPSPoint(String str) {
            i.f(str, "<set-?>");
            this.GPSPoint = str;
        }

        public final void setGPSState(float f10) {
            this.GPSState = f10;
        }

        public final void setHeartRate(int i10) {
            this.heartRate = i10;
        }

        public final void setResume(boolean z10) {
            this.resume = z10;
        }

        public final void setSteps(int i10) {
            this.steps = i10;
        }

        public final void setSwimStroke(int i10) {
            this.swimStroke = i10;
        }

        public final void setSwimTrips(float f10) {
            this.swimTrips = f10;
        }

        public final void setSwimType(int i10) {
            this.swimType = i10;
        }

        public final void setTimestamp(long j10) {
            this.timestamp = j10;
        }

        public final void setVelocity(double d10) {
            this.velocity = d10;
        }

        public final void setWallClockTimestamp(long j10) {
            this.wallClockTimestamp = j10;
        }
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final int getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public final float getCumulativeDown() {
        return this.cumulativeDown;
    }

    public final float getCumulativeUp() {
        return this.cumulativeUp;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getEndAt() {
        return this.endAt;
    }

    public final String getId() {
        return this.f15613id;
    }

    public final float getMaxElevation() {
        return this.maxElevation;
    }

    public final float getMinElevation() {
        return this.minElevation;
    }

    public final float getObjective() {
        return this.objective;
    }

    public final String getObjectiveType() {
        return this.objectiveType;
    }

    public final float getScore() {
        return this.score;
    }

    public final int getSessionMode() {
        return this.sessionMode;
    }

    public final long getStartAt() {
        return this.startAt;
    }

    public final int getSwimDistance() {
        return this.swimDistance;
    }

    public final int getSwimPoolLength() {
        return this.swimPoolLength;
    }

    public final int getSwimStroke() {
        return this.swimStroke;
    }

    public final float getSwimTrips() {
        return this.swimTrips;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getTotalCalorie() {
        return this.totalCalorie;
    }

    public final int getTotalDistance() {
        return this.totalDistance;
    }

    public final long getTotalMotionTime() {
        return this.totalMotionTime;
    }

    public final int getTotalSteps() {
        return this.totalSteps;
    }

    public final ArrayList<TrackPoint> getTrackPoints() {
        return this.trackPoints;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAccountId(int i10) {
        this.accountId = i10;
    }

    public final void setAvgHeartRate(int i10) {
        this.avgHeartRate = i10;
    }

    public final void setCumulativeDown(float f10) {
        this.cumulativeDown = f10;
    }

    public final void setCumulativeUp(float f10) {
        this.cumulativeUp = f10;
    }

    public final void setDeviceId(String str) {
        i.f(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setEndAt(long j10) {
        this.endAt = j10;
    }

    public final void setId(String str) {
        i.f(str, "<set-?>");
        this.f15613id = str;
    }

    public final void setMaxElevation(float f10) {
        this.maxElevation = f10;
    }

    public final void setMinElevation(float f10) {
        this.minElevation = f10;
    }

    public final void setObjective(float f10) {
        this.objective = f10;
    }

    public final void setObjectiveType(String str) {
        i.f(str, "<set-?>");
        this.objectiveType = str;
    }

    public final void setScore(float f10) {
        this.score = f10;
    }

    public final void setSessionMode(int i10) {
        this.sessionMode = i10;
    }

    public final void setStartAt(long j10) {
        this.startAt = j10;
    }

    public final void setSwimDistance(int i10) {
        this.swimDistance = i10;
    }

    public final void setSwimPoolLength(int i10) {
        this.swimPoolLength = i10;
    }

    public final void setSwimStroke(int i10) {
        this.swimStroke = i10;
    }

    public final void setSwimTrips(float f10) {
        this.swimTrips = f10;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public final void setTotalCalorie(int i10) {
        this.totalCalorie = i10;
    }

    public final void setTotalDistance(int i10) {
        this.totalDistance = i10;
    }

    public final void setTotalMotionTime(long j10) {
        this.totalMotionTime = j10;
    }

    public final void setTotalSteps(int i10) {
        this.totalSteps = i10;
    }

    public final void setTrackPoints(ArrayList<TrackPoint> arrayList) {
        i.f(arrayList, "<set-?>");
        this.trackPoints = arrayList;
    }

    public final void setType(String str) {
        i.f(str, "<set-?>");
        this.type = str;
    }
}
