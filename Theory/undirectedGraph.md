# Undirected Graph

## Introduction
An **Undirected Graph** uses **bidirectional edges**, meaning relationships go **both ways**.

## Basic Structure
- Contains:
  - **Vertices**
  - **Edges** with no direction (u — v)
- `A — B` implies:
  - A is connected to B  
  - B is connected to A

### Example Representation
A — B — C  
|     \  
D ——— E

## Operations
| Operation | Description |
|----------|-------------|
| Add Vertex | Add a new node |
| Add Edge | Connect u — v |
| Remove Vertex | Remove node + edges |
| Remove Edge | Remove u — v |
| DFS / BFS | Explore graph |
| Connected Components | Identify isolated groups |
| Cycle Detection | Check for loops |

## How Searching Works (DFS/BFS)
1. Start at **any vertex**.  
2. Traverse via edges (u — v).  
3. Mark visited nodes.  
4. Continue until the component is fully explored.

> All edges are bidirectional.

## Properties
- **Degree** = number of edges attached to a node  
- Disconnected sets form **connected components**

## Time & Space Complexity
| Operation | Adjacency List | Adjacency Matrix |
|----------|-----------------|------------------|
| Add Vertex | O(1) | O(V²) |
| Add Edge | O(1) | O(1) |
| Search (DFS/BFS) | O(V + E) | O(V²) |
| Space | O(V + E) | O(V²) |

## Advantages
- Simple, natural modeling  
- Easy traversal  
- Good for symmetric relations  
- Efficient for sparse graphs  

## Disadvantages
- Cannot express direction  
- Matrix uses high memory  
- Not suitable for dependency-based structures  

## Applications
- **Social networks** (friendships)  
- **Computer networks**  
- **Biological networks**  
- **Geographical connections**  
- **Recommendation systems**