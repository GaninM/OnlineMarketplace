package marketplace.model;

import java.util.Date;

public class Product {

    private int productId;

    private String productTitle;

    private int startPrice;

    private String description;

    private Date startDate;

    private Date endDate;

    private int bidInc;

    private long offerId;

    public Product(int productId, String productTitle, int startPrice, String description, Date startDate, Date endDate,
                   int bidInc, long offerId) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.startPrice = startPrice;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bidInc = bidInc;
        this.offerId = offerId;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBidInc() {
        return bidInc;
    }

    public void setBidInc(int bidInc) {
        this.bidInc = bidInc;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }
}
