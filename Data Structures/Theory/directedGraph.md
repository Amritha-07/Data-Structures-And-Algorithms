# Directed Graph

## Introduction
A **Directed Graph (Digraph)** is a graph where edges have a **direction**, meaning each connection goes **from one node to another** but not necessarily back.

## Basic Structure
- Contains:
  - **Vertices (Nodes)**
  - **Directed Edges** (u → v)
- Direction matters:
  - `A → B` does **not** imply `B → A`
- Can include:
  - **Self-loops** (A → A)
  - **Multiple edges**
  - **Cycles**

### Example Representation
A → B → C  
↑       ↓  
F ← E ← D

## Operations
| Operation | Description |
|----------|-------------|
| Add Vertex | Insert a new node |
| Add Edge | Insert a directed edge u → v |
| Remove Vertex | Delete node and all associated edges |
| Remove Edge | Delete a directed edge |
| DFS / BFS | Traverse graph following edge direction |
| Topological Sort | Ordering for DAGs |
| Check Connectivity | Strongly connected or not |

## How Searching Works (DFS/BFS)
1. Start at a **source node**.  
2. Move through **outgoing edges (u → v)**.  
3. Mark visited nodes.  
4. Continue until all reachable nodes are visited.

> Traversal direction affects reachability.

## Properties
- **In-degree** = number of incoming edges  
- **Out-degree** = number of outgoing edges  
- **DAGs** (Directed Acyclic Graphs) are used for scheduling and dependencies.

## Time & Space Complexity
| Operation | Adjacency List | Adjacency Matrix |
|----------|-----------------|------------------|
| Add Vertex | O(1) | O(V²) |
| Add Edge | O(1) | O(1) |
| Search (DFS/BFS) | O(V + E) | O(V²) |
| Space | O(V + E) | O(V²) |

## Advantages
- Represents **one-way relationships**
- Models **dependencies**
- Efficient for sparse graphs
- Realistic direction modeling

## Disadvantages
- Direction increases traversal complexity
- Cycle detection is harder
- Dense graphs use a lot of memory

## Applications
- **Navigation systems** (one-way roads)
- **Web page linking**
- **Task scheduling (DAG)**
- **Dependency graphs**
- **Flow networks**