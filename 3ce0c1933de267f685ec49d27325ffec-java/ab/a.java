package ab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.assistant.account.AccountHomeActivity;
/* compiled from: BaseAccountFragment.java */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private boolean f164a = false;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f165b = new C0001a();

    /* compiled from: BaseAccountFragment.java */
    /* renamed from: ab.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0001a extends BroadcastReceiver {
        C0001a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action.LOGIN".equals(action)) {
                a.this.a0();
            } else if ("action.LOGOUT".equals(action)) {
                a.this.b0();
            }
        }
    }

    private void c0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.LOGIN");
        intentFilter.addAction("action.LOGOUT");
        b1.a.b(b.e()).c(this.f165b, intentFilter);
        this.f164a = true;
    }

    protected abstract int Y();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Z() {
        return !TextUtils.isEmpty(ta.a.s());
    }

    protected void a0() {
    }

    protected void b0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0() {
        Intent intent = new Intent(getContext(), AccountHomeActivity.class);
        intent.putExtra("key_type", "key_login");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0(String str) {
        sb.a.d(requireContext(), str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c0();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(Y(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f164a) {
            b1.a.b(b.e()).e(this.f165b);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
