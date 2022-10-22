package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import j0.h;
/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
final class z {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1371a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1372b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextView textView) {
        this.f1371a = (TextView) h.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1372b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1371a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f1372b = textClassifier;
    }
}
