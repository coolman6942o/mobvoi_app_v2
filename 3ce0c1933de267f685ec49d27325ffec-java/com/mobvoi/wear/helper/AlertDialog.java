package com.mobvoi.wear.helper;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobvoi.wear.common.R;
/* loaded from: classes2.dex */
public class AlertDialog extends Dialog {
    private final View.OnClickListener mButtonHandler;
    protected ImageView mIcon;
    protected View mIconButtonPanel;
    protected ImageButton mIconNegativeButton;
    protected ImageButton mIconPositiveButton;
    protected TextView mMessage;
    protected DialogInterface.OnClickListener mNegativeButtonListener;
    protected TextView mNegativeTextButton;
    protected DialogInterface.OnClickListener mNeutralButtonListener;
    protected TextView mNeutralTextButton;
    protected DialogInterface.OnClickListener mPositiveButtonListener;
    protected TextView mPositiveTextButton;
    protected View mSpacer;
    protected View mTextButtonPanel;
    protected TextView mTitle;

    public AlertDialog(Context context) {
        this(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleButtonClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        DialogInterface.OnClickListener onClickListener3;
        Log.e("PageStep", "handleButtonClick() called with: v = [" + view + "]");
        if ((view == this.mIconPositiveButton || view == this.mPositiveTextButton) && (onClickListener3 = this.mPositiveButtonListener) != null) {
            onClickListener3.onClick(this, -1);
        } else if ((view == this.mIconNegativeButton || view == this.mNegativeTextButton) && (onClickListener2 = this.mNegativeButtonListener) != null) {
            onClickListener2.onClick(this, -2);
        } else if (view == this.mNeutralTextButton && (onClickListener = this.mNeutralButtonListener) != null) {
            onClickListener.onClick(this, -3);
        }
        dismiss();
    }

    public void setIcon(Drawable drawable) {
        this.mIcon.setVisibility(drawable == null ? 4 : 0);
        this.mIcon.setImageDrawable(drawable);
    }

    public void setIconButton(int i10, DialogInterface.OnClickListener onClickListener) {
        if (i10 == -3) {
            this.mNeutralButtonListener = onClickListener;
        } else if (i10 == -2) {
            this.mNegativeButtonListener = onClickListener;
        } else if (i10 == -1) {
            this.mPositiveButtonListener = onClickListener;
        } else {
            return;
        }
        int i11 = 8;
        this.mSpacer.setVisibility((this.mPositiveButtonListener == null || this.mNegativeButtonListener == null) ? 8 : 4);
        this.mIconPositiveButton.setVisibility(this.mPositiveButtonListener == null ? 8 : 0);
        this.mIconNegativeButton.setVisibility(this.mNegativeButtonListener == null ? 8 : 0);
        View view = this.mIconButtonPanel;
        if (!(this.mPositiveButtonListener == null && this.mNegativeButtonListener == null)) {
            i11 = 0;
        }
        view.setVisibility(i11);
    }

    public void setIconNegativeButton(DialogInterface.OnClickListener onClickListener) {
        setIconButton(-2, onClickListener);
    }

    public void setIconPositiveButton(DialogInterface.OnClickListener onClickListener) {
        setIconButton(-1, onClickListener);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
        this.mMessage.setVisibility(charSequence == null ? 8 : 0);
    }

    public void setTextButton(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
        if (i11 == -3) {
            this.mNeutralButtonListener = onClickListener;
            this.mNeutralTextButton.setText(i10);
        } else if (i11 == -2) {
            this.mNegativeButtonListener = onClickListener;
            this.mNegativeTextButton.setText(i10);
        } else if (i11 == -1) {
            this.mPositiveButtonListener = onClickListener;
            this.mPositiveTextButton.setText(i10);
        } else {
            return;
        }
        int i12 = 0;
        this.mPositiveTextButton.setVisibility(this.mPositiveButtonListener == null ? 8 : 0);
        this.mNegativeTextButton.setVisibility(this.mNegativeButtonListener == null ? 8 : 0);
        this.mNeutralTextButton.setVisibility(this.mNeutralButtonListener == null ? 8 : 0);
        View view = this.mTextButtonPanel;
        if (this.mPositiveButtonListener == null && this.mNegativeButtonListener == null && this.mNeutralButtonListener == null) {
            i12 = 8;
        }
        view.setVisibility(i12);
        this.mIconButtonPanel.setVisibility(8);
    }

    public void setTextNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
        setTextButton(i10, -2, onClickListener);
    }

    public void setTextNeutralButton(int i10, DialogInterface.OnClickListener onClickListener) {
        setTextButton(i10, -3, onClickListener);
    }

    public void setTextPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
        setTextButton(i10, -1, onClickListener);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
    }

    public AlertDialog(Context context, int i10) {
        super(context, i10);
        View.OnClickListener aVar = new View.OnClickListener() { // from class: com.mobvoi.wear.helper.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertDialog.this.handleButtonClick(view);
            }
        };
        this.mButtonHandler = aVar;
        setContentView(R.layout.alert_dialog);
        this.mTitle = (TextView) findViewById(16908310);
        this.mMessage = (TextView) findViewById(16908299);
        this.mIcon = (ImageView) findViewById(16908294);
        this.mIconPositiveButton = (ImageButton) findViewById(16908313);
        this.mIconNegativeButton = (ImageButton) findViewById(16908314);
        this.mSpacer = findViewById(R.id.spacer);
        this.mIconButtonPanel = findViewById(R.id.buttonPanel);
        this.mTextButtonPanel = findViewById(R.id.textButtonPanel);
        this.mPositiveTextButton = (TextView) findViewById(R.id.buttonPositive);
        this.mNegativeTextButton = (TextView) findViewById(R.id.buttonNegative);
        this.mNeutralTextButton = (TextView) findViewById(R.id.buttonNeutral);
        this.mIconPositiveButton.setOnClickListener(aVar);
        this.mIconNegativeButton.setOnClickListener(aVar);
        this.mPositiveTextButton.setOnClickListener(aVar);
        this.mNegativeTextButton.setOnClickListener(aVar);
        this.mNeutralTextButton.setOnClickListener(aVar);
    }

    public void setIcon(int i10) {
        this.mIcon.setVisibility(i10 == 0 ? 4 : 0);
        this.mIcon.setImageResource(i10);
    }
}
