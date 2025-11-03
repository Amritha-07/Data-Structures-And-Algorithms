class Node:
	def __init__(self, element):
		self.data = element
		self.next = None


class SinglyLinkedList:
	def __init__(self):
		self.head = None

	def insertAtBeginning(self, element):
		newNode = Node(element)
		newNode.next = self.head
		self.head = newNode
		return "Inserted"

	def deleteAtBeginning(self):
		if self.head == None:
			return "Linked List is Empty"
		self.head = self.head.next;
		return "Deleted"

	def insertAtEnding(self, element):
		newNode = Node(element)
		if self.head == None:
			self.head = newNode
			return "Inserted"
		curr = self.head
		while curr.next != None:
			curr = curr.next
		curr.next = newNode
		return "Inserted"

	def deleteAtEnding(self):
		if self.head == None:
			return "Linked List is Empty"
		if self.head.next == None:
			self.head = None
			return "Deleted"
		curr = self.head
		while curr.next.next != None:
			curr = curr.next
		curr.next = None
		return "Deleted"

	def insertAfterData(self, data, element):
		if self.head == None:
			return "Linked List is Empty"
		newNode = Node(element)
		curr = self.head
		while curr:
			if curr.data == data:
				newNode.next = curr.next
				curr.next = newNode
				return "Inserted"
			curr = curr.next
		return "Data not found"

	def deleteAfterData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		curr = self.head
		while curr:
			if curr.data == data:
				if curr.next == None:
					return "No element after this data"
				curr.next = curr.next.next
				return "Deleted"
			curr = curr.next
		return "Data not found"

	def insertBeforeData(self, data, element):
		if self.head == None:
			return "Linked List is Empty"
		newNode = Node(element)
		curr = self.head
		if curr.data == data:
			newNode.next = self.head
			self.head = newNode
			return "Inserted"
		while curr.next != None:
			if curr.next.data == data:
				newNode.next = curr.next
				curr.next = newNode
				return "Inserted"
			curr = curr.next
		return "Data not found"

	def deleteBeforeData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		if self.head.data == data:
			return "No element before this data"
		prev = None
		curr = self.head
		while curr.next != None:
			if curr.next.data == data:
				if prev == None:
					self.head = curr.next
					return "Deleted"
				prev.next = curr.next
				return "Deleted"
			prev = curr
			curr = curr.next
		return "Data not found"

	def deleteData(self, data):
		if self.head == None:
			return "Linked List is Empty"
		if self.head.data == data:
			self.head = self.head.next
			return "Deleted"
		curr = self.head
		while curr.next != None:
			if curr.next.data == data:
				curr.next = curr.next.next
				return "Deleted"
			curr = curr.next
		return "Data not found"
		
	def traverse(self):
		print("Traverse: ", end = "")
		if self.head == None:
			print("Linked List is Empty")
			return
		curr = self.head
		while curr:
			print(curr.data, end = " ")
			curr = curr.next
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
		if self.head.next == None:
			return "Reversed"
		curr = self.head
		prev = None
		nex = self.head.next
		while curr:
			nex = curr.next
			curr.next = prev
			prev = curr
			curr = nex
		self.head = prev
		return "Reversed"

linkedList = SinglyLinkedList()
while 1:
	print("\n0. Exit\n1. Insert at Beginning\n2. Delete at Beginning\n3. Insert at Ending\n4. Delete at Ending\n5. Insert after Data\n6. Delete after Data\n7. Insert before Data\n8. Delete before Data\n9. Delete Data\n10. Traverse\n11. Is Empty\n12. Length\n13. Search\n14. Reverse")
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
			print(linkedList.isEmpty())
		case 12:
			print(linkedList.getLength())
		case 13:
			data = int(input("\nData: "))
			print(linkedList.search(data))
		case 14:
			print(linkedList.reverse())
			linkedList.traverse()
