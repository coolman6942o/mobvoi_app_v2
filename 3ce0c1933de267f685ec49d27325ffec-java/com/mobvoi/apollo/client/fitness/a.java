package com.mobvoi.apollo.client.fitness;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.protocol.model.DataSession;
import com.mobvoi.apollo.protocol.model.DataSet;
import com.mobvoi.apollo.protocol.model.FitnessRecord;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import oa.b;
import qo.l;
/* compiled from: Converter.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: Converter.kt */
    /* renamed from: com.mobvoi.apollo.client.fitness.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0190a extends Lambda implements l<Integer, DataSet.Point> {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ Ref$ObjectRef<byte[]> $dstArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0190a(ByteBuffer byteBuffer, Ref$ObjectRef<byte[]> ref$ObjectRef) {
            super(1);
            this.$buffer = byteBuffer;
            this.$dstArray = ref$ObjectRef;
        }

        /* JADX WARN: Type inference failed for: r9v12, types: [byte[], T] */
        /* JADX WARN: Type inference failed for: r9v3, types: [byte[], T] */
        public final DataSet.Point a(int i10) {
            ?? r92 = new byte[this.$buffer.get()];
            this.$dstArray.element = r92;
            this.$buffer.get((byte[]) r92);
            Charset charset = d.f30092a;
            String str = new String(this.$dstArray.element, charset);
            long j10 = this.$buffer.getLong();
            long j11 = this.$buffer.getLong();
            ?? r93 = new byte[this.$buffer.get()];
            this.$dstArray.element = r93;
            this.$buffer.get((byte[]) r93);
            return new DataSet.Point(j10, j11, str, new String(this.$dstArray.element, charset), this.$buffer.get());
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ DataSet.Point invoke(Integer num) {
            return a(num.intValue());
        }
    }

    public static final List<DataSession> a(ByteBuffer buffer) {
        i.f(buffer, "buffer");
        if (k.j()) {
            k.a("DataSession", b.f31485a.a(buffer.array()));
        }
        short s10 = buffer.getShort();
        ArrayList arrayList = new ArrayList(s10);
        for (int i10 = 0; i10 < s10; i10++) {
            byte[] bArr = new byte[buffer.get()];
            buffer.get(bArr);
            Charset charset = d.f30092a;
            String str = new String(bArr, charset);
            byte[] bArr2 = new byte[buffer.get()];
            buffer.get(bArr2);
            String str2 = new String(bArr2, charset);
            long j10 = buffer.getLong();
            long j11 = buffer.getLong();
            byte[] bArr3 = new byte[buffer.get()];
            buffer.get(bArr3);
            arrayList.add(new DataSession(str, str2, new String(bArr3, charset), j10, j11));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [byte[], T] */
    public static final List<DataSet> b(ByteBuffer buffer) {
        i.f(buffer, "buffer");
        if (k.j()) {
            k.a("DataSets", b.f31485a.a(buffer.array()));
        }
        short s10 = buffer.getShort();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ArrayList arrayList = new ArrayList(s10);
        for (int i10 = 0; i10 < s10; i10++) {
            ?? r42 = new byte[buffer.get()];
            ref$ObjectRef.element = r42;
            buffer.get((byte[]) r42);
            arrayList.add(new DataSet(new String((byte[]) ref$ObjectRef.element, d.f30092a), buffer.getLong(), buffer.getLong(), buffer.getShort(), new C0190a(buffer, ref$ObjectRef)));
        }
        return arrayList;
    }

    public static final FitnessRecord c(ByteBuffer buffer) {
        int i10;
        i.f(buffer, "buffer");
        if (k.j()) {
            k.a("FitnessParser", b.f31485a.a(buffer.array()));
        }
        FitnessRecord fitnessRecord = new FitnessRecord();
        fitnessRecord.setAccountId(buffer.getInt());
        fitnessRecord.setAvgHeartRate(buffer.getInt());
        fitnessRecord.setCumulativeDown(buffer.getFloat());
        fitnessRecord.setCumulativeUp(buffer.getFloat());
        int i11 = buffer.get();
        if (i11 > 0) {
            byte[] bArr = new byte[i11];
            buffer.get(bArr);
            fitnessRecord.setDeviceId(new String(bArr, d.f30092a));
        }
        int i12 = buffer.get();
        if (i12 > 0) {
            byte[] bArr2 = new byte[i12];
            buffer.get(bArr2);
            fitnessRecord.setId(new String(bArr2, d.f30092a));
        }
        fitnessRecord.setStartAt(buffer.getLong());
        fitnessRecord.setEndAt(buffer.getLong());
        fitnessRecord.setMaxElevation(buffer.getFloat());
        fitnessRecord.setMinElevation(buffer.getFloat());
        fitnessRecord.setObjective(buffer.getFloat());
        int i13 = buffer.get();
        if (i13 > 0) {
            byte[] bArr3 = new byte[i13];
            buffer.get(bArr3);
            fitnessRecord.setObjectiveType(new String(bArr3, d.f30092a));
        }
        int i14 = buffer.get();
        if (i14 > 0) {
            byte[] bArr4 = new byte[i14];
            buffer.get(bArr4);
            fitnessRecord.setType(new String(bArr4, d.f30092a));
        }
        fitnessRecord.setScore(buffer.getFloat());
        fitnessRecord.setSessionMode(buffer.getInt());
        fitnessRecord.setSwimDistance(buffer.getInt());
        fitnessRecord.setSwimPoolLength(buffer.getInt());
        fitnessRecord.setSwimStroke(buffer.getInt());
        fitnessRecord.setSwimTrips(buffer.getFloat());
        fitnessRecord.setTotalCalorie(buffer.getInt());
        fitnessRecord.setTotalDistance(buffer.getInt());
        fitnessRecord.setTotalMotionTime(buffer.getLong());
        fitnessRecord.setTotalSteps(buffer.getInt());
        fitnessRecord.setTimestamp(buffer.getLong());
        while (buffer.hasRemaining()) {
            int i15 = buffer.getInt();
            FitnessRecord.TrackPoint trackPoint = new FitnessRecord.TrackPoint();
            if ((i15 & 1) != 0) {
                trackPoint.setDistance(buffer.getInt());
            }
            if ((i15 & 2) != 0) {
                trackPoint.setSteps(buffer.getInt());
            }
            if ((i15 & 4) != 0) {
                trackPoint.setElevation(buffer.getFloat());
            }
            if ((i15 & 8) != 0 && (i10 = buffer.get()) > 0) {
                byte[] bArr5 = new byte[i10];
                buffer.get(bArr5);
                trackPoint.setGPSPoint(new String(bArr5, d.f30092a));
            }
            if ((i15 & 16) != 0) {
                trackPoint.setGPSState(buffer.getFloat());
            }
            if ((i15 & 32) != 0) {
                trackPoint.setHeartRate(buffer.getInt());
            }
            if ((i15 & 64) != 0) {
                boolean z10 = true;
                if (buffer.get() != 1) {
                    z10 = false;
                }
                trackPoint.setResume(z10);
            }
            if ((i15 & 128) != 0) {
                trackPoint.setSwimStroke(buffer.getInt());
            }
            if ((i15 & 256) != 0) {
                trackPoint.setSwimTrips(buffer.getFloat());
            }
            if ((i15 & 512) != 0) {
                trackPoint.setSwimType(buffer.getInt());
            }
            if ((i15 & 1024) != 0) {
                trackPoint.setTimestamp(buffer.getLong());
            }
            if ((i15 & 2048) != 0) {
                trackPoint.setVelocity(buffer.getFloat());
            }
            if ((i15 & 4096) != 0) {
                trackPoint.setWallClockTimestamp(buffer.getLong());
            }
            fitnessRecord.getTrackPoints().add(trackPoint);
        }
        return fitnessRecord;
    }
}
