package marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.StringJoiner;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "offer_id")
    private Long offerId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_price")
    private int startPrice;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "bidinc")
    private int bidInc;

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ownerId=" + ownerId)
                .add("offerId=" + offerId)
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("startPrice=" + startPrice)
                .add("startDate=" + startDate)
                .add("endDate=" + endDate)
                .add("bidInc=" + bidInc)
                .toString();
    }
}
