package com.mobvoi.companion.health;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.i;
import oc.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardManagementModule.kt */
/* loaded from: classes2.dex */
public final class v extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final q f17093a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(q viewBinding) {
        super(viewBinding.a());
        i.f(viewBinding, "viewBinding");
        this.f17093a = viewBinding;
    }

    public final q a() {
        return this.f17093a;
    }
}
