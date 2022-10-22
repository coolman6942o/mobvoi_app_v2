package kotlin.jvm.internal;

import wo.f;
import wo.j;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference extends PropertyReference {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ j.a<V> getGetter();

    public abstract /* synthetic */ f<V> getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
