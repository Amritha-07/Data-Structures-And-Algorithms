class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
    
class HashTable:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.table = [None] * capacity
    
    def _hash(self, value):
        return hash(value) % self.capacity
    
    def insert(self, value):
        index = self._hash(value)
        if self.table[index] == None:
            self.table[index] = Node(value)
            self.size += 1
            return "Inserted"
        curr = self.table[index]
        while curr.next != None:
            curr = curr.next
        newNode = Node(value)
        curr.next = newNode
        return "Inserted"
    
    def delete(self, value):
        index = self._hash(value)
        curr = self.table[index]
        prev = None
        while curr != None:
            if curr.value == value:
                if prev == None:
                    self.table[index] = curr.next
                    return "Deleted"
                prev.next = curr.next
                return "Deleted"
            prev = curr
            curr = curr.next
        return "Data not found"
    
    def search(self, value):
        index = self._hash(value)
        curr = self.table[index]
        while curr != None:
            if curr.value == value:
                return curr.value
        return "Data not found"
    
    def traverse(self):
        for i in range(capacity):
            curr = self.table[i]
            if curr == None:
                print("__")
                continue
            while curr.next != None:
                print(curr.value, " -> ", end = "")
                curr = curr.next
            print(curr.value)

capacity = int(input("Enter capacity of Hash table: "))
hashTable = HashTable(capacity)
while 1:
    print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traverse")
    option = int(input("\nOption: "))
    if option == 0:
        break
    match option:
        case 1:
            value = int(input("Value: "))
            print(hashTable.insert(value))
        case 2:
            value = int(input("Value: "))
            print(hashTable.delete(value))
        case 3:
            value = int(input("Value: "))
            print(hashTable.search(value))
        case 4:
            hashTable.traverse()