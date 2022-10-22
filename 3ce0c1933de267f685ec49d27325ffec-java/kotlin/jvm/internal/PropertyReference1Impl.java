package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(d dVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
