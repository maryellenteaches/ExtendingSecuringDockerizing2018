package com.example.ec.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Tour contains all attributes of an Explore California Tour.
 *
 * Created by Mary Ellen Bowman
 */
@Entity
public class Tour implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String blurb;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;


    @ManyToOne
    @JoinColumn(name="tour_package_code")
    private TourPackage tourPackage;

    @Column
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column
    private Region region;

    /**
     * No public constructor. Entity is only constructed from database.
     */
    protected Tour() {
    }

    /**
     * Get the identifier.
     *
     * @return identifier
     */
    public Integer getId() {
        return id;
    }

    /**
     * Get the title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the blurb
     *
     * @return blurb
     */
    public String getBlurb() {
        return blurb;
    }

    /**
     * Get the price
     *
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Get the duration.
     *
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Get comma-separated list of items as a string.
     *
     * @return bullets
     */
    public String getBullets() {
        return bullets;
    }

    /**
     * Get the keywords.
     *
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Return the TourPackage
     *
     * @return tour package
     */
    public TourPackage getTourPackage() {
        return tourPackage;
    }

    /**
     * Get the difficulty.
     *
     * @return difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Get the region
     *
     * @return region
     */
    public Region getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blurb='" + blurb + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                ", bullets='" + bullets + '\'' +
                ", keywords='" + keywords + '\'' +
                ", tourPackage=" + tourPackage +
                ", difficulty=" + difficulty +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(title, tour.title) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(blurb, tour.blurb) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(duration, tour.duration) &&
                Objects.equals(bullets, tour.bullets) &&
                Objects.equals(keywords, tour.keywords) &&
                Objects.equals(tourPackage, tour.tourPackage) &&
                difficulty == tour.difficulty &&
                region == tour.region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region);
    }
}
