package com.mobvoi.companion.health;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.health.entity.WeekSportDetailBean;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: MedalDetailActivity.kt */
/* loaded from: classes2.dex */
public final class MedalDetailActivity extends d {

    /* renamed from: g  reason: collision with root package name */
    public static final a f16785g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private WeekSportDetailBean f16786a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16787b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f16788c = new int[5];

    /* renamed from: d  reason: collision with root package name */
    private final int[] f16789d = new int[5];

    /* renamed from: e  reason: collision with root package name */
    private final int[] f16790e = new int[5];

    /* renamed from: f  reason: collision with root package name */
    private final io.d f16791f = com.mobvoi.android.common.ui.viewbinding.a.a(this, b.INSTANCE);

    /* compiled from: MedalDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context, WeekSportDetailBean weekSportDetailBean) {
            i.f(context, "context");
            Intent intent = new Intent(context, MedalDetailActivity.class);
            intent.putExtra("data", weekSportDetailBean);
            context.startActivity(intent);
        }
    }

    /* compiled from: MedalDetailActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements l<LayoutInflater, oc.d> {
        public static final b INSTANCE = new b();

        b() {
            super(1, oc.d.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/companion/databinding/ActivityMedalDetailBinding;", 0);
        }

        /* renamed from: g */
        public final oc.d invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return oc.d.d(p02);
        }
    }

    private final oc.d H() {
        return (oc.d) this.f16791f.getValue();
    }

    private final void I() {
        Intent intent = getIntent();
        if (intent.hasExtra("data")) {
            this.f16786a = (WeekSportDetailBean) intent.getParcelableExtra("data");
        }
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.medal_detail_unget_image_array);
        i.e(obtainTypedArray, "resources.obtainTypedArray(R.array.medal_detail_unget_image_array)");
        int length = this.f16788c.length - 1;
        int i10 = 0;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                this.f16788c[i11] = obtainTypedArray.getResourceId(i11, -1);
                if (i12 > length) {
                    break;
                }
                i11 = i12;
            }
        }
        obtainTypedArray.recycle();
        TypedArray obtainTypedArray2 = getResources().obtainTypedArray(R.array.medal_detail_get_image_array);
        i.e(obtainTypedArray2, "resources.obtainTypedArray(R.array.medal_detail_get_image_array)");
        int length2 = this.f16789d.length - 1;
        if (length2 >= 0) {
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                this.f16789d[i13] = obtainTypedArray2.getResourceId(i13, -1);
                if (i14 > length2) {
                    break;
                }
                i13 = i14;
            }
        }
        obtainTypedArray2.recycle();
        TypedArray obtainTypedArray3 = getResources().obtainTypedArray(R.array.medal_detail_bg_color_array);
        i.e(obtainTypedArray3, "resources.obtainTypedArray(R.array.medal_detail_bg_color_array)");
        int length3 = this.f16790e.length - 1;
        if (length3 >= 0) {
            while (true) {
                int i15 = i10 + 1;
                this.f16790e[i10] = obtainTypedArray2.getColor(i10, -1);
                if (i15 > length3) {
                    break;
                }
                i10 = i15;
            }
        }
        obtainTypedArray3.recycle();
    }

    private final void initView() {
        WeekSportDetailBean weekSportDetailBean = this.f16786a;
        if (weekSportDetailBean != null) {
            if (weekSportDetailBean.f16839c >= weekSportDetailBean.f16838b) {
                this.f16787b = true;
            }
            int i10 = weekSportDetailBean.f16842f - 1;
            if (this.f16787b) {
                H().f31509d.setBackgroundColor(this.f16790e[i10]);
                H().f31507b.setImageResource(R.drawable.bg_get_medal_detail);
                H().f31510e.setImageResource(this.f16789d[i10]);
            } else {
                H().f31509d.setBackgroundColor(getResources().getColor(R.color.device_page_bg));
                H().f31507b.setImageResource(R.drawable.bg_unget_medal_detail);
                H().f31510e.setImageResource(this.f16788c[i10]);
            }
            H().f31511f.setText(weekSportDetailBean.f16837a);
            H().f31512g.setText(getString(R.string.medal_detail_week, new Object[]{Integer.valueOf(weekSportDetailBean.f16842f)}));
            H().f31513h.setText(getString(R.string.medal_detail_sport_time, new Object[]{Integer.valueOf(ph.a.a(weekSportDetailBean.f16839c))}));
            H().f31508c.setText(this.f16787b ? R.string.medal_detail_get : R.string.medal_detail_unget);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(H().a());
        setTitle(R.string.medal_detail);
        I();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "medalDetail");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "medalDetail");
    }
}
