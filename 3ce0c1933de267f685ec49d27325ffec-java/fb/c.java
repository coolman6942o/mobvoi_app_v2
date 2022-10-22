package fb;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import kotlin.jvm.internal.i;
/* compiled from: LoginPrivacyUtil.kt */
/* loaded from: classes2.dex */
abstract class c extends ClickableSpan {
    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        i.f(ds, "ds");
        ds.setUnderlineText(false);
    }
}
