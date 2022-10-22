package bm;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.UUID;
import xl.b;
/* loaded from: classes2.dex */
public abstract class c extends b {
    public BluetoothGattService A0;
    public BluetoothGattCharacteristic B0;
    public BluetoothGattCharacteristic C0;
    public BluetoothGattService G0;
    public BluetoothGattCharacteristic H0;
    public BluetoothGattCharacteristic I0;

    /* renamed from: z0  reason: collision with root package name */
    public UUID f5243z0 = f.Z;
    public UUID D0 = f.f5255b0;
    public UUID E0 = f.f5256c0;
    public UUID F0 = f.f5257d0;

    public c(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    public int p0() {
        if (this.G0 == null) {
            il.b.l("DFU_SERVICE not found:" + this.D0.toString());
            throw new OtaException("load dfu service failed", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS);
        } else if (this.H0 == null) {
            il.b.l("not found DFU_CONTROL_POINT_UUID : " + this.F0.toString());
            throw new OtaException("load dfu service failed", DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS);
        } else if (this.I0 == null) {
            il.b.l("not found DFU_DATA_UUID :" + this.E0.toString());
            throw new OtaException("load dfu service failed", DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS);
        } else if (!this.f36588b) {
            return 0;
        } else {
            il.b.j("find DFU_CONTROL_POINT_UUID: " + this.F0.toString());
            il.b.j("find DFU_DATA_UUID: " + this.E0.toString());
            return 0;
        }
    }

    @Override // bm.b, zl.b, xl.a
    public void x() {
        super.x();
        try {
            this.f5243z0 = UUID.fromString(t().u());
            this.D0 = UUID.fromString(t().g());
            this.E0 = UUID.fromString(t().f());
            this.F0 = UUID.fromString(t().e());
        } catch (Exception e10) {
            il.b.l(e10.toString());
        }
        this.f36593g = true;
    }
}
