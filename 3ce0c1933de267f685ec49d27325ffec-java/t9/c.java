package t9;

import android.os.SystemClock;
import com.mobvoi.android.common.utils.d;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskInfo.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    private static AtomicInteger f35091f = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public Runnable f35093b;

    /* renamed from: c  reason: collision with root package name */
    public long f35094c;

    /* renamed from: e  reason: collision with root package name */
    public long f35096e;

    /* renamed from: d  reason: collision with root package name */
    public long f35095d = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f35092a = f35091f.getAndIncrement();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, long j10) {
        this.f35093b = runnable;
        this.f35094c = j10;
        this.f35096e = SystemClock.elapsedRealtime() + j10;
    }

    public String toString() {
        long currentTimeMillis = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - this.f35096e);
        return "TaskInfo[id=" + this.f35092a + ", delay=" + this.f35094c + ", triggerAt=" + d.a(currentTimeMillis) + ", period=" + this.f35095d + "]";
    }
}
