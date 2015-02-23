import java.util.concurrent.*;

public class Starter {
	
	private static long start=0;
	private static long end=1;
	static Callable<Object> complicatedCalculation = new Callable<Object>() {
		public Object call() throws Exception {
			start=System.currentTimeMillis();
			System.out.println("calculating");
			
			Thread.sleep(1337);
			end=System.currentTimeMillis();
			System.out.println(end-start);
			return "true";
		}

	};

	public static void main(String[] arg) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		try {
			Future<Object> futures = executorService
					.submit(complicatedCalculation);

			System.out.println(futures.get(1400, TimeUnit.MILLISECONDS));
		} catch (final TimeoutException e) {
			System.err.println("Calculation took to long");
		} catch (final Exception e) {
			throw new RuntimeException(e);
		} finally {
			executorService.shutdown();
		}

	}
}