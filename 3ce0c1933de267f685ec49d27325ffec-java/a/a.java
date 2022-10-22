package a;

import android.os.ParcelUuid;
import fl.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
/* loaded from: classes.dex */
public class a {
    public static ParcelUuid a(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new ParcelUuid(new UUID(wrap.getLong(0), wrap.getLong(8)));
    }

    public static ParcelUuid b(ParcelUuid[] parcelUuidArr, UUID uuid, boolean z10) {
        ParcelUuid a10;
        if (!(uuid == null || parcelUuidArr == null || parcelUuidArr.length <= 0)) {
            for (ParcelUuid parcelUuid : parcelUuidArr) {
                if (parcelUuid != null) {
                    if (uuid.equals(parcelUuid.getUuid())) {
                        return parcelUuid;
                    }
                    if (!b.d(parcelUuid) && !b.e(parcelUuid) && z10 && (a10 = a(jl.a.d(c(parcelUuid)))) != null && uuid.equals(a10.getUuid())) {
                        il.b.j("match reverse uuid:" + a10.toString());
                        return a10;
                    }
                }
            }
        }
        return null;
    }

    public static byte[] c(ParcelUuid parcelUuid) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        UUID uuid = parcelUuid.getUuid();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        allocate.putLong(mostSignificantBits);
        allocate.putLong(8, leastSignificantBits);
        return allocate.array();
    }
}
