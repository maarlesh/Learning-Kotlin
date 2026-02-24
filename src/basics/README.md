## 1. Prime Number

**File:** `src/basics/PrimeNumber.kt`

### Description
Utility class to:
- Check if a number is prime
- Generate all prime numbers up to a given range

Uses √n optimization for primality check.

---

### Class
`PrimeNumber`

#### Constructor
- `PrimeNumber()`

---

### Methods

#### `getN(range: Int): Array<Int>`
- **Description:**  
  Returns all prime numbers from `2` to `range`
- **Parameters:**
    - `range`: range of natural numbers to be given
- **Returns:**  
  `Array<Int>` – array of prime numbers
- **Time Complexity:**  
  `O(n √n)`
- **Notes:**  
  Uses repeated array resizing (`+=`)  
  Can be optimized using `MutableList` or `IntArray`

---

#### `isPrime(num: Int): Boolean`
- **Description:**  
  Checks whether a given number is prime
- **Parameters:**
    - `num`: number to be checked
- **Returns:**  
  `true` if prime, `false` otherwise
- **Time Complexity:**  
  `O(√n)`

---

### Concepts Used
- `if / else`
- `for` loops
- `break`
- `range (..)`
- `kotlin.math.sqrt`