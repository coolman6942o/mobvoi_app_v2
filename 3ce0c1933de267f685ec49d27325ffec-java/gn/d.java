package gn;

import java.math.BigDecimal;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f27543a;

    public static d b() {
        if (f27543a == null) {
            f27543a = new d();
        }
        return f27543a;
    }

    public float a(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        return new BigDecimal(String.valueOf(f10)).divide(new BigDecimal(String.valueOf(f11)), 6, 4).floatValue();
    }
}
