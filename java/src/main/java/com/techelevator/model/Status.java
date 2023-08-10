package com.techelevator.model;
;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Status {
    @NotNull
    private int statusId;
    @NotNull
    @NotBlank(message = "Status must have a description")
    private String description;

}
