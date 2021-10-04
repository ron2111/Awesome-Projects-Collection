
class check:
	def _init_ (self):
		self.ans = 0
		self.eve = []
		self.odd = []
	def odd_even(self,n):
		if(n%2==0):
			self.ans = n
			self.eve.append(n)
			print(self.ans)
		else:
			self.ans = n
			self.odd.append(n)
			print(self.ans)
	def print_list(self):
		print("Odd List ",self.odd)
		print("Even List ",self.eve)

	def num(self):
		len1 = len(self.eve)
		len2 = len(self.odd)
		print("Even Number is ",len1)
		print("Odd Number is ",len2)


ob1 = check()
ob1.odd_even(22)
ob1.odd_even(11)
ob1.odd_even(45)
ob1.odd_even(33)

ob1.print_list()
ob1.num()