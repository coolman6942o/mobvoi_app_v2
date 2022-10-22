package ij;

import android.content.DialogInterface;
import com.mobvoi.mcuwatch.ui.settings.SettingActivity;
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f28286a = new e();

    private /* synthetic */ e() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        SettingActivity.V(dialogInterface, i10);
    }
}
