package com.mobvoi.mcuwatch.ui.search.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import nj.q;
import sh.k;
import sh.m;
import zh.v;
/* compiled from: SearchBlankPage.kt */
/* loaded from: classes2.dex */
public final class SearchBlankPage extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public v f19997a;

    /* renamed from: b  reason: collision with root package name */
    private int f19998b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f19999c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f20000d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchBlankPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public /* synthetic */ SearchBlankPage(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void a(int i10) {
        int i11 = k.E4;
        int i12 = k.F4;
        int[] iArr = this.f19999c;
        int m10 = q.g().m();
        if (m10 == 5) {
            iArr = this.f20000d;
        }
        int i13 = iArr[0];
        boolean z10 = true;
        String str = "gth_pair.json";
        if (i10 == 1) {
            i11 = k.C4;
            i12 = k.D4;
            i13 = iArr[i10];
            str = "gth_pair_start.json";
        } else if (i10 == 2) {
            i11 = k.f34904z4;
            i12 = k.A4;
            i13 = iArr[i10];
            str = "";
        } else if (i10 == 3) {
            i11 = k.f34837m4;
            i12 = k.f34842n4;
            i13 = iArr[i10];
            str = "gth_pair_search.json";
        } else if (i10 == 4) {
            i11 = k.f34857q4;
            i12 = k.f34862r4;
            i13 = iArr[i10];
            str = "gth_pair_success.json";
        } else if (i10 == 5) {
            i11 = k.f34847o4;
            i12 = k.f34852p4;
            i13 = iArr[i10];
        }
        getBinding().f37609e.setText(getContext().getText(i11));
        getBinding().f37608d.setText(getContext().getText(i12));
        if (m10 == 2 || m10 == 3) {
            if (str.length() != 0) {
                z10 = false;
            }
            if (z10) {
                getBinding().f37607c.setVisibility(8);
                getBinding().f37606b.setVisibility(0);
                getBinding().f37606b.setImageResource(sh.f.f34601y);
                return;
            }
            getBinding().f37606b.setVisibility(8);
            getBinding().f37607c.setVisibility(0);
            LottieAnimationView lottieAnimationView = getBinding().f37607c;
            lottieAnimationView.setImageAssetsFolder("images");
            lottieAnimationView.setAnimation(str);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.o();
            return;
        }
        getBinding().f37606b.setVisibility(0);
        getBinding().f37606b.setImageResource(i13);
    }

    public static /* synthetic */ void getMode$annotations() {
    }

    public final int[] getApolloSearchIconArray() {
        return this.f20000d;
    }

    public final v getBinding() {
        v vVar = this.f19997a;
        if (vVar != null) {
            return vVar;
        }
        i.u("binding");
        throw null;
    }

    public final int getMode() {
        return this.f19998b;
    }

    public final void setApolloSearchIconArray(int[] iArr) {
        i.f(iArr, "<set-?>");
        this.f20000d = iArr;
    }

    public final void setBinding(v vVar) {
        i.f(vVar, "<set-?>");
        this.f19997a = vVar;
    }

    public final void setMode(int i10) {
        this.f19998b = i10;
        a(i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBlankPage(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f19999c = new int[]{sh.f.C, sh.f.K, sh.f.D, sh.f.f34604z, sh.f.B, sh.f.A};
        this.f20000d = new int[]{sh.f.f34593v0, sh.f.f34599x0, sh.f.f34596w0, sh.f.f34584s0, sh.f.f34590u0, sh.f.f34587t0};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f34921o);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.SearchBlankPage)");
        int integer = obtainStyledAttributes.getInteger(m.f34922p, 0);
        obtainStyledAttributes.recycle();
        v d10 = v.d(LayoutInflater.from(context), this, true);
        i.e(d10, "inflate(LayoutInflater.from(context),this,true)");
        setBinding(d10);
        setMode(integer);
    }
}
