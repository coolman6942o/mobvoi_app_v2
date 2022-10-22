package com.mobvoi.wear.common;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.app.PermissionCompat;
import com.mobvoi.wear.common.FragmentCompat;
import com.mobvoi.wear.util.WatchInfoUtils;
import java.util.List;
/* loaded from: classes2.dex */
final class FragmentCompat {
    private static final int REQUEST_CODE_ACTIVITY = 1120;
    private static final int REQUEST_CODE_INTENT_SENDER = 1226;
    private static final int REQUEST_CODE_PERMISSIONS = 1020;
    private static final String TAG = "FragmentCompat";
    private static final String TAG_FRAGMENT = "sfr_soul_fragment";
    private SoulFragment mSoulFragment;
    private SoulSupportFragment mSoulSupportFragment;
    private StartForResult mStartForResult;

    /* loaded from: classes2.dex */
    public static class SoulFragment extends Fragment {
        private static final String TAG = "SoulFragment";
        private OnAttachedListener mOnAttachedListener;
        private StartForResult mResult;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public interface OnAttachedListener {
            void onAttached();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$requestPermissionsForResult$0(String[] strArr) {
            requestPermissions(strArr, FragmentCompat.REQUEST_CODE_PERMISSIONS);
            this.mOnAttachedListener = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$requestPermissionsForResult$1(String[] strArr) {
            PermissionCompat.requestPermissions(this, strArr, (int) FragmentCompat.REQUEST_CODE_PERMISSIONS);
            this.mOnAttachedListener = null;
        }

        @Override // android.app.Fragment
        public void onActivityResult(int i10, int i11, Intent intent) {
            super.onActivityResult(i10, i11, intent);
            StartForResult startForResult = this.mResult;
            if (startForResult != null) {
                startForResult.onActivityResult(i10, i11, intent);
            } else {
                k.d(TAG, "App is reloaded");
            }
        }

        @Override // android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        @Override // android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            OnAttachedListener onAttachedListener = this.mOnAttachedListener;
            if (onAttachedListener != null) {
                onAttachedListener.onAttached();
            }
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }

        @Override // android.app.Fragment
        public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
            StartForResult startForResult = this.mResult;
            if (startForResult != null) {
                startForResult.onRequestPermissionsResult(i10, strArr, iArr);
            } else {
                k.d(TAG, "App is reloaded");
            }
        }

        void requestPermissionsForResult(final String[] strArr, StartForResult startForResult) {
            this.mResult = startForResult;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                requestPermissions(strArr, FragmentCompat.REQUEST_CODE_PERMISSIONS);
            } else if (i10 >= 23) {
                this.mOnAttachedListener = new OnAttachedListener() { // from class: com.mobvoi.wear.common.a
                    @Override // com.mobvoi.wear.common.FragmentCompat.SoulFragment.OnAttachedListener
                    public final void onAttached() {
                        FragmentCompat.SoulFragment.this.lambda$requestPermissionsForResult$0(strArr);
                    }
                };
            } else {
                this.mOnAttachedListener = new OnAttachedListener() { // from class: com.mobvoi.wear.common.b
                    @Override // com.mobvoi.wear.common.FragmentCompat.SoulFragment.OnAttachedListener
                    public final void onAttached() {
                        FragmentCompat.SoulFragment.this.lambda$requestPermissionsForResult$1(strArr);
                    }
                };
            }
        }

        void startActivityForResult(Intent intent, Bundle bundle, StartForResult startForResult) {
            this.mResult = startForResult;
            startActivityForResult(intent, FragmentCompat.REQUEST_CODE_ACTIVITY, bundle);
        }

