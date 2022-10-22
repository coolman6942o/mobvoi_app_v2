package com.mobvoi.ticwear.youngwatch.data;
/* loaded from: classes2.dex */
public enum PedometerSportsType {
    AEROBIC_SPORT(9),
    AEROBIC_SPORT_12(17),
    AEROBIC_SPORT_6(18),
    BADMINTON(12),
    BASKETBALL(10),
    BODY_BUILDING(5),
    CYCLING(3),
    FITNESS_DANCE(19),
    FOOTBALL(11),
    GAMING(16),
    INDOOR_RUNNING(7),
    PING_PONG(14),
    RUNNABLE_NEW(6),
    RUNNING(1),
    SWIMMING(4),
    TAI_CHI(20),
    UNKNOWN(0),
    VOLLEYBALL(13),
    WALKING(2),
    YOGA(15);
    
    private int value;

    PedometerSportsType(int i10) {
        this.value = i10;
    }

    public static PedometerSportsType getPedometerSportsType(int i10) {
        PedometerSportsType[] values;
        PedometerSportsType pedometerSportsType = RUNNING;
        for (PedometerSportsType pedometerSportsType2 : values()) {
            if (pedometerSportsType2.value == i10) {
                pedometerSportsType = pedometerSportsType2;
            }
        }
        return pedometerSportsType;
    }

    public int getSportMode() {
        return this.value;
    }
}
