package com.mobvoi.companion.base.ui.view.numberpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.k;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class NumberPicker extends LinearLayout {

    /* renamed from: p0  reason: collision with root package name */
    private static final j f16575p0 = new j();

    /* renamed from: q0  reason: collision with root package name */
    private static final char[] f16576q0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};
    private int A;
    private int B;
    private int C;
    private int D;
    private final com.mobvoi.companion.base.ui.view.numberpicker.a E;
    private final com.mobvoi.companion.base.ui.view.numberpicker.a F;
    private int G;
    private h H;
    private c I;
    private float J;
    private long K;
    private float L;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private final int R;
    private final boolean S;
    private Drawable T;
    private final int U;
    private int V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private int f16577a;

    /* renamed from: b  reason: collision with root package name */
    private int f16578b;

    /* renamed from: c  reason: collision with root package name */
    private int f16579c;

    /* renamed from: d  reason: collision with root package name */
    private int f16580d;

    /* renamed from: e  reason: collision with root package name */
    private int f16581e;

    /* renamed from: f  reason: collision with root package name */
    private DisplayMetrics f16582f;

    /* renamed from: g  reason: collision with root package name */
    private final EditText f16583g;

    /* renamed from: h  reason: collision with root package name */
    private final int f16584h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16585i;

    /* renamed from: j  reason: collision with root package name */
    private final int f16586j;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f16587j0;

    /* renamed from: k  reason: collision with root package name */
    private final int f16588k;

    /* renamed from: k0  reason: collision with root package name */
    private int f16589k0;

    /* renamed from: l  reason: collision with root package name */
    private int f16590l;

    /* renamed from: l0  reason: collision with root package name */
    private int f16591l0;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f16592m;

    /* renamed from: m0  reason: collision with root package name */
    private int f16593m0;

    /* renamed from: n  reason: collision with root package name */
    private int f16594n;

    /* renamed from: n0  reason: collision with root package name */
    private i f16595n0;

    /* renamed from: o  reason: collision with root package name */
    private int f16596o;

    /* renamed from: o0  reason: collision with root package name */
    private int f16597o0;

    /* renamed from: p  reason: collision with root package name */
    private String[] f16598p;

    /* renamed from: q  reason: collision with root package name */
    private int f16599q;

    /* renamed from: r  reason: collision with root package name */
    private int f16600r;

    /* renamed from: s  reason: collision with root package name */
    private int f16601s;

    /* renamed from: t  reason: collision with root package name */
    private g f16602t;

    /* renamed from: u  reason: collision with root package name */
    private f f16603u;

    /* renamed from: v  reason: collision with root package name */
    private d f16604v;

    /* renamed from: w  reason: collision with root package name */
    private final SparseArray<String> f16605w;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f16606x;

    /* renamed from: y  reason: collision with root package name */
    private final Paint f16607y;

    /* renamed from: z  reason: collision with root package name */
    private final Paint f16608z;

    /* loaded from: classes2.dex */
    public static class CustomEditText extends k {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.TextView
        public void onEditorAction(int i10) {
            super.onEditorAction(i10);
            if (i10 == 6) {
                clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f16609a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f16610b = new int[2];

        /* renamed from: c  reason: collision with root package name */
        private int f16611c = Integer.MIN_VALUE;

        b() {
        }

        private AccessibilityNodeInfo a(int i10, int i11, int i12, int i13) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(NumberPicker.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this);
            if (g()) {
                obtain.addChild(NumberPicker.this, 3);
            }
            obtain.addChild(NumberPicker.this, 2);
            if (h()) {
                obtain.addChild(NumberPicker.this, 1);
            }
            obtain.setParent((View) NumberPicker.this.getParentForAccessibility());
            obtain.setEnabled(NumberPicker.this.isEnabled());
            obtain.setScrollable(true);
            if (this.f16611c != -1) {
                obtain.addAction(64);
            }
            if (this.f16611c == -1) {
                obtain.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                    obtain.addAction(8192);
                }
            }
            return obtain;
        }

        private AccessibilityNodeInfo b(int i10, String str, int i11, int i12, int i13, int i14) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this, i10);
            obtain.setParent(NumberPicker.this);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(NumberPicker.this.isEnabled());
            Rect rect = this.f16609a;
            rect.set(i11, i12, i13, i14);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.f16610b;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.f16611c != i10) {
                obtain.addAction(64);
            }
            if (this.f16611c == i10) {
                obtain.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        private AccessibilityNodeInfo c() {
            AccessibilityNodeInfo createAccessibilityNodeInfo = NumberPicker.this.f16583g.createAccessibilityNodeInfo();
            createAccessibilityNodeInfo.setSource(NumberPicker.this, 2);
            if (this.f16611c != 2) {
                createAccessibilityNodeInfo.addAction(64);
            }
            if (this.f16611c == 2) {
                createAccessibilityNodeInfo.addAction(128);
            }
            return createAccessibilityNodeInfo;
        }

        private void d(String str, int i10, List<AccessibilityNodeInfo> list) {
            if (i10 == 1) {
                String f10 = f();
                if (!TextUtils.isEmpty(f10) && f10.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(1));
                }
            } else if (i10 == 2) {
                Editable text = NumberPicker.this.f16583g.getText();
                if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
                    Editable text2 = NumberPicker.this.f16583g.getText();
                    if (!TextUtils.isEmpty(text2) && text2.toString().toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(2));
                        return;
                    }
                    return;
                }
                list.add(createAccessibilityNodeInfo(2));
            } else if (i10 == 3) {
                String e10 = e();
                if (!TextUtils.isEmpty(e10) && e10.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(3));
                }
            }
        }

        private String e() {
            int i10 = NumberPicker.this.f16601s - 1;
            if (NumberPicker.this.Q) {
                i10 = NumberPicker.this.D(i10);
            }
            if (i10 >= NumberPicker.this.f16599q) {
                return NumberPicker.this.f16598p == null ? NumberPicker.this.v(i10) : NumberPicker.this.f16598p[i10 - NumberPicker.this.f16599q];
            }
            return null;
        }

        private String f() {
            int i10 = NumberPicker.this.f16601s + 1;
            if (NumberPicker.this.Q) {
                i10 = NumberPicker.this.D(i10);
            }
            if (i10 <= NumberPicker.this.f16600r) {
                return NumberPicker.this.f16598p == null ? NumberPicker.this.v(i10) : NumberPicker.this.f16598p[i10 - NumberPicker.this.f16599q];
            }
            return null;
        }

        private boolean g() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue();
        }

        private boolean h() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue();
        }

        private void i(int i10, int i11, String str) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(NumberPicker.this.isEnabled());
                obtain.setSource(NumberPicker.this, i10);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        private void j(int i10) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
                NumberPicker.this.f16583g.onInitializeAccessibilityEvent(obtain);
                NumberPicker.this.f16583g.onPopulateAccessibilityEvent(obtain);
                obtain.setSource(NumberPicker.this, 2);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            if (i10 == -1) {
                return a(NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
            }
            if (i10 == 1) {
                return b(1, f(), NumberPicker.this.getScrollX(), NumberPicker.this.f16591l0 - NumberPicker.this.U, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
            }
            if (i10 == 2) {
                return c();
            }
            if (i10 != 3) {
                return super.createAccessibilityNodeInfo(i10);
            }
            return b(3, e(), NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.f16589k0 + NumberPicker.this.U);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (i10 == -1) {
                d(lowerCase, 3, arrayList);
                d(lowerCase, 2, arrayList);
                d(lowerCase, 1, arrayList);
                return arrayList;
            } else if (i10 != 1 && i10 != 2 && i10 != 3) {
                return super.findAccessibilityNodeInfosByText(str, i10);
            } else {
                d(lowerCase, i10, arrayList);
                return arrayList;
            }
        }

        public void k(int i10, int i11) {
            if (i10 != 1) {
                if (i10 == 2) {
                    j(i11);
                } else if (i10 == 3 && g()) {
                    i(i10, i11, e());
                }
            } else if (h()) {
                i(i10, i11, f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.U();
            NumberPicker.this.W = true;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        String format(int i10);
    }

    /* loaded from: classes2.dex */
    class e extends NumberKeyListener {
        e() {
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            String valueOf;
            String[] strArr;
            if (NumberPicker.this.f16598p == null) {
                CharSequence filter = super.filter(charSequence, i10, i11, spanned, i12, i13);
                if (filter == null) {
                    filter = charSequence.subSequence(i10, i11);
                }
                String str = String.valueOf(spanned.subSequence(0, i12)) + ((Object) filter) + ((Object) spanned.subSequence(i13, spanned.length()));
                return "".equals(str) ? str : NumberPicker.this.B(str) > NumberPicker.this.f16600r ? "" : filter;
            }
            if (TextUtils.isEmpty(String.valueOf(charSequence.subSequence(i10, i11)))) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i12)) + ((Object) valueOf) + ((Object) spanned.subSequence(i13, spanned.length()));
            String lowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : NumberPicker.this.f16598p) {
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    NumberPicker.this.O(str2.length(), str3.length());
                    return str3.subSequence(i12, str3.length());
                }
            }
            return "";
        }

        @Override // android.text.method.NumberKeyListener
        protected char[] getAcceptedChars() {
            return NumberPicker.f16576q0;
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(NumberPicker numberPicker, int i10);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(NumberPicker numberPicker, int i10, int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f16615a;

        /* renamed from: b  reason: collision with root package name */
        private int f16616b;

        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.f16583g.setSelection(this.f16615a, this.f16616b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        b f16618a;

        public boolean a(int i10, int i11, Bundle bundle) {
            b bVar = this.f16618a;
            if (bVar != null) {
                return bVar.performAction(i10, i11, bundle);
            }
            return false;
        }

        public void b(int i10, int i11) {
            b bVar = this.f16618a;
            if (bVar != null) {
                bVar.k(i10, i11);
            }
        }

        private i(NumberPicker numberPicker) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f16618a = new b();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class j implements d {

        /* renamed from: b  reason: collision with root package name */
        char f16620b;

        /* renamed from: c  reason: collision with root package name */
        Formatter f16621c;

        /* renamed from: a  reason: collision with root package name */
        final StringBuilder f16619a = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        final Object[] f16622d = new Object[1];

        j() {
            c(Locale.getDefault());
        }

        private Formatter a(Locale locale) {
            return new Formatter(this.f16619a, locale);
        }

        private static char b(Locale locale) {
            return new DecimalFormatSymbols(locale).getZeroDigit();
        }

        private void c(Locale locale) {
            this.f16621c = a(locale);
            this.f16620b = b(locale);
        }

        @Override // com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker.d
        public String format(int i10) {
            Locale locale = Locale.getDefault();
            if (this.f16620b != b(locale)) {
                c(locale);
            }
            this.f16622d[0] = Integer.valueOf(i10);
            StringBuilder sb2 = this.f16619a;
            sb2.delete(0, sb2.length());
            this.f16621c.format("%02d", this.f16622d);
            return this.f16621c.toString();
        }
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, gc.a.f27327c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B(String str) {
        try {
            if (this.f16598p == null) {
                return Integer.parseInt(str);
            }
            for (int i10 = 0; i10 < this.f16598p.length; i10++) {
                str = str.toLowerCase();
                if (this.f16598p[i10].toLowerCase().startsWith(str)) {
                    return this.f16599q + i10;
                }
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return this.f16599q;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(int i10) {
        int i11 = this.f16600r;
        if (i10 > i11) {
            int i12 = this.f16599q;
            return (i12 + ((i10 - i11) % (i11 - i12))) - 1;
        }
        int i13 = this.f16599q;
        return i10 < i13 ? (i11 - ((i13 - i10) % (i11 - i13))) + 1 : i10;
    }

    private void E(int[] iArr) {
        int i10 = 0;
        while (i10 < iArr.length - 1) {
            int i11 = i10 + 1;
            iArr[i10] = iArr[i11];
            i10 = i11;
        }
        int i12 = iArr[iArr.length - 2] + 1;
        if (this.Q && i12 > this.f16600r) {
            i12 = this.f16599q;
        }
        iArr[iArr.length - 1] = i12;
        s(i12);
    }

    private void F() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - (this.f16594n / 2)) / 2);
    }

    private void G() {
        H();
        int[] iArr = this.f16606x;
        int bottom = (int) (((getBottom() - getTop()) - (((iArr.length - 1) * this.f16594n) + this.f16581e)) / (iArr.length + 2.0f));
        this.f16596o = bottom;
        this.f16578b = bottom;
        int i10 = (bottom * 3) / 2;
        this.f16577a = i10;
        int i11 = this.f16594n;
        int i12 = i11 + bottom;
        this.A = i12;
        this.f16579c = i12;
        int i13 = this.f16581e + i10;
        this.B = i13;
        this.f16580d = i13;
        int i14 = bottom + i11;
        this.C = i14;
        this.D = i14;
        W();
    }

    private void H() {
        this.f16605w.clear();
        int[] iArr = this.f16606x;
        int value = getValue();
        for (int i10 = 0; i10 < this.f16606x.length; i10++) {
            int i11 = (i10 - 2) + value;
            if (this.Q) {
                i11 = D(i11);
            }
            iArr[i10] = i11;
            s(iArr[i10]);
        }
    }

    private int I(int i10, int i11) {
        if (i11 == -1) {
            return i10;
        }
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        if (mode == 1073741824) {
            return i10;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    private boolean J(com.mobvoi.companion.base.ui.view.numberpicker.a aVar) {
        aVar.d(true);
        int g10 = aVar.g() - aVar.f();
        int i10 = this.C - ((this.D + g10) % this.B);
        if (i10 == 0) {
            return false;
        }
        int abs = Math.abs(i10);
        int i11 = this.B;
        if (abs > i11 / 2) {
            i10 = i10 > 0 ? i10 - i11 : i10 + i11;
        }
        scrollBy(0, g10 + i10);
        return true;
    }

    private void K(int i10, int i11) {
        g gVar = this.f16602t;
        if (gVar != null) {
            gVar.a(this, i10, this.f16601s);
        }
    }

    private void L(int i10) {
        if (this.V != i10) {
            this.V = i10;
            f fVar = this.f16603u;
            if (fVar != null) {
                fVar.a(this, i10);
            }
        }
    }

    private void M(com.mobvoi.companion.base.ui.view.numberpicker.a aVar) {
        if (aVar == this.E) {
            if (!t()) {
                W();
            }
            L(0);
        } else if (this.V != 1) {
            W();
        }
    }

    private void N() {
        c cVar = this.I;
        if (cVar == null) {
            this.I = new c();
        } else {
            removeCallbacks(cVar);
        }
        postDelayed(this.I, ViewConfiguration.getLongPressTimeout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i10, int i11) {
        h hVar = this.H;
        if (hVar == null) {
            this.H = new h();
        } else {
            removeCallbacks(hVar);
        }
        this.H.f16615a = i10;
        this.H.f16616b = i11;
        post(this.H);
    }

    private void P() {
        h hVar = this.H;
        if (hVar != null) {
            removeCallbacks(hVar);
        }
        c cVar = this.I;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
    }

    private void Q() {
        c cVar = this.I;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
    }

    private void R() {
    }

    private int S(int i10, int i11, int i12) {
        return i10 != -1 ? resolveSizeAndState(Math.max(i10, i11), i12, 0) : i11;
    }

    private void T(int i10, boolean z10) {
        int i11;
        if (this.f16601s != i10) {
            if (this.Q) {
                i11 = D(i10);
            } else {
                i11 = Math.min(Math.max(i10, this.f16599q), this.f16600r);
            }
            int i12 = this.f16601s;
            this.f16601s = i11;
            W();
            if (z10) {
                K(i12, i11);
            }
            H();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            if (this.S) {
                this.f16583g.setVisibility(0);
            }
            this.f16583g.requestFocus();
            inputMethodManager.showSoftInput(this.f16583g, 0);
        }
    }

    private void V() {
        int i10;
        if (this.f16592m) {
            String[] strArr = this.f16598p;
            int i11 = 0;
            if (strArr == null) {
                float f10 = 0.0f;
                for (int i12 = 0; i12 <= 9; i12++) {
                    float measureText = this.f16607y.measureText(w(i12));
                    if (measureText > f10) {
                        f10 = measureText;
                    }
                }
                for (int i13 = this.f16600r; i13 > 0; i13 /= 10) {
                    i11++;
                }
                i10 = (int) (i11 * f10);
            } else {
                int length = strArr.length;
                int i14 = 0;
                while (i11 < length) {
                    float measureText2 = this.f16607y.measureText(this.f16598p[i11]);
                    if (measureText2 > i14) {
                        i14 = (int) measureText2;
                    }
                    i11++;
                }
                i10 = i14;
            }
            int paddingLeft = i10 + this.f16583g.getPaddingLeft() + this.f16583g.getPaddingRight();
            if (this.f16590l != paddingLeft) {
                int i15 = this.f16588k;
                if (paddingLeft > i15) {
                    this.f16590l = paddingLeft;
                } else {
                    this.f16590l = i15;
                }
                invalidate();
            }
        }
    }

    private boolean W() {
        String[] strArr = this.f16598p;
        String v10 = strArr == null ? v(this.f16601s) : strArr[this.f16601s - this.f16599q];
        if (TextUtils.isEmpty(v10) || v10.equals(this.f16583g.getText().toString())) {
            return false;
        }
        this.f16583g.setText((CharSequence) null);
        return true;
    }

    private i getSupportAccessibilityNodeProvider() {
        return new i();
    }

    public static final d getTwoDigitFormatter() {
        return f16575p0;
    }

    private void q(boolean z10) {
        if (this.S) {
            this.f16583g.setVisibility(4);
            this.f16583g.clearFocus();
            if (!J(this.E)) {
                J(this.F);
            }
            this.G = 0;
            if (z10) {
                this.E.j(0, 0, 0, -this.B, 300);
            } else {
                this.E.j(0, 0, 0, this.B, 300);
            }
            invalidate();
        } else if (z10) {
            T(this.f16601s + 1, true);
        } else {
            T(this.f16601s - 1, true);
        }
    }

    private void r(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i10 = iArr[1] - 1;
        if (this.Q && i10 < this.f16599q) {
            i10 = this.f16600r;
        }
        iArr[0] = i10;
        s(i10);
    }

    public static int resolveSizeAndState(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i10 = size;
            }
        } else if (size < i10) {
            i10 = 16777216 | size;
        }
        return i10 | ((-16777216) & i12);
    }

    private void s(int i10) {
        String str;
        SparseArray<String> sparseArray = this.f16605w;
        if (sparseArray.get(i10) == null) {
            int i11 = this.f16599q;
            if (i10 < i11 || i10 > this.f16600r) {
                str = "";
            } else {
                String[] strArr = this.f16598p;
                if (strArr != null) {
                    str = strArr[i10 - i11];
                } else {
                    str = v(i10);
                }
            }
            sparseArray.put(i10, str);
        }
    }

    private boolean t() {
        int i10 = this.C - this.D;
        if (i10 == 0) {
            return false;
        }
        this.G = 0;
        int abs = Math.abs(i10);
        int i11 = this.B;
        if (abs > i11 / 2) {
            if (i10 > 0) {
                i11 = -i11;
            }
            i10 += i11;
        }
        this.F.j(0, 0, 0, i10, 800);
        invalidate();
        return true;
    }

    private void u(int i10) {
        this.G = 0;
        if (i10 > 0) {
            this.E.c(0, 0, 0, i10, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.E.c(0, Integer.MAX_VALUE, 0, i10, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v(int i10) {
        d dVar = this.f16604v;
        return dVar != null ? dVar.format(i10) : w(i10);
    }

    private static String w(int i10) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
    }

    public float A(int i10) {
        int i11 = (this.f16580d - this.f16581e) + this.f16594n;
        int i12 = this.f16579c;
        return (float) ((((i11 - i12) / 2) * Math.cos((i10 * 3.141592653589793d) / i11)) + ((i11 + i12) / 2));
    }

    public int C(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842906, typedValue, true);
        return typedValue.data;
    }

    @Override // android.view.View
    public void computeScroll() {
        com.mobvoi.companion.base.ui.view.numberpicker.a aVar = this.E;
        if (aVar.i()) {
            aVar = this.F;
            if (aVar.i()) {
                return;
            }
        }
        aVar.b();
        int f10 = aVar.f();
        if (this.G == 0) {
            this.G = aVar.h();
        }
        scrollBy(0, f10 - this.G);
        this.G = f10;
        if (aVar.i()) {
            M(aVar);
        } else {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i10;
        if (!this.S) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return false;
        }
        int y10 = (int) motionEvent.getY();
        if (y10 < this.f16589k0) {
            i10 = 3;
        } else {
            i10 = y10 > this.f16591l0 ? 1 : 2;
        }
        int action = motionEvent.getAction() & 255;
        i supportAccessibilityNodeProvider = getSupportAccessibilityNodeProvider();
        if (action == 7) {
            int i11 = this.f16593m0;
            if (i11 == i10 || i11 == -1) {
                return false;
            }
            supportAccessibilityNodeProvider.b(i11, 256);
            supportAccessibilityNodeProvider.b(i10, 128);
            this.f16593m0 = i10;
            supportAccessibilityNodeProvider.a(i10, 64, null);
            return false;
        } else if (action == 9) {
            supportAccessibilityNodeProvider.b(i10, 128);
            this.f16593m0 = i10;
            supportAccessibilityNodeProvider.a(i10, 64, null);
            return false;
        } else if (action != 10) {
            return false;
        } else {
            supportAccessibilityNodeProvider.b(i10, 256);
            this.f16593m0 = -1;
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        requestFocus();
        r5.f16597o0 = r0;
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r5.E.i() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        if (r0 != 20) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        q(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        return true;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            if (this.S) {
                int action = keyEvent.getAction();
                if (action != 0) {
                    if (action == 1 && this.f16597o0 == keyCode) {
                        this.f16597o0 = -1;
                        return true;
                    }
                } else if (!this.Q) {
                }
            }
        } else if (keyCode == 23 || keyCode == 66) {
            P();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            P();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            P();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.S) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.f16595n0 == null) {
            this.f16595n0 = new i();
        }
        return this.f16595n0.f16618a;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.f16598p;
    }

    public int getMaxValue() {
        return this.f16600r;
    }

    public int getMinValue() {
        return this.f16599q;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.R;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.f16601s;
    }

    public boolean getWrapSelectorWheel() {
        return this.Q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        P();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        if (!this.S) {
            super.onDraw(canvas);
            return;
        }
        float right = (getRight() - getLeft()) / 2;
        float f10 = this.D;
        int[] iArr = this.f16606x;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            String str = this.f16605w.get(iArr[i11]);
            if (i11 != 2 || this.f16583g.getVisibility() != 0) {
                canvas.drawText(str, right, f10, this.f16607y);
                if (i11 == 1) {
                    i10 = (int) z(this.D - this.C);
                    this.B = i10;
                } else {
                    i10 = this.A;
                }
            } else if (i11 == 2) {
                this.f16608z.setTextSize(y(this.D - this.C));
                canvas.drawText(str, right, f10, this.f16608z);
                i10 = (int) A(this.D - this.C);
                this.B = i10;
            }
            f10 += i10;
        }
        Drawable drawable = this.T;
        if (drawable != null) {
            int i12 = this.f16589k0;
            drawable.setBounds(0, i12, getRight(), this.U + i12);
            this.T.draw(canvas);
            int i13 = this.f16591l0;
            this.T.setBounds(0, i13 - this.U, getRight(), i13);
            this.T.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.f16599q + this.f16601s) * this.B);
        accessibilityEvent.setMaxScrollY((this.f16600r - this.f16599q) * this.B);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.S || !isEnabled() || (motionEvent.getAction() & 255) != 0) {
            return false;
        }
        P();
        float y10 = motionEvent.getY();
        this.J = y10;
        this.L = y10;
        this.K = motionEvent.getEventTime();
        this.W = false;
        this.f16587j0 = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.E.i()) {
            this.E.d(true);
            this.F.d(true);
            L(0);
        } else if (!this.F.i()) {
            this.E.d(true);
            this.F.d(true);
        } else {
            this.f16587j0 = true;
            N();
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (!this.S) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f16583g.getMeasuredWidth();
        int measuredHeight2 = this.f16583g.getMeasuredHeight();
        int i14 = (measuredWidth - measuredWidth2) / 2;
        int i15 = (measuredHeight - measuredHeight2) / 2;
        this.f16583g.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
        if (z10) {
            G();
            F();
            int height = getHeight();
            int i16 = this.f16584h;
            int i17 = this.U;
            int i18 = ((height - i16) / 2) - i17;
            this.f16589k0 = i18;
            this.f16591l0 = i18 + (i17 * 2) + i16;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (!this.S) {
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(I(i10, this.f16590l), I(i11, this.f16586j));
        setMeasuredDimension(S(this.f16588k, getMeasuredWidth(), i10), S(this.f16585i, getMeasuredHeight(), i11));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.S) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            Q();
            R();
            VelocityTracker velocityTracker = this.M;
            velocityTracker.computeCurrentVelocity(1000, this.P);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.O) {
                u(yVelocity);
                L(2);
            } else {
                int abs = (int) Math.abs(((int) motionEvent.getY()) - this.J);
                motionEvent.getEventTime();
                ViewConfiguration.getTapTimeout();
                if (abs > this.N) {
                    t();
                } else if (this.f16587j0) {
                    this.f16587j0 = false;
                    t();
                } else {
                    t();
                }
                L(0);
            }
            this.M.recycle();
            this.M = null;
        } else if (action == 2 && !this.W) {
            float y10 = motionEvent.getY();
            if (this.V == 1) {
                scrollBy(0, (int) (y10 - this.L));
                invalidate();
            } else if (((int) Math.abs(y10 - this.J)) > this.N) {
                P();
                L(1);
            }
            this.L = y10;
        }
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        int[] iArr = this.f16606x;
        boolean z10 = this.Q;
        if (!z10 && i11 > 0 && iArr[2] <= this.f16599q) {
            this.D = this.C;
        } else if (z10 || i11 >= 0 || iArr[2] < this.f16600r) {
            this.D += i11;
            while (true) {
                int i12 = this.D;
                if (i12 - this.C > this.f16577a) {
                    this.D = i12 - this.B;
                    r(iArr);
                    T(iArr[2], true);
                    if (!this.Q && iArr[2] <= this.f16599q) {
                        this.D = this.C;
                    }
                }
            }
            while (true) {
                int i13 = this.D;
                if (i13 - this.C < (-this.f16577a)) {
                    this.D = i13 + this.B;
                    E(iArr);
                    T(iArr[2], true);
                    if (!this.Q && iArr[2] >= this.f16600r) {
                        this.D = this.C;
                    }
                } else {
                    return;
                }
            }
        } else {
            this.D = this.C;
        }
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f16598p != strArr) {
            this.f16598p = strArr;
            if (strArr != null) {
                this.f16583g.setRawInputType(524289);
            } else {
                this.f16583g.setRawInputType(2);
            }
            W();
            H();
            V();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f16583g.setEnabled(z10);
    }

    public void setFormatter(d dVar) {
        if (dVar != this.f16604v) {
            this.f16604v = dVar;
            H();
            W();
        }
    }

    public void setMaxValue(int i10) {
        if (this.f16600r != i10) {
            if (i10 >= 0) {
                this.f16600r = i10;
                if (i10 < this.f16601s) {
                    this.f16601s = i10;
                }
                setWrapSelectorWheel(i10 - this.f16599q > this.f16606x.length);
                H();
                W();
                V();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public void setMinValue(int i10) {
        if (this.f16599q != i10) {
            if (i10 >= 0) {
                this.f16599q = i10;
                if (i10 > this.f16601s) {
                    this.f16601s = i10;
                }
                setWrapSelectorWheel(this.f16600r - i10 > this.f16606x.length);
                H();
                W();
                V();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    public void setOnLongPressUpdateInterval(long j10) {
    }

    public void setOnScrollListener(f fVar) {
        this.f16603u = fVar;
    }

    public void setOnValueChangedListener(g gVar) {
        this.f16602t = gVar;
    }

    public void setPickerDividerColor(int i10) {
        ColorDrawable colorDrawable = new ColorDrawable(i10);
        this.T = colorDrawable;
        colorDrawable.getBounds();
    }

    public void setValue(int i10) {
        T(i10, false);
    }

    public void setWrapSelectorWheel(boolean z10) {
        boolean z11 = this.f16600r - this.f16599q >= this.f16606x.length;
        if ((!z10 || z11) && z10 != this.Q) {
            this.Q = z10;
        }
    }

    public int x(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(gc.a.f27325a, typedValue, true);
        return typedValue.data;
    }

    public float y(int i10) {
        return (float) ((((this.f16581e - this.f16594n) / 2) * Math.cos((i10 * 3.141592653589793d) / this.f16577a)) + ((this.f16581e + this.f16594n) / 2));
    }

    public float z(int i10) {
        int i11 = this.f16580d;
        int i12 = this.f16579c;
        return (float) ((((i11 - i12) / 2) * Math.cos((i10 * 3.141592653589793d) / i11)) + ((i11 + i12) / 2));
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        this.f16581e = 52;
        this.f16594n = 44;
        this.f16605w = new SparseArray<>();
        this.f16606x = new int[5];
        this.C = Integer.MIN_VALUE;
        this.V = 0;
        this.f16597o0 = -1;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f16582f = displayMetrics;
        this.f16581e = (int) ((this.f16581e * displayMetrics.density) / 2.0f);
        Log.d("NumberPicker", "Density == " + this.f16582f.density);
        this.f16594n = (int) ((((float) this.f16594n) * this.f16582f.density) / 2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gc.h.f27374a, i10, 0);
        int resourceId = obtainStyledAttributes.getResourceId(gc.h.f27375b, 0);
        boolean z10 = resourceId != 0;
        this.S = z10;
        this.R = obtainStyledAttributes.getColor(gc.h.f27385l, 0);
        this.T = obtainStyledAttributes.getDrawable(gc.h.f27381h);
        this.U = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27382i, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f16584h = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27383j, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27378e, -1);
        this.f16585i = dimensionPixelSize;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27376c, -1);
        this.f16586j = dimensionPixelSize2;
        if (dimensionPixelSize == -1 || dimensionPixelSize2 == -1 || dimensionPixelSize <= dimensionPixelSize2) {
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27379f, -1);
            this.f16588k = dimensionPixelSize3;
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(gc.h.f27377d, -1);
            this.f16590l = dimensionPixelSize4;
            if (dimensionPixelSize3 == -1 || dimensionPixelSize4 == -1 || dimensionPixelSize3 <= dimensionPixelSize4) {
                this.f16592m = dimensionPixelSize4 == -1;
                obtainStyledAttributes.getDrawable(gc.h.f27386m);
                int color = obtainStyledAttributes.getColor(gc.h.f27384k, C(context));
                int color2 = obtainStyledAttributes.getColor(gc.h.f27380g, x(context));
                obtainStyledAttributes.recycle();
                setWillNotDraw(!z10);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(resourceId, (ViewGroup) this, true);
                EditText editText = (EditText) findViewById(gc.d.f27343n);
                this.f16583g = editText;
                editText.setFocusable(false);
                editText.setFilters(new InputFilter[]{new e()});
                editText.setRawInputType(2);
                editText.setImeOptions(6);
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.N = viewConfiguration.getScaledTouchSlop();
                this.O = viewConfiguration.getScaledMinimumFlingVelocity();
                this.P = viewConfiguration.getScaledMaximumFlingVelocity() / 15;
                Paint paint = new Paint();
                this.f16607y = paint;
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(this.f16594n);
                paint.setTypeface(editText.getTypeface());
                paint.setColor(color);
                Paint paint2 = new Paint();
                this.f16608z = paint2;
                paint2.setAntiAlias(true);
                paint2.setTextAlign(Paint.Align.CENTER);
                paint2.setTextSize(this.f16581e);
                paint2.setTypeface(editText.getTypeface());
                paint2.setColor(color2);
                this.E = new com.mobvoi.companion.base.ui.view.numberpicker.a(getContext(), null, true);
                this.F = new com.mobvoi.companion.base.ui.view.numberpicker.a(getContext(), new DecelerateInterpolator(2.5f));
                W();
                if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }
}
