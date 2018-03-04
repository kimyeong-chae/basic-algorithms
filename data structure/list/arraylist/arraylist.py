class ArrayList():

	def __init__(self) :
		self.array = []
		self.count = 0

	# data add
	def add(self, data) :
		self.array.append(data)
		self.count += 1

	# get data
	def get(self, index) :
		return self.array[index]

	# remove data
	def remove(self, index) :
		for _index in range(index, self.count - 1):
			self.array[_index] = self.array[_index + 1]

		del self.array[self.count - 1]
		self.count -= 1

	# get list size
	def size(self) :
		return self.count

	def pop(self) :
		returnData = self.array[self.count-1]
		self.remove(self.count-1)
		return returnData


# TEST
arraylist = ArrayList()

arraylist.add("12")
print arraylist.size()
arraylist.add(123)
print arraylist.size()
arraylist.add("123")
print arraylist.size()

print arraylist.pop()
print arraylist.size()

arraylist.add("456")
print arraylist.size()

arraylist.remove(1)
print arraylist.size()

print arraylist.get(1)
