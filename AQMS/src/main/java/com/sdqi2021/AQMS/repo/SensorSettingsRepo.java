package com.sdqi2021.AQMS.repo;

import com.sdqi2021.AQMS.model.SensorSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorSettingsRepo extends JpaRepository<SensorSettings, Integer> {
}
