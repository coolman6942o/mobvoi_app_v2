package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.l;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f4132a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f4133b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<k> f4134c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final l.a f4135d = new b();

    /* loaded from: classes.dex */
    class a extends RemoteCallbackList<k> {
        a() {
        }

        /* renamed from: a */
        public void onCallbackDied(k kVar, Object obj) {
            MultiInstanceInvalidationService.this.f4133b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    /* loaded from: classes.dex */
    class b extends l.a {
        b() {
        }

        @Override // androidx.room.l
        public int U(k kVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4134c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i10 = multiInstanceInvalidationService.f4132a + 1;
                multiInstanceInvalidationService.f4132a = i10;
                if (multiInstanceInvalidationService.f4134c.register(kVar, Integer.valueOf(i10))) {
                    MultiInstanceInvalidationService.this.f4133b.put(Integer.valueOf(i10), str);
                    return i10;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4132a--;
                return 0;
            }
        }

        @Override // androidx.room.l
        public void g2(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4134c) {
                String str = MultiInstanceInvalidationService.this.f4133b.get(Integer.valueOf(i10));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f4134c.beginBroadcast();
                for (int i11 = 0; i11 < beginBroadcast; i11++) {
                    int intValue = ((Integer) MultiInstanceInvalidationService.this.f4134c.getBroadcastCookie(i11)).intValue();
                    String str2 = MultiInstanceInvalidationService.this.f4133b.get(Integer.valueOf(intValue));
                    if (i10 != intValue && str.equals(str2)) {
                        try {
                            MultiInstanceInvalidationService.this.f4134c.getBroadcastItem(i11).H(strArr);
                        } catch (RemoteException e10) {
                            Log.w("ROOM", "Error invoking a remote callback", e10);
                        }
                    }
                }
                MultiInstanceInvalidationService.this.f4134c.finishBroadcast();
            }
        }

        @Override // androidx.room.l
        public void p2(k kVar, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f4134c) {
                MultiInstanceInvalidationService.this.f4134c.unregister(kVar);
                MultiInstanceInvalidationService.this.f4133b.remove(Integer.valueOf(i10));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f4135d;
    }
}
