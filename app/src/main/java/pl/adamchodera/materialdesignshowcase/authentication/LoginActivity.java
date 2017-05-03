package pl.adamchodera.materialdesignshowcase.authentication;

import android.content.Intent;
import android.os.Bundle;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.authentication.common.AuthenticationActivity;
import pl.adamchodera.materialdesignshowcase.dashboard.DashboardActivity;

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

        loginUser();
    }

    @Override
    public void onFlatButtonClicked() {
        final Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
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

    private void loginUser() {
        // TODO implement login flow
        goToDashboard();
    }

    private void goToDashboard() {
        final Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}

