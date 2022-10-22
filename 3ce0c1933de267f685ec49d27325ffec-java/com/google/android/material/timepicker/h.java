package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.j;
import com.google.android.material.timepicker.TimePickerView;
import d7.f;
import java.lang.reflect.Field;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePickerTextInputPresenter.java */
/* loaded from: classes.dex */
public class h implements TimePickerView.g, f {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11651a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeModel f11652b;

    /* renamed from: c  reason: collision with root package name */
    private final TextWatcher f11653c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f11654d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f11655e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f11656f;

    /* renamed from: g  reason: collision with root package name */
    private final g f11657g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f11658h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f11659i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f11660j;

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes.dex */
    class a extends j {
        a() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    h.this.f11652b.i(0);
                    return;
                }
                h.this.f11652b.i(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes.dex */
    class b extends j {
        b() {
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    h.this.f11652b.g(0);
                    return;
                }
                h.this.f11652b.g(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.f(((Integer) view.getTag(f.f25245b0)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerTextInputPresenter.java */
    /* loaded from: classes.dex */
    public class d implements MaterialButtonToggleGroup.e {
        d() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
            h.this.f11652b.j(i10 == f.f25266m ? 1 : 0);
        }
    }

    public h(LinearLayout linearLayout, TimeModel timeModel) {
        this.f11651a = linearLayout;
        this.f11652b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(f.f25271r);
        this.f11655e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(f.f25268o);
        this.f11656f = chipTextInputComboView2;
        int i10 = f.f25270q;
        ((TextView) chipTextInputComboView.findViewById(i10)).setText(resources.getString(d7.j.f25324o));
        ((TextView) chipTextInputComboView2.findViewById(i10)).setText(resources.getString(d7.j.f25323n));
        int i11 = f.f25245b0;
        chipTextInputComboView.setTag(i11, 12);
        chipTextInputComboView2.setTag(i11, 10);
        if (timeModel.f11596c == 0) {
            m();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.d());
        chipTextInputComboView.c(timeModel.e());
        EditText editText = chipTextInputComboView2.e().getEditText();
        this.f11658h = editText;
        EditText editText2 = chipTextInputComboView.e().getEditText();
        this.f11659i = editText2;
        if (Build.VERSION.SDK_INT < 21) {
            int d10 = j7.a.d(linearLayout, d7.b.f25159o);
            k(editText, d10);
            k(editText2, d10);
        }
        this.f11657g = new g(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new com.google.android.material.timepicker.a(linearLayout.getContext(), d7.j.f25318i));
        chipTextInputComboView.f(new com.google.android.material.timepicker.a(linearLayout.getContext(), d7.j.f25320k));
        h();
    }

    private void d() {
        this.f11658h.addTextChangedListener(this.f11654d);
        this.f11659i.addTextChangedListener(this.f11653c);
    }

    private void i() {
        this.f11658h.removeTextChangedListener(this.f11654d);
        this.f11659i.removeTextChangedListener(this.f11653c);
    }

    private static void k(EditText editText, int i10) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i11 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable b10 = e.a.b(context, i11);
            b10.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{b10, b10});
        } catch (Throwable unused) {
        }
    }

    private void l(TimeModel timeModel) {
        i();
        Locale locale = this.f11651a.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(timeModel.f11598e));
        String format2 = String.format(locale, "%02d", Integer.valueOf(timeModel.c()));
        this.f11655e.g(format);
        this.f11656f.g(format2);
        d();
        n();
    }

    private void m() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f11651a.findViewById(f.f25267n);
        this.f11660j = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new d());
        this.f11660j.setVisibility(0);
        n();
    }

    private void n() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f11660j;
        if (materialButtonToggleGroup != null) {
            materialButtonToggleGroup.j(this.f11652b.f11600g == 0 ? f.f25264l : f.f25266m);
        }
    }

    @Override // com.google.android.material.timepicker.f
    public void a() {
        this.f11651a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.f
    public void c() {
        l(this.f11652b);
    }

    public void e() {
        this.f11655e.setChecked(false);
        this.f11656f.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void f(int i10) {
        this.f11652b.f11599f = i10;
        boolean z10 = true;
        this.f11655e.setChecked(i10 == 12);
        ChipTextInputComboView chipTextInputComboView = this.f11656f;
        if (i10 != 10) {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
        n();
    }

    @Override // com.google.android.material.timepicker.f
    public void g() {
        View focusedChild = this.f11651a.getFocusedChild();
        if (focusedChild == null) {
            this.f11651a.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) androidx.core.content.b.i(this.f11651a.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f11651a.setVisibility(8);
    }

    public void h() {
        d();
        l(this.f11652b);
        this.f11657g.a();
    }

    public void j() {
        boolean z10 = true;
        this.f11655e.setChecked(this.f11652b.f11599f == 12);
        ChipTextInputComboView chipTextInputComboView = this.f11656f;
        if (this.f11652b.f11599f != 10) {
            z10 = false;
        }
        chipTextInputComboView.setChecked(z10);
    }
}
