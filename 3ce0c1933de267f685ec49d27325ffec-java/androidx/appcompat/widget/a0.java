package androidx.appcompat.widget;

import a0.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.d0;
import d.j;
import java.lang.ref.WeakReference;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1071a;

    /* renamed from: b  reason: collision with root package name */
    private v0 f1072b;

    /* renamed from: c  reason: collision with root package name */
    private v0 f1073c;

    /* renamed from: d  reason: collision with root package name */
    private v0 f1074d;

    /* renamed from: e  reason: collision with root package name */
    private v0 f1075e;

    /* renamed from: f  reason: collision with root package name */
    private v0 f1076f;

    /* renamed from: g  reason: collision with root package name */
    private v0 f1077g;

    /* renamed from: h  reason: collision with root package name */
    private v0 f1078h;

    /* renamed from: i  reason: collision with root package name */
    private final c0 f1079i;

    /* renamed from: j  reason: collision with root package name */
    private int f1080j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1081k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1082l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1083m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class a extends h.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1085b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f1086c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f1084a = i10;
            this.f1085b = i11;
            this.f1086c = weakReference;
        }

        @Override // a0.h.d
        public void d(int i10) {
        }

        @Override // a0.h.d
        public void e(Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1084a) != -1) {
                typeface = Typeface.create(typeface, i10, (this.f1085b & 2) != 0);
            }
            a0.this.n(this.f1086c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f1088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f1089b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1090c;

        b(a0 a0Var, TextView textView, Typeface typeface, int i10) {
            this.f1088a = textView;
            this.f1089b = typeface;
            this.f1090c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1088a.setTypeface(this.f1089b, this.f1090c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(TextView textView) {
        this.f1071a = textView;
        this.f1079i = new c0(textView);
    }

    private void B(int i10, float f10) {
        this.f1079i.y(i10, f10);
    }

    private void C(Context context, x0 x0Var) {
        String o10;
        this.f1080j = x0Var.k(j.Y2, this.f1080j);
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = false;
        if (i10 >= 28) {
            int k10 = x0Var.k(j.f24873d3, -1);
            this.f1081k = k10;
            if (k10 != -1) {
                this.f1080j = (this.f1080j & 2) | 0;
            }
        }
        int i11 = j.f24868c3;
        if (x0Var.s(i11) || x0Var.s(j.f24878e3)) {
            this.f1082l = null;
            int i12 = j.f24878e3;
            if (x0Var.s(i12)) {
                i11 = i12;
            }
            int i13 = this.f1081k;
            int i14 = this.f1080j;
            if (!context.isRestricted()) {
                try {
                    Typeface j10 = x0Var.j(i11, this.f1080j, new a(i13, i14, new WeakReference(this.f1071a)));
                    if (j10 != null) {
                        if (i10 < 28 || this.f1081k == -1) {
                            this.f1082l = j10;
                        } else {
                            this.f1082l = Typeface.create(Typeface.create(j10, 0), this.f1081k, (this.f1080j & 2) != 0);
                        }
                    }
                    this.f1083m = this.f1082l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1082l == null && (o10 = x0Var.o(i11)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1081k == -1) {
                    this.f1082l = Typeface.create(o10, this.f1080j);
                    return;
                }
                Typeface create = Typeface.create(o10, 0);
                int i15 = this.f1081k;
                if ((this.f1080j & 2) != 0) {
                    z10 = true;
                }
                this.f1082l = Typeface.create(create, i15, z10);
                return;
            }
            return;
        }
        int i16 = j.X2;
        if (x0Var.s(i16)) {
            this.f1083m = false;
            int k11 = x0Var.k(i16, 1);
            if (k11 == 1) {
                this.f1082l = Typeface.SANS_SERIF;
            } else if (k11 == 2) {
                this.f1082l = Typeface.SERIF;
            } else if (k11 == 3) {
                this.f1082l = Typeface.MONOSPACE;
            }
        }
    }

    private void a(Drawable drawable, v0 v0Var) {
        if (drawable != null && v0Var != null) {
            j.i(drawable, v0Var, this.f1071a.getDrawableState());
        }
    }

    private static v0 d(Context context, j jVar, int i10) {
        ColorStateList f10 = jVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.f1358d = true;
        v0Var.f1355a = f10;
        return v0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1071a.getCompoundDrawablesRelative();
            TextView textView = this.f1071a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (i10 >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1071a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1071a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1071a.getCompoundDrawables();
            TextView textView3 = this.f1071a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void z() {
        v0 v0Var = this.f1078h;
        this.f1072b = v0Var;
        this.f1073c = v0Var;
        this.f1074d = v0Var;
        this.f1075e = v0Var;
        this.f1076f = v0Var;
        this.f1077g = v0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (!androidx.core.widget.b.X && !l()) {
            B(i10, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1072b == null && this.f1073c == null && this.f1074d == null && this.f1075e == null)) {
            Drawable[] compoundDrawables = this.f1071a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1072b);
            a(compoundDrawables[1], this.f1073c);
            a(compoundDrawables[2], this.f1074d);
            a(compoundDrawables[3], this.f1075e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1076f != null || this.f1077g != null) {
            Drawable[] compoundDrawablesRelative = this.f1071a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f1076f);
            a(compoundDrawablesRelative[2], this.f1077g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1079i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1079i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1079i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1079i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1079i.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1079i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        v0 v0Var = this.f1078h;
        if (v0Var != null) {
            return v0Var.f1355a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        v0 v0Var = this.f1078h;
        if (v0Var != null) {
            return v0Var.f1356b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1079i.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c5 A[ADDED_TO_REGION] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AttributeSet attributeSet, int i10) {
        boolean z10;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z11;
        String str;
        ColorStateList colorStateList3;
        String str2;
        String str3;
        int i11;
        int i12;
        String str4;
        j jVar;
        Typeface typeface;
        x0 u10;
        int i13;
        int i14;
        int i15;
        int f10;
        int f11;
        int f12;
        int[] m10;
        Context context = this.f1071a.getContext();
        j b10 = j.b();
        int[] iArr = j.V;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        TextView textView = this.f1071a;
        d0.r0(textView, textView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        int n10 = v10.n(j.W, -1);
        int i16 = j.Z;
        if (v10.s(i16)) {
            this.f1072b = d(context, b10, v10.n(i16, 0));
        }
        int i17 = j.X;
        if (v10.s(i17)) {
            this.f1073c = d(context, b10, v10.n(i17, 0));
        }
        int i18 = j.f24855a0;
        if (v10.s(i18)) {
            this.f1074d = d(context, b10, v10.n(i18, 0));
        }
        int i19 = j.Y;
        if (v10.s(i19)) {
            this.f1075e = d(context, b10, v10.n(i19, 0));
        }
        int i20 = Build.VERSION.SDK_INT;
        if (i20 >= 17) {
            int i21 = j.f24860b0;
            if (v10.s(i21)) {
                this.f1076f = d(context, b10, v10.n(i21, 0));
            }
            int i22 = j.f24865c0;
            if (v10.s(i22)) {
                this.f1077g = d(context, b10, v10.n(i22, 0));
            }
        }
        v10.w();
        boolean z12 = this.f1071a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n10 != -1) {
            x0 t10 = x0.t(context, n10, j.V2);
            if (!z12) {
                int i23 = j.f24888g3;
                if (t10.s(i23)) {
                    z11 = t10.a(i23, false);
                    z10 = true;
                    C(context, t10);
                    if (i20 >= 23) {
                        int i24 = j.Z2;
                        colorStateList3 = t10.s(i24) ? t10.c(i24) : null;
                        int i25 = j.f24858a3;
                        colorStateList2 = t10.s(i25) ? t10.c(i25) : null;
                        int i26 = j.f24863b3;
                        if (t10.s(i26)) {
                            colorStateList = t10.c(i26);
                            int i27 = j.f24893h3;
                            str = t10.s(i27) ? t10.o(i27) : null;
                            if (i20 >= 26) {
                                int i28 = j.f24883f3;
                                if (t10.s(i28)) {
                                    str2 = t10.o(i28);
                                    t10.w();
                                }
                            }
                            str2 = null;
                            t10.w();
                        }
                    } else {
                        colorStateList3 = null;
                        colorStateList2 = null;
                    }
                    colorStateList = null;
                    int i272 = j.f24893h3;
                    if (t10.s(i272)) {
                    }
                    if (i20 >= 26) {
                    }
                    str2 = null;
                    t10.w();
                }
            }
            z11 = false;
            z10 = false;
            C(context, t10);
            if (i20 >= 23) {
            }
            colorStateList = null;
            int i2722 = j.f24893h3;
            if (t10.s(i2722)) {
            }
            if (i20 >= 26) {
            }
            str2 = null;
            t10.w();
        } else {
            z11 = false;
            z10 = false;
            str2 = null;
            colorStateList3 = null;
            str = null;
            colorStateList2 = null;
            colorStateList = null;
        }
        x0 v11 = x0.v(context, attributeSet, j.V2, i10, 0);
        if (!z12) {
            int i29 = j.f24888g3;
            if (v11.s(i29)) {
                str3 = str2;
                z11 = v11.a(i29, false);
                i11 = 23;
                z10 = true;
                if (i20 < i11) {
                    int i30 = j.Z2;
                    if (v11.s(i30)) {
                        colorStateList3 = v11.c(i30);
                    }
                    int i31 = j.f24858a3;
                    if (v11.s(i31)) {
                        colorStateList2 = v11.c(i31);
                    }
                    int i32 = j.f24863b3;
                    if (v11.s(i32)) {
                        colorStateList = v11.c(i32);
                    }
                }
                i12 = j.f24893h3;
                if (v11.s(i12)) {
                    str = v11.o(i12);
                }
                if (i20 >= 26) {
                    int i33 = j.f24883f3;
                    if (v11.s(i33)) {
                        str4 = v11.o(i33);
                        if (i20 >= 28) {
                            int i34 = j.W2;
                            if (v11.s(i34)) {
                                jVar = b10;
                                if (v11.f(i34, -1) == 0) {
                                    this.f1071a.setTextSize(0, 0.0f);
                                }
                                C(context, v11);
                                v11.w();
                                if (colorStateList3 != null) {
                                    this.f1071a.setTextColor(colorStateList3);
                                }
                                if (colorStateList2 != null) {
                                    this.f1071a.setHintTextColor(colorStateList2);
                                }
                                if (colorStateList != null) {
                                    this.f1071a.setLinkTextColor(colorStateList);
                                }
                                if (!z12 && z10) {
                                    s(z11);
                                }
                                typeface = this.f1082l;
                                if (typeface != null) {
                                    if (this.f1081k == -1) {
                                        this.f1071a.setTypeface(typeface, this.f1080j);
                                    } else {
                                        this.f1071a.setTypeface(typeface);
                                    }
                                }
                                if (str4 != null) {
                                    this.f1071a.setFontVariationSettings(str4);
                                }
                                if (str != null) {
                                    if (i20 >= 24) {
                                        this.f1071a.setTextLocales(LocaleList.forLanguageTags(str));
                                    } else if (i20 >= 21) {
                                        this.f1071a.setTextLocale(Locale.forLanguageTag(str.substring(0, str.indexOf(44))));
                                    }
                                }
                                this.f1079i.t(attributeSet, i10);
                                if (androidx.core.widget.b.X && this.f1079i.n() != 0) {
                                    m10 = this.f1079i.m();
                                    if (m10.length > 0) {
                                        if (this.f1071a.getAutoSizeStepGranularity() != -1.0f) {
                                            this.f1071a.setAutoSizeTextTypeUniformWithConfiguration(this.f1079i.k(), this.f1079i.j(), this.f1079i.l(), 0);
                                        } else {
                                            this.f1071a.setAutoSizeTextTypeUniformWithPresetSizes(m10, 0);
                                        }
                                    }
                                }
                                u10 = x0.u(context, attributeSet, j.f24870d0);
                                int n11 = u10.n(j.f24910l0, -1);
                                j jVar2 = jVar;
                                Drawable c10 = n11 == -1 ? jVar2.c(context, n11) : null;
                                int n12 = u10.n(j.f24935q0, -1);
                                Drawable c11 = n12 == -1 ? jVar2.c(context, n12) : null;
                                int n13 = u10.n(j.f24915m0, -1);
                                Drawable c12 = n13 == -1 ? jVar2.c(context, n13) : null;
                                int n14 = u10.n(j.f24900j0, -1);
                                Drawable c13 = n14 == -1 ? jVar2.c(context, n14) : null;
                                int n15 = u10.n(j.f24920n0, -1);
                                Drawable c14 = n15 == -1 ? jVar2.c(context, n15) : null;
                                int n16 = u10.n(j.f24905k0, -1);
                                y(c10, c11, c12, c13, c14, n16 == -1 ? jVar2.c(context, n16) : null);
                                i13 = j.f24925o0;
                                if (u10.s(i13)) {
                                    androidx.core.widget.j.j(this.f1071a, u10.c(i13));
                                }
                                i14 = j.f24930p0;
                                if (!u10.s(i14)) {
                                    i15 = -1;
                                    androidx.core.widget.j.k(this.f1071a, g0.e(u10.k(i14, -1), null));
                                } else {
                                    i15 = -1;
                                }
                                f10 = u10.f(j.f24945s0, i15);
                                f11 = u10.f(j.f24950t0, i15);
                                f12 = u10.f(j.f24955u0, i15);
                                u10.w();
                                if (f10 != i15) {
                                    androidx.core.widget.j.m(this.f1071a, f10);
                                }
                                if (f11 != i15) {
                                    androidx.core.widget.j.n(this.f1071a, f11);
                                }
                                if (f12 == i15) {
                                    androidx.core.widget.j.o(this.f1071a, f12);
                                    return;
                                }
                                return;
                            }
                        }
                        jVar = b10;
                        C(context, v11);
                        v11.w();
                        if (colorStateList3 != null) {
                        }
                        if (colorStateList2 != null) {
                        }
                        if (colorStateList != null) {
                        }
                        if (!z12) {
                            s(z11);
                        }
                        typeface = this.f1082l;
                        if (typeface != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str != null) {
                        }
                        this.f1079i.t(attributeSet, i10);
                        if (androidx.core.widget.b.X) {
                            m10 = this.f1079i.m();
                            if (m10.length > 0) {
                            }
                        }
                        u10 = x0.u(context, attributeSet, j.f24870d0);
                        int n112 = u10.n(j.f24910l0, -1);
                        j jVar22 = jVar;
                        if (n112 == -1) {
                        }
                        int n122 = u10.n(j.f24935q0, -1);
                        if (n122 == -1) {
                        }
                        int n132 = u10.n(j.f24915m0, -1);
                        if (n132 == -1) {
                        }
                        int n142 = u10.n(j.f24900j0, -1);
                        if (n142 == -1) {
                        }
                        int n152 = u10.n(j.f24920n0, -1);
                        if (n152 == -1) {
                        }
                        int n162 = u10.n(j.f24905k0, -1);
                        y(c10, c11, c12, c13, c14, n162 == -1 ? jVar22.c(context, n162) : null);
                        i13 = j.f24925o0;
                        if (u10.s(i13)) {
                        }
                        i14 = j.f24930p0;
                        if (!u10.s(i14)) {
                        }
                        f10 = u10.f(j.f24945s0, i15);
                        f11 = u10.f(j.f24950t0, i15);
                        f12 = u10.f(j.f24955u0, i15);
                        u10.w();
                        if (f10 != i15) {
                        }
                        if (f11 != i15) {
                        }
                        if (f12 == i15) {
                        }
                    }
                }
                str4 = str3;
                if (i20 >= 28) {
                }
                jVar = b10;
                C(context, v11);
                v11.w();
                if (colorStateList3 != null) {
                }
                if (colorStateList2 != null) {
                }
                if (colorStateList != null) {
                }
                if (!z12) {
                }
                typeface = this.f1082l;
                if (typeface != null) {
                }
                if (str4 != null) {
                }
                if (str != null) {
                }
                this.f1079i.t(attributeSet, i10);
                if (androidx.core.widget.b.X) {
                }
                u10 = x0.u(context, attributeSet, j.f24870d0);
                int n1122 = u10.n(j.f24910l0, -1);
                j jVar222 = jVar;
                if (n1122 == -1) {
                }
                int n1222 = u10.n(j.f24935q0, -1);
                if (n1222 == -1) {
                }
                int n1322 = u10.n(j.f24915m0, -1);
                if (n1322 == -1) {
                }
                int n1422 = u10.n(j.f24900j0, -1);
                if (n1422 == -1) {
                }
                int n1522 = u10.n(j.f24920n0, -1);
                if (n1522 == -1) {
                }
                int n1622 = u10.n(j.f24905k0, -1);
                y(c10, c11, c12, c13, c14, n1622 == -1 ? jVar222.c(context, n1622) : null);
                i13 = j.f24925o0;
                if (u10.s(i13)) {
                }
                i14 = j.f24930p0;
                if (!u10.s(i14)) {
                }
                f10 = u10.f(j.f24945s0, i15);
                f11 = u10.f(j.f24950t0, i15);
                f12 = u10.f(j.f24955u0, i15);
                u10.w();
                if (f10 != i15) {
                }
                if (f11 != i15) {
                }
                if (f12 == i15) {
                }
            }
        }
        str3 = str2;
        i11 = 23;
        if (i20 < i11) {
        }
        i12 = j.f24893h3;
        if (v11.s(i12)) {
        }
        if (i20 >= 26) {
        }
        str4 = str3;
        if (i20 >= 28) {
        }
        jVar = b10;
        C(context, v11);
        v11.w();
        if (colorStateList3 != null) {
        }
        if (colorStateList2 != null) {
        }
        if (colorStateList != null) {
        }
        if (!z12) {
        }
        typeface = this.f1082l;
        if (typeface != null) {
        }
        if (str4 != null) {
        }
        if (str != null) {
        }
        this.f1079i.t(attributeSet, i10);
        if (androidx.core.widget.b.X) {
        }
        u10 = x0.u(context, attributeSet, j.f24870d0);
        int n11222 = u10.n(j.f24910l0, -1);
        j jVar2222 = jVar;
        if (n11222 == -1) {
        }
        int n12222 = u10.n(j.f24935q0, -1);
        if (n12222 == -1) {
        }
        int n13222 = u10.n(j.f24915m0, -1);
        if (n13222 == -1) {
        }
        int n14222 = u10.n(j.f24900j0, -1);
        if (n14222 == -1) {
        }
        int n15222 = u10.n(j.f24920n0, -1);
        if (n15222 == -1) {
        }
        int n16222 = u10.n(j.f24905k0, -1);
        y(c10, c11, c12, c13, c14, n16222 == -1 ? jVar2222.c(context, n16222) : null);
        i13 = j.f24925o0;
        if (u10.s(i13)) {
        }
        i14 = j.f24930p0;
        if (!u10.s(i14)) {
        }
        f10 = u10.f(j.f24945s0, i15);
        f11 = u10.f(j.f24950t0, i15);
        f12 = u10.f(j.f24955u0, i15);
        u10.w();
        if (f10 != i15) {
        }
        if (f11 != i15) {
        }
        if (f12 == i15) {
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1083m) {
            this.f1082l = typeface;
            TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (d0.W(textView)) {
                textView.post(new b(this, textView, typeface, this.f1080j));
            } else {
                textView.setTypeface(typeface, this.f1080j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!androidx.core.widget.b.X) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String o10;
        ColorStateList c10;
        ColorStateList c11;
        ColorStateList c12;
        x0 t10 = x0.t(context, i10, j.V2);
        int i11 = j.f24888g3;
        if (t10.s(i11)) {
            s(t10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = j.Z2;
            if (t10.s(i13) && (c12 = t10.c(i13)) != null) {
                this.f1071a.setTextColor(c12);
            }
            int i14 = j.f24863b3;
            if (t10.s(i14) && (c11 = t10.c(i14)) != null) {
                this.f1071a.setLinkTextColor(c11);
            }
            int i15 = j.f24858a3;
            if (t10.s(i15) && (c10 = t10.c(i15)) != null) {
                this.f1071a.setHintTextColor(c10);
            }
        }
        int i16 = j.W2;
        if (t10.s(i16) && t10.f(i16, -1) == 0) {
            this.f1071a.setTextSize(0, 0.0f);
        }
        C(context, t10);
        if (i12 >= 26) {
            int i17 = j.f24883f3;
            if (t10.s(i17) && (o10 = t10.o(i17)) != null) {
                this.f1071a.setFontVariationSettings(o10);
            }
        }
        t10.w();
        Typeface typeface = this.f1082l;
        if (typeface != null) {
            this.f1071a.setTypeface(typeface, this.f1080j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            m0.a.f(editorInfo, textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f1071a.setAllCaps(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        this.f1079i.u(i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int[] iArr, int i10) throws IllegalArgumentException {
        this.f1079i.v(iArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i10) {
        this.f1079i.w(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f1078h == null) {
            this.f1078h = new v0();
        }
        v0 v0Var = this.f1078h;
        v0Var.f1355a = colorStateList;
        v0Var.f1358d = colorStateList != null;
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f1078h == null) {
            this.f1078h = new v0();
        }
        v0 v0Var = this.f1078h;
        v0Var.f1356b = mode;
        v0Var.f1357c = mode != null;
        z();
    }
}
