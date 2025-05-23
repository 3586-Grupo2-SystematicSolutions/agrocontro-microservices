package com.agrocontrol.msvc_finance.finances.application.acl;

import com.agrocontrol.msvc_finance.finances.domain.model.commands.CreateFinanceCommand;
import com.agrocontrol.msvc_finance.finances.domain.services.FinanceCommandService;
import com.agrocontrol.msvc_finance.finances.interfaces.acl.FinancesContextFacade;
import org.springframework.stereotype.Service;

@Service
public class FinancesContextFacadeImpl implements FinancesContextFacade {
    private final FinanceCommandService financeCommandService;

    public FinancesContextFacadeImpl(FinanceCommandService financeCommandService) {
        this.financeCommandService = financeCommandService;
    }

    @Override
    public void createFinance(Long agriculturalProcessId, String type, String description, double value) {
        var createFinanceCommand = new CreateFinanceCommand(agriculturalProcessId, type, description, value);
        var finance = financeCommandService.handle(createFinanceCommand);
        if (finance.isPresent()) {
            finance.get();
        }
    }
}
