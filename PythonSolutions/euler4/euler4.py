def isPalin(num):
    if int(str(num)[::-1]) == num:
        return True
    return False

lastPalin = 0
for i in range(1000):
    for j in range(i, 1000):
        product = i * j
        if isPalin(product) and product > lastPalin:
            lastPalin = product
print(lastPalin)
