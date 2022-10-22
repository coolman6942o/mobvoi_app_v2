package we;

import com.mobvoi.wear.util.UnitsUtility;
import ef.c0;
import ef.p;
/* compiled from: StrideAnalyzer.java */
/* loaded from: classes2.dex */
public abstract class e<Data extends c0> extends d<Data> {

    /* renamed from: c  reason: collision with root package name */
    private float f36227c;

    /* renamed from: d  reason: collision with root package name */
    private int f36228d;

    /* renamed from: e  reason: collision with root package name */
    private long f36229e;

    /* renamed from: f  reason: collision with root package name */
    private float f36230f;

    public e() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        super.d();
        this.f36227c = 0.0f;
        this.f36228d = 0;
        this.f36229e = 0L;
        this.f36230f = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public Data c(Data data, long j10, p pVar) {
        long j11 = pVar.f25951a;
        int i10 = pVar.f25953c;
        if (i10 > this.f36227c) {
            this.f36227c = i10;
        }
        if (pVar.f25956f <= this.f36228d) {
            return null;
        }
        Data j12 = j(j11, UnitsUtility.Time.ms2min(j11 - this.f36229e), this.f36227c - this.f36230f, pVar.f25956f - this.f36228d);
        this.f36228d = pVar.f25956f;
        this.f36229e = j11;
        this.f36230f = this.f36227c;
        return j12;
    }

    protected abstract Data j(long j10, float f10, float f11, int i10);
}
