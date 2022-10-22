package b6;
/* loaded from: classes.dex */
public final class f {
    public f(String str, String str2) {
        i.l(str, "log tag cannot be null");
        i.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }

    public f(String str) {
        this(str, null);
    }
}
