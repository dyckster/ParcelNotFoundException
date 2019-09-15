package com.pnfe.dashboard.dto.fns;

import lombok.Data;

import java.util.List;

@Data
public class FnsSearchResponse {
    List<FnsSearchResult> items;
}
