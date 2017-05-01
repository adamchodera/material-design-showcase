package pl.adamchodera.materialdesignshowcase.login;

import android.os.Bundle;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.common.AuthenticationActivity;

/**
 * A screen that offers login via email & password.
 */
public class LoginActivity extends AuthenticationActivity {

    @BindString(R.string.activity_login_sign_in_button_label)
    String loginButtonLabel;

    @BindString(R.string.activity_login_create_account_button_label)
    String registerButtonLabel;

    @Override
    public void onRaisedButtonClicked() {
        super.showProgress(true);

        // TODO implement login flow
    }

    @Override
    public void onFlatButtonClicked() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        super.initFormView();
    }

    @Override
    protected String getRaisedButtonLabel() {
        return loginButtonLabel;
    }

    @Override
    protected String getFlatButtonLabel() {
        return registerButtonLabel;
    }
}

