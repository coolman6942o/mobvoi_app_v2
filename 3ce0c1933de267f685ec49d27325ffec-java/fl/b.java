package fl;

import android.os.ParcelUuid;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final ParcelUuid f27080a = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");

    /* renamed from: b  reason: collision with root package name */
    public static final ParcelUuid f27081b = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    /* renamed from: c  reason: collision with root package name */
    public static final ParcelUuid[] f27082c;

    static {
        ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString2 = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
        ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000112e-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
        ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
        f27082c = new ParcelUuid[]{fromString, fromString2};
    }

    public static boolean a(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return true;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (!hashSet.contains(parcelUuid)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return parcelUuidArr.length == 0;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (hashSet.contains(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    public static UUID c(int i10) {
        return UUID.fromString("0000" + String.format("%04X", Integer.valueOf(i10 & 65535)) + "-0000-1000-8000-00805F9B34FB");
    }

    public static boolean d(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == f27081b.getUuid().getLeastSignificantBits() && (uuid.getMostSignificantBits() & (-281470681743361L)) == ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF;
    }

    public static boolean e(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == f27081b.getUuid().getLeastSignificantBits() && !d(parcelUuid) && (uuid.getMostSignificantBits() & 4294967295L) == ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF;
    }

    public static ParcelUuid f(byte[] bArr) {
        long j10;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j10 = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                } else {
                    j10 = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
                }
                ParcelUuid parcelUuid = f27081b;
                return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j10 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    public static int g(UUID uuid) {
        return (int) ((uuid.getMostSignificantBits() >> 32) & 65535);
    }
}
