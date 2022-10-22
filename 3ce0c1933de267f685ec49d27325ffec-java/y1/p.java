package y1;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.d;
import androidx.work.k;
import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* compiled from: WorkSpec.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public String f36689a;

    /* renamed from: b  reason: collision with root package name */
    public WorkInfo.State f36690b;

    /* renamed from: c  reason: collision with root package name */
    public String f36691c;

    /* renamed from: d  reason: collision with root package name */
    public String f36692d;

    /* renamed from: e  reason: collision with root package name */
    public d f36693e;

    /* renamed from: f  reason: collision with root package name */
    public d f36694f;

    /* renamed from: g  reason: collision with root package name */
    public long f36695g;

    /* renamed from: h  reason: collision with root package name */
    public long f36696h;

    /* renamed from: i  reason: collision with root package name */
    public long f36697i;

    /* renamed from: j  reason: collision with root package name */
    public androidx.work.b f36698j;

    /* renamed from: k  reason: collision with root package name */
    public int f36699k;

    /* renamed from: l  reason: collision with root package name */
    public BackoffPolicy f36700l;

    /* renamed from: m  reason: collision with root package name */
    public long f36701m;

    /* renamed from: n  reason: collision with root package name */
    public long f36702n;

    /* renamed from: o  reason: collision with root package name */
    public long f36703o;

    /* renamed from: p  reason: collision with root package name */
    public long f36704p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f36705q;

    /* renamed from: r  reason: collision with root package name */
    public OutOfQuotaPolicy f36706r;

    /* compiled from: WorkSpec.java */
    /* loaded from: classes.dex */
    class a implements m.a<List<c>, List<WorkInfo>> {
        a() {
        }

        /* renamed from: a */
        public List<WorkInfo> apply(List<c> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (c cVar : list) {
                arrayList.add(cVar.a());
            }
            return arrayList;
        }
    }

    /* compiled from: WorkSpec.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f36707a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f36708b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f36708b != bVar.f36708b) {
                return false;
            }
            return this.f36707a.equals(bVar.f36707a);
        }

        public int hashCode() {
            return (this.f36707a.hashCode() * 31) + this.f36708b.hashCode();
        }
    }

    /* compiled from: WorkSpec.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f36709a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f36710b;

        /* renamed from: c  reason: collision with root package name */
        public d f36711c;

        /* renamed from: d  reason: collision with root package name */
        public int f36712d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f36713e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f36714f;

        public WorkInfo a() {
            d dVar;
            List<d> list = this.f36714f;
            if (list == null || list.isEmpty()) {
                dVar = d.f4740c;
            } else {
                dVar = this.f36714f.get(0);
            }
            return new WorkInfo(UUID.fromString(this.f36709a), this.f36710b, this.f36711c, this.f36713e, dVar, this.f36712d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f36712d != cVar.f36712d) {
                return false;
            }
            String str = this.f36709a;
            if (str == null ? cVar.f36709a != null : !str.equals(cVar.f36709a)) {
                return false;
            }
            if (this.f36710b != cVar.f36710b) {
                return false;
            }
            d dVar = this.f36711c;
            if (dVar == null ? cVar.f36711c != null : !dVar.equals(cVar.f36711c)) {
                return false;
            }
            List<String> list = this.f36713e;
            if (list == null ? cVar.f36713e != null : !list.equals(cVar.f36713e)) {
                return false;
            }
            List<d> list2 = this.f36714f;
            List<d> list3 = cVar.f36714f;
            return list2 != null ? list2.equals(list3) : list3 == null;
        }

        public int hashCode() {
            String str = this.f36709a;
            int i10 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            WorkInfo.State state = this.f36710b;
            int hashCode2 = (hashCode + (state != null ? state.hashCode() : 0)) * 31;
            d dVar = this.f36711c;
            int hashCode3 = (((hashCode2 + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.f36712d) * 31;
            List<String> list = this.f36713e;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<d> list2 = this.f36714f;
            if (list2 != null) {
                i10 = list2.hashCode();
            }
            return hashCode4 + i10;
        }
    }

    static {
        k.f("WorkSpec");
        new a();
    }

    public p(String str, String str2) {
        this.f36690b = WorkInfo.State.ENQUEUED;
        d dVar = d.f4740c;
        this.f36693e = dVar;
        this.f36694f = dVar;
        this.f36698j = androidx.work.b.f4719i;
        this.f36700l = BackoffPolicy.EXPONENTIAL;
        this.f36701m = ab.Y;
        this.f36704p = -1L;
        this.f36706r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f36689a = str;
        this.f36691c = str2;
    }

    public long a() {
        long j10;
        boolean z10 = false;
        if (c()) {
            if (this.f36700l == BackoffPolicy.LINEAR) {
                z10 = true;
            }
            if (z10) {
                j10 = this.f36701m * this.f36699k;
            } else {
                j10 = Math.scalb((float) this.f36701m, this.f36699k - 1);
            }
            return this.f36702n + Math.min(18000000L, j10);
        }
        long j11 = 0;
        if (d()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j12 = this.f36702n;
            long j13 = j12 == 0 ? currentTimeMillis + this.f36695g : j12;
            long j14 = this.f36697i;
            long j15 = this.f36696h;
            if (j14 != j15) {
                z10 = true;
            }
            if (z10) {
                if (j12 == 0) {
                    j11 = j14 * (-1);
                }
                return j13 + j15 + j11;
            }
            if (j12 != 0) {
                j11 = j15;
            }
            return j13 + j11;
        }
        long j16 = this.f36702n;
        if (j16 == 0) {
            j16 = System.currentTimeMillis();
        }
        return j16 + this.f36695g;
    }

    public boolean b() {
        return !androidx.work.b.f4719i.equals(this.f36698j);
    }

    public boolean c() {
        return this.f36690b == WorkInfo.State.ENQUEUED && this.f36699k > 0;
    }

    public boolean d() {
        return this.f36696h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f36695g != pVar.f36695g || this.f36696h != pVar.f36696h || this.f36697i != pVar.f36697i || this.f36699k != pVar.f36699k || this.f36701m != pVar.f36701m || this.f36702n != pVar.f36702n || this.f36703o != pVar.f36703o || this.f36704p != pVar.f36704p || this.f36705q != pVar.f36705q || !this.f36689a.equals(pVar.f36689a) || this.f36690b != pVar.f36690b || !this.f36691c.equals(pVar.f36691c)) {
            return false;
        }
        String str = this.f36692d;
        if (str == null ? pVar.f36692d == null : str.equals(pVar.f36692d)) {
            return this.f36693e.equals(pVar.f36693e) && this.f36694f.equals(pVar.f36694f) && this.f36698j.equals(pVar.f36698j) && this.f36700l == pVar.f36700l && this.f36706r == pVar.f36706r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f36689a.hashCode() * 31) + this.f36690b.hashCode()) * 31) + this.f36691c.hashCode()) * 31;
        String str = this.f36692d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j10 = this.f36695g;
        long j11 = this.f36696h;
        long j12 = this.f36697i;
        long j13 = this.f36701m;
        long j14 = this.f36702n;
        long j15 = this.f36703o;
        long j16 = this.f36704p;
        return ((((((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f36693e.hashCode()) * 31) + this.f36694f.hashCode()) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f36698j.hashCode()) * 31) + this.f36699k) * 31) + this.f36700l.hashCode()) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + ((int) (j16 ^ (j16 >>> 32)))) * 31) + (this.f36705q ? 1 : 0)) * 31) + this.f36706r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f36689a + "}";
    }

    public p(p pVar) {
        this.f36690b = WorkInfo.State.ENQUEUED;
        d dVar = d.f4740c;
        this.f36693e = dVar;
        this.f36694f = dVar;
        this.f36698j = androidx.work.b.f4719i;
        this.f36700l = BackoffPolicy.EXPONENTIAL;
        this.f36701m = ab.Y;
        this.f36704p = -1L;
        this.f36706r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f36689a = pVar.f36689a;
        this.f36691c = pVar.f36691c;
        this.f36690b = pVar.f36690b;
        this.f36692d = pVar.f36692d;
        this.f36693e = new d(pVar.f36693e);
        this.f36694f = new d(pVar.f36694f);
        this.f36695g = pVar.f36695g;
        this.f36696h = pVar.f36696h;
        this.f36697i = pVar.f36697i;
        this.f36698j = new androidx.work.b(pVar.f36698j);
        this.f36699k = pVar.f36699k;
        this.f36700l = pVar.f36700l;
        this.f36701m = pVar.f36701m;
        this.f36702n = pVar.f36702n;
        this.f36703o = pVar.f36703o;
        this.f36704p = pVar.f36704p;
        this.f36705q = pVar.f36705q;
        this.f36706r = pVar.f36706r;
    }
}
