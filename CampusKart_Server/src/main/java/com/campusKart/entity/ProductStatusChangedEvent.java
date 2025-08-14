package com.campusKart.entity;

import com.campusKart.entity.Enum.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class ProductStatusChangedEvent extends ApplicationEvent {
    private final Long productId;
    private final ProductStatus oldStatus;
    private final ProductStatus newStatus;

    public ProductStatusChangedEvent(Object source,Long productId, ProductStatus oldStatus, ProductStatus newStatus) {
        super(source);
        this.productId = productId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }
}
