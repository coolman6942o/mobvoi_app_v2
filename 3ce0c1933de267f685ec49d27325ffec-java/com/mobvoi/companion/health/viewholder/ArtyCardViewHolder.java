package com.mobvoi.companion.health.viewholder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.c;
import com.cardiex.arty.lite.models.coach.Action;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Content;
import com.cardiex.arty.lite.models.coach.ContentType;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.PercentLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.List;
import java.util.Objects;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import yc.d;
import yc.h;
import yc.j;
import yc.k;
import yc.l;
/* compiled from: ArtyCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class ArtyCardViewHolder extends i {
    public static final String ACTION_ARTY_CENTER = "com.mobvoi.arty.action.START_ARTY_CENTER";
    public static final String ACTION_ARTY_DETAIL = "com.mobvoi.arty.action.START_ARTY_DETAIL";
    public static final String ACTION_RECOMMENDATION = "com.mobvoi.arty.action.START_ACTION_RECOMMENDATION";
    public static final String ACTION_TAKE_READING = "com.mobvoi.arty.action.START_TAKE_READING";
    public static final a Companion = new a(null);
    public static final String TAG = "ArtyCardViewHolder";
    private PercentLayout mRoot = (PercentLayout) this.itemView.findViewById(R.id.root_layout);
    private CardView mCardView = (CardView) this.itemView.findViewById(R.id.cardview);

    /* compiled from: ArtyCardViewHolder.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ArtyCardViewHolder.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17096a;

        static {
            int[] iArr = new int[Action.values().length];
            iArr[Action.DETAIL.ordinal()] = 1;
            iArr[Action.DASHBOARD.ordinal()] = 2;
            iArr[Action.TAKE_READING.ordinal()] = 3;
            iArr[Action.ARTY_SCORE.ordinal()] = 4;
            iArr[Action.TRU_HR.ordinal()] = 5;
            iArr[Action.E_CAP.ordinal()] = 6;
            iArr[Action.HSX.ordinal()] = 7;
            iArr[Action.ARTY_AGE.ordinal()] = 8;
            f17096a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_mcu_arty_card);
        i.f(parentView, "parentView");
    }

    private final View getArtyViewByContentType(zc.a aVar) {
        String b10 = aVar.b();
        if (b10 != null) {
            switch (b10.hashCode()) {
                case -2094135325:
                    if (b10.equals("view_component")) {
                        return new yc.b(getContext(), null, 0, 6, null);
                    }
                    break;
                case -1573015406:
                    if (b10.equals("view_tips")) {
                        return new ArtyTipsTextView(getContext());
                    }
                    break;
                case -1530589388:
                    if (b10.equals("view_graph")) {
                        return new d(getContext(), null, 0, 6, null);
                    }
                    break;
                case -1530492702:
                    if (b10.equals("view_guide")) {
                        return new yc.f(getContext(), null, 0, 6, null);
                    }
                    break;
                case -1517002143:
                    if (b10.equals("view_video")) {
                        return new h(getContext(), null, 0, 6, null);
                    }
                    break;
                case -378556776:
                    if (b10.equals("view_answer")) {
                        return new yc.a(getContext(), null, 0, 6, null);
                    }
                    break;
                case -180906450:
                    if (b10.equals("view_take_reading")) {
                        return new j(getContext(), null, 0, 6, null);
                    }
                    break;
                case 1100905889:
                    if (b10.equals("view_bottom_image")) {
                        ImageView imageView = new ImageView(getContext());
                        Object c10 = aVar.c();
                        if (c10 != null && (c10 instanceof String)) {
                            c.u(getContext()).r((String) c10).u0(imageView);
                        }
                        return imageView;
                    }
                    break;
                case 1110183332:
                    if (b10.equals("view_sub_component")) {
                        return new l(getContext(), null, 0, 6, null);
                    }
                    break;
                case 1751933974:
                    if (b10.equals("view_head_image")) {
                        ImageView imageView2 = new ImageView(getContext());
                        imageView2.setImageResource(R.drawable.arty_chart_people_shortcut);
                        return imageView2;
                    }
                    break;
            }
        }
        return null;
    }

    private final void startArtyDetailActivity(int i10, String str, List<zc.a> list) {
        Intent intent = new Intent(str);
        Bundle bundle = new Bundle();
        bundle.putInt("data_type", i10);
        if (list != null) {
            for (zc.a aVar : list) {
                if (TextUtils.equals(aVar.b(), "view_tips") && (aVar.c() instanceof String)) {
                    Object c10 = aVar.c();
                    Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.String");
                    bundle.putString("extra_tips_content", (String) c10);
                }
            }
        }
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private final void startArtyRecommendationActivity(yc.c cVar) {
        List<Content> U;
        Advice a10 = cVar.a();
        boolean z10 = true;
        if ((a10 == null ? null : a10.getDetails()) != null) {
            List<Content> details = a10.getDetails();
            i.d(details);
            if (!details.isEmpty()) {
                List<Content> details2 = a10.getDetails();
                i.d(details2);
                U = u.U(details2);
                for (Content content : U) {
                    if (content.getType() == ContentType.HTML) {
                        break;
                    }
                }
            }
        }
        z10 = false;
        if (z10) {
            Intent intent = new Intent(ACTION_RECOMMENDATION);
            Bundle bundle = new Bundle();
            bundle.putParcelable("recommend_key", a10);
            intent.putExtras(bundle);
            getContext().startActivity(intent);
            return;
        }
        startArtyDetailActivity(-1, ACTION_ARTY_CENTER, cVar.b());
    }

    public final ConstraintLayout.b getArtyViewLayoutParamsByPos(int i10) {
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
        switch (i10) {
            case 1:
                ConstraintLayout.b bVar2 = new ConstraintLayout.b(-1, -1);
                int i11 = R.id.root_layout;
                bVar2.f1790d = i11;
                bVar2.f1796g = i11;
                bVar2.f1798h = i11;
                bVar2.f1804k = i11;
                return bVar2;
            case 2:
            case 7:
                int i12 = R.id.root_layout;
                bVar.f1796g = i12;
                bVar.f1798h = i12;
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                return bVar;
            case 3:
                ConstraintLayout.b bVar3 = new ConstraintLayout.b(-1, 0);
                int i13 = R.id.root_layout;
                bVar3.f1790d = i13;
                bVar3.f1796g = i13;
                bVar3.f1804k = i13;
                int dp2px = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                bVar3.setMargins(dp2px, dp2px, dp2px, dp2px);
                bVar3.R = 0.5f;
                return bVar3;
            case 4:
                int i14 = R.id.root_layout;
                bVar.f1790d = i14;
                bVar.f1804k = i14;
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                return bVar;
            case 5:
                int i15 = R.id.root_layout;
                bVar.f1796g = i15;
                bVar.f1804k = i15;
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                return bVar;
            case 6:
                int i16 = R.id.root_layout;
                bVar.f1790d = i16;
                bVar.f1798h = i16;
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = (int) DimensionUtils.dp2px(getContext(), 12.0f);
                return bVar;
            default:
                return bVar;
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(xc.b<?> data) {
        i.f(data, "data");
        if ((data instanceof xc.l) && data.c()) {
            yc.c a10 = ((xc.l) data).a();
            List<zc.a> b10 = a10 == null ? null : a10.b();
            if (b10 != null) {
                this.mRoot.removeAllViews();
                int i10 = 0;
                int size = b10.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        zc.a aVar = b10.get(i10);
                        View artyViewByContentType = getArtyViewByContentType(aVar);
                        ConstraintLayout.b artyViewLayoutParamsByPos = getArtyViewLayoutParamsByPos(aVar.a());
                        if (artyViewByContentType != null) {
                            artyViewByContentType.setLayoutParams(artyViewLayoutParamsByPos);
                            this.mRoot.addView(artyViewByContentType);
                            if (artyViewByContentType instanceof k) {
                                ((k) artyViewByContentType).c(aVar);
                            }
                        }
                        if (i11 <= size) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(xc.b<?> data, int i10, com.mobvoi.companion.health.viewholder.a controlInterface) {
        yc.c a10;
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        if (!CompanionSetting.isArtyAuthorize()) {
            b1.a.b(getContext()).d(new Intent("com.mobvoi.ACTION_SHOW_ARTY_AUTH"));
        } else if ((data instanceof xc.l) && data.c() && (a10 = ((xc.l) data).a()) != null) {
            Action c10 = a10.c();
            switch (c10 == null ? -1 : b.f17096a[c10.ordinal()]) {
                case 1:
                    startArtyRecommendationActivity(a10);
                    break;
                case 2:
                    startArtyDetailActivity(-1, ACTION_ARTY_CENTER, a10.b());
                    break;
                case 3:
                    getContext().startActivity(new Intent(ACTION_TAKE_READING));
                    break;
                case 4:
                    startArtyDetailActivity(0, ACTION_ARTY_DETAIL, a10.b());
                    break;
                case 5:
                    startArtyDetailActivity(1, ACTION_ARTY_DETAIL, a10.b());
                    break;
                case 6:
                    startArtyDetailActivity(2, ACTION_ARTY_DETAIL, a10.b());
                    break;
                case 7:
                    startArtyDetailActivity(3, ACTION_ARTY_DETAIL, a10.b());
                    break;
                case 8:
                    startArtyDetailActivity(4, ACTION_ARTY_DETAIL, a10.b());
                    break;
                default:
                    startArtyDetailActivity(-1, ACTION_ARTY_CENTER, a10.b());
                    break;
            }
            Advice a11 = a10.a();
            String id2 = a11 == null ? null : a11.getId();
            if (id2 != null) {
                ad.a.f168a.l(id2);
                b1.a.b(getContext()).d(new Intent("action.UPDATE_MCU_WATCH_DATA"));
            }
        }
    }
}
