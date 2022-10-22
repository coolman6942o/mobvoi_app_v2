package com.mobvoi.wear.mcu;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
/* loaded from: classes2.dex */
public class FitnessMcuData implements Parcelable {
    public static final Parcelable.Creator<FitnessMcuData> CREATOR = new Parcelable.Creator<FitnessMcuData>() { // from class: com.mobvoi.wear.mcu.FitnessMcuData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FitnessMcuData createFromParcel(Parcel parcel) {
            return new FitnessMcuData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FitnessMcuData[] newArray(int i10) {
            return new FitnessMcuData[i10];
        }
    };
    public static final int GPS_NONE = 0;
    public static final int GPS_PREPARED = 1;
    public static final int GPS_SEARCHING = 2;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSING = 3;
    public static final int STATE_PREPARE = 1;
    public static final int STATE_RUNNING = 2;
    public static final int STATE_STOPPED = 4;
    public static final int TYPE_FREE_SWIMMING = 6;
    public static final int TYPE_FREE_WORKOUT = 5;
    public static final int TYPE_INDOOR_RUNNING = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OUTDOOR_BIKE = 4;
    public static final int TYPE_OUTDOOR_RUNNING = 3;
    public static final int TYPE_OUTDOOR_WALK = 2;
    public int calorie;
    public float distance;
    public int down;
    @Deprecated
    public int duration;
    public long durationMs;
    public int gpsStatus;
    public int heartRate;
    public boolean isKilometer;
    public long lastUpdateTime;
    public int pace;
    public float speed;
    public int state;
    public int type;

    /* renamed from: up  reason: collision with root package name */
    public int f20939up;

    public FitnessMcuData() {
    }

    private void readFromParcel(Parcel parcel) {
        this.type = parcel.readInt();
        this.state = parcel.readInt();
        this.heartRate = parcel.readInt();
        this.duration = parcel.readInt();
        this.calorie = parcel.readInt();
        this.distance = parcel.readFloat();
        this.speed = parcel.readFloat();
        this.pace = parcel.readInt();
        this.gpsStatus = parcel.readInt();
        boolean z10 = true;
        if (parcel.readInt() != 1) {
            z10 = false;
        }
        this.isKilometer = z10;
        this.durationMs = parcel.readLong();
        this.lastUpdateTime = parcel.readLong();
        if (parcel.dataAvail() > 0) {
            this.down = parcel.readInt();
        }
        if (parcel.dataAvail() > 0) {
            this.f20939up = parcel.readInt();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "FitnessMcuData %d {type = %d, state = %d, heartRate = %d, duration = %d, calorie = %d, distance = %.2f, speed = %.2f, pace = %d, gpsStatus = %d, isKilometer = %s, lastUpdateTime = %d, down = %dup = %d}", Integer.valueOf(hashCode()), Integer.valueOf(this.type), Integer.valueOf(this.state), Integer.valueOf(this.heartRate), Long.valueOf(this.durationMs), Integer.valueOf(this.calorie), Float.valueOf(this.distance), Float.valueOf(this.speed), Integer.valueOf(this.pace), Integer.valueOf(this.gpsStatus), Boolean.valueOf(this.isKilometer), Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.down), Integer.valueOf(this.f20939up));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.state);
        parcel.writeInt(this.heartRate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.calorie);
        parcel.writeFloat(this.distance);
        parcel.writeFloat(this.speed);
        parcel.writeInt(this.pace);
        parcel.writeInt(this.gpsStatus);
        parcel.writeInt(this.isKilometer ? 1 : 0);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeInt(this.down);
        parcel.writeInt(this.f20939up);
    }

    protected FitnessMcuData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
