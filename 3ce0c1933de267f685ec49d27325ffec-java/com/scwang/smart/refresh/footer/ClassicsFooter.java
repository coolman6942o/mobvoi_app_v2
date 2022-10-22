package com.scwang.smart.refresh.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import pm.b;
import qm.d;
import sm.c;
import sm.f;
/* loaded from: classes2.dex */
public class ClassicsFooter extends b<ClassicsFooter> implements c {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;

    /* renamed from: y  reason: collision with root package name */
    public static String f22304y;

    /* renamed from: z  reason: collision with root package name */
    public static String f22305z;

    /* renamed from: q  reason: collision with root package name */
    protected String f22306q;

    /* renamed from: r  reason: collision with root package name */
    protected String f22307r;

    /* renamed from: s  reason: collision with root package name */
    protected String f22308s;

    /* renamed from: t  reason: collision with root package name */
    protected String f22309t;

    /* renamed from: u  reason: collision with root package name */
    protected String f22310u;

    /* renamed from: v  reason: collision with root package name */
    protected String f22311v;

    /* renamed from: w  reason: collision with root package name */
    protected String f22312w;

    /* renamed from: x  reason: collision with root package name */
    protected boolean f22313x = false;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22314a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f22314a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22314a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22314a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22314a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22314a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22314a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        View.inflate(context, qm.b.f33255a, this);
        ImageView imageView = (ImageView) findViewById(qm.a.f33252a);
        this.f32881e = imageView;
        ImageView imageView2 = (ImageView) findViewById(qm.a.f33253b);
        this.f32882f = imageView2;
        this.f32880d = (TextView) findViewById(qm.a.f33254c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f33263a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.f33268f, xm.b.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i10 = d.f33267e;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i10, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i10, layoutParams.height);
        int i11 = d.f33270h;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i11, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i11, layoutParams2.height);
        int i12 = d.f33271i;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i12, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i12, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i12, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i12, layoutParams2.height);
        this.f32889m = obtainStyledAttributes.getInt(d.f33272j, this.f32889m);
        this.f36331b = tm.b.f35229i[obtainStyledAttributes.getInt(d.f33265c, this.f36331b.f35230a)];
        int i13 = d.f33266d;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.f32881e.setImageDrawable(obtainStyledAttributes.getDrawable(i13));
        } else if (this.f32881e.getDrawable() == null) {
            pm.a aVar = new pm.a();
            this.f32884h = aVar;
            aVar.a(-10066330);
            this.f32881e.setImageDrawable(this.f32884h);
        }
        int i14 = d.f33269g;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.f32882f.setImageDrawable(obtainStyledAttributes.getDrawable(i14));
        } else if (this.f32882f.getDrawable() == null) {
            om.b bVar = new om.b();
            this.f32885i = bVar;
            bVar.a(-10066330);
            this.f32882f.setImageDrawable(this.f32885i);
        }
        int i15 = d.f33281s;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.f32880d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i15, xm.b.c(16.0f)));
        }
        int i16 = d.f33273k;
        if (obtainStyledAttributes.hasValue(i16)) {
            super.t(obtainStyledAttributes.getColor(i16, 0));
        }
        int i17 = d.f33264b;
        if (obtainStyledAttributes.hasValue(i17)) {
            super.s(obtainStyledAttributes.getColor(i17, 0));
        }
        int i18 = d.f33278p;
        if (obtainStyledAttributes.hasValue(i18)) {
            this.f22306q = obtainStyledAttributes.getString(i18);
        } else {
            String str = f22304y;
            if (str != null) {
                this.f22306q = str;
            } else {
                this.f22306q = context.getString(qm.c.f33260e);
            }
        }
        int i19 = d.f33280r;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.f22307r = obtainStyledAttributes.getString(i19);
        } else {
            String str2 = f22305z;
            if (str2 != null) {
                this.f22307r = str2;
            } else {
                this.f22307r = context.getString(qm.c.f33262g);
            }
        }
        int i20 = d.f33276n;
        if (obtainStyledAttributes.hasValue(i20)) {
            this.f22308s = obtainStyledAttributes.getString(i20);
        } else {
            String str3 = A;
            if (str3 != null) {
                this.f22308s = str3;
            } else {
                this.f22308s = context.getString(qm.c.f33258c);
            }
        }
        int i21 = d.f33279q;
        if (obtainStyledAttributes.hasValue(i21)) {
            this.f22309t = obtainStyledAttributes.getString(i21);
        } else {
            String str4 = B;
            if (str4 != null) {
                this.f22309t = str4;
            } else {
                this.f22309t = context.getString(qm.c.f33261f);
            }
        }
        int i22 = d.f33275m;
        if (obtainStyledAttributes.hasValue(i22)) {
            this.f22310u = obtainStyledAttributes.getString(i22);
        } else {
            String str5 = C;
            if (str5 != null) {
                this.f22310u = str5;
            } else {
                this.f22310u = context.getString(qm.c.f33257b);
            }
        }
        int i23 = d.f33274l;
        if (obtainStyledAttributes.hasValue(i23)) {
            this.f22311v = obtainStyledAttributes.getString(i23);
        } else {
            String str6 = D;
            if (str6 != null) {
                this.f22311v = str6;
            } else {
                this.f22311v = context.getString(qm.c.f33256a);
            }
        }
        int i24 = d.f33277o;
        if (obtainStyledAttributes.hasValue(i24)) {
            this.f22312w = obtainStyledAttributes.getString(i24);
        } else {
            String str7 = E;
            if (str7 != null) {
                this.f22312w = str7;
            } else {
                this.f22312w = context.getString(qm.c.f33259d);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.f32880d.setText(isInEditMode() ? this.f22308s : this.f22306q);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // wm.b, sm.c
    public boolean c(boolean z10) {
        if (this.f22313x == z10) {
            return true;
        }
        this.f22313x = z10;
        ImageView imageView = this.f32881e;
        if (z10) {
            this.f32880d.setText(this.f22312w);
            imageView.setVisibility(8);
            return true;
        }
        this.f32880d.setText(this.f22306q);
        imageView.setVisibility(0);
        return true;
    }

    @Override // pm.b, wm.b, sm.a
    public int h(f fVar, boolean z10) {
        super.h(fVar, z10);
        if (this.f22313x) {
            return 0;
        }
        this.f32880d.setText(z10 ? this.f22310u : this.f22311v);
        return this.f32889m;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // wm.b, vm.h
    public void q(f fVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.f32881e;
        if (!this.f22313x) {
            switch (a.f22314a[refreshState2.ordinal()]) {
                case 1:
                    imageView.setVisibility(0);
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                    imageView.setVisibility(8);
                    this.f32880d.setText(this.f22308s);
                    return;
                case 5:
                    this.f32880d.setText(this.f22307r);
                    imageView.animate().rotation(0.0f);
                    return;
                case 6:
                    this.f32880d.setText(this.f22309t);
                    imageView.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.f32880d.setText(this.f22306q);
            imageView.animate().rotation(180.0f);
        }
    }

    @Override // pm.b, wm.b, sm.a
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f36331b == tm.b.f35226f) {
            super.setPrimaryColors(iArr);
        }
    }
}
