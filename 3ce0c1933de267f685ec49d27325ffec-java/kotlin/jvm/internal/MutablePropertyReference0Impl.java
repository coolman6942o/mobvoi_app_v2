package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    public MutablePropertyReference0Impl(d dVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(Object obj) {
        getSetter().call(obj);
    }

    public MutablePropertyReference0Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public MutablePropertyReference0Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
