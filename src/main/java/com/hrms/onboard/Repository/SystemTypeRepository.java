package com.hrms.onboard.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hrms.onboard.entity.SystemType;

@EnableJpaRepositories
public interface SystemTypeRepository extends JpaRepository<SystemType,Serializable>{

}
