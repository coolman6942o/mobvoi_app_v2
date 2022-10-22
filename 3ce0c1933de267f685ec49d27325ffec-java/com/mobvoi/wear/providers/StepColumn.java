package com.mobvoi.wear.providers;
/* loaded from: classes2.dex */
public interface StepColumn {
    public static final int COLUMN_COUNT = 9;
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_ENABLE = "enable";
    public static final String COLUMN_STEPS = "steps";
    public static final int INDEX_DISTANCE = 1;
    public static final int INDEX_ENABLE = 3;
    public static final int INDEX_GOAL = 2;
    public static final int INDEX_HEALTH_CALORIE = 8;
    public static final int INDEX_HEALTH_COUNT = 6;
    public static final int INDEX_HEALTH_COUNT_GOAL = 7;
    public static final int INDEX_HEALTH_TIME = 4;
    public static final int INDEX_HEALTH_TIME_GOAL = 5;
    public static final int INDEX_STEP = 0;
    public static final String COLUMN_GOAL = "goal";
    public static final String COLUMN_HEALTH_TIME = "health_time";
    public static final String COLUMN_HEALTH_TIME_GOAL = "health_time_goal";
    public static final String COLUMN_HEALTH_COUNT = "health_count";
    public static final String COLUMN_HEALTH_COUNT_GOAL = "health_count_goal";
    public static final String COLUMN_HEALTH_CALORIE = "health_calorie";
    public static final String[] COLUMN_NAMES = {"steps", "distance", COLUMN_GOAL, "enable", COLUMN_HEALTH_TIME, COLUMN_HEALTH_TIME_GOAL, COLUMN_HEALTH_COUNT, COLUMN_HEALTH_COUNT_GOAL, COLUMN_HEALTH_CALORIE};
}
