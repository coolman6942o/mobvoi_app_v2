package j0;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static <T> T c(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static String d(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
