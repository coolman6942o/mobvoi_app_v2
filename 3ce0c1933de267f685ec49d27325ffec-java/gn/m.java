package gn;
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f27579a;

    private boolean a(char c10) {
        return !(c10 == 0 || c10 == '\t' || c10 == '\n' || c10 == '\r' || ((c10 >= ' ' && c10 <= 55295) || ((c10 >= 57344 && c10 <= 65533) || c10 >= 0))) || c10 == 169 || c10 == 174 || c10 == 8482 || c10 == 12336 || (c10 >= 9654 && c10 <= 10175) || c10 == 9000 || ((c10 >= 9193 && c10 <= 9210) || ((c10 >= 61440 && c10 <= 65535) || ((c10 >= 9986 && c10 <= 10160) || ((c10 >= 62977 && c10 <= 63055) || c10 == 8205 || c10 == 65039 || c10 == 11088))));
    }

    private boolean b(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (a(str.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public static m d() {
        if (f27579a == null) {
            f27579a = new m();
        }
        return f27579a;
    }

    public String c(String str) {
        if (!b(str)) {
            return str;
        }
        StringBuilder sb2 = null;
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (!a(charAt)) {
                if (sb2 == null) {
                    sb2 = new StringBuilder(str.length());
                }
                sb2.append(charAt);
            }
        }
        return (sb2 == null || sb2.length() == length) ? str : sb2.toString();
    }
}
