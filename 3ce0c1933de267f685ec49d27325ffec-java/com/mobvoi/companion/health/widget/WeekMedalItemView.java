package com.mobvoi.companion.health.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.entity.WeekSportDetailBean;
/* loaded from: classes2.dex */
public class WeekMedalItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17132a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f17133b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17134c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f17135d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f17136e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f17137f;

    public WeekMedalItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(WeekSportDetailBean weekSportDetailBean) {
        int i10 = weekSportDetailBean.f16842f - 1;
        this.f17134c.setText(this.f17135d[i10]);
        if (weekSportDetailBean.f16839c >= weekSportDetailBean.f16838b) {
            this.f17133b.setImageResource(this.f17137f[i10]);
        } else {
            this.f17133b.setImageResource(this.f17136e[i10]);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(this.f17132a).inflate(R.layout.week_medal_item_view, (ViewGroup) this, true);
        this.f17133b = (ImageView) findViewById(R.id.iv_medal);
        this.f17134c = (TextView) findViewById(R.id.tv_which_week);
    }

    public WeekMedalItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17132a = context;
        String[] stringArray = context.getResources().getStringArray(R.array.medal_week_array);
        this.f17135d = stringArray;
        this.f17136e = new int[stringArray.length];
        this.f17137f = new int[stringArray.length];
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.medal_unget_image_array);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.f17136e;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = obtainTypedArray.getResourceId(i12, -1);
            i12++;
        }
        obtainTypedArray.recycle();
        TypedArray obtainTypedArray2 = getResources().obtainTypedArray(R.array.medal_get_image_array);
        while (true) {
            int[] iArr2 = this.f17137f;
            if (i11 < iArr2.length) {
                iArr2[i11] = obtainTypedArray2.getResourceId(i11, -1);
                i11++;
            } else {
                obtainTypedArray2.recycle();
                return;
            }
        }
    }
}
