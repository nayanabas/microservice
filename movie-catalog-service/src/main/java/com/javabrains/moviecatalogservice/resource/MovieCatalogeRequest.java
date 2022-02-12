package com.javabrains.moviecatalogservice.resource;

import com.javabrains.moviecatalogservice.Model.CatalogItem;
import com.javabrains.moviecatalogservice.Model.Movie;
import com.javabrains.moviecatalogservice.Model.Rating;
import com.javabrains.moviecatalogservice.Model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogeRequest {

    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/{userId}")
    List<CatalogItem> getMovieCatalog(@PathVariable String userId){
       /* List<Rating> ratingList = Arrays.asList(
                new Rating("1234",4),
                new Rating("5678",5),
                new Rating("9876",3)
        );*/
        UserRating userRating = restTemplate.getForObject("http://movie-ratings-service:8083/ratingsdata/users/"+userId,UserRating.class);
        return userRating.getRatingList().stream().map(rating -> {
                  //  RestTemplate restTemplate =new RestTemplate();
                    Movie movie = restTemplate.getForObject("http://movie-info-service:8082/movies/"+rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "desc", rating.getRating());
                }).
                collect(Collectors.toList());

       /* return Collections.singletonList(
                new CatalogItem("bahubali", "historical",5)
        );*/
    }
}
