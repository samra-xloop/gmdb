package com.galvanize.gmdb.gmdb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.gmdb.gmdb.controller.MoviesController;
import com.galvanize.gmdb.gmdb.controller.ReviewController;
import com.galvanize.gmdb.gmdb.controller.ReviewerController;
import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.repository.IMoviesRepository;
import com.galvanize.gmdb.gmdb.repository.IReviewersRepository;
import com.galvanize.gmdb.gmdb.repository.IReviewsRepository;


@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class GmdbApplicationTests {

    private MockMvc mvc_movie;
    private MockMvc mvc_review;
    private MockMvc mvc_reviewer;

    private Movie movie;
    private Review review;
    private Reviewer reviewer;
    
    @Mock
    private IMoviesRepository movie_repo;
    @Mock
    private IReviewersRepository reviewer_repo;
    @Mock
    private IReviewsRepository review_repo;

    @InjectMocks
    private MoviesController movie_cont;
    @InjectMocks
    private ReviewController review_cont;
    @InjectMocks
    private ReviewerController reviewer_cont;

    private JacksonTester<Reviewer> jsonReviwer;
    private JacksonTester<Review> jsonReview;


    @BeforeEach
    public void setUp(){
        JacksonTester.initFields(this, new ObjectMapper());
        mvc_movie= MockMvcBuilders.standaloneSetup(movie_cont).build();
        mvc_review= MockMvcBuilders.standaloneSetup(review_cont).build();
        mvc_reviewer= MockMvcBuilders.standaloneSetup(reviewer_cont).build();
    }





	// Stories for this project are shown below in order of value, with the highest value listed first.
    // This microservice will contain the CRUD operations required to interact with the GMDB movie database.
    // Other functionality (e.g. user authentication) is hosted in other microservices.
    //
    // 1. As a user
    //    I can GET a list of movies from GMDB that includes Movie ID | Movie Title | Year Released | Genre | Runtime
    //    so that I can see the list of available movies.

    @Test
    public void can_get_movies_list() throws Exception{
        Movie movie= new Movie("interstellar",2014,"sci-fi",169);
        Movie movie2= new Movie("Transcendence",2014,"sci-fi",129);
        Movie movie3= new Movie("Following",1998,"drama",69);

        List<Movie> movies= new ArrayList<>(List.of(movie,movie2,movie3));
        when(movie_repo.findAll()).thenReturn(movies);
            mvc_movie.perform(get("/movies/all").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
            

    }
    //
    // 2. As a user
    //    I can provide a movie ID and get back the record shown in story 1, plus a list of reviews that contains Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    //    so that I can read the reviews for a movie.
    @Test
    public void can_get_movie_byID() throws Exception{
        Movie movie= new Movie("interstellar",2014,"sci-fi",169);
        movie.setId(1L);
        Review review =new Review("fantastic");
        movie.setReviews(List.of(review));
        when(movie_repo.findById(1L)).thenReturn(Optional.of(movie));
            mvc_movie.perform(get("/movies/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
            

    }
    
    //
    // 3. As a user
    //    I can provide a Reviewer ID and get back a record that contains Reivewer ID | Username | Date Joined | Number of Reviews
    //    so that I can see details about a particular reviewer.
    //

    @Test
	public void get_reviewer_ById() throws Exception {
        Reviewer reviewer = new Reviewer("Samra");
        reviewer.setId(1L);
		when(reviewer_repo.findById(1L)).thenReturn(Optional.of(reviewer));
		mvc_reviewer.perform(get("/reviewers/1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

    
    // 4. As a user
    //    I can register as a reviewer by providing my Username. (Reviewer ID should be autogenerated)
    //    So that I can start reviewing movies.
    //
    @Test void reviwer_can_register_by_username() throws Exception{
        Reviewer reviewer=new Reviewer("Samra");
        mvc_reviewer.perform(post("/reviewers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonReviwer.write(reviewer).getJson()))
        .andExpect(status().isOk());
    }
    // 5. As a reviewer
    //    I can post a review by providing my reviewer ID, a movie ID and my review text. (Review ID should be autogenerated)
    //    So that I can share my opinions with others.

    @Test
    public void can_generate_review() throws Exception{
        
        Movie movie= new Movie("interstellar",2014,"sci-fi",169);
        movie.setId(1L);
        Reviewer reviewer=new Reviewer("Samra");
        reviewer.setId(1L);
        Review review =new Review("fantastic movie");
        review.setId(1L);
        review.setMovie(movie);
        review.setReviewer(reviewer);
        reviewer.setReviews(new ArrayList<>(List.of(review)));

        when(movie_repo.findById(1L)).thenReturn(Optional.of(movie));
        when(reviewer_repo.findById(1L)).thenReturn(Optional.of(reviewer));
        when(review_repo.save(review)).thenReturn(review);

        mvc_review.perform(post("/reviews/1/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonReview.write(review).getJson()))
        .andExpect(status().isOk());
    }
    // 6. As a reviewer
    //    I can delete a review by providing my reviewer ID and a review ID
    //    So that I can remove reviews I no longer wish to share.

    // 7. As a reviewer
    //    I can update a review by providing my reviewer ID, a movie ID and my review text.
    //    So that I can modify the opinion I'm sharing with others.
    //
    // 8. As an Admin
    //    I can add a new movie to the database by providing the data listed in story 1 (Movie ID should be autogenerated)
    //    so that I can share new movies with the users.
    // 9. As an Admin
    //    I can add update the entry for a movie by providing the data listed in Story 1.
    //    so that I can correct errors in previously uploaded movie entries.
    //
    //10. As an admin
    //    I can delete a movie by providing a movie ID
    //    so that I can remove movies I no longer wish to share.
    //
    //11. As an admin
    //    I can impersonate a reviewer and do any of the things they can do
    //    so that I can help confused reviewers.
    

}
