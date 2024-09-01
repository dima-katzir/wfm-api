package com.dkatzir.wfm.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ActionItem {
    private String name;
    private LocalDate dueDate;
    private LocalTime dueTime;
}
