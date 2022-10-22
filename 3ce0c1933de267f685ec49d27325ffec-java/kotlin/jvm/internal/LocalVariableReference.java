package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import wo.d;
/* compiled from: localVariableReferences.kt */
/* loaded from: classes3.dex */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        j.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public d getOwner() {
        j.b();
        throw new KotlinNothingValueException();
    }
}
