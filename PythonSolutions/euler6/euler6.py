sumOfSquares = 0
for i in range(101):
    sumOfSquares += i ** 2

squareOfSum = 0
for j in range(101):
    squareOfSum += j
squareOfSum = squareOfSum ** 2

print(abs(squareOfSum - sumOfSquares))
