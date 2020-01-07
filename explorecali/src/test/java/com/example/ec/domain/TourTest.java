package com.example.ec.domain;

import org.junit.Test;

import static com.example.ec.domain.Difficulty.Difficult;
import static com.example.ec.domain.Region.Central_Coast;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Mary Ellen Bowman.
 */
public class TourTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Tour tour = TestHelper.makeTour();
        assertNull(tour.getId());
        assertThat(tour.getTitle(), is("title"));
        assertThat(tour.getDescription(), is("description"));
        assertThat(tour.getBlurb(), is("blurb"));
        assertThat(tour.getPrice(), is(50));
        assertThat(tour.getDuration(), is("1 day"));
        assertThat(tour.getBullets(), is("bullets"));
        assertThat(tour.getKeywords(), is("keywords"));
        assertThat(tour.getTourPackage().getCode(), is("code"));
        assertThat(tour.getDifficulty(), is(Difficult));
        assertThat(tour.getRegion(), is(Central_Coast));
    }

    @Test
    public void equalsHashcodeVerify() throws IllegalAccessException {
        Tour tour1 = TestHelper.makeTour();
        Tour tour2 = TestHelper.makeTour();

        assertThat(tour1, is(tour2));
        assertThat(tour1.hashCode(), is(tour2.hashCode()));
    }

}