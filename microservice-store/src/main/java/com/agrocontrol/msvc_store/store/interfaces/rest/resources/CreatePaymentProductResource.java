package com.agrocontrol.msvc_store.store.interfaces.rest.resources;

public record CreatePaymentProductResource(
        Long productId,
        Integer quantityProduct,
        Long userId
) {

}
