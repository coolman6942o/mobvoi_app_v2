package da;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.mobvoi.android.common.utils.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.collections.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: AdvertisePayloadParser.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f25575a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, byte[]> f25576b = new HashMap<>();

    /* compiled from: AdvertisePayloadParser.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final da.a c(BluetoothDevice bluetoothDevice, byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        short s10 = order.getShort();
        byte[] bArr2 = new byte[6];
        order.get(bArr2);
        String b10 = com.mobvoi.android.common.utils.f.b(bArr2);
        i.e(b10, "encodeWithHex(macAddress)");
        return new da.a(bluetoothDevice, (byte) 1, s10, b10);
    }

    private final void d(byte b10, byte[] bArr) {
        byte[] g10;
        byte[] g11;
        if (b10 == 3) {
            kotlin.collections.i.w(bArr);
            this.f25575a.add(com.mobvoi.android.common.utils.f.d(bArr, false));
        } else if (b10 == 22) {
            if (bArr.length > 2) {
                g10 = h.g(bArr, 0, 2);
                kotlin.collections.i.w(g10);
                String oneUuid = com.mobvoi.android.common.utils.f.d(g10, false);
                g11 = h.g(bArr, 2, bArr.length);
                HashMap<String, byte[]> hashMap = this.f25576b;
                i.e(oneUuid, "oneUuid");
                hashMap.put(oneUuid, g11);
                return;
            }
            throw new IllegalStateException(("The data is too small for TYPE_SERVICE_DATA_16_BIT (size = " + bArr.length + ").").toString());
        }
    }

    public final da.a a(BluetoothDevice device, byte[] data) {
        byte[] g10;
        int i10;
        byte[] g11;
        i.f(device, "device");
        i.f(data, "data");
        k.a("AdvertisePayloadParser", "Parsing [" + ((Object) com.mobvoi.android.common.utils.f.b(data)) + ']');
        int i11 = 0;
        while (i11 < data.length && (i10 = data[i11] & 255) != 0) {
            byte b10 = data[i11 + 1];
            int i12 = i11 + 2;
            g11 = h.g(data, i12, (i12 + i10) - 1);
            d(b10, g11);
            i11 += i10 + 1;
        }
        byte[] bArr = this.f25576b.get("fea6");
        if (bArr == null) {
            k.a("AdvertisePayloadParser", "service data not found");
            return null;
        } else if (bArr.length < 2) {
            k.a("AdvertisePayloadParser", i.n("illegal service data, size=", Integer.valueOf(bArr.length)));
            return null;
        } else if (bArr[0] != -120) {
            k.a("AdvertisePayloadParser", "illegal service data, vendor id not match.");
            return null;
        } else {
            byte b11 = bArr[1];
            k.a("AdvertisePayloadParser", "version: " + ((int) b11) + ", " + bArr.length);
            if (b11 == 1) {
                if (bArr.length == 10) {
                    g10 = h.g(bArr, 2, 10);
                    return c(device, g10);
                }
                k.a("AdvertisePayloadParser", i.n("illegal service data for version#1, size=", Integer.valueOf(bArr.length)));
            }
            String address = device.getAddress();
            i.e(address, "device.address");
            return new da.a(device, b11, (short) 1, address);
        }
    }

    public final da.a b(ScanResult result) {
        i.f(result, "result");
        if (result.getScanRecord() == null) {
            k.a("AdvertisePayloadParser", "No scan record");
            return null;
        }
        BluetoothDevice device = result.getDevice();
        i.e(device, "result.device");
        ScanRecord scanRecord = result.getScanRecord();
        i.d(scanRecord);
        byte[] bytes = scanRecord.getBytes();
        i.e(bytes, "result.scanRecord!!.bytes");
        return a(device, bytes);
    }
}
