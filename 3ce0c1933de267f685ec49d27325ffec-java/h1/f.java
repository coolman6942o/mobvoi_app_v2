package h1;
/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public class f {
    public static void a(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("?");
            if (i11 < i10 - 1) {
                sb2.append(",");
            }
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}
