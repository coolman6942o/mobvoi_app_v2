package oa;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.i;
/* compiled from: ByteUtils.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final byte[] a(int i10) {
        byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i10).array();
        i.e(array, "allocate(4).order(ByteOrder.LITTLE_ENDIAN)\n        .putInt(this)\n        .array()");
        return array;
    }
}
