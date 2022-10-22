package c7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.k;
/* loaded from: classes.dex */
public final class g0 implements k.b {

    /* renamed from: a  reason: collision with root package name */
    private final Status f5588a;

    /* renamed from: b  reason: collision with root package name */
    private final j f5589b;

    public g0(Status status, j jVar) {
        this.f5588a = status;
        this.f5589b = jVar;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.f5588a;
    }

    @Override // com.google.android.gms.wearable.k.b
    public final j k0() {
        return this.f5589b;
    }
}
