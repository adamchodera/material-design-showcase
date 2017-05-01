package pl.adamchodera.materialdesignshowcase.registration;

import android.content.Intent;
import android.os.Bundle;

import butterknife.BindString;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;
import pl.adamchodera.materialdesignshowcase.common.AuthenticationActivity;
import pl.adamchodera.materialdesignshowcase.dashboard.DashboardActivity;
import pl.adamchodera.materialdesignshowcase.login.LoginActivity;

/**
 * A screen that offers registration via email & password.
 */
public class RegisterActivity extends AuthenticationActivity {

    @BindString(R.string.activity_register_create_account_button_label)
    String registerButtonLabel;

    @BindString(R.string.activity_register_login_button_label)
    String loginButtonLabel;

    @Override
    public void onRaisedButtonClicked() {
        super.showProgress(true);

        registerUser();
    }

    @Override
    public void onFlatButtonClicked() {
        final Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        super.initFormView();
    }

    @Override
    protected String getRaisedButtonLabel() {
        return registerButtonLabel;
    }

    @Override
    protected String getFlatButtonLabel() {
        return loginButtonLabel;
    }

    private void registerUser() {
        // TODO implement registration flow

        goToDashboard();
    }

    private void goToDashboard() {
        final Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}

