package ge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.mobvoi.assistant.account.AccountHomeActivity;
/* compiled from: BaseDeviceFragment.java */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f27398a;

    protected abstract View Y(LayoutInflater layoutInflater, ViewGroup viewGroup);

    protected abstract void Z();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a0() {
        return !TextUtils.isEmpty(ta.a.s());
    }

    public void b0() {
        Intent intent = new Intent(this.f27398a, AccountHomeActivity.class);
        intent.putExtra("key_type", "key_login");
        startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View Y = Y(layoutInflater, viewGroup);
        if (getParentFragment() != null && (getParentFragment() instanceof b)) {
            b bVar = (b) getParentFragment();
        }
        this.f27398a = requireActivity();
        Z();
        return Y;
    }
}
