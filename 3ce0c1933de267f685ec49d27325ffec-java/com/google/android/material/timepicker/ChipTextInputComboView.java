package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.d0;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.j;
import com.google.android.material.internal.m;
import com.google.android.material.textfield.TextInputLayout;
import d7.f;
import d7.h;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private final Chip f11566a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f11567b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f11568c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f11569d;

    /* loaded from: classes.dex */
    private class b extends j {
        private b() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f11566a.setText(ChipTextInputComboView.this.d("00"));
            } else {
                ChipTextInputComboView.this.f11566a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f11568c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f11568c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f11568c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f11567b;
    }

    public void f(androidx.core.view.a aVar) {
        d0.t0(this.f11566a, aVar);
    }

    public void g(CharSequence charSequence) {
        this.f11566a.setText(d(charSequence));
        if (!TextUtils.isEmpty(this.f11568c.getText())) {
            this.f11568c.removeTextChangedListener(this.f11569d);
            this.f11568c.setText((CharSequence) null);
            this.f11568c.addTextChangedListener(this.f11569d);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f11566a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f11566a.setChecked(z10);
        int i10 = 0;
        this.f11568c.setVisibility(z10 ? 0 : 4);
        Chip chip = this.f11566a;
        if (z10) {
            i10 = 8;
        }
        chip.setVisibility(i10);
        if (isChecked()) {
            m.g(this.f11568c);
            if (!TextUtils.isEmpty(this.f11568c.getText())) {
                EditText editText = this.f11568c;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11566a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f11566a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f11566a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(h.f25295m, (ViewGroup) this, false);
        this.f11566a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(h.f25296n, (ViewGroup) this, false);
        this.f11567b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f11568c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f11569d = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(f.f25270q);
        editText.setSaveEnabled(false);
    }
}
