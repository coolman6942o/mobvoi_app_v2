package u0;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.m;
/* compiled from: EmojiEditableFactory.java */
/* loaded from: classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f35241a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f35242b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f35243c;

    @SuppressLint({"PrivateApi"})
    private b() {
        try {
            f35243c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f35242b == null) {
            synchronized (f35241a) {
                if (f35242b == null) {
                    f35242b = new b();
                }
            }
        }
        return f35242b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f35243c;
        if (cls != null) {
            return m.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
