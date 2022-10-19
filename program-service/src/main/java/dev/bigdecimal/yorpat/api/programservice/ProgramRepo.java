package dev.bigdecimal.yorpat.api.programservice;

import org.springframework.data.repository.CrudRepository;

public interface ProgramRepo extends CrudRepository<ProgramEntity, Long> {
    
}
