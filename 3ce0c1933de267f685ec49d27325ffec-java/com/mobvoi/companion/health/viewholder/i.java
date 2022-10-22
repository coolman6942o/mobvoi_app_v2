package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import xc.b;
/* compiled from: HomeTabViewHolder.kt */
/* loaded from: classes2.dex */
public abstract class i extends RecyclerView.b0 {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ViewGroup parentView, int i10) {
        super(LayoutInflater.from(parentView.getContext()).inflate(i10, parentView, false));
        kotlin.jvm.internal.i.f(parentView, "parentView");
        Context context = parentView.getContext();
        kotlin.jvm.internal.i.e(context, "parentView.context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m14bindData$lambda0(i this$0, b data, int i10, a controlInterface, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(data, "$data");
        kotlin.jvm.internal.i.f(controlInterface, "$controlInterface");
        this$0.onItemClick(data, i10, controlInterface);
    }

    public final void bindData(final b<?> data, final int i10, final a controlInterface) {
        kotlin.jvm.internal.i.f(data, "data");
        kotlin.jvm.internal.i.f(controlInterface, "controlInterface");
        if (needClick()) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.viewholder.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.m14bindData$lambda0(i.this, data, i10, controlInterface, view);
                }
            });
        } else {
            this.itemView.setOnClickListener(null);
        }
        if (!data.c()) {
            onDataEmpty();
        } else {
            onBindData(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    protected boolean needClick() {
        return true;
    }

    protected abstract void onBindData(b<?> bVar);

    protected abstract void onDataEmpty();

    protected abstract void onItemClick(b<?> bVar, int i10, a aVar);
}
