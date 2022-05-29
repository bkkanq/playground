package rxjava;

import io.reactivex.Flowable;

public interface GeoNames {
    Flowable<Long> populationOf(String city);
}
