package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.services;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.aggregates.AgriculturalProcess;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.queries.*;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.AgriculturalActivity;

import java.util.List;
import java.util.Optional;

public interface AgriculturalProcessQueryService {
    Optional<AgriculturalProcess> handle(GetAgriculturalProcessByIdQuery query);
    List<AgriculturalProcess> handle(GetAgriculturalProcessByFieldIdQuery query);
    Optional<AgriculturalProcess> handle(GetUnfinishedAgriculturalProcessByFieldIdQuery query);

    List<AgriculturalActivity> handle(GetActivitiesByActivityTypeAndAgriculturalProcessIdQuery query);
    Optional<AgriculturalActivity> handle(GetLastActivityByActivityTypeAndAgriculturalProcessIdQuery query);
}
