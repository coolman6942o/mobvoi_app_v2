package com.mobvoi.health.companion.sport.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.sport.SportTypeEditActivity;
import com.mobvoi.health.companion.sport.view.a;
import com.mobvoi.health.companion.sport.view.b;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import fg.v;
import java.util.List;
/* compiled from: SportPopWindow.java */
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private final View f18995a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f18996b;

    /* renamed from: c  reason: collision with root package name */
    private List<SportType> f18997c;

    /* renamed from: d  reason: collision with root package name */
    private a f18998d;

    /* renamed from: e  reason: collision with root package name */
    private SportType f18999e;

    /* renamed from: f  reason: collision with root package name */
    private C0220b f19000f;

    /* compiled from: SportPopWindow.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(SportType sportType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportPopWindow.java */
    /* renamed from: com.mobvoi.health.companion.sport.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0220b extends BaseQuickAdapter<SportType, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final int f19001a;

        /* renamed from: b  reason: collision with root package name */
        private final int f19002b;

        public C0220b(Context context, List<SportType> list) {
            super(t.U, list);
            this.f19001a = context.getColor(o.f26462i);
            this.f19002b = context.getColor(o.f26487u0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(SportType sportType, View view) {
            b.this.dismiss();
            if (b.this.f18998d != null) {
                b.this.f18998d.a(sportType);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public void convert(BaseViewHolder baseViewHolder, final SportType sportType) {
            TextView textView = (TextView) baseViewHolder.getView(s.f26777s5);
            ImageView imageView = (ImageView) baseViewHolder.getView(s.f26770r5);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(s.f26702i);
            if (sportType == SportType.AutoRunning || sportType == SportType.AutoWalking || sportType == SportType.AutoCycling) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26544a);
            } else if (sportType == SportType.Gymnastics || sportType == SportType.Spinning) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26580j);
            } else {
                imageView2.setVisibility(8);
            }
            a.C0219a e10 = com.mobvoi.health.companion.sport.view.a.d().e(sportType);
            if (sportType == SportType.Unknown) {
                imageView.setImageResource(q.f26611q2);
                imageView.setBackgroundResource(q.f26615r2);
                textView.setText(u.f26884f);
            } else {
                imageView.setBackgroundResource(q.f26627u2);
                imageView.setImageDrawable(androidx.core.content.b.e(b.this.f18996b, e10.f18992a));
                textView.setText(e10.f18994c);
            }
            if (b.this.f18999e == sportType) {
                textView.setTextColor(this.f19002b);
            } else {
                textView.setTextColor(this.f19001a);
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.health.companion.sport.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C0220b.this.e(sportType, view);
                }
            });
        }
    }

    public b(Activity activity, List<SportType> list, SportType sportType, a aVar) {
        super(activity);
        this.f18995a = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(t.T, (ViewGroup) null);
        this.f18996b = activity;
        this.f18997c = list;
        this.f18998d = aVar;
        this.f18999e = sportType;
        h(activity);
        g();
    }

    private void g() {
        setContentView(this.f18995a);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(v.f27010a);
        setBackgroundDrawable(new ColorDrawable(j7.a.e(this.f18995a, 16842801, -1)));
        f(this.f18996b, 1.0f);
    }

    private void h(final Activity activity) {
        RecyclerView recyclerView = (RecyclerView) this.f18995a.findViewById(s.B2);
        ((TextView) this.f18995a.findViewById(s.f26750o5)).setOnClickListener(new View.OnClickListener() { // from class: ch.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTypeEditActivity.S(activity);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 4));
        C0220b bVar = new C0220b(activity, this.f18997c);
        this.f19000f = bVar;
        recyclerView.setAdapter(bVar);
        this.f18995a.setOnClickListener(new View.OnClickListener() { // from class: ch.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.j(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        dismiss();
    }

    public void f(Activity activity, float f10) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f10;
        activity.getWindow().addFlags(2);
        activity.getWindow().setAttributes(attributes);
    }

    public void k() {
        C0220b bVar = this.f19000f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f18996b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight((view.getResources().getDisplayMetrics().heightPixels - rect.top) - ((int) ((displayMetrics.density * 56.0f) + 0.5f)));
        }
        super.showAsDropDown(view);
    }
}
