package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class Objects {

    /* loaded from: classes.dex */
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f13732a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f13733b;

        private ToStringHelper(Object obj) {
            this.f13733b = Preconditions.checkNotNull(obj);
            this.f13732a = new ArrayList();
        }

        /* synthetic */ ToStringHelper(Object obj, byte b10) {
            this(obj);
        }

        public final ToStringHelper add(String str, Object obj) {
            String valueOf = String.valueOf(obj);
            List<String> list = this.f13732a;
            list.add(((String) Preconditions.checkNotNull(str)) + ContainerUtils.KEY_VALUE_DELIMITER + valueOf);
            return this;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f13733b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f13732a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f13732a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    private Objects() {
        throw new AssertionError("illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj, (byte) 0);
    }
}
