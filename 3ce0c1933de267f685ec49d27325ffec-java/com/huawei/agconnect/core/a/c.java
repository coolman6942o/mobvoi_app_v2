package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private Map<Class<?>, Service> f13509a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<Class<?>, Object> f13510b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<Service> list) {
        if (list != null) {
            for (Service service : list) {
                this.f13509a.put(service.getInterface(), service);
            }
        }
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb2;
        String str;
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a10 = a(type, Context.class, AGConnectInstance.class);
            if (a10 != null) {
                return a10.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor a11 = a(type, Context.class);
            return a11 != null ? a11.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e10) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e10.getLocalizedMessage();
            sb2.append(str);
            Log.e("ServiceRepository", sb2.toString());
            return null;
        } catch (InstantiationException e11) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e11.getLocalizedMessage();
            sb2.append(str);
            Log.e("ServiceRepository", sb2.toString());
            return null;
        } catch (InvocationTargetException e12) {
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            str = e12.getLocalizedMessage();
            sb2.append(str);
            Log.e("ServiceRepository", sb2.toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        Constructor<?>[] declaredConstructors;
        boolean z10 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i10 = 0; i10 < clsArr.length; i10++) {
                    z10 = parameterTypes[i10] == clsArr[i10];
                }
                if (z10) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t10;
        Service service = this.f13509a.get(cls);
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t10 = (T) this.f13510b.get(cls)) != null) {
            return t10;
        }
        T t11 = (T) a(aGConnectInstance, service);
        if (t11 != null && service.isSingleton()) {
            this.f13510b.put(cls, t11);
        }
        return t11;
    }
}
