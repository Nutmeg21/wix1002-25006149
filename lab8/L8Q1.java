import java.util.*;

public class L8Q1 {
    public static void main(String[] args) {
        Number a = new Number();
        Number b = new Number(5);
        Number c = new Number(4, 50);
        a.getAll();
        b.getAll();
        c.getAll();
    }
}

class Number {
    int size = 10;
    int[] arr;
    int bound = 100;
    
    // For default values
    public Number()
    {
        arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(bound + 1);
        }
    }

    // For array size input only
    public Number(int arrSize)
    {
        size = arrSize;
        arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(bound + 1);
        }
    }

    // For user given data upon creation
    public Number(int arrSize, int randBound)
    {
        size = arrSize;
        bound = randBound;
        arr = new int[size];

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(bound + 1);
        }
    }

    public void getElement()
    {
        System.out.println("Array: ");
        for (int x : arr)
        {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void getEven()
    {
        ArrayList<Integer> evens = new ArrayList<>();
        for (int x : arr)
        {
            if (x % 2 == 0)
            {
                evens.add(x);
            }
        }
        if (evens.isEmpty())
        {
            System.out.println("There are no even numbers.");
        }
        else
        {
            System.out.println("Even numbers: ");
            for (int x : evens)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public void getPrime()
    {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if(isPrime(arr[i]))
            {
                primes.add(arr[i]);
            }
        }
        if(primes.isEmpty())
        {
            System.out.println("There are no primes.");
        }
        else
        {
            System.out.println("Primes: ");
            for (int x : primes)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private boolean isPrime(int num)
    {
        if (num < 2)
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void getMaximum()
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = arr[i] > max ? arr[i] : max; 
        }
        System.out.println("Maximum number: " + max);;
    }

    public void getMinimum()
    {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            min = arr[i] < min ? arr[i] : min; 
        }
        System.out.println("Minimum number: " + min);;
    }

    public void getAverage()
    {
        double sum = 0, avg = 0;
        for (int x : arr)
        {
            sum += x;
        }
        avg = sum / arr.length;
        System.out.println("Average: " + avg);
    }

    public void getSquare()
    {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (Math.sqrt(arr[i]) == Math.ceil(Math.sqrt(arr[i])))
            {
                squares.add(arr[i]);
            }
        }
        if (squares.isEmpty())
        {
            System.out.println("There are no square numbers.");
        }
        else
        {
            System.out.println("Squares: ");
            for (int x : squares)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public void getAll()
    {
        getElement();
        getEven();
        getPrime();
        getMaximum();
        getMinimum();
        getAverage();
        getSquare();
    }
}

