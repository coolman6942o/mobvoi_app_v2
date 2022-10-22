package com.unionpay.tsmservice.mi;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.tsmservice.mi.ITsmActivityCallback;
import com.unionpay.tsmservice.mi.ITsmCallback;
import com.unionpay.tsmservice.mi.ITsmService;
import com.unionpay.tsmservice.mi.data.Constant;
import com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.mi.request.CancelPayRequestParams;
import com.unionpay.tsmservice.mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.mi.request.ClearEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.request.InitRequestParams;
import com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.RequestParams;
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.result.AcquireSeAppListResult;
import com.unionpay.tsmservice.mi.result.AddCardResult;
import com.unionpay.tsmservice.mi.result.EncryptDataResult;
import com.unionpay.tsmservice.mi.result.GetEncryptDataResult;
import com.unionpay.tsmservice.mi.result.GetSeIdResult;
import com.unionpay.tsmservice.mi.result.InitResult;
import com.unionpay.tsmservice.mi.result.MessageDetailsResult;
import com.unionpay.tsmservice.mi.result.OnlinePaymentVerifyResult;
import com.unionpay.tsmservice.mi.result.PayResultNotifyResult;
import com.unionpay.tsmservice.mi.result.PinRequestResult;
import com.unionpay.tsmservice.mi.result.TransactionDetailsResult;
import com.unionpay.tsmservice.mi.result.VendorPayStatusResult;
import com.unionpay.tsmservice.mi.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UPTsmAddon {

    /* renamed from: a  reason: collision with root package name */
    private static UPTsmAddon f24542a;

    /* renamed from: b  reason: collision with root package name */
    private static CopyOnWriteArrayList f24543b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24544c;

    /* renamed from: d  reason: collision with root package name */
    private ServiceConnection f24545d = null;

    /* renamed from: e  reason: collision with root package name */
    private ITsmService f24546e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24547f = false;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f24548g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private HashMap f24549h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private HashMap f24550i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private HashMap f24551j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private HashMap f24552k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private HashMap f24553l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private HashMap f24554m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private HashMap f24555n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    private HashMap f24556o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private HashMap f24557p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    private HashMap f24558q = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private HashMap f24559r = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private HashMap f24560s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    private HashMap f24561t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    private HashMap f24562u = new HashMap();

    /* renamed from: v  reason: collision with root package name */
    private HashMap f24563v = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private int[] f24564w = new int[19];

    /* renamed from: x  reason: collision with root package name */
    private final Handler.Callback f24565x;

    /* renamed from: y  reason: collision with root package name */
    private final Handler f24566y;

    /* loaded from: classes2.dex */
    public interface UPTsmConnectionListener {
        void onTsmConnected();

        void onTsmDisconnected();
    }

    /* loaded from: classes2.dex */
    public final class a extends ITsmActivityCallback.Stub {

        /* renamed from: b  reason: collision with root package name */
        private int f24570b = 1000;

        public a() {
        }

        @Override // com.unionpay.tsmservice.mi.ITsmActivityCallback
        public final void startActivity(String str, String str2, int i10, Bundle bundle) {
            UPTsmAddon.a((ITsmActivityCallback) UPTsmAddon.b(UPTsmAddon.this, this.f24570b).get(UPTsmAddon.c(UPTsmAddon.this)), str, str2, i10, bundle);
            UPTsmAddon.b(UPTsmAddon.this, this.f24570b).remove(UPTsmAddon.c(UPTsmAddon.this));
        }
    }

    /* loaded from: classes2.dex */
    final class b extends ITsmCallback.Stub {

        /* renamed from: b  reason: collision with root package name */
        private int f24572b;

        /* renamed from: c  reason: collision with root package name */
        private int f24573c;

        private b(int i10, int i11) {
            this.f24572b = i10;
            this.f24573c = i11;
        }

        /* synthetic */ b(UPTsmAddon uPTsmAddon, int i10, int i11, byte b10) {
            this(i10, i11);
        }

        @Override // com.unionpay.tsmservice.mi.ITsmCallback
        public final void onError(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.f24572b).get(String.valueOf(this.f24573c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.f24572b).remove(String.valueOf(this.f24573c));
            if (UPTsmAddon.a(UPTsmAddon.this, this.f24572b).isEmpty()) {
                UPTsmAddon.this.f24564w[this.f24572b] = 0;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // com.unionpay.tsmservice.mi.ITsmCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onResult(Bundle bundle) {
            Parcelable parcelable;
            new Bundle();
            int i10 = this.f24572b;
            Bundle bundle2 = new Bundle();
            Parcel obtain = Parcel.obtain();
            String string = bundle.getString("errorCode");
            String string2 = bundle.getString("result");
            bundle2.putString("errorCode", string);
            if (!TextUtils.isEmpty(string2)) {
                byte[] decode = Base64.decode(UPTsmAddon.d(string2), 0);
                if (!(decode == null || decode.length == 0)) {
                    obtain.unmarshall(decode, 0, decode.length);
                    obtain.setDataPosition(0);
                }
                if (obtain.dataSize() == 0) {
                    bundle2.putString("errorCode", "010035");
                    bundle = bundle2;
                    obtain.recycle();
                    UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.f24572b).get(String.valueOf(this.f24573c)), bundle);
                    UPTsmAddon.a(UPTsmAddon.this, this.f24572b).remove(String.valueOf(this.f24573c));
                    if (!UPTsmAddon.a(UPTsmAddon.this, this.f24572b).isEmpty()) {
                        UPTsmAddon.this.f24564w[this.f24572b] = 0;
                        return;
                    }
                    return;
                }
            }
            switch (i10) {
                case 0:
                    parcelable = (InitResult) obtain.readParcelable(InitResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 1:
                    parcelable = (EncryptDataResult) obtain.readParcelable(EncryptDataResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 2:
                    parcelable = (GetEncryptDataResult) obtain.readParcelable(GetEncryptDataResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 6:
                    parcelable = (AcquireSeAppListResult) obtain.readParcelable(AcquireSeAppListResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 8:
                case 9:
                case 14:
                    parcelable = (VendorPayStatusResult) obtain.readParcelable(VendorPayStatusResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 10:
                    parcelable = (OnlinePaymentVerifyResult) obtain.readParcelable(OnlinePaymentVerifyResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 11:
                    parcelable = (PinRequestResult) obtain.readParcelable(PinRequestResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 12:
                    parcelable = (PayResultNotifyResult) obtain.readParcelable(PinRequestResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 15:
                    parcelable = (GetSeIdResult) obtain.readParcelable(GetSeIdResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 16:
                    parcelable = (AddCardResult) obtain.readParcelable(AddCardResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 17:
                    parcelable = (TransactionDetailsResult) obtain.readParcelable(TransactionDetailsResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
                case 18:
                    parcelable = (MessageDetailsResult) obtain.readParcelable(MessageDetailsResult.class.getClassLoader());
                    bundle2.putParcelable("result", parcelable);
                    bundle = bundle2;
                    break;
            }
            obtain.recycle();
            UPTsmAddon.a((ITsmCallback) UPTsmAddon.a(UPTsmAddon.this, this.f24572b).get(String.valueOf(this.f24573c)), bundle);
            UPTsmAddon.a(UPTsmAddon.this, this.f24572b).remove(String.valueOf(this.f24573c));
            if (!UPTsmAddon.a(UPTsmAddon.this, this.f24572b).isEmpty()) {
            }
        }
    }

    static {
        try {
            System.loadLibrary("uptsmaddonmi");
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
        f24542a = null;
        f24543b = null;
    }

    private UPTsmAddon(Context context) {
        this.f24544c = null;
        Handler.Callback callback = new Handler.Callback() { // from class: com.unionpay.tsmservice.mi.UPTsmAddon.1
            @Override // android.os.Handler.Callback
            public final synchronized boolean handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    UPTsmAddon.a();
                    return true;
                } else if (i10 != 1) {
                    return false;
                } else {
                    UPTsmAddon.b();
                    return true;
                }
            }
        };
        this.f24565x = callback;
        this.f24566y = new Handler(Looper.getMainLooper(), callback);
        this.f24544c = context;
        if (!a(context)) {
            throw new RuntimeException();
        }
    }

    private static int a(int i10, RequestParams requestParams, ITsmCallback iTsmCallback) {
        return new SessionKeyReExchange(f24542a, i10, requestParams, iTsmCallback).reExchangeKey();
    }

    private static int a(int i10, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i11, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        return new SessionKeyReExchange(f24542a, i10, safetyKeyboardRequestParams, i11, onSafetyKeyboardCallback, context).reExchangeKey();
    }

    private static int a(RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        return new SessionKeyReExchange(f24542a, 16, requestParams, iTsmCallback, iTsmProgressCallback).reExchangeKey();
    }

    private static String a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        String c10 = (marshall == null || marshall.length == 0) ? "" : c(Base64.encodeToString(marshall, 0));
        obtain.recycle();
        return c10;
    }

    static /* synthetic */ HashMap a(UPTsmAddon uPTsmAddon, int i10) {
        switch (i10) {
            case 0:
                return uPTsmAddon.f24548g;
            case 1:
                return uPTsmAddon.f24549h;
            case 2:
                return uPTsmAddon.f24550i;
            case 3:
            case 4:
            case 5:
            case 13:
            default:
                return null;
            case 6:
                return uPTsmAddon.f24552k;
            case 7:
                return uPTsmAddon.f24553l;
            case 8:
                return uPTsmAddon.f24554m;
            case 9:
                return uPTsmAddon.f24555n;
            case 10:
                return uPTsmAddon.f24556o;
            case 11:
                return uPTsmAddon.f24557p;
            case 12:
                return uPTsmAddon.f24558q;
            case 14:
                return uPTsmAddon.f24559r;
            case 15:
                return uPTsmAddon.f24560s;
            case 16:
                return uPTsmAddon.f24561t;
            case 17:
                return uPTsmAddon.f24562u;
            case 18:
                return uPTsmAddon.f24563v;
        }
    }

    static /* synthetic */ void a() {
        CopyOnWriteArrayList copyOnWriteArrayList = f24543b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator it = f24543b.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener uPTsmConnectionListener = (UPTsmConnectionListener) it.next();
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmConnected();
                }
            }
        }
    }

    static /* synthetic */ void a(ITsmActivityCallback iTsmActivityCallback, String str, String str2, int i10, Bundle bundle) {
        if (iTsmActivityCallback != null) {
            try {
                iTsmActivityCallback.startActivity(str, str2, i10, bundle);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(ITsmCallback iTsmCallback, Bundle bundle) {
        if (iTsmCallback != null) {
            try {
                String string = bundle.getString("errorCode");
                if ("10000".equals(string)) {
                    iTsmCallback.onResult(bundle);
                } else {
                    iTsmCallback.onError(string, bundle.getString("errorDesc"));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private static boolean a(Context context) {
        try {
            return IUPJniInterface.iJE(context);
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ HashMap b(UPTsmAddon uPTsmAddon, int i10) {
        if (i10 != 1000) {
            return null;
        }
        return uPTsmAddon.f24551j;
    }

    static /* synthetic */ void b() {
        CopyOnWriteArrayList copyOnWriteArrayList = f24543b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator it = f24543b.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener uPTsmConnectionListener = (UPTsmConnectionListener) it.next();
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmDisconnected();
                }
            }
        }
    }

    private static boolean b(String str) {
        try {
            return IUPJniInterface.cSKV(str);
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ String c(UPTsmAddon uPTsmAddon) {
        return uPTsmAddon.f24544c.getPackageName();
    }

    private static String c(String str) {
        try {
            return IUPJniInterface.eMG(str);
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private boolean c() {
        String f10 = f("com.unionpay.tsmservice.mi");
        return f10 != null && f10.compareTo(Constant.APK_VERSION_010002) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        try {
            return IUPJniInterface.dMG(str);
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private boolean e(String str) {
        String f10 = f("com.unionpay.tsmservice.mi");
        return f10 != null && f10.compareTo(str) >= 0;
    }

    private String f(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f24544c.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    private static String g(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("jarVersionCode", 19);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static synchronized UPTsmAddon getInstance(Context context) {
        synchronized (UPTsmAddon.class) {
            if (context == null) {
                return null;
            }
            if (f24542a == null) {
                f24542a = new UPTsmAddon(context.getApplicationContext());
            }
            if (f24543b == null) {
                f24543b = new CopyOnWriteArrayList();
            }
            return f24542a;
        }
    }

    private String h(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("packageName", this.f24544c.getPackageName());
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static boolean isAppRunInBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (TextUtils.equals(runningAppProcessInfo.processName, context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return false;
            }
        }
        return true;
    }

    public synchronized int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            AcquireSEAppListRequestParams acquireSEAppListRequestParams2 = new AcquireSEAppListRequestParams();
            String str = "";
            if (acquireSEAppListRequestParams != null) {
                str = acquireSEAppListRequestParams.getReserve();
                Bundle params = acquireSEAppListRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", a(params));
                    acquireSEAppListRequestParams2.setParams(bundle);
                }
            }
            acquireSEAppListRequestParams2.setReserve(c(h(g(str))));
            this.f24552k.put(String.valueOf(this.f24564w[6]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[6];
                iArr[6] = i11 + 1;
                int acquireSEAppList = iTsmService.acquireSEAppList(acquireSEAppListRequestParams2, new b(this, 6, i11, (byte) 0));
                if (acquireSEAppList != 0) {
                    HashMap hashMap = this.f24552k;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[6] - 1;
                    iArr2[6] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != acquireSEAppList) {
                    return acquireSEAppList;
                }
                return a(6, acquireSEAppListRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(6, acquireSEAppListRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        int i10;
        if (addCardToVendorPayRequestParams == null || iTsmCallback == null) {
            i10 = -3;
        } else if (!e(com.unionpay.tsmservice.data.Constant.SUPPORTED_MIN_APK_VERSION)) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            AddCardToVendorPayRequestParams addCardToVendorPayRequestParams2 = new AddCardToVendorPayRequestParams();
            Bundle params = addCardToVendorPayRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                addCardToVendorPayRequestParams2.setParams(bundle);
            }
            addCardToVendorPayRequestParams2.setReserve(c(h(g(addCardToVendorPayRequestParams.getReserve()))));
            this.f24561t.put(String.valueOf(this.f24564w[16]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[16];
                iArr[16] = i11 + 1;
                int addCardToVendorPay = iTsmService.addCardToVendorPay(addCardToVendorPayRequestParams2, new b(this, 16, i11, (byte) 0), iTsmProgressCallback);
                if (addCardToVendorPay != 0) {
                    HashMap hashMap = this.f24561t;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[16] - 1;
                    iArr2[16] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != addCardToVendorPay) {
                    return addCardToVendorPay;
                }
                return a(addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(addCardToVendorPayRequestParams, iTsmCallback, iTsmProgressCallback);
        }
        return i10;
    }

    public synchronized void addConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            f24543b.add(uPTsmConnectionListener);
        }
    }

    public boolean bind() {
        if (this.f24545d == null) {
            this.f24545d = new ServiceConnection() { // from class: com.unionpay.tsmservice.mi.UPTsmAddon.2
                @Override // android.content.ServiceConnection
                public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    UPTsmAddon.this.f24547f = true;
                    UPTsmAddon.this.f24546e = ITsmService.Stub.asInterface(iBinder);
                    UPTsmAddon.this.f24566y.sendEmptyMessage(0);
                }

                @Override // android.content.ServiceConnection
                public final synchronized void onServiceDisconnected(ComponentName componentName) {
                    UPTsmAddon.this.f24547f = false;
                    UPTsmAddon.this.f24546e = null;
                    UPTsmAddon.this.f24566y.sendEmptyMessage(1);
                }
            };
        }
        if (this.f24547f) {
            return true;
        }
        Intent intent = new Intent("com.unionpay.tsmservice.mi.UPTsmService");
        intent.setPackage("com.unionpay.tsmservice.mi");
        return this.f24544c.bindService(intent, this.f24545d, 1);
    }

    public synchronized int cancelPay() {
        int i10;
        if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            CancelPayRequestParams cancelPayRequestParams = new CancelPayRequestParams();
            cancelPayRequestParams.setReserve(c(h(g(""))));
            try {
                int cancelPay = this.f24546e.cancelPay(cancelPayRequestParams);
                if (-2 != cancelPay) {
                    return cancelPay;
                }
                return a(13, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(13, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        }
        return i10;
    }

    public synchronized int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            CardListStatusChangedRequestParams cardListStatusChangedRequestParams2 = new CardListStatusChangedRequestParams();
            String str = "";
            if (cardListStatusChangedRequestParams != null) {
                str = cardListStatusChangedRequestParams.getReserve();
            }
            cardListStatusChangedRequestParams2.setReserve(c(h(g(str))));
            this.f24553l.put(String.valueOf(this.f24564w[7]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[7];
                iArr[7] = i11 + 1;
                int cardListStatusChanged = iTsmService.cardListStatusChanged(cardListStatusChangedRequestParams2, new b(this, 7, i11, (byte) 0));
                if (cardListStatusChanged != 0) {
                    HashMap hashMap = this.f24553l;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[7] - 1;
                    iArr2[7] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != cardListStatusChanged) {
                    return cardListStatusChanged;
                }
                return a(7, cardListStatusChangedRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(7, cardListStatusChangedRequestParams, iTsmCallback);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:7:0x000a, B:9:0x000e, B:11:0x001c, B:13:0x0022, B:14:0x0038, B:16:0x0040, B:17:0x0048, B:18:0x0049, B:21:0x0052, B:27:0x005b, B:28:0x0063, B:29:0x0064), top: B:42:0x000a, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int clearEncryptData(int i10) {
        int i11;
        int clearEncryptData;
        if (i10 < 2000 || i10 > 2002) {
            i11 = -3;
        } else if (this.f24546e == null) {
            i11 = -1;
        } else if (!b(this.f24544c.getPackageName())) {
            return a(4, (SafetyKeyboardRequestParams) null, i10, (OnSafetyKeyboardCallback) null, (Context) null);
        } else if (c()) {
            ClearEncryptDataRequestParams clearEncryptDataRequestParams = new ClearEncryptDataRequestParams();
            clearEncryptDataRequestParams.setReserve(c(h(g(""))));
            try {
                clearEncryptData = this.f24546e.clearKeyboardEncryptData(clearEncryptDataRequestParams, i10);
                if (-2 == clearEncryptData) {
                    return clearEncryptData;
                }
                return a(4, (SafetyKeyboardRequestParams) null, i10, (OnSafetyKeyboardCallback) null, (Context) null);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            try {
                clearEncryptData = this.f24546e.clearEncryptData(i10);
                if (-2 == clearEncryptData) {
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                throw new RemoteException();
            }
        }
        return i11;
    }

    public synchronized int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) {
        if (encryptDataRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (this.f24546e == null) {
            return -1;
        }
        if (b(this.f24544c.getPackageName())) {
            EncryptDataRequestParams encryptDataRequestParams2 = new EncryptDataRequestParams();
            String reserve = encryptDataRequestParams.getReserve();
            if (c()) {
                reserve = h(g(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                encryptDataRequestParams2.setReserve(c(reserve));
            }
            ArrayList arrayList = (ArrayList) encryptDataRequestParams.getData();
            if (arrayList != null) {
                int size = arrayList.size();
                if (size == 0) {
                    return -3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i10 = 0; i10 < size; i10++) {
                    String str = (String) arrayList.get(i10);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList2.add(c(str));
                    }
                }
                encryptDataRequestParams2.setData(arrayList2);
            }
            this.f24549h.put(String.valueOf(this.f24564w[1]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[1];
                iArr[1] = i11 + 1;
                int encryptData = iTsmService.encryptData(encryptDataRequestParams2, new b(this, 1, i11, (byte) 0));
                if (encryptData != 0) {
                    HashMap hashMap = this.f24549h;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[1] - 1;
                    iArr2[1] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != encryptData) {
                    return encryptData;
                }
                return a(1, encryptDataRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(1, encryptDataRequestParams, iTsmCallback);
        }
    }

    public int exchangeKey(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return -3;
        }
        ITsmService iTsmService = this.f24546e;
        if (iTsmService == null) {
            return -1;
        }
        try {
            return iTsmService.exchangeKey(str, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new RemoteException();
        }
    }

    public Context getContext() {
        return this.f24544c;
    }

    public synchronized int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) {
        if (iTsmCallback == null || getEncryptDataRequestParams == null) {
            return -3;
        }
        int type = getEncryptDataRequestParams.getType();
        String pan = getEncryptDataRequestParams.getPan();
        if (type >= 2000 && type <= 2001) {
            if (type == 2000 && TextUtils.isEmpty(pan)) {
                return -3;
            }
            if (this.f24546e == null) {
                return -1;
            }
            if (b(this.f24544c.getPackageName())) {
                GetEncryptDataRequestParams getEncryptDataRequestParams2 = new GetEncryptDataRequestParams();
                if (type == 2000) {
                    getEncryptDataRequestParams2.setPan(c(pan));
                }
                getEncryptDataRequestParams2.setType(type);
                String reserve = getEncryptDataRequestParams.getReserve();
                if (c()) {
                    reserve = h(g(reserve));
                }
                if (!TextUtils.isEmpty(reserve)) {
                    getEncryptDataRequestParams2.setReserve(c(reserve));
                }
                this.f24550i.put(String.valueOf(this.f24564w[2]), iTsmCallback);
                try {
                    ITsmService iTsmService = this.f24546e;
                    int[] iArr = this.f24564w;
                    int i10 = iArr[2];
                    iArr[2] = i10 + 1;
                    int encryptData = iTsmService.getEncryptData(getEncryptDataRequestParams2, new b(this, 2, i10, (byte) 0));
                    if (encryptData != 0) {
                        HashMap hashMap = this.f24550i;
                        int[] iArr2 = this.f24564w;
                        int i11 = iArr2[2] - 1;
                        iArr2[2] = i11;
                        hashMap.remove(String.valueOf(i11));
                    }
                    if (-2 != encryptData) {
                        return encryptData;
                    }
                    return a(2, getEncryptDataRequestParams, iTsmCallback);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    throw new RemoteException();
                }
            } else {
                return a(2, getEncryptDataRequestParams, iTsmCallback);
            }
        }
        return -3;
    }

    public synchronized int getListenerCount() {
        CopyOnWriteArrayList copyOnWriteArrayList = f24543b;
        if (copyOnWriteArrayList == null) {
            return 0;
        }
        return copyOnWriteArrayList.size();
    }

    public synchronized int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e(com.unionpay.tsmservice.data.Constant.APK_VERSION_010017)) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            GetMessageDetailsRequestParams getMessageDetailsRequestParams2 = new GetMessageDetailsRequestParams();
            String str = "";
            if (getMessageDetailsRequestParams != null) {
                str = getMessageDetailsRequestParams.getReserve();
                Bundle params = getMessageDetailsRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", a(params));
                    getMessageDetailsRequestParams2.setParams(bundle);
                }
            }
            getMessageDetailsRequestParams2.setReserve(c(h(g(str))));
            this.f24563v.put(String.valueOf(this.f24564w[18]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[18];
                iArr[18] = i11 + 1;
                int messageDetails = iTsmService.getMessageDetails(getMessageDetailsRequestParams2, new b(this, 18, i11, (byte) 0));
                if (messageDetails != 0) {
                    HashMap hashMap = this.f24563v;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[18] - 1;
                    iArr2[18] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != messageDetails) {
                    return messageDetails;
                }
                return a(18, getMessageDetailsRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(18, getMessageDetailsRequestParams, iTsmCallback);
        }
        return i10;
    }

    public int getPubKey(int i10, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return -3;
        }
        ITsmService iTsmService = this.f24546e;
        if (iTsmService == null) {
            return -1;
        }
        try {
            return iTsmService.getPubKey(i10, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new RemoteException();
        }
    }

    public synchronized int getSeId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.10")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            GetSeIdRequestParams getSeIdRequestParams2 = new GetSeIdRequestParams();
            String str = "";
            if (getSeIdRequestParams != null) {
                str = getSeIdRequestParams.getReserve();
            }
            getSeIdRequestParams2.setReserve(c(h(g(str))));
            this.f24560s.put(String.valueOf(this.f24564w[15]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[15];
                iArr[15] = i11 + 1;
                int sEId = iTsmService.getSEId(getSeIdRequestParams2, new b(this, 15, i11, (byte) 0));
                if (sEId != 0) {
                    HashMap hashMap = this.f24560s;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[15] - 1;
                    iArr2[15] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != sEId) {
                    return sEId;
                }
                return a(15, getSeIdRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(15, getSeIdRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e(com.unionpay.tsmservice.data.Constant.APK_VERSION_010017)) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            GetTransactionDetailsRequestParams getTransactionDetailsRequestParams2 = new GetTransactionDetailsRequestParams();
            String str = "";
            if (getTransactionDetailsRequestParams != null) {
                str = getTransactionDetailsRequestParams.getReserve();
                Bundle params = getTransactionDetailsRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", a(params));
                    getTransactionDetailsRequestParams2.setParams(bundle);
                }
            }
            getTransactionDetailsRequestParams2.setReserve(c(h(g(str))));
            this.f24562u.put(String.valueOf(this.f24564w[17]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[17];
                iArr[17] = i11 + 1;
                int transactionDetails = iTsmService.getTransactionDetails(getTransactionDetailsRequestParams2, new b(this, 17, i11, (byte) 0));
                if (transactionDetails != 0) {
                    HashMap hashMap = this.f24562u;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[17] - 1;
                    iArr2[17] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != transactionDetails) {
                    return transactionDetails;
                }
                return a(17, getTransactionDetailsRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(17, getTransactionDetailsRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
            String str = "";
            if (getVendorPayStatusRequestParams != null) {
                str = getVendorPayStatusRequestParams.getReserve();
            }
            getVendorPayStatusRequestParams2.setReserve(c(h(g(str))));
            this.f24555n.put(String.valueOf(this.f24564w[9]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[9];
                iArr[9] = i11 + 1;
                int vendorPayStatus = iTsmService.getVendorPayStatus(getVendorPayStatusRequestParams2, new b(this, 9, i11, (byte) 0));
                if (vendorPayStatus != 0) {
                    HashMap hashMap = this.f24555n;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[9] - 1;
                    iArr2[9] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != vendorPayStatus) {
                    return vendorPayStatus;
                }
                return a(9, getVendorPayStatusRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(9, getVendorPayStatusRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.09")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = new GetVendorPayStatusRequestParams();
            String str = "";
            if (getVendorPayStatusRequestParams != null) {
                str = getVendorPayStatusRequestParams.getReserve();
            }
            getVendorPayStatusRequestParams2.setReserve(c(h(g(str))));
            this.f24559r.put(String.valueOf(this.f24564w[14]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[14];
                iArr[14] = i11 + 1;
                int vendorPayStatusForBankApp = iTsmService.getVendorPayStatusForBankApp(getVendorPayStatusRequestParams2, new b(this, 14, i11, (byte) 0));
                if (vendorPayStatusForBankApp != 0) {
                    HashMap hashMap = this.f24559r;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[14] - 1;
                    iArr2[14] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != vendorPayStatusForBankApp) {
                    return vendorPayStatusForBankApp;
                }
                return a(14, getVendorPayStatusRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(14, getVendorPayStatusRequestParams, iTsmCallback);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: all -> 0x0065, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0014, B:9:0x001a, B:10:0x0030, B:12:0x0038, B:13:0x0040, B:14:0x0041, B:17:0x004a, B:23:0x0053, B:24:0x005b, B:25:0x005c), top: B:33:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int hideKeyboard() {
        int hideKeyboard;
        if (this.f24546e == null) {
            return -1;
        }
        if (!b(this.f24544c.getPackageName())) {
            return a(5, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
        } else if (c()) {
            HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams = new HideSafetyKeyboardRequestParams();
            hideSafetyKeyboardRequestParams.setReserve(c(h(g(""))));
            try {
                hideKeyboard = this.f24546e.hideSafetyKeyboard(hideSafetyKeyboardRequestParams);
                if (-2 == hideKeyboard) {
                    return hideKeyboard;
                }
                return a(5, (SafetyKeyboardRequestParams) null, 0, (OnSafetyKeyboardCallback) null, (Context) null);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            try {
                hideKeyboard = this.f24546e.hideKeyboard();
                if (-2 == hideKeyboard) {
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                throw new RemoteException();
            }
        }
    }

    public synchronized int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            InitRequestParams initRequestParams2 = new InitRequestParams();
            String str = "";
            if (initRequestParams != null) {
                str = initRequestParams.getReserve();
                String signature = initRequestParams.getSignature();
                if (!TextUtils.isEmpty(signature)) {
                    initRequestParams2.setSignature(c(signature));
                }
            }
            if (c()) {
                str = h(g(str));
            }
            if (!TextUtils.isEmpty(str)) {
                initRequestParams2.setReserve(c(str));
            }
            this.f24548g.put(String.valueOf(this.f24564w[0]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[0];
                iArr[0] = i11 + 1;
                int init = iTsmService.init(initRequestParams2, new b(this, 0, i11, (byte) 0));
                if (init != 0) {
                    HashMap hashMap = this.f24548g;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[0] - 1;
                    iArr2[0] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != init) {
                    return init;
                }
                return a(0, initRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(0, initRequestParams, iTsmCallback);
        }
        return i10;
    }

    public boolean isConnected() {
        return this.f24547f;
    }

    public synchronized int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (onlinePaymentVerifyRequestParams == null || iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams2 = new OnlinePaymentVerifyRequestParams();
            Bundle params = onlinePaymentVerifyRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                onlinePaymentVerifyRequestParams2.setParams(bundle);
            }
            onlinePaymentVerifyRequestParams2.setReserve(c(h(g(onlinePaymentVerifyRequestParams.getReserve()))));
            this.f24556o.put(String.valueOf(this.f24564w[10]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[10];
                iArr[10] = i11 + 1;
                int onlinePaymentVerify = iTsmService.onlinePaymentVerify(onlinePaymentVerifyRequestParams2, new b(this, 10, i11, (byte) 0));
                if (onlinePaymentVerify != 0) {
                    HashMap hashMap = this.f24556o;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[10] - 1;
                    iArr2[10] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != onlinePaymentVerify) {
                    return onlinePaymentVerify;
                }
                return a(10, onlinePaymentVerifyRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(10, onlinePaymentVerifyRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (payResultNotifyRequestParams == null || iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            PayResultNotifyRequestParams payResultNotifyRequestParams2 = new PayResultNotifyRequestParams();
            Bundle params = payResultNotifyRequestParams.getParams();
            if (params != null) {
                Bundle bundle = new Bundle();
                bundle.putString("encryptData", a(params));
                payResultNotifyRequestParams2.setParams(bundle);
            }
            payResultNotifyRequestParams2.setReserve(c(h(g(payResultNotifyRequestParams.getReserve()))));
            this.f24558q.put(String.valueOf(this.f24564w[12]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[12];
                iArr[12] = i11 + 1;
                int payResultNotify = iTsmService.payResultNotify(payResultNotifyRequestParams2, new b(this, 12, i11, (byte) 0));
                if (payResultNotify != 0) {
                    HashMap hashMap = this.f24558q;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[12] - 1;
                    iArr2[12] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != payResultNotify) {
                    return payResultNotify;
                }
                return a(12, payResultNotifyRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(12, payResultNotifyRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.08")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            PinRequestRequestParams pinRequestRequestParams2 = new PinRequestRequestParams();
            String str = "";
            if (pinRequestRequestParams != null) {
                str = pinRequestRequestParams.getReserve();
                Bundle params = pinRequestRequestParams.getParams();
                if (params != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("encryptData", a(params));
                    pinRequestRequestParams2.setParams(bundle);
                }
            }
            pinRequestRequestParams2.setReserve(c(h(g(str))));
            this.f24557p.put(String.valueOf(this.f24564w[11]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[11];
                iArr[11] = i11 + 1;
                int pinRequest = iTsmService.pinRequest(pinRequestRequestParams2, new b(this, 11, i11, (byte) 0));
                if (pinRequest != 0) {
                    HashMap hashMap = this.f24557p;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[11] - 1;
                    iArr2[11] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != pinRequest) {
                    return pinRequest;
                }
                return a(11, pinRequestRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(11, pinRequestRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
        int i10;
        if (iTsmCallback == null) {
            i10 = -3;
        } else if (!e("01.00.07")) {
            i10 = -8;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams2 = new QueryVendorPayStatusRequestParams();
            String str = "";
            if (queryVendorPayStatusRequestParams != null) {
                str = queryVendorPayStatusRequestParams.getReserve();
            }
            queryVendorPayStatusRequestParams2.setReserve(c(h(g(str))));
            this.f24554m.put(String.valueOf(this.f24564w[8]), iTsmCallback);
            try {
                ITsmService iTsmService = this.f24546e;
                int[] iArr = this.f24564w;
                int i11 = iArr[8];
                iArr[8] = i11 + 1;
                int queryVendorPayStatus = iTsmService.queryVendorPayStatus(queryVendorPayStatusRequestParams2, new b(this, 8, i11, (byte) 0));
                if (queryVendorPayStatus != 0) {
                    HashMap hashMap = this.f24554m;
                    int[] iArr2 = this.f24564w;
                    int i12 = iArr2[8] - 1;
                    iArr2[8] = i12;
                    hashMap.remove(String.valueOf(i12));
                }
                if (-2 != queryVendorPayStatus) {
                    return queryVendorPayStatus;
                }
                return a(8, queryVendorPayStatusRequestParams, iTsmCallback);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(8, queryVendorPayStatusRequestParams, iTsmCallback);
        }
        return i10;
    }

    public synchronized void removeConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            f24543b.remove(uPTsmConnectionListener);
        }
    }

    public synchronized int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
        int i10;
        if (safetyKeyboardRequestParams == null) {
            i10 = -3;
        } else if (this.f24546e == null) {
            i10 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            String reserve = safetyKeyboardRequestParams.getReserve();
            if (c()) {
                reserve = h(g(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                safetyKeyboardRequestParams.setReserve(c(reserve));
            }
            try {
                int safetyKeyboardBitmap = this.f24546e.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                if (-2 != safetyKeyboardBitmap) {
                    return safetyKeyboardBitmap;
                }
                return a(3, safetyKeyboardRequestParams, (ITsmCallback) null);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(3, safetyKeyboardRequestParams, (ITsmCallback) null);
        }
        return i10;
    }

    public synchronized int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i10, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        int i11;
        if (safetyKeyboardRequestParams == null || i10 < 2000 || i10 > 2002) {
            i11 = -3;
        } else if (this.f24546e == null) {
            i11 = -1;
        } else if (b(this.f24544c.getPackageName())) {
            this.f24551j.put(this.f24544c.getPackageName(), new com.unionpay.tsmservice.mi.a(context));
            String reserve = safetyKeyboardRequestParams.getReserve();
            if (c()) {
                reserve = h(g(reserve));
            }
            if (!TextUtils.isEmpty(reserve)) {
                safetyKeyboardRequestParams.setReserve(c(reserve));
            }
            try {
                int showSafetyKeyboard = this.f24546e.showSafetyKeyboard(safetyKeyboardRequestParams, i10, onSafetyKeyboardCallback, new a());
                if (showSafetyKeyboard != 0) {
                    this.f24551j.remove(this.f24544c.getPackageName());
                }
                if (-2 != showSafetyKeyboard) {
                    return showSafetyKeyboard;
                }
                return a(1000, safetyKeyboardRequestParams, i10, onSafetyKeyboardCallback, context);
            } catch (Exception e10) {
                e10.printStackTrace();
                throw new RemoteException();
            }
        } else {
            return a(1000, safetyKeyboardRequestParams, i10, onSafetyKeyboardCallback, context);
        }
        return i11;
    }

    public void unbind() {
        ServiceConnection serviceConnection = this.f24545d;
        if (serviceConnection != null && this.f24547f) {
            this.f24544c.unbindService(serviceConnection);
            this.f24547f = false;
        }
    }
}
