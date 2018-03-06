class Node :
	def __init__(self, data, next) :
		self.data = data
		self.next = None

class LinkedList :
	def __init__(self):
		self.head = None
		self.tail = None
		self.size = 0

	# 첫번째 첫번째에 데이터 추가
	def addFirst(self, data):
		node = Node(data)

		node.next = self.head
		self.head = node

		self.size += 1

	# 마지막 인덱스에 데이터 추가
	def addLast(self, data):

		if self.size == 0:
			addFirst(data)
		else
			node = Node(data)

			self.tail.next = node
			self.tail = node

	# index에 데이터 추가
	def add(self, index, data):
		# index가 0일경우 addFirst 호출
		if index == 0 :
			self.addFirst(data)
		# index가 마지막 index일 경우 addLast호출
		else if index == size-1 :
			self.addLast(data)
		else :
			node = Node(data)

			beforeNode = self.getNode(index-1)
			nextNode = beforeNode.next

			beforeNode.next = node

			node.next = nextNode

			self.size += 1

	def getNode(self, index):
		if index == self.size-1 :
			return self.tail

		returnNode = self.head
		for _index in range(index)
			returnNode = returnNode.next

		return returnNode

	def removeFirst(self):
		self.head = self.head.next
		self.size -= 1

	def removeLast(self):
		self.tail = self.getNode(self.size-2).next
		self.size -= 1

	def remove(self, index):
		if index == 0 :
			self.removeFirst()
		else if index == self.size-1 :
			self.removeLast()
		else :
			beforeNode = self.getNode(index-1)
			beforeNode.next = beforeNode.next.next
