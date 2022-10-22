package fk;

import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import qk.c;
/* compiled from: TicCareDevice.java */
/* loaded from: classes2.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private TicCareDeviceInfo f27067a;

    public b(TicCareDeviceInfo ticCareDeviceInfo) {
        this.f27067a = ticCareDeviceInfo;
    }

    @Override // qk.c
    public String getId() {
        return this.f27067a.deviceId;
    }

    @Override // qk.c
    public String getModel() {
        return "tic_care";
    }
}
