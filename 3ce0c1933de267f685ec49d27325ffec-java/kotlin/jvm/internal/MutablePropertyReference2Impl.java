package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(d dVar, String str, String str2) {
        super(((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i10) {
        super(cls, str, str2, i10);
    }
}
