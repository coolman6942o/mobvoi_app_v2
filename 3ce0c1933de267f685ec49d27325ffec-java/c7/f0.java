package c7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.k;
import java.util.List;
/* loaded from: classes.dex */
public final class f0 implements k.a {

    /* renamed from: a  reason: collision with root package name */
    private final Status f5586a;

    /* renamed from: b  reason: collision with root package name */
    private final List<j> f5587b;

    public f0(Status status, List<j> list) {
        this.f5586a = status;
        this.f5587b = list;
    }

    @Override // com.google.android.gms.wearable.k.a
    public final List<j> d() {
        return this.f5587b;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.f5586a;
    }
}
