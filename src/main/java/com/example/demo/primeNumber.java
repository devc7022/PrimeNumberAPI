package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class primeNumber {

    @GetMapping("/isprime/{number}")
    public PrimeResponse isPrime(@PathVariable int number) {
        return new PrimeResponse(number, isPrimeN(number));
    }

    private boolean isPrimeN(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static class PrimeResponse {
        private int number;
        private boolean isPrime;

        public PrimeResponse(int number, boolean isPrime) {
            this.number = number;
            this.isPrime = isPrime;
        }

        public int getNumber() {
            return number;
        }

        public boolean isIsPrime() {
            return isPrime;
        }
    }
}

