package dev.bigdecimal.yorpat.api.programservice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        entity.setProgramDate(Date.valueOf(program.getProgramDate()));
        try {
            return repo.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public ProgramEntity getProgramById(Long programId) {
        try {
            return repo.findById(programId).orElseThrow();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ProgramModel> getAllPrograms() throws Exception {
        try {
            List<ProgramModel> programs = new ArrayList<>();
            Iterator<ProgramEntity> iterator = repo.findAll().iterator();
            while (iterator.hasNext()) {
                ProgramEntity entity = iterator.next();
                ProgramModel model = new ProgramModel();
                model.setProgramId(entity.getProgramId());
                model.setProgramName(entity.getProgramName());
                model.setProgramDate(String.valueOf(entity.getProgramDate()));
                programs.add(model);
            }
            return programs;
        } catch (Exception e) {
            throw e;
        }
    }
}
