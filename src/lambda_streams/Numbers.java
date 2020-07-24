
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Numbers {
    static List<Integer> nums = Arrays.asList(10, 100, 1000, 5, 50, 500, 3, 30, 300, 7, 70, 700, 1, 10, 100, 25, 250, 2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams
        // to compute the results wherever possible.
        System.out.println(nums);
//
//
//        System.out.println(isOdd(3));
//        System.out.println(isOdd(2));
//        System.out.println(isEven(3));
//        System.out.println(isEven(2));
//        System.out.println(isPrime(0)+" "+nums.get(0));
//        System.out.println(isPrime(9)+" "+nums.get(9));
//        System.out.println(isPrime(12)+" "+nums.get(12));
//
//        System.out.println(added());
//        System.out.println(subtracted());
//        System.out.println(multipled());
//        System.out.println(divided());
//        System.out.println(findMax());
//        System.out.println(findMin());
//        System.out.println(compare(2,5));
//        System.out.println(compare(5,2));
//        System.out.println(compare(0,13));
//        System.out.println(append(77));
//        System.out.println(nums);


        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions
        // directly inside the method calls, or define them first, then pass them into the methods. give them the same
        // names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.
        added(() -> {});
        OR
        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});
        OR
        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...
        */

        LambdaBoolean lambdaIsOdd = (index) -> {
            boolean ifOdd = nums.stream()
                    .filter(x -> (x % 2) == 1)
                    .anyMatch(x -> x.equals(nums.get(index)));
            return ifOdd;
        };
        System.out.println(lambdaIsOdd.work(3));
        System.out.println(lambdaIsOdd.work(2));



        LambdaBoolean lambdaIsEven = (index) -> {
            boolean ifEven = nums.stream()
                    .filter(x -> (x % 2) == 0)
                    .anyMatch(x -> x.equals(nums.get(index)));
            return ifEven;
        };
        System.out.println(lambdaIsOdd.work(3));
        System.out.println(lambdaIsOdd.work(2));


        LambdaBoolean lambdaIsPrime = (index)->{
            List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
            boolean ifPrime = primes.stream()
                .anyMatch(x -> x.equals(nums.get(index)));
            return ifPrime;
        };
        System.out.println(lambdaIsPrime.work(0)+" on prime");
        System.out.println(lambdaIsPrime.work(9)+" on prime");
        System.out.println(lambdaIsPrime.work(12)+" on prime");


        LambdaSequence lambdaAdded = () ->{
        int sum = nums.stream()
                .reduce(0,(a,b)-> a+b);
        return sum;
    };
        System.out.println(lambdaAdded.calculate()+" is the sum");


        LambdaSequence lambdaSubtracted = () ->{
        int sum = nums.stream()
                .reduce(0,(a,b)-> a-b);
        return sum;
    };
        System.out.println(lambdaSubtracted.calculate()+" is the sum");

        LambdaSequence2 lambdaMultiplied = () ->{
        double sum = nums.stream()
                .mapToDouble(x->x)
                .reduce(1d,(a,b)-> a*b);
        return sum;
    };
        System.out.println(lambdaMultiplied.figure()+" is the sum");

        LambdaSequence2 lambdaDivided = () ->{
        double sum = nums.stream()
                .mapToDouble(x->x)
                .reduce(1d,(a,b)-> a/b);
        return sum;
    };
        System.out.println(lambdaDivided.figure()+" is the sum");


    LambdaInteger lambdaFindMax = () -> {
        Integer max = nums.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        return max;
    };
        System.out.println(lambdaFindMax.find()+" is the max");

    LambdaInteger lambdaFindMin = () -> {
        Integer min = nums.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        return min;
    };
        System.out.println(lambdaFindMin.find()+" is the min");


    LambdaCompare lambdaCompare = (firstIndex,secondIndex)-> {
            int firstInt = nums.stream()
                    .filter(x -> x.equals(nums.get(firstIndex)))
                    .findFirst().get();

            int secondInt = nums.stream()
                    .filter(x -> x.equals(nums.get(secondIndex)))
                    .findFirst().get();

            if (firstInt > secondInt) {
                return 1;
            } else if (firstInt < secondInt) {
                return -1;
            }
            return 0;
    };
        System.out.println(lambdaCompare.comp(2,5));
        System.out.println(lambdaCompare.comp(5,2));
        System.out.println(lambdaCompare.comp(0,13));




    LambdaNewElement lambdaAppend = (newElement) -> {
        Stream<Integer> newStream = Stream.concat(nums.stream(), Stream.of(newElement));
                int newInt = newStream
                    .skip(nums.stream().count()).findFirst().get();
                return newInt;
        };
        System.out.println(lambdaAppend.append(77));







    }

}
    interface LambdaBoolean{
        public boolean work(int b);
    }
    interface LambdaSequence{
        public int calculate();
    }

    interface LambdaSequence2{
        public double figure();
    }

    interface LambdaInteger{
        public int find();
    }
    interface LambdaCompare{
        public int comp(int a, int b);
    }
    interface LambdaNewElement{
        public int append(int a);
    }


