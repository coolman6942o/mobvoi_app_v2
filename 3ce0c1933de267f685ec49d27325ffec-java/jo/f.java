package jo;

import java.util.Comparator;
import kotlin.jvm.internal.i;
/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f29653a = new f();

    private f() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> a10, Comparable<Object> b10) {
        i.f(a10, "a");
        i.f(b10, "b");
        return b10.compareTo(a10);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f29652a;
    }
}
