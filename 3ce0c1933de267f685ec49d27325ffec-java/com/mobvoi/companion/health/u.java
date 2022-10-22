package com.mobvoi.companion.health;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import kotlin.jvm.internal.i;
/* compiled from: CardManagementModule.kt */
/* loaded from: classes2.dex */
public final class u extends g.f {

    /* renamed from: a  reason: collision with root package name */
    private k3 f17090a;

    public final void a(k3 k3Var) {
        this.f17090a = k3Var;
    }

    @Override // androidx.recyclerview.widget.g.f
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.b0 viewHolder) {
        i.f(recyclerView, "recyclerView");
        i.f(viewHolder, "viewHolder");
        return g.f.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean onMove(RecyclerView recyclerView, RecyclerView.b0 fromViewHolder, RecyclerView.b0 toViewHolder) {
        i.f(recyclerView, "recyclerView");
        i.f(fromViewHolder, "fromViewHolder");
        i.f(toViewHolder, "toViewHolder");
        k3 k3Var = this.f17090a;
        return k3Var != null && k3Var.a(toViewHolder.getBindingAdapterPosition());
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onMoved(RecyclerView recyclerView, RecyclerView.b0 viewHolder, int i10, RecyclerView.b0 target, int i11, int i12, int i13) {
        i.f(recyclerView, "recyclerView");
        i.f(viewHolder, "viewHolder");
        i.f(target, "target");
        super.onMoved(recyclerView, viewHolder, i10, target, i11, i12, i13);
        k3 k3Var = this.f17090a;
        if (k3Var != null) {
            k3Var.b(i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onSwiped(RecyclerView.b0 viewHolder, int i10) {
        i.f(viewHolder, "viewHolder");
    }
}
