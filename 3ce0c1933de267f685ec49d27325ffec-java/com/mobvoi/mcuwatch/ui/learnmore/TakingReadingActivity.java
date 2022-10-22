package com.mobvoi.mcuwatch.ui.learnmore;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.ui.learnmore.TakingReadingActivity;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
import sh.k;
/* compiled from: TakingReadingActivity.kt */
/* loaded from: classes2.dex */
public final class TakingReadingActivity extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f19731c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f19732a;

    /* renamed from: b  reason: collision with root package name */
    public b f19733b;

    /* compiled from: TakingReadingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, TakingReadingActivity.class));
        }
    }

    /* compiled from: TakingReadingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.Adapter<C0227b> {

        /* renamed from: a  reason: collision with root package name */
        private a f19734a;

        /* renamed from: b  reason: collision with root package name */
        private final Integer[] f19735b = {Integer.valueOf(sh.f.D1), Integer.valueOf(sh.f.F1), Integer.valueOf(sh.f.E1), Integer.valueOf(sh.f.C1)};

        /* renamed from: c  reason: collision with root package name */
        private final Integer[] f19736c = {Integer.valueOf(k.H2), Integer.valueOf(k.I2), Integer.valueOf(k.J2), Integer.valueOf(k.K2)};

        /* compiled from: TakingReadingActivity.kt */
        /* loaded from: classes2.dex */
        public interface a {
            void a(int i10);
        }

        /* compiled from: TakingReadingActivity.kt */
        /* renamed from: com.mobvoi.mcuwatch.ui.learnmore.TakingReadingActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0227b extends RecyclerView.b0 {

            /* renamed from: a  reason: collision with root package name */
            private final ImageView f19737a;

            /* renamed from: b  reason: collision with root package name */
            private final TextView f19738b;

            /* renamed from: c  reason: collision with root package name */
            private final Button f19739c;

            /* renamed from: d  reason: collision with root package name */
            private final LinearLayout f19740d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ b f19741e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0227b(b this$0, View view) {
                super(view);
                i.f(this$0, "this$0");
                i.f(view, "view");
                this.f19741e = this$0;
                this.f19737a = (ImageView) view.findViewById(h.A1);
                this.f19738b = (TextView) view.findViewById(h.G3);
                this.f19739c = (Button) view.findViewById(h.f34610a0);
                this.f19740d = (LinearLayout) view.findViewById(h.f34664m1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(b this$0, int i10, View view) {
                i.f(this$0, "this$0");
                a aVar = this$0.f19734a;
                if (aVar != null) {
                    aVar.a(i10 + 1);
                } else {
                    i.u("mCallback");
                    throw null;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(int i10, b this$0, View view) {
                i.f(this$0, "this$0");
                int parseInt = Integer.parseInt(view.getTag().toString());
                if (parseInt != i10) {
                    a aVar = this$0.f19734a;
                    if (aVar != null) {
                        aVar.a(parseInt);
                    } else {
                        i.u("mCallback");
                        throw null;
                    }
                }
            }

            public final void c(final int i10) {
                this.f19737a.setBackgroundResource(this.f19741e.f19735b[i10].intValue());
                Drawable background = this.f19737a.getBackground();
                Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                ((AnimationDrawable) background).start();
                String string = this.itemView.getResources().getString(this.f19741e.f19736c[i10].intValue());
                i.e(string, "itemView.resources.getString(describes[pos])");
                this.f19738b.setText(i0.b.a(string, 0));
                if (i10 == this.f19741e.getItemCount() - 1) {
                    this.f19739c.setText(k.L2);
                } else {
                    this.f19739c.setText(k.M2);
                }
                Button button = this.f19739c;
                final b bVar = this.f19741e;
                button.setOnClickListener(new View.OnClickListener() { // from class: yi.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TakingReadingActivity.b.C0227b.d(TakingReadingActivity.b.this, i10, view);
                    }
                });
                int childCount = this.f19740d.getChildCount();
                if (childCount > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        this.f19740d.getChildAt(i11).setSelected(i11 <= i10);
                        View childAt = this.f19740d.getChildAt(i11);
                        final b bVar2 = this.f19741e;
                        childAt.setOnClickListener(new View.OnClickListener() { // from class: yi.a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                TakingReadingActivity.b.C0227b.e(i10, bVar2, view);
                            }
                        });
                        if (i12 < childCount) {
                            i11 = i12;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: f */
        public void onBindViewHolder(C0227b holder, int i10) {
            i.f(holder, "holder");
            holder.c(i10);
        }

        /* renamed from: g */
        public C0227b onCreateViewHolder(ViewGroup parent, int i10) {
            i.f(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(sh.i.G0, parent, false);
            i.e(inflate, "from(parent.context)\n                    .inflate(R.layout.item_taking_a_reading, parent, false)");
            return new C0227b(this, inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 4;
        }

        public final void h(a callback) {
            i.f(callback, "callback");
            this.f19734a = callback;
        }
    }

    /* compiled from: TakingReadingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements b.a {
        c() {
        }

        @Override // com.mobvoi.mcuwatch.ui.learnmore.TakingReadingActivity.b.a
        public void a(int i10) {
            RecyclerView.Adapter adapter = TakingReadingActivity.this.I().getAdapter();
            i.d(adapter);
            if (i10 == adapter.getItemCount()) {
                TakingReadingActivity.this.finish();
            } else {
                TakingReadingActivity.this.I().w1(i10);
            }
        }
    }

    public final b H() {
        b bVar = this.f19733b;
        if (bVar != null) {
            return bVar;
        }
        i.u("listAdapter");
        throw null;
    }

    public final RecyclerView I() {
        RecyclerView recyclerView = this.f19732a;
        if (recyclerView != null) {
            return recyclerView;
        }
        i.u("recyclerView");
        throw null;
    }

    public final void J(b bVar) {
        i.f(bVar, "<set-?>");
        this.f19733b = bVar;
    }

    public final void K(RecyclerView recyclerView) {
        i.f(recyclerView, "<set-?>");
        this.f19732a = recyclerView;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34754t;
    }

    public final void initView() {
        setTitle(getString(k.f34819j1));
        View findViewById = findViewById(h.M2);
        i.e(findViewById, "findViewById(R.id.rv_tips)");
        K((RecyclerView) findViewById);
        new n().b(I());
        J(new b());
        I().setAdapter(H());
        H().h(new c());
        I().o1(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }
}
