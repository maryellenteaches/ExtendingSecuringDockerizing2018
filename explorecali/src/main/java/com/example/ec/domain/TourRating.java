package com.example.ec.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Rating of a Tour by a Customer
 *
 * Created by Mary Ellen Bowman
 */
@Entity
@Table(name="tour_rating")
public class TourRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    protected TourRating() {
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
     */
    public TourRating(Tour tour, Integer customerId, Integer score, String comment) {
        this.tour = tour;
        this.customerId = customerId;
        this.score = score;
        this.comment = comment;
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     */
    public TourRating(Tour tour, Integer customerId, Integer score) {
        this.tour = tour;
        this.customerId = customerId;
        this.score = score;
        this.comment = toComment(score);
    }

    /**
     * Auto Generate a message for a score.
     *
     * @param score
     * @return
     */
    private String toComment(Integer score) {
        switch (score) {
            case 1:return "Terrible";
            case 2:return "Poor";
            case 3:return "Fair";
            case 4:return "Good";
            case 5:return "Great";
            default: return score.toString();
        }
    }

    /**
     * Get the identifier
     *
     * @return identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Get the score.
     *
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Get the comment.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Get the tour.
     *
     * @return tour
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * Get the customer identifier
     *
     * @return customer identifier
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Set the score.
     *
     * @param score score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * set the comment.
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tour, that.tour) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, customerId, score, comment);
    }
}
