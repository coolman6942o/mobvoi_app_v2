package com.huawei.hms.feature.dynamic;

import android.os.IBinder;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final T f13778a;

    private ObjectWrapper(T t10) {
        this.f13778a = t10;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f13778a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i10 = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i10++;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        } else if (!declaredFields[0].isAccessible()) {
            declaredFields[0].setAccessible(true);
            try {
                return (T) declaredFields[0].get(asBinder);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Get binder failed: null or not permitted.");
            }
        } else {
            throw new IllegalArgumentException("The field is accessible.");
        }
    }

    public static <T> IObjectWrapper wrap(T t10) {
        return new ObjectWrapper(t10);
    }
}
