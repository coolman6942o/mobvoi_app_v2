package com.mobvoi.wear.battery.nano;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface WearBatteryStatsProtos {

    /* loaded from: classes2.dex */
    public static final class AppUsage extends c {
        public static final int APP = 7;
        public static final int BLUETOOTH = 4;
        public static final int CELL = 1;
        public static final int FLASHLIGHT = 5;
        public static final int IDLE = 0;
        public static final int OVERCOUNTED = 10;
        public static final int PHONE = 2;
        public static final int SCREEN = 6;
        public static final int UNACCOUNTED = 9;
        public static final int USER = 8;
        public static final int WIFI = 3;
        private static volatile AppUsage[] _emptyArray;
        public int draintype;
        public String packageLabel;
        public String packageWithHighestDrain;
        public float percentOfMax;
        public float percentOfTotal;
        public float power;
        public int uid;

        public AppUsage() {
            clear();
        }

        public static AppUsage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (b.f13297b) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppUsage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static AppUsage parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (AppUsage) c.mergeFrom(new AppUsage(), bArr);
        }

        public AppUsage clear() {
            this.draintype = 0;
            this.uid = 0;
            this.power = 0.0f;
            this.percentOfMax = 0.0f;
            this.percentOfTotal = 0.0f;
            this.packageWithHighestDrain = "";
            this.packageLabel = "";
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.c
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i10 = this.draintype;
            if (i10 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.h(1, i10);
            }
            int i11 = this.uid;
            if (i11 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.u(2, i11);
            }
            if (Float.floatToIntBits(this.power) != Float.floatToIntBits(0.0f)) {
                computeSerializedSize += CodedOutputByteBufferNano.f(3, this.power);
            }
            if (Float.floatToIntBits(this.percentOfMax) != Float.floatToIntBits(0.0f)) {
                computeSerializedSize += CodedOutputByteBufferNano.f(4, this.percentOfMax);
            }
            if (Float.floatToIntBits(this.percentOfTotal) != Float.floatToIntBits(0.0f)) {
                computeSerializedSize += CodedOutputByteBufferNano.f(5, this.percentOfTotal);
            }
            if (!this.packageWithHighestDrain.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.r(6, this.packageWithHighestDrain);
            }
            return !this.packageLabel.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(7, this.packageLabel) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.c
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i10 = this.draintype;
            if (i10 != 0) {
                codedOutputByteBufferNano.M(1, i10);
            }
            int i11 = this.uid;
            if (i11 != 0) {
                codedOutputByteBufferNano.e0(2, i11);
            }
            if (Float.floatToIntBits(this.power) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.K(3, this.power);
            }
            if (Float.floatToIntBits(this.percentOfMax) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.K(4, this.percentOfMax);
            }
            if (Float.floatToIntBits(this.percentOfTotal) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.K(5, this.percentOfTotal);
            }
            if (!this.packageWithHighestDrain.equals("")) {
                codedOutputByteBufferNano.b0(6, this.packageWithHighestDrain);
            }
            if (!this.packageLabel.equals("")) {
                codedOutputByteBufferNano.b0(7, this.packageLabel);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static AppUsage parseFrom(a aVar) throws IOException {
            return new AppUsage().mergeFrom(aVar);
        }

        @Override // com.google.protobuf.nano.c
        public AppUsage mergeFrom(a aVar) throws IOException {
            while (true) {
                int v10 = aVar.v();
                if (v10 == 0) {
                    return this;
                }
                if (v10 == 8) {
                    int k10 = aVar.k();
                    switch (k10) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            this.draintype = k10;
                            continue;
                    }
                } else if (v10 == 16) {
                    this.uid = aVar.w();
                } else if (v10 == 29) {
                    this.power = aVar.j();
                } else if (v10 == 37) {
                    this.percentOfMax = aVar.j();
                } else if (v10 == 45) {
                    this.percentOfTotal = aVar.j();
                } else if (v10 == 50) {
                    this.packageWithHighestDrain = aVar.u();
                } else if (v10 == 58) {
                    this.packageLabel = aVar.u();
                } else if (!e.e(aVar, v10)) {
                    return this;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class BatteryHistory extends c {
        private static volatile BatteryHistory[] _emptyArray;
        public int level;
        public long time;

        public BatteryHistory() {
            clear();
        }

        public static BatteryHistory[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (b.f13297b) {
                    if (_emptyArray == null) {
                        _emptyArray = new BatteryHistory[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static BatteryHistory parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (BatteryHistory) c.mergeFrom(new BatteryHistory(), bArr);
        }

        public BatteryHistory clear() {
            this.level = 0;
            this.time = 0L;
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.c
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i10 = this.level;
            if (i10 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.u(1, i10);
            }
            long j10 = this.time;
            return j10 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.w(2, j10) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.c
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i10 = this.level;
            if (i10 != 0) {
                codedOutputByteBufferNano.e0(1, i10);
            }
            long j10 = this.time;
            if (j10 != 0) {
                codedOutputByteBufferNano.g0(2, j10);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static BatteryHistory parseFrom(a aVar) throws IOException {
            return new BatteryHistory().mergeFrom(aVar);
        }

        @Override // com.google.protobuf.nano.c
        public BatteryHistory mergeFrom(a aVar) throws IOException {
            while (true) {
                int v10 = aVar.v();
                if (v10 == 0) {
                    return this;
                }
                if (v10 == 8) {
                    this.level = aVar.w();
                } else if (v10 == 16) {
                    this.time = aVar.x();
                } else if (!e.e(aVar, v10)) {
                    return this;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class WearBatteryStats extends c {
        public static final int STATS_CURRENT = 1;
        public static final int STATS_SINCE_CHARGED = 0;
        public static final int STATS_SINCE_UNPLUGGED = 2;
        private static volatile WearBatteryStats[] _emptyArray;
        public AppUsage[] appUsage;
        public BatteryHistory[] batteryHistory;
        public long batteryTimeRemain;
        public long chargeTimeRemain;
        public int curLevel;
        public long fullWakelockTime;
        public boolean isCharging;
        public long kernelWakelockTime;
        public long screenOffUptime;
        public long screenOnTime;
        public int statsType;
        public long totalTime;
        public long userWakelockTime;

        public WearBatteryStats() {
            clear();
        }

        public static WearBatteryStats[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (b.f13297b) {
                    if (_emptyArray == null) {
                        _emptyArray = new WearBatteryStats[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static WearBatteryStats parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (WearBatteryStats) c.mergeFrom(new WearBatteryStats(), bArr);
        }

        public WearBatteryStats clear() {
            this.statsType = 0;
            this.curLevel = 0;
            this.batteryTimeRemain = 0L;
            this.chargeTimeRemain = 0L;
            this.appUsage = AppUsage.emptyArray();
            this.batteryHistory = BatteryHistory.emptyArray();
            this.isCharging = false;
            this.totalTime = 0L;
            this.screenOnTime = 0L;
            this.screenOffUptime = 0L;
            this.fullWakelockTime = 0L;
            this.userWakelockTime = 0L;
            this.kernelWakelockTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.c
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i10 = this.statsType;
            if (i10 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.h(1, i10);
            }
            int i11 = this.curLevel;
            if (i11 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.u(2, i11);
            }
            long j10 = this.batteryTimeRemain;
            if (j10 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(3, j10);
            }
            long j11 = this.chargeTimeRemain;
            if (j11 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(4, j11);
            }
            AppUsage[] appUsageArr = this.appUsage;
            int i12 = 0;
            if (appUsageArr != null && appUsageArr.length > 0) {
                int i13 = 0;
                while (true) {
                    AppUsage[] appUsageArr2 = this.appUsage;
                    if (i13 >= appUsageArr2.length) {
                        break;
                    }
                    AppUsage appUsage = appUsageArr2[i13];
                    if (appUsage != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.l(5, appUsage);
                    }
                    i13++;
                }
            }
            BatteryHistory[] batteryHistoryArr = this.batteryHistory;
            if (batteryHistoryArr != null && batteryHistoryArr.length > 0) {
                while (true) {
                    BatteryHistory[] batteryHistoryArr2 = this.batteryHistory;
                    if (i12 >= batteryHistoryArr2.length) {
                        break;
                    }
                    BatteryHistory batteryHistory = batteryHistoryArr2[i12];
                    if (batteryHistory != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.l(6, batteryHistory);
                    }
                    i12++;
                }
            }
            boolean z10 = this.isCharging;
            if (z10) {
                computeSerializedSize += CodedOutputByteBufferNano.b(7, z10);
            }
            long j12 = this.totalTime;
            if (j12 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(8, j12);
            }
            long j13 = this.screenOnTime;
            if (j13 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(9, j13);
            }
            long j14 = this.screenOffUptime;
            if (j14 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(10, j14);
            }
            long j15 = this.fullWakelockTime;
            if (j15 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(11, j15);
            }
            long j16 = this.userWakelockTime;
            if (j16 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.w(12, j16);
            }
            long j17 = this.kernelWakelockTime;
            return j17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.w(13, j17) : computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.c
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i10 = this.statsType;
            if (i10 != 0) {
                codedOutputByteBufferNano.M(1, i10);
            }
            int i11 = this.curLevel;
            if (i11 != 0) {
                codedOutputByteBufferNano.e0(2, i11);
            }
            long j10 = this.batteryTimeRemain;
            if (j10 != 0) {
                codedOutputByteBufferNano.g0(3, j10);
            }
            long j11 = this.chargeTimeRemain;
            if (j11 != 0) {
                codedOutputByteBufferNano.g0(4, j11);
            }
            AppUsage[] appUsageArr = this.appUsage;
            int i12 = 0;
            if (appUsageArr != null && appUsageArr.length > 0) {
                int i13 = 0;
                while (true) {
                    AppUsage[] appUsageArr2 = this.appUsage;
                    if (i13 >= appUsageArr2.length) {
                        break;
                    }
                    AppUsage appUsage = appUsageArr2[i13];
                    if (appUsage != null) {
                        codedOutputByteBufferNano.Q(5, appUsage);
                    }
                    i13++;
                }
            }
            BatteryHistory[] batteryHistoryArr = this.batteryHistory;
            if (batteryHistoryArr != null && batteryHistoryArr.length > 0) {
                while (true) {
                    BatteryHistory[] batteryHistoryArr2 = this.batteryHistory;
                    if (i12 >= batteryHistoryArr2.length) {
                        break;
                    }
                    BatteryHistory batteryHistory = batteryHistoryArr2[i12];
                    if (batteryHistory != null) {
                        codedOutputByteBufferNano.Q(6, batteryHistory);
                    }
                    i12++;
                }
            }
            boolean z10 = this.isCharging;
            if (z10) {
                codedOutputByteBufferNano.G(7, z10);
            }
            long j12 = this.totalTime;
            if (j12 != 0) {
                codedOutputByteBufferNano.g0(8, j12);
            }
            long j13 = this.screenOnTime;
            if (j13 != 0) {
                codedOutputByteBufferNano.g0(9, j13);
            }
            long j14 = this.screenOffUptime;
            if (j14 != 0) {
                codedOutputByteBufferNano.g0(10, j14);
            }
            long j15 = this.fullWakelockTime;
            if (j15 != 0) {
                codedOutputByteBufferNano.g0(11, j15);
            }
            long j16 = this.userWakelockTime;
            if (j16 != 0) {
                codedOutputByteBufferNano.g0(12, j16);
            }
            long j17 = this.kernelWakelockTime;
            if (j17 != 0) {
                codedOutputByteBufferNano.g0(13, j17);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static WearBatteryStats parseFrom(a aVar) throws IOException {
            return new WearBatteryStats().mergeFrom(aVar);
        }

        @Override // com.google.protobuf.nano.c
        public WearBatteryStats mergeFrom(a aVar) throws IOException {
            while (true) {
                int v10 = aVar.v();
                switch (v10) {
                    case 0:
                        return this;
                    case 8:
                        int k10 = aVar.k();
                        if (k10 != 0 && k10 != 1 && k10 != 2) {
                            break;
                        } else {
                            this.statsType = k10;
                            break;
                        }
                    case 16:
                        this.curLevel = aVar.w();
                        break;
                    case 24:
                        this.batteryTimeRemain = aVar.x();
                        break;
                    case 32:
                        this.chargeTimeRemain = aVar.x();
                        break;
                    case 42:
                        int a10 = e.a(aVar, 42);
                        AppUsage[] appUsageArr = this.appUsage;
                        int length = appUsageArr == null ? 0 : appUsageArr.length;
                        int i10 = a10 + length;
                        AppUsage[] appUsageArr2 = new AppUsage[i10];
                        if (length != 0) {
                            System.arraycopy(appUsageArr, 0, appUsageArr2, 0, length);
                        }
                        while (length < i10 - 1) {
                            appUsageArr2[length] = new AppUsage();
                            aVar.m(appUsageArr2[length]);
                            aVar.v();
                            length++;
                        }
                        appUsageArr2[length] = new AppUsage();
                        aVar.m(appUsageArr2[length]);
                        this.appUsage = appUsageArr2;
                        break;
                    case 50:
                        int a11 = e.a(aVar, 50);
                        BatteryHistory[] batteryHistoryArr = this.batteryHistory;
                        int length2 = batteryHistoryArr == null ? 0 : batteryHistoryArr.length;
                        int i11 = a11 + length2;
                        BatteryHistory[] batteryHistoryArr2 = new BatteryHistory[i11];
                        if (length2 != 0) {
                            System.arraycopy(batteryHistoryArr, 0, batteryHistoryArr2, 0, length2);
                        }
                        while (length2 < i11 - 1) {
                            batteryHistoryArr2[length2] = new BatteryHistory();
                            aVar.m(batteryHistoryArr2[length2]);
                            aVar.v();
                            length2++;
                        }
                        batteryHistoryArr2[length2] = new BatteryHistory();
                        aVar.m(batteryHistoryArr2[length2]);
                        this.batteryHistory = batteryHistoryArr2;
                        break;
                    case 56:
                        this.isCharging = aVar.h();
                        break;
                    case 64:
                        this.totalTime = aVar.x();
                        break;
                    case 72:
                        this.screenOnTime = aVar.x();
                        break;
                    case 80:
                        this.screenOffUptime = aVar.x();
                        break;
                    case 88:
                        this.fullWakelockTime = aVar.x();
                        break;
                    case 96:
                        this.userWakelockTime = aVar.x();
                        break;
                    case 104:
                        this.kernelWakelockTime = aVar.x();
                        break;
                    default:
                        if (e.e(aVar, v10)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }
    }
}
