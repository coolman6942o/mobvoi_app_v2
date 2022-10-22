package com.mobvoi.wear.util;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class BundleUtil {
    public static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (parcelableArray == null) {
            return null;
        }
        if (parcelableArray instanceof Bundle[]) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }
}
