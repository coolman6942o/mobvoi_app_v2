package k6;

import android.os.IBinder;
import java.lang.reflect.Field;
import k6.b;
/* loaded from: classes.dex */
public final class d<T> extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private final T f29787a;

    private d(T t10) {
        this.f29787a = t10;
    }

    public static <T> b A2(T t10) {
        return new d(t10);
    }

    public static <T> T U1(b bVar) {
        if (bVar instanceof d) {
            return ((d) bVar).f29787a;
        }
        IBinder asBinder = bVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            int length = declaredFields.length;
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("Unexpected number of IObjectWrapper declared fields: ");
            sb2.append(length);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                return (T) field.get(asBinder);
            } catch (IllegalAccessException e10) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
            } catch (NullPointerException e11) {
                throw new IllegalArgumentException("Binder object is null.", e11);
            }
        } else {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
    }
}
