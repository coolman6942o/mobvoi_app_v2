package kotlin.jvm.internal;

import wo.c;
import wo.d;
/* loaded from: classes3.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, d dVar, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((c) dVar).b(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
