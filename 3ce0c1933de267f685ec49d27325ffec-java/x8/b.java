package x8;

import com.mobvoi.wear.lpa.LpaConstants;
import w8.c;
/* compiled from: ExpandedPair.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final w8.b f36489a;

    /* renamed from: b  reason: collision with root package name */
    private final w8.b f36490b;

    /* renamed from: c  reason: collision with root package name */
    private final c f36491c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(w8.b bVar, w8.b bVar2, c cVar, boolean z10) {
        this.f36489a = bVar;
        this.f36490b = bVar2;
        this.f36491c = cVar;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b() {
        return this.f36491c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w8.b c() {
        return this.f36489a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w8.b d() {
        return this.f36490b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f36489a, bVar.f36489a) && a(this.f36490b, bVar.f36490b) && a(this.f36491c, bVar.f36491c);
    }

    public boolean f() {
        return this.f36490b == null;
    }

    public int hashCode() {
        return (e(this.f36489a) ^ e(this.f36490b)) ^ e(this.f36491c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        sb2.append(this.f36489a);
        sb2.append(" , ");
        sb2.append(this.f36490b);
        sb2.append(" : ");
        c cVar = this.f36491c;
        sb2.append(cVar == null ? LpaConstants.VALUE_NULL : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
