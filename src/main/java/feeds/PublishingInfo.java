package feeds;

import feeds.enums.PublishingType;

/**
 * Created by linux on 27.04.16.
 */
public class PublishingInfo {
    private boolean isPublishingNeeded;
    PublishingType publishingType;

    public PublishingInfo(boolean isPublishingNeeded, PublishingType publishingType) {
        this.isPublishingNeeded = isPublishingNeeded;
        this.publishingType = publishingType;
    }

    public boolean isPublishingNeeded() {
        return isPublishingNeeded;
    }

    public PublishingType getPublishingType() {
        return publishingType;
    }
}
