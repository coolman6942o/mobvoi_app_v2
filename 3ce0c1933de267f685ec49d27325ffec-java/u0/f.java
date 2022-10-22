package u0;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.emoji2.text.d;
import j0.h;
/* compiled from: EmojiTextViewHelper.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final b f35252a;

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f35253a;

        /* renamed from: b  reason: collision with root package name */
        private final d f35254b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f35255c = true;

        a(TextView textView) {
            this.f35253a = textView;
            this.f35254b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f35254b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f35254b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> g(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                if (inputFilterArr[i10] instanceof d) {
                    sparseArray.put(i10, inputFilterArr[i10]);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g10 = g(inputFilterArr);
            if (g10.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - g10.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (g10.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f35253a.setFilters(a(this.f35253a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return (!(transformationMethod instanceof h) && !(transformationMethod instanceof PasswordTransformationMethod)) ? new h(transformationMethod) : transformationMethod;
        }

        @Override // u0.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f35255c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        @Override // u0.f.b
        public boolean b() {
            return this.f35255c;
        }

        @Override // u0.f.b
        void c(boolean z10) {
            if (z10) {
                l();
            }
        }

        @Override // u0.f.b
        void d(boolean z10) {
            this.f35255c = z10;
            l();
            k();
        }

        @Override // u0.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f35255c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        void i(boolean z10) {
            this.f35255c = z10;
        }

        void l() {
            this.f35253a.setTransformationMethod(e(this.f35253a.getTransformationMethod()));
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        void c(boolean z10) {
        }

        void d(boolean z10) {
        }

        TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    /* compiled from: EmojiTextViewHelper.java */
    /* loaded from: classes.dex */
    private static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final a f35256a;

        c(TextView textView) {
            this.f35256a = new a(textView);
        }

        private boolean f() {
            return !d.h();
        }

        @Override // u0.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f35256a.a(inputFilterArr);
        }

        @Override // u0.f.b
        public boolean b() {
            return this.f35256a.b();
        }

        @Override // u0.f.b
        void c(boolean z10) {
            if (!f()) {
                this.f35256a.c(z10);
            }
        }

        @Override // u0.f.b
        void d(boolean z10) {
            if (f()) {
                this.f35256a.i(z10);
            } else {
                this.f35256a.d(z10);
            }
        }

        @Override // u0.f.b
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f35256a.e(transformationMethod);
        }
    }

    public f(TextView textView, boolean z10) {
        h.h(textView, "textView cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f35252a = new b();
        } else if (!z10) {
            this.f35252a = new c(textView);
        } else {
            this.f35252a = new a(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f35252a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f35252a.b();
    }

    public void c(boolean z10) {
        this.f35252a.c(z10);
    }

    public void d(boolean z10) {
        this.f35252a.d(z10);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f35252a.e(transformationMethod);
    }
}
