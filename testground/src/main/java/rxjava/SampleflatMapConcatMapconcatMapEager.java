package rxjava;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleflatMapConcatMapconcatMapEager {
    private static Flowable<String> CITIES = Flowable.just("Warsaw", "Paris", "London", "Madrid");
    private GeoNames geoNames;

    public void testConcatMaop() {
        CITIES.concatMap(geoNames::populationOf)
                .subscribe(response -> System.out.println("response"));

    }

}
