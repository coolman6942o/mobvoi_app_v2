package com.mobvoi.health.common.data.pojo;

import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import xf.b;
import xf.c;
import xf.d;
import xf.e;
/* loaded from: classes2.dex */
public enum DataType implements c, e {
    HeartRate(1, "heart_rate"),
    Motion(2, "sleep_motion"),
    Location(3, ""),
    Calorie(4, "calorie"),
    Distance(5, "distance"),
    Step(6, HealthDataProviderContracts.NAME_STEP_COUNT),
    Exercise(7, "exercise"),
    DeltaCalorie(8, "delta_calorie"),
    DeltaDistance(9, "delta_distance"),
    DeltaStep(10, "delta_step"),
    DeltaExercise(11, "delta_exercise"),
    PeriodEvent(12, "period_event"),
    PeriodCycleLength(13, "period_cycle_length"),
    PeriodMenstruationLength(14, "period_menstruation_length"),
    HeartRateWarning(15, "heart_rate_warning"),
    HeartRateWarningFitnessUpperLimit(16, "heart_rate_warning_fitness_upper_limit"),
    HeartRateWarningRestUpperLimit(17, "heart_rate_warning_rest_upper_limit"),
    HeartRateWarningRestLowerLimit(18, "heart_rate_warning_rest_lower_limit"),
    GoalTodayStep(19, "goal_today_step"),
    GoalTodayActive(20, "goal_today_active"),
    GoalTodayExercise(21, "goal_today_exercise"),
    TodayMood(22, "today_mood"),
    InfoGender(23, "info_gender"),
    InfoBirthday(24, "info_birthday"),
    InfoHeight(25, "info_height"),
    InfoWeight(26, "info_weight"),
    NOISE_DECIBEL(27, "noise_decibel"),
    BloodOxygen(28, "blood_oxygen"),
    Pressure(29, HealthDataProviderContracts.NAME_LAST_PRESSURE),
    HighStrengthTraining(30, "high_strength_training"),
    AISportGrade(31, "ai_sport_grade"),
    Temperature(32, SettingConstants.TEMPERATURE),
    ExpectedSleepTime(33, "expected_sleep_time"),
    ExpectedGetUpTime(34, "expected_get_up_time"),
    ArtyData(35, "arty_data"),
    HeartHealth(36, "heart_health"),
    BodyAndMindState(37, "body_mind_state"),
    Unknown,
    Speed;
    
    public final String name;
    public final int typeCode;

    DataType() {
        this(-1, "");
    }

    public static DataType from(int i10) {
        return (DataType) b.b(DataType.class, i10);
    }

    @Override // xf.e
    public String getName() {
        return this.name;
    }

    @Override // xf.c
    public int getTypeCode() {
        return this.typeCode;
    }

    public /* bridge */ /* synthetic */ boolean isLocal() {
        return d.a(this);
    }

    public /* bridge */ /* synthetic */ boolean isPersistent() {
        return b.a(this);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name + " : " + this.typeCode;
    }

    DataType(int i10, String str) {
        this.typeCode = i10;
        this.name = str;
    }

    public static DataType from(String str) {
        return (DataType) d.b(DataType.class, str);
    }
}
