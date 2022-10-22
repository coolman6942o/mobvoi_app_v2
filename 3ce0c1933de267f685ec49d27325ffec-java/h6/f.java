package h6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class f {
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> b(T t10) {
        return Collections.singletonList(t10);
    }

    @Deprecated
    public static <T> List<T> c(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return b(tArr[0]);
    }
}
