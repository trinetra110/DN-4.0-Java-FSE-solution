
# 💸 Exercise 7: Financial Forecasting

This project demonstrates how to use **recursive algorithms** in Java to forecast future financial values based on past data and a constant growth rate.

## ✅ Steps Completed

### 1. Understand Recursive Algorithms

Recursion is a programming technique where a function calls itself to solve smaller instances of the same problem.

How recursion simplifies problems:

- Divide-and-conquer approach: Breaks complex problems into smaller, identical subproblems

- Natural expression: Many problems (like financial forecasting) are naturally recursive - future values depend on past values

- Code simplicity: Often results in cleaner, more readable code compared to iterative solutions

- State management: Automatically handles state through the call stack

In our case, recursion elegantly expresses the idea that each forecast builds upon the previous one, mirroring how financial forecasting works in reality.

### 2. Setup

Please refer to the code.

### 3. Implementation

Please refer to the code.

### 4. Analysis

#### **A. Time Complexity Analysis**

**For the recursive algorithm**:
- **Time Complexity**: O(k²) where k is number of forecast periods
  - Each recursive call involves O(n) operations (growth rate calculation + array copy)
  - With k calls, total operations sum to O(k²) when k dominates initial array size

#### **B. Optimization Approaches**

1. **Tail Recursion Optimization**:
   - Rewrite recursion so the recursive call is the last operation
   - Enables compiler optimization into a loop

2. **Iterative Conversion**:
   - Replace recursion with a loop to avoid stack overhead
   - More memory efficient for large forecasts

3. **Memoization**:
   - Cache growth rate calculations to avoid recomputation
   - Store intermediate results

4. **Growth Rate Optimization**:
   - Maintain running total of growth rates
   - Update incrementally rather than recalculating