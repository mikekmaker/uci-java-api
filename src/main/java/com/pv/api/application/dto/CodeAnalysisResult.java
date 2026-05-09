package com.pv.api.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pv.api.domain.model.AuditoriaDetalle;

import java.util.List;

public class CodeAnalysisResult {

    private List<AuditoriaDetalle> issues;
    @JsonProperty("pedagogical_explanation")
    private String pedagogicalExplanation;
    @JsonProperty("refactored_code")
    private String refactoredCode;

    public String getPedagogicalExplanation() {
        return pedagogicalExplanation;
    }

    public void setPedagogicalExplanation(String pedagogicalExplanation) {
        this.pedagogicalExplanation = pedagogicalExplanation;
    }

    public String getRefactoredCode() {
        return refactoredCode;
    }

    public void setRefactoredCode(String refactoredCode) {
        this.refactoredCode = refactoredCode;
    }

    public List<AuditoriaDetalle> getIssues() {
        return issues;
    }

    public void setIssues(List<AuditoriaDetalle> issues) {
        this.issues = issues;
    }
}