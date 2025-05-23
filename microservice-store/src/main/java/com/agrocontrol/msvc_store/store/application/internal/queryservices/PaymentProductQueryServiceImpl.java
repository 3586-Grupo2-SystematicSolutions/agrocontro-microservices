package com.agrocontrol.msvc_store.store.application.internal.queryservices;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.PaymentProduct;
import com.agrocontrol.msvc_store.store.domain.model.queries.GetPaymentProductByOwnerProductId;
import com.agrocontrol.msvc_store.store.domain.model.queries.GetPaymentProductByUserIdQuery;
import com.agrocontrol.msvc_store.store.domain.services.PaymentProductQueryService;
import com.agrocontrol.msvc_store.store.infrastructure.persistence.jpa.repositories.PaymentProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentProductQueryServiceImpl implements PaymentProductQueryService {
    private final PaymentProductRepository paymentProductRepository;

    public PaymentProductQueryServiceImpl(PaymentProductRepository paymentProductRepository) {
        this.paymentProductRepository = paymentProductRepository;
    }

    @Override
    public List<PaymentProduct> handle(GetPaymentProductByOwnerProductId query) {
        if(!paymentProductRepository.existsByOwnerProductId(query.ownerProductId())) {
            throw new IllegalArgumentException("The OwnerProductId not exist with id" + query.ownerProductId());
        }
        return paymentProductRepository.findByOwnerProductId(query.ownerProductId());
    }

    @Override
    public List<PaymentProduct> handle(GetPaymentProductByUserIdQuery query) {
        return this.paymentProductRepository.findByUserId(query.userId());
    }
}
