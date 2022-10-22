package com.unionpay.mobile.android.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.m;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class BaseActivity extends Activity implements com.unionpay.mobile.android.plugin.a, b {
    public static IntentFilter[] FILTERS;
    public static String[][] TECHLISTS;

    /* renamed from: f  reason: collision with root package name */
    private static int f23851f;

    /* renamed from: c  reason: collision with root package name */
    protected NfcAdapter f23854c;

    /* renamed from: g  reason: collision with root package name */
    private PendingIntent f23857g;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<b> f23853b = null;

    /* renamed from: a  reason: collision with root package name */
    private l f23852a = null;

    /* renamed from: d  reason: collision with root package name */
    private a f23855d = null;

    /* renamed from: e  reason: collision with root package name */
    private m f23856e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public com.unionpay.mobile.android.model.b f23858a;

        /* renamed from: b  reason: collision with root package name */
        public UPPayEngine f23859b;

        public a(UPPayEngine uPPayEngine) {
            this.f23858a = null;
            this.f23859b = null;
            com.unionpay.mobile.android.model.b bVar = new com.unionpay.mobile.android.model.b();
            this.f23858a = bVar;
            this.f23859b = uPPayEngine;
            uPPayEngine.a(bVar);
        }
    }

    static {
        try {
            TECHLISTS = new String[][]{new String[]{IsoDep.class.getName()}, new String[]{NfcV.class.getName()}, new String[]{NfcF.class.getName()}};
            FILTERS = new IntentFilter[]{new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*")};
        } catch (Exception unused) {
        }
    }

    public Object a(String str) {
        if (str == null) {
            return this.f23855d.f23858a;
        }
        if (str.equalsIgnoreCase(UPPayEngine.class.toString())) {
            return this.f23855d.f23859b;
        }
        if (str.equalsIgnoreCase(m.class.toString())) {
            return this.f23856e;
        }
        return null;
    }

    public final void a(int i10) {
        ArrayList<b> arrayList = this.f23853b;
        if (arrayList != null) {
            int size = arrayList.size() - 1;
            this.f23853b.get(size);
            while (size >= 0) {
                b bVar = this.f23853b.get(size);
                if (bVar.g() == i10) {
                    setContentView(bVar);
                    return;
                } else {
                    this.f23853b.remove(size);
                    size--;
                }
            }
        }
    }

    public final void a(b bVar) {
        ArrayList<b> arrayList = this.f23853b;
        if (arrayList != null) {
            int size = arrayList.size();
            if (size > 0) {
                this.f23853b.get(size - 1);
            }
            this.f23853b.add(bVar);
            setContentView(bVar);
        }
    }

    public boolean a() {
        return false;
    }

    public final void b() {
        int size;
        ArrayList<b> arrayList;
        ArrayList<b> arrayList2;
        ArrayList<b> arrayList3 = this.f23853b;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            int i10 = size - 1;
            this.f23853b.get(i10);
            this.f23853b.get(i10);
            this.f23853b.remove(i10);
            if (this.f23853b.size() != 0) {
                this.f23853b.get(arrayList.size() - 1);
                setContentView(this.f23853b.get(arrayList2.size() - 1));
            }
        }
    }

    public final String c() {
        return this.f23855d.f23858a.f23497a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        try {
            Resources resources = super.getResources();
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return resources;
        } catch (Exception unused) {
            return super.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        l lVar = this.f23852a;
        if (lVar != null) {
            lVar.u();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        k.a("uppay", "PayActivityEx.onCreate() +++");
        c.a();
        com.unionpay.mobile.android.global.a.a(this);
        this.f23853b = new ArrayList<>(1);
        this.f23855d = new a(d());
        this.f23856e = new m(this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        l lVar = (l) a(1, null);
        this.f23852a = lVar;
        setContentView(lVar);
        getWindow().addFlags(8192);
        f23851f++;
        k.a("uppay", "PayActivityEx.onCreate() ---");
        if (a()) {
            this.f23854c = NfcAdapter.getDefaultAdapter(this);
            this.f23857g = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0);
            onNewIntent(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        ArrayList<b> arrayList = this.f23853b;
        if (arrayList != null) {
            arrayList.clear();
        }
        l lVar = this.f23852a;
        if (lVar != null) {
            lVar.x();
        }
        this.f23852a = null;
        com.unionpay.mobile.android.model.b.f23493bl = false;
        com.unionpay.mobile.android.model.b.f23492bb = null;
        com.unionpay.mobile.android.model.b.f23494bm = false;
        int i10 = f23851f - 1;
        f23851f = i10;
        if (i10 == 0) {
            com.unionpay.mobile.android.resource.c.a(this).a();
        }
        this.f23856e.c();
        this.f23856e = null;
        a aVar = this.f23855d;
        aVar.f23859b = null;
        aVar.f23858a = null;
        this.f23855d = null;
        ((ViewGroup) getWindow().getDecorView().findViewById(16908290)).removeAllViews();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        ArrayList<b> arrayList = this.f23853b;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<b> arrayList2 = this.f23853b;
            arrayList2.get(arrayList2.size() - 1).k();
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        NfcAdapter nfcAdapter;
        super.onPause();
        if (a() && (nfcAdapter = this.f23854c) != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        NfcAdapter nfcAdapter;
        super.onResume();
        if (this.f23856e.a()) {
            this.f23856e.b();
        }
        if (a() && (nfcAdapter = this.f23854c) != null) {
            nfcAdapter.enableForegroundDispatch(this, this.f23857g, FILTERS, TECHLISTS);
        }
    }
}
