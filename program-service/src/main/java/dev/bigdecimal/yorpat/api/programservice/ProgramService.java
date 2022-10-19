package dev.bigdecimal.yorpat.api.programservice;

import org.springframework.stereotype.Service;

@Service
public class ProgramService {
    private final ProgramRepo repo;

    public ProgramService(ProgramRepo repo){
        this.repo=repo;
    }

    public ProgramEntity createProgram(ProgramModel program) {
        ProgramEntity entity = new ProgramEntity();
        entity.setProgramName(program.getProgramName());
        entity.setProgramDate(program.getProgramDate());
        try {
            return repo.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }
}
