package com.mobvoi.mcuwatch.artyfeed.adapter;

import a5.e;
import a5.j;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.c;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Article;
import com.cardiex.arty.lite.models.coach.Content;
import com.cardiex.arty.lite.models.coach.ContentType;
import com.cardiex.arty.lite.models.social.BadgeSummary;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.mcuwatch.article.ArticleActivity;
import com.mobvoi.mcuwatch.artyfeed.adapter.ArtyFeedAdapter;
import com.mobvoi.mcuwatch.badges.BadgesActivity;
import com.mobvoi.mcuwatch.recommendation.RecommendationActivity;
import com.mobvoi.mcuwatch.ui.customview.k;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
import sh.d;
import sh.f;
import sh.h;
import vh.a;
/* compiled from: ArtyFeedAdapter.kt */
/* loaded from: classes2.dex */
public final class ArtyFeedAdapter extends BaseMultiItemQuickAdapter<a, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Activity f19114a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyFeedAdapter(Activity context, List<a> list) {
        super(list);
        i.f(context, "context");
        i.f(list, "list");
        this.f19114a = context;
        addItemType(-1, sh.i.f34763x0);
        addItemType(0, sh.i.f34765y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ArtyFeedAdapter this$0, Advice advice, View view) {
        i.f(this$0, "this$0");
        i.f(advice, "$advice");
        RecommendationActivity.f19255g.a(this$0.j(), advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ArtyFeedAdapter this$0, View view) {
        i.f(this$0, "this$0");
        BadgesActivity.f19119h.a(this$0.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ArtyFeedAdapter this$0, a item, View view) {
        i.f(this$0, "this$0");
        i.f(item, "$item");
        ArticleActivity.b bVar = ArticleActivity.f19087g;
        Activity j10 = this$0.j();
        Article b10 = item.b();
        i.d(b10);
        bVar.a(j10, b10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void convert(BaseViewHolder helper, final a item) {
        List<Content> details;
        List<Content> U;
        Article b10;
        i.f(helper, "helper");
        i.f(item, "item");
        int itemType = item.getItemType();
        boolean z10 = true;
        if (itemType == 0) {
            final Advice a10 = item.a();
            if (a10 != null) {
                String str = null;
                ((LinearLayout) helper.getView(h.f34612a2)).setBackground(new k(j(), null, 2, null));
                int i10 = h.C2;
                Content primary = a10.getPrimary();
                if (primary != null) {
                    str = primary.getValue();
                }
                helper.setText(i10, str);
                TextView textView = (TextView) helper.getView(h.A2);
                if (a10.getDetails() != null) {
                    i.d(a10.getDetails());
                    if (!details.isEmpty()) {
                        List<Content> details2 = a10.getDetails();
                        i.d(details2);
                        U = u.U(details2);
                        for (Content content : U) {
                            if (content.getType() != ContentType.HTML) {
                                if (content.getType() == ContentType.GRAPH) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                z10 = false;
                if (z10) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                textView.setOnClickListener(new View.OnClickListener() { // from class: uh.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtyFeedAdapter.g(ArtyFeedAdapter.this, a10, view);
                    }
                });
            }
        } else if (itemType == 1) {
            BadgeSummary c10 = item.c();
            if (c10 != null) {
                helper.setText(h.M_res_0x7f0b00e9, j().getString(sh.k.Q, new Object[]{Integer.valueOf(c10.getBadgesEarned()), Integer.valueOf(c10.getTotalBadges())}));
                ProgressBar progressBar = (ProgressBar) helper.getView(h.f34705v2);
                TextView textView2 = (TextView) helper.getView(h.L_res_0x7f0b00e8);
                if (c10.getTotalBadges() != 0) {
                    progressBar.setProgress((int) ((c10.getBadgesEarned() * 100.0d) / c10.getTotalBadges()));
                }
                textView2.setOnClickListener(new View.OnClickListener() { // from class: uh.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtyFeedAdapter.h(ArtyFeedAdapter.this, view);
                    }
                });
            }
        } else if (itemType == 2 && (b10 = item.b()) != null) {
            TextView textView3 = (TextView) helper.getView(h.p_res_0x7f0b00a4);
            TextView textView4 = (TextView) helper.getView(h.k_res_0x7f0b009f);
            FrameLayout frameLayout = (FrameLayout) helper.getView(h.l_res_0x7f0b00a0);
            ImageView imageView = (ImageView) helper.getView(h.Q_res_0x7f0b00fc);
            ImageView imageView2 = (ImageView) helper.getView(h.m_res_0x7f0b00a1);
            textView3.setText(b10.getTitle());
            textView4.setText(b10.getSummary());
            String image = b10.getImage();
            if (image == null || image.length() == 0) {
                Resources resources = j().getResources();
                int i11 = d.f34445e;
                textView3.setTextColor(resources.getColor(i11));
                textView4.setTextColor(j().getResources().getColor(i11));
                imageView.setBackgroundResource(f.a_res_0x7f080098);
            } else {
                Resources resources2 = j().getResources();
                int i12 = d.f34444b0;
                textView3.setTextColor(resources2.getColor(i12));
                textView4.setTextColor(j().getResources().getColor(i12));
                c.t(j()).r(b10.getImage()).a(new j5.c().h0(new e(), new j(aa.d.b(10.0f, j())))).u0(imageView);
            }
            if (b10.isSeen()) {
                imageView2.setImageResource(f.f34577q);
            } else {
                imageView2.setImageResource(f.f34574p);
            }
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: uh.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArtyFeedAdapter.i(ArtyFeedAdapter.this, item, view);
                }
            });
        }
    }

    public final Activity j() {
        return this.f19114a;
    }
}
