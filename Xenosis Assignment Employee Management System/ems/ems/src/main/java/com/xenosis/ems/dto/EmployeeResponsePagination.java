package com.xenosis.ems.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeResponsePagination {
    private List<EmployeeDto> employeeDtoList;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;
    private int pageNo;
    private int pageSize;
}
