package com.lanister.encuesta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPollResponse {
    private List<PollSimpleResponse> polls;
    private  int totalPages;
    private  long totalRecords;
    private  int currentPageRecords;
    private  int currentPage;
}
