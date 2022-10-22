package yf;

import java.util.concurrent.TimeUnit;
/* compiled from: SyncContracts.java */
/* loaded from: classes2.dex */
public interface e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f37076a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f37077b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f37078c;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        f37076a = timeUnit.toMillis(365L);
        f37077b = timeUnit.toMillis(1L);
        f37078c = timeUnit.toMillis(30L);
    }
}
