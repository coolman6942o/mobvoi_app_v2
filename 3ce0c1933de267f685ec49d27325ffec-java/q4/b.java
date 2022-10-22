package q4;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/* compiled from: Key.java */
/* loaded from: classes.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f32922a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
