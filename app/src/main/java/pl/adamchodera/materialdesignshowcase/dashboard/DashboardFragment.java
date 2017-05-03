package pl.adamchodera.materialdesignshowcase.dashboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.adamchodera.materialdesignshowcase.R;

public class DashboardFragment extends Fragment {

    private static final String ARG_POSITION = "ARG_POSITION";

    @BindView(R.id.fragment_dashboard_text_view)
    TextView textView;

    public static DashboardFragment newInstance(final int position) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(view);



        return view;
    }
}
