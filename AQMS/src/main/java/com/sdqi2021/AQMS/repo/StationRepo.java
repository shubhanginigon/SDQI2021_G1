package com.sdqi2021.AQMS.repo;


import com.sdqi2021.AQMS.model.dataModel.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, String> {
}
