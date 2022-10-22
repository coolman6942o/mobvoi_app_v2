package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.mobvoi.wear.contacts.ContactConstant;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.af;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ao;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.at;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.av;
import com.unionpay.mobile.android.widgets.bd;
import com.unionpay.mobile.android.widgets.e;
import com.unionpay.mobile.android.widgets.f;
import com.unionpay.mobile.android.widgets.g;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends LinearLayout implements q.a, aa.a, ah.a, aj.a, ap.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f23985a;

    /* renamed from: b  reason: collision with root package name */
    private m f23986b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<z> f23987c;

    /* renamed from: d  reason: collision with root package name */
    private long f23988d;

    /* renamed from: e  reason: collision with root package name */
    private b f23989e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23990f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23991g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f23992h;

    /* renamed from: i  reason: collision with root package name */
    private String f23993i;

    /* renamed from: com.unionpay.mobile.android.upviews.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0266a {

        /* renamed from: a  reason: collision with root package name */
        public int f23994a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f23995b;

        C0266a(String str) {
            this.f23995b = str;
        }

        public final void a(int i10, String str) {
            this.f23995b = str;
            this.f23994a = i10;
        }

        public final boolean a() {
            return this.f23994a == 0;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(C0266a aVar);

        void a(boolean z10);

        void c(String str);

        void c(String str, String str2);

        void r();
    }

    public a(Context context, JSONArray jSONArray, long j10, b bVar, String str, boolean z10, String str2) {
        this(context, jSONArray, j10, bVar, str, z10, str2, (byte) 0);
    }

    private a(Context context, JSONArray jSONArray, long j10, b bVar, String str, boolean z10, String str2, byte b10) {
        this(context, jSONArray, j10, bVar, str, z10, str2, (char) 0);
    }

    private a(Context context, JSONArray jSONArray, long j10, b bVar, String str, boolean z10, String str2, char c10) {
        this(context, jSONArray, j10, bVar, str, z10, false, null, null, str2);
    }

    public a(Context context, JSONArray jSONArray, long j10, b bVar, String str, boolean z10, boolean z11, z zVar, JSONArray jSONArray2, String str2) {
        super(context);
        this.f23985a = null;
        this.f23986b = null;
        this.f23987c = null;
        this.f23988d = 0L;
        this.f23989e = null;
        this.f23990f = false;
        this.f23991g = true;
        this.f23992h = null;
        this.f23993i = "";
        this.f23985a = context;
        this.f23988d = j10;
        this.f23989e = bVar;
        this.f23990f = z11;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i10 = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams.bottomMargin = i10;
        layoutParams.topMargin = i10;
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        setOrientation(1);
        setBackgroundColor(0);
        a(jSONArray, str, z10, zVar, jSONArray2, str2);
    }

    public a(Context context, JSONArray jSONArray, b bVar, String str) {
        this(context, jSONArray, -1L, bVar, null, true, str);
    }

    private C0266a a(boolean z10) {
        String format;
        String format2;
        C0266a aVar = new C0266a("");
        ArrayList<z> arrayList = this.f23987c;
        if (arrayList != null) {
            Iterator<z> it = arrayList.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (!(next instanceof af)) {
                    if (!next.c()) {
                        format2 = String.format(c.bD.aC, next.r());
                    } else if (!next.b()) {
                        format2 = String.format(c.bD.aD, next.r());
                    }
                    aVar.a(-1, format2);
                    break;
                }
                if (!next.c()) {
                    c cVar = c.bD;
                    format = String.format(cVar.aC, cVar.aE);
                } else if (!next.b()) {
                    c cVar2 = c.bD;
                    format = String.format(cVar2.aD, cVar2.aE);
                }
                aVar.a(-1, format);
            }
        }
        if (!aVar.a()) {
            return aVar;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f23987c != null) {
            for (int i10 = 0; i10 < this.f23987c.size(); i10++) {
                z zVar = this.f23987c.get(i10);
                if (!(zVar instanceof ad) && ((!(zVar instanceof UPWidget) || z10) && !TextUtils.isEmpty(this.f23987c.get(i10).h()) && this.f23987c.get(i10).f())) {
                    stringBuffer.append(",");
                    stringBuffer.append(this.f23987c.get(i10).h());
                }
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            stringBuffer2 = stringBuffer2.substring(1);
        }
        aVar.a(0, stringBuffer2);
        return aVar;
    }

    private static z a(List<z> list, String str) {
        for (z zVar : list) {
            if (zVar.n().equalsIgnoreCase(str)) {
                return zVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0266a a() {
        String format;
        C0266a aVar = new C0266a("");
        z a10 = a(this.f23987c, Constant.KEY_PIN);
        if (a10 != null) {
            if (!a10.c()) {
                format = String.format(c.bD.aC, a10.r());
            } else {
                if (!a10.b()) {
                    format = String.format(c.bD.aD, a10.r());
                }
                if (aVar.a()) {
                    return aVar;
                }
                aVar.f23995b = a10.a();
            }
            aVar.a(-1, format);
            if (aVar.a()) {
            }
        }
        return aVar;
    }

    public final String a(String str) {
        z a10 = a(this.f23987c, str);
        String h10 = a10 != null ? a10.h() : "";
        k.a("uppay", " name:" + str + ", value:" + h10);
        return h10;
    }

    public final void a(int i10) {
        z a10 = a(this.f23987c, "sms");
        if (a10 != null) {
            ((ap) a10).a(i10);
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        z c10 = c("promotion");
        if (c10 != null && (c10 instanceof aj)) {
            ((aj) c10).b(onClickListener);
        }
    }

    public final void a(m mVar, JSONObject jSONObject) {
        this.f23986b = mVar;
        this.f23992h = jSONObject;
    }

    @Override // com.unionpay.mobile.android.widgets.aa.a
    public final void a(u uVar, String str) {
        if (this.f23989e != null) {
            boolean z10 = true;
            if (str != null && str.length() > 0) {
                ArrayList<z> arrayList = this.f23987c;
                if (arrayList != null) {
                    Iterator<z> it = arrayList.iterator();
                    while (it.hasNext()) {
                        z next = it.next();
                        if (next instanceof aa) {
                            aa aaVar = (aa) next;
                            if (!aaVar.a(uVar) && !aaVar.c()) {
                                break;
                            }
                        }
                    }
                }
                z10 = false;
            }
            this.f23989e.a(z10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    @Override // com.unionpay.mobile.android.widgets.ap.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(z zVar) {
        String str;
        String format;
        String format2;
        boolean z10 = zVar instanceof ap;
        if (this.f23989e != null && z10) {
            d();
            String str2 = "";
            C0266a aVar = new C0266a(str2);
            z a10 = a(this.f23987c, "mobile");
            z a11 = a(this.f23987c, Constant.KEY_PAN);
            z a12 = a(this.f23987c, "card");
            z a13 = a(this.f23987c, "area_code");
            if (a11 != null) {
                if (!a11.c()) {
                    c cVar = c.bD;
                    format2 = String.format(cVar.aC, cVar.aE);
                } else if (!a11.b()) {
                    c cVar2 = c.bD;
                    format2 = String.format(cVar2.aD, cVar2.aE);
                } else {
                    str = str2 + a11.h();
                    if (aVar.a()) {
                        if (a10 != null) {
                            if (!a10.c()) {
                                format = String.format(c.bD.aC, a10.r());
                            } else if (!a10.b()) {
                                format = String.format(c.bD.aD, a10.r());
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append(str.length() == 0 ? str2 : ",");
                                str = sb2.toString() + a10.h();
                            }
                            aVar.a(-1, format);
                        }
                        if (aVar.a()) {
                            if (a12 != null && a12.h().length() > 0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str);
                                sb3.append(str.length() == 0 ? str2 : ",");
                                str = sb3.toString() + a12.h();
                            }
                            if (a13 != null && a13.h().length() > 0) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str);
                                if (str.length() != 0) {
                                    str2 = ",";
                                }
                                sb4.append(str2);
                                str = sb4.toString() + a13.h();
                            }
                            aVar.a(0, str);
                        }
                    }
                    this.f23989e.a(aVar);
                }
                aVar.a(-1, format2);
            }
            str = str2;
            if (aVar.a()) {
            }
            this.f23989e.a(aVar);
        }
    }

    @Override // com.unionpay.mobile.android.upwidget.q.a
    public final void a(String str, String str2) {
        if (this.f23989e != null) {
            d();
            this.f23989e.c(str, str2);
        }
    }

    @Override // com.unionpay.mobile.android.upwidget.q.a
    public final void a(String str, boolean z10) {
        String str2 = "promotion";
        if (str2.equalsIgnoreCase(str)) {
            str2 = "instalment";
        }
        z c10 = c(str);
        z c11 = c(str2);
        if (c10 != null) {
            if (c10 instanceof aj) {
                ((aj) c10).a(z10);
                if (c11 != null) {
                    p pVar = (p) c11;
                    if (pVar.g()) {
                        Toast.makeText(this.f23985a, this.f23993i, 1).show();
                        pVar.b(false);
                    }
                }
            } else if (c10 instanceof p) {
                if (z10) {
                    this.f23989e.r();
                }
                ((p) c10).b(z10);
            }
        }
    }

    public final void a(JSONArray jSONArray) {
        z c10 = c("promotion");
        if (c10 != null && (c10 instanceof aj)) {
            ((aj) c10).a(jSONArray);
        }
    }

    public final void a(JSONArray jSONArray, String str) {
        z c10 = c("promotion");
        if (c10 != null && (c10 instanceof aj)) {
            ((aj) c10).a(jSONArray, str);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(4:157|13|145|14)|(1:16)(2:19|(1:21)(8:22|(5:149|24|25|159|26)(9:29|(1:31)(2:33|(1:35)(7:36|(5:153|38|39|155|40)(8:42|(1:44)(2:46|(1:48)(2:49|(1:51)(2:52|(1:54)(2:55|(1:57)(2:58|(1:60)(2:61|(1:63)(2:64|(1:66)(2:67|(1:69)(2:70|(1:72)(2:73|(1:75)(7:76|(4:78|79|147|80)(1:81)|151|82|83|(8:94|(1:96)(2:97|(1:99)(2:100|(1:102)))|103|(1:107)|108|(10:110|(1:112)(2:113|(5:115|117|(2:125|(2:127|(1:130)))(3:121|(1:123)|124)|131|(1:136)(1:135)))|116|117|(0)|125|(0)|131|(1:133)|136)(1:137)|138|163)(2:139|162)|140)))))))))))|45|151|82|83|(0)(0)|140)|89|90|92|(0)(0)|140))|32|18|151|82|83|(0)(0)|140)|27|151|82|83|(0)(0)|140))|17|18|151|82|83|(0)(0)|140|11) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a9, code lost:
        r4 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONArray jSONArray, String str, boolean z10, z zVar, JSONArray jSONArray2, String str2) {
        int i10;
        int i11;
        ViewGroup.LayoutParams layoutParams;
        String str3;
        aj ajVar;
        String str4;
        int i12;
        int i13;
        boolean z11;
        ah ahVar;
        JSONObject jSONObject;
        String a10;
        Context context;
        String a11;
        aj ajVar2;
        z apVar;
        at atVar;
        e eVar;
        z zVar2;
        af afVar;
        JSONArray jSONArray3 = jSONArray;
        if (jSONArray3 != null && jSONArray.length() > 0) {
            ArrayList<z> arrayList = this.f23987c;
            if (arrayList == null) {
                this.f23987c = new ArrayList<>(1);
            } else {
                arrayList.clear();
            }
            removeAllViews();
            int i14 = -1;
            setBackgroundColor(-1);
            int i15 = -2;
            new LinearLayout.LayoutParams(-1, -2);
            int i16 = com.unionpay.mobile.android.global.a.I - (com.unionpay.mobile.android.global.a.f23315f * 4);
            int i17 = 0;
            String str5 = "";
            ViewGroup.LayoutParams layoutParams2 = null;
            while (i17 < jSONArray.length()) {
                try {
                    jSONObject = jSONArray3.getJSONObject(i17);
                    a10 = j.a(jSONObject, "type");
                    try {
                        context = this.f23985a;
                        a11 = j.a(jSONObject, "type");
                    } catch (JSONException unused) {
                        i10 = i17;
                    }
                } catch (JSONException unused2) {
                    i10 = i17;
                    i11 = i16;
                    ahVar = null;
                }
                if (Constant.KEY_PAN.equalsIgnoreCase(a11)) {
                    afVar = new af(context, i16, jSONObject, str2);
                } else if ("mobile".equalsIgnoreCase(a11)) {
                    afVar = new ah(context, i16, jSONObject, str2);
                } else {
                    if ("sms".equalsIgnoreCase(a11)) {
                        try {
                            i10 = i17;
                        } catch (JSONException unused3) {
                            i10 = i17;
                        }
                        try {
                            apVar = new ap(context, i16, jSONObject, str2, (byte) 0);
                            i11 = i16;
                        } catch (JSONException unused4) {
                            i11 = i16;
                            ahVar = null;
                            str5 = a10;
                            k.c("uppay", "json parser exception!!! - UPRuleView");
                            layoutParams = layoutParams2;
                            ajVar = ahVar;
                            str3 = str5;
                            if (ajVar == null) {
                            }
                            i17 = i13 + 1;
                            layoutParams2 = layoutParams;
                            i16 = i11;
                            i14 = i12;
                            str5 = str4;
                            i15 = -2;
                            jSONArray3 = jSONArray;
                        }
                    } else {
                        i10 = i17;
                        if (Constant.KEY_CVN2.equalsIgnoreCase(a11)) {
                            eVar = new e(context, i16, jSONObject, str2);
                        } else if ("expire".equalsIgnoreCase(a11)) {
                            eVar = new av(context, i16, jSONObject, str2);
                        } else {
                            if ("pwd".equalsIgnoreCase(a11)) {
                                try {
                                    i11 = i16;
                                } catch (JSONException unused5) {
                                    i11 = i16;
                                }
                                try {
                                    apVar = new UPWidget(context, this.f23988d, i16, jSONObject, str2);
                                } catch (JSONException unused6) {
                                    ahVar = null;
                                    str5 = a10;
                                    k.c("uppay", "json parser exception!!! - UPRuleView");
                                    layoutParams = layoutParams2;
                                    ajVar = ahVar;
                                    str3 = str5;
                                    if (ajVar == null) {
                                    }
                                    i17 = i13 + 1;
                                    layoutParams2 = layoutParams;
                                    i16 = i11;
                                    i14 = i12;
                                    str5 = str4;
                                    i15 = -2;
                                    jSONArray3 = jSONArray;
                                }
                            } else {
                                i11 = i16;
                                if ("text".equalsIgnoreCase(a11)) {
                                    atVar = new at(context, i11, jSONObject, str2);
                                } else if ("string".equalsIgnoreCase(a11)) {
                                    atVar = new ad(context, jSONObject, str2);
                                } else if ("cert_id".equalsIgnoreCase(a11)) {
                                    atVar = new f(context, i11, jSONObject, str2);
                                } else if ("cert_type".equalsIgnoreCase(a11)) {
                                    atVar = new g(context, jSONObject, str2);
                                } else if (ContactConstant.CallsRecordKeys.NAME.equalsIgnoreCase(a11)) {
                                    atVar = new ae(context, i11, jSONObject, str2);
                                } else if ("hidden".equalsIgnoreCase(a11)) {
                                    atVar = new y(context, jSONObject, str2);
                                } else if ("user_name".equalsIgnoreCase(a11)) {
                                    atVar = new au(context, i11, jSONObject, str2);
                                } else if ("password".equalsIgnoreCase(a11)) {
                                    atVar = new ao(context, i11, jSONObject, str2);
                                } else if ("point".equalsIgnoreCase(a11)) {
                                    atVar = new bd(context, i11, jSONObject, str2);
                                } else if ("instalment".equalsIgnoreCase(a11)) {
                                    p pVar = new p(this.f23985a, jSONObject, str2);
                                    pVar.a(this);
                                    atVar = pVar;
                                } else if ("promotion".equalsIgnoreCase(a11)) {
                                    aj ajVar3 = new aj(this.f23985a, jSONObject, str2, this);
                                    ajVar3.a(this);
                                    atVar = ajVar3;
                                } else {
                                    if ("area_code".equalsIgnoreCase(a11)) {
                                        try {
                                            ajVar2 = new com.unionpay.mobile.android.widgets.a(this.f23985a, jSONObject, jSONArray2, str2);
                                        } catch (JSONException unused7) {
                                        }
                                    } else {
                                        ajVar2 = null;
                                    }
                                    layoutParams = new LinearLayout.LayoutParams(i14, i15);
                                    str3 = a10;
                                    ajVar = ajVar2;
                                    if (ajVar == null) {
                                        if (ajVar instanceof UPWidget) {
                                            UPWidget uPWidget = (UPWidget) ajVar;
                                            uPWidget.a(this.f23988d);
                                            uPWidget.b(str);
                                            uPWidget.b(z10);
                                        } else if (ajVar instanceof ap) {
                                            ((ap) ajVar).a((ap.a) this);
                                        } else if (ajVar instanceof ah) {
                                            ajVar.a((ah.a) this);
                                        }
                                        if ((ajVar instanceof aa) && !(ajVar instanceof bd)) {
                                            ajVar.a((aa.a) this);
                                        }
                                        if (!"instalment".equals(str3)) {
                                            LinearLayout linearLayout = new LinearLayout(this.f23985a);
                                            linearLayout.setBackgroundColor(-3419943);
                                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i14, 1);
                                            i13 = i10;
                                            str4 = str3;
                                            if (i13 != 0) {
                                                layoutParams3.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f23985a, 10.0f);
                                            } else if (this.f23990f) {
                                                layoutParams3.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f23985a, 10.0f);
                                                setPadding(0, 0, 0, 0);
                                                if (!this.f23990f && i13 == 0 && zVar != null) {
                                                    addView(zVar, layoutParams);
                                                    if (ajVar.getVisibility() == 0) {
                                                        addView(linearLayout, layoutParams3);
                                                    }
                                                    addView(ajVar, layoutParams);
                                                } else if (ajVar.getVisibility() == 0) {
                                                    addView(linearLayout, layoutParams3);
                                                    addView(ajVar, layoutParams);
                                                    if ((ajVar instanceof af) && zVar != null) {
                                                        addView(zVar, layoutParams);
                                                    }
                                                }
                                                if (i13 != jSONArray.length() - 1 || (ajVar instanceof aj)) {
                                                    LinearLayout linearLayout2 = new LinearLayout(this.f23985a);
                                                    linearLayout2.setBackgroundColor(-3419943);
                                                    z11 = true;
                                                    i12 = -1;
                                                    addView(linearLayout2, new LinearLayout.LayoutParams(-1, 1));
                                                } else {
                                                    z11 = true;
                                                    i12 = -1;
                                                }
                                            }
                                            if (!this.f23990f) {
                                            }
                                            if (ajVar.getVisibility() == 0) {
                                            }
                                            if (i13 != jSONArray.length() - 1) {
                                            }
                                            LinearLayout linearLayout22 = new LinearLayout(this.f23985a);
                                            linearLayout22.setBackgroundColor(-3419943);
                                            z11 = true;
                                            i12 = -1;
                                            addView(linearLayout22, new LinearLayout.LayoutParams(-1, 1));
                                        } else {
                                            str4 = str3;
                                            i12 = i14;
                                            i13 = i10;
                                            z11 = true;
                                        }
                                        this.f23987c.add(ajVar);
                                    } else {
                                        str4 = str3;
                                        i12 = i14;
                                        i13 = i10;
                                        z11 = true;
                                    }
                                    i17 = i13 + 1;
                                    layoutParams2 = layoutParams;
                                    i16 = i11;
                                    i14 = i12;
                                    str5 = str4;
                                    i15 = -2;
                                    jSONArray3 = jSONArray;
                                }
                                ajVar2 = atVar;
                                layoutParams = new LinearLayout.LayoutParams(i14, i15);
                                str3 = a10;
                                ajVar = ajVar2;
                                if (ajVar == null) {
                                }
                                i17 = i13 + 1;
                                layoutParams2 = layoutParams;
                                i16 = i11;
                                i14 = i12;
                                str5 = str4;
                                i15 = -2;
                                jSONArray3 = jSONArray;
                            }
                            ahVar = null;
                            str5 = a10;
                            k.c("uppay", "json parser exception!!! - UPRuleView");
                            layoutParams = layoutParams2;
                            ajVar = ahVar;
                            str3 = str5;
                            if (ajVar == null) {
                            }
                            i17 = i13 + 1;
                            layoutParams2 = layoutParams;
                            i16 = i11;
                            i14 = i12;
                            str5 = str4;
                            i15 = -2;
                            jSONArray3 = jSONArray;
                        }
                        zVar2 = eVar;
                        i11 = i16;
                        ajVar2 = zVar2;
                        layoutParams = new LinearLayout.LayoutParams(i14, i15);
                        str3 = a10;
                        ajVar = ajVar2;
                        if (ajVar == null) {
                        }
                        i17 = i13 + 1;
                        layoutParams2 = layoutParams;
                        i16 = i11;
                        i14 = i12;
                        str5 = str4;
                        i15 = -2;
                        jSONArray3 = jSONArray;
                    }
                    ajVar2 = apVar;
                    layoutParams = new LinearLayout.LayoutParams(i14, i15);
                    str3 = a10;
                    ajVar = ajVar2;
                    if (ajVar == null) {
                    }
                    i17 = i13 + 1;
                    layoutParams2 = layoutParams;
                    i16 = i11;
                    i14 = i12;
                    str5 = str4;
                    i15 = -2;
                    jSONArray3 = jSONArray;
                }
                i10 = i17;
                zVar2 = afVar;
                i11 = i16;
                ajVar2 = zVar2;
                layoutParams = new LinearLayout.LayoutParams(i14, i15);
                str3 = a10;
                ajVar = ajVar2;
                if (ajVar == null) {
                }
                i17 = i13 + 1;
                layoutParams2 = layoutParams;
                i16 = i11;
                i14 = i12;
                str5 = str4;
                i15 = -2;
                jSONArray3 = jSONArray;
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String a10 = j.a(jSONObject, "instalment_empty_info");
            if (!TextUtils.isEmpty(a10)) {
                ((p) c("instalment")).a(false);
                ((p) c("instalment")).b(false);
                Toast.makeText(this.f23985a, a10, 1).show();
                return;
            }
            ((p) c("instalment")).a(true);
            ((p) c("instalment")).b(true);
            ((p) a(this.f23987c, "instalment_policy")).a(j.d(jSONObject, "new_instalments"));
        }
    }

    public final C0266a b() {
        return a(true);
    }

    public final String b(String str) {
        z a10 = a(this.f23987c, str);
        return a10 != null ? a10.a() : "";
    }

    public final void b(View.OnClickListener onClickListener) {
        z c10 = c("promotion");
        if (c10 != null && (c10 instanceof aj)) {
            ((aj) c10).c(onClickListener);
        }
    }

    public final z c(String str) {
        ArrayList<z> arrayList = this.f23987c;
        if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<z> it = this.f23987c.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (next.o().equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public final HashMap<String, String> c() {
        if (!a(false).a()) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.f23987c != null) {
            for (int i10 = 0; i10 < this.f23987c.size(); i10++) {
                z zVar = this.f23987c.get(i10);
                if (!(zVar instanceof ad) && !(zVar instanceof UPWidget) && !TextUtils.isEmpty(zVar.a())) {
                    hashMap.put(zVar.n(), zVar.a());
                }
            }
        }
        return hashMap;
    }

    public final void c(View.OnClickListener onClickListener) {
        z c10 = c("promotion");
        if (c10 != null && (c10 instanceof aj)) {
            ((aj) c10).a(onClickListener);
        }
    }

    public final void d(String str) {
        this.f23993i = str;
    }

    public final boolean d() {
        boolean z10;
        ArrayList<z> arrayList = this.f23987c;
        if (arrayList != null) {
            Iterator<z> it = arrayList.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (next instanceof UPWidget) {
                    UPWidget uPWidget = (UPWidget) next;
                    if (uPWidget.j()) {
                        uPWidget.k();
                        z10 = true;
                        break;
                    }
                }
            }
        }
        z10 = false;
        ((InputMethodManager) this.f23985a.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return z10;
    }

    @Override // com.unionpay.mobile.android.widgets.ah.a
    public final void e(String str) {
        b bVar = this.f23989e;
        if (bVar != null) {
            bVar.c(str);
        }
    }

    public final boolean e() {
        boolean z10;
        ArrayList<z> arrayList = this.f23987c;
        if (arrayList != null) {
            Iterator<z> it = arrayList.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if ((next instanceof aa) && !((aa) next).c()) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        return !z10;
    }

    public final void f() {
        ArrayList<z> arrayList = this.f23987c;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<z> it = this.f23987c.iterator();
            while (it.hasNext()) {
                z next = it.next();
                if ((next instanceof UPWidget) || (next instanceof e) || (next instanceof av)) {
                    ((aa) next).g();
                }
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.aj.a
    public final void g() {
        z c10 = c("instalment");
        if (c10 != null) {
            p pVar = (p) c10;
            if (pVar.g()) {
                Toast.makeText(this.f23985a, this.f23993i, 1).show();
                pVar.b(false);
            }
        }
    }
}
