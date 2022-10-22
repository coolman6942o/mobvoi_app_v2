package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ag implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f24291a;

    /* renamed from: c  reason: collision with root package name */
    private int f24293c;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24292b = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24294d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f24291a = afVar;
    }

    private String a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = charSequence.charAt(i12);
            if (charAt != ' ') {
                i11++;
                if (i12 != 0 && (i11 & 3) == 1) {
                    stringBuffer.append(' ');
                }
            }
            if (i12 == i10) {
                this.f24293c = stringBuffer.length();
            }
            if (charAt != ' ') {
                stringBuffer.append(charAt);
            }
        }
        if (i10 == length) {
            this.f24293c = stringBuffer.length();
        }
        return stringBuffer.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (i11 == 1 && i12 == 0 && charSequence.charAt(i10) == ' ') {
            this.f24294d = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f24292b) {
            if (this.f24294d) {
                CharSequence subSequence = charSequence.subSequence(0, i10 - 1);
                if (i10 < charSequence.length()) {
                    charSequence = subSequence.toString() + ((Object) charSequence.subSequence(i10, charSequence.length()));
                } else {
                    charSequence = subSequence;
                }
                i10--;
                this.f24294d = false;
            }
            this.f24292b = false;
            ((aa) this.f24291a).f24277b.c(a(charSequence, i10 + i12));
            u uVar = ((aa) this.f24291a).f24277b;
            int i13 = this.f24293c;
            if (i13 > 23) {
                i13 = 23;
            }
            uVar.b(i13);
            this.f24292b = true;
        }
    }
}
