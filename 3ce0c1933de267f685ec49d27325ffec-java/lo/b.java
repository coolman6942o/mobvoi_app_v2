package lo;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import no.a;
/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30564a;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int a10 = a();
        if (a10 >= 65544) {
            try {
                newInstance = a.class.newInstance();
                i.e(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                    } catch (ClassCastException e10) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e10);
                        i.e(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                i.e(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance3 != null) {
                        aVar = (a) newInstance3;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassCastException e11) {
                    ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e11);
                    i.e(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause2;
                }
            }
            if (newInstance != null) {
                aVar = (a) newInstance;
                f30564a = aVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        if (a10 >= 65543) {
            try {
                newInstance2 = mo.a.class.newInstance();
                i.e(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e12) {
                    ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e12);
                    i.e(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause3;
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                i.e(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance4 != null) {
                        aVar = (a) newInstance4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassCastException e13) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e13);
                    i.e(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause4;
                }
            }
            if (newInstance2 != null) {
                aVar = (a) newInstance2;
                f30564a = aVar;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        aVar = new a();
        f30564a = aVar;
    }

    private static final int a() {
        int S;
        int S2;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        S = u.S(property, '.', 0, false, 6, null);
        if (S < 0) {
            try {
                return Integer.parseInt(property) * WXMediaMessage.THUMB_LENGTH_LIMIT;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        } else {
            int i10 = S + 1;
            S2 = u.S(property, '.', i10, false, 4, null);
            if (S2 < 0) {
                S2 = property.length();
            }
            String substring = property.substring(0, S);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = property.substring(i10, S2);
            i.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * WXMediaMessage.THUMB_LENGTH_LIMIT) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
    }
}
