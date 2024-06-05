import java.util.Arrays;


/*

Function:
- takes 3 parameters
  - “list1” - list of signed integers sorted in ascending order
  - “list2" - list of signed integers sorted in ascending order
  - “maxSize” - (integer) maximum number of elements in the output

- output
  - merged list of list1 and list2, maintaining the ascending sort,
     of up to “maxSize” elements in length

Example:

  ([0,2,6], [-1,7,9], 4) = [-1,0,2,6]

  ([1,2,3], [4,5,6], 4) = [1,2,3,4]

Notes:
 - brute force
 - more optimal solutions?
 - happy path input
 - edge cases
 - lists have differing lengths
 - appending 2 lists into 1 list. Downside:  allocates a large array. Doesn't work for
   large inputs.
 - TreeSet (SortedSet)
     - add list1 into TreeSet
     - add list2 into TreeSet
  - Primitive int vs java.lang.Integer
      Integer objects consume more memory than a primitive int
  - Eclipse Collections --- primitive collections
  - for loops approach

 */
public class Hello {
  public static void main(String[] args) {
    int [] input1 = new int[] { 0,2,6 };
    int [] input2 = new int[] { -1,7,9 };
    int maxSize = 4;

    int[] result = solve(input1, input2, maxSize);
    System.out.print(Arrays.toString(result));
  }

  static int[] solve(int[] list1, int[] list2, int maxSize) {
    int resultSize = Math.min(list1.length + list2.length, maxSize);
    int[] result = new int[resultSize];

    int resultIndex = 0;

    int list1Index = 0;
    int list2Index = 0;
    int value = 0;

    while (resultIndex < result.length) {

      if (list1Index >= list1.length) {
        value = list2[list2Index];
        list2Index++;
      }
      else if (list2Index >= list2.length) {
        value = list1[list1Index];
        list1Index++;
      }

      if ((list1Index < list1.length) && (list2Index < list2.length)) {
        if (list1[list1Index] < list2[list2Index]) {
          value = list1[list1Index];
          list1Index++;
        } else {
          value = list2[list2Index];
          list2Index++;
        }
      }

      result[resultIndex] = value;
      resultIndex++;
    }

    return result;
  }
}
