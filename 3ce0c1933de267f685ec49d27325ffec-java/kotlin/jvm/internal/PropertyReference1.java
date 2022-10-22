package kotlin.jvm.internal;

import wo.b;
import wo.l;
/* loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements l {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.h(this);
    }

    public abstract /* synthetic */ V get(T t10);

    @Override // wo.l
    public Object getDelegate(Object obj) {
        return ((l) c()).getDelegate(obj);
    }

    @Override // qo.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((l) c()).getGetter();
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
