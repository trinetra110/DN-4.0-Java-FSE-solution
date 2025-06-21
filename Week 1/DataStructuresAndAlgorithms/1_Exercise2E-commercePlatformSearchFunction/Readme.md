
# 💸 Exercise 2: E-commerce Platform Search Function

This project demonstrates the implementation and performance comparison of **linear search** and **binary search** algorithms in the context of an e-commerce platform's product search system.

## ✅ Exercise Steps

### 1. Understand Asymptotic Notation

#### **A. Big O Notation and Algorithm Analysis**

Big O notation describes how an algorithm's runtime or space requirements grow as input size increases.

How it helps in analysis:
- Provides upper bound on growth rate
- Allows comparison of algorithm efficiency
- Helps predict performance at scale
- Identifies bottlenecks in code

#### **B. Search Operation Scenarios**

1. **Best-case scenario**:
   - Item found in first position checked
   - O(1) constant time complexity
   - Example: Search for popular product that appears first

2. **Average-case scenario**:
   - Item found after checking half the elements
   - O(n/2) → O(n) for linear search
   - O(log n) for binary search

3. **Worst-case scenario**:
   - Item not present or at last position
   - O(n) for linear search
   - O(log n) for binary search

### 2. Setup

Please refer to the code.

### 3. Implementation

Please refer to the code.

### 4. Analysis

#### **A. Linear Search vs Binary Search**

| Characteristic       | Linear Search         | Binary Search         |
|----------------------|-----------------------|-----------------------|
| Time Complexity      | O(n)                  | O(log n)              |
| Prerequisites        | None                  | Sorted data           |
| Best Case            | O(1)                  | O(1)                  |
| Worst Case           | O(n)                  | O(log n)              |
| Space Complexity     | O(1)                  | O(1) (iterative)      |
| Implementation       | Simple                | More complex          |

#### **B. Algorithm Selection for E-commerce Platform: Hybrid Search**

**Primary Algorithm**: **Binary Search**
- For structured data (products sorted by ID/price)
- Extremely efficient (O(log n)) for large catalogs
- Requires initial sorting overhead

**Fallback to Linear Search**:
- For unstructured data (product descriptions)
- When immediate results needed for small datasets

**Justification**:
1. **Product Database Characteristics**:
   - Large catalog (millions of items)
   - Mostly sorted by product IDs
   - Frequent searches by price range (sorted field)

2. **Performance Requirements**:
   - Sub-second response expected
   - High concurrent user load
   - Scalability crucial

3. **Implementation Strategy**:
   - Pre-sort inventory during database indexing
   - Use binary search for primary fields (ID, price)
   - Implement linear search as fallback for text fields
   - Combine with caching for popular searches
