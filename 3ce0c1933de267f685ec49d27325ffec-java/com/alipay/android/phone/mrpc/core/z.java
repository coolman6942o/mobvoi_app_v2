package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<Object> f6804a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f6805b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public byte f6806c = 0;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f6807d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public x f6808e;

    public z(x xVar) {
        this.f6808e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (!(Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())) {
            OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
            boolean z10 = method.getAnnotation(ResetCookie.class) != null;
            Type genericReturnType = method.getGenericReturnType();
            method.getAnnotations();
            ThreadLocal<Object> threadLocal = f6804a;
            threadLocal.set(null);
            ThreadLocal<Map<String, Object>> threadLocal2 = f6805b;
            threadLocal2.set(null);
            if (operationType != null) {
                String value = operationType.value();
                int incrementAndGet = this.f6807d.incrementAndGet();
                try {
                    if (this.f6806c == 0) {
                        e eVar = new e(incrementAndGet, value, objArr);
                        if (threadLocal2.get() != null) {
                            eVar.a(threadLocal2.get());
                        }
                        byte[] a10 = eVar.a();
                        threadLocal2.set(null);
                        Object a11 = new d(genericReturnType, (byte[]) new j(this.f6808e.a(), method, incrementAndGet, value, a10, z10).a()).a();
                        if (genericReturnType != Void.TYPE) {
                            threadLocal.set(a11);
                        }
                    }
                    return threadLocal.get();
                } catch (RpcException e10) {
                    e10.setOperationType(value);
                    throw e10;
                }
            } else {
                throw new IllegalStateException("OperationType must be set.");
            }
        } else {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
    }
}
