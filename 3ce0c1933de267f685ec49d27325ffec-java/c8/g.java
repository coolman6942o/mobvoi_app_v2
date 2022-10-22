package c8;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
/* loaded from: classes.dex */
public final class g extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final c f5625a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f5625a = cVar;
    }

    public final void b(e eVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f5625a.d(eVar.f5619a)) {
                eVar.a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f5625a.f5611a.execute(new h(this, eVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
