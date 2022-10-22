package bg;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* compiled from: OldDataConverter.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<DataType, c> f5145a;

    /* compiled from: OldDataConverter.java */
    /* loaded from: classes2.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DataType f5146a;

        /* renamed from: b  reason: collision with root package name */
        private long f5147b;

        /* renamed from: c  reason: collision with root package name */
        private float f5148c;

        @Override // bg.d.c
        public qf.a a(qf.a aVar) {
            float f10;
            long j10;
            long j11 = aVar.f33128d;
            float e10 = aVar.e();
            long j12 = this.f5147b;
            if (j12 == 0 || !eg.c.k(d.c(j12), d.c(j11))) {
                j10 = eg.c.a(j11).getTimeInMillis();
                f10 = e10;
            } else {
                j10 = this.f5147b;
                float f11 = this.f5148c;
                f10 = e10 > f11 ? e10 - f11 : 0.0f;
            }
            qf.a aVar2 = new qf.a(this.f5146a, j10, j11);
            aVar2.h(f10);
            this.f5147b = j11;
            this.f5148c = e10;
            return aVar2;
        }

        @Override // bg.d.c
        public void reset() {
            this.f5147b = 0L;
            this.f5148c = 0.0f;
        }

        private b(DataType dataType) {
            this.f5146a = dataType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OldDataConverter.java */
    /* loaded from: classes2.dex */
    public interface c {
        qf.a a(qf.a aVar);

        void reset();
    }

    /* compiled from: OldDataConverter.java */
    /* renamed from: bg.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0073d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DataType f5149a;

        @Override // bg.d.c
        public qf.a a(qf.a aVar) {
            qf.a aVar2 = new qf.a(this.f5149a, aVar.f33129e, aVar.f33128d);
            aVar2.h(aVar.e());
            return aVar2;
        }

        @Override // bg.d.c
        public /* synthetic */ void reset() {
            e.a(this);
        }

        private C0073d(DataType dataType) {
            this.f5149a = dataType;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f5145a = hashMap;
        hashMap.put(DataType.Step, new C0073d(DataType.DeltaStep));
        hashMap.put(DataType.Exercise, new C0073d(DataType.DeltaExercise));
        hashMap.put(DataType.Calorie, new b(DataType.DeltaCalorie));
        hashMap.put(DataType.Distance, new b(DataType.DeltaDistance));
    }

    public static List<qf.a> b(List<qf.a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.isEmpty()) {
            return arrayList;
        }
        for (c cVar : f5145a.values()) {
            cVar.reset();
        }
        for (qf.a aVar : list) {
            DataType from = DataType.from(aVar.f33127c);
            Map<DataType, c> map = f5145a;
            if (map.containsKey(from)) {
                arrayList.add(map.get(from).a(aVar));
            } else {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(long j10) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(j10);
    }
}
