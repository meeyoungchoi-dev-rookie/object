package com.book.object.chap03_1.chap03.screening;

import com.book.object.chap03_1.chap03.Movie.Movie;
import com.book.object.chap03_1.chap03.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
                break;
            case NONE_DISCOUNT:
                movie.calculateNoneDiscountedFee().times(audienceCount);
        }
        return movie.calculatePercentDiscountedFee().times(audienceCount);
    }
}
