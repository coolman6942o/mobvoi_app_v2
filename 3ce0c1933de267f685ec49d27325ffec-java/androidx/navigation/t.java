package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.k;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: Navigator.java */
/* loaded from: classes.dex */
public abstract class t<D extends k> {

    /* compiled from: Navigator.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: Navigator.java */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface b {
        String value();
    }

    public abstract D a();

    public abstract k b(D d10, Bundle bundle, q qVar, a aVar);

    public void c(Bundle bundle) {
    }

    public Bundle d() {
        return null;
    }

    public abstract boolean e();
}
