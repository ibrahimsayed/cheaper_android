package com.afy.cheaper.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/*import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
*/
/**
 * Created by isayed on 10/29/2017.
 */

//@Root
public class OffersResponseModel {
    //@ElementList (name = "collection")
    @SerializedName("collection")

    List<Offer> offers;

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
