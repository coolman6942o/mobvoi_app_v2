package g0;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
/* compiled from: LocaleListCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private h f27188a;

    static {
        a(new Locale[0]);
    }

    private f(h hVar) {
        this.f27188a = hVar;
    }

    public static f a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e(new LocaleList(localeArr));
        }
        return new f(new g(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static f d() {
        return Build.VERSION.SDK_INT >= 24 ? e(LocaleList.getDefault()) : a(Locale.getDefault());
    }

    public static f e(LocaleList localeList) {
        return new f(new i(localeList));
    }

    public Locale c(int i10) {
        return this.f27188a.get(i10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f27188a.equals(((f) obj).f27188a);
    }

    public int hashCode() {
        return this.f27188a.hashCode();
    }

    public String toString() {
        return this.f27188a.toString();
    }
}
