class Heap:
    def __init__(self):
        self.heap = []
    
    def insert(self, value):
        self.heap.append(value)
        index = self.getLength() - 1
        while index > 0 and self.heap[(index - 1) // 2] < value:
            self.heap[index], self.heap[(index - 1) // 2] = self.heap[(index - 1) // 2], self.heap[index]
            index  = (index - 1) // 2
        return "Inserted"
    
    def delete(self, value):
        index = -1
        for i in range(self.getLength()):
            if self.heap[i] == value:
                index = i
        if index == -1:
            return "Data not found"
        self.heap[index] = self.heap[-1]
        self.heap.pop()
        while 1:
            leftChild = (2 * index) + 1
            rightChild = (2 * index) + 2
            largest = index
            if leftChild < self.getLength() and self.heap[leftChild] > self.heap[largest]:
                largest = leftChild
            if rightChild < self.getLength() and self.heap[rightChild] > self.heap[largest]:
                largest = rightChild
            if index != largest:
                self.heap[index], self.heap[largest] = self.heap[largest], self.heap[index]
                index = largest
            else:
                break
        return "Deleted"
    
    def peek(self):
        return "Heap is Empty" if self.getLength() == 0 else self.heap[0]
    
    def traverse(self):
        for i in range(self.getLength()):
            print(self.heap[i], end = " ")

    def getLength(self):
        return len(self.heap)
    
heap = Heap()
while 1:
    print("\n0. Exit\n1. Insert\n2. Delete\n3. Peek\n4. Traverse\n5. Length")
    option = int(input("\nOption: "))
    if option == 0:
        break
    match option:
        case 1:
            value = int(input("Value: "))
            print(heap.insert(value))
        case 2:
            value = int(input("Value: "))
            print(heap.delete(value))
        case 3:
            print(heap.peek())
        case 4:
            heap.traverse()
        case 5:
            print(heap.getLength())
