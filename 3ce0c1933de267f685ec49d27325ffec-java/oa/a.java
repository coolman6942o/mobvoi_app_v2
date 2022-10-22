package oa;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
/* compiled from: BluetoothHelper.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f31484a = new a();

    private a() {
    }

    public final boolean a(Context context) {
        i.f(context, "context");
        if (!g(context)) {
            k.q("BluetoothHelper", "This device doesn't support BLE");
            return false;
        }
        BluetoothAdapter d10 = d(context);
        if (d10 == null) {
            k.q("BluetoothHelper", "Failed to get BluetoothAdapter");
            return false;
        } else if (d10.isEnabled()) {
            return true;
        } else {
            k.q("BluetoothHelper", "Bluetooth not enabled");
            return false;
        }
    }

    public final String b(int i10) {
        if (i10 == 0) {
            return "DISCONNECTED";
        }
        if (i10 == 1) {
            return "CONNECTING";
        }
        if (i10 == 2) {
            return "CONNECTED";
        }
        if (i10 == 3) {
            return "DISCONNECTING";
        }
        return "CONNECTION_STATE_UNKNOWN-[" + i10 + ']';
    }

    public final String c(int i10) {
        if (i10 == 13) {
            return "GATT_INVALID_ATTRIBUTE_LENGTH";
        }
        if (i10 == 15) {
            return "GATT_INSUFFICIENT_ENCRYPTION";
        }
        if (i10 == 128) {
            return "GATT_NO_RESOURCES";
        }
        if (i10 == 257) {
            return "GATT_FAILURE";
        }
        if (i10 == 132) {
            return "GATT_BUSY";
        }
        if (i10 == 133) {
            return "GATT_ERROR";
        }
        switch (i10) {
            case 0:
                return "GATT_SUCCESS";
            case 1:
                return "GATT_INVALID_HANDLE";
            case 2:
                return "GATT_READ_NOT_PERMITTED";
            case 3:
                return "GATT_WRITE_NOT_PERMITTED";
            case 4:
                return "GATT_INVALID_PDU";
            case 5:
                return "GATT_INSUFFICIENT_AUTHENTICATION";
            case 6:
                return "GATT_REQUEST_NOT_SUPPORTED";
            case 7:
                return "GATT_INVALID_OFFSET";
            case 8:
                return "GATT_INSUF_AUTHORIZATION";
            default:
                n nVar = n.f30086a;
                String format = String.format(Locale.US, "GATT_STATUS_UNKNOWN-[0x%x]", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                i.e(format, "java.lang.String.format(locale, format, *args)");
                return format;
        }
    }

    public final BluetoothAdapter d(Context context) {
        i.f(context, "context");
        return e(context).getAdapter();
    }

    public final BluetoothManager e(Context context) {
        i.f(context, "context");
        Object systemService = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        return (BluetoothManager) systemService;
    }

    public final boolean f(Context context, String btAddress) {
        Set<BluetoothDevice> bondedDevices;
        i.f(context, "context");
        i.f(btAddress, "btAddress");
        BluetoothAdapter d10 = d(context);
        Object obj = null;
        if (!(d10 == null || (bondedDevices = d10.getBondedDevices()) == null)) {
            Iterator<T> it = bondedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (i.b(((BluetoothDevice) next).getAddress(), btAddress)) {
                    obj = next;
                    break;
                }
            }
            obj = (BluetoothDevice) obj;
        }
        return obj != null;
    }

    public final boolean g(Context context) {
        i.f(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
