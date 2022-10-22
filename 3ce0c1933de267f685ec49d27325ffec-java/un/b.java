package un;

import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class b {
    public static <T> void a(T t10, Class<T> cls) {
        if (t10 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T b(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    public static <T> T c(T t10) {
        Objects.requireNonNull(t10, "Cannot return null from a non-@Nullable @Provides method");
        return t10;
    }
}
