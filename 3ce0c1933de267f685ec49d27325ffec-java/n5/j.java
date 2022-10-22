package n5;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class j {
    public static void a(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T c(T t10) {
        if (!t10.isEmpty()) {
            return t10;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static <T> T d(T t10) {
        return (T) e(t10, "Argument must not be null");
    }

    public static <T> T e(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }
}
