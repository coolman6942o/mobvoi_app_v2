package c;

import android.content.Context;
import android.content.Intent;
import c.a;
import io.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class b extends c.a<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5539a = new a(null);

    /* compiled from: ActivityResultContracts.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Intent a(String[] input) {
            i.f(input, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            i.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    /* renamed from: d */
    public Intent a(Context context, String[] input) {
        i.f(context, "context");
        i.f(input, "input");
        return f5539a.a(input);
    }

    /* renamed from: e */
    public a.C0080a<Map<String, Boolean>> b(Context context, String[] input) {
        int b10;
        int c10;
        Map e10;
        i.f(context, "context");
        i.f(input, "input");
        boolean z10 = true;
        if (input.length == 0) {
            e10 = d0.e();
            return new a.C0080a<>(e10);
        }
        int length = input.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (!(androidx.core.content.b.a(context, input[i10]) == 0)) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (!z10) {
            return null;
        }
        b10 = c0.b(input.length);
        c10 = vo.f.c(b10, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(c10);
        for (String str : input) {
            Pair a10 = j.a(str, Boolean.TRUE);
            linkedHashMap.put(a10.getFirst(), a10.getSecond());
        }
        return new a.C0080a<>(linkedHashMap);
    }

    /* renamed from: f */
    public Map<String, Boolean> c(int i10, Intent intent) {
        Map<String, Boolean> e10;
        List o10;
        List Y;
        Map<String, Boolean> l10;
        Map<String, Boolean> e11;
        Map<String, Boolean> e12;
        if (i10 != -1) {
            e12 = d0.e();
            return e12;
        } else if (intent == null) {
            e11 = d0.e();
            return e11;
        } else {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                e10 = d0.e();
                return e10;
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            o10 = kotlin.collections.i.o(stringArrayExtra);
            Y = u.Y(o10, arrayList);
            l10 = d0.l(Y);
            return l10;
        }
    }
}
