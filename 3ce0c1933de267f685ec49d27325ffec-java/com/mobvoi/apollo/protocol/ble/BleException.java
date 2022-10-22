package com.mobvoi.apollo.protocol.ble;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
/* compiled from: BleException.kt */
/* loaded from: classes2.dex */
public final class BleException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BleException(String message) {
        super(message);
        i.f(message, "message");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BleException(String format, Object... args) {
        super(r3);
        i.f(format, "format");
        i.f(args, "args");
        n nVar = n.f30086a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        i.e(format2, "java.lang.String.format(locale, format, *args)");
    }
}
