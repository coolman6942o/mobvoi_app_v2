package c7;

import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.j;
import java.util.Set;
/* loaded from: classes.dex */
public final class c1 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f5580a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<j> f5581b;

    private c1(String str, Set<j> set) {
        this.f5580a = str;
        this.f5581b = set;
    }

    @Override // com.google.android.gms.wearable.b
    public final Set<j> d() {
        return this.f5581b;
    }

    @Override // com.google.android.gms.wearable.b
    public final String getName() {
        return this.f5580a;
    }

    public c1(b bVar) {
        this(bVar.getName(), bVar.d());
    }
}
