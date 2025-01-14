package com.medical.alert.system.repository;

import com.medical.alert.system.entity.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
}
