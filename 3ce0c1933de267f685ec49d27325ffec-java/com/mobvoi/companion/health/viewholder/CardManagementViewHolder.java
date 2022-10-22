package com.mobvoi.companion.health.viewholder;

import android.content.Intent;
import android.view.ViewGroup;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.CardManagementActivity;
import kotlin.jvm.internal.i;
import xc.b;
/* compiled from: CardManagementViewHolder.kt */
/* loaded from: classes2.dex */
public final class CardManagementViewHolder extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardManagementViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_card_management);
        i.f(parentView, "parentView");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected boolean needClick() {
        return true;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        getContext().startActivity(new Intent(getContext(), CardManagementActivity.class));
    }
}
