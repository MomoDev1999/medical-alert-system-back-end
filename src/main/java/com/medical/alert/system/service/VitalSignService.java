package com.medical.alert.system.service;

import com.medical.alert.system.entity.VitalSign;
import com.medical.alert.system.repository.VitalSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignService {
    @Autowired
    private VitalSignRepository vitalSignRepository;

    public List<VitalSign> findAll() {
        return vitalSignRepository.findAll();
    }

    public VitalSign save(VitalSign vitalSign) {
        return vitalSignRepository.save(vitalSign);
    }
}
