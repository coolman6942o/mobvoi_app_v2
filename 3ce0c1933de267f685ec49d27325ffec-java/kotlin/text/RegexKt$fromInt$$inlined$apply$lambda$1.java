package kotlin.text;

import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class RegexKt$fromInt$$inlined$apply$lambda$1 extends Lambda implements l<Enum, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$$inlined$apply$lambda$1(int i10) {
        super(1);
        this.$value$inlined = i10;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ Boolean invoke(Enum r12) {
        return Boolean.valueOf(invoke2(r12));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Enum r32) {
        f fVar = (f) r32;
        return (this.$value$inlined & fVar.getMask()) == fVar.getValue();
    }
}
