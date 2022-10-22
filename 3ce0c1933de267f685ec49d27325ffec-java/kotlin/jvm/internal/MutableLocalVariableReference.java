package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import wo.d;
/* compiled from: localVariableReferences.kt */
/* loaded from: classes3.dex */
public class MutableLocalVariableReference extends MutablePropertyReference0 {
    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public Object get() {
        j.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public d getOwner() {
        j.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(Object obj) {
        j.b();
        throw new KotlinNothingValueException();
    }
}
