package fr.esilv.s8.completeapplication.pm.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Paul on 18/03/2017.
 */

public class PageInfo {
    @SerializedName("totalResults")
    private Integer totalResults;
    @SerializedName("resultsPerPage")
    private Integer resultsPerPage;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
