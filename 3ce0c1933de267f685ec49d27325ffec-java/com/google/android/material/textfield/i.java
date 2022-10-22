package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.j;
import com.google.android.material.textfield.TextInputLayout;
import d7.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PasswordToggleEndIconDelegate.java */
/* loaded from: classes.dex */
public class i extends e {

    /* renamed from: e  reason: collision with root package name */
    private final TextWatcher f11557e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.f f11558f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.g f11559g = new c();

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes.dex */
    class a extends j {
        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            i iVar = i.this;
            iVar.f11525c.setChecked(!iVar.g());
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes.dex */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            i iVar = i.this;
            iVar.f11525c.setChecked(!iVar.g());
            editText.removeTextChangedListener(i.this.f11557e);
            editText.addTextChangedListener(i.this.f11557e);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes.dex */
    class c implements TextInputLayout.g {

        /* compiled from: PasswordToggleEndIconDelegate.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f11563a;

            a(EditText editText) {
                this.f11563a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11563a.removeTextChangedListener(i.this.f11557e);
            }
        }

        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i10 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new a(editText));
            }
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = i.this.f11523a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                if (i.this.g()) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                i.this.f11523a.X();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.f11523a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        TextInputLayout textInputLayout = this.f11523a;
        int i10 = this.f11526d;
        if (i10 == 0) {
            i10 = e.f25234a;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f11523a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(d7.j.R));
        this.f11523a.setEndIconOnClickListener(new d());
        this.f11523a.e(this.f11558f);
        this.f11523a.f(this.f11559g);
        EditText editText = this.f11523a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
