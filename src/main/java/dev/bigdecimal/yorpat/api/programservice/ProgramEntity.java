
package dev.bigdecimal.yorpat.api.programservice;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Program")
@Data
public class ProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;
    @Column(name = "programDesc")
    private String programName;
    @Column(nullable = false)
    private Date programDate;
}