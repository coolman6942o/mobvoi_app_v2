package ni;

import java.util.List;
import pk.f;
import rx.c;
/* compiled from: DeviceDataSource.java */
/* loaded from: classes2.dex */
public interface a {
    c<pi.a> dataChange();

    void deleteDevice(String str);

    c<String> deviceDel();

    void insertOrUpdateInfo(f fVar);

    c<pi.a> queryDevice(String str);

    c<List<pi.a>> queryDevices();
}
