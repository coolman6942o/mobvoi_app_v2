package kotlin.jvm.internal;

import wo.b;
import wo.h;
import wo.l;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements h {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.e(this);
    }

    public abstract /* synthetic */ V get(T t10);

    @Override // wo.l
    public Object getDelegate(Object obj) {
        return ((h) c()).getDelegate(obj);
    }

    @Override // qo.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public abstract /* synthetic */ void set(T t10, V v10);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((h) c()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, wo.g
    public h.a getSetter() {
        return ((h) c()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
