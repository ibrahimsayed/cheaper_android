package com.afy.cheaper.fragments.market;

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
public class MarketContent {

    /**
     * An array of sample (market) items.
     */
    public static final List<MarketItem> ITEMS = new ArrayList<MarketItem>();

    /**
     * A map of sample (market) items, by ID.
     */
    public static final Map<String, MarketItem> ITEM_MAP = new HashMap<String, MarketItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createMarketItem(i));
        }
    }

    private static void addItem(MarketItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MarketItem createMarketItem(int position) {
        return new MarketItem(String.valueOf(position), "Market " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Market: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A market item representing a piece of content.
     */
    public static class MarketItem {
        public final String id;
        public final String content;
        public final String details;

        public MarketItem(String id, String content, String details) {
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
