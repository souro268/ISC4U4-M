package Assignment15;
import Assignment15.PersonPackage.Person;



public class Main {

	public static void main(String[] args) {

		//Create an array of people:
		Person[] people = new Person[] {
				new Person("Adam", 15),
				new Person("Becky", 26),
				new Person("Carter", 5),
				new Person("Davis", 42),
				new Person("Everly", 16),
				new Person("Francis", 18),
				new Person("Grant", 27)
		};

		
		mergeSort(people);
		

		//Show the list of people
		display(people);
	}


	//output all of the people in the array; show their name and age
	public static void display(Person[] people)
	{
		//COMPLETE THIS
		// displays the name and their age
		for(int i = 0; i < people.length; i++){
			System.out.println("Name: " + people[i].getName() + " - Age: " + people[i].getAge());
			
		}

		
	}

	
	//You can also use MergeSort if you wish:
	public static void mergeSort(Person[] people)
	{
		mergeSort(people, 0, people.length-1);
	}
	
	//This is the actual recursive part of the mergeSort
	private static void mergeSort(Person[] people, int startIndex, int endIndex)
	{
		//BASE CASE:  If the length of the array is 1 or less, it's already sorted
		if (startIndex >= endIndex){//checking to see that the start index isnt bigger than the end index
            return; // ending the function. But returning nothing as it is a void function
        }
		
		//RECURSIVE STEP:
		//Find the midpoint of this part of the array
		int mid = (startIndex + endIndex)/2;//calculating the middle of the array
		//mergeSort the left half (recursive)
		mergeSort(people, startIndex, mid);
		//mergeSort the right half (recursive)
		mergeSort(people, mid+1, endIndex);//strarting with mid+1 as to not have duplicates of the midth index
		//merge the two halves together
		merge(people, startIndex, endIndex);
		//Done!
	}
	
	//Merge together two sorted
	private static void merge(Person[] people, int startIndex, int endIndex)
	{
		//Create a temporary array, with enough space to hold everything from startIndex to
		//endIndex
		Person[] temp = new Person[endIndex - startIndex +1];
		//Walk through the two halves of this section of the array, always copying the smaller
		//value into our temporary array
		
		//Finally, copy the contents of the temporary array back into the main array
		int mid = (startIndex + endIndex)/2; // middle of array
		int leftIndex = startIndex;      // variable for left half array
		int rightIndex = mid + 1;        // variable for right half array
		int tempIndex = 0;               // variable for temp array

		// Merge by comparing age of persons from both halves
		while (leftIndex <= mid && rightIndex <= endIndex) {
			// If the current element in the left half is smaller or equal (based on age),
			// then copy it into the temp array.
			if (people[leftIndex].getAge() <= people[rightIndex].getAge()) {
				// Copy the person from the left half into temp
				temp[tempIndex] = people[leftIndex];
				tempIndex++;
				leftIndex++;
			} else {
				// Otherwise, copy the person from the right half into temp
				temp[tempIndex] = people[rightIndex];
				tempIndex++;
				rightIndex++;
			}
		}

		// Copy any remaining elements from the left half
		while (leftIndex <= mid) {
			temp[tempIndex] = people[leftIndex];
			tempIndex++;
			leftIndex++;
		}

		// Copy any remaining elements from the right half
		while (rightIndex <= endIndex) {
			temp[tempIndex] = people[rightIndex];
			tempIndex++;
			rightIndex++;
		}

		// Copy sorted data back into the original array
		for (int i = 0; i < temp.length; i++) {
			people[startIndex + i] = temp[i];
		}
		
	}
}
