package c7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.b;
/* loaded from: classes.dex */
public final class d1 implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final b f5583a;

    /* renamed from: b  reason: collision with root package name */
    private final Status f5584b;

    public d1(Status status, b bVar) {
        this.f5584b = status;
        this.f5583a = bVar;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.f5584b;
    }

    @Override // com.google.android.gms.wearable.a.b
    public final b h0() {
        return this.f5583a;
    }
}
