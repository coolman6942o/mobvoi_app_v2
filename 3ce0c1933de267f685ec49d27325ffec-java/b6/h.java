package b6;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class h {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f5063a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f5064b;

        private a(Object obj) {
            this.f5064b = i.k(obj);
            this.f5063a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f5063a;
            String str2 = (String) i.k(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 1 + valueOf.length());
            sb2.append(str2);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(valueOf);
            list.add(sb2.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f5064b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f5063a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f5063a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj);
    }
}
