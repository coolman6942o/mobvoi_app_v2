package com.scwang.smart.refresh.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import pm.b;
import rm.c;
import sm.d;
/* loaded from: classes2.dex */
public class ClassicsHeader extends b<ClassicsHeader> implements d {
    public static String E = null;
    public static String F = null;
    public static String G = null;
    public static String H = null;
    public static String I = null;
    public static String J = null;
    public static String K = null;
    public static String L = null;
    protected String A;
    protected String B;
    protected String C;
    protected String D;

    /* renamed from: q  reason: collision with root package name */
    protected String f22315q = "LAST_UPDATE_TIME";

    /* renamed from: r  reason: collision with root package name */
    protected Date f22316r;

    /* renamed from: s  reason: collision with root package name */
    protected TextView f22317s;

    /* renamed from: t  reason: collision with root package name */
    protected SharedPreferences f22318t;

    /* renamed from: u  reason: collision with root package name */
    protected DateFormat f22319u;

    /* renamed from: v  reason: collision with root package name */
    protected boolean f22320v;

    /* renamed from: w  reason: collision with root package name */
    protected String f22321w;

    /* renamed from: x  reason: collision with root package name */
    protected String f22322x;

    /* renamed from: y  reason: collision with root package name */
    protected String f22323y;

    /* renamed from: z  reason: collision with root package name */
    protected String f22324z;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22325a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f22325a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22325a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22325a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22325a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22325a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22325a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22325a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i10;
        int i11;
        FragmentManager supportFragmentManager;
        this.f22320v = true;
        View.inflate(context, rm.b.f33612a, this);
        ImageView imageView = (ImageView) findViewById(rm.a.f33608a);
        this.f32881e = imageView;
        TextView textView = (TextView) findViewById(rm.a.f33611d);
        this.f22317s = textView;
        ImageView imageView2 = (ImageView) findViewById(rm.a.f33609b);
        this.f32882f = imageView2;
        this.f32880d = (TextView) findViewById(rm.a.f33610c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rm.d.f33621a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = obtainStyledAttributes.getDimensionPixelSize(rm.d.f33642v, xm.b.c(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(rm.d.f33626f, xm.b.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i12 = rm.d.f33625e;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i12, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i12, layoutParams.height);
        int i13 = rm.d.f33628h;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i13, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i13, layoutParams2.height);
        int i14 = rm.d.f33629i;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams2.height);
        this.f32889m = obtainStyledAttributes.getInt(rm.d.f33631k, this.f32889m);
        this.f22320v = obtainStyledAttributes.getBoolean(rm.d.f33630j, this.f22320v);
        this.f36331b = tm.b.f35229i[obtainStyledAttributes.getInt(rm.d.f33623c, this.f36331b.f35230a)];
        int i15 = rm.d.f33624d;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.f32881e.setImageDrawable(obtainStyledAttributes.getDrawable(i15));
        } else if (this.f32881e.getDrawable() == null) {
            pm.a aVar = new pm.a();
            this.f32884h = aVar;
            aVar.a(-10066330);
            this.f32881e.setImageDrawable(this.f32884h);
        }
        int i16 = rm.d.f33627g;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.f32882f.setImageDrawable(obtainStyledAttributes.getDrawable(i16));
        } else if (this.f32882f.getDrawable() == null) {
            om.b bVar = new om.b();
            this.f32885i = bVar;
            bVar.a(-10066330);
            this.f32882f.setImageDrawable(this.f32885i);
        }
        if (obtainStyledAttributes.hasValue(rm.d.f33641u)) {
            this.f32880d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i10, xm.b.c(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(rm.d.f33640t)) {
            this.f22317s.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i11, xm.b.c(12.0f)));
        }
        int i17 = rm.d.f33632l;
        if (obtainStyledAttributes.hasValue(i17)) {
            super.t(obtainStyledAttributes.getColor(i17, 0));
        }
        int i18 = rm.d.f33622b;
        if (obtainStyledAttributes.hasValue(i18)) {
            s(obtainStyledAttributes.getColor(i18, 0));
        }
        int i19 = rm.d.f33636p;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.f22321w = obtainStyledAttributes.getString(i19);
        } else {
            String str = E;
            if (str != null) {
                this.f22321w = str;
            } else {
                this.f22321w = context.getString(c.f33616d);
            }
        }
        int i20 = rm.d.f33635o;
        if (obtainStyledAttributes.hasValue(i20)) {
            this.f22323y = obtainStyledAttributes.getString(i20);
        } else {
            String str2 = G;
            if (str2 != null) {
                this.f22323y = str2;
            } else {
                this.f22323y = context.getString(c.f33615c);
            }
        }
        int i21 = rm.d.f33638r;
        if (obtainStyledAttributes.hasValue(i21)) {
            this.f22324z = obtainStyledAttributes.getString(i21);
        } else {
            String str3 = H;
            if (str3 != null) {
                this.f22324z = str3;
            } else {
                this.f22324z = context.getString(c.f33618f);
            }
        }
        int i22 = rm.d.f33634n;
        if (obtainStyledAttributes.hasValue(i22)) {
            this.A = obtainStyledAttributes.getString(i22);
        } else {
            String str4 = I;
            if (str4 != null) {
                this.A = str4;
            } else {
                this.A = context.getString(c.f33614b);
            }
        }
        int i23 = rm.d.f33633m;
        if (obtainStyledAttributes.hasValue(i23)) {
            this.B = obtainStyledAttributes.getString(i23);
        } else {
            String str5 = J;
            if (str5 != null) {
                this.B = str5;
            } else {
                this.B = context.getString(c.f33613a);
            }
        }
        int i24 = rm.d.f33639s;
        if (obtainStyledAttributes.hasValue(i24)) {
            this.D = obtainStyledAttributes.getString(i24);
        } else {
            String str6 = L;
            if (str6 != null) {
                this.D = str6;
            } else {
                this.D = context.getString(c.f33619g);
            }
        }
        int i25 = rm.d.f33637q;
        if (obtainStyledAttributes.hasValue(i25)) {
            this.f22322x = obtainStyledAttributes.getString(i25);
        } else {
            String str7 = F;
            if (str7 != null) {
                this.f22322x = str7;
            } else {
                this.f22322x = context.getString(c.f33617e);
            }
        }
        int i26 = rm.d.f33643w;
        if (obtainStyledAttributes.hasValue(i26)) {
            this.C = obtainStyledAttributes.getString(i26);
        } else {
            String str8 = K;
            if (str8 != null) {
                this.C = str8;
            } else {
                this.C = context.getString(c.f33620h);
            }
        }
        this.f22319u = new SimpleDateFormat(this.C, Locale.getDefault());
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.f22320v ? 0 : 8);
        this.f32880d.setText(isInEditMode() ? this.f22322x : this.f22321w);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof f) && (supportFragmentManager = ((f) context).getSupportFragmentManager()) != null && supportFragmentManager.t0().size() > 0) {
                v(new Date());
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f22315q += context.getClass().getName();
        this.f22318t = context.getSharedPreferences("ClassicsHeader", 0);
        v(new Date(this.f22318t.getLong(this.f22315q, System.currentTimeMillis())));
    }

    @Override // pm.b, wm.b, sm.a
    public int h(sm.f fVar, boolean z10) {
        if (z10) {
            this.f32880d.setText(this.A);
            if (this.f22316r != null) {
                v(new Date());
            }
        } else {
            this.f32880d.setText(this.B);
        }
        return super.h(fVar, z10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // wm.b, vm.h
    public void q(sm.f fVar, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.f32881e;
        TextView textView = this.f22317s;
        int i10 = 8;
        switch (a.f22325a[refreshState2.ordinal()]) {
            case 1:
                if (this.f22320v) {
                    i10 = 0;
                }
                textView.setVisibility(i10);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f32880d.setText(this.f22322x);
                imageView.setVisibility(8);
                return;
            case 5:
                this.f32880d.setText(this.f22324z);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.f32880d.setText(this.D);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                if (this.f22320v) {
                    i10 = 4;
                }
                textView.setVisibility(i10);
                this.f32880d.setText(this.f22323y);
                return;
            default:
                return;
        }
        this.f32880d.setText(this.f22321w);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    /* renamed from: u */
    public ClassicsHeader s(int i10) {
        this.f22317s.setTextColor((16777215 & i10) | (-872415232));
        return (ClassicsHeader) super.s(i10);
    }

    public ClassicsHeader v(Date date) {
        this.f22316r = date;
        this.f22317s.setText(this.f22319u.format(date));
        if (this.f22318t != null && !isInEditMode()) {
            this.f22318t.edit().putLong(this.f22315q, date.getTime()).apply();
        }
        return this;
    }
}
