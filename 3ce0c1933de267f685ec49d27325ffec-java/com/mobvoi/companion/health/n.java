package com.mobvoi.companion.health;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.viewholder.k;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.i;
import oc.q;
/* compiled from: CardManagementModule.kt */
/* loaded from: classes2.dex */
public final class n extends RecyclerView.Adapter<RecyclerView.b0> implements k3 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16890a;

    /* renamed from: b  reason: collision with root package name */
    private final g f16891b;

    /* renamed from: c  reason: collision with root package name */
    private final List<k> f16892c;

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f16893d;

    /* compiled from: CardManagementModule.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {
        a(TextView textView) {
            super(textView);
        }
    }

    /* compiled from: CardManagementModule.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.b0 {
        b(TextView textView) {
            super(textView);
        }
    }

    public n(Context context, g itemTouchHelper, List<k> cardsAdded, List<k> cardsPending) {
        i.f(context, "context");
        i.f(itemTouchHelper, "itemTouchHelper");
        i.f(cardsAdded, "cardsAdded");
        i.f(cardsPending, "cardsPending");
        this.f16890a = context;
        this.f16891b = itemTouchHelper;
        this.f16892c = cardsAdded;
        this.f16893d = cardsPending;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(v cardViewHolder, n this$0, View view) {
        i.f(cardViewHolder, "$cardViewHolder");
        i.f(this$0, "this$0");
        int bindingAdapterPosition = cardViewHolder.getBindingAdapterPosition() - 1;
        this$0.f16892c.remove(bindingAdapterPosition);
        this$0.f16893d.add(0, this$0.f16892c.get(bindingAdapterPosition));
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(n this$0, int i10, View view) {
        i.f(this$0, "this$0");
        this$0.f16893d.remove(i10);
        this$0.f16892c.add(this$0.f16893d.get(i10));
        this$0.notifyDataSetChanged();
    }

    @Override // com.mobvoi.companion.health.k3
    public boolean a(int i10) {
        return i10 > 0 && i10 <= this.f16892c.size();
    }

    @Override // com.mobvoi.companion.health.k3
    public void b(int i10, int i11) {
        if (i10 >= i11) {
            int i12 = i11 + 1;
            if (i12 <= i10) {
                int i13 = i10;
                while (true) {
                    i13--;
                    Collections.swap(this.f16892c, i13 - 1, i13 - 2);
                    if (i13 == i12) {
                        break;
                    }
                }
            }
        } else if (i10 < i11) {
            int i14 = i10;
            while (true) {
                int i15 = i14 + 1;
                Collections.swap(this.f16892c, i14 - 1, i14);
                if (i15 >= i11) {
                    break;
                }
                i14 = i15;
            }
        }
        notifyItemMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16892c.size() + 1 + 1 + this.f16893d.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (i10 == 0 || i10 == this.f16892c.size() + 1) {
            return 1;
        }
        return i10 == getItemCount() - 1 ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 holder, int i10) {
        int i11;
        i.f(holder, "holder");
        int itemViewType = getItemViewType(i10);
        if (itemViewType == 1) {
            Context context = this.f16890a;
            if (i10 == 0) {
                i11 = R.string.home_tab_card_mgr_section_added;
            } else {
                i11 = R.string.home_tab_card_mgr_section_pending;
            }
            String string = context.getString(i11);
            i.e(string, "context.getString(\n                    if (position == 0) R.string.home_tab_card_mgr_section_added\n                    else R.string.home_tab_card_mgr_section_pending\n                )");
            ((TextView) holder.itemView).setText(string);
        } else if (itemViewType == 2) {
            final v vVar = (v) holder;
            if (i10 <= 0 || i10 > this.f16892c.size()) {
                final int size = (i10 - this.f16892c.size()) - 2;
                vVar.a().f31560c.setVisibility(8);
                vVar.a().f31562e.setText(this.f16890a.getString(this.f16893d.get(size).e()));
                if (this.f16893d.get(size).d() == null) {
                    vVar.a().f31561d.setVisibility(8);
                } else {
                    TextView textView = vVar.a().f31561d;
                    textView.setVisibility(0);
                    textView.setText(this.f16893d.get(size).d());
                }
                vVar.a().f31559b.setImageDrawable(androidx.core.content.b.e(this.f16890a, R.drawable.ic_card_mgr_add));
                vVar.a().f31560c.setOnTouchListener(null);
                if (this.f16893d.get(size).f()) {
                    vVar.a().f31559b.setAlpha(1.0f);
                    vVar.a().f31559b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.l
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            n.f(n.this, size, view);
                        }
                    });
                    return;
                }
                vVar.a().f31559b.setAlpha(0.3f);
                vVar.a().f31559b.setOnClickListener(null);
                return;
            }
            vVar.a().f31560c.setVisibility(0);
            vVar.a().f31562e.setText(this.f16890a.getString(this.f16892c.get(i10 - 1).e()));
            vVar.a().f31561d.setVisibility(8);
            vVar.a().f31559b.setImageDrawable(androidx.core.content.b.e(this.f16890a, R.drawable.ic_card_mgr_del));
            vVar.a().f31560c.setOnTouchListener(new com.mobvoi.companion.health.a(this.f16891b, vVar));
            vVar.a().f31559b.setAlpha(1.0f);
            vVar.a().f31559b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.e(v.this, this, view);
                }
            });
        } else if (itemViewType == 3) {
            ((TextView) holder.itemView).setText(this.f16890a.getString(R.string.home_tab_card_mgr_list_footer));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        if (i10 == 1) {
            TextView textView = new TextView(this.f16890a);
            textView.setLayoutParams(new RecyclerView.o(-1, -2));
            textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.home_tab_card_section));
            textView.setTextSize(12.0f);
            textView.setGravity(3);
            return new a(textView);
        } else if (i10 != 3) {
            q d10 = q.d(LayoutInflater.from(this.f16890a), parent, false);
            i.e(d10, "inflate(\n                        LayoutInflater.from(context),\n                        parent,\n                        false\n                    )");
            return new v(d10);
        } else {
            TextView textView2 = new TextView(this.f16890a);
            textView2.setLayoutParams(new RecyclerView.o(-1, -2));
            textView2.setTextColor(androidx.core.content.b.c(textView2.getContext(), R.color.home_tab_card_feature_desc));
            textView2.setGravity(17);
            textView2.setTextSize(10.0f);
            return new b(textView2);
        }
    }
}
