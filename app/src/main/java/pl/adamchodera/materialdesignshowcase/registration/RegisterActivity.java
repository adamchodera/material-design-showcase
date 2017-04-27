package pl.adamchodera.materialdesignshowcase.registration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.common.AuthenticationFormView;

/**
 * A screen that offers registration via email & password.
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    View progressView;

    @BindView(R.id.authentication_form)
    AuthenticationFormView formView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initFormView();
    }

    private void initFormView() {
        formView.setOnAuthenticationAttemptListener(new AuthenticationFormView.OnAuthenticationAttemptListener() {
            @Override
            public void onAuthenticationAttempt() {
                if (formView.isValid()) {
                    showProgress(true);
                    // TODO send request to backend; redirect to main screen for now
                }
            }
        });
    }

    /**
     * Shows the progress bar and hides the form.
     */
    private void showProgress(final boolean show) {
        progressView.setVisibility(show ? View.VISIBLE : View.GONE);
        formView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
}

