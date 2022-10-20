package dev.bigdecimal.yorpat.api.programservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("programs")
public class ProgramResource {
    private final ProgramService service;
    private final ResponseEntity<? extends Object> requestErrorResponse = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    public ProgramResource(ProgramService service) {
        this.service = service;
    }

    @PostMapping("/createProgram")
    public ResponseEntity<? extends Object> createProgram(@RequestBody ProgramModel program) {
        if (!program.equals(null)) {
            try {
                Map<String, Long> responseBody = new HashMap<>();
                responseBody.put("Program ID", service.createProgram(program).getProgramId());
                return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return requestErrorResponse;
    }

    @GetMapping("getProgram/{programId}")
    public ResponseEntity<? extends Object> getProgramById(@PathVariable Long programId) {
        if (!programId.equals(null)) {
            try {
                return new ResponseEntity<>(service.getProgramById(programId), HttpStatus.FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return requestErrorResponse;
    }

    @GetMapping("/getAllPrograms")
    public ResponseEntity<? extends Object> getAllPrograms() {
        try {
            List<ProgramModel> programs = service.getAllPrograms();
            if (programs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(programs, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<? extends Object> updateProgramById(@PathVariable Long programId) {
        return requestErrorResponse;
    }

    public ResponseEntity<? extends Object> removeProgramById(@PathVariable Long programId) {
        return requestErrorResponse;
    }
}
