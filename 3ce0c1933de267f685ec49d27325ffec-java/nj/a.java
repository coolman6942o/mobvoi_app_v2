package nj;

import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.model.FitnessRecord;
import df.e;
import df.f;
import java.util.ArrayList;
import kotlin.collections.n;
import kotlin.jvm.internal.i;
/* compiled from: ApolloDataConverter.kt */
/* loaded from: classes2.dex */
public final class a {
    private static final f a(FitnessRecord.TrackPoint trackPoint) {
        f fVar = new f();
        fVar.time = trackPoint.getTimestamp();
        fVar.wallClockTimestamp = trackPoint.getWallClockTimestamp();
        fVar.GPSState = String.valueOf(trackPoint.getGPSState());
        fVar.GPSPoint = trackPoint.getGPSPoint();
        fVar.speed = trackPoint.getVelocity();
        fVar.distance = trackPoint.getDistance();
        fVar.steps = trackPoint.getSteps();
        fVar.heart = trackPoint.getHeartRate();
        fVar.resume = trackPoint.getResume();
        fVar.swimStroke = trackPoint.getSwimStroke();
        fVar.swimTrips = trackPoint.getSwimTrips();
        fVar.swimType = trackPoint.getSwimType();
        fVar.elevation = trackPoint.getElevation();
        return fVar;
    }

    public static final e b(FitnessRecord fitnessRecord) {
        int p10;
        i.f(fitnessRecord, "<this>");
        e eVar = new e();
        eVar.avgHeartRate = fitnessRecord.getAvgHeartRate();
        eVar.cumulativeDown = fitnessRecord.getCumulativeDown();
        eVar.cumulativeUp = fitnessRecord.getCumulativeUp();
        String deviceId = fitnessRecord.getDeviceId();
        if (deviceId.length() == 0) {
            deviceId = r.f15521b.a();
        }
        eVar.deviceId = deviceId;
        eVar.motionId = fitnessRecord.getId();
        eVar.startAt = fitnessRecord.getStartAt();
        eVar.endAt = fitnessRecord.getEndAt();
        eVar.maxElevation = fitnessRecord.getMaxElevation();
        eVar.minElevation = fitnessRecord.getMinElevation();
        eVar.objective = fitnessRecord.getObjective();
        eVar.objectiveType = fitnessRecord.getObjectiveType();
        eVar.motionType = fitnessRecord.getType();
        eVar.score = fitnessRecord.getScore();
        eVar.sessionMode = Integer.valueOf(fitnessRecord.getSessionMode());
        eVar.swimDistance = fitnessRecord.getSwimDistance();
        eVar.swimPoolLength = fitnessRecord.getSwimPoolLength();
        eVar.swimStroke = fitnessRecord.getSwimStroke();
        eVar.swimTrips = fitnessRecord.getSwimTrips();
        eVar.totalCalorie = fitnessRecord.getTotalCalorie();
        eVar.totalDistance = fitnessRecord.getTotalDistance();
        eVar.totalMotionTime = fitnessRecord.getTotalMotionTime();
        eVar.totalSteps = fitnessRecord.getTotalSteps();
        eVar.timestamp = fitnessRecord.getTimestamp();
        ArrayList<FitnessRecord.TrackPoint> trackPoints = fitnessRecord.getTrackPoints();
        p10 = n.p(trackPoints, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (FitnessRecord.TrackPoint trackPoint : trackPoints) {
            arrayList.add(a(trackPoint));
        }
        eVar.trackPoints = arrayList;
        return eVar;
    }
}
