package kotlin.jvm.internal;

import wo.b;
import wo.m;
/* loaded from: classes3.dex */
public abstract class PropertyReference2 extends PropertyReference implements m {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.i(this);
    }

    public abstract /* synthetic */ V get(D d10, E e10);

    @Override // wo.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((m) c()).getDelegate(obj, obj2);
    }

    @Override // qo.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((m) c()).getGetter();
    }
}
