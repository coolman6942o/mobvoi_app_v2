package t9;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
/* compiled from: HandlerExecutor.java */
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private Handler f35090a;

    public a(Looper looper) {
        this.f35090a = new Handler(looper);
    }

    @Override // t9.b
    public void a(List<Runnable> list) {
        for (Runnable runnable : list) {
            this.f35090a.post(runnable);
        }
    }

    @Override // t9.b
    public void b() {
        this.f35090a.removeCallbacksAndMessages(null);
    }
}
