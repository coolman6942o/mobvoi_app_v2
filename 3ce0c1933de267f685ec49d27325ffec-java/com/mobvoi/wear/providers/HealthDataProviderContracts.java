package com.mobvoi.wear.providers;
/* loaded from: classes2.dex */
public interface HealthDataProviderContracts {
    public static final String AUTHORITY = "com.mobvoi.health.data.provider";
    public static final String CONTENT_URI_BASE = "content://com.mobvoi.health.data.provider";
    public static final String CONTENT_URI_HEALTH_SUMMARY = "content://com.mobvoi.health.data.provider/health_summary";
    public static final String CONTENT_URI_HEART_RATE = "content://com.mobvoi.health.data.provider/heart_rate";
    public static final String CONTENT_URI_LAST_PRESSURE = "content://com.mobvoi.health.data.provider/pressure";
    public static final String NAME_ACTIVE_PERCENT = "active_percent";
    public static final String NAME_ACTIVE_TIME = "active_time";
    public static final String NAME_ACTIVE_TIME_GOAL = "active_time_goal";
    public static final String NAME_ACTIVE_TIME_STRING = "active_string";
    public static final String NAME_CALORIE = "calorie";
    public static final String NAME_CALORIE_STRING = "calorie_string";
    public static final String NAME_DISTANCE = "distance";
    public static final String NAME_DISTANCE_STRING = "distance_string";
    public static final String NAME_EXERCISE_PERCENT = "exercise_percent";
    public static final String NAME_EXERCISE_TIME = "exercise_time";
    public static final String NAME_EXERCISE_TIME_GOAL = "exercise_time_goal";
    public static final String NAME_EXERCISE_TIME_STRING = "exercise_string";
    public static final String NAME_GOAL_STRING = "goal_string";
    public static final String NAME_HEALTH_SUMMARY = "health_summary";
    public static final String NAME_HEART_RATE = "heart_rate";
    public static final String NAME_HEART_RATE_AVG_REST = "avg_rest_heart_rate";
    public static final String NAME_HEART_RATE_LEVEL = "heart_rate_level";
    public static final String NAME_HEART_RATE_MAX = "max_heart_rate";
    public static final String NAME_HEART_RATE_MIN = "min_heart_rate";
    public static final String NAME_HEART_RATE_STRING = "heart_rate_string";
    public static final String NAME_HEART_RATE_TODAY_STRING = "heart_rate_today_string";
    public static final String NAME_LAST_PRESSURE = "pressure";
    public static final String NAME_STEP_COUNT = "step_count";
    public static final String NAME_STEP_COUNT_GOAL = "step_count_goal";
    public static final String NAME_STEP_PERCENT = "step_percent";
    public static final String NAME_STEP_STRING = "step_string";
    public static final String NAME_TIME = "time";
    public static final String NAME_VALUE = "value";
    public static final String PATH_HEALTH_SUMMARY = "/health_summary";
    public static final String PATH_HEART_RATE = "/heart_rate";
    public static final String PATH_LAST_PRESSURE = "/pressure";

    /* loaded from: classes2.dex */
    public interface HealthSummary {
        public static final int COLUMNS_COUNT = 14;
        public static final String[] COLUMN_NAMES = {HealthDataProviderContracts.NAME_STEP_COUNT, HealthDataProviderContracts.NAME_EXERCISE_TIME, HealthDataProviderContracts.NAME_ACTIVE_TIME, "distance", "calorie", HealthDataProviderContracts.NAME_STEP_STRING, HealthDataProviderContracts.NAME_EXERCISE_TIME_STRING, HealthDataProviderContracts.NAME_ACTIVE_TIME_STRING, HealthDataProviderContracts.NAME_GOAL_STRING, HealthDataProviderContracts.NAME_DISTANCE_STRING, HealthDataProviderContracts.NAME_CALORIE_STRING, HealthDataProviderContracts.NAME_STEP_COUNT_GOAL, HealthDataProviderContracts.NAME_EXERCISE_TIME_GOAL, HealthDataProviderContracts.NAME_ACTIVE_TIME_GOAL};
        public static final int INDEX_ACTIVE_TIME = 2;
        public static final int INDEX_ACTIVE_TIME_GOAL = 13;
        public static final int INDEX_ACTIVE_TIME_STRING = 7;
        public static final int INDEX_CALORIE = 4;
        public static final int INDEX_CALORIE_STRING = 9;
        public static final int INDEX_DISTANCE = 3;
        public static final int INDEX_DISTANCE_STRING = 10;
        public static final int INDEX_EXERCISE_TIME = 1;
        public static final int INDEX_EXERCISE_TIME_GOAL = 12;
        public static final int INDEX_EXERCISE_TIME_STRING = 6;
        public static final int INDEX_GOAL_STRING = 8;
        public static final int INDEX_STEP_COUNT = 0;
        public static final int INDEX_STEP_COUNT_GOAL = 11;
        public static final int INDEX_STEP_STRING = 5;
        public static final int V2_COLUMNS_COUNT = 11;
    }

    /* loaded from: classes2.dex */
    public interface HeartRate {
        public static final int COLUMNS_COUNT = 7;
        public static final String[] COLUMN_NAMES = {HealthDataProviderContracts.NAME_VALUE, "time", HealthDataProviderContracts.NAME_HEART_RATE_STRING, HealthDataProviderContracts.NAME_HEART_RATE_TODAY_STRING, HealthDataProviderContracts.NAME_HEART_RATE_MAX, HealthDataProviderContracts.NAME_HEART_RATE_MIN, HealthDataProviderContracts.NAME_HEART_RATE_AVG_REST};
        public static final int INDEX_HEART_RATE_AVG_REST = 6;
        public static final int INDEX_HEART_RATE_MAX = 4;
        public static final int INDEX_HEART_RATE_MIN = 5;
        public static final int INDEX_HEART_RATE_STRING = 2;
        public static final int INDEX_HEART_RATE_TODAY_STRING = 3;
        public static final int INDEX_TIME = 1;
        public static final int INDEX_VALUE = 0;
        public static final int V2_COLUMNS_COUNT = 4;
    }

    /* loaded from: classes2.dex */
    public interface Pressure {
        public static final int COLUMNS_COUNT = 2;
        public static final String[] COLUMN_NAMES = {HealthDataProviderContracts.NAME_VALUE, "time"};
        public static final int INDEX_TIME = 1;
        public static final int INDEX_VALUE = 0;
    }
}
