package b1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mobvoi.wear.util.TelephonyUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f4968f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static a f4969g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f4970a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f4971b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f4972c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f4973d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f4974e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0063a extends Handler {
        HandlerC0063a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f4976a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f4977b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f4976a = intent;
            this.f4977b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f4978a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f4979b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4980c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4981d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4978a = intentFilter;
            this.f4979b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f4979b);
            sb2.append(" filter=");
            sb2.append(this.f4978a);
            if (this.f4981d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private a(Context context) {
        this.f4970a = context;
        this.f4974e = new HandlerC0063a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f4968f) {
            if (f4969g == null) {
                f4969g = new a(context.getApplicationContext());
            }
            aVar = f4969g;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f4971b) {
                size = this.f4973d.size();
                if (size > 0) {
                    bVarArr = new b[size];
                    this.f4973d.toArray(bVarArr);
                    this.f4973d.clear();
                } else {
                    return;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f4977b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f4977b.get(i11);
                    if (!cVar.f4981d) {
                        cVar.f4979b.onReceive(this.f4970a, bVar.f4976a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f4971b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f4971b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f4971b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<c> arrayList2 = this.f4972c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f4972c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        ArrayList<c> arrayList;
        String str2;
        int i10;
        ArrayList arrayList2;
        synchronized (this.f4971b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4970a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f4972c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    c cVar = arrayList3.get(i11);
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f4978a);
                    }
                    if (cVar.f4980c) {
                        if (z10) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i10 = i11;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        i10 = i11;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = cVar.f4978a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(cVar);
                            cVar.f4980c = true;
                            i11 = i10 + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        } else if (z10) {
                            String str3 = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : TelephonyUtil.KEY_SIM_ACTION : "category";
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                        }
                    }
                    arrayList4 = arrayList2;
                    i11 = i10 + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((c) arrayList5.get(i12)).f4980c = false;
                    }
                    this.f4973d.add(new b(intent, arrayList5));
                    if (!this.f4974e.hasMessages(1)) {
                        this.f4974e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f4971b) {
            ArrayList<c> remove = this.f4971b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.f4981d = true;
                    for (int i10 = 0; i10 < cVar.f4978a.countActions(); i10++) {
                        String action = cVar.f4978a.getAction(i10);
                        ArrayList<c> arrayList = this.f4972c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f4979b == broadcastReceiver) {
                                    cVar2.f4981d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f4972c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
