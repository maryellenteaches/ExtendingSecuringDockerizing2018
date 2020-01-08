package com.example.ec.web;

import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for Rating a Tour.
 *
 * Created by Mary Ellen Bowman
 */

public class RatingDto  extends ResourceSupport {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    /**
     * Constructor to fully initialize the RatingDto
     *
     * @param score score
     * @param comment comment
     * @param customerId customer identifier
     */
    public RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto() {}

    /**
     * Get the score
     *
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Get the comment
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Get the customer identifier
     *
     * @return customer identifier
     */
    public Integer getCustomerId() {
        return customerId;
    }
}
