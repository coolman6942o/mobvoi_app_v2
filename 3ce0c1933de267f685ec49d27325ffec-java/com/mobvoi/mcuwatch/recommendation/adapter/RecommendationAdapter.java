package com.mobvoi.mcuwatch.recommendation.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyGraph;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.cardiex.arty.lite.models.coach.Duration;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataChartView;
import eg.c;
import gg.b;
import gg.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import sh.h;
/* compiled from: RecommendationAdapter.kt */
/* loaded from: classes2.dex */
public final class RecommendationAdapter extends BaseMultiItemQuickAdapter<ji.a, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Activity f19277a;

    /* renamed from: b  reason: collision with root package name */
    private int f19278b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19279c = true;

    /* compiled from: RecommendationAdapter.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19280a;

        static {
            int[] iArr = new int[ArtyType.values().length];
            iArr[ArtyType.ARTY.ordinal()] = 1;
            iArr[ArtyType.TRU_HR.ordinal()] = 2;
            iArr[ArtyType.E_CAP.ordinal()] = 3;
            iArr[ArtyType.HSX.ordinal()] = 4;
            iArr[ArtyType.AGE.ordinal()] = 5;
            f19280a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendationAdapter(Activity context, List<ji.a> list) {
        super(list);
        i.f(context, "context");
        i.f(list, "list");
        this.f19277a = context;
        addItemType(-1, sh.i.f34763x0);
        addItemType(0, sh.i.C0);
        addItemType(1, sh.i.B0);
    }

    private final void d(List<ArtyComponent> list, Map<Long, List<ArtyComponent>> map) {
        long j10;
        int i10 = this.f19278b;
        if (i10 == 0) {
            j10 = c.h();
        } else if (i10 == 1) {
            j10 = c.g();
        } else if (i10 != 2) {
            j10 = i10 != 3 ? 0L : c.i();
        } else if (this.f19279c) {
            j10 = c.e(true);
        } else {
            j10 = c.e(false);
        }
        for (ArtyComponent artyComponent : list) {
            long b10 = c.b(artyComponent.getTimestamp());
            if (b10 >= j10) {
                if (!map.containsKey(Long.valueOf(b10))) {
                    map.put(Long.valueOf(b10), new ArrayList());
                }
                List<ArtyComponent> list2 = map.get(Long.valueOf(b10));
                i.d(list2);
                list2.add(artyComponent);
            }
        }
    }

    private final int e(ArtyGraph artyGraph) {
        List<ArtyComponent> data = artyGraph.getData();
        boolean z10 = true;
        if (data != null && data.size() > 0) {
            int size = data.size();
            Duration duration = data.get(0).getDuration();
            long timestamp = data.get(0).getTimestamp();
            if (duration == Duration.DAY) {
                if (size <= 7) {
                    return 0;
                }
                if (size <= 31) {
                    return 1;
                }
            } else if (duration == Duration.MONTH) {
                if (size <= 6) {
                    Calendar calendar = Calendar.getInstance();
                    i.e(calendar, "getInstance()");
                    calendar.setTimeInMillis(timestamp);
                    if (calendar.get(2) + 1 > 6) {
                        z10 = false;
                    }
                    this.f19279c = z10;
                    return 2;
                } else if (size <= 12) {
                    return 3;
                }
            }
        }
        return -1;
    }

    private final Map<Long, List<gg.c>> f(ArtyGraph artyGraph) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        List<ArtyComponent> data = artyGraph.getData();
        if (data != null && !data.isEmpty()) {
            d(data, hashMap2);
            for (Map.Entry<Long, List<ArtyComponent>> entry : hashMap2.entrySet()) {
                long longValue = entry.getKey().longValue();
                hashMap.put(Long.valueOf(longValue), h(entry.getValue(), longValue));
            }
        }
        return hashMap;
    }

    private final int g(ArtyType artyType) {
        int i10 = a.f19280a[artyType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<gg.c> h(List<ArtyComponent> list, long j10) {
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        ArrayList arrayList4 = new ArrayList(list.size());
        ArrayList arrayList5 = new ArrayList(list.size());
        ArrayList arrayList6 = new ArrayList(list.size());
        for (ArtyComponent artyComponent : list) {
            ArtyType artyType = artyComponent.getArtyType();
            int i10 = artyType == null ? -1 : a.f19280a[artyType.ordinal()];
            if (i10 == 1) {
                long timestamp = artyComponent.getTimestamp();
                a15 = so.c.a(artyComponent.getValue());
                arrayList.add(new f(timestamp, a15));
            } else if (i10 == 2) {
                long timestamp2 = artyComponent.getTimestamp();
                a14 = so.c.a(artyComponent.getValue());
                arrayList2.add(new f(timestamp2, a14));
            } else if (i10 == 3) {
                long timestamp3 = artyComponent.getTimestamp();
                a13 = so.c.a(artyComponent.getValue());
                arrayList3.add(new f(timestamp3, a13));
            } else if (i10 == 4) {
                long timestamp4 = artyComponent.getTimestamp();
                a12 = so.c.a(artyComponent.getValue());
                arrayList4.add(new f(timestamp4, a12));
            } else if (i10 == 5) {
                double d10 = 2;
                a10 = so.c.a(artyComponent.getValue() - (artyComponent.getSpread() / d10));
                a11 = so.c.a(artyComponent.getValue() + (artyComponent.getSpread() / d10));
                arrayList5.add(new b(artyComponent.getTimestamp(), a10, a11));
            }
        }
        arrayList6.add(i(arrayList, j10));
        arrayList6.add(i(arrayList2, j10));
        arrayList6.add(i(arrayList3, j10));
        arrayList6.add(i(arrayList4, j10));
        arrayList6.add(i(arrayList5, j10));
        return arrayList6;
    }

    private final gg.c i(List<? extends f> list, long j10) {
        gg.a aVar;
        int i10;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        long j11 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = Integer.MAX_VALUE;
        int i20 = Integer.MIN_VALUE;
        for (f fVar : list) {
            if (fVar instanceof b) {
                i15 = ((b) fVar).f27456c;
                i10 = fVar.f27465b;
                i17 += i15;
                if (i15 > i20) {
                    i11 = i10;
                    i20 = i15;
                }
                if (i10 < i12) {
                    i12 = i10;
                    i19 = i15;
                }
            } else {
                i10 = fVar.f27465b;
                if (i10 > i11) {
                    i11 = i10;
                }
                if (i10 < i12) {
                    i12 = i10;
                    i16 = i12;
                    i18++;
                    i14 += i16;
                    j11 = fVar.f27464a;
                }
            }
            i16 = i10;
            i18++;
            i14 += i16;
            j11 = fVar.f27464a;
        }
        if (i17 > 0) {
            int i21 = i18 > 0 ? i14 / i18 : 0;
            int i22 = i18 > 0 ? i12 : 0;
            int i23 = i18 > 0 ? i11 : 0;
            int i24 = i15;
            gg.a aVar2 = new gg.a(i21, i22, i23, j10, list, i16, j11);
            aVar2.f27452h = i18 > 0 ? i17 / i18 : 0;
            if (i18 <= 0) {
                i19 = 0;
            }
            aVar2.f27453i = i19;
            if (i18 > 0) {
                i13 = i20;
            }
            aVar2.f27454j = i13;
            aVar2.f27455k = i24;
            aVar = aVar2;
        } else {
            aVar = new gg.c(i18 > 0 ? i14 / i18 : 0, i18 > 0 ? i12 : 0, i18 > 0 ? i11 : 0, j10, list, i16, j11);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void convert(BaseViewHolder helper, ji.a item) {
        i.f(helper, "helper");
        i.f(item, "item");
        int itemType = item.getItemType();
        if (itemType == 0) {
            ImageView imageView = (ImageView) helper.getView(h.A1);
            if (TextUtils.isEmpty(item.b())) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                com.bumptech.glide.c.t(this.f19277a).r(item.b()).u0(imageView);
            }
            WebView webView = new WebView(this.f19277a);
            webView.setHorizontalFadingEdgeEnabled(false);
            webView.setVerticalScrollBarEnabled(false);
            webView.getSettings().setJavaScriptEnabled(false);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(false);
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webView.getSettings().setDefaultTextEncodingName("utf-8");
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setCacheMode(-1);
            webView.setFocusable(false);
            ((FrameLayout) helper.getView(h.X0)).addView(webView);
            if (!TextUtils.isEmpty(item.c())) {
                String c10 = item.c();
                i.d(c10);
                webView.loadDataWithBaseURL(null, c10, "text/html", "utf-8", null);
            }
        } else if (itemType == 1) {
            ArtyDataChartView artyDataChartView = (ArtyDataChartView) helper.getView(h.f34708w0);
            ArtyGraph a10 = item.a();
            if (a10 != null) {
                int e10 = e(a10);
                this.f19278b = e10;
                if (e10 != -1) {
                    artyDataChartView.c(e10);
                    artyDataChartView.a(Boolean.valueOf(this.f19279c));
                    artyDataChartView.setArtyDataType(g(a10.getArtyType()));
                    artyDataChartView.setArtyDetailData(f(a10));
                }
            }
        }
    }
}
