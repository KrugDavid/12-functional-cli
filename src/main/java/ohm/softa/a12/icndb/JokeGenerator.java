package ohm.softa.a12.icndb;

import ohm.softa.a12.icndb.suppliers.AllJokesSupplier;
import ohm.softa.a12.icndb.suppliers.RandomJokeSupplier;
import ohm.softa.a12.model.JokeDto;
import ohm.softa.a12.model.ResponseWrapper;
import org.apache.commons.lang3.NotImplementedException;

import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

/**
 * Generator instance to provide streams of jokes
 * @author Peter Kurfer
 */

public final class JokeGenerator {

    /**
     * Generator for random jokes
     * @return stream of random jokes wrapped in ResponseWrapper objects
     */
    public Stream<ResponseWrapper<JokeDto>> randomJokesStream() {
        /* TODO create new Stream of random jokes */
		var prngStream = Stream.generate(new RandomJokeSupplier());
		return prngStream;
        //throw new NotImplementedException("Method `randomJokeStream()` is not implemented");
    }

    /**
     * Generator for jokes ordered by their id
     * @return stream of jokes wrapped in ResponseWrapper objects
     */
    public Stream<ResponseWrapper<JokeDto>> jokesStream() throws ExecutionException, InterruptedException {
        /* TODO create a new Stream of all jokes */
		var prngStream = Stream.generate(new AllJokesSupplier());
		return prngStream;

		//throw new NotImplementedException("Method `jokesStream()` is not implemented");
    }
}
