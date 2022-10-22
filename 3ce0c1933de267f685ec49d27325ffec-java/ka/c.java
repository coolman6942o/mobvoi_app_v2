package ka;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.i;
/* compiled from: PacketComposer.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f29837a = new c();

    private c() {
    }

    public final byte[] a(int i10, byte[] bArr) {
        return b(new a(0, i10, bArr, 1, null));
    }

    public final byte[] b(a packet) {
        i.f(packet, "packet");
        int b10 = packet.b();
        int a10 = packet.a();
        byte[] c10 = packet.c();
        int i10 = 0;
        ByteBuffer order = ByteBuffer.allocate((c10 == null ? 0 : c10.length) + 6).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) b10);
        order.putShort((short) a10);
        if (c10 != null) {
            i10 = c10.length;
        }
        order.putShort((short) i10);
        if (c10 != null) {
            order.put(c10);
        }
        byte[] array = order.array();
        i.e(array, "buffer.array()");
        return array;
    }
}
