/**
 * A collection of methods that work with arrays of ints.
 * 
 * @author mvail
 */
public class MethodsToAnalyze {

	// VARIABLE ADDED FOR TESTING
	private static int numStatements = 0;

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static int find(int[] array, int value) {
		// ADDED FOR TESTING
		numStatements += 2; // for loop initialization and checking i < array.length

		for (int i = 0; i < array.length; i++) {
			// ADDED FOR TESTING
			numStatements += 1; // if statement condition check
			if (array[i] == value) {
				return i;
			}
			// ADDED FOR TESTING
			numStatements += 2; // i++ and check i < array.length
		}
		return -1;
	}

	/**
	 * Replace all occurrences of oldValue with newValue in array.
	 * @param array ints where oldValue may be found
	 * @param oldValue value to replace
	 * @param newValue new value
	 */
	public static void replaceAll(int[] array, int oldValue, int newValue) {
		// ADDED FOR TESTING
		numStatements += 2; // initializing index value and first while check. numstatements is increased in find()
		int index = find(array, oldValue);
		while (index > -1) {
			// ADDED FOR TESTING
			numStatements += 3; // setting array at index to newValue, setting index, checking while loop
			array[index] = newValue;
			index = find(array, oldValue); // numstatements will increase with find()
		}
	}
	
	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static void sortIt(int[] array) {
		// +2 statements for initializing next and checking condition
		numStatements += 2;
		for (int next = 1; next < array.length; next++) {
			// +4 statements - setting value, setting index, checking while loop condition
			numStatements += 4;
			int value = array[next];
			int index = next;
			while (index > 0 && value < array[index - 1]) {
				//+4 statements - setting array[index], decrementing index, checking while loop
				numStatements += 4;
				array[index] = array[index - 1];
				index--;
			}
			// +1 statement - setting array[index]
			numStatements += 1;
			array[index] = value;

			// +2 statements - iterating next and checking for loop condition
			numStatements += 2;
		}
	}

	public static void main(String[] args) {
		MethodsToAnalyze myMethod = new MethodsToAnalyze();
		int[] array = new int[3];
		int value = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = value;
			value++;
		}
		MethodsToAnalyze.sortIt(array);
		System.out.println("Number of statements is: " + numStatements);
	}
}
