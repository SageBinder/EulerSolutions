numsum = 0

for i in range(1000):
    if i % 5 == 0 or i % 3 == 0:
        numsum = numsum + i

print(numsum)
