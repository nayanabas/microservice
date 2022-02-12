package com.javabrains.ratingsservice.resource;

import com.javabrains.ratingsservice.model.Rating;
import com.javabrains.ratingsservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
    List<Rating> ratingList;

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable String movieId){
        return new Rating(movieId,4);

    }
    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable String userId){
        ratingList = Arrays.asList(
                new Rating("550",4)
        );
        UserRating userRating = new UserRating();
         userRating.setRatingList(ratingList);
         return userRating;

    }

}
