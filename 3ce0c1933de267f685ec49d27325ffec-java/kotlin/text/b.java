package kotlin.text;

import vo.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes3.dex */
public class b {
    public static int a(int i10) {
        if (2 <= i10 && 36 >= i10) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new c(2, 36));
    }

    public static final int b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    public static final boolean c(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }
}
