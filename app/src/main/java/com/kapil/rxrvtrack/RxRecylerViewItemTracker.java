package com.kapil.rxrvtrack;


import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by kapilbakshi on 16/06/18.
 */

public class RxRecylerViewItemTracker {

    private PublishSubject<PositionsVisible> publishSubject;
    private static final int TIME_THRESHOLD_IN_MS = 300;
    private Disposable disposable;
    private final Consumer<PositionsVisible> successConsumer;

    public RxRecylerViewItemTracker(final Consumer<PositionsVisible> successConsumer) {
        this.successConsumer = successConsumer;
        this.publishSubject = PublishSubject.create();
        this.disposable = publishSubject
                .throttleWithTimeout(TIME_THRESHOLD_IN_MS, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribe(this::onSuccess, throwable -> { throwable.printStackTrace(); });
    }

    public void triggerItemVisibleEvent(final PositionsVisible visibleState) {
        publishSubject.onNext(visibleState);
    }

    public void unSubscribe() {
        disposable.dispose();
    }

    private void onSuccess(PositionsVisible positionsVisible) {
        try {
            successConsumer.accept(positionsVisible);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}