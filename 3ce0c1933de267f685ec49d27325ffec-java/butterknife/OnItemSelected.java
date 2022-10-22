package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* JADX WARN: Method from annotation default annotation not found: callback */
/* JADX WARN: Method from annotation default annotation not found: value */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface OnItemSelected {

    /* loaded from: classes.dex */
    public enum Callback {
        ITEM_SELECTED,
        NOTHING_SELECTED
    }
}
