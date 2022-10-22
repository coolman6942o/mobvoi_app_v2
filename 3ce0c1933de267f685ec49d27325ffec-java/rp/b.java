package rp;

import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: -Platform.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final byte[] a(String asUtf8ToByteArray) {
        i.f(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(d.f30092a);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] toUtf8String) {
        i.f(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, d.f30092a);
    }
}
