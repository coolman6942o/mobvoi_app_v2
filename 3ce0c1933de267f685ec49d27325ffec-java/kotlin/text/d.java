package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.i;
/* compiled from: Charsets.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f30092a;

    /* renamed from: b  reason: collision with root package name */
    private static Charset f30093b;

    /* renamed from: c  reason: collision with root package name */
    private static Charset f30094c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f30095d = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        i.e(forName, "Charset.forName(\"UTF-8\")");
        f30092a = forName;
        i.e(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        i.e(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        i.e(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        i.e(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        i.e(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f30094c;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        i.e(forName, "Charset.forName(\"UTF-32BE\")");
        f30094c = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f30093b;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        i.e(forName, "Charset.forName(\"UTF-32LE\")");
        f30093b = forName;
        return forName;
    }
}
