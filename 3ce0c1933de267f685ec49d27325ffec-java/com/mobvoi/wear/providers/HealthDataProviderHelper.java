package com.mobvoi.wear.providers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mobvoi.android.common.utils.k;
/* loaded from: classes2.dex */
public class HealthDataProviderHelper {
    public static final String TAG = "HealthDataProviderHelpe";

    /* loaded from: classes2.dex */
    public static class HealthSummary {
        public int activeTime;
        public int activeTimeGoal;
        public String activeTimeString;
        public int calorie;
        public String calorieString;
        public int distance;
        public String distanceString;
        public int exerciseTime;
        public int exerciseTimeGoal;
        public String exerciseTimeString;
        public String healthGoalString;
        public int stepCountGoal;
        public int steps;
        public String stepsString;

        public int getActiveTimePercent() {
            int i10 = this.activeTimeGoal;
            if (i10 == 0) {
                return 0;
            }
            return (int) ((this.activeTime * 100.0f) / i10);
        }

        public int getExerciseTimePercent() {
            int i10 = this.exerciseTimeGoal;
            if (i10 == 0) {
                return 0;
            }
            return (int) ((this.exerciseTime * 100.0f) / i10);
        }

        public int getStepsPercent() {
            int i10 = this.stepCountGoal;
            if (i10 == 0) {
                return 0;
            }
            return (int) ((this.steps * 100.0f) / i10);
        }

        public String toString() {
            return "HealthSummary{steps=" + this.steps + ", exerciseTime=" + this.exerciseTime + ", activeTime=" + this.activeTime + ", distance=" + this.distance + ", calorie=" + this.calorie + ", stepsString='" + this.stepsString + "', exerciseTimeString='" + this.exerciseTimeString + "', activeTimeString='" + this.activeTimeString + "', healthGoalString='" + this.healthGoalString + "', calorieString='" + this.calorieString + "', distanceString='" + this.distanceString + "', stepCountGoal=" + this.stepCountGoal + ", exerciseTimeGoal=" + this.exerciseTimeGoal + ", activeTimeGoal=" + this.activeTimeGoal + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class HeartRate {
        public String dailyText;
        public int heartRateAvgRest;
        public int heartRateMax;
        public int heartRateMin;
        public String recentText;
        public long timestamp;
        public int value;

        public String toString() {
            return "HeartRate{value=" + this.value + ", timestamp=" + this.timestamp + ", recentText='" + this.recentText + "', dailyText='" + this.dailyText + "', heartRateMax=" + this.heartRateMax + ", heartRateMin=" + this.heartRateMin + ", heartRateAvgRest=" + this.heartRateAvgRest + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class Pressure {
        public long timestamp;
        public int value;

        public String toString() {
            return "Pressure{value=" + this.value + ", timestamp=" + this.timestamp + '}';
        }
    }

    public static boolean isProviderAvailable(Context context) {
        return context.getPackageManager().resolveContentProvider(HealthDataProviderContracts.AUTHORITY, 0) != null;
    }

    public static HealthSummary queryHealthSummary(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(HealthDataProviderContracts.CONTENT_URI_HEALTH_SUMMARY), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    HealthSummary healthSummary = new HealthSummary();
                    healthSummary.steps = query.getInt(0);
                    healthSummary.exerciseTime = query.getInt(1);
                    healthSummary.activeTime = query.getInt(2);
                    healthSummary.distance = query.getInt(3);
                    healthSummary.calorie = query.getInt(4);
                    int columnCount = query.getColumnCount();
                    if (columnCount >= 11) {
                        healthSummary.stepsString = query.getString(5);
                        healthSummary.exerciseTimeString = query.getString(6);
                        healthSummary.activeTimeString = query.getString(7);
                        healthSummary.healthGoalString = query.getString(8);
                        healthSummary.calorieString = query.getString(9);
                        healthSummary.distanceString = query.getString(10);
                    }
                    if (columnCount >= 14) {
                        healthSummary.stepCountGoal = query.getInt(11);
                        healthSummary.exerciseTimeGoal = query.getInt(12);
                        healthSummary.activeTimeGoal = query.getInt(13);
                    }
                    k.c(TAG, "HealthSummary %s", healthSummary);
                    query.close();
                    return healthSummary;
                }
            } catch (Throwable th2) {
                try {
                    query.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (query != null) {
            query.close();
        }
        return null;
    }

    public static HeartRate queryHeartRate(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(HealthDataProviderContracts.CONTENT_URI_HEART_RATE), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    HeartRate heartRate = new HeartRate();
                    heartRate.value = query.getInt(0);
                    heartRate.timestamp = query.getLong(1);
                    int columnCount = query.getColumnCount();
                    if (columnCount >= 4) {
                        heartRate.recentText = query.getString(2);
                        heartRate.dailyText = query.getString(3);
                    }
                    if (columnCount >= 7) {
                        heartRate.heartRateMax = query.getInt(4);
                        heartRate.heartRateMin = query.getInt(5);
                        heartRate.heartRateAvgRest = query.getInt(6);
                    }
                    k.c(TAG, "HeartRate %s", heartRate);
                    query.close();
                    return heartRate;
                }
            } catch (Throwable th2) {
                try {
                    query.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (query != null) {
            query.close();
        }
        return null;
    }

    public static Pressure queryLastPressure(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(HealthDataProviderContracts.CONTENT_URI_LAST_PRESSURE), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    Pressure pressure = new Pressure();
                    pressure.value = query.getInt(0);
                    pressure.timestamp = query.getLong(1);
                    k.c(TAG, "Pressure %s", pressure);
                    query.close();
                    return pressure;
                }
            } catch (Throwable th2) {
                try {
                    query.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (query != null) {
            query.close();
        }
        return null;
    }
}
