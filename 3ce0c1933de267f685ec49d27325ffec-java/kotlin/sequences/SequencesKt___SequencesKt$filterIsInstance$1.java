package kotlin.sequences;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: _Sequences.kt */
/* loaded from: classes3.dex */
public final class SequencesKt___SequencesKt$filterIsInstance$1 extends Lambda implements l<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 INSTANCE = new SequencesKt___SequencesKt$filterIsInstance$1();

    public SequencesKt___SequencesKt$filterIsInstance$1() {
        super(1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Boolean, boolean] */
    @Override // qo.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Object obj) {
        i.k(3, "R");
        return obj instanceof Object;
    }
}
