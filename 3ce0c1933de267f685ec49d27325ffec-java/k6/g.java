package k6;

import android.os.Bundle;
import k6.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements a.AbstractC0363a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f29789a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a f29790b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, Bundle bundle) {
        this.f29790b = aVar;
        this.f29789a = bundle;
    }

    @Override // k6.a.AbstractC0363a
    public final void a(c cVar) {
        c cVar2;
        cVar2 = this.f29790b.f29783a;
        cVar2.onCreate(this.f29789a);
    }

    @Override // k6.a.AbstractC0363a
    public final int getState() {
        return 1;
    }
}
