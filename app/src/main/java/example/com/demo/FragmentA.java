package example.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    View root;
    RecyclerView listView;
    RecyclerView.LayoutManager mLayoutManager;

    Activity activity;

    public FragmentAAdapter boardAdapter;

    public static FragmentA getInstance(Bundle bundle) {
        FragmentA instance = new FragmentA();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (Activity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        root = inflater.inflate(R.layout.fragment_a, null, false);

        listView = (RecyclerView) root.findViewById(R.id.listView);

        mLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        listView.setLayoutManager(mLayoutManager);

        boardAdapter = new FragmentAAdapter(this, activity, listView);
        listView.setAdapter(boardAdapter);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}