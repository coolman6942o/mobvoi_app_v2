package df;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.fitness.core.data.pojo.SessionMode;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.wear.util.GeoPoint;
import com.mobvoi.wear.util.GeoUtil;
import ef.o;
import ef.p;
import ef.q;
import ef.r;
import ef.u;
import j0.d;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DataTranslator.java */
/* loaded from: classes2.dex */
public class a {
    private static void a(String str) {
        if (!k.j()) {
            k.d("fit.net.translator", str);
            return;
        }
        throw new RuntimeException(str);
    }

    public static e b(r rVar, int i10) {
        u b10 = rVar.b();
        if (b10 == null) {
            return null;
        }
        e eVar = new e();
        eVar.motionId = b10.f25984c;
        eVar.deviceId = b10.f25983b;
        eVar.motionType = b10.f25985d.name();
        eVar.sessionMode = Integer.valueOf(b10.D.typeCode);
        eVar.startAt = b10.f25989h;
        SportDataType sportDataType = b10.f25987f;
        if (!(sportDataType == null || sportDataType == SportDataType.Unknown)) {
            eVar.objectiveType = sportDataType.name();
        }
        eVar.objective = b10.f25986e;
        eVar.endAt = b10.f25990i;
        eVar.totalMotionTime = b10.f25991j;
        eVar.totalDistance = b10.f25992k;
        eVar.totalCalorie = Math.round(b10.f25993l);
        eVar.avgHeartRate = b10.f25994m;
        eVar.totalSteps = b10.f25995n;
        eVar.groups = u.e(b10.f26007z);
        if (b10.f25985d.isSwimming()) {
            eVar.swimTrips = b10.B;
            eVar.swimStroke = b10.C;
            eVar.swimPoolLength = b10.A;
        } else {
            int i11 = b10.f26004w;
            if (i11 > 0) {
                eVar.swimDistance = i11;
                eVar.swimStroke = b10.f26003v;
                eVar.swimPoolLength = b10.f26005x;
            }
        }
        float f10 = b10.f26002u;
        if (f10 >= 0.0f) {
            eVar.swimTrips = f10;
        }
        eVar.maxElevation = b10.f25997p;
        eVar.minElevation = b10.f25998q;
        eVar.cumulativeUp = b10.f25999r;
        eVar.cumulativeDown = b10.f26000s;
        eVar.score = b10.f26001t;
        eVar.extra = b10.G;
        if (b10.f25985d.isCountType()) {
            eVar.score = b10.H;
        }
        q a10 = rVar.a();
        if (!(a10 == null || a10.c() == null)) {
            for (p pVar : a10.c()) {
                eVar.trackPoints.add(c(pVar, i10));
            }
        }
        return eVar;
    }

    public static f c(p pVar, int i10) {
        int i11;
        f fVar = new f();
        fVar.time = pVar.f25951a;
        fVar.wallClockTimestamp = pVar.f25952b;
        fVar.distance = pVar.f25953c;
        fVar.speed = pVar.f25954d;
        fVar.heart = pVar.f25955e;
        fVar.steps = pVar.f25956f;
        fVar.resume = pVar.f25963m;
        fVar.swimTrips = pVar.f25964n;
        fVar.swimType = pVar.f25966p;
        fVar.swimStroke = pVar.f25965o;
        fVar.elevation = pVar.f25957g;
        fVar.GPSPoint = null;
        o oVar = pVar.f25973w;
        if (oVar != null) {
            GeoPoint geoPoint = new GeoPoint(oVar.f25947d, oVar.f25946c);
            if (i10 == 0) {
                geoPoint = GeoUtil.convertGPSToBaiduGeo(geoPoint);
            } else if (i10 == 1) {
                geoPoint = GeoUtil.convertGCJToBaidu(geoPoint);
            }
            fVar.GPSPoint = geoPoint.toStringWithComma();
            fVar.GPSState = String.valueOf(pVar.f25973w.f25948e);
        }
        if (pVar.f25964n <= 0.0f && (i11 = pVar.f25967q) > 0) {
            fVar.swimTrips = i11;
            fVar.swimStroke = pVar.f25968r;
            fVar.swimType = pVar.f25969s;
        }
        return fVar;
    }

