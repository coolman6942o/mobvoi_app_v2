package c7;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.e;
/* loaded from: classes.dex */
final class t0 implements i.b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ DataHolder f5598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(DataHolder dataHolder) {
        this.f5598a = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(d dVar) {
        try {
            dVar.onDataChanged(new e(this.f5598a));
        } finally {
            this.f5598a.close();
        }
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
        this.f5598a.close();
    }
}
