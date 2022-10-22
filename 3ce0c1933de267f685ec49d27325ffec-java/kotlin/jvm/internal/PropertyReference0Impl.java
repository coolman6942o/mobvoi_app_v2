package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(d dVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public PropertyReference0Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
