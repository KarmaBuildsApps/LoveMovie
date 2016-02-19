package myapp.tae.ac.uk.lovemovie.utilities;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Karma on 17/02/16.
 */
public class RxUtil {
    public static void unsubscribe(Subscription subscription) {
        if (subscription != null)
            subscription.unsubscribe();
    }

    public static CompositeSubscription getNewSubscriptionIfUnsubscribed(CompositeSubscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            subscription = new CompositeSubscription();
        }
        return subscription;
    }
}
