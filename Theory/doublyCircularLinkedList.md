# Doubly Circular Linked List (DCLL)

## Introduction
A **Doubly Circular Linked List** is similar to a **Doubly Linked List**, but the last node points back to the first node and the first node points to the last node. This means that you can traverse the list **forward and backward**, starting from any node, and eventually return to the same node. There are **no null pointers** at the boundaries.

## Basic Structure
Each node contains:
- **Data Field** → stores the data.
- **Next Pointer** → points to the next node.
- **Previous Pointer** → points to the previous node.

Head ⇄ [Prev | Data | Next] ⇄ [Prev | Data | Next] ⇄ ... ⇄ [Prev | Data | Next]

↑_______________________________________________________↓

## Operations
| Operation | Description |
|-----------|-------------|
| Insert at Beginning | Insert before head; update both `prev` and `next` pointers; last node’s next points to new node and new node’s prev points to last node |
| Delete at Beginning | Remove head; update new head’s prev to last; update last node’s next pointer |
| Insert at Ending | Insert after last node; new node’s next points to head; head’s prev points to new end node |
| Delete at Ending | Delete last node; second last node’s next points to head; head’s prev points to second last node |
| Insert After Data | Same as doubly linked list; handle edge case of inserting after last node |
| Delete After Data | Same as doubly linked list; handle edge case of deleting last node |
| Insert Before Data | Same as doubly linked list; handle edge case of inserting before head |
| Delete Before Data | Same as doubly linked list; handle edge case while deleting before head |
| Delete Data | Same as doubly linked list; handle deleting beginning or ending |
| Traverse Forward | Move from head using next pointers until reaching head again |
| Traverse Backward | Move from head.prev using prev pointers until reaching head again |
| Reverse Traverse | Start from tail (head.prev) and move backward node by node using prev pointers until reaching tail again |
| Is Empty | True if head is empty else false |
| getLength | Count nodes via traversal |
| Search | Search forward or backward |
| Reverse | Swap next and prev pointers for all nodes; update head pointer |

## Advantage
- Can traverse both forward and backward
- Useful for **navigation systems**, **playlist loops**, and **undo-redo** structures
- No null checks required during traversal
- More flexible than SCLL due to double linkage

## Disadvantage
- More memory required due to extra pointer
- More pointer adjustments needed during insertion and deletion
- Slightly more complex than Singly Circular Linked List

## Application
- Music/Video Playlist with forward-backward navigation  
- Undo/Redo Functionality 
- Browser History Management
- Circular Buffers
- Multi-directional Traversal** in games or simulations  
