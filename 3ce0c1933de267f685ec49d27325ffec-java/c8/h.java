package c8;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f5626a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ g f5627b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, e eVar) {
        this.f5627b = gVar;
        this.f5626a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        cVar = this.f5627b.f5625a;
        cVar.e(this.f5626a.f5619a);
        this.f5626a.a();
    }
}
