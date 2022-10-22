package x8;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ExpandedRow.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f36492a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36493b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f36494c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<b> list, int i10, boolean z10) {
        this.f36492a = new ArrayList(list);
        this.f36493b = i10;
        this.f36494c = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> a() {
        return this.f36492a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f36493b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(List<b> list) {
        return this.f36492a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f36492a.equals(cVar.a()) && this.f36494c == cVar.f36494c;
    }

    public int hashCode() {
        return this.f36492a.hashCode() ^ Boolean.valueOf(this.f36494c).hashCode();
    }

    public String toString() {
        return "{ " + this.f36492a + " }";
    }
}
