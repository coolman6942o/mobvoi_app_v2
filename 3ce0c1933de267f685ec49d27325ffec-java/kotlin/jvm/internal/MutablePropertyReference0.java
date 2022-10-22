package kotlin.jvm.internal;

import wo.b;
import wo.g;
import wo.k;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements g {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.d(this);
    }

    public abstract /* synthetic */ V get();

    @Override // wo.k
    public Object getDelegate() {
        return ((g) c()).getDelegate();
    }

    @Override // qo.a
    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(V v10);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public k.a getGetter() {
        return ((g) c()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, wo.g
    public g.a getSetter() {
        return ((g) c()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
