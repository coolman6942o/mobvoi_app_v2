package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import d.j;
import u0.f;
/* compiled from: AppCompatEmojiTextHelper.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1256a;

    /* renamed from: b  reason: collision with root package name */
    private final f f1257b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TextView textView) {
        this.f1256a = textView;
        this.f1257b = new f(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1257b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1257b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f1256a.getContext().obtainStyledAttributes(attributeSet, j.f24870d0, i10, 0);
        try {
            int i11 = j.f24940r0;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f1257b.c(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f1257b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1257b.e(transformationMethod);
    }
}
