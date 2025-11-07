# Skip List

## Introduction
A **Skip List** is a probablistic data structure that maintains a stored list of elements with efficient search, insertion and deletion. It work similar to that of **Linked List** but with different levels of forward pointer that allows to skip node, thus achieving algorithmic time complexity.

## Basic Structure
- A **Skip List** consist of multiple levels.
- Level 0: contains all the elements (basic **Linked List**).
- Higher Levels: fewer elements chosen randomly that allows to skip nodes
- Each node may contain:
    - **Data**
    - **Array of forward pointers** (one for each level the node participates in)
- The **height** of each node is assigned using a random coin flip strategy, giving Skip Lists their self-balancing behavior.

Level 3: A -------------------------> G

Level 2: A ----------> D -----------> G

Level 1: A -> B ------> D ------> F -> G

Level 0: A -> B -> C -> D -> E -> F -> G

## Operations
| Operation | Description |
|----------|-------------|
| Search | Start at highest level; move forward until key is exceeded; drop down a level and continue |
| Insert | Search for position; insert new node with random height; update forward pointers at all relevant levels |
| Delete | Search for node; remove it from all levels by updating forward pointers |
| Traverse | Start from Level 0 and move forward |
| Random Level Generation | Flip coins to decide how many levels the node should occupy |

## How Searching Works
1. Begin at the topmost level.
2. Move forward while the next node’s value is **less than the search key**.
3. When you can't move forward, go **one level down**.
4. Repeat until you reach Level 0.
5. Check if the node matches the key.

> This process gives **O(log n)** expected search time.

## Height & Probability
Skip List balance is maintained using randomization:
- Each time a node is inserted, it is promoted to a higher level with probability **P = 0.5** (commonly).
- Expected height of a node ≈ O(log n)
- Maximum number of levels ≈ O(log n)

## Time & Space Complexity
| Operation | Average | Worst Case |
|----------|----------|-------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Space | O(n) | O(n log n) (with many levels) |

> Worst case occurs only if randomization generates poor level heights, but this is extremely rare.

## Advantage
- Easy to implement compared to balanced trees
- Good average-case performance (O(log n))
- Supports concurrency better than tree-based structures
- Ideal for ordered data structures with fast search and updates
- Randomized balancing avoids complex rotations

## Disadvantage
- Worst-case performance is O(n)
- Requires extra memory for multiple levels
- Balancing depends on randomness, not guaranteed
- Overhead of maintaining forward pointers

## Application
- **Databases** (e.g., LevelDB, RocksDB)
- **In-memory stores** (Redis uses Skip Lists for sorted sets)
- **Concurrent applications**
- **Network routing tables**
- **Priority queues** (alternative to heaps)