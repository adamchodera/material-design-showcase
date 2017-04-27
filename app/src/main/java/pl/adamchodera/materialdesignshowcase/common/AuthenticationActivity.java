package pl.adamchodera.materialdesignshowcase.common;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import pl.adamchodera.materialdesignshowcase.R;

public abstract class AuthenticationActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    protected View progressView;

    @BindView(R.id.authentication_form)
    protected AuthenticationFormView formView;

    protected abstract String getAuthenticationButtonLabel();

    protected abstract void triggerAuthentication();

    protected void initFormView() {
        formView.setOnAuthenticationAttemptListener(new AuthenticationFormView.OnAuthenticationAttemptListener() {
            @Override
            public void onAuthenticationAttempt() {
                if (formView.isValid()) {
                    triggerAuthentication();
                }
            }
        });

        formView.setButtonLabel(getAuthenticationButtonLabel());
    }

    /**
     * Shows the progress bar and hides the form.
     */
    protected void showProgress(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        formView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}
