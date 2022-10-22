package ef;

import java.util.List;
import java.util.Locale;
/* compiled from: Groups.java */
/* loaded from: classes2.dex */
public class e extends n {

    /* renamed from: c  reason: collision with root package name */
    public final List<Long> f25916c;

    public static int a(List<Long> list) {
        return (list.size() / 2) + 1;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: {%d, times %s}", this.f25944a.name(), Long.valueOf(this.f25945b), this.f25916c);
    }
}
