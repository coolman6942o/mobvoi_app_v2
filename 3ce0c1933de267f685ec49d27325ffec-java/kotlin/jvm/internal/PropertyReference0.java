package kotlin.jvm.internal;

import wo.b;
import wo.k;
/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements k {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.g(this);
    }

    public abstract /* synthetic */ V get();

    @Override // wo.k
    public Object getDelegate() {
        return ((k) c()).getDelegate();
    }

    @Override // qo.a
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public k.a getGetter() {
        return ((k) c()).getGetter();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
