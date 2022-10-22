package bp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: DfuServiceListenerHelper.java */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static b f5491a;

    /* compiled from: DfuServiceListenerHelper.java */
    /* loaded from: classes3.dex */
    private static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private k f5492a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, k> f5493b;

        private b() {
            this.f5493b = new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(k kVar) {
            if (this.f5492a == kVar) {
                this.f5492a = null;
            }
            Iterator<Map.Entry<String, k>> it = this.f5493b.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, k> next = it.next();
                if (next.getValue() == kVar) {
                    this.f5493b.remove(next.getKey());
                    break;
                }
            }
            Iterator<Map.Entry<String, k>> it2 = this.f5493b.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, k> next2 = it2.next();
                if (next2.getValue() == kVar) {
                    this.f5493b.remove(next2.getKey());
                    break;
                }
            }
            return this.f5492a == null && this.f5493b.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(k kVar) {
            this.f5492a = kVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS");
            k kVar = this.f5492a;
            k kVar2 = this.f5493b.get(stringExtra);
            if (kVar != null || kVar2 != null) {
                String action = intent.getAction();
                action.hashCode();
                if (action.equals("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS")) {
                    int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
                    float floatExtra = intent.getFloatExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", 0.0f);
                    float floatExtra2 = intent.getFloatExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", 0.0f);
                    int intExtra2 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 0);
                    int intExtra3 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 0);
                    switch (intExtra) {
                        case -7:
                            if (kVar != null) {
                                kVar.b(stringExtra);
                                kVar.g(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.b(stringExtra);
                                kVar2.g(stringExtra);
                                return;
                            }
                            return;
                        case -6:
                            if (kVar != null) {
                                kVar.b(stringExtra);
                                kVar.k(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.b(stringExtra);
                                kVar2.k(stringExtra);
                                return;
                            }
                            return;
                        case -5:
                            if (kVar != null) {
                                kVar.i(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.i(stringExtra);
                                return;
                            }
                            return;
                        case -4:
                            if (kVar != null) {
                                kVar.h(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.h(stringExtra);
                                return;
                            }
                            return;
                        case -3:
                            if (kVar != null) {
                                kVar.c(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.c(stringExtra);
                                return;
                            }
                            return;
                        case -2:
                            if (kVar != null) {
                                kVar.j(stringExtra);
                                kVar.l(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.j(stringExtra);
                                kVar2.l(stringExtra);
                                return;
                            }
                            return;
                        case -1:
                            if (kVar != null) {
                                kVar.f(stringExtra);
                            }
                            if (kVar2 != null) {
                                kVar2.f(stringExtra);
                                return;
                            }
                            return;
                        default:
                            if (intExtra == 0) {
                                if (kVar != null) {
                                    kVar.a(stringExtra);
                                }
                                if (kVar2 != null) {
                                    kVar2.a(stringExtra);
                                }
                            }
                            if (kVar != null) {
                                kVar.e(stringExtra, intExtra, floatExtra, floatExtra2, intExtra2, intExtra3);
                            }
                            if (kVar2 != null) {
                                kVar2.e(stringExtra, intExtra, floatExtra, floatExtra2, intExtra2, intExtra3);
                                return;
                            }
                            return;
                    }
                } else if (action.equals("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR")) {
                    int intExtra4 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
                    int intExtra5 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
                    if (kVar != null) {
                        kVar.b(stringExtra);
                    }
                    if (kVar2 != null) {
                        kVar2.b(stringExtra);
                    }
                    if (intExtra5 == 1) {
                        if (kVar != null) {
                            kVar.d(stringExtra, intExtra4, intExtra5, fp.a.b(intExtra4));
                        }
                        if (kVar2 != null) {
                            kVar2.d(stringExtra, intExtra4, intExtra5, fp.a.b(intExtra4));
                        }
                    } else if (intExtra5 != 3) {
                        if (kVar != null) {
                            kVar.d(stringExtra, intExtra4, intExtra5, fp.a.a(intExtra4));
                        }
                        if (kVar2 != null) {
                            kVar2.d(stringExtra, intExtra4, intExtra5, fp.a.a(intExtra4));
                        }
                    } else {
                        if (kVar != null) {
                            kVar.d(stringExtra, intExtra4, intExtra5, fp.a.c(intExtra4));
                        }
                        if (kVar2 != null) {
                            kVar2.d(stringExtra, intExtra4, intExtra5, fp.a.c(intExtra4));
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, k kVar) {
        if (f5491a == null) {
            f5491a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
            b1.a.b(context).c(f5491a, intentFilter);
        }
        f5491a.d(kVar);
    }

    public static void b(Context context, k kVar) {
        b bVar = f5491a;
        if (bVar != null && bVar.c(kVar)) {
            b1.a.b(context).e(f5491a);
            f5491a = null;
        }
    }
}
