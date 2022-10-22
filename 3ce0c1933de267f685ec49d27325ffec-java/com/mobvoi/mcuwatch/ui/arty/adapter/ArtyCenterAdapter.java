package com.mobvoi.mcuwatch.ui.arty.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.card.MaterialCardView;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import com.mobvoi.mcuwatch.artyfeed.ArtyFeedActivity;
import com.mobvoi.mcuwatch.ui.arty.adapter.ArtyCenterAdapter;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataCommonView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyScoreView;
import com.mobvoi.mcuwatch.ui.learnmore.LearnMoreActivity;
import gg.c;
import java.util.List;
import sh.f;
import sh.h;
import sh.i;
import sh.k;
import ti.a;
/* loaded from: classes2.dex */
public class ArtyCenterAdapter extends BaseMultiItemQuickAdapter<a, BaseViewHolder> {
    public ArtyCenterAdapter(List<a> list) {
        super(list);
        addItemType(0, i.L0);
        addItemType(1, i.K0);
        int i10 = i.J0;
        addItemType(2, i10);
        addItemType(3, i10);
        addItemType(4, i.I0);
    }

    private void k(BaseViewHolder baseViewHolder, a aVar) {
        final Context context = baseViewHolder.itemView.getContext();
        int itemType = aVar.getItemType();
        ImageView imageView = (ImageView) baseViewHolder.getView(h.s_res_0x7f0b00a8);
        TextView textView = (TextView) baseViewHolder.getView(h.t_res_0x7f0b00a9);
        final TextView textView2 = (TextView) baseViewHolder.getView(h.u_res_0x7f0b00aa);
        if (itemType == 2) {
            imageView.setBackground(context.getDrawable(f.f34544f));
            textView.setText(k.i_res_0x7f1400c9);
            int i10 = aVar.f35165d;
            if (i10 > 0) {
                textView2.setText(String.valueOf(i10));
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: si.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyCenterAdapter.q(textView2, context, view);
                }
            });
        } else if (itemType == 3) {
            imageView.setBackground(context.getDrawable(f.Y));
            textView.setText(k.p_res_0x7f1400d5);
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: si.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LearnMoreActivity.start(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(TextView textView, Context context, View view) {
        textView.setVisibility(8);
        ArtyFeedActivity.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public void convert(BaseViewHolder baseViewHolder, a aVar) {
        int itemType = aVar.getItemType();
        if (itemType == 0) {
            ((ArtyTipsTextView) baseViewHolder.getView(h.H)).setText(aVar.f35164c);
        } else if (itemType == 1) {
            final ArtyScoreView artyScoreView = (ArtyScoreView) baseViewHolder.getView(h.D_res_0x7f0b00bb);
            MaterialCardView materialCardView = (MaterialCardView) baseViewHolder.getView(h.u0_res_0x7f0b0165);
            final ArtyDataCommonView artyDataCommonView = (ArtyDataCommonView) baseViewHolder.getView(h.I_res_0x7f0b00c2);
            final ArtyDataCommonView artyDataCommonView2 = (ArtyDataCommonView) baseViewHolder.getView(h.z_res_0x7f0b00af);
            final ArtyDataCommonView artyDataCommonView3 = (ArtyDataCommonView) baseViewHolder.getView(h.A_res_0x7f0b00b8);
            final ArtyDataCommonView artyDataCommonView4 = (ArtyDataCommonView) baseViewHolder.getView(h.r_res_0x7f0b00a7);
            MaterialCardView materialCardView2 = (MaterialCardView) baseViewHolder.getView(h.v0_res_0x7f0b0166);
            MaterialCardView materialCardView3 = (MaterialCardView) baseViewHolder.getView(h.s0_res_0x7f0b0163);
            MaterialCardView materialCardView4 = (MaterialCardView) baseViewHolder.getView(h.t0_res_0x7f0b0164);
            MaterialCardView materialCardView5 = (MaterialCardView) baseViewHolder.getView(h.f34687r0);
            List<c> a10 = aVar.a();
            if (a10 != null) {
                artyScoreView.setScore(a10.get(0).f27461e);
                artyDataCommonView.d(1, a10.get(1));
                artyDataCommonView2.d(2, a10.get(2));
                artyDataCommonView3.d(3, a10.get(3));
                artyDataCommonView4.d(4, a10.get(4));
            } else {
                artyScoreView.c();
                artyDataCommonView.c(1);
                artyDataCommonView2.c(2);
                artyDataCommonView3.c(3);
                artyDataCommonView4.c(4);
            }
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: si.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyScoreView.this.b();
                }
            });
            materialCardView2.setOnClickListener(new View.OnClickListener() { // from class: si.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyDataCommonView.this.b();
                }
            });
            materialCardView3.setOnClickListener(new View.OnClickListener() { // from class: si.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyDataCommonView.this.b();
                }
            });
            materialCardView4.setOnClickListener(new View.OnClickListener() { // from class: si.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyDataCommonView.this.b();
                }
            });
            materialCardView5.setOnClickListener(new View.OnClickListener() { // from class: si.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyDataCommonView.this.b();
                }
            });
        } else if (itemType == 2 || itemType == 3) {
            k(baseViewHolder, aVar);
        }
    }
}
