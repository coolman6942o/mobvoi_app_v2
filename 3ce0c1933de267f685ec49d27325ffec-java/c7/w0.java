package c7;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.internal.zzah;
/* loaded from: classes.dex */
final class w0 implements i.b<a.AbstractC0116a> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzah f5601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(zzah zzahVar) {
        this.f5601a = zzahVar;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(a.AbstractC0116a aVar) {
        aVar.onCapabilityChanged(this.f5601a);
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
    }
}
