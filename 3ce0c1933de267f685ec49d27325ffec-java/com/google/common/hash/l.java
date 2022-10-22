package com.google.common.hash;

import java.nio.Buffer;
/* compiled from: Java8Compatibility.java */
/* loaded from: classes.dex */
final class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Buffer buffer) {
        buffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Buffer buffer, int i10) {
        buffer.position(i10);
    }
}
