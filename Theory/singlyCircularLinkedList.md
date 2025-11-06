# Singly Circular Linked List (SCLL)

## Introduction
A **Singly Circular Linked List** is similar to that of **Singly Linked List** where the last node points back to the first node. This means that you can start traversing the list from any node and reach back to the same node. It has no null pointer at the end of the list, unlike singly linked list.

## Basic Structure
- **Data Field** -> stores the data.
- **Next Pointer** -> points to the next node.

Head → [Data | Next] → [Data | Next] → ... → [Data | Next]

↑___________________________________________|

## Operations
| Operation | Description |
|------------|------------|
| Insert at Beginning | Insert the data before head; Last node's next pointer points to the data |
| Deleta at Beginning | Delete head; Head points to next data; Last node's next pointer points to new head |
| Insert at Ending | Insert the data at end; Data's next pointer points to head |
| Delete at Ending | Delete the end node; Previous node's next pointer points to head |
| Insert After Data | Same as Singly Linked List; handle edge case while inserting at ending |
| Delete After Data | Same as Singly Linked List; handle edge case while deleting at ending |
| Insert Before Data | Same as Singly Linked List; handle edge case while inserting at beginning |
| Delete Before Data | Same as Singly Linked List; handle edge case while deleting at beginning |
| Delete Data | Same as Singly Linked List; handle edge case while deleting at beginning and ending |
| Traverse | Start from head and keep moving to next until reaching head again |
| Is Empty | True if head is empty else false |
| getLength | Returns the length of the Linked List by traversing |
| Search | Find data by traversing |
| Reverse | Traverse through the Linked List; make the next pointer to point the data previous to it |

## Advantage
- Can traverse the entire list from any point
- usefull for **round robin**, **buffer management** and **music playlist**
- no need for null checks

## Disadvantage
- Can lead to infinte loops if condition is not set properly during traversal
- extra updation during insertion and deletion
- complicated than **Singly Linked List**

## Application
- Circular Queue
- Round Robin CPU scheduling
- Multiplayer Game
- Circular Playlist
