package com.ssd.esprithub.repository;

import com.ssd.esprithub.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface OptionsRepository extends JpaRepository<Options, Long> {
}
