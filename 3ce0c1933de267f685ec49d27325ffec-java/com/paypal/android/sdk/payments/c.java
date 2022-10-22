package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
class c {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f21683f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static c f21684g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f21685a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f21686b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap f21687c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f21688d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f21689e;

    private c(Context context) {
        this.f21685a = context;
        this.f21689e = new d(this, context.getMainLooper());
    }

    public static c a(Context context) {
        c cVar;
        synchronized (f21683f) {
            if (f21684g == null) {
                f21684g = new c(context.getApplicationContext());
            }
            cVar = f21684g;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(c cVar) {
        int size;
        e[] eVarArr;
        while (true) {
            synchronized (cVar.f21686b) {
                size = cVar.f21688d.size();
                if (size > 0) {
                    eVarArr = new e[size];
                    cVar.f21688d.toArray(eVarArr);
                    cVar.f21688d.clear();
                } else {
                    return;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = eVarArr[i10];
                for (int i11 = 0; i11 < eVar.f21714b.size(); i11++) {
                    ((f) eVar.f21714b.get(i11)).f21720b.onReceive(cVar.f21685a, eVar.f21713a);
                }
            }
        }
    }

    public final void b(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f21686b) {
            ArrayList arrayList = (ArrayList) this.f21686b.remove(broadcastReceiver);
            if (arrayList != null) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    IntentFilter intentFilter = (IntentFilter) arrayList.get(i10);
                    for (int i11 = 0; i11 < intentFilter.countActions(); i11++) {
                        String action = intentFilter.getAction(i11);
                        ArrayList arrayList2 = (ArrayList) this.f21687c.get(action);
                        if (arrayList2 != null) {
                            int i12 = 0;
                            while (i12 < arrayList2.size()) {
                                if (((f) arrayList2.get(i12)).f21720b == broadcastReceiver) {
                                    arrayList2.remove(i12);
                                    i12--;
                                }
                                i12++;
                            }
                            if (arrayList2.size() <= 0) {
                                this.f21687c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f21686b) {
            f fVar = new f(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f21686b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f21686b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList arrayList2 = (ArrayList) this.f21687c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f21687c.put(action, arrayList2);
                }
                arrayList2.add(fVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [int, boolean] */
    public final boolean e(Intent intent) {
        String str;
        ArrayList arrayList;
        String str2;
        int i10;
        boolean z10;
        ArrayList arrayList2;
        synchronized (this.f21686b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f21685a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z11 = true;
            boolean z12 = (intent.getFlags() & 8) != 0;
            if (z12) {
                intent.toString();
            }
            ArrayList arrayList3 = (ArrayList) this.f21687c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z12) {
                    arrayList3.toString();
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    f fVar = (f) arrayList3.get(i11);
                    if (z12) {
                        Objects.toString(fVar.f21719a);
                    }
                    if (fVar.f21721c) {
                        i10 = i11;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                        z10 = z11;
                    } else {
                        IntentFilter intentFilter = fVar.f21719a;
                        String str3 = action;
                        String str4 = resolveTypeIfNeeded;
                        i10 = i11;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        z10 = z11;
                        int match = intentFilter.match(str3, str4, scheme, data, categories, "ClonedLocalBroadcastManager");
                        if (match >= 0) {
                            if (z12) {
                                Integer.toHexString(match);
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(fVar);
                            fVar.f21721c = z10;
                            i11 = i10 + 1;
                            z11 = z10;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        }
                    }
                    arrayList4 = arrayList2;
                    i11 = i10 + 1;
                    z11 = z10;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                ArrayList arrayList5 = arrayList4;
                ?? r11 = z11;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((f) arrayList5.get(i12)).f21721c = false;
                    }
                    this.f21688d.add(new e(intent, arrayList5));
                    if (!this.f21689e.hasMessages(r11 == true ? 1 : 0)) {
                        this.f21689e.sendEmptyMessage(r11);
                    }
                    return r11;
                }
            }
            return false;
        }
    }
}
