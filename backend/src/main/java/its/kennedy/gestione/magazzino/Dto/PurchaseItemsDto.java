package its.kennedy.gestione.magazzino.Dto;

import java.time.Instant;

public class PurchaseItemsDto {

    private Integer id;

    private Integer purchase_id;

    private Integer item_id;

    private Integer quantity;

    private Double unit_price;

    private Instant created_at;

    private Instant updated_at;

    private Instant deleted_at;
}
