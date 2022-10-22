package g0;

import android.os.LocaleList;
import java.util.Locale;
/* compiled from: LocaleListPlatformWrapper.java */
/* loaded from: classes.dex */
final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f27191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LocaleList localeList) {
        this.f27191a = localeList;
    }

    @Override // g0.h
    public Object a() {
        return this.f27191a;
    }

    public boolean equals(Object obj) {
        return this.f27191a.equals(((h) obj).a());
    }

    @Override // g0.h
    public Locale get(int i10) {
        return this.f27191a.get(i10);
    }

    public int hashCode() {
        return this.f27191a.hashCode();
    }

    public String toString() {
        return this.f27191a.toString();
    }
}