        @TargetApi(24)
        void startIntentSenderForResult(IntentSender intentSender, Intent intent, int i10, int i11, int i12, Bundle bundle, StartForResult startForResult) throws IntentSender.SendIntentException {
            this.mResult = startForResult;
            startIntentSenderForResult(intentSender, FragmentCompat.REQUEST_CODE_INTENT_SENDER, intent, i10, i11, i12, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class SoulSupportFragment extends androidx.fragment.app.Fragment {
        private static final String TAG = "SoulSupportFragment";
        private StartForResult mResult;

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int i10, int i11, Intent intent) {
            super.onActivityResult(i10, i11, intent);
            StartForResult startForResult = this.mResult;
            if (startForResult != null) {
                startForResult.onActivityResult(i10, i11, intent);
            } else {
                k.d(TAG, "App is reloaded");
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        @Override // androidx.fragment.app.Fragment
        public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
            StartForResult startForResult = this.mResult;
            if (startForResult != null) {
                startForResult.onRequestPermissionsResult(i10, strArr, iArr);
            } else {
                k.d(TAG, "App is reloaded");
            }
        }

        void requestPermissionsForResult(String[] strArr, StartForResult startForResult) {
            this.mResult = startForResult;
            requestPermissions(strArr, FragmentCompat.REQUEST_CODE_PERMISSIONS);
        }

        void startActivityForResult(Intent intent, Bundle bundle, StartForResult startForResult) {
            this.mResult = startForResult;
            startActivityForResult(intent, FragmentCompat.REQUEST_CODE_ACTIVITY, bundle);
        }

        void startIntentSenderForResult(IntentSender intentSender, Intent intent, int i10, int i11, int i12, Bundle bundle, StartForResult startForResult) throws IntentSender.SendIntentException {
            this.mResult = startForResult;
            startIntentSenderForResult(intentSender, FragmentCompat.REQUEST_CODE_INTENT_SENDER, intent, i10, i11, i12, bundle);
        }
    }

    private FragmentCompat(StartForResult startForResult) {
        this.mStartForResult = startForResult;
        if (WatchInfoUtils.isTicwearSystem()) {
            this.mSoulFragment = getFragment(startForResult.getFragmentManager());
            return;
        }
        FragmentManager supportFragmentManager = startForResult.getSupportFragmentManager();
        if (supportFragmentManager != null) {
            this.mSoulSupportFragment = getSupportFragment(supportFragmentManager);
        } else {
            this.mSoulFragment = getFragment(startForResult.getFragmentManager());
        }
    }

    private SoulFragment findFragment(android.app.FragmentManager fragmentManager) {
        return (SoulFragment) fragmentManager.findFragmentByTag(TAG_FRAGMENT);
    }

    private FragmentManager findSuitableFragmentManager(FragmentManager fragmentManager) {
        List<androidx.fragment.app.Fragment> t02 = fragmentManager.t0();
        if (t02.size() == 0) {
            return null;
        }
        for (androidx.fragment.app.Fragment fragment : t02) {
            if (fragment.isAdded() && !fragment.isDetached()) {
                return fragment.getChildFragmentManager();
            }
        }
        return null;
    }

    private SoulSupportFragment findSupportFragment(FragmentManager fragmentManager) {
        return (SoulSupportFragment) fragmentManager.g0(TAG_FRAGMENT);
    }

    private SoulFragment getFragment(android.app.FragmentManager fragmentManager) {
        SoulFragment findFragment = findFragment(fragmentManager);
        if (findFragment == null) {
            findFragment = new SoulFragment();
            if (Build.VERSION.SDK_INT >= 24) {
                fragmentManager.beginTransaction().add(findFragment, TAG_FRAGMENT).commitNow();
            } else {
                fragmentManager.beginTransaction().add(findFragment, TAG_FRAGMENT).commit();
            }
        }
        return findFragment;
    }

    private SoulSupportFragment getSupportFragment(FragmentManager fragmentManager) {
        SoulSupportFragment findSupportFragment = findSupportFragment(fragmentManager);
        if (findSupportFragment == null) {
            findSupportFragment = new SoulSupportFragment();
            try {
                fragmentManager.l().e(findSupportFragment, TAG_FRAGMENT).m();
            } catch (Exception e10) {
                k.r(TAG, "Please try to invoke this before you use FragmentManager to switch fragment!", e10, new Object[0]);
                FragmentManager findSuitableFragmentManager = findSuitableFragmentManager(fragmentManager);
                if (findSuitableFragmentManager != null) {
                    findSuitableFragmentManager.l().e(findSupportFragment, TAG_FRAGMENT).m();
                } else {
                    k.d(TAG, "ahhhhhhh, Rarely like use of this!, i do the best!");
                }
            }
        }
        return findSupportFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FragmentCompat newInstance(StartForResult startForResult) {
        return new FragmentCompat(startForResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestPermissionsForResult(String[] strArr) {
        SoulSupportFragment soulSupportFragment = this.mSoulSupportFragment;
        if (soulSupportFragment != null) {
            soulSupportFragment.requestPermissionsForResult(strArr, this.mStartForResult);
        } else {
            this.mSoulFragment.requestPermissionsForResult(strArr, this.mStartForResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startActivityForResult(Intent intent, Bundle bundle) {
        SoulSupportFragment soulSupportFragment = this.mSoulSupportFragment;
        if (soulSupportFragment != null) {
            soulSupportFragment.startActivityForResult(intent, bundle, this.mStartForResult);
        } else {
            this.mSoulFragment.startActivityForResult(intent, bundle, this.mStartForResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startIntentSenderForResult(IntentSender intentSender, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        SoulSupportFragment soulSupportFragment = this.mSoulSupportFragment;
        if (soulSupportFragment != null) {
            soulSupportFragment.startIntentSenderForResult(intentSender, intent, i10, i11, i12, bundle, this.mStartForResult);
        } else {
            this.mSoulFragment.startIntentSenderForResult(intentSender, intent, i10, i11, i12, bundle, this.mStartForResult);
        }
    }
}
