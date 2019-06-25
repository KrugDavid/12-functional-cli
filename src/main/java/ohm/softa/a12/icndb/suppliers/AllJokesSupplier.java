package ohm.softa.a12.icndb.suppliers;

import ohm.softa.a12.icndb.ICNDBApi;
import ohm.softa.a12.icndb.ICNDBService;
import ohm.softa.a12.model.JokeDto;
import ohm.softa.a12.model.ResponseWrapper;
import org.apache.commons.lang3.NotImplementedException;

import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Supplier implementation to retrieve all jokes of the ICNDB in a linear way
 * @author Peter Kurfer
 */

public final class AllJokesSupplier implements Supplier<ResponseWrapper<JokeDto>> {

    /* ICNDB API proxy to retrieve jokes */
    private final ICNDBApi icndbApi;
    int count = 0;
    int current = 0;
    int retrieved = 0;

    public AllJokesSupplier() throws ExecutionException, InterruptedException {
        icndbApi = ICNDBService.getInstance();
        /* TODO fetch the total count of jokes the API is aware of
         * to determine when all jokes are iterated and the counters have to be reset */
        count = icndbApi.getJokeCount().get().getValue();
    }

    public ResponseWrapper<JokeDto> get() {
        /* TODO retrieve the next joke
         * note that there might be IDs that are not present in the database
         * you have to catch an exception and continue if no joke was retrieved to an ID
         * if you retrieved all jokes (count how many jokes you successfully fetched from the API)
         * reset the counters and continue at the beginning */
        if(count==0)
        	return null;
        ResponseWrapper<JokeDto> retrievedJoke;

        do {
			if(retrieved>=count)
			{
				retrieved = 0;
				current = 0;
			}
			try {
				retrievedJoke = icndbApi.getJoke(++current).get();
				retrieved++;
			} catch (InterruptedException | ExecutionException e) {
				retrievedJoke = null;
			}
		}while(retrievedJoke==null);

        return retrievedJoke;
        //throw new NotImplementedException("Method `get()` is not implemented");
    }

}
