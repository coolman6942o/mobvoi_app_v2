package com.mobvoi.companion.aw.watchfacecenter.widget;

import a0.h;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import n1.m;
import n1.n;
import n1.o;
import qo.l;
import qo.q;
/* compiled from: TextViewExtensions.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f16544a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f16545b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f16546c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f16547d;

    /* renamed from: e  reason: collision with root package name */
    private Layout f16548e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16549f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16550g;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f16554k;

    /* renamed from: m  reason: collision with root package name */
    private final io.d f16556m;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16551h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f16552i = 3;

    /* renamed from: j  reason: collision with root package name */
    private m f16553j = new n1.b();

    /* renamed from: l  reason: collision with root package name */
    private final q<String, CharSequence, Integer, CharSequence> f16555l = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f16557a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16558b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f16559c;

        /* renamed from: d  reason: collision with root package name */
        private final View.OnClickListener f16560d;

        public a(int i10, int i11, Integer num, View.OnClickListener onClickListener) {
            this.f16557a = i10;
            this.f16558b = i11;
            this.f16559c = num;
            this.f16560d = onClickListener;
        }

        public final Integer a() {
            return this.f16559c;
        }

        public final int b() {
            return this.f16557a;
        }

        public final View.OnClickListener c() {
            return this.f16560d;
        }

        public final int d() {
            return this.f16558b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16557a == aVar.f16557a && this.f16558b == aVar.f16558b && i.b(this.f16559c, aVar.f16559c) && i.b(this.f16560d, aVar.f16560d);
        }

        public int hashCode() {
            int i10 = ((this.f16557a * 31) + this.f16558b) * 31;
            Integer num = this.f16559c;
            int i11 = 0;
            int hashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
            View.OnClickListener onClickListener = this.f16560d;
            if (onClickListener != null) {
                i11 = onClickListener.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "SuffixColor(fromIndex=" + this.f16557a + ", toIndex=" + this.f16558b + ", color=" + this.f16559c + ", listener=" + this.f16560d + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements l<CharSequence, io.m> {
        b() {
            super(1);
        }

        public final void a(CharSequence text) {
            i.f(text, "text");
            c.this.f16547d = text;
            c cVar = c.this;
            cVar.f16548e = cVar.l().getLayout();
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ io.m invoke(CharSequence charSequence) {
            a(charSequence);
            return io.m.f28349a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextViewExtensions.kt */
    /* renamed from: com.mobvoi.companion.aw.watchfacecenter.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0204c extends Lambda implements l<CharSequence, io.m> {
        final /* synthetic */ m $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0204c(m mVar) {
            super(1);
            this.$transition = mVar;
        }

        public final void a(CharSequence it) {
            i.f(it, "it");
            c.n(c.this, this.$transition);
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ io.m invoke(CharSequence charSequence) {
            a(charSequence);
            return io.m.f28349a;
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    public static final class d extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f16561a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f16562b;

        d(TextView textView, c cVar) {
            this.f16561a = textView;
            this.f16562b = cVar;
        }

        @Override // n1.m.f
        public void b(m transition) {
            i.f(transition, "transition");
            transition.P(this);
            this.f16561a.getLayoutParams().height = -2;
            TextView textView = this.f16561a;
            textView.setLayoutParams(textView.getLayoutParams());
            this.f16561a.setMaxLines(this.f16562b.k());
            this.f16561a.setText(this.f16562b.g());
        }

        @Override // n1.n, n1.m.f
        public void d(m transition) {
            i.f(transition, "transition");
            transition.P(this);
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<List<a>> {
        public static final e INSTANCE = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final List<a> invoke() {
            return new ArrayList();
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements q<String, CharSequence, Integer, SpannableStringBuilder> {

        /* compiled from: TextViewExtensions.kt */
        /* loaded from: classes2.dex */
        public static final class a extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View.OnClickListener f16563a;

            a(View.OnClickListener onClickListener) {
                this.f16563a = onClickListener;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                i.f(widget, "widget");
                this.f16563a.onClick(widget);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                i.f(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        }

        f() {
            super(3);
        }

        public final SpannableStringBuilder a(String text, CharSequence suffix, int i10) {
            i.f(text, "text");
            i.f(suffix, "suffix");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            c cVar = c.this;
            for (a aVar : cVar.j()) {
                int b10 = aVar.b() + i10;
                int d10 = aVar.d() + i10;
                View.OnClickListener c10 = aVar.c();
                if (c10 != null) {
                    spannableStringBuilder.setSpan(new a(c10), b10, d10, 33);
                    cVar.l().setMovementMethod(LinkMovementMethod.getInstance());
                }
                Integer a10 = aVar.a();
                if (a10 != null) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(a10.intValue()), b10, d10, 33);
                }
            }
            return spannableStringBuilder;
        }

        @Override // qo.q
        public /* bridge */ /* synthetic */ SpannableStringBuilder invoke(String str, CharSequence charSequence, Integer num) {
            return a(str, charSequence, num.intValue());
        }
    }

    public c(TextView textView) {
        io.d a10;
        i.f(textView, "textView");
        this.f16544a = textView;
        CharSequence text = textView.getText();
        i.e(text, "textView.text");
        this.f16545b = text;
        ViewParent parent = textView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f16554k = (ViewGroup) parent;
        a10 = io.f.a(e.INSTANCE);
        this.f16556m = a10;
        if (textView.getLayoutParams().width == -2) {
            throw new RuntimeException("textView's width can't be wrap_content. Only support match_parent or specified size");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<a> j() {
        return (List) this.f16556m.getValue();
    }

    private final void m(m mVar) {
        if (!this.f16551h || this.f16544a.getMaxLines() >= this.f16552i) {
            this.f16549f = true;
            if (this.f16546c == null) {
                n(this, mVar);
            } else if (!this.f16550g || this.f16547d == null || !i.b(this.f16548e, this.f16544a.getLayout())) {
                TextView textView = this.f16544a;
                CharSequence charSequence = this.f16545b;
                CharSequence charSequence2 = this.f16546c;
                i.d(charSequence2);
                com.mobvoi.companion.aw.watchfacecenter.widget.a.f(textView, charSequence, charSequence2, this.f16552i, mVar, this.f16554k, new b(), new C0204c(mVar), this.f16555l);
            } else if (!i.b(this.f16547d, this.f16545b)) {
                if (mVar != null) {
                    TextView textView2 = this.f16544a;
                    CharSequence charSequence3 = this.f16547d;
                    i.d(charSequence3);
                    com.mobvoi.companion.aw.watchfacecenter.widget.a.i(textView2, charSequence3, mVar, this.f16554k);
                    return;
                }
                this.f16544a.setMaxLines(this.f16552i);
                this.f16544a.setEllipsize(TextUtils.TruncateAt.END);
                this.f16544a.setText(this.f16547d);
            }
        } else {
            throw new IllegalArgumentException(("textView.maxLines(" + l().getMaxLines() + ") < targetLineCount(" + k() + ')').toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(c cVar, m mVar) {
        cVar.f16544a.setMaxLines(cVar.f16552i);
        cVar.f16544a.setEllipsize(TextUtils.TruncateAt.END);
        CharSequence text = cVar.f16544a.getText();
        cVar.f16544a.setText(cVar.f16545b);
        if (mVar != null) {
            TextView textView = cVar.f16544a;
            Layout layout = textView.getLayout();
            if (layout != null) {
                textView.setText(text);
                textView.setMaxLines(Integer.MAX_VALUE);
                textView.getLayoutParams().height = layout.getHeight() + textView.getPaddingTop() + textView.getPaddingBottom();
                textView.setLayoutParams(textView.getLayoutParams());
                mVar.a(new d(textView, cVar));
            }
            o.a(cVar.h(), mVar);
        }
    }

    private final void o(m mVar) {
        this.f16549f = false;
        com.mobvoi.companion.aw.watchfacecenter.widget.a.g(this.f16544a, this.f16545b, mVar, this.f16554k);
    }

    public final void e(boolean z10) {
        m(z10 ? this.f16553j : null);
    }

    public final void f(boolean z10) {
        o(z10 ? this.f16553j : null);
    }

    public final CharSequence g() {
        return this.f16545b;
    }

    public final ViewGroup h() {
        return this.f16554k;
    }

    public final CharSequence i() {
        return this.f16546c;
    }

    public final int k() {
        return this.f16552i;
    }

    public final TextView l() {
        return this.f16544a;
    }

    public final void p(CharSequence value) {
        i.f(value, "value");
        this.f16547d = null;
        this.f16545b = value;
    }

    public final void q(CharSequence charSequence) {
        this.f16547d = null;
        this.f16546c = charSequence;
    }

    public final void r(int i10, int i11, int i12, View.OnClickListener listener) {
        i.f(listener, "listener");
        j().add(new a(i10, i11, Integer.valueOf(h.d(this.f16544a.getResources(), i12, this.f16544a.getContext().getTheme())), listener));
    }

    public final void s(boolean z10) {
        if (this.f16549f) {
            f(z10);
        } else {
            e(z10);
        }
    }
}
