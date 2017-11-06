package com.afy.cheaper.fragments.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class OfferContent {

    /**
     * An array of sample (offer) items.
     */
    public static final List<OfferItem> ITEMS = new ArrayList<OfferItem>();

    /**
     * A map of sample (offer) items, by ID.
     */
    public static final Map<String, OfferItem> ITEM_MAP = new HashMap<String, OfferItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createOfferItem(i));
        }
    }

    private static void addItem(OfferItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static OfferItem createOfferItem(int position) {
        return new OfferItem(String.valueOf(position), "Offer " + position, makeDetails(position));
        //return new OfferItem(String.valueOf(position), "Item # " + position, "Details kkkkkk");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details of Offer ").append(position).append(" :");
        //for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        //}
        return builder.toString();
    }

    /**
     * A offer item representing a piece of content.
     */
    public static class OfferItem {
        public final String id;
        public final String content;
        public final String details;

        public OfferItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
