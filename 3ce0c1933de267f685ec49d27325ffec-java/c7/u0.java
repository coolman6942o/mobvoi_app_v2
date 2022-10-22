package c7;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.internal.zzfe;
/* loaded from: classes.dex */
final class u0 implements i.b<h.a> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzfe f5599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(zzfe zzfeVar) {
        this.f5599a = zzfeVar;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(h.a aVar) {
        aVar.onMessageReceived(this.f5599a);
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
    }
}
