package com.mobvoi.companion.health.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import java.util.ArrayList;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class i extends RecyclerView.Adapter<RecyclerView.b0> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16981a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Integer> f16982b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private p f16983c;

    /* compiled from: HealthShareChartFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {
        a(View view) {
            super(view);
        }
    }

    public i(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f16981a = context;
    }

    private final View d(Context context, int i10, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(i10, viewGroup, false);
        kotlin.jvm.internal.i.e(inflate, "from(this).inflate(layoutId, parent, false)");
        return inflate;
    }

    public final ArrayList<Integer> c() {
        return this.f16982b;
    }

    public final void e(p pVar) {
        this.f16983c = pVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16982b.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (i10 == 0) {
            return 4;
        }
        Integer num = this.f16982b.get(i10 - 1);
        kotlin.jvm.internal.i.e(num, "cardTypeList[position - 1]");
        return num.intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 holder, int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        boolean z10 = true;
        if (i10 != getItemCount() - 1) {
            z10 = false;
        }
        p pVar = this.f16983c;
        if (pVar != null) {
            if (holder instanceof t) {
                ((t) holder).a(this.f16981a, pVar, z10);
            } else if (holder instanceof u) {
                ((u) holder).a(this.f16981a, pVar, z10);
            } else if (holder instanceof v) {
                ((v) holder).a(this.f16981a, pVar, z10);
            } else if (holder instanceof x) {
                ((x) holder).a(pVar, z10);
            } else if (holder instanceof w) {
                ((w) holder).a(pVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        if (i10 == 0) {
            return new t(d(this.f16981a, R.layout.layout_health_share_heart_rate, parent));
        }
        if (i10 == 1) {
            return new u(d(this.f16981a, R.layout.layout_health_share_pace, parent));
        }
        if (i10 == 2) {
            return new v(d(this.f16981a, R.layout.layout_health_share_speed, parent));
        }
        if (i10 == 3) {
            return new x(d(this.f16981a, R.layout.layout_health_share_swim, parent));
        }
        if (i10 != 4) {
            return new a(new View(this.f16981a));
        }
        Context context = this.f16981a;
        return new w(context, d(context, R.layout.layout_health_share_sport_info, parent));
    }
}
