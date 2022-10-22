package oh;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import bg.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.pojo.MotionType;
import eg.c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mh.a;
import of.g;
/* compiled from: DataStore.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    private static final DataType[] f31714i = {DataType.DeltaStep, DataType.DeltaExercise, DataType.DeltaCalorie, DataType.DeltaDistance};

    /* renamed from: a  reason: collision with root package name */
    private final g f31715a;

    /* renamed from: b  reason: collision with root package name */
    private a f31716b;

    /* renamed from: c  reason: collision with root package name */
    private long f31717c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f31718d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f31719e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f31720f = 24;

    /* renamed from: g  reason: collision with root package name */
    private SparseArray<a> f31721g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    private final Object f31722h = new Object();

    public b(Context context, g gVar) {
        this.f31715a = gVar;
    }

    private a a(SparseArray<a> sparseArray, int i10, String str) {
        int c10 = c.c(i10);
        a aVar = sparseArray.get(c10);
        if (aVar == null) {
            aVar = new a(c10);
            sparseArray.put(c10, aVar);
        }
        aVar.h(this.f31719e, this.f31720f);
        aVar.i(str);
        return aVar;
    }

    static void c(List<qf.a> list, List<qf.a> list2) {
        for (qf.a aVar : list2) {
            if (aVar.f33127c != DataType.DeltaStep.typeCode) {
                list.add(aVar);
            }
        }
    }

    private int g(long j10) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(j10);
    }

    public SparseArray<a> b() {
        SparseArray<a> clone;
        synchronized (this.f31722h) {
            clone = this.f31721g.clone();
        }
        return clone;
    }

    public void d(String str, String str2) {
        long j10;
        long j11;
        long j12;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SparseArray<a> sparseArray = new SparseArray<>();
        synchronized (this.f31722h) {
            j10 = this.f31717c;
            j11 = this.f31718d;
        }
        if (j10 < 0 || j11 < 0 || j10 >= j11) {
            k.c("health.DataSource", "refresh skipped because the time range is invalid: [%d, %d)", Long.valueOf(j10), Long.valueOf(j11));
            return;
        }
        com.mobvoi.health.common.data.db.a z10 = this.f31715a.z();
        String o10 = TextUtils.isEmpty(str) ? z10.o() : str;
        List<qf.a> g10 = z10.g(o10, null, null, j10, j11);
        List<qf.a> b10 = d.b(g10);
        for (qf.a aVar : g10) {
            if (!DataType.Motion.equals(DataType.from(aVar.f33127c)) || !MotionType.from((int) aVar.e()).isExercise()) {
                j12 = j10;
            } else {
                j12 = j10;
                qf.a aVar2 = new qf.a(DataType.DeltaExercise, aVar.f33129e, aVar.f33128d);
                aVar2.h(((float) (aVar.f33128d - aVar.f33129e)) / 1000.0f);
                b10.add(aVar2);
            }
            j10 = j12;
        }
        long j13 = j10;
        if (this.f31716b != null) {
            k.c("health.DataSource", "query sport points, from: %s, to: %s", com.mobvoi.android.common.utils.d.a(j13), com.mobvoi.android.common.utils.d.a(j11));
            List<qf.a> a10 = this.f31716b.a(j13, j11, str2);
            k.c("health.DataSource", "sport points found: %d", Integer.valueOf(a10.size()));
            c(b10, a10);
        }
        bg.c cVar = new bg.c();
        for (qf.a aVar3 : b10) {
            cVar.d(aVar3);
        }
        for (DataType dataType : f31714i) {
            for (bg.a aVar4 : cVar.c(dataType)) {
                long j14 = aVar4.f5139b;
                int c10 = j14 == 0 ? 0 : c.c(g(j14));
                int c11 = c.c(g(aVar4.f5140c));
                if (!(c10 == 0 || c10 == c11)) {
                    a(sparseArray, c10, o10).g(aVar4);
                }
                if (c11 != 0) {
                    a(sparseArray, c11, o10).g(aVar4);
                }
            }
        }
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray.valueAt(i10).m();
        }
        synchronized (this.f31722h) {
            this.f31721g = sparseArray;
        }
        k.c("health.DataSource", "refresh finished with ranges [%d, %d), took %.1f s", Long.valueOf(j13), Long.valueOf(j11), Float.valueOf(((float) (SystemClock.elapsedRealtime() - elapsedRealtime)) / 1000.0f));
    }

    public void e(long j10, long j11) {
        synchronized (this.f31722h) {
            this.f31717c = c.b(j10);
            this.f31718d = c.b(j11 - 1) + (c.f26040a * 1000);
        }
    }

    public void f(a aVar) {
        this.f31716b = aVar;
    }
}
