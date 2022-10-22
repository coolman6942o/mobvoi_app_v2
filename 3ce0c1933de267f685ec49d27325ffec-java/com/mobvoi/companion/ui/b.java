package com.mobvoi.companion.ui;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import ce.h;
import com.mobvoi.android.common.utils.k;
import hc.e;
import java.util.ArrayList;
/* compiled from: McuBasePermissionFragment.java */
/* loaded from: classes2.dex */
public abstract class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f17630b;

    /* renamed from: a  reason: collision with root package name */
    private static final String f17629a = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f17631c = false;

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 28) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        } else {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_PHONE_STATE");
        if (i10 >= 26) {
            arrayList.add("android.permission.ANSWER_PHONE_CALLS");
        }
        f17630b = (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        Context requireContext = requireContext();
        String[] strArr = f17630b;
        if (!e.i(requireContext, strArr) && !f17631c) {
            f17631c = true;
            requestPermissions(strArr, 10001);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10001) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < iArr.length; i11++) {
                if (iArr[i11] == -1) {
                    k.h(f17629a, " onRequestPermissionsResult permissions denied = " + strArr[i11]);
                    arrayList.add(e.h(strArr[i11]));
                }
            }
            String string = requireContext().getString(h.Q, TextUtils.join("\n", arrayList));
            if (arrayList.size() > 0) {
                Toast.makeText(requireContext(), string, 0).show();
            }
        }
    }
}
