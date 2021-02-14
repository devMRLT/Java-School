public class recursionLabDriver {
	static int count;
	public static void main(String[] args) {
		System.out.println("Fibonacci:");
		int n = 15;
		//fib rec
		resetCallCount();
		int recursiveResult = fibonacciRec(n);
		int recursiveCalls = getCallCount();
		System.out.printf("Recursive result: %d (%d recursive calls)\n",
			recursiveResult, recursiveCalls);
		//fib loop
		resetCallCount();
		int iterativeResult = fibonacciIter(n);
		int iterations = getCallCount();
		System.out.printf("Iterative result: %d (%d iterations)\n", 
			iterativeResult, iterations);
		for (int i=0; i< 50; i++) {
			System.out.print("-");
		}
		//Tower of Hanoi
		System.out.println("\nTowers of Hanoi:");
		solveHanoi(1, 3, 2, 4);
	}
	public static int getCallCount(){return count++;}
	public static int resetCallCount(){return count = 0;}
	//part 1 a
	public static int fibonacciRec(int n){
	if ((n == 1) || (n ==0)) {
		getCallCount();
		return n;
	}else{
		getCallCount();
		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
	}
}
	//using a loop to iterate
	public static int fibonacciIter(int n){
		int x=0, y=1, z=1;
		for (int i=0; i<n; i++) {
			x=y;
			y=z;
			z=x+y;
			getCallCount();
		}
		return x;
	}
	//part 2 of lab
	public static void move1(int source, int dest){
		System.out.printf("Move top ring from %d to %d.\n", source, dest);
	}
	public static void solveHanoi(int source, int dest, int temporaryHolder, int n){
		if(n == 1){
			move1(source, dest);
			return;
		}else{
			solveHanoi(source, temporaryHolder, dest, n-1);
			//System.out.println("Move disk " + n + " from rod " + source + " to rod " + dest);
			solveHanoi(temporaryHolder, dest, source, n-1);
			return;
		}
	}
}
