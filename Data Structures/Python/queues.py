class Queue:
	def __init__(self):
		self.queue = []

	def enqueue(self, element):
		self.queue.append(element)

	def dequeue(self):
		if(self.isEmpty()):
			return "Queue is Empty"
		return self.queue.pop(0)

	def peek(self):
		if(self.isEmpty()):
			return "Queue is Empty"
		return self.queue[0]

	def isEmpty(self):
		return True if self.size() == 0 else False

	def size(self):
		return len(self.queue)

queue = Queue()
while(1):
	print("\n0. Exit\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Is Empty\n5. Size")
	option = int(input("\nOption: "))
	if option == 0:
		break
	match option:
		case 1:
			element = int(input("\nELEMENT: "))
			queue.enqueue(element)
		case 2:
			print(queue.dequeue())
		case 3:
			print(queue.peek())
		case 4:
			print(queue.isEmpty())
		case 5:
			print(queue.size())