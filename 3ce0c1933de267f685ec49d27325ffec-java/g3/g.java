package g3;
/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    private static String f27241d = "\r";

    /* renamed from: a  reason: collision with root package name */
    private final String f27242a;

    /* renamed from: b  reason: collision with root package name */
    public final float f27243b;

    /* renamed from: c  reason: collision with root package name */
    public final float f27244c;

    public g(String str, float f10, float f11) {
        this.f27242a = str;
        this.f27244c = f11;
        this.f27243b = f10;
    }

    public boolean a(String str) {
        if (this.f27242a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f27242a.endsWith(f27241d)) {
            String str2 = this.f27242a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
