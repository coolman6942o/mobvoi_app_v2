package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
/* compiled from: TimePickerTextInputKeyController.java */
/* loaded from: classes.dex */
class g implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final ChipTextInputComboView f11647a;

    /* renamed from: b  reason: collision with root package name */
    private final ChipTextInputComboView f11648b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeModel f11649c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11650d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f11647a = chipTextInputComboView;
        this.f11648b = chipTextInputComboView2;
        this.f11649c = timeModel;
    }

    private void b(int i10) {
        boolean z10 = true;
        this.f11648b.setChecked(i10 == 12);
        ChipTextInputComboView chipTextInputComboView = this.f11647a;
        if (i10 != 10) {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
        this.f11649c.f11599f = i10;
    }

    private boolean c(int i10, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (!(i10 >= 7 && i10 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2)) {
            return false;
        }
        b(12);
        return true;
    }

    private boolean d(int i10, KeyEvent keyEvent, EditText editText) {
        if (!(i10 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText()))) {
            return false;
        }
        b(10);
        return true;
    }

    public void a() {
        TextInputLayout e10 = this.f11647a.e();
        TextInputLayout e11 = this.f11648b.e();
        EditText editText = e10.getEditText();
        EditText editText2 = e11.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        boolean z10 = i10 == 5;
        if (z10) {
            b(12);
        }
        return z10;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        if (this.f11650d) {
            return false;
        }
        this.f11650d = true;
        EditText editText = (EditText) view;
        if (this.f11649c.f11599f == 12) {
            z10 = d(i10, keyEvent, editText);
        } else {
            z10 = c(i10, keyEvent, editText);
        }
        this.f11650d = false;
        return z10;
    }
}
