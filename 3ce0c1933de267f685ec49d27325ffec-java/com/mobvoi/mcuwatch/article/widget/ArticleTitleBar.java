package com.mobvoi.mcuwatch.article.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.d;
import io.m;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.k;
/* compiled from: ArticleTitleBar.kt */
/* loaded from: classes2.dex */
public final class ArticleTitleBar extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final d f19092a;

    /* renamed from: b  reason: collision with root package name */
    private int f19093b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f19094c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f19095d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19096e;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f19097f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<b> f19098g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f19099h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19100i = true;

    /* compiled from: ArticleTitleBar.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ArticleTitleBar.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void e();

        void f();
    }

    /* compiled from: ArticleTitleBar.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<ArticleTitleBar> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final ArticleTitleBar invoke() {
            return ArticleTitleBar.this;
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArticleTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d a10;
        i.f(context, "context");
        a10 = io.f.a(new c());
        this.f19092a = a10;
        e(context);
    }

    private final int a(float f10) {
        return aa.d.b(f10, getContext());
    }

    private final void b(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundResource(getCloseIconDrawable());
        m mVar = m.f28349a;
        this.f19094c = imageView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(20.0f), a(20.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(this.f19094c, layoutParams);
        frameLayout.setOnClickListener(getInstance());
        frameLayout.setOnTouchListener(getInstance());
        frameLayout.setTag("closeTag");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(a(20.0f), a(10.0f), a(20.0f), a(12.0f));
        layoutParams2.gravity = 83;
        addView(frameLayout, layoutParams2);
    }

    private final void c(Context context, int i10) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#E5E5E5"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a(0.5f));
        layoutParams.gravity = 80;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setPadding(0, i10, 0, 0);
        frameLayout.setBackgroundColor(Color.parseColor("#FBFBFB"));
        frameLayout.setAlpha(0.0f);
        frameLayout.addView(view, layoutParams);
        m mVar = m.f28349a;
        this.f19097f = frameLayout;
        this.f19093b = a(58.0f) + i10 + a(1.0f);
        addView(this.f19097f, new FrameLayout.LayoutParams(-1, this.f19093b));
    }

    private final void d(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundResource(getSaveIconDrawable());
        m mVar = m.f28349a;
        this.f19095d = imageView;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(a(17.0f), a(17.0f));
        marginLayoutParams.rightMargin = a(4.0f);
        TextView textView = new TextView(context);
        textView.setText(k.f34850p2);
        textView.setTextSize(15.0f);
        textView.setTextColor(getColor());
        textView.setGravity(16);
        this.f19096e = textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.addView(this.f19095d, marginLayoutParams);
        linearLayout.addView(this.f19096e, layoutParams);
        linearLayout.setOnClickListener(getInstance());
        linearLayout.setOnTouchListener(getInstance());
        linearLayout.setTag("saveTag");
        this.f19099h = linearLayout;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(a(20.0f), a(10.0f), a(20.0f), a(10.0f));
        layoutParams2.gravity = 85;
        addView(this.f19099h, layoutParams2);
    }

    private final void e(Context context) {
        c(context, aa.d.c(context));
        b(context);
        d(context);
    }

    private final int getCloseIconDrawable() {
        return this.f19100i ? sh.f.f34586t : sh.f.f34589u;
    }

    private final int getColor() {
        int i10;
        Resources resources;
        if (this.f19100i) {
            resources = getResources();
            i10 = sh.d.f34444b0;
        } else {
            resources = getResources();
            i10 = sh.d.f34445e;
        }
        return resources.getColor(i10);
    }

    private final ArticleTitleBar getInstance() {
        return (ArticleTitleBar) this.f19092a.getValue();
    }

    private final int getSaveIconDrawable() {
        return this.f19100i ? sh.f.f34560k0 : sh.f.f34557j0;
    }

    @TargetApi(19)
    private final void setTranslucent(Activity activity) {
        activity.getWindow().setFlags(67108864, 67108864);
    }

    public final void f(float f10) {
        FrameLayout frameLayout = this.f19097f;
        i.d(frameLayout);
        frameLayout.setAlpha(f10);
        if (f10 <= 0.5d) {
            ImageView imageView = this.f19095d;
            i.d(imageView);
            imageView.setBackgroundResource(getSaveIconDrawable());
            TextView textView = this.f19096e;
            i.d(textView);
            textView.setTextColor(getColor());
            LinearLayout linearLayout = this.f19099h;
            i.d(linearLayout);
            float f11 = 1 - (f10 * 2);
            linearLayout.setAlpha(Math.abs(f11));
            ImageView imageView2 = this.f19094c;
            i.d(imageView2);
            imageView2.setBackgroundResource(getCloseIconDrawable());
            ImageView imageView3 = this.f19094c;
            i.d(imageView3);
            imageView3.setAlpha(Math.abs(f11));
            return;
        }
        ImageView imageView4 = this.f19095d;
        i.d(imageView4);
        imageView4.setBackgroundResource(sh.f.f34557j0);
        TextView textView2 = this.f19096e;
        i.d(textView2);
        textView2.setTextColor(getResources().getColor(sh.d.f34445e));
        LinearLayout linearLayout2 = this.f19099h;
        i.d(linearLayout2);
        float f12 = (f10 * 2) - 1;
        linearLayout2.setAlpha(Math.abs(f12));
        ImageView imageView5 = this.f19094c;
        i.d(imageView5);
        imageView5.setBackgroundResource(sh.f.f34589u);
        ImageView imageView6 = this.f19094c;
        i.d(imageView6);
        imageView6.setAlpha(Math.abs(f12));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        WeakReference<b> weakReference = this.f19098g;
        i.d(weakReference);
        b bVar = weakReference.get();
        if (bVar == null) {
            return;
        }
        if (i.b(v10.getTag(), "closeTag")) {
            bVar.f();
        } else if (i.b(v10.getTag(), "saveTag")) {
            bVar.e();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(getMeasuredWidth(), this.f19093b);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v10, MotionEvent event) {
        i.f(v10, "v");
        i.f(event, "event");
        if (event.getAction() == 0) {
            v10.setAlpha(0.7f);
            return false;
        } else if (event.getAction() != 1) {
            return false;
        } else {
            v10.setAlpha(1.0f);
            return false;
        }
    }

    public final void setIsWhiteColor(boolean z10) {
        this.f19100i = z10;
        ImageView imageView = this.f19094c;
        if (imageView != null) {
            imageView.setBackgroundResource(getCloseIconDrawable());
        }
        ImageView imageView2 = this.f19095d;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(getSaveIconDrawable());
        }
        TextView textView = this.f19096e;
        if (textView != null) {
            textView.setTextColor(getColor());
        }
    }

    public final void setOnTabBarClickListener(b tabBarClickListener) {
        i.f(tabBarClickListener, "tabBarClickListener");
        this.f19098g = new WeakReference<>(tabBarClickListener);
    }

    public final void setTranslucentStatus(Activity activity) {
        i.f(activity, "activity");
        setTranslucent(activity);
    }
}
