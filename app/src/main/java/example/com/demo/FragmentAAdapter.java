package example.com.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class FragmentAAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    FragmentA fragmentA;
    Activity activity;
    RecyclerView listView;

    public FragmentAAdapter(FragmentA fragmentA, Activity activity, RecyclerView listView) {
        this.fragmentA = fragmentA;
        this.activity = activity;
        this.listView = listView;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_b, parent, false);
        RecyclerView.ViewHolder vh = new BoardViewHolder(v, this);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BoardViewHolder){
            BoardViewHolder pHolder = (BoardViewHolder)holder;
            pHolder.onBindViewHolder(position);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {

        FragmentAAdapter adapter;
        FragmentB fragmentB;
        View view;

        public BoardViewHolder(View itemView, FragmentAAdapter adapter) {
            super(itemView);

            this.view = itemView;
            this.adapter = adapter;
        }

        public void onBindViewHolder(int position) {

            FragmentManager fm = fragmentA.getChildFragmentManager();
            if (fragmentB==null) {
                Bundle bundle = new Bundle();
                bundle.putString("TEXT", "This is Fragment B:" + position);
                fragmentB = FragmentB.getInstance(bundle);

                int boardId = generateViewId();
                // switch the id of the board to be unique
                View board = view.findViewById(R.id.board);
                board.setId(boardId);

                // now flip fragmentB
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(boardId, fragmentB);
                ft.commit();
            }
        }
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

}
