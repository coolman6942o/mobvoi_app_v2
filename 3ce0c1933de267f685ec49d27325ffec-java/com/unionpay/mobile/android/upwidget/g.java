package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class g extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24061a;

    /* renamed from: b  reason: collision with root package name */
    private c f24062b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<AdapterView.OnItemClickListener> f24063c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24064d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private AdapterView.OnItemClickListener f24065e = new h(this);

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f24066f = new i(this);

    public g(Context context, c cVar) {
        super(context);
        this.f24061a = context;
        this.f24062b = cVar;
        RelativeLayout relativeLayout = new RelativeLayout(this.f24061a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        LinearLayout linearLayout = new LinearLayout(this.f24061a);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setId(linearLayout.hashCode());
        relativeLayout.addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = new LinearLayout(this.f24061a);
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(2, linearLayout.getId());
        relativeLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.setOnClickListener(this.f24066f);
        int a10 = com.unionpay.mobile.android.utils.g.a(this.f24061a, 1.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i10 = b.f23336a;
        layoutParams3.bottomMargin = i10;
        layoutParams3.topMargin = i10;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, a10);
        LinearLayout linearLayout3 = new LinearLayout(this.f24061a);
        linearLayout3.setBackgroundColor(-3355444);
        linearLayout.addView(linearLayout3, layoutParams4);
        new LinearLayout.LayoutParams(-1, -2);
        ListView listView = new ListView(this.f24061a);
        listView.setDivider(null);
        a(listView, this.f24062b);
        listView.setAdapter(this.f24062b);
        listView.setCacheColorHint(-1);
        listView.setOnItemClickListener(this.f24065e);
        new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(listView);
        addView(relativeLayout);
    }

    private void a(ListView listView, ListAdapter listAdapter) {
        ViewGroup.LayoutParams layoutParams;
        if (!(listAdapter == null || (layoutParams = listView.getLayoutParams()) == null)) {
            Rect rect = new Rect();
            ((Activity) this.f24061a).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            int i10 = 0;
            for (int i11 = 0; i11 < listAdapter.getCount(); i11++) {
                View view = listAdapter.getView(i11, null, listView);
                view.measure(0, 0);
                i10 += view.getMeasuredHeight();
                if (i10 > height) {
                    break;
                }
            }
            layoutParams.height = Math.min(i10, height);
            listView.setLayoutParams(layoutParams);
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f24064d.add(onClickListener);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f24063c.add(onItemClickListener);
    }
}
