package gl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.ParcelUuid;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import gl.a;
import il.b;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@TargetApi(19)
/* loaded from: classes2.dex */
public class c extends gl.a {

    /* renamed from: g  reason: collision with root package name */
    public BluetoothAdapter.LeScanCallback f27494g = new a();

    /* loaded from: classes2.dex */
    public class a implements BluetoothAdapter.LeScanCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
            c cVar = c.this;
            a.AbstractC0292a aVar = cVar.f27492f;
            if (aVar != null) {
                el.c.this.e(bluetoothDevice, i10, bArr);
            } else {
                b.k(cVar.f27488b, "no listeners register");
            }
        }
    }

    public c(Context context) {
        super(context);
        b.k(this.f27488b, "LeScannerV19 init");
    }

    @Override // gl.a
    public boolean a() {
        String str;
        super.a();
        BluetoothAdapter bluetoothAdapter = this.f27489c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            str = "BT Adapter is not turned ON";
        } else {
            try {
                this.f27489c.stopLeScan(this.f27494g);
                return true;
            } catch (Exception e10) {
                str = e10.toString();
            }
        }
        b.l(str);
        return false;
    }

    @Override // gl.a
    public boolean b(ScannerParams scannerParams) {
        if (!super.b(scannerParams)) {
            return false;
        }
        UUID[] uuidArr = null;
        List<CompatScanFilter> h10 = scannerParams.h();
        if (h10 != null && h10.size() > 0) {
            b.k(this.f27488b, "contains " + h10.size() + " filters");
            ArrayList arrayList = new ArrayList();
            for (CompatScanFilter compatScanFilter : h10) {
                b.j(compatScanFilter.toString());
                if (compatScanFilter.i() != null) {
                    arrayList.add(compatScanFilter.i());
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                uuidArr = new UUID[size];
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayList.get(i10) != null) {
                        uuidArr[i10] = ((ParcelUuid) arrayList.get(i10)).getUuid();
                    }
                }
            }
        }
        try {
            return this.f27489c.startLeScan(uuidArr, this.f27494g);
        } catch (Exception e10) {
            b.l(e10.toString());
            return false;
        }
    }
}
