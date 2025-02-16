public class FizzBuzz {
    private int limit;
    public FizzBuzz(int limit) {
        this.limit = limit;
    }
    public void printFizzBuzz() {
        for (int i = 1; i <= limit; i++) {
            System.out.println(getFizzBuzzValue(i));
        }
    }
    private String getFizzBuzzValue(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }
}