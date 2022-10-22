package lk;

import io.reactivex.k;
import io.reactivex.p;
import java.util.concurrent.TimeUnit;
import zn.o;
/* compiled from: RetryWithDelay.java */
/* loaded from: classes2.dex */
public class c implements o<k<? extends Throwable>, k<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final int f30503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30504b;

    /* renamed from: c  reason: collision with root package name */
    private int f30505c;

    public c(int i10, int i11) {
        this.f30503a = i10;
        this.f30504b = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p c(Throwable th2) throws Exception {
        com.mobvoi.android.common.utils.k.c("RetryWithDelay", "retry %d, %d", Integer.valueOf(this.f30505c), Integer.valueOf(this.f30503a));
        int i10 = this.f30505c + 1;
        this.f30505c = i10;
        if (i10 <= this.f30503a) {
            return k.timer(this.f30504b, TimeUnit.MILLISECONDS);
        }
        return k.error(th2);
    }

    /* renamed from: b */
    public k<?> apply(k<? extends Throwable> kVar) throws Exception {
        return kVar.flatMap(new o() { // from class: lk.b
            @Override // zn.o
            public final Object apply(Object obj) {
                p c10;
                c10 = c.this.c((Throwable) obj);
                return c10;
            }
        });
    }
}
