package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* JADX WARN: Method from annotation default annotation not found: callback */
/* JADX WARN: Method from annotation default annotation not found: value */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface OnTextChanged {

    /* loaded from: classes.dex */
    public enum Callback {
        TEXT_CHANGED,
        BEFORE_TEXT_CHANGED,
        AFTER_TEXT_CHANGED
    }
}
