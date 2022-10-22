package kotlin.jvm.internal;

import wo.b;
import wo.j;
/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements j {
    public PropertyReference() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public j c() {
        return (j) super.c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && i.b(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (obj instanceof j) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public abstract /* synthetic */ j.a<V> getGetter();

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // wo.j
    public boolean isConst() {
        return c().isConst();
    }

    @Override // wo.j
    public boolean isLateinit() {
        return c().isLateinit();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) != 1 ? false : true);
    }
}
