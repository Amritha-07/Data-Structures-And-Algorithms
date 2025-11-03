class Node:
	def __init__(self, element):
		self.data = element
		self.previous = None
		self.next = None

class DoublyLinkedList:
	def __init__(self):
		self.head = None
		self.tail = None

	def insertAtBeginning(self, element):
		newNode = Node(element)
		if self.head == None :
			self.head = newNode
			self.tail = newNode
			return "Inserted"
		newNode.next = self.head
		self.head.previous = newNode
		self.head = newNode
		return "Inserted"

	def deleteAtBeginning(self):
		if self.head == None:
			return "Linked List is Empty"
		if self.head != None and self.head.next == None:
			self.head = None
			self.tail = None
			return "Deleted"
		self.head = self.head.next
		self.head.previous = None
		return "Deleted"

	def insertAtEnding(self, element):
		newNode = Node(element)
		if self.head == None:
			self.head = newNode
			self.tail = newNode
			return "Inserted"
		newNode.previous = self.tail
		self.tail.next = newNode
		self.tail = newNode
		return "Inserted"

	def deleteAtEnding(self):
		if self.head == None:
			return "Linked List is Empty"
		if self.head != None and self.head.next == None:
			self.head = None
			self.tail = None
			return "Deleted"
		self.tail = self.tail.previous
		self.tail.next = None
		return "Deleted"

	def insertAfterData(self, data, element):
		if self.head == None:
			return "Linked List is Empty"
		newNode = Node(element)
		curr = self.head
		while curr:
			if curr.data == data:
				newNode.next = curr.next
				newNode.previous = curr
				if curr.next != None:
					curr.next.previous = newNode
				else:
					self.tail = newNode
				curr.next = newNode
				return "Inserted"
			curr = curr.next
		return "Data no found"
	
	def deleteAfterData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		curr = self.head
		while curr.next != None:
			if curr.data == data:
				if curr.next.next != None:
					curr.next.next.previous = curr
				else:
					self.tail = curr
				curr.next = curr.next.next
				return "Deleted"
			curr = curr.next
		if curr.data == data:
			return "No element after this data"
		return "Data not found"
	
	def insertBeforeData(self, data, element):
		if self.head == None:
			return "Linked List is Empty"
		newNode = Node(element)
		curr = self.head
		if curr.data == data:
			newNode.next = curr
			curr.previous = newNode
			self.head = newNode
			return "Inserted"
		while curr.next != None:
			if curr.next.data == data:
				newNode.next = curr.next
				curr.next.previous = newNode
				newNode.previous = curr
				curr.next = newNode
				return "Inserted"
			curr = curr.next
		return "Data not found"
	
	def deleteBeforeData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		if self.head.data == data:
			return "No element before this data"
		curr = self.head
		while curr.next != None:
			if curr.next.data == data:
				if curr.previous == None:
					self.head = curr.next
				else:
					curr.previous.next = curr.next
				curr.next.previous = curr.previous
				return "Deleted"
			curr = curr.next
		return "Data not found"
	
	def deleteData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		if self.head == self.tail and self.head.data == data:
			self.head = None
			self.tail = None
			return "Deleted"
		curr = self.head
		while curr:
			if curr.data == data:
				if curr.previous == None:
					curr.next.previous = None
					self.head = curr.next
					return "Deleted"
				curr.previous.next = curr.next
				if curr.next != None:
					curr.next.previous = curr.previous
				else:
					self.tail = curr.previous
				return "Deleted"
			curr = curr.next
		return "Data not found"

	def traverse(self):
		if self.head == None:
			print("Linked List is Empty")
			return
		curr = self.head
		while curr:
			print(curr.data, end = " ")
			curr = curr.next
		print("\n")

	def reverseTraverse(self):
		if self.head == None:
			print("Linked List is Empty")
			return
		curr = self.tail
		while curr:
			print(curr.data, end = " ")
			curr = curr.previous
		print("\n")
	
	def isEmpty(self):
		return True if self.head == None else False
	
	def getLength(self):
		i = 0
		curr = self.head
		while curr:
			i += 1
			curr = curr.next
		return i
	
	def search(self, data):
		if self.head == None:
			return "Linked List is Empty"
		curr = self.head
		while curr:
			if curr.data == data:
				return data
			curr = curr.next
		return "Data not found"
	
	def reverse(self):
		if self.head == None:
			return "Linked List is Empty"
		if self.head != None and self.head.next == None:
			return "Reversed"
		prev = None
		curr = self.head
		while curr:
			nsx = curr.next
			curr.next = prev
			curr.previous = nsx
			prev = curr
			curr = nsx
		self.tail = self.head
		self.head = prev
		return "Reversed"

linkedList = DoublyLinkedList()
while 1:
	print("\n0. Exit\n1. Insert at Beginning\n2. Delete at Beginning\n3. Insert at Ending\n4. Delete at Ending\n5. Insert after Data\n6. Delete after Data\n7. Insert before Data\n8. Delete before Data\n9. Delete Data\n10. Traverse\n11. Reverse Traverse\n12. Is Empty\n13. Length\n14. Search\n15. Reverse")
	option = int(input("\nOption: "))
	if option == 0:
		break
	match option:
		case 1:
			element = int(input("\nElement: "))
			print(linkedList.insertAtBeginning(element))
			linkedList.traverse()
		case 2:
			print(linkedList.deleteAtBeginning())
			linkedList.traverse()
		case 3:
			element = int(input("\nElement: "))
			print(linkedList.insertAtEnding(element))
			linkedList.traverse()
		case 4:
			print(linkedList.deleteAtEnding())
			linkedList.traverse()
		case 5:
			element = int(input("\nElement: "))
			data = int(input("\nData: "))
			print(linkedList.insertAfterData(data, element))
			linkedList.traverse()
		case 6:
			data = int(input("\nData: "))
			print(linkedList.deleteAfterData(data))
			linkedList.traverse()
		case 7:
			element = int(input("\nElement: "))
			data = int(input("\nData: "))
			print(linkedList.insertBeforeData(data, element))
			linkedList.traverse()
		case 8:
			data = int(input("\nData: "))
			print(linkedList.deleteBeforeData(data))
			linkedList.traverse()
		case 9:
			data = int(input("\nData: "))
			print(linkedList.deleteData(data))
			linkedList.traverse()
		case 10:
			linkedList.traverse()
		case 11:
			linkedList.reverseTraverse()
		case 12:
			print(linkedList.isEmpty())
		case 13:
			print(linkedList.getLength())
		case 14:
			data = int(input("\nData: "))
			print(linkedList.search(data))
		case 15:
			print(linkedList.reverse())
			linkedList.traverse()
