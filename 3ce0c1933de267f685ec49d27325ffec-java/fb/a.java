package fb;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.i;
/* compiled from: LoginPrivacyUtil.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: LoginPrivacyUtil.kt */
    /* renamed from: fb.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0285a extends fb.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ fb.b f26397a;

        C0285a(fb.b bVar) {
            this.f26397a = bVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            this.f26397a.c();
        }
    }

    /* compiled from: LoginPrivacyUtil.kt */
    /* loaded from: classes2.dex */
    public static final class b extends fb.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ fb.b f26398a;

        b(fb.b bVar) {
            this.f26398a = bVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            this.f26398a.b();
        }
    }

    /* compiled from: LoginPrivacyUtil.kt */
    /* loaded from: classes2.dex */
    public static final class c extends fb.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ fb.b f26399a;

        c(fb.b bVar) {
            this.f26399a = bVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            this.f26399a.a();
        }
    }

    public static final void a(TextView textView, fb.b listener) {
        i.f(textView, "<this>");
        i.f(listener, "listener");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(androidx.core.content.b.c(textView.getContext(), pa.c.f32623f));
        String string = textView.getContext().getString(pa.i.f32691a0);
        i.e(string, "context.getString(R.string.user_agreement)");
        String string2 = textView.getContext().getString(pa.i.M);
        i.e(string2, "context.getString(R.string.privacy_policy)");
        String string3 = textView.getContext().getString(pa.i.f32715y);
        i.e(string3, "context.getString(R.string.kid_privacy_policy)");
        String string4 = textView.getContext().getString(pa.i.O);
        i.e(string4, "context.getString(R.string.read_and_agree_before_login)");
        String string5 = textView.getContext().getString(pa.i.f32701k);
        i.e(string5, "context.getString(R.string.and)");
        String string6 = textView.getContext().getString(pa.i.f32702l);
        i.e(string6, "context.getString(R.string.as_well_as)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string4 + string + string5 + string2 + string6 + string3);
        int c10 = androidx.core.content.b.c(textView.getContext(), pa.c.f32620c);
        int c11 = androidx.core.content.b.c(textView.getContext(), pa.c.f32621d);
        int length = string4.length();
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c10), 0, length, 33);
        int length2 = string.length() + length;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c11), length, length2, 33);
        spannableStringBuilder.setSpan(new C0285a(listener), length, length2, 33);
        int length3 = string5.length() + length2;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c10), length2, length3, 33);
        int length4 = string2.length() + length3;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c11), length3, length4, 33);
        spannableStringBuilder.setSpan(new b(listener), length3, length4, 33);
        int length5 = string6.length() + length4;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c10), length4, length5, 33);
        int length6 = string3.length() + length5;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c11), length5, length6, 33);
        spannableStringBuilder.setSpan(new c(listener), length5, length6, 33);
        textView.setText(spannableStringBuilder);
    }
}
