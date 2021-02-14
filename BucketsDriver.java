import java.util.*;

class Buckets{
	private List<String> zeroBucket;
	private List<String> oneBucket;

	public Buckets(){
		zeroBucket = new ArrayList<>();//initate the zero bucket arraylist
		oneBucket = new ArrayList<>();//initate the zero bucket arraylist
	}
	public void addZero(String newValue){
		zeroBucket.add(newValue);//adds values to zero bucket
	}
	public void addOne(String newValue){
		oneBucket.add(newValue);//adds values to onesBucket
	}
	public List<String> getAllInOrder(){
		List<String> result = new ArrayList<>();//declare a resulting arraylist

		for (String val: oneBucket) {//for val in range Onebucket add to the result bucket
			result.add(val);
		}
		for(String val: zeroBucket){//for val in range Onebucket add to the result bucket
			result.add(val);
		}
		return result;
    }
    public void clear(){
        zeroBucket.clear();
        oneBucket.clear();
    }
}
public class BucketsDriver{
    public static void main(String[] args) {
        radixSort();
    }
    public static void printArray(List<String> numbers){
        System.out.print("[ ");
		for (int i = 0; i < 5; i++) {
			System.out.print(numbers.get(i) + " ");
		}
		System.out.print("]\n");
	}	
	public static void radixSort(){
		//declares the original numbers in string array
		String[] origNumbers = {"0011", "1001", "1000", "0111", "0101"};
		//declares an array list
		List<String> numbers = new ArrayList<>();
        //declares num as type string and loops in range of the orig
		for(String num: origNumbers){
			numbers.add(num);
        }
        Buckets b = new Buckets();
		printArray(numbers);//prints the updated version of the array
		//check least significant digit first
		for (int binaryDigitIndex = 3; binaryDigitIndex >=0; binaryDigitIndex--){
			for (int binaryWordIndex = 0; binaryWordIndex < 5; binaryWordIndex++){
				if(numbers.get(binaryWordIndex).charAt(binaryDigitIndex) == '0'){
					b.addZero(numbers.get(binaryWordIndex));//gets the array index then gets the index of the sig char
                }else{
                    b.addOne(numbers.get(binaryWordIndex));
                }
            }
			numbers = b.getAllInOrder();
            printArray(numbers);
            b.clear();
		}
    }

}