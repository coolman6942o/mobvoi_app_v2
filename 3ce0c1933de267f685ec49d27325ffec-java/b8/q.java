package b8;

import java.util.Objects;
/* loaded from: classes.dex */
public final class q {
    public static void a(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T b(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }
}
