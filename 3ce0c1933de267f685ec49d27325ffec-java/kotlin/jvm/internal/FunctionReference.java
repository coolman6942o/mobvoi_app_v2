package kotlin.jvm.internal;

import wo.b;
import wo.e;
/* loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements g, e {
    private final int arity;
    private final int flags;

    public FunctionReference(int i10) {
        this(i10, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b b() {
        return l.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public e c() {
        return (e) super.c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return i.b(getOwner(), functionReference.getOwner()) && getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && i.b(getBoundReceiver(), functionReference.getBoundReceiver());
        } else if (obj instanceof e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // wo.e
    public boolean isExternal() {
        return c().isExternal();
    }

    @Override // wo.e
    public boolean isInfix() {
        return c().isInfix();
    }

    @Override // wo.e
    public boolean isInline() {
        return c().isInline();
    }

    @Override // wo.e
    public boolean isOperator() {
        return c().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, wo.b
    public boolean isSuspend() {
        return c().isSuspend();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
