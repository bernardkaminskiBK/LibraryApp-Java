package core.service;

import core.abstractions.services.IQueueService;
import core.entities.Member;
import core.entities.QueueItem;
import core.entities.Title;

import java.util.ArrayList;

public class QueueService implements IQueueService {
    @Override
    public QueueItem addToQueue(Title title, Member member) {
        return null;
    }

    @Override
    public void markAsResolved(QueueItem item) {

    }

    @Override
    public ArrayList<QueueItem> getAllItems() {
        return new ArrayList<>();
    }

//    @Override
//    public void onTitleReturned(Object sender, TitleReturnedEventArgs args) {
//
//    }

    @Override
    public ArrayList<QueueItem> getItems(int titleId, boolean onlyPendingItems) {
        return null;
    }
}
