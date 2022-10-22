package rx.exceptions;

import bq.f;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    /* loaded from: classes3.dex */
    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final Set<Class<?>> f33699a = a();

            private static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + a(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th2) {
                    obj = th2.getMessage();
                }
            }
            this.value = obj;
        }

        static String a(Object obj) {
            if (obj == null) {
                return LpaConstants.VALUE_NULL;
            }
            if (a.f33699a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String b10 = f.c().b().b(obj);
            if (b10 != null) {
                return b10;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object getValue() {
            return this.value;
        }
    }

    private OnErrorThrowable(Throwable th2) {
        super(th2);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th2, Object obj) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable b10 = a.b(th2);
        if ((b10 instanceof OnNextValue) && ((OnNextValue) b10).getValue() == obj) {
            return th2;
        }
        a.a(th2, new OnNextValue(obj));
        return th2;
    }

    public static OnErrorThrowable from(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable b10 = a.b(th2);
        if (b10 instanceof OnNextValue) {
            return new OnErrorThrowable(th2, ((OnNextValue) b10).getValue());
        }
        return new OnErrorThrowable(th2);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    private OnErrorThrowable(Throwable th2, Object obj) {
        super(th2);
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th3) {
                obj = th3.getMessage();
            }
        }
        this.value = obj;
    }
}
