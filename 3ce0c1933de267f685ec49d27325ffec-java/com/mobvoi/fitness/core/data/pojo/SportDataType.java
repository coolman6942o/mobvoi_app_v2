package com.mobvoi.fitness.core.data.pojo;
/* loaded from: classes2.dex */
public enum SportDataType {
    Unknown,
    Duration,
    Distance,
    Calorie,
    HeartRate,
    Steps,
    Group,
    Speed,
    Pace,
    Stride,
    StrideFreq,
    MaxSpeed,
    MaxPace,
    MaxHeartRate,
    MaxStrideFreq,
    Vo2Max,
    Location,
    GpsStatus,
    Motion,
    RawSensor,
    AutoPause,
    MotionState,
    Elevation,
    MaxElevation,
    MinElevation,
    SwimTrips,
    SwimDistance,
    SwimPace,
    SwimStroke,
    SwimType,
    SwimTypeDistance,
    SwimTripSummary,
    SwimPoolLength,
    SwimPoints,
    AiScore,
    CumulativeUp,
    CumulativeDown,
    Lap,
    HiitStages,
    HiitGroup,
    HiitTypeDuration,
    HiitTypeTimes,
    SportActionTimes;

    public static SportDataType from(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return Unknown;
        }
    }
}
