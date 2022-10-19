package dev.bigdecimal.yorpat.api.programservice;

import java.util.Date;

import lombok.Data;

@Data
public class ProgramModel {
    private Long programId;
    private String programName;
    private Date programDate;
}