//    static boolean isOdd(int i) {
//        //determine if the value at the index i is odd.  return true if yes, return false if  no.
//         boolean ifOdd = nums.stream()
//                .filter(x -> x % 2==1)
//                .anyMatch(x -> x.equals(nums.get(i)));
//        return ifOdd;
//    }
//
//    static boolean isEven(int i) {
//        //determine if the value at the index i is even.  return true if yes, return false if  no.
//        boolean ifEven = nums.stream()
//                .filter(x -> x % 2==0)
//                .anyMatch(x -> x.equals(nums.get(i)));
//        return ifEven;
//    }
//
//    static boolean isPrime(int i) {
//         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
//        List<Integer> primes = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97);
//        boolean ifPrime = primes.stream()
//                .anyMatch(x -> x.equals(nums.get(i)));
//        return ifPrime;
//    }
//
//    static int added() {
//        //add all the elements in the list.  return the sum.
//        int sum = nums.stream()
//                .reduce(0,(a,b)-> a+b);
//
//        return sum;
//    }
//
//    static int subtracted() {
//        //subtract all the elements in the list. return the remainder.
//        int sum2 = nums.stream()
//                .reduce(0,(a,b)-> a-b);
//
//        return sum2;
//    }
//
//    static double multipled() {
//        //multiply all the elements in the list and return the product.
//        double sum3 = nums.stream()
//                .mapToDouble(x -> x)
//                .reduce(1d,(a,b)-> a*b);
//
//        return sum3;
//    }
//
//    static double divided() {
//        //divide all the elements in the list and return the product.
//        double sum4 = nums.stream()
//                .mapToDouble(x -> x)
//                .reduce(1d,(a, b)-> a/b);
//
//        return sum4;
//    }
//
//    static int findMax() {
//         //return the maximum value in the list.
//        Integer max = nums.stream()
//                .max(Comparator.comparing(Integer::valueOf))
//                .get();
//        return max;
//    }
//
//    static int findMin() {
//        //return the minimum value in the list.
//        Integer min = nums.stream()
//                .min(Comparator.comparing(Integer::valueOf))
//                .get();
//        return min;
//    }
//
//    static int compare(int i, int j) {
//        //compare the values stored in the array at index position i and j.
//        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are
//        // equal, return 0.
//        int firstInt = nums.stream()
//                .filter(x->x.equals(nums.get(i)))
//                .findFirst().get();
//
//        int secondInt = nums.stream()
//                .filter(x->x.equals(nums.get(j)))
//                .findFirst().get();
//
//        if(firstInt>secondInt){
//            return 1;
//        }else if(firstInt<secondInt){
//            return -1;
//        }
//                //.forEach();
//        return 0;
//    }
//
//    static int append(int n) {
//        //add a new value to the values list. return that value after adding it to the list.
//        Stream<Integer> newStream = Stream.concat(nums.stream(), Stream.of(n));
//        int newInt = newStream
//                .skip(nums.stream().count()).findFirst().get();
//        return newInt;
//    }
//}


