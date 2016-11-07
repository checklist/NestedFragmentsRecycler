package example.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {

    View root;

    Activity activity;

    String text;
    private TextView textView;

    public static FragmentB getInstance(Bundle bundle) {
        FragmentB instance = new FragmentB();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (Activity) getActivity();

        if (getArguments()!=null) {
            text = getArguments().getString("TEXT");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        root = inflater.inflate(R.layout.row, null, false);

        textView = (TextView)root.findViewById(R.id.textView);
        textView.setText(text);

        return root;
    }
}
