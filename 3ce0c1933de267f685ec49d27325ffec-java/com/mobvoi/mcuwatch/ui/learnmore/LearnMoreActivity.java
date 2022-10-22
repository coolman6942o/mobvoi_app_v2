package com.mobvoi.mcuwatch.ui.learnmore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.ui.arty.ArtyAboutActivity;
import com.mobvoi.mcuwatch.ui.learnmore.LearnMoreActivity;
import kotlin.jvm.internal.i;
import sh.f;
import sh.h;
import sh.k;
/* compiled from: LearnMoreActivity.kt */
/* loaded from: classes2.dex */
public final class LearnMoreActivity extends d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f19722d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Integer[] f19723a = {Integer.valueOf(f.M0), Integer.valueOf(f.J0), Integer.valueOf(f.L0), Integer.valueOf(f.f34567m1), Integer.valueOf(f.X0), Integer.valueOf(f.f34537c1), Integer.valueOf(f.G0)};

    /* renamed from: b  reason: collision with root package name */
    private final Integer[] f19724b = {Integer.valueOf(k.f34819j1), Integer.valueOf(k.f34809h1), Integer.valueOf(k.f34788d1), Integer.valueOf(k.f34829l1), Integer.valueOf(k.f34799f1), Integer.valueOf(k.Z0), Integer.valueOf(k.f34776b1)};

    /* renamed from: c  reason: collision with root package name */
    private final Integer[] f19725c = {Integer.valueOf(k.f34824k1), Integer.valueOf(k.f34814i1), Integer.valueOf(k.f34794e1), Integer.valueOf(k.f34834m1), Integer.valueOf(k.f34804g1), Integer.valueOf(k.f34770a1), Integer.valueOf(k.f34782c1)};

    /* compiled from: LearnMoreActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, LearnMoreActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LearnMoreActivity.kt */
    /* loaded from: classes2.dex */
    public final class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final ImageView f19726a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f19727b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f19728c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LearnMoreActivity f19729d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LearnMoreActivity this$0, View item) {
            super(item);
            i.f(this$0, "this$0");
            i.f(item, "item");
            this.f19729d = this$0;
            View findViewById = item.findViewById(h.f34719y1);
            i.e(findViewById, "item.findViewById(R.id.iv_icon)");
            this.f19726a = (ImageView) findViewById;
            View findViewById2 = item.findViewById(h.f34647h4);
            i.e(findViewById2, "item.findViewById(R.id.tv_title)");
            this.f19727b = (TextView) findViewById2;
            View findViewById3 = item.findViewById(h.G3);
            i.e(findViewById3, "item.findViewById(R.id.tv_describe)");
            this.f19728c = (TextView) findViewById3;
        }

        public final void a(int i10) {
            this.f19726a.setImageResource(this.f19729d.f19723a[i10].intValue());
            this.f19727b.setText(this.f19729d.f19724b[i10].intValue());
            this.f19728c.setText(this.f19729d.f19725c[i10].intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LearnMoreActivity.kt */
    /* loaded from: classes2.dex */
    public final class c extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LearnMoreActivity f19730a;

        public c(LearnMoreActivity this$0) {
            i.f(this$0, "this$0");
            this.f19730a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(LearnMoreActivity this$0, int i10, View view) {
            i.f(this$0, "this$0");
            int intValue = this$0.f19724b[i10].intValue();
            if (intValue == k.f34819j1) {
                TakingReadingActivity.f19731c.a(this$0);
            } else if (intValue == k.f34809h1) {
                ArtyAboutActivity.S(this$0, 5);
            } else if (intValue == k.f34788d1) {
                ArtyAboutActivity.S(this$0, 0);
            } else if (intValue == k.f34829l1) {
                ArtyAboutActivity.S(this$0, 1);
            } else if (intValue == k.f34799f1) {
                ArtyAboutActivity.S(this$0, 2);
            } else if (intValue == k.Z0) {
                ArtyAboutActivity.S(this$0, 3);
            } else if (intValue == k.f34776b1) {
                ArtyAboutActivity.S(this$0, 4);
            }
        }

        /* renamed from: d */
        public void onBindViewHolder(b holder, final int i10) {
            i.f(holder, "holder");
            holder.a(i10);
            View view = holder.itemView;
            final LearnMoreActivity learnMoreActivity = this.f19730a;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.learnmore.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LearnMoreActivity.c.e(LearnMoreActivity.this, i10, view2);
                }
            });
        }

        /* renamed from: f */
        public b onCreateViewHolder(ViewGroup parent, int i10) {
            i.f(parent, "parent");
            LearnMoreActivity learnMoreActivity = this.f19730a;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(sh.i.A0, parent, false);
            i.e(inflate, "from(parent.context).inflate(R.layout.item_learn_more, parent, false)");
            return new b(learnMoreActivity, inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f19730a.f19724b.length;
        }
    }

    public static final void start(Context context) {
        f19722d.a(context);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.j_res_0x7f0e0028;
    }

    public final void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(h.D2);
        setTitle(getString(k.f34791d4));
        recyclerView.h(new ba.a(0, getResources().getColor(sh.d.f34442a0), aa.d.b(15.0f, this), 0));
        recyclerView.setAdapter(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }
}
