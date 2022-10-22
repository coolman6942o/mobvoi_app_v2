package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(d dVar, String str, String str2) {
        super(((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    public PropertyReference2Impl(Class cls, String str, String str2, int i10) {
        super(cls, str, str2, i10);
    }
}
