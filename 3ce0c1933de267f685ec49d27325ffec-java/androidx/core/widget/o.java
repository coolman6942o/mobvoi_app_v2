package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* compiled from: TintableImageSourceView.java */
/* loaded from: classes.dex */
public interface o {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
