package com.kapil.rxrvtrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kapilbakshi on 16/06/18.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.person_rv)
    RecyclerView personRecyclerView;
    private RxRecylerViewItemTracker rxRecylerViewItemTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setPersonRecyclerView();
    }
    
    private void setPersonRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        personRecyclerView.setAdapter(new RecyclerViewAdapter(PersonDataSource.newInstance().
                getRandomPersonsList(50)));
        personRecyclerView.setLayoutManager(linearLayoutManager);
        personRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                 final PositionsVisible itemsVisible = new PositionsVisible(linearLayoutManager.findFirstVisibleItemPosition(),
                        linearLayoutManager.findLastVisibleItemPosition());
                rxRecylerViewItemTracker.triggerItemVisibleEvent(itemsVisible);
            }
        });
    }

    void onItemsVisibilityTracked(PositionsVisible positionsVisible) {
        for(int i = positionsVisible.getFirstPartiallyVisibleItemPosition(); i <
                positionsVisible.getlastCompletelyVisibleItemPosition(); i++) {
            int position = i +1;
            System.out.println(position);
        }

        System.out.println("---------------------------------");
    }

    @Override
    public void onResume() {
        super.onResume();
        rxRecylerViewItemTracker = new RxRecylerViewItemTracker(this::onItemsVisibilityTracked);
    }

    @Override
    public void onPause() {
        super.onPause();
        rxRecylerViewItemTracker.unSubscribe();
    }
}
