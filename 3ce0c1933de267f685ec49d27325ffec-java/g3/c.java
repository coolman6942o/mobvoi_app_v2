package g3;

import i3.i;
import java.util.List;
/* compiled from: FontCharacter.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<i> f27232a;

    /* renamed from: b  reason: collision with root package name */
    private final char f27233b;

    /* renamed from: c  reason: collision with root package name */
    private final double f27234c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27235d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27236e;

    public c(List<i> list, char c10, double d10, double d11, String str, String str2) {
        this.f27232a = list;
        this.f27233b = c10;
        this.f27234c = d11;
        this.f27235d = str;
        this.f27236e = str2;
    }

    public static int c(char c10, String str, String str2) {
        return ((((0 + c10) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<i> a() {
        return this.f27232a;
    }

    public double b() {
        return this.f27234c;
    }

    public int hashCode() {
        return c(this.f27233b, this.f27236e, this.f27235d);
    }
}
