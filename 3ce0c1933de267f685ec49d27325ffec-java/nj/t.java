package nj;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.utils.BleConnectFailException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.c;
import yp.g;
/* compiled from: RetryWithDelayMcu.java */
/* loaded from: classes2.dex */
public class t implements g<c<? extends Throwable>, c<?>> {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f31293c = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 5, 5};

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f31294a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f31295b = f31293c;

    public t(int i10) {
        this.f31294a = new AtomicInteger(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c c(Throwable th2) {
        this.f31294a.getAndAdd(1);
        if (d(th2)) {
            int i10 = this.f31294a.get();
            int[] iArr = this.f31295b;
            if (i10 < iArr.length) {
                k.c("DataSyncService", "蓝牙连接失败回调，将等待%s分钟开始回连", Integer.valueOf(iArr[this.f31294a.get()]));
                k.c("RetryWithDelay", "Retry count %s", Integer.valueOf(this.f31294a.get()));
                return c.e0(this.f31295b[this.f31294a.get()], TimeUnit.MINUTES);
            }
        }
        return c.t(th2);
    }

    private boolean d(Throwable th2) {
        k.a("DataSyncService", "needRetry执行了");
        return th2 instanceof BleConnectFailException;
    }

    /* renamed from: b */
    public c<?> call(c<? extends Throwable> cVar) {
        return cVar.v(new g() { // from class: nj.s
            @Override // yp.g
            public final Object call(Object obj) {
                c c10;
                c10 = t.this.c((Throwable) obj);
                return c10;
            }
        });
    }
}
