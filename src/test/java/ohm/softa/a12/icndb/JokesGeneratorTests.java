package ohm.softa.a12.icndb;

import ohm.softa.a12.model.JokeDto;
import ohm.softa.a12.model.ResponseWrapper;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Peter Kurfer
 * Created on 12/28/17.
 */
class JokesGeneratorTests {

    private JokeGenerator jokeGenerator = new JokeGenerator();

    @Test
    void testRandomStream() {
        /* timeout to ensure that stream does not loop forever */
        /* TODO implement a test for the random joke stream */

		assertTimeout(Duration.ofMinutes(1L),()->jokeGenerator.randomJokesStream()
			.filter(o->o!=null)
			.skip(200)
			.limit(400)
			.map(ResponseWrapper::getValue)
			.map(JokeDto::getJoke)
			.forEach(System.out::println));
    }


    @Test
    void testJokesStream() {
        /* TODO implement a test for the linear jokes generator */
		assertTimeout(Duration.ofSeconds(5L),()->jokeGenerator.jokesStream()
			.filter(o->o!=null)
			.skip(0)
			.limit(5)
			.map(ResponseWrapper::getValue)
			.map(JokeDto::getJoke)
			.forEach(System.out::println));
    }

}
