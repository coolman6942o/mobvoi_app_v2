package q6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
final class h implements e {
    private h() {
    }

    @Override // q6.e
    public final ExecutorService a(int i10, ThreadFactory threadFactory, int i11) {
        return Executors.newFixedThreadPool(2, threadFactory);
    }
}
