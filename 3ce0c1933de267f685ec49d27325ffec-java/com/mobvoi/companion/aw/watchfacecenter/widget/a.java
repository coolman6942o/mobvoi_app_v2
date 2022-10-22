package com.mobvoi.companion.aw.watchfacecenter.widget;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.aw.watchfacecenter.widget.a;
import io.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.i;
import n1.n;
import n1.o;
import qo.l;
import qo.q;
/* compiled from: TextViewExtensions.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: TextViewExtensions.kt */
    /* renamed from: com.mobvoi.companion.aw.watchfacecenter.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0202a extends Lambda implements l<CharSequence, m> {
        final /* synthetic */ l<CharSequence, m> $onSuccess;
        final /* synthetic */ CharSequence $originText;
        final /* synthetic */ ViewGroup $sceneRoot;
        final /* synthetic */ TextView $this_collapse;
        final /* synthetic */ n1.m $transition;

        /* compiled from: TextViewExtensions.kt */
        /* renamed from: com.mobvoi.companion.aw.watchfacecenter.widget.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0203a extends n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TextView f16522a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CharSequence f16523b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ l<CharSequence, m> f16524c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ CharSequence f16525d;

            /* JADX WARN: Multi-variable type inference failed */
            C0203a(TextView textView, CharSequence charSequence, l<? super CharSequence, m> lVar, CharSequence charSequence2) {
                this.f16522a = textView;
                this.f16523b = charSequence;
                this.f16524c = lVar;
                this.f16525d = charSequence2;
            }

            @Override // n1.m.f
            public void b(n1.m transition) {
                i.f(transition, "transition");
                transition.P(this);
                this.f16522a.getLayoutParams().height = -2;
                TextView textView = this.f16522a;
                textView.setLayoutParams(textView.getLayoutParams());
                this.f16522a.setText(this.f16523b);
                l<CharSequence, m> lVar = this.f16524c;
                if (lVar != null) {
                    lVar.invoke(this.f16525d);
                }
            }

            @Override // n1.n, n1.m.f
            public void d(n1.m transition) {
                i.f(transition, "transition");
                transition.P(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0202a(n1.m mVar, l<? super CharSequence, m> lVar, TextView textView, CharSequence charSequence, ViewGroup viewGroup) {
            super(1);
            this.$transition = mVar;
            this.$onSuccess = lVar;
            this.$this_collapse = textView;
            this.$originText = charSequence;
            this.$sceneRoot = viewGroup;
        }

        public final void a(CharSequence result) {
            i.f(result, "result");
            if (this.$transition == null) {
                l<CharSequence, m> lVar = this.$onSuccess;
                if (lVar != null) {
                    lVar.invoke(result);
                    return;
                }
                return;
            }
            CharSequence text = this.$this_collapse.getText();
            int height = this.$this_collapse.getLayout().getHeight() + this.$this_collapse.getPaddingTop() + this.$this_collapse.getPaddingBottom();
            this.$this_collapse.setText(this.$originText);
            this.$this_collapse.getLayoutParams().height = height;
            TextView textView = this.$this_collapse;
            textView.setLayoutParams(textView.getLayoutParams());
            this.$transition.a(new C0203a(this.$this_collapse, text, this.$onSuccess, result));
            o.a(this.$sceneRoot, this.$transition);
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(CharSequence charSequence) {
            a(charSequence);
            return m.f28349a;
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements l<CharSequence, m> {
        final /* synthetic */ CharSequence $mainContent;
        final /* synthetic */ l<CharSequence, m> $onFailed;
        final /* synthetic */ int $targetLineCount;
        final /* synthetic */ TextView $this_collapse;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(TextView textView, CharSequence charSequence, int i10, l<? super CharSequence, m> lVar) {
            super(1);
            this.$this_collapse = textView;
            this.$mainContent = charSequence;
            this.$targetLineCount = i10;
            this.$onFailed = lVar;
        }

        public final void a(CharSequence it) {
            i.f(it, "it");
            this.$this_collapse.setText(this.$mainContent);
            this.$this_collapse.setMaxLines(this.$targetLineCount);
            l<CharSequence, m> lVar = this.$onFailed;
            if (lVar != null) {
                lVar.invoke(this.$mainContent);
            }
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(CharSequence charSequence) {
            a(charSequence);
            return m.f28349a;
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    public static final class c extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f16526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CharSequence f16527b;

        c(TextView textView, CharSequence charSequence) {
            this.f16526a = textView;
            this.f16527b = charSequence;
        }

        @Override // n1.m.f
        public void b(n1.m transition) {
            i.f(transition, "transition");
            transition.P(this);
            this.f16526a.getLayoutParams().height = -2;
            TextView textView = this.f16526a;
            textView.setLayoutParams(textView.getLayoutParams());
            this.f16526a.setText(this.f16527b);
        }

        @Override // n1.n, n1.m.f
        public void d(n1.m transition) {
            i.f(transition, "transition");
            transition.P(this);
        }
    }

    /* compiled from: TextViewExtensions.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f16528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l<CharSequence, m> f16529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CharSequence f16530c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CharSequence f16531d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f16532e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q<String, CharSequence, Integer, CharSequence> f16533f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CharSequence f16534g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ l<CharSequence, m> f16535h;

        /* JADX WARN: Multi-variable type inference failed */
        d(TextView textView, l<? super CharSequence, m> lVar, CharSequence charSequence, CharSequence charSequence2, int i10, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar, CharSequence charSequence3, l<? super CharSequence, m> lVar2) {
            this.f16528a = textView;
            this.f16529b = lVar;
            this.f16530c = charSequence;
            this.f16531d = charSequence2;
            this.f16532e = i10;
            this.f16533f = qVar;
            this.f16534g = charSequence3;
            this.f16535h = lVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TextView this_setTextWithSuffix, CharSequence mainContent, CharSequence suffix, int i10, q qVar, l onFailed, CharSequence charSequence, l onSuccess) {
            i.f(this_setTextWithSuffix, "$this_setTextWithSuffix");
            i.f(mainContent, "$mainContent");
            i.f(suffix, "$suffix");
            i.f(onFailed, "$onFailed");
            i.f(onSuccess, "$onSuccess");
            long currentTimeMillis = System.currentTimeMillis();
            a.k(onFailed, charSequence, this_setTextWithSuffix, mainContent, suffix, qVar, onSuccess, a.d(this_setTextWithSuffix, mainContent, suffix, i10, qVar));
            long currentTimeMillis2 = System.currentTimeMillis();
            a.h(">>>>>performance: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f16528a.removeOnLayoutChangeListener(this);
            if (this.f16528a.getLayout() == null) {
                l<CharSequence, m> lVar = this.f16529b;
                CharSequence text = this.f16528a.getText();
                i.e(text, "text");
                lVar.invoke(text);
                return;
            }
            final TextView textView = this.f16528a;
            final CharSequence charSequence = this.f16530c;
            final CharSequence charSequence2 = this.f16531d;
            final int i18 = this.f16532e;
            final q<String, CharSequence, Integer, CharSequence> qVar = this.f16533f;
            final l<CharSequence, m> lVar2 = this.f16529b;
            final CharSequence charSequence3 = this.f16534g;
            final l<CharSequence, m> lVar3 = this.f16535h;
            textView.post(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.d.b(textView, charSequence, charSequence2, i18, qVar, lVar2, charSequence3, lVar3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(TextView textView, CharSequence charSequence, CharSequence charSequence2, int i10, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar) {
        int i11;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (textView.getLayout() == null) {
            h("layout is null");
            return -1;
        }
        int e10 = e(linkedHashMap, ref$IntRef, charSequence, charSequence2, textView, qVar, 0, charSequence.length());
        if (e10 <= i10) {
            h("verify <= targetLineCount, verify = " + e10 + ", targetLineCount = " + i10);
            textView.setText(charSequence);
            return charSequence.length();
        }
        int length = charSequence.length();
        h("left = 0, right = " + length);
        int i12 = length;
        int i13 = 0;
        while (true) {
            if (i13 > i12) {
                break;
            }
            int i14 = (i13 + i12) / 2;
            int e11 = e(linkedHashMap, ref$IntRef, charSequence, charSequence2, textView, qVar, 0, i14);
            String str = "binarySearch: (" + i13 + ", " + i14 + ", " + i12 + "), pLineCount = " + e11;
            if (e11 < i10) {
                str = str + ", targetLineCount = " + i10 + ", pLineCount < targetLineCount";
                i13 = i14 + 1;
                i11 = i14;
            } else if (e11 == i10) {
                int i15 = i14 + 1;
                int e12 = e(linkedHashMap, ref$IntRef, charSequence, charSequence2, textView, qVar, 0, i15);
                str = str + ", nLineCount = " + e12;
                int i16 = i10 + 1;
                if (e12 < i16) {
                    i11 = i14;
                    i13 = i15;
                } else if (e12 == i16) {
                    h("success = " + i14 + ", verifyCount = " + ref$IntRef.element);
                    return i14;
                } else {
                    h("impossible");
                }
            } else {
                i11 = i14;
                i12 = i11 - 1;
            }
            h(str + ", text = " + charSequence.subSequence(0, i11).toString() + ((Object) charSequence2));
        }
        h(i.n("failed, verifyCount = ", Integer.valueOf(ref$IntRef.element)));
        return -1;
    }

    private static final int e(Map<Integer, Integer> map, Ref$IntRef ref$IntRef, CharSequence charSequence, CharSequence charSequence2, TextView textView, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar, int i10, int i11) {
        CharSequence invoke;
        int i12 = (i10 << 16) | i11;
        Integer num = map.get(Integer.valueOf(i12));
        if (num != null) {
            h("verify: " + i11 + " cached");
            return num.intValue();
        }
        ref$IntRef.element++;
        CharSequence n10 = i.n(charSequence.subSequence(i10, i11).toString(), charSequence2);
        if (!(qVar == null || (invoke = qVar.invoke(n10, charSequence2, Integer.valueOf(i11))) == null)) {
            n10 = invoke;
        }
        textView.setText(n10);
        int lineCount = textView.getLineCount();
        h("verify: " + i11 + ", lineCount = " + lineCount);
        map.put(Integer.valueOf(i12), Integer.valueOf(lineCount));
        return lineCount;
    }

    public static final void f(TextView textView, CharSequence mainContent, CharSequence suffix, int i10, n1.m mVar, ViewGroup sceneRoot, l<? super CharSequence, m> lVar, l<? super CharSequence, m> lVar2, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar) {
        i.f(textView, "<this>");
        i.f(mainContent, "mainContent");
        i.f(suffix, "suffix");
        i.f(sceneRoot, "sceneRoot");
        j(textView, mainContent, suffix, i10, new C0202a(mVar, lVar, textView, textView.getText(), sceneRoot), new b(textView, mainContent, i10, lVar2), qVar);
    }

    public static final void g(TextView textView, CharSequence mainContent, n1.m mVar, ViewGroup sceneRoot) {
        i.f(textView, "<this>");
        i.f(mainContent, "mainContent");
        i.f(sceneRoot, "sceneRoot");
        textView.setMaxLines(Integer.MAX_VALUE);
        textView.setText(mainContent);
        if (mVar != null) {
            o.a(sceneRoot, mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Object obj) {
        Log.d("TextViewLayout", String.valueOf(obj));
    }

    public static final void i(TextView textView, CharSequence content, n1.m transition, ViewGroup sceneRoot) {
        i.f(textView, "<this>");
        i.f(content, "content");
        i.f(transition, "transition");
        i.f(sceneRoot, "sceneRoot");
        CharSequence text = textView.getText();
        textView.setText(content);
        Layout layout = textView.getLayout();
        if (layout != null) {
            textView.setText(text);
            textView.getLayoutParams().height = layout.getHeight() + textView.getPaddingTop() + textView.getPaddingBottom();
            textView.setLayoutParams(textView.getLayoutParams());
            transition.a(new c(textView, content));
        }
        o.a(sceneRoot, transition);
    }

    public static final void j(TextView textView, CharSequence mainContent, CharSequence suffix, int i10, l<? super CharSequence, m> onSuccess, l<? super CharSequence, m> onFailed, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar) {
        i.f(textView, "<this>");
        i.f(mainContent, "mainContent");
        i.f(suffix, "suffix");
        i.f(onSuccess, "onSuccess");
        i.f(onFailed, "onFailed");
        CharSequence text = textView.getText();
        if (textView.getLayout() == null) {
            textView.addOnLayoutChangeListener(new d(textView, onFailed, mainContent, suffix, i10, qVar, text, onSuccess));
            textView.requestLayout();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        k(onFailed, text, textView, mainContent, suffix, qVar, onSuccess, d(textView, mainContent, suffix, i10, qVar));
        long currentTimeMillis2 = System.currentTimeMillis();
        h(">>>>>performance: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(l<? super CharSequence, m> lVar, CharSequence originText, TextView textView, CharSequence charSequence, CharSequence charSequence2, q<? super String, ? super CharSequence, ? super Integer, ? extends CharSequence> qVar, l<? super CharSequence, m> lVar2, int i10) {
        CharSequence invoke;
        if (i10 < 0) {
            i.e(originText, "originText");
            lVar.invoke(originText);
            return;
        }
        if (i10 < charSequence.length()) {
            charSequence = i.n(charSequence.subSequence(0, i10).toString(), charSequence2);
            if (!(qVar == null || (invoke = qVar.invoke(charSequence, charSequence2, Integer.valueOf(i10))) == null)) {
                charSequence = invoke;
            }
        }
        textView.setText(charSequence);
        CharSequence text = textView.getText();
        i.e(text, "text");
        lVar2.invoke(text);
    }
}
