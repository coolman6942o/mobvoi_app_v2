package b6;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public class a {
    public static ApiException a(Status status) {
        if (status.J0()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
