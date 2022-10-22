package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import b6.i;
import com.google.android.gms.measurement.AppMeasurement;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class x0 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<String[]> f9786c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<String[]> f9787d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<String[]> f9788e = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(d2 d2Var) {
        super(d2Var);
    }

    private static String D(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        i.k(strArr);
        i.k(strArr2);
        i.k(atomicReference);
        i.a(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (r5.C0(str, strArr[i10])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i10] == null) {
                        strArr3[i10] = strArr2[i10] + "(" + strArr[i10] + ")";
                    }
                    str2 = strArr3[i10];
                }
                return str2;
            }
        }
        return str;
    }

    private static void E(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    private final void F(StringBuilder sb2, int i10, w5 w5Var) {
        String[] strArr;
        String str;
        if (w5Var != null) {
            E(sb2, i10);
            sb2.append("filter {\n");
            I(sb2, i10, "complement", w5Var.f9782e);
            I(sb2, i10, "param_name", N(w5Var.f9783f));
            int i11 = i10 + 1;
            z5 z5Var = w5Var.f9780c;
            if (z5Var != null) {
                E(sb2, i11);
                sb2.append("string_filter");
                sb2.append(" {\n");
                Integer num = z5Var.f9855c;
                if (num != null) {
                    switch (num.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                        default:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                    }
                    I(sb2, i11, "match_type", str);
                }
                I(sb2, i11, "expression", z5Var.f9856d);
                I(sb2, i11, "case_sensitive", z5Var.f9857e);
                if (z5Var.f9858f.length > 0) {
                    E(sb2, i11 + 1);
                    sb2.append("expression_list {\n");
                    for (String str2 : z5Var.f9858f) {
                        E(sb2, i11 + 2);
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                E(sb2, i11);
                sb2.append("}\n");
            }
            G(sb2, i11, "number_filter", w5Var.f9781d);
            E(sb2, i10);
            sb2.append("}\n");
        }
    }

    private final void G(StringBuilder sb2, int i10, String str, x5 x5Var) {
        if (x5Var != null) {
            E(sb2, i10);
            sb2.append(str);
            sb2.append(" {\n");
            Integer num = x5Var.f9801c;
            if (num != null) {
                int intValue = num.intValue();
                I(sb2, i10, "comparison_type", intValue != 1 ? intValue != 2 ? intValue != 3 ? intValue != 4 ? "UNKNOWN_COMPARISON_TYPE" : "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN");
            }
            I(sb2, i10, "match_as_float", x5Var.f9802d);
            I(sb2, i10, "comparison_value", x5Var.f9803e);
            I(sb2, i10, "min_comparison_value", x5Var.f9804f);
            I(sb2, i10, "max_comparison_value", x5Var.f9805g);
            E(sb2, i10);
            sb2.append("}\n");
        }
    }

    private static void H(StringBuilder sb2, int i10, String str, i6 i6Var) {
        if (i6Var != null) {
            E(sb2, 3);
            sb2.append(str);
            sb2.append(" {\n");
            if (i6Var.f9372d != null) {
                E(sb2, 4);
                sb2.append("results: ");
                int i11 = 0;
                for (long j10 : i6Var.f9372d) {
                    Long valueOf = Long.valueOf(j10);
                    i11++;
                    if (i11 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(valueOf);
                }
                sb2.append('\n');
            }
            if (i6Var.f9371c != null) {
                E(sb2, 4);
                sb2.append("status: ");
                int i12 = 0;
                for (long j11 : i6Var.f9371c) {
                    Long valueOf2 = Long.valueOf(j11);
                    i12++;
                    if (i12 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(valueOf2);
                }
                sb2.append('\n');
            }
            E(sb2, 3);
            sb2.append("}\n");
        }
    }

    private static void I(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj != null) {
            E(sb2, i10 + 1);
            sb2.append(str);
            sb2.append(": ");
            sb2.append(obj);
            sb2.append('\n');
        }
    }

    private final String K(zzer zzerVar) {
        if (zzerVar == null) {
            return null;
        }
        return !P() ? zzerVar.toString() : J(zzerVar.L0());
    }

    private final boolean P() {
        return this.f9815a.c().z(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String A(v5 v5Var) {
        if (v5Var == null) {
            return LpaConstants.VALUE_NULL;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        I(sb2, 0, "filter_id", v5Var.f9750c);
        I(sb2, 0, "event_name", M(v5Var.f9751d));
        G(sb2, 1, "event_count_filter", v5Var.f9754g);
        sb2.append("  filters {\n");
        for (w5 w5Var : v5Var.f9752e) {
            F(sb2, 2, w5Var);
        }
        E(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String B(y5 y5Var) {
        if (y5Var == null) {
            return LpaConstants.VALUE_NULL;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        I(sb2, 0, "filter_id", y5Var.f9821c);
        I(sb2, 0, "property_name", O(y5Var.f9822d));
        F(sb2, 1, y5Var.f9823e);
        sb2.append("}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String C(g6 g6Var) {
        int i10;
        h6[] h6VarArr;
        int i11;
        h6[] h6VarArr2;
        x0 x0Var = this;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        h6[] h6VarArr3 = g6Var.f9304c;
        if (h6VarArr3 != null) {
            int length = h6VarArr3.length;
            int i12 = 0;
            while (i12 < length) {
                h6 h6Var = h6VarArr3[i12];
                if (h6Var != null) {
                    E(sb2, 1);
                    sb2.append("bundle {\n");
                    I(sb2, 1, "protocol_version", h6Var.f9326c);
                    I(sb2, 1, "platform", h6Var.f9334k);
                    I(sb2, 1, "gmp_version", h6Var.f9342s);
                    I(sb2, 1, "uploading_gmp_version", h6Var.f9343t);
                    I(sb2, 1, "config_version", h6Var.I);
                    I(sb2, 1, "gmp_app_id", h6Var.A);
                    I(sb2, 1, "app_id", h6Var.f9340q);
                    I(sb2, 1, "app_version", h6Var.f9341r);
                    I(sb2, 1, "app_version_major", h6Var.E);
                    I(sb2, 1, "firebase_instance_id", h6Var.D);
                    I(sb2, 1, "dev_cert_hash", h6Var.f9347x);
                    I(sb2, 1, "app_store", h6Var.f9339p);
                    I(sb2, 1, "upload_timestamp_millis", h6Var.f9329f);
                    I(sb2, 1, "start_timestamp_millis", h6Var.f9330g);
                    I(sb2, 1, "end_timestamp_millis", h6Var.f9331h);
                    I(sb2, 1, "previous_bundle_start_timestamp_millis", h6Var.f9332i);
                    I(sb2, 1, "previous_bundle_end_timestamp_millis", h6Var.f9333j);
                    I(sb2, 1, "app_instance_id", h6Var.f9346w);
                    I(sb2, 1, "resettable_device_id", h6Var.f9344u);
                    I(sb2, 1, "device_id", h6Var.H);
                    I(sb2, 1, "limited_ad_tracking", h6Var.f9345v);
                    I(sb2, 1, "os_version", h6Var.f9335l);
                    I(sb2, 1, "device_model", h6Var.f9336m);
                    I(sb2, 1, "user_default_language", h6Var.f9337n);
                    I(sb2, 1, "time_zone_offset_minutes", h6Var.f9338o);
                    I(sb2, 1, "bundle_sequential_index", h6Var.f9348y);
                    I(sb2, 1, "service_upload", h6Var.B);
                    I(sb2, 1, "health_monitor", h6Var.f9349z);
                    Long l10 = h6Var.J;
                    if (!(l10 == null || l10.longValue() == 0)) {
                        I(sb2, 1, "android_id", h6Var.J);
                    }
                    Integer num = h6Var.M;
                    if (num != null) {
                        I(sb2, 1, "retry_counter", num);
                    }
                    j6[] j6VarArr = h6Var.f9328e;
                    int i13 = 2;
                    if (j6VarArr != null) {
                        int length2 = j6VarArr.length;
                        int i14 = 0;
                        while (i14 < length2) {
                            j6 j6Var = j6VarArr[i14];
                            if (j6Var != null) {
                                E(sb2, i13);
                                sb2.append("user_property {\n");
                                h6VarArr2 = h6VarArr3;
                                i11 = length;
                                I(sb2, 2, "set_timestamp_millis", j6Var.f9412c);
                                I(sb2, 2, ContactConstant.CallsRecordKeys.NAME, x0Var.O(j6Var.f9413d));
                                I(sb2, 2, "string_value", j6Var.f9414e);
                                I(sb2, 2, "int_value", j6Var.f9415f);
                                I(sb2, 2, "double_value", j6Var.f9417h);
                                E(sb2, 2);
                                sb2.append("}\n");
                            } else {
                                h6VarArr2 = h6VarArr3;
                                i11 = length;
                            }
                            i14++;
                            h6VarArr3 = h6VarArr2;
                            length = i11;
                            i13 = 2;
                        }
                    }
                    h6VarArr = h6VarArr3;
                    i10 = length;
                    d6[] d6VarArr = h6Var.C;
                    if (d6VarArr != null) {
                        for (d6 d6Var : d6VarArr) {
                            if (d6Var != null) {
                                E(sb2, 2);
                                sb2.append("audience_membership {\n");
                                I(sb2, 2, "audience_id", d6Var.f9234c);
                                I(sb2, 2, "new_audience", d6Var.f9237f);
                                H(sb2, 2, "current_data", d6Var.f9235d);
                                H(sb2, 2, "previous_data", d6Var.f9236e);
                                E(sb2, 2);
                                sb2.append("}\n");
                            }
                        }
                    }
                    e6[] e6VarArr = h6Var.f9327d;
                    if (e6VarArr != null) {
                        int length3 = e6VarArr.length;
                        int i15 = 0;
                        while (i15 < length3) {
                            e6 e6Var = e6VarArr[i15];
                            if (e6Var != null) {
                                E(sb2, 2);
                                sb2.append("event {\n");
                                I(sb2, 2, ContactConstant.CallsRecordKeys.NAME, x0Var.M(e6Var.f9258d));
                                I(sb2, 2, "timestamp_millis", e6Var.f9259e);
                                I(sb2, 2, "previous_timestamp_millis", e6Var.f9260f);
                                I(sb2, 2, ContactConstant.CallsRecordKeys.COUNT, e6Var.f9261g);
                                f6[] f6VarArr = e6Var.f9257c;
                                if (f6VarArr != null) {
                                    int length4 = f6VarArr.length;
                                    int i16 = 0;
                                    while (i16 < length4) {
                                        f6 f6Var = f6VarArr[i16];
                                        if (f6Var != null) {
                                            E(sb2, 3);
                                            sb2.append("param {\n");
                                            I(sb2, 3, ContactConstant.CallsRecordKeys.NAME, x0Var.N(f6Var.f9274c));
                                            I(sb2, 3, "string_value", f6Var.f9275d);
                                            I(sb2, 3, "int_value", f6Var.f9276e);
                                            I(sb2, 3, "double_value", f6Var.f9278g);
                                            E(sb2, 3);
                                            sb2.append("}\n");
                                        }
                                        i16++;
                                        x0Var = this;
                                    }
                                }
                                E(sb2, 2);
                                sb2.append("}\n");
                            }
                            i15++;
                            x0Var = this;
                        }
                    }
                    E(sb2, 1);
                    sb2.append("}\n");
                } else {
                    h6VarArr = h6VarArr3;
                    i10 = length;
                }
                i12++;
                x0Var = this;
                h6VarArr3 = h6VarArr;
                length = i10;
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String J(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!P()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb2.append(sb2.length() != 0 ? ", " : "Bundle[{");
            sb2.append(N(str));
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(bundle.get(str));
        }
        sb2.append("}]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String L(zzeu zzeuVar) {
        if (zzeuVar == null) {
            return null;
        }
        if (!P()) {
            return zzeuVar.toString();
        }
        return "origin=" + zzeuVar.f9890c + ",name=" + M(zzeuVar.f9888a) + ",params=" + K(zzeuVar.f9889b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String M(String str) {
        if (str == null) {
            return null;
        }
        return !P() ? str : D(str, AppMeasurement.a.f10132b, AppMeasurement.a.f10131a, f9786c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String N(String str) {
        if (str == null) {
            return null;
        }
        return !P() ? str : D(str, AppMeasurement.d.f10134b, AppMeasurement.d.f10133a, f9787d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String O(String str) {
        if (str == null) {
            return null;
        }
        if (!P()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return D(str, AppMeasurement.e.f10136b, AppMeasurement.e.f10135a, f9788e);
        }
        return "experiment_id(" + str + ")";
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String z(k0 k0Var) {
        if (k0Var == null) {
            return null;
        }
        if (!P()) {
            return k0Var.toString();
        }
        return "Event{appId='" + k0Var.f9423a + "', name='" + M(k0Var.f9424b) + "', params=" + K(k0Var.f9428f) + "}";
    }
}
