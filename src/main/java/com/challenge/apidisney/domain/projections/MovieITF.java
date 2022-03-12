package com.challenge.apidisney.domain.projections;


import java.time.LocalDate;

public interface MovieITF {

    Long getId();
    String getImage();
    String getTitle();
    LocalDate getCreationDate();
}
