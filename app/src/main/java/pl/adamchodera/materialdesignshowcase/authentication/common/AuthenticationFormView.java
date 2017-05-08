package pl.adamchodera.materialdesignshowcase.authentication.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.adamchodera.materialdesignshowcase.R;

/**
 * Custom form view for sign up and sign in purposes.
 */
public class AuthenticationFormView extends ScrollView {

    @BindView(R.id.emailInputLayout)
    TextInputLayout emailView;

    @BindView(R.id.passwordInputLayout)
    TextInputLayout passwordView;

    @BindView(R.id.raised_button)
    Button raisedButton;

    @BindView(R.id.flat_button)
    Button flatButton;

    private AuthenticationFormValidator formValidator;
    private OnButtonClickedListener onButtonClickedListener;

    public AuthenticationFormView(final Context context) {
        super(context);
        init();
    }

    public AuthenticationFormView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AuthenticationFormView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setOnButtonClickedListener(final OnButtonClickedListener onButtonClickedListener) {
        this.onButtonClickedListener = onButtonClickedListener;
    }

    public boolean isValid() {
        boolean isEmailValid = isEmailValid();
        boolean isPasswordValid = isPasswordValid();

        if (isEmailValid) {
            emailView.setError(null);
        } else {
            emailView.setError(getContext().getString(R.string.error_invalid_email));
        }

        if (isPasswordValid) {
            passwordView.setError(null);
        } else {
            passwordView.setError(getContext().getString(R.string.error_invalid_password));
        }

        return isEmailValid && isPasswordValid;
    }

    public void setRaisedButtonLabel(final String authenticationButtonLabel) {
        raisedButton.setText(authenticationButtonLabel);
        passwordView.getEditText().setImeActionLabel(authenticationButtonLabel, R.id.authenticate);
    }

    public void setFlatButtonLabel(final String flatButtonLabel) {
        flatButton.setText(flatButtonLabel);
    }

    @OnClick(R.id.raised_button)
    protected void raisedButtonClicked() {
        if (onButtonClickedListener == null) {
            Log.d(getClass().getCanonicalName(), "onButtonClickedListener == null");
            return;
        }

        onButtonClickedListener.onRaisedButtonClicked();
    }

    @OnClick(R.id.flat_button)
    protected void flatButtonClicked() {
        if (onButtonClickedListener == null) {
            Log.d(getClass().getCanonicalName(), "onButtonClickedListener == null");
            return;
        }

        onButtonClickedListener.onFlatButtonClicked();
    }

    private void init() {
        setFillViewport(true);

        final View view = inflate(getContext(), R.layout.view_authentication_form, this);
        ButterKnife.bind(this, view);

        formValidator = new AuthenticationFormValidator();

        passwordView.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.authenticate) {
                    onButtonClickedListener.onRaisedButtonClicked();
                    return true;
                }
                return false;
            }
        });
    }

    private boolean isEmailValid() {
        final String email = emailView.getEditText().getText().toString();

        return formValidator.isEmailValid(email);
    }

    private boolean isPasswordValid() {
        final String password = passwordView.getEditText().getText().toString();

        return formValidator.isPasswordValid(password, getContext());
    }

    interface OnButtonClickedListener {
        void onRaisedButtonClicked();

        void onFlatButtonClicked();
    }
}
