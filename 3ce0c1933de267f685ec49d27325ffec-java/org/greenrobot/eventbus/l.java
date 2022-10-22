package org.greenrobot.eventbus;

import java.lang.reflect.Method;
/* compiled from: SubscriberMethod.java */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    final Method f32491a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f32492b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f32493c;

    /* renamed from: d  reason: collision with root package name */
    final int f32494d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f32495e;

    /* renamed from: f  reason: collision with root package name */
    String f32496f;

    public l(Method method, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f32491a = method;
        this.f32492b = threadMode;
        this.f32493c = cls;
        this.f32494d = i10;
        this.f32495e = z10;
    }

    private synchronized void a() {
        if (this.f32496f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f32491a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f32491a.getName());
            sb2.append('(');
            sb2.append(this.f32493c.getName());
            this.f32496f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f32496f.equals(lVar.f32496f);
    }

    public int hashCode() {
        return this.f32491a.hashCode();
    }
}
