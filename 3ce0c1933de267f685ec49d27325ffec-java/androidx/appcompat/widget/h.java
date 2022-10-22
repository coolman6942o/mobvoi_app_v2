package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.a;
import androidx.core.view.d0;
import androidx.core.widget.c;
import d.j;
/* compiled from: AppCompatCheckedTextViewHelper.java */
/* loaded from: classes.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f1168a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1169b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1170c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1171d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1172e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1173f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CheckedTextView checkedTextView) {
        this.f1168a = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable a10 = c.a(this.f1168a);
        if (a10 == null) {
            return;
        }
        if (this.f1171d || this.f1172e) {
            Drawable mutate = a.r(a10).mutate();
            if (this.f1171d) {
                a.o(mutate, this.f1169b);
            }
            if (this.f1172e) {
                a.p(mutate, this.f1170c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1168a.getDrawableState());
            }
            this.f1168a.setCheckMarkDrawable(mutate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f1169b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f1170c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AttributeSet attributeSet, int i10) {
        boolean z10;
        int i11;
        int i12;
        int n10;
        int n11;
        Context context = this.f1168a.getContext();
        int[] iArr = j.M0;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        CheckedTextView checkedTextView = this.f1168a;
        d0.r0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i13 = j.O0;
            if (v10.s(i13) && (n11 = v10.n(i13, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.f1168a;
                    checkedTextView2.setCheckMarkDrawable(e.a.b(checkedTextView2.getContext(), n11));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z10) {
                    int i14 = j.N0;
                    if (v10.s(i14) && (n10 = v10.n(i14, 0)) != 0) {
                        CheckedTextView checkedTextView3 = this.f1168a;
                        checkedTextView3.setCheckMarkDrawable(e.a.b(checkedTextView3.getContext(), n10));
                    }
                }
                i11 = j.P0;
                if (v10.s(i11)) {
                    c.b(this.f1168a, v10.c(i11));
                }
                i12 = j.Q0;
                if (v10.s(i12)) {
                    c.c(this.f1168a, g0.e(v10.k(i12, -1), null));
                }
            }
            z10 = false;
            if (!z10) {
            }
            i11 = j.P0;
            if (v10.s(i11)) {
            }
            i12 = j.Q0;
            if (v10.s(i12)) {
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f1173f) {
            this.f1173f = false;
            return;
        }
        this.f1173f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f1169b = colorStateList;
        this.f1171d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f1170c = mode;
        this.f1172e = true;
        a();
    }
}
