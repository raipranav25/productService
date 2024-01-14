package com.productservice.productservice.inheritanceRelation.MappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ms_mentorRepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
@Override
    Mentor save(Mentor mentor );
}
