package kotlin.jvm.internal;

import wo.b;
import wo.i;
import wo.m;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements i {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.f(this);
    }

    public abstract /* synthetic */ V get(D d10, E e10);

    @Override // wo.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((i) c()).getDelegate(obj, obj2);
    }

    @Override // qo.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public abstract /* synthetic */ void set(D d10, E e10, V v10);

    public MutablePropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((i) c()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, wo.g
    public i.a getSetter() {
        return ((i) c()).getSetter();
    }
}
