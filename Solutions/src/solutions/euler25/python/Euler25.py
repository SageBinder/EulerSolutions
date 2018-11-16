x = 1
y = 1
r = x + y
i = 2
while len(str(r)) < 1000:
    r = x + y
    x = y
    y = r
    i += 1

print(i)
print(r)
