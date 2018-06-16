package com.kapil.rxrvtrack;

/**
 * Created by kapilbakshi on 16/06/18.
 */

public class PositionsVisible {

    final int firstPartiallyVisibleItemPosition;
    final int lastPartiallyVisibleItemPosition;

    public PositionsVisible(int firstPartiallyVisibleItemPosition,
                            int lastPartiallyVisibleItemPosition) {
        this.firstPartiallyVisibleItemPosition = firstPartiallyVisibleItemPosition;
        this.lastPartiallyVisibleItemPosition = lastPartiallyVisibleItemPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionsVisible that = (PositionsVisible) o;

        return (firstPartiallyVisibleItemPosition == that.firstPartiallyVisibleItemPosition) &&
                (lastPartiallyVisibleItemPosition == that.lastPartiallyVisibleItemPosition);

    }

    @Override
    public int hashCode() {
        int result = firstPartiallyVisibleItemPosition;
        result = 31 * result + lastPartiallyVisibleItemPosition;
        return result;
    }

    public int getFirstPartiallyVisibleItemPosition() {
        return firstPartiallyVisibleItemPosition;
    }

    public int getlastCompletelyVisibleItemPosition() {
        return lastPartiallyVisibleItemPosition;
    }


}