    public static p d(f fVar, int i10) {
        p pVar = new p();
        pVar.f25951a = fVar.time;
        pVar.f25952b = fVar.wallClockTimestamp;
        pVar.f25953c = fVar.distance;
        pVar.f25954d = (float) fVar.speed;
        pVar.f25955e = fVar.heart;
        pVar.f25956f = fVar.steps;
        pVar.f25963m = fVar.resume;
        pVar.f25964n = fVar.swimTrips;
        pVar.f25965o = fVar.swimStroke;
        pVar.f25966p = fVar.swimType;
        pVar.f25957g = fVar.elevation;
        GeoPoint parseFromStringComma = GeoPoint.parseFromStringComma(fVar.GPSPoint);
        if (parseFromStringComma.isValid()) {
            if (i10 == 0) {
                parseFromStringComma = GeoUtil.convertBaiduToGPSGeo(parseFromStringComma);
            } else if (i10 == 1) {
                parseFromStringComma = GeoUtil.convertBaiduToGCJ(parseFromStringComma);
            }
            o oVar = new o(fVar.time);
            pVar.f25973w = oVar;
            oVar.f25947d = parseFromStringComma.getLat();
            pVar.f25973w.f25946c = parseFromStringComma.getLng();
            pVar.f25973w.f25948e = Float.parseFloat(fVar.GPSState);
        }
        pVar.f25967q = (int) pVar.f25964n;
        pVar.f25968r = pVar.f25965o;
        pVar.f25969s = pVar.f25966p;
        return pVar;
    }

    public static r e(e eVar, String str, int i10) {
        return new r(h(eVar, str), f(eVar, i10));
    }

    public static q f(e eVar, int i10) {
        List<f> list = eVar.trackPoints;
        ArrayList arrayList = new ArrayList(list.size());
        for (f fVar : list) {
            if (fVar.time >= 0) {
                p d10 = d(fVar, i10);
                List<d<Long, Long>> g10 = g(eVar.pauseTimeRanges);
                p c10 = ze.a.c(d10, fVar.time, eVar.startAt, eVar.endAt, g10);
                if (c10 != null && ze.a.a(c10.f25951a, fVar.time, eVar.startAt, g10)) {
                    arrayList.add(c10);
                }
            }
        }
        return new q(arrayList, true);
    }

    public static List<d<Long, Long>> g(List<String> list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (str == null) {
                a("Format error, got an null pause pair string.");
            } else {
                String[] split = str.split(",");
                if (split.length != 2) {
                    a("Format error, " + str + " has no pause pairs.");
                } else {
                    arrayList.add(d.a(Long.valueOf(Long.getLong(split[0], -1L).longValue()), Long.valueOf(Long.getLong(split[1], -1L).longValue())));
                }
            }
        }
        return arrayList;
    }

    public static u h(e eVar, String str) {
        u uVar = new u(eVar.motionId);
        uVar.f25982a = str;
        uVar.f25983b = eVar.deviceId;
        uVar.f25989h = eVar.startAt;
        if (!TextUtils.isEmpty(eVar.motionType)) {
            uVar.f25985d = SportType.from(eVar.motionType);
        }
        if (!TextUtils.isEmpty(eVar.objectiveType)) {
            uVar.f25987f = SportDataType.from(eVar.objectiveType);
        }
        Integer num = eVar.sessionMode;
        uVar.D = SessionMode.from(num == null ? SessionMode.UNKNOWN.typeCode : num.intValue());
        uVar.f25986e = (float) eVar.objective;
        uVar.f25990i = eVar.endAt;
        uVar.f25991j = eVar.totalMotionTime;
        uVar.f25992k = eVar.totalDistance;
        uVar.f25993l = eVar.totalCalorie;
        uVar.f25994m = eVar.avgHeartRate;
        uVar.f25995n = eVar.totalSteps;
        uVar.f26007z.clear();
        uVar.f26007z.addAll(u.k(eVar.groups));
        uVar.B = eVar.swimTrips;
        uVar.C = eVar.swimStroke;
        uVar.A = eVar.swimPoolLength;
        uVar.f26006y = eVar.swimDistance;
        uVar.f25997p = eVar.maxElevation;
        uVar.f25998q = eVar.minElevation;
        uVar.f25999r = eVar.cumulativeUp;
        uVar.f26000s = eVar.cumulativeDown;
        uVar.f26001t = eVar.score;
        uVar.G = eVar.extra;
        if (!uVar.f25985d.isSwimming()) {
            int i10 = uVar.f26006y;
            if (i10 > 0) {
                uVar.f26004w = i10;
                uVar.f26005x = uVar.A;
                uVar.f26003v = uVar.C;
            }
            float f10 = uVar.B;
            if (f10 >= 0.0f) {
                uVar.f26002u = f10;
            }
        }
        if (uVar.f25985d.isCountType()) {
            uVar.H = (int) uVar.f26001t;
        }
        return uVar;
    }
}
