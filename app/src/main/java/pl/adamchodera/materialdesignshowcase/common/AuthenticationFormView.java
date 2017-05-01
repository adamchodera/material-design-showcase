package pl.adamchodera.materialdesignshowcase.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @BindView(R.id.email)
    EditText emailView;

    @BindView(R.id.password)
    EditText passwordView;

    @BindView(R.id.authenticate_button)
    Button authenticateButton;

    private AuthenticationFormValidator formValidator;
    private OnAuthenticationAttemptListener onAuthenticationAttemptListener;

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

    public void setOnAuthenticationAttemptListener(final OnAuthenticationAttemptListener onAuthenticationAttemptListener) {
        this.onAuthenticationAttemptListener = onAuthenticationAttemptListener;
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

    public void setButtonLabel(final String authenticationButtonLabel) {
        authenticateButton.setText(authenticationButtonLabel);
        passwordView.setImeActionLabel(authenticationButtonLabel, R.id.authenticate);
    }

    @OnClick(R.id.authenticate_button)
    protected void attemptAuthentication() {
        if (onAuthenticationAttemptListener == null) {
            Log.d(getClass().getCanonicalName(), "onAuthenticationAttemptListener == null");
            return;
        }

        onAuthenticationAttemptListener.onAuthenticationAttempt();

    }

    private void init() {
        setFillViewport(true);

        final View view = inflate(getContext(), R.layout.view_authentication_form, this);
        ButterKnife.bind(this, view);

        formValidator = new AuthenticationFormValidator();

        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.authenticate) {
                    onAuthenticationAttemptListener.onAuthenticationAttempt();
                    return true;
                }
                return false;
            }
        });
    }

    private boolean isEmailValid() {
        final String email = emailView.getText().toString();

        return formValidator.isEmailValid(email);
    }

    private boolean isPasswordValid() {
        final String email = passwordView.getText().toString();

        return formValidator.isPasswordValid(email);
    }

    interface OnAuthenticationAttemptListener {
        void onAuthenticationAttempt();
    }
}
