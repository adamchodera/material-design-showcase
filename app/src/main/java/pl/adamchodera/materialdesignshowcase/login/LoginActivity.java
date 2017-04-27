package pl.adamchodera.materialdesignshowcase.login;

import android.os.Bundle;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.common.AuthenticationActivity;

/**
 * A screen that offers registration via email & password.
 */
public class LoginActivity extends AuthenticationActivity {

    @BindString(R.string.activity_login_button_label)
    String loginButtonLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        super.initFormView();
    }

    @Override
    protected String getAuthenticationButtonLabel() {
        return loginButtonLabel;
    }

    @Override
    protected void triggerAuthentication() {
        super.showProgress(true);
    }
}

