package i6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import r6.d;
/* loaded from: classes.dex */
public class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f28098a;

    public a(Looper looper) {
        this.f28098a = new d(looper);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f28098a.post(runnable);
    }
}
