package marketplace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "owner_id")
    private long ownerId;

    @Column(name = "offer_id")
    private long offerId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "start_price")
    private int startPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "bidInc")
    private int bidInc;

}
