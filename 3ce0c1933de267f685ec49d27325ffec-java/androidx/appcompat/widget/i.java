package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.view.d0;
import androidx.core.widget.d;
import d.j;
/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1190a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1191b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1192c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1193d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1194e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1195f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CompoundButton compoundButton) {
        this.f1190a = compoundButton;
    }

    void a() {
        Drawable a10 = d.a(this.f1190a);
        if (a10 == null) {
            return;
        }
        if (this.f1193d || this.f1194e) {
            Drawable mutate = a.r(a10).mutate();
            if (this.f1193d) {
                a.o(mutate, this.f1191b);
            }
            if (this.f1194e) {
                a.p(mutate, this.f1192c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1190a.getDrawableState());
            }
            this.f1190a.setButtonDrawable(mutate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        Drawable a10;
        return (Build.VERSION.SDK_INT >= 17 || (a10 = d.a(this.f1190a)) == null) ? i10 : i10 + a10.getIntrinsicWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1191b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1192c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:30:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(AttributeSet attributeSet, int i10) {
        boolean z10;
        int i11;
        int i12;
        int n10;
        int n11;
        Context context = this.f1190a.getContext();
        int[] iArr = j.R0;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton = this.f1190a;
        d0.r0(compoundButton, compoundButton.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i13 = j.T0;
            if (v10.s(i13) && (n11 = v10.n(i13, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f1190a;
                    compoundButton2.setButtonDrawable(e.a.b(compoundButton2.getContext(), n11));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z10) {
                    int i14 = j.S0;
                    if (v10.s(i14) && (n10 = v10.n(i14, 0)) != 0) {
                        CompoundButton compoundButton3 = this.f1190a;
                        compoundButton3.setButtonDrawable(e.a.b(compoundButton3.getContext(), n10));
                    }
                }
                i11 = j.U0;
                if (v10.s(i11)) {
                    d.c(this.f1190a, v10.c(i11));
                }
                i12 = j.V0;
                if (v10.s(i12)) {
                    d.d(this.f1190a, g0.e(v10.k(i12, -1), null));
                }
            }
            z10 = false;
            if (!z10) {
            }
            i11 = j.U0;
            if (v10.s(i11)) {
            }
            i12 = j.V0;
            if (v10.s(i12)) {
            }
        } finally {
            v10.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f1195f) {
            this.f1195f = false;
            return;
        }
        this.f1195f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1191b = colorStateList;
        this.f1193d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1192c = mode;
        this.f1194e = true;
        a();
    }
}
