package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.h;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.u;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.g;
import com.google.android.material.textview.MaterialTextView;
import g7.a;
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends h {
    @Override // androidx.appcompat.app.h
    protected c c(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected e d(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected f e(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected u k(Context context, AttributeSet attributeSet) {
        return new s7.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    protected b0 o(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
