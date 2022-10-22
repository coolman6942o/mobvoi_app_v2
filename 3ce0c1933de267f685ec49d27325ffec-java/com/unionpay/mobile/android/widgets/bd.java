package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.u;
import java.math.BigDecimal;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bd extends aa implements u.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24376c = bd.class.getSimpleName();

    /* renamed from: o  reason: collision with root package name */
    private String f24377o;

    /* renamed from: p  reason: collision with root package name */
    private String f24378p;

    /* renamed from: q  reason: collision with root package name */
    private String f24379q;

    /* renamed from: r  reason: collision with root package name */
    private String f24380r;

    /* renamed from: s  reason: collision with root package name */
    private String f24381s;

    /* loaded from: classes2.dex */
    public class a implements InputFilter {

        /* renamed from: b  reason: collision with root package name */
        private u f24383b;

        /* renamed from: c  reason: collision with root package name */
        private BigDecimal f24384c;

        /* renamed from: d  reason: collision with root package name */
        private BigDecimal f24385d;

        public a(u uVar, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            this.f24383b = null;
            this.f24384c = null;
            this.f24385d = null;
            this.f24383b = uVar;
            this.f24384c = bigDecimal;
            this.f24385d = bigDecimal2;
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                c(this.f24384c.toString());
            }
        }

        private static int a(String str) {
            if (str == null || !b(str)) {
                return 0;
            }
            return (str.length() - str.indexOf(".")) - 1;
        }

        private CharSequence a(String str, boolean z10, boolean z11) {
            String bigDecimal = this.f24385d.toString();
            String bigDecimal2 = this.f24384c.toString();
            try {
                BigDecimal bigDecimal3 = new BigDecimal(str);
                bigDecimal3.setScale(2, 6);
                if (z10 && z11 && bigDecimal3.compareTo(this.f24384c) == -1) {
                    c(bigDecimal2);
                }
                if (bigDecimal3.compareTo(this.f24385d) != 1) {
                    return null;
                }
                c(bigDecimal);
                return null;
            } catch (Exception unused) {
                return "";
            }
        }

        private static boolean b(String str) {
            return str != null && str.contains(".");
        }

        private void c(String str) {
            this.f24383b.c(str);
            Selection.setSelection(this.f24383b.c(), this.f24383b.b().length());
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            boolean z10 = true;
            boolean z11 = false;
            if (charSequence == null || !charSequence.equals("")) {
                int i14 = i11 - i10;
                boolean b10 = b(spanned.toString());
                if (1 != i14) {
                    boolean b11 = b(charSequence.toString());
                    if (b11 && b10) {
                        return "";
                    }
                    if (b11 && (a(charSequence.toString()) > 2 || spanned.toString().length() != i13)) {
                        return "";
                    }
                } else if (!b10 && spanned.length() == 1 && spanned.charAt(0) == '0') {
                    return ".";
                } else {
                    if ('0' == charSequence.charAt(0) && i12 == 0 && i13 == 0 && spanned.length() != 0) {
                        return "";
                    }
                    if ('.' == charSequence.charAt(0)) {
                        if (spanned.length() == 0) {
                            return "";
                        }
                        if (spanned.length() != 0 && spanned.length() - i12 > 2) {
                            return "";
                        }
                    }
                    if (b10 && i12 > spanned.toString().indexOf(".") && a(spanned.toString()) > 2 - i14) {
                        return "";
                    }
                }
                String str = spanned.subSequence(0, i12).toString() + charSequence.subSequence(i10, i11).toString() + ((Object) spanned.subSequence(i13, spanned.length()));
                if (a(str) != 2) {
                    z10 = false;
                }
                return a(str, false, z10);
            }
            String str2 = spanned.subSequence(0, i12).toString() + charSequence.subSequence(i10, i11).toString() + ((Object) spanned.subSequence(i13, spanned.length()));
            if (i13 - i12 != 1) {
                z11 = true;
            }
            return a(str2, true, z11);
        }
    }

    public bd(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        this.f24377o = null;
        this.f24378p = null;
        this.f24379q = null;
        this.f24380r = null;
        this.f24381s = null;
        this.f24380r = j.a(jSONObject, "point");
        this.f24379q = j.a(jSONObject, "max_use_point");
        this.f24378p = j.a(jSONObject, "min_use_point");
        this.f24381s = j.a(jSONObject, "ratio");
        this.f24377o = j.a(jSONObject, "ordr_amnt");
        ((aa) this).f24277b.a(8194);
        ((aa) this).f24277b.a(DigitsKeyListener.getInstance("0123456789."));
        try {
            bigDecimal = new BigDecimal(this.f24378p);
        } catch (Exception unused) {
            bigDecimal = BigDecimal.ZERO;
        }
        BigDecimal scale = bigDecimal.setScale(2, 6);
        try {
            bigDecimal2 = new BigDecimal(this.f24379q);
        } catch (Exception unused2) {
            bigDecimal2 = new BigDecimal(3.4028234663852886E38d);
        }
        BigDecimal scale2 = bigDecimal2.setScale(2, 6);
        u uVar = ((aa) this).f24277b;
        uVar.a(new a(uVar, scale, scale2));
        a((String) null, (String) null);
        if (q() == null || q().length() == 0) {
            u();
            c(String.format(c.bD.ay, this.f24380r, this.f24381s));
        }
        ((aa) this).f24277b.a(this);
    }

    private void a(String str, String str2) {
        SpannableString spannableString;
        if (p() == null || p().length() == 0) {
            t();
            if (str == null) {
                String format = String.format(c.bD.aw, this.f24379q);
                spannableString = new SpannableString(format);
                spannableString.setSpan(new ForegroundColorSpan(-15958150), 0, format.length(), 0);
            } else {
                String format2 = String.format(c.bD.aw + str, this.f24379q, str2);
                SpannableString spannableString2 = new SpannableString(format2);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-15958150);
                int length = format2.length();
                spannableString2.setSpan(foregroundColorSpan, 0, length - (str2 + "元").length(), 0);
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-44462);
                int length2 = format2.length();
                spannableString2.setSpan(foregroundColorSpan2, length2 - (str2 + "元").length(), format2.length(), 0);
                spannableString = spannableString2;
            }
            v();
            a(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        String a10 = super.a();
        if (!(a10 == null || a10.length() == 0)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(a10);
                bigDecimal.setScale(2, 6);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    return bigDecimal.toString();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.widgets.aa
    public final void a(Editable editable) {
        super.a(editable);
        if (p() == null || p().length() == 0) {
            try {
                a(c.bD.ax, new BigDecimal(this.f24377o).setScale(2, 6).subtract(new BigDecimal(a()).setScale(2, 6).multiply(new BigDecimal(this.f24381s).setScale(2, 6)).setScale(2, 6)).toString());
            } catch (Exception unused) {
                a((String) null, (String) null);
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.u.a
    public final void a(boolean z10) {
        if (z10) {
            a(this.f24355l);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.z
    public final String h() {
        String a10 = a();
        if (a10 == null || a10.length() == 0) {
            return null;
        }
        return super.h();
    }
}
