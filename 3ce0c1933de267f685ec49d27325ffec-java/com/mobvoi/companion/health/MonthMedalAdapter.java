package com.mobvoi.companion.health;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.entity.WeekSportDetailBean;
import com.mobvoi.companion.health.entity.a;
import com.mobvoi.companion.health.widget.WeekMedalItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import so.c;
import tc.d;
/* compiled from: MonthMedalAdapter.kt */
/* loaded from: classes2.dex */
public final class MonthMedalAdapter extends BaseMultiItemQuickAdapter<d, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16792a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f16793b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f16794c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f16795d = new int[5];

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonthMedalAdapter(Context context, List<d> list, Runnable runnable) {
        super(list);
        i.f(context, "context");
        this.f16792a = context;
        this.f16793b = runnable;
        int[] iArr = new int[5];
        this.f16794c = iArr;
        int i10 = 0;
        addItemType(0, R.layout.layout_current_week_medal);
        addItemType(1, R.layout.week_of_month_medal_view);
        addItemType(2, R.layout.layout_medal_center_load_failed);
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.medal_today_get_image_array);
        i.e(obtainTypedArray, "context.resources.obtainTypedArray(R.array.medal_today_get_image_array)");
        int length = iArr.length - 1;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                this.f16794c[i11] = obtainTypedArray.getResourceId(i11, -1);
                if (i12 > length) {
                    break;
                }
                i11 = i12;
            }
        }
        obtainTypedArray.recycle();
        TypedArray obtainTypedArray2 = this.f16792a.getResources().obtainTypedArray(R.array.medal_today_unget_image_array);
        i.e(obtainTypedArray2, "context.resources.obtainTypedArray(R.array.medal_today_unget_image_array)");
        int length2 = this.f16795d.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i13 = i10 + 1;
                this.f16795d[i10] = obtainTypedArray2.getResourceId(i10, -1);
                if (i13 > length2) {
                    break;
                }
                i10 = i13;
            }
        }
        obtainTypedArray2.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MonthMedalAdapter this$0, View view) {
        i.f(this$0, "this$0");
        Runnable runnable = this$0.f16793b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MonthMedalAdapter this$0, WeekSportDetailBean weekSportDetailBean, View view) {
        i.f(this$0, "this$0");
        MedalDetailActivity.f16785g.a(this$0.f16792a, weekSportDetailBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void convert(BaseViewHolder baseViewHolder, d dVar) {
        if (baseViewHolder != null && dVar != null) {
            int itemType = dVar.getItemType();
            a a10 = dVar.a();
            if (itemType == 0) {
                TextView textView = (TextView) baseViewHolder.getView(R.id.tv_current_sport_time);
                TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_target_sport_time);
                SportGoalProgressBar sportGoalProgressBar = (SportGoalProgressBar) baseViewHolder.getView(R.id.pb_sport_target);
                TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_complete_progress);
                ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_week_medal);
                if (a10 != null) {
                    int a11 = ph.a.a(a10.a());
                    int a12 = ph.a.a(a10.c());
                    int i10 = 100;
                    int b10 = a12 != 0 ? c.b((a11 * 100) / a12) : 0;
                    textView.setText(String.valueOf(a11));
                    textView2.setText(this.f16792a.getString(R.string.target_sport_time, Integer.valueOf(a12)));
                    if (b10 <= 100) {
                        i10 = b10;
                    }
                    sportGoalProgressBar.setProgress(i10);
                    Context context = this.f16792a;
                    int i11 = R.string.complete_sport_time;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i10);
                    sb2.append('%');
                    textView3.setText(context.getString(i11, sb2.toString()));
                    textView2.setVisibility(0);
                    textView3.setVisibility(0);
                    if (a10.b() >= 1) {
                        int b11 = a10.b() - 1;
                        int[] iArr = this.f16794c;
                        if (b11 >= iArr.length) {
                            return;
                        }
                        if (a11 >= a12) {
                            imageView.setImageResource(iArr[a10.b() - 1]);
                        } else {
                            imageView.setImageResource(this.f16795d[a10.b() - 1]);
                        }
                    }
                }
            } else if (itemType == 1) {
                WeekMedalItemView mWeekOne = (WeekMedalItemView) baseViewHolder.getView(R.id.week_item_one);
                WeekMedalItemView mWeekTwo = (WeekMedalItemView) baseViewHolder.getView(R.id.week_item_two);
                WeekMedalItemView mWeekThree = (WeekMedalItemView) baseViewHolder.getView(R.id.week_item_three);
                WeekMedalItemView mWeekFour = (WeekMedalItemView) baseViewHolder.getView(R.id.week_item_four);
                WeekMedalItemView mWeekFive = (WeekMedalItemView) baseViewHolder.getView(R.id.week_item_five);
                TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_current_month);
                ArrayList arrayList = new ArrayList();
                i.e(mWeekOne, "mWeekOne");
                arrayList.add(mWeekOne);
                i.e(mWeekTwo, "mWeekTwo");
                arrayList.add(mWeekTwo);
                i.e(mWeekThree, "mWeekThree");
                arrayList.add(mWeekThree);
                i.e(mWeekFour, "mWeekFour");
                arrayList.add(mWeekFour);
                i.e(mWeekFive, "mWeekFive");
                arrayList.add(mWeekFive);
                if (a10 != null) {
                    String d10 = a10.d();
                    textView4.setText(d10);
                    List<a.b> e10 = a10.e();
                    for (int i12 = 0; i12 < e10.size(); i12++) {
                        final WeekSportDetailBean a13 = WeekSportDetailBean.a(d10, e10.get(i12));
                        ((WeekMedalItemView) arrayList.get(i12)).a(a13);
                        ((WeekMedalItemView) arrayList.get(i12)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.j3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MonthMedalAdapter.g(MonthMedalAdapter.this, a13, view);
                            }
                        });
                    }
                    if (e10.size() >= 5 || arrayList.size() <= 0) {
                        baseViewHolder.getView(R.id.week_view_three_view).setVisibility(0);
                    } else {
                        baseViewHolder.getView(R.id.week_view_three_view).setVisibility(8);
                    }
                }
                arrayList.clear();
            } else if (itemType == 2) {
                ((TextView) baseViewHolder.getView(R.id.tv_refresh_medal_center)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.i3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MonthMedalAdapter.f(MonthMedalAdapter.this, view);
                    }
                });
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(parent, i10);
        i.e(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        if (i10 == 2) {
            float applyDimension = this.f16792a.getResources().getDisplayMetrics().heightPixels - TypedValue.applyDimension(1, 248.0f, this.f16792a.getResources().getDisplayMetrics());
            onCreateViewHolder.itemView.setLayoutParams(new RecyclerView.o(-1, applyDimension > 0.0f ? (int) applyDimension : -2));
        }
        return onCreateViewHolder;
    }
}
