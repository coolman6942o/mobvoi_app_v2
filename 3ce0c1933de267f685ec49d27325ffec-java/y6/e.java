package y6;
/* loaded from: classes.dex */
public final class e {
    public static byte a(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : (byte) 0;
        }
        return (byte) -1;
    }

    public static Boolean b(byte b10) {
        if (b10 == 0) {
            return Boolean.FALSE;
        }
        if (b10 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }
}
