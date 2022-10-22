package y1;
/* compiled from: Preference.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f36671a;

    /* renamed from: b  reason: collision with root package name */
    public Long f36672b;

    public d(String str, boolean z10) {
        this(str, z10 ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f36671a.equals(dVar.f36671a)) {
            return false;
        }
        Long l10 = this.f36672b;
        Long l11 = dVar.f36672b;
        return l10 != null ? l10.equals(l11) : l11 == null;
    }

    public int hashCode() {
        int hashCode = this.f36671a.hashCode() * 31;
        Long l10 = this.f36672b;
        return hashCode + (l10 != null ? l10.hashCode() : 0);
    }

    public d(String str, long j10) {
        this.f36671a = str;
        this.f36672b = Long.valueOf(j10);
    }
}
