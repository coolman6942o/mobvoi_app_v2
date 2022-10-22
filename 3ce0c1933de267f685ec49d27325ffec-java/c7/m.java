package c7;

import a6.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.f;
/* loaded from: classes.dex */
public final class m extends d {

    /* renamed from: d  reason: collision with root package name */
    private final int f5590d;

    public m(DataHolder dataHolder, int i10, int i11) {
        super(dataHolder, i10);
        this.f5590d = i11;
    }

    public final f e() {
        return new o(this.f105a, this.f106b, this.f5590d);
    }

    public final int f() {
        return b("event_type");
    }

    public final String toString() {
        String str = f() == 1 ? "changed" : f() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(e());
        StringBuilder sb2 = new StringBuilder(str.length() + 32 + valueOf.length());
        sb2.append("DataEventRef{ type=");
        sb2.append(str);
        sb2.append(", dataitem=");
        sb2.append(valueOf);
        sb2.append(" }");
        return sb2.toString();
    }
}
