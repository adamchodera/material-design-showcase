package pl.adamchodera.materialdesignshowcase.dashboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;

public class DashboardFragment extends Fragment {

    private static final String ARG_FRAGMENT_NUMBER = "ARG_FRAGMENT_NUMBER";

    @BindView(R.id.fragment_dashboard_text_view)
    TextView textView;

    @BindString(R.string.large_text)
    String largeText;

    private int fragmentNumber;

    public DashboardFragment() {
    }

    public static DashboardFragment newInstance(final int fragmentNumber) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_FRAGMENT_NUMBER, fragmentNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentNumber =  getArguments().getInt(ARG_FRAGMENT_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        final String newLine = System.getProperty("line.separator"); // alternative: "\n"
        final String fragmentTitle = "This is fragment number: " + fragmentNumber;
        final String fragmentContent = fragmentTitle + newLine + newLine + largeText;

        textView.setText(fragmentContent);

        return view;
    }
}
