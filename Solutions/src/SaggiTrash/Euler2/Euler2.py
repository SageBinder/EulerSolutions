fib = 1
last = fib
temp = 0
fibsum = 0
while fib < 4000000:
    temp = fib
    fib = fib + last
    last = temp
    if fib % 2 == 0:
        fibsum = fibsum + fib

print(fibsum)
